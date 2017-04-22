package com.example.user.myapplication.Activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.DTO.TaiKhoan;
import com.example.user.myapplication.Database.TaiKhoanModify;
import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.R;

import java.io.ByteArrayOutputStream;

/**
 * Created by user on 12/04/2017.
 */

public class ActivityThemTaiKhoan extends Activity {

    EditText edtTen_tai_khoan;
    TextView txtSo_tien_ban_dau, txtDialogLoai_tai_khoan;
    ImageView imgLoai_tai_khoan, imgD;
    Button btnLuu;

    Intent intent;
    Bundle bundle= new Bundle();
    String [] Loaitaikhoan= {"Tiền mặt", "Thẻ tín dụng", "Tài khoản tiết kiệm", "Tài khoản khác"};
    double kq;
    TaiKhoan taikhoan= new TaiKhoan();
    TaiKhoanModify taiKhoanModify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_them_tai_khoan);

        edtTen_tai_khoan= (EditText)findViewById(R.id.edtTen_them_tai_khoan);
        txtSo_tien_ban_dau= (TextView)findViewById(R.id.txtSo_tien_ban_dau);
        txtDialogLoai_tai_khoan=(TextView) findViewById(R.id.txtDialog_loai_tai_khoan);
        imgLoai_tai_khoan=(ImageView) findViewById(R.id.imgLoai_tai_khoan);
        imgD= (ImageView) findViewById(R.id.imgD);
        btnLuu=(Button) findViewById(R.id.btnLuu_them_tai_khoan);

        taiKhoanModify= new TaiKhoanModify(this);
        txtSo_tien_ban_dau.setOnClickListener(new EvenCalculator());
        txtDialogLoai_tai_khoan.setOnClickListener(new EvenLoaiTaiKhoan());
        btnLuu.setOnClickListener(new EvenLuu());
    }

    private class EvenCalculator implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityThemTaiKhoan.this, ActivityCalculator.class);
            startActivityForResult(intent, MainActivity.CALCULATOR);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if(requestCode== MainActivity.CALCULATOR && resultCode== MainActivity.CALCULATOR) {
                bundle= data.getExtras();
                txtSo_tien_ban_dau.setText(String.valueOf(bundle.getDouble("keyCalculator")));
                kq= bundle.getDouble("keyCalculator");

            }
        }
        catch (Exception ex)
        {
            ex.getMessage();
        }
    }

    private class EvenLoaiTaiKhoan implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder= new AlertDialog.Builder(ActivityThemTaiKhoan.this);
            builder.setTitle("Chọn tài khoản")
                    .setItems(Loaitaikhoan, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which)
                            {
                                case 0:
                                    txtDialogLoai_tai_khoan.setText("Tiền mặt");
                                    taikhoan.setmImg(ImageView_to_Byte(R.drawable.ic_subject_black_18dp));
                                    break;
                                case 1:
                                    txtDialogLoai_tai_khoan.setText("Thẻ tín dụng");
                                    taikhoan.setmImg(ImageView_to_Byte(R.drawable.ic_subject_black_24dp));
                                    break;
                                case 2:
                                    txtDialogLoai_tai_khoan.setText("Tài khoản tiết kiệm");
                                    break;
                                case 3:
                                    txtDialogLoai_tai_khoan.setText("Tài khoản khác");
                                    break;
                                default:
                                    break;
                            }
                        }
                    });
            builder.show();
        }
    }

    private class EvenLuu implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            taikhoan.setmName(edtTen_tai_khoan.getText().toString());
            taikhoan.setmMoney(txtSo_tien_ban_dau.getText().toString());
            taiKhoanModify.insert(taikhoan);
            finish();
        }
    }

    public byte[] ImageView_to_Byte(int drawable)
    {
        Bitmap bmp= BitmapFactory.decodeResource(getResources(), drawable);
        //BitmapDrawable drawable= (BitmapDrawable) imageView.getDrawable();
        //Bitmap bmp= drawable.getBitmap();

        ByteArrayOutputStream stream= new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray= stream.toByteArray();
        return byteArray;
    }
}
