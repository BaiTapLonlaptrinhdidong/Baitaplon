package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 09/04/2017.
 */

public class ActivityChiTien extends Activity {

    EditText edtChitien;
    Button btnMucchi, btnDiengiai, btnTuTaiKhoan, btnSukien;
    TextView txtDiengiai;

    Intent intent;
    Bundle bundle= new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chi_tien);

        edtChitien=(EditText) findViewById(R.id.editSo_tien_chi);
        txtDiengiai=(TextView) findViewById(R.id.txtDien_giai);

        btnMucchi=(Button) findViewById(R.id.btnMuc_chi);
        btnDiengiai=(Button) findViewById(R.id.btnDien_giai);
        btnSukien=(Button) findViewById(R.id.btnSu_kien);
        btnTuTaiKhoan=(Button) findViewById(R.id.btnTu_tai_khoan);

        btnDiengiai.setOnClickListener(new EventDienGiai());
    }


    private class EventDienGiai implements AdapterView.OnClickListener
    {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityChiTien.this, ActivityDienGiai.class);
            startActivityForResult(intent, 3);
        }
    }
}
