package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 12/04/2017.
 */

public class ActivityThemTaiKhoan extends Activity {

    EditText edtTen_tai_khoan;
    TextView txtLoai_tai_khoan, txtSo_tien_ban_dau;
    ImageView imgLoai_tai_khoan, imgD;
    Button btnLuu;

    Intent intent;
    Bundle bundle= new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_them_tai_khoan);

        edtTen_tai_khoan= (EditText)findViewById(R.id.edtTen_them_tai_khoan);
        txtSo_tien_ban_dau= (TextView)findViewById(R.id.txtSo_tien_ban_dau);
        txtLoai_tai_khoan=(TextView)findViewById(R.id.txtLoai_tai_khoan);
        imgLoai_tai_khoan=(ImageView) findViewById(R.id.imgLoai_tai_khoan);
        imgD= (ImageView) findViewById(R.id.imgD);
        btnLuu=(Button) findViewById(R.id.btnLuu_them_tai_khoan);

        txtSo_tien_ban_dau.setOnClickListener(new EvenCalculator());
    }

    private class EvenCalculator implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityThemTaiKhoan.this, ActivityCalculator.class);
            startActivityForResult(intent, 11);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if(requestCode== 11 && resultCode== 11) {
                bundle= data.getExtras();
                txtSo_tien_ban_dau.setText(String.valueOf(bundle.getDouble("keyCalculator")));
            }
        }
        catch (Exception ex)
        {
            ex.getMessage();
        }
    }
}
