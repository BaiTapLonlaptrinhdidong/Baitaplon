package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 09/04/2017.
 */

public class ActivityChiTien extends AppCompatActivity {

    EditText edtChitien;
    Button btnMucchi, btnDiengiai, btnTuTaiKhoan, btnSukien;
    TextView txtDiengiai, txtSukien, txtMucChi;

    Intent intent;
    Bundle bundle= new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chi_tien);

        edtChitien=(EditText) findViewById(R.id.editSo_tien_chi);

        txtDiengiai=(TextView) findViewById(R.id.txtDien_giai);
        txtSukien=(TextView) findViewById(R.id.txtSu_kien);
        txtMucChi=(TextView) findViewById(R.id.txtMuc_chi);

        btnMucchi=(Button) findViewById(R.id.btnMuc_chi);
        btnDiengiai=(Button) findViewById(R.id.btnDien_giai);
        btnSukien=(Button) findViewById(R.id.btnSu_kien);
        btnTuTaiKhoan=(Button) findViewById(R.id.btnTu_tai_khoan);

        btnDiengiai.setOnClickListener(new EventDienGiai());
        btnSukien.setOnClickListener(new EventSuKien());
        btnMucchi.setOnClickListener(new EventMucChi());
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
}
