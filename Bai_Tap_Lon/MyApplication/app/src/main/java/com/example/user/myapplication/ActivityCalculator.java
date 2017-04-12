package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by user on 12/04/2017.
 */

public class ActivityCalculator extends Activity implements View.OnClickListener{

    double thamsothunhat, thamsothuhai;
    String stoantu, sxuatmanhinh="";
    EditText edtGiaTri;

    Intent intent;
    Bundle bundle=new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_calculator);

        edtGiaTri= (EditText) findViewById(R.id.edtGia_tri);
        int [] idButton= {R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4, R.id.btnNum5, R.id.btnNum6, R.id.btnNum7,
                R.id.btnNum8, R.id.btnNum9, R.id.btnNumC, R.id.btnNumAC, R.id.btnNumNhan, R.id.btnNumChia, R.id.btnNumCong, R.id.btnNumTru, R.id.btnNumCham, R.id.btnNumBang};

        for(int id: idButton)
        {
            View v= (View) findViewById(id);
            v.setOnClickListener(this);
        }
    }

    private void Toantu(){
        thamsothunhat= Double.parseDouble(edtGiaTri.getText().toString());
        sxuatmanhinh= "0";
        edtGiaTri.setText("0");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnNumAC:
                edtGiaTri.setText("");
                thamsothuhai= 0.0;
                thamsothunhat= 0.0;
                sxuatmanhinh= "";
                break;
            case R.id.btnNumC:
                BaseInputConnection textFieldInput= new BaseInputConnection(edtGiaTri, true);
                textFieldInput.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btnNumBang:
                double ketqua= 0;
                thamsothuhai= Double.parseDouble(edtGiaTri.getText().toString());
                if(stoantu== "+")
                {
                    ketqua= thamsothunhat+ thamsothuhai;
                }
                if(stoantu== "-")
                {
                    ketqua= thamsothunhat- thamsothuhai;
                }
                if(stoantu== "*")
                {
                    ketqua= thamsothunhat* thamsothuhai;
                }
                if(stoantu== "/")
                {
                    ketqua= thamsothunhat/ thamsothuhai;
                }

                thamsothuhai= 0.0;
                thamsothunhat= 0.0;
                sxuatmanhinh= "";
                intent= new Intent();
                bundle.putDouble("keyCalculator", ketqua);
                intent.putExtras(bundle);
                setResult(11, intent);

                finish();
                break;
            case R.id.btnNumCham:
                stoantu= ".";
                break;
            case R.id.btnNumCong:
                stoantu="+";
                Toantu();
                break;
            case R.id.btnNumTru:
                stoantu="-";
                Toantu();
                break;
            case R.id.btnNumNhan:
                stoantu="*";
                Toantu();
                break;
            case R.id.btnNumChia:
                stoantu="/";
                Toantu();
                break;
            default:
                if(sxuatmanhinh.equals(""))
                {
                    sxuatmanhinh="";
                }
                sxuatmanhinh+= ((Button)v).getText().toString();
                edtGiaTri.setText(sxuatmanhinh);
                break;
        }
    }
}
