package com.example.user.myapplication.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.R;

/**
 * Created by user on 04/06/2017.
 */

public class ActivityHangMucKhac extends Activity {
    Button btnHuy, btnXong;
    EditText edtTenDanhMuc;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hang_muc_chi_new);

        btnHuy= (Button) findViewById(R.id.btnHuy_hang_muc_khac);
        btnXong= (Button) findViewById(R.id.btnXong_hang_muc_khac);
        edtTenDanhMuc= (EditText) findViewById(R.id.edtHang_muc_khac);

        btnHuy.setOnClickListener(new EventHuy());
        btnXong.setOnClickListener(new EventXong());
    }

    private class EventHuy implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            finish();
        }
    }

    private class EventXong implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            bundle= new Bundle();
            bundle.putString("keyHangMucKhac", edtTenDanhMuc.getText().toString());

            intent= new Intent();
            intent.putExtras(bundle);

            setResult(MainActivity.HANG_MUC_KHAC, intent);
            finishActivity(MainActivity.HANG_MUC_KHAC);
            finish();
        }
    }
}
