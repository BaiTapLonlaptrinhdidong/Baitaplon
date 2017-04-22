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
 * Created by user on 21/04/2017.
 */

public class ActivityUpdateTaiKhoan extends Activity {

    EditText edtTen_tai_khoan_up;
    TextView txtSo_tien_ban_dau_up, txtDialogLoai_tai_khoan_up;
    Button btnLuu_up;

    Intent intent;
    Bundle bundle= new Bundle();
    String [] Loaitaikhoan= {"Tiền mặt", "Thẻ tín dụng", "Tài khoản tiết kiệm", "Tài khoản khác"};
    double kq;
    TaiKhoan taikhoan= new TaiKhoan();
    TaiKhoanModify taiKhoanModify;
    int id;
    byte[] imgBytes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_update_tai_khoan);

        edtTen_tai_khoan_up= (EditText)findViewById(R.id.edtTen_them_tai_khoan_up);
        txtSo_tien_ban_dau_up= (TextView)findViewById(R.id.txtSo_tien_ban_dau_up);
        txtDialogLoai_tai_khoan_up=(TextView) findViewById(R.id.txtDialog_loai_tai_khoan_up);
        btnLuu_up=(Button) findViewById(R.id.btnLuu_them_tai_khoan_up);

        LoadTaiKhoan();
        taiKhoanModify= new TaiKhoanModify(this);

        txtSo_tien_ban_dau_up.setOnClickListener(new EvenCalculator());
        txtDialogLoai_tai_khoan_up.setOnClickListener(new EvenLoaiTaiKhoan());
        btnLuu_up.setOnClickListener(new EvenUpdate());
    }


    public void LoadTaiKhoan()
    {
        intent= getIntent();
        bundle= intent.getExtras();
        id= bundle.getInt("KeyId");
        taikhoan.setmImg(bundle.getByteArray("KeyImg"));
        edtTen_tai_khoan_up.setText(bundle.getString("KeyName"));
        txtSo_tien_ban_dau_up.setText(bundle.getString("KeyMoney"));
    }
    //Calculator
    private class EvenCalculator implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityUpdateTaiKhoan.this, ActivityCalculator.class);
            startActivityForResult(intent, MainActivity.CALCULATOR_UPDATE);
        }
    }
    private class EvenLoaiTaiKhoan implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder= new AlertDialog.Builder(ActivityUpdateTaiKhoan.this);
            builder.setTitle("Chọn tài khoản")
                    .setItems(Loaitaikhoan, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which)
                            {
                                case 0:
                                    txtDialogLoai_tai_khoan_up.setText("Tiền mặt");
                                    taikhoan.setmImg(ImageView_to_Byte(R.drawable.ic_subject_black_18dp));
                                    break;
                                case 1:
                                    txtDialogLoai_tai_khoan_up.setText("Thẻ tín dụng");
                                    taikhoan.setmImg(ImageView_to_Byte(R.drawable.ic_subject_black_24dp));
                                    break;
                                case 2:
                                    txtDialogLoai_tai_khoan_up.setText("Tài khoản tiết kiệm");
                                    break;
                                case 3:
                                    txtDialogLoai_tai_khoan_up.setText("Tài khoản khác");
                                    break;
                                default:
                                    break;
                            }
                        }
                    });
            builder.show();
        }
    }
    //chuyển bitmap sang array bytes
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if(requestCode== MainActivity.CALCULATOR_UPDATE && resultCode== MainActivity.CALCULATOR) {
                bundle= data.getExtras();
                txtSo_tien_ban_dau_up.setText(String.valueOf(bundle.getDouble("keyCalculator")));
                kq= bundle.getDouble("keyCalculator");
            }
        }
        catch (Exception ex)
        {
            ex.getMessage();
        }
    }

    private class EvenUpdate implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            taikhoan.setmName(edtTen_tai_khoan_up.getText().toString());
            taikhoan.setmMoney(txtSo_tien_ban_dau_up.getText().toString());
            taikhoan.setmId(id);
            taiKhoanModify.upDate(taikhoan);
            Toast.makeText(ActivityUpdateTaiKhoan.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
