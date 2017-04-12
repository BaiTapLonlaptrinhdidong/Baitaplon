package com.example.user.myapplication;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.util.Locale;

import br.com.bloder.magic.view.MagicButton;

/**
 * Created by user on 09/04/2017.
 */

public class ActivityChiTien extends AppCompatActivity {

    EditText edtChitien;
    Button btnMucchi, btnDiengiai, btnTuTaiKhoan, btnSukien;
    MagicButton btnMagic;
    TextView txtDiengiai, txtSukien, txtMucChi, txtDate;

    Intent intent;
    Bundle bundle= new Bundle();
    java.util.Calendar calendar;
    Date date;
    int month, year, day;
    String strDay, strMonth, strYear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chi_tien);

        edtChitien=(EditText) findViewById(R.id.editSo_tien_chi);

        txtDiengiai=(TextView) findViewById(R.id.txtDien_giai);
        txtSukien=(TextView) findViewById(R.id.txtSu_kien);
        txtMucChi=(TextView) findViewById(R.id.txtMuc_chi);
        txtDate=(TextView) findViewById(R.id.txtNgay);

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
    }

    private class EventDienGiai implements AdapterView.OnClickListener
    {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityChiTien.this, ActivityDienGiai.class);
            startActivityForResult(intent, 3);
        }
    }

    private class EventSuKien implements AdapterView.OnClickListener
    {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityChiTien.this, ActivitySuKien.class);
            startActivityForResult(intent, 5);
        }
    }

    private class EventMucChi implements AdapterView.OnClickListener
    {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityChiTien.this, ActivityHangMucChi.class);
            startActivityForResult(intent, 1);
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if(requestCode== 3 && resultCode== 3) {

                bundle = data.getExtras();
                txtDiengiai.setText(bundle.getString("keyDienGiai").toString());
            }
            if(requestCode== 5 && resultCode== 5) {

                bundle = data.getExtras();
                txtSukien.setText(bundle.getString("keySuKien").toString());
            }

            if(requestCode== 1 && resultCode== 1) {

                bundle= data.getExtras();
                txtMucChi.setText(bundle.getString("keyHangMucChi"));
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
                    txtDate.setText(day + "/" + (month +1) + "/" + year);
                }
            };
            DatePickerDialog dateDialog= new DatePickerDialog(ActivityChiTien.this, calldateDialog, year, month, day);
            dateDialog.show();
        }
    }
}
