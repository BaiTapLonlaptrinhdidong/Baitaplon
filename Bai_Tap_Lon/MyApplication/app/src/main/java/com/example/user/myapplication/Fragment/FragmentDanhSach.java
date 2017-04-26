package com.example.user.myapplication.Fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;

import com.example.user.myapplication.Adapter.AdapterCursorDanhSachChi;
import com.example.user.myapplication.Adapter.AdapterCursorDanhSachThu;
import com.example.user.myapplication.Adapter.AdapterSpinnerDanhSach;
import com.example.user.myapplication.Adapter.AdapterSpinnerDanhSachThu;
import com.example.user.myapplication.Modify.DanhSachModify;
import com.example.user.myapplication.Modify.DanhSachThuModify;
import com.example.user.myapplication.R;

/**
 * Created by user on 23/04/2017.
 */

public class FragmentDanhSach extends Fragment {

    private TabHost tabhost;
    private ListView lvDanhSachChi, lvDanhSachThu;
    private Spinner spnDate, spnDateThu;

    private AdapterCursorDanhSachChi adapter;
    private AdapterSpinnerDanhSach adapterNgay;

    private AdapterSpinnerDanhSachThu adapterNgayThu;
    private AdapterCursorDanhSachThu adapterThu;

    DanhSachModify danhSachModify;
    DanhSachThuModify danhSachThuModify;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.layout_fragment_danh_sach, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        danhSachModify= new DanhSachModify(getActivity());
        danhSachThuModify= new DanhSachThuModify(getActivity());

        tabhost= (TabHost) getActivity().findViewById(android.R.id.tabhost);
        lvDanhSachChi= (ListView) getActivity().findViewById(R.id.lvDanh_sach);
        lvDanhSachThu= (ListView) getActivity().findViewById(R.id.lvDanh_sach_thu);

        spnDate= (Spinner) getActivity().findViewById(R.id.spnNgay);
        spnDateThu=(Spinner) getActivity().findViewById(R.id.spnNgayThu);

        LoadAdapterSpinner();
        LoadTabs();

        tabhost.setOnTabChangedListener(new EventTab());
        spnDate.setOnItemSelectedListener(new EventSelectChi());
        spnDateThu.setOnItemSelectedListener(new EventSelectThu());
    }

    public void LoadAdapterList(String date)
    {
        adapter= new AdapterCursorDanhSachChi(getActivity(), danhSachModify.getOneDate(date), true);
        lvDanhSachChi.setAdapter(adapter);
    }

    public void LoadAdapterListThu(String date)
    {
        adapterThu= new AdapterCursorDanhSachThu(getActivity(), danhSachThuModify.getOneDate(date), true);
        lvDanhSachThu.setAdapter(adapterThu);
    }

    public void LoadAdapterSpinner()
    {
        adapterNgay= new AdapterSpinnerDanhSach(getActivity(),danhSachModify.getListDanhSach(), true);
        spnDate.setAdapter(adapterNgay);
    }

    public void LoadAdapterSpinnerThu()
    {
        adapterNgayThu= new AdapterSpinnerDanhSachThu(getActivity(), danhSachThuModify.getListDanhSachThu(), true);
        spnDateThu.setAdapter(adapterNgayThu);
    }

    public void LoadTabs()
    {
        tabhost.setup();
        TabHost.TabSpec spec;

        //tạo tab Chi tiền
        spec= tabhost.newTabSpec("tbChi");
        spec.setContent(R.id.tbChi);
        spec.setIndicator("Chi tiền");
        tabhost.addTab(spec);

        //tạo tab Thu tiền
        spec= tabhost.newTabSpec("tbThu");
        spec.setContent(R.id.tbThu);
        spec.setIndicator("Thu tiền");
        tabhost.addTab(spec);

        //set mặc định tab hiện thị ban đầu
        tabhost.setCurrentTab(0);
    }

    private class EventTab implements TabHost.OnTabChangeListener {
        @Override
        public void onTabChanged(String tabId) {
            if(tabId.equals("tbChi"))
            {
                LoadAdapterSpinner();
            }
            if(tabId.equals("tbThu"))
            {
                LoadAdapterSpinnerThu();
            }
        }
    }
    private class EventSelectChi implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor= (Cursor) spnDate.getItemAtPosition(position);
            String date= cursor.getString(1);
            LoadAdapterList(date);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class EventSelectThu implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor= (Cursor) spnDateThu.getItemAtPosition(position);
            String date= cursor.getString(1);
            LoadAdapterListThu(date);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
