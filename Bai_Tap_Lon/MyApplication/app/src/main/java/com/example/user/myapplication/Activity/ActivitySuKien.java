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
        setContentView(R.layout.layout_su_kien);

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
            intent= new Intent();
            bundle.putString("keySuKien", edtSu_kien.getText().toString());
            intent.putExtras(bundle);

            setResult(MainActivity.SU_KIEN, intent);
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
