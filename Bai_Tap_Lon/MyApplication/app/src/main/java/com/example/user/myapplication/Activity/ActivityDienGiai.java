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
 * Created by user on 09/04/2017.
 */

public class ActivityDienGiai extends Activity {

    private EditText edtDien_giai;
    private Button btnHuy_dien_giai, btnXong_dien_giai;

    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dien_giai);

        edtDien_giai= (EditText)findViewById(R.id.edtDienGiai);

        btnHuy_dien_giai=(Button)findViewById(R.id.btnHuy_dien_giai);
        btnXong_dien_giai=(Button)findViewById(R.id.btnXong_dien_giai);

        intent= new Intent();
        bundle= new Bundle();

        btnXong_dien_giai.setOnClickListener(new MyEventXong());
        btnHuy_dien_giai.setOnClickListener(new MyEventHuy());


    }


    private class MyEventXong implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            intent= new Intent();
            bundle.putString("keyDienGiai", edtDien_giai.getText().toString());
            intent.putExtras(bundle);

            setResult(MainActivity.DIEN_GIAI, intent);
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
