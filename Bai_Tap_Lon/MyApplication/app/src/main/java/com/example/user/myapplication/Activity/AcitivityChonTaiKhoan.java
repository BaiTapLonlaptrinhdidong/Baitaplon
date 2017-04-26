package com.example.user.myapplication.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.myapplication.Adapter.AdapterTaiKhoan;
import com.example.user.myapplication.Modify.TaiKhoanModify;
import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.R;

/**
 * Created by user on 22/04/2017.
 */

public class AcitivityChonTaiKhoan extends Activity {

    private TaiKhoanModify taiKhoanModify;
    private AdapterTaiKhoan adapter;
    private ListView lvTai_khoan;

    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fragment_tai_khoan);
        lvTai_khoan= (ListView) findViewById(R.id.Listview_tai_khoan);

        taiKhoanModify= new TaiKhoanModify(this);
        Load();
        lvTai_khoan.setOnItemClickListener(new EventChonTaiKhoan());
    }

    public void Load()
    {
        adapter= new AdapterTaiKhoan(this,taiKhoanModify.getListTaiKhoan(), true);
        lvTai_khoan.setAdapter(adapter);
    }


    private class EventChonTaiKhoan implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor= (Cursor) lvTai_khoan.getItemAtPosition(position);
            String Name= cursor.getString(1);
            int ID= cursor.getInt(0);
            String Money= cursor.getString(2);
            byte[] Img= cursor.getBlob(3);

            bundle= new Bundle();
            bundle.putByteArray("keyImg", Img);
            bundle.putInt("keyID", ID);
            bundle.putString("keyNameTaiKhoan", Name);
            bundle.putString("keyMoneyTaiKhoan", Money);

            intent= new Intent();
            intent.putExtras(bundle);
            setResult(MainActivity.CHON_TAI_KHOAN, intent);
            finish();
        }
    }
}
