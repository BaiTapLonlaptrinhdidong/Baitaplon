package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by user on 10/04/2017.
 */

public class ActivitySuKien extends Activity {

    EditText edtSu_kien;
    Button btnHuy_su_kien, btnXong_su_kien;

    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.su_kien);

        edtSu_kien= (EditText) findViewById(R.id.edtSu_kien);

        btnXong_su_kien=(Button) findViewById(R.id.btnXong_su_kien);
        btnHuy_su_kien=(Button) findViewById(R.id.btnHuy_su_kien);

        intent= new Intent();
        bundle= new Bundle();


        btnXong_su_kien.setOnClickListener(new MyEventXong());
        btnHuy_su_kien.setOnClickListener(new MyEventHuy());
    }


    private class MyEventXong implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            bundle.putString("keySuKien", edtSu_kien.getText().toString());
            intent.putExtras(bundle);

            setResult(5, intent);
            finish();
        }
    }

    private class MyEventHuy implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            finish();
        }
    }
}
