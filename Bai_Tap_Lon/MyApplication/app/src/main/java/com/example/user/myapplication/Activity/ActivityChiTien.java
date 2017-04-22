package com.example.user.myapplication.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.R;

import java.util.Date;

import br.com.bloder.magic.view.MagicButton;

/**
 * Created by user on 09/04/2017.
 */

public class ActivityChiTien extends AppCompatActivity {

    Button btnMucchi, btnDiengiai, btnTuTaiKhoan, btnSukien;
    MagicButton btnMagic;
    TextView txtDiengiai, txtSukien, txtMucChi, txtDate, txtSotienchi;

    Intent intent;
    Bundle bundle= new Bundle();
    java.util.Calendar calendar;
    Date date;
    int month, year, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chi_tien);

        txtDiengiai=(TextView) findViewById(R.id.txtDien_giai);
        txtSukien=(TextView) findViewById(R.id.txtSu_kien);
        txtMucChi=(TextView) findViewById(R.id.txtMuc_chi);
        txtDate=(TextView) findViewById(R.id.txtNgay);
        txtSotienchi=(TextView) findViewById(R.id.txtSo_tien_chi);

        btnMucchi=(Button) findViewById(R.id.btnMuc_chi);
        btnDiengiai=(Button) findViewById(R.id.btnDien_giai);
        btnSukien=(Button) findViewById(R.id.btnSu_kien);
        btnTuTaiKhoan=(Button) findViewById(R.id.btnTu_tai_khoan);
        btnMagic=(MagicButton) findViewById(R.id.btnMagic);

        calendar= java.util.Calendar.getInstance();
        day= calendar.get(java.util.Calendar.DAY_OF_MONTH);
        month= calendar.get(java.util.Calendar.MONTH);
        year= calendar.get(java.util.Calendar.YEAR);
        String strDate= String.valueOf(day)+ " / " +String.valueOf(month + 1) +" / "+ String.valueOf(year);
        txtDate.setText(strDate);

        btnDiengiai.setOnClickListener(new EventDienGiai());
        btnSukien.setOnClickListener(new EventSuKien());
        btnMucchi.setOnClickListener(new EventMucChi());
        btnMagic.setMagicButtonClickListener(new EventNgay());
        txtSotienchi.setOnClickListener(new EventSoTienChi());
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
                txtDiengiai.setText(bundle.getString("keyDienGiai").toString());
            }
            if(requestCode== MainActivity.SU_KIEN && resultCode== MainActivity.SU_KIEN) {

                bundle = data.getExtras();
                txtSukien.setText(bundle.getString("keySuKien").toString());
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
                    txtDate.setText(day + "/" + (month + 1) + "/" + year);
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
}
