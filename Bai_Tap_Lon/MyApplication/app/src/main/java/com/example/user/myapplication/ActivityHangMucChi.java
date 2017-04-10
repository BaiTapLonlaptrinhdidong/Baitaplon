package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user on 10/04/2017.
 */

public class ActivityHangMucChi extends Activity {

    Button btnXong_hang_muc_chi, btnHuy_hang_muc_chi;
    Spinner spnHang_muc_chi;
    ListView lvHang_muc_chi;

    Intent intent;
    Bundle bundle;

    ArrayList<CustomSpinnerHangMuc> spnArrayList;
    ArrayList<CustomListViewHangMucChi> lvArrayList;
    AdapterSpinnerHangMuc adapterSpinnerHangMuc;
    AdapterListViewHangMucChi adapterListViewHangMucChi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hang_muc_chi);

        spnHang_muc_chi= (Spinner) findViewById(R.id.spnHang_muc_chi);
        lvHang_muc_chi=(ListView) findViewById(R.id.listviewHang_muc_chi);
        btnXong_hang_muc_chi=(Button) findViewById(R.id.btnXong_hang_muc_chi);
        btnHuy_hang_muc_chi=(Button) findViewById(R.id.btnHuy_hang_muc_chi);

        intent= new Intent();
        bundle= new Bundle();

        spnArrayList= new ArrayList<CustomSpinnerHangMuc>();
        lvArrayList= new ArrayList<CustomListViewHangMucChi>();

        adapterListViewHangMucChi= new AdapterListViewHangMucChi(this, R.layout.layout_customlistview_hang_muc_chi, lvArrayList);
        adapterSpinnerHangMuc= new AdapterSpinnerHangMuc(this, R.layout.layout_custom_hang_muc, spnArrayList);
        spnHang_muc_chi.setAdapter(adapterSpinnerHangMuc);
        lvHang_muc_chi.setAdapter(adapterListViewHangMucChi);

        spnArrayList.add(new CustomSpinnerHangMuc("Ăn uống"));
        spnArrayList.add(new CustomSpinnerHangMuc("Dịch vụ sinh hoạt"));
        spnArrayList.add(new CustomSpinnerHangMuc("Đi lại"));
        spnArrayList.add(new CustomSpinnerHangMuc("Giải trí"));
        spnArrayList.add(new CustomSpinnerHangMuc("Sức khỏe"));
        spnArrayList.add(new CustomSpinnerHangMuc("Hiếu hỉ"));

        adapterSpinnerHangMuc.notifyDataSetChanged();


        spnHang_muc_chi.setOnItemSelectedListener(new EventSelect());
    }

    private class EventSelect implements AdapterView.OnItemSelectedListener
    {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (position)
            {
                case 0:
                    adapterListViewHangMucChi.clear();
                    lvArrayList.add(new CustomListViewHangMucChi("Đi chợ/ siêu thị"));
                    lvArrayList.add(new CustomListViewHangMucChi("Ăn tiệm"));
                    lvArrayList.add(new CustomListViewHangMucChi("Cafe"));
                    adapterListViewHangMucChi.notifyDataSetChanged();
                    lvHang_muc_chi.setOnItemClickListener(new EventAnUong());
                    break;
                case 1:
                    adapterListViewHangMucChi.clear();
                    lvArrayList.add(new CustomListViewHangMucChi("Điện"));
                    lvArrayList.add(new CustomListViewHangMucChi("Nước"));
                    lvArrayList.add(new CustomListViewHangMucChi("Internet"));
                    lvArrayList.add(new CustomListViewHangMucChi("Điện thoại di động"));
                    lvArrayList.add(new CustomListViewHangMucChi("Gas"));
                    lvArrayList.add(new CustomListViewHangMucChi("Truyền hình"));
                    adapterListViewHangMucChi.notifyDataSetChanged();
                    lvHang_muc_chi.setOnItemClickListener(new EventDichVuSinhHoat());
                    break;
                case 2:
                    adapterListViewHangMucChi.clear();
                    lvArrayList.add(new CustomListViewHangMucChi("Xăng"));
                    lvArrayList.add(new CustomListViewHangMucChi("Bảo hiểm xe"));
                    lvArrayList.add(new CustomListViewHangMucChi("Sửa chữa, bảo dưỡng"));
                    lvArrayList.add(new CustomListViewHangMucChi("Gửi xe"));
                    lvArrayList.add(new CustomListViewHangMucChi("Rửa xe"));
                    lvArrayList.add(new CustomListViewHangMucChi("Taxi"));
                    adapterListViewHangMucChi.notifyDataSetChanged();
                    lvHang_muc_chi.setOnItemClickListener(new EventDiLai());
                    break;
                case 3:
                    adapterListViewHangMucChi.clear();
                    lvArrayList.add(new CustomListViewHangMucChi("Du lịch"));
                    lvArrayList.add(new CustomListViewHangMucChi("Làm đẹp"));
                    lvArrayList.add(new CustomListViewHangMucChi("Vui chơi, xem phim"));
                    adapterListViewHangMucChi.notifyDataSetChanged();
                    lvHang_muc_chi.setOnItemClickListener(new EventGiaiTri());
                    break;
                case 4:
                    adapterListViewHangMucChi.clear();
                    lvArrayList.add(new CustomListViewHangMucChi("Khám chữa bệnh"));
                    lvArrayList.add(new CustomListViewHangMucChi("Thuốc men"));
                    adapterListViewHangMucChi.notifyDataSetChanged();
                    lvHang_muc_chi.setOnItemClickListener(new EventSucKhoe());
                    break;
                case 5:
                    adapterListViewHangMucChi.clear();
                    lvArrayList.add(new CustomListViewHangMucChi("Cưới xin"));
                    lvArrayList.add(new CustomListViewHangMucChi("Ma chay"));
                    lvArrayList.add(new CustomListViewHangMucChi("Thăm hỏi"));
                    lvArrayList.add(new CustomListViewHangMucChi("Biếu tặng"));
                    adapterListViewHangMucChi.notifyDataSetChanged();
                    lvHang_muc_chi.setOnItemClickListener(new EventHieuHi());
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class EventAnUong implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position)
            {
                case 0:
                    bundle.putString("keyHangMucChi", "Đi chợ/ siêu thị");
                    intent.putExtras(bundle);
                    setResult(1,intent);
                    finish();
                    break;
                case 1:
                    bundle.putString("keyHangMucChi", "Ăn tiệm");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
                case 2:
                    bundle.putString("keyHangMucChi", "Cafe");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
            }
        }
    }
    private class EventDiLai implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position)
            {
                case 0:
                    bundle.putString("keyHangMucChi", "Xăng");
                    intent.putExtras(bundle);
                    setResult(1,intent);
                    finish();
                    break;
                case 1:
                    bundle.putString("keyHangMucChi", "Bảo hiểm xe");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
                case 2:
                    bundle.putString("keyHangMucChi", "Sữa chửa, bảo dưỡng");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
                case 3:
                    bundle.putString("keyHangMucChi", "Gửi xe");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
                case 4:
                    bundle.putString("keyHangMucChi", "Rửa xe");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
            }
        }
    }

    private class EventDichVuSinhHoat implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position)
            {
                case 0:
                    bundle.putString("keyHangMucChi", "Điện");
                    intent.putExtras(bundle);
                    setResult(1,intent);
                    finish();
                    break;
                case 1:
                    bundle.putString("keyHangMucChi", "Nước");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
                case 2:
                    bundle.putString("keyHangMucChi", "Internet");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
                case 3:
                    bundle.putString("keyHangMucChi", "Điện thoại di động");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
                case 4:
                    bundle.putString("keyHangMucChi", "Gas");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
                case 5:
                    bundle.putString("keyHangMucChi", "Truyền hình");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
            }
        }
    }
    private class EventGiaiTri implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position)
            {
                case 0:
                    bundle.putString("keyHangMucChi", "Du lịch");
                    intent.putExtras(bundle);
                    setResult(1,intent);
                    finish();
                    break;
                case 1:
                    bundle.putString("keyHangMucChi", "Làm đẹp");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
                case 2:
                    bundle.putString("keyHangMucChi", "Vui chơi, xem phim");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
            }
        }
    }

    private class EventSucKhoe implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position)
            {
                case 0:
                    bundle.putString("keyHangMucChi", "Khám chữa bệnh");
                    intent.putExtras(bundle);
                    setResult(1,intent);
                    finish();
                    break;
                case 1:
                    bundle.putString("keyHangMucChi", "Thuốc men");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
            }
        }
    }
    private class EventHieuHi implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position)
            {
                case 0:
                    bundle.putString("keyHangMucChi", "Cưới xin");
                    intent.putExtras(bundle);
                    setResult(1,intent);
                    finish();
                    break;
                case 1:
                    bundle.putString("keyHangMucChi", "Ma chay");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
                case 2:
                    bundle.putString("keyHangMucChi", "Thăm hỏi");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
                case 3:
                    bundle.putString("keyHangMucChi", "Biếu tặng");
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                    break;
            }
        }
    }
}
