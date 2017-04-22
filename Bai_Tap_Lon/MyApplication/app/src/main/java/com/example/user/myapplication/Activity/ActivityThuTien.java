package com.example.user.myapplication.Activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.R;

import java.util.Date;

import br.com.bloder.magic.view.MagicButton;

/**
 * Created by user on 09/04/2017.
 */

public class ActivityThuTien extends Activity {

    Button btnMucchi, btnDiengiai, btnTuTaiKhoan, btnSukien;
    MagicButton btnMagic;
    TextView txtDiengiai, txtSukien, txtMucThu, txtDate, txtSotienthu;

    Intent intent;
    Bundle bundle= new Bundle();
    java.util.Calendar calendar;
    Date date;
    int month, year, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_thu_tien);

        txtDiengiai=(TextView) findViewById(R.id.txtDien_giai_thu_tien);
        txtSukien=(TextView) findViewById(R.id.txtSu_kien_thu_tien);
        txtMucThu=(TextView) findViewById(R.id.txtMuc_thu);
        txtDate=(TextView) findViewById(R.id.txtNgay_thu_tien);
        txtSotienthu=(TextView) findViewById(R.id.txtSo_tien_thu);

        btnMucchi=(Button) findViewById(R.id.btnMuc_thu);
        btnDiengiai=(Button) findViewById(R.id.btnDien_giai_thu_tien);
        btnSukien=(Button) findViewById(R.id.btnSu_kien_thu_tien);
        btnTuTaiKhoan=(Button) findViewById(R.id.btnTu_tai_khoan_thu_tien);
        btnMagic=(MagicButton) findViewById(R.id.btnMagic_thu_tien);

        calendar= java.util.Calendar.getInstance();
        day= calendar.get(java.util.Calendar.DAY_OF_MONTH);
        month= calendar.get(java.util.Calendar.MONTH);
        year= calendar.get(java.util.Calendar.YEAR);
        String strDate= String.valueOf(day)+ " / " +String.valueOf(month + 1) +" / "+ String.valueOf(year);
        txtDate.setText(strDate);

        btnDiengiai.setOnClickListener(new EventDienGiai());
        btnSukien.setOnClickListener(new EventSuKien());
        btnMucchi.setOnClickListener(new EventMucThu());
        btnMagic.setMagicButtonClickListener(new EventNgay());
        txtSotienthu.setOnClickListener(new EventSoTienThu());
    }

    private class EventSoTienThu implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityThuTien.this, ActivityCalculator.class);
            startActivityForResult(intent, MainActivity.SO_TIEN_THU);
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
            DatePickerDialog dateDialog= new DatePickerDialog(ActivityThuTien.this, calldateDialog, year, month, day);
            dateDialog.show();
        }
    }

    private class EventDienGiai implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityThuTien.this, ActivityDienGiai.class);
            startActivityForResult(intent, MainActivity.DIEN_GIAI_THU);
        }
    }

    private class EventSuKien implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityThuTien.this, ActivitySuKien.class);
            startActivityForResult(intent, MainActivity.SU_KIEN_THU);
        }
    }

    private class EventMucThu implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityThuTien.this, ActivityHangMucChi.class);
            startActivityForResult(intent, MainActivity.HANG_MUC_THU);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if(requestCode== MainActivity.DIEN_GIAI_THU && resultCode== MainActivity.DIEN_GIAI) {

                bundle = data.getExtras();
                txtDiengiai.setText(bundle.getString("keyDienGiai").toString());
            }
            if(requestCode== MainActivity.SU_KIEN_THU && resultCode== MainActivity.SU_KIEN) {

                bundle = data.getExtras();
                txtSukien.setText(bundle.getString("keySuKien").toString());
            }

            if(requestCode== MainActivity.HANG_MUC_THU && resultCode== MainActivity.HANG_MUC_CHI) {

                bundle= data.getExtras();
                txtMucThu.setText(bundle.getString("keyHangMucChi"));
            }
            if(requestCode== MainActivity.SO_TIEN_THU&& resultCode== MainActivity.CALCULATOR)
            {
                bundle= data.getExtras();
                txtSotienthu.setText(String.valueOf(bundle.getDouble("keyCalculator")));
            }

        }
        catch (Exception ex)
        {
            ex.getMessage();
        }
    }
}
