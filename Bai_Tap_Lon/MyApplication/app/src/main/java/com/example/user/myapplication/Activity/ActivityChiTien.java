package com.example.user.myapplication.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.DTO.DanhSach;
import com.example.user.myapplication.DTO.TaiKhoan;
import com.example.user.myapplication.Modify.DanhSachModify;
import com.example.user.myapplication.Modify.TaiKhoanModify;
import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.R;

import br.com.bloder.magic.view.MagicButton;

/**
 * Created by user on 09/04/2017.
 */

public class ActivityChiTien extends AppCompatActivity {

    private Button btnMucchi, btnDiengiai, btnTuTaiKhoan, btnSukien, btnBack;
    private MagicButton btnMagic;
    private TextView txtDiengiai, txtSukien, txtMucChi, txtDate, txtSotienchi, txtTuTaiKhoan;
    private ImageButton imgBtn_luu_chi;

    private Intent intent;
    private Bundle bundle= new Bundle();
    private java.util.Calendar calendar;
    private TaiKhoanModify taiKhoanModify;
    private DanhSachModify danhSachModify;
    private int month, year, day;
    private double Money;
    private int ID;
    private byte[] Img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chi_tien);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        txtDiengiai=(TextView) findViewById(R.id.txtDien_giai);
        txtSukien=(TextView) findViewById(R.id.txtSu_kien);
        txtMucChi=(TextView) findViewById(R.id.txtMuc_chi);
        txtDate=(TextView) findViewById(R.id.txtNgay);
        txtSotienchi=(TextView) findViewById(R.id.txtSo_tien_chi);
        txtTuTaiKhoan= (TextView) findViewById(R.id.txtTu_tai_khoan);

        btnMucchi=(Button) findViewById(R.id.btnMuc_chi);
        btnDiengiai=(Button) findViewById(R.id.btnDien_giai);
        btnSukien=(Button) findViewById(R.id.btnSu_kien);
        btnTuTaiKhoan=(Button) findViewById(R.id.btnTu_tai_khoan);
        btnMagic=(MagicButton) findViewById(R.id.btnMagic);
        btnTuTaiKhoan=(Button) findViewById(R.id.btnTu_tai_khoan);
        btnBack= (Button) findViewById(R.id.btnBack_chi_tien);

        imgBtn_luu_chi= (ImageButton) findViewById(R.id.imgBtn_Lưu_chi);
        calendar= java.util.Calendar.getInstance();
        day= calendar.get(java.util.Calendar.DAY_OF_MONTH);
        month= calendar.get(java.util.Calendar.MONTH);
        year= calendar.get(java.util.Calendar.YEAR);
        String strDate= String.valueOf(day)+ "/ " +String.valueOf(month + 1) +"/ "+ String.valueOf(year);
        txtDate.setText(strDate);

        taiKhoanModify= new TaiKhoanModify(this);
        danhSachModify= new DanhSachModify(this);

        btnDiengiai.setOnClickListener(new EventDienGiai());
        btnSukien.setOnClickListener(new EventSuKien());
        btnMucchi.setOnClickListener(new EventMucChi());
        btnMagic.setMagicButtonClickListener(new EventNgay());
        btnTuTaiKhoan.setOnClickListener(new EvenTuTaiKhoan());
        btnBack.setOnClickListener(new EventBack());
        txtSotienchi.setOnClickListener(new EventSoTienChi());
        imgBtn_luu_chi.setOnClickListener(new EventLuu());
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private class EventDienGiai implements AdapterView.OnClickListener
    {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityChiTien.this, ActivityDienGiai.class);
            startActivityForResult(intent, MainActivity.DIEN_GIAI);
        }
    }

    private class EventSuKien implements AdapterView.OnClickListener
    {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityChiTien.this, ActivitySuKien.class);
            startActivityForResult(intent, MainActivity.SU_KIEN);
        }
    }

    private class EventMucChi implements AdapterView.OnClickListener
    {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityChiTien.this, ActivityHangMucChi.class);
            startActivityForResult(intent, MainActivity.HANG_MUC_CHI);
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if(requestCode== MainActivity.DIEN_GIAI && resultCode== MainActivity.DIEN_GIAI) {

                bundle = data.getExtras();
                txtDiengiai.setText(bundle.getString("keyDienGiai"));
            }
            if(requestCode== MainActivity.SU_KIEN && resultCode== MainActivity.SU_KIEN) {

                bundle = data.getExtras();
                txtSukien.setText(bundle.getString("keySuKien"));
            }

            if(requestCode== MainActivity.HANG_MUC_CHI && resultCode== MainActivity.HANG_MUC_CHI) {

                bundle= data.getExtras();
                txtMucChi.setText(bundle.getString("keyHangMucChi"));
            }
            if(requestCode== MainActivity.SO_TIEN_CHI&& resultCode== MainActivity.CALCULATOR)
            {
                bundle= data.getExtras();
                txtSotienchi.setText(String.valueOf(bundle.getDouble("keyCalculator")));
            }
            if(requestCode== MainActivity.CHON_TAI_KHOAN && resultCode== MainActivity.CHON_TAI_KHOAN)
            {
                bundle= data.getExtras();
                txtTuTaiKhoan.setText(bundle.getString("keyNameTaiKhoan"));
                Money= Double.parseDouble(bundle.getString("keyMoneyTaiKhoan"));
                ID= bundle.getInt("keyID");
                Img= bundle.getByteArray("keyImg");
            }

        }
        catch (Exception ex)
        {
            ex.getMessage();
        }

    }

    private class EventNgay implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            DatePickerDialog.OnDateSetListener calldateDialog= new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int y, int m, int d) {
                    day= Integer.valueOf(d);
                    month= Integer.valueOf(m);
                    year= Integer.valueOf(y);
                    txtDate.setText(day + "/ " + (month + 1) + "/ " + year);
                }
            };
            DatePickerDialog dateDialog= new DatePickerDialog(ActivityChiTien.this, calldateDialog, year, month, day);
            dateDialog.show();
        }
    }

    public class EventSoTienChi implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityChiTien.this, ActivityCalculator.class);
            startActivityForResult(intent, MainActivity.SO_TIEN_CHI);
        }
    }

    private class EvenTuTaiKhoan implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityChiTien.this, AcitivityChonTaiKhoan.class);
            startActivityForResult(intent, MainActivity.CHON_TAI_KHOAN);
        }
    }

    private class EventLuu implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(txtTuTaiKhoan.getText().toString()== "")
            {
                Toast.makeText(ActivityChiTien.this, "Bạn phải chọn tài khoản", Toast.LENGTH_SHORT).show();
            }
            else {
                double moneyUpdate = Money - Double.parseDouble(txtSotienchi.getText().toString());
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setmMoney(String.valueOf(moneyUpdate));
                taiKhoan.setmId(ID);
                taiKhoanModify.upDateMoney(taiKhoan);
                DanhSach danhsach = new DanhSach(txtSotienchi.getText().toString(), txtMucChi.getText().toString(), txtDiengiai.getText().toString(), txtSukien.getText().toString(), Img, txtDate.getText().toString());
                danhSachModify.insertDanhSach(danhsach);
                finish();
            }
        }
    }

    private class EventBack implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            finish();
        }
    }
}
