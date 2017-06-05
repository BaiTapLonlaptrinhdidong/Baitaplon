package com.example.user.myapplication.Activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.DTO.DanhSachThu;
import com.example.user.myapplication.DTO.TaiKhoan;
import com.example.user.myapplication.Modify.DanhSachThuModify;
import com.example.user.myapplication.Modify.TaiKhoanModify;
import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.R;

import br.com.bloder.magic.view.MagicButton;

/**
 * Created by user on 09/04/2017.
 */

public class ActivityThuTien extends Activity {

    private Button btnDiengiai, btnTuTaiKhoan, btnSukien, btnBack;
    private MagicButton btnMagic;
    private TextView txtDiengiai, txtSukien, txtDate, txtSotienthu, txtVaoTaiKhoan;
    private ImageButton imgBtnLuu;

    private Intent intent;
    private Bundle bundle= new Bundle();
    private java.util.Calendar calendar;
    private int month, year, day;
    private int ID;
    private double Money;
    private byte[] Img;
    private TaiKhoanModify taiKhoanModify;
    private DanhSachThuModify danhSachThuModify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_thu_tien);

        txtDiengiai=(TextView) findViewById(R.id.txtDien_giai_thu_tien);
        txtSukien=(TextView) findViewById(R.id.txtSu_kien_thu_tien);
        txtDate=(TextView) findViewById(R.id.txtNgay_thu_tien);
        txtSotienthu=(TextView) findViewById(R.id.txtSo_tien_thu);
        txtVaoTaiKhoan= (TextView) findViewById(R.id.txtTu_tai_khoan_thu_tien);

        btnDiengiai=(Button) findViewById(R.id.btnDien_giai_thu_tien);
        btnSukien=(Button) findViewById(R.id.btnSu_kien_thu_tien);
        btnTuTaiKhoan=(Button) findViewById(R.id.btnTu_tai_khoan_thu_tien);
        btnMagic=(MagicButton) findViewById(R.id.btnMagic_thu_tien);
        btnBack= (Button) findViewById(R.id.btnBack_thu_tien);

        imgBtnLuu= (ImageButton) findViewById(R.id.imgBtn_Luu_thu_tien);

        taiKhoanModify= new TaiKhoanModify(this);
        danhSachThuModify= new DanhSachThuModify(this);
        calendar= java.util.Calendar.getInstance();
        day= calendar.get(java.util.Calendar.DAY_OF_MONTH);
        month= calendar.get(java.util.Calendar.MONTH);
        year= calendar.get(java.util.Calendar.YEAR);
        String strDate= String.valueOf(day)+ "/ " +String.valueOf(month + 1) +"/ "+ String.valueOf(year);
        txtDate.setText(strDate);

        btnDiengiai.setOnClickListener(new EventDienGiai());
        btnSukien.setOnClickListener(new EventSuKien());
        btnMagic.setMagicButtonClickListener(new EventNgay());
        btnTuTaiKhoan.setOnClickListener(new EventTaiKhoan());
        btnBack.setOnClickListener(new EventBack());
        txtSotienthu.setOnClickListener(new EventSoTienThu());
        imgBtnLuu.setOnClickListener(new EventLuu());
    }

    private class EventSoTienThu implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityThuTien.this, ActivityCalculator.class);
            startActivityForResult(intent, MainActivity.SO_TIEN_THU);
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
                    txtDate.setText(day + "/ " + (month +1) + "/ " + year);
                }
            };
            DatePickerDialog dateDialog= new DatePickerDialog(ActivityThuTien.this, calldateDialog, year, month, day);
            dateDialog.show();
        }
    }

    private class EventDienGiai implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityThuTien.this, ActivityDienGiai.class);
            startActivityForResult(intent, MainActivity.DIEN_GIAI_THU);
        }
    }

    private class EventSuKien implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityThuTien.this, ActivitySuKien.class);
            startActivityForResult(intent, MainActivity.SU_KIEN_THU);
        }
    }

    private class EventTaiKhoan implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityThuTien.this, AcitivityChonTaiKhoan.class);
            startActivityForResult(intent, MainActivity.VAO_TAI_KHOAN);
        }
    }

    private class EventBack implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            finish();
        }
    }

    private class EventLuu implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(txtVaoTaiKhoan.getText().toString()== "")
            {
                Toast.makeText(ActivityThuTien.this, "Bạn phải chọn tài khoản", Toast.LENGTH_SHORT).show();
            }
            else {
                double moneyUpdate = Money + Double.parseDouble(txtSotienthu.getText().toString());
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setmMoney(String.valueOf(moneyUpdate));
                taiKhoan.setmId(ID);
                taiKhoanModify.upDateMoney(taiKhoan);
                DanhSachThu danhsachthu = new DanhSachThu(txtSotienthu.getText().toString(), txtDiengiai.getText().toString(), Img, txtSukien.getText().toString(), txtDate.getText().toString(), String.valueOf(month+ 1), String.valueOf(year));
                danhSachThuModify.insertDanhSachThu(danhsachthu);
                finish();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if(requestCode== MainActivity.DIEN_GIAI_THU && resultCode== MainActivity.DIEN_GIAI) {

                bundle = data.getExtras();
                txtDiengiai.setText(bundle.getString("keyDienGiai").toString());
            }

            if(requestCode== MainActivity.SU_KIEN_THU && resultCode== MainActivity.SU_KIEN) {

                bundle = data.getExtras();
                txtSukien.setText(bundle.getString("keySuKien").toString());
            }

            if(requestCode== MainActivity.SO_TIEN_THU&& resultCode== MainActivity.CALCULATOR)
            {
                bundle= data.getExtras();
                txtSotienthu.setText(String.valueOf(bundle.getDouble("keyCalculator")));
            }
            if(requestCode== MainActivity.VAO_TAI_KHOAN && resultCode== MainActivity.CHON_TAI_KHOAN)
            {
                bundle= data.getExtras();
                txtVaoTaiKhoan.setText(bundle.getString("keyNameTaiKhoan"));
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
}
