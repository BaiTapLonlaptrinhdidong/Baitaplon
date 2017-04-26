package com.example.user.myapplication.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.user.myapplication.Adapter.AdapterListViewHangMucChi;
import com.example.user.myapplication.Adapter.AdapterSpinnerHangMuc;
import com.example.user.myapplication.CustomList.CustomListViewHangMucChi;
import com.example.user.myapplication.CustomList.CustomSpinnerHangMuc;
import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.R;

import java.util.ArrayList;

/**
 * Created by user on 10/04/2017.
 */

public class ActivityHangMucChi extends Activity {

    private Button  btnHuy_hang_muc_chi;
    private Spinner spnHang_muc_chi;
    private ListView lvHang_muc_chi;

    private Intent intent;
    private Bundle bundle;

    private ArrayList<CustomSpinnerHangMuc> spnArrayList;
    private ArrayList<CustomListViewHangMucChi> lvArrayList;
    private AdapterSpinnerHangMuc adapterSpinnerHangMuc;
    private AdapterListViewHangMucChi adapterListViewHangMucChi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hang_muc_chi);

        spnHang_muc_chi= (Spinner) findViewById(R.id.spnHang_muc_chi);
        lvHang_muc_chi=(ListView) findViewById(R.id.listviewHang_muc_chi);
        btnHuy_hang_muc_chi=(Button) findViewById(R.id.btnHuy_hang_muc_chi);

        intent= new Intent();
        bundle= new Bundle();

        spnArrayList= new ArrayList<CustomSpinnerHangMuc>();
        lvArrayList= new ArrayList<CustomListViewHangMucChi>();

        adapterListViewHangMucChi= new AdapterListViewHangMucChi(this, R.layout.layout_customlistview_hang_muc_chi, lvArrayList);
        adapterSpinnerHangMuc= new AdapterSpinnerHangMuc(this, R.layout.layout_custom_hang_muc, spnArrayList);
        spnHang_muc_chi.setAdapter(adapterSpinnerHangMuc);
        lvHang_muc_chi.setAdapter(adapterListViewHangMucChi);

        spnArrayList.add(new CustomSpinnerHangMuc("Ăn uống", R.mipmap.an_uong));
        spnArrayList.add(new CustomSpinnerHangMuc("Dịch vụ sinh hoạt", R.mipmap.hoat_dong));
        spnArrayList.add(new CustomSpinnerHangMuc("Đi lại", R.mipmap.di_lai));
        spnArrayList.add(new CustomSpinnerHangMuc("Giải trí", R.mipmap.giai_tri));
        spnArrayList.add(new CustomSpinnerHangMuc("Sức khỏe", R.mipmap.suc_khoe));
        spnArrayList.add(new CustomSpinnerHangMuc("Hiếu hỉ",R.mipmap.hieu_hi));

        adapterSpinnerHangMuc.notifyDataSetChanged();

        spnHang_muc_chi.setOnItemSelectedListener(new EventSelect());
        btnHuy_hang_muc_chi.setOnClickListener(new EventBack());
    }

    private class EventSelect implements AdapterView.OnItemSelectedListener
    {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (position)
            {
                case 0:
                    adapterListViewHangMucChi.clear();
                    lvArrayList.add(new CustomListViewHangMucChi("Đi chợ/ siêu thị", R.mipmap.sieu_thi));
                    lvArrayList.add(new CustomListViewHangMucChi("Ăn tiệm", R.mipmap.an_tiem));
                    lvArrayList.add(new CustomListViewHangMucChi("Cafe", R.mipmap.cafe));
                    adapterListViewHangMucChi.notifyDataSetChanged();
                    lvHang_muc_chi.setOnItemClickListener(new EventAnUong());
                    break;
                case 1:
                    adapterListViewHangMucChi.clear();
                    lvArrayList.add(new CustomListViewHangMucChi("Điện", R.mipmap.dien));
                    lvArrayList.add(new CustomListViewHangMucChi("Nước", R.mipmap.nuoc));
                    lvArrayList.add(new CustomListViewHangMucChi("Internet", R.mipmap.internet));
                    lvArrayList.add(new CustomListViewHangMucChi("Điện thoại di động", R.mipmap.dien_thoai_di_dong));
                    lvArrayList.add(new CustomListViewHangMucChi("Gas", R.mipmap.gas));
                    lvArrayList.add(new CustomListViewHangMucChi("Truyền hình", R.mipmap.truyen_hinh_cap));
                    adapterListViewHangMucChi.notifyDataSetChanged();
                    lvHang_muc_chi.setOnItemClickListener(new EventDichVuSinhHoat());
                    break;
                case 2:
                    adapterListViewHangMucChi.clear();
                    lvArrayList.add(new CustomListViewHangMucChi("Xăng", R.mipmap.xang));
                    lvArrayList.add(new CustomListViewHangMucChi("Bảo hiểm xe", R.mipmap.bao_hiem_xe));
                    lvArrayList.add(new CustomListViewHangMucChi("Sửa chữa, bảo dưỡng", R.mipmap.bao_duong_xe));
                    lvArrayList.add(new CustomListViewHangMucChi("Gửi xe", R.mipmap.do_xe));
                    lvArrayList.add(new CustomListViewHangMucChi("Rửa xe", R.mipmap.rua_xe));
                    lvArrayList.add(new CustomListViewHangMucChi("Taxi", R.mipmap.taxi));
                    adapterListViewHangMucChi.notifyDataSetChanged();
                    lvHang_muc_chi.setOnItemClickListener(new EventDiLai());
                    break;
                case 3:
                    adapterListViewHangMucChi.clear();
                    lvArrayList.add(new CustomListViewHangMucChi("Du lịch", R.mipmap.du_lich));
                    lvArrayList.add(new CustomListViewHangMucChi("Làm đẹp", R.mipmap.lam_dep));
                    lvArrayList.add(new CustomListViewHangMucChi("Vui chơi, xem phim", R.mipmap.xem_phim));
                    adapterListViewHangMucChi.notifyDataSetChanged();
                    lvHang_muc_chi.setOnItemClickListener(new EventGiaiTri());
                    break;
                case 4:
                    adapterListViewHangMucChi.clear();
                    lvArrayList.add(new CustomListViewHangMucChi("Khám chữa bệnh", R.mipmap.kham_benh));
                    lvArrayList.add(new CustomListViewHangMucChi("Thuốc men", R.mipmap.thuoc));
                    adapterListViewHangMucChi.notifyDataSetChanged();
                    lvHang_muc_chi.setOnItemClickListener(new EventSucKhoe());
                    break;
                case 5:
                    adapterListViewHangMucChi.clear();
                    lvArrayList.add(new CustomListViewHangMucChi("Cưới xin", R.mipmap.cuoi_hoi));
                    lvArrayList.add(new CustomListViewHangMucChi("Ma chay", R.mipmap.dam_tang));
                    lvArrayList.add(new CustomListViewHangMucChi("Thăm hỏi", R.mipmap.tham_hoi));
                    lvArrayList.add(new CustomListViewHangMucChi("Biếu tặng", R.mipmap.tang_qua));
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
                    setResult(MainActivity.HANG_MUC_CHI,intent);
                    finish();
                    break;
                case 1:
                    bundle.putString("keyHangMucChi", "Ăn tiệm");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
                    finish();
                    break;
                case 2:
                    bundle.putString("keyHangMucChi", "Cafe");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
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
                    setResult(MainActivity.HANG_MUC_CHI,intent);
                    finish();
                    break;
                case 1:
                    bundle.putString("keyHangMucChi", "Bảo hiểm xe");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
                    finish();
                    break;
                case 2:
                    bundle.putString("keyHangMucChi", "Sữa chửa, bảo dưỡng");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
                    finish();
                    break;
                case 3:
                    bundle.putString("keyHangMucChi", "Gửi xe");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
                    finish();
                    break;
                case 4:
                    bundle.putString("keyHangMucChi", "Rửa xe");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
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
                    setResult(MainActivity.HANG_MUC_CHI,intent);
                    finish();
                    break;
                case 1:
                    bundle.putString("keyHangMucChi", "Nước");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
                    finish();
                    break;
                case 2:
                    bundle.putString("keyHangMucChi", "Internet");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
                    finish();
                    break;
                case 3:
                    bundle.putString("keyHangMucChi", "Điện thoại di động");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
                    finish();
                    break;
                case 4:
                    bundle.putString("keyHangMucChi", "Gas");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
                    finish();
                    break;
                case 5:
                    bundle.putString("keyHangMucChi", "Truyền hình");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
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
                    setResult(MainActivity.HANG_MUC_CHI,intent);
                    finish();
                    break;
                case 1:
                    bundle.putString("keyHangMucChi", "Làm đẹp");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
                    finish();
                    break;
                case 2:
                    bundle.putString("keyHangMucChi", "Vui chơi, xem phim");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
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
                    setResult(MainActivity.HANG_MUC_CHI,intent);
                    finish();
                    break;
                case 1:
                    bundle.putString("keyHangMucChi", "Thuốc men");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
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
                    setResult(MainActivity.HANG_MUC_CHI,intent);
                    finish();
                    break;
                case 1:
                    bundle.putString("keyHangMucChi", "Ma chay");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
                    finish();
                    break;
                case 2:
                    bundle.putString("keyHangMucChi", "Thăm hỏi");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
                    finish();
                    break;
                case 3:
                    bundle.putString("keyHangMucChi", "Biếu tặng");
                    intent.putExtras(bundle);
                    setResult(MainActivity.HANG_MUC_CHI, intent);
                    finish();
                    break;
            }
        }
    }

    private class EventBack implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            finish();
        }
    }
}
