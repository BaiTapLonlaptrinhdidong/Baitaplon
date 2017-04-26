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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.DTO.TaiKhoan;
import com.example.user.myapplication.Modify.TaiKhoanModify;
import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.R;

import java.io.ByteArrayOutputStream;

/**
 * Created by user on 21/04/2017.
 */

public class ActivityUpdateTaiKhoan extends Activity {

    private EditText edtTen_tai_khoan_up;
    private TextView txtSo_tien_ban_dau_up, txtDialogLoai_tai_khoan_up;
    private Button btnLuu_up;
    private ImageButton  imgBtn_Back;

    Intent intent;
    Bundle bundle= new Bundle();
    private String [] Loaitaikhoan= {"Tiền mặt", "Thẻ tín dụng", "Tài khoản tiết kiệm", "Tài khoản khác"};
    private double kq;
    private TaiKhoan taikhoan= new TaiKhoan();
    private TaiKhoanModify taiKhoanModify;
    private int id;
    private byte[] imgBytes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_update_tai_khoan);

        edtTen_tai_khoan_up= (EditText)findViewById(R.id.edtTen_them_tai_khoan_up);
        txtSo_tien_ban_dau_up= (TextView)findViewById(R.id.txtSo_tien_ban_dau_up);
        txtDialogLoai_tai_khoan_up=(TextView) findViewById(R.id.txtDialog_loai_tai_khoan_up);
        btnLuu_up=(Button) findViewById(R.id.btnLuu_them_tai_khoan_up);
        imgBtn_Back= (ImageButton) findViewById(R.id.imgBtn_Back_update);

        LoadTaiKhoan();
        taiKhoanModify= new TaiKhoanModify(this);

        txtSo_tien_ban_dau_up.setOnClickListener(new EventCalculator());
        txtDialogLoai_tai_khoan_up.setOnClickListener(new EventLoaiTaiKhoan());
        btnLuu_up.setOnClickListener(new EventUpdate());
        imgBtn_Back.setOnClickListener(new EventBack());
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
    private class EventCalculator implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(ActivityUpdateTaiKhoan.this, ActivityCalculator.class);
            startActivityForResult(intent, MainActivity.CALCULATOR_UPDATE);
        }
    }

    private class EventBack implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            finish();
        }
    }
    private class EventLoaiTaiKhoan implements View.OnClickListener {
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
                                    taikhoan.setmImg(ImageView_to_Byte(R.mipmap.tien_mat));
                                    break;
                                case 1:
                                    txtDialogLoai_tai_khoan_up.setText("Thẻ tín dụng");
                                    taikhoan.setmImg(ImageView_to_Byte(R.mipmap.atm));
                                    break;
                                case 2:
                                    txtDialogLoai_tai_khoan_up.setText("Tài khoản tiết kiệm");
                                    taikhoan.setmImg(ImageView_to_Byte(R.mipmap.taikhoan_tietkiem));
                                    break;
                                case 3:
                                    txtDialogLoai_tai_khoan_up.setText("Tài khoản khác");
                                    taikhoan.setmImg(ImageView_to_Byte(R.mipmap.tien_khac));
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

    private class EventUpdate implements View.OnClickListener {
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
