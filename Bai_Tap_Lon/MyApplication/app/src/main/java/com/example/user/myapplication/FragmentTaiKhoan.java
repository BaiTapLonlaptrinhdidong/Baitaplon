package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 09/04/2017.
 */

public class FragmentTaiKhoan extends Fragment {

    ListView lvTai_khoan;
    ImageButton imgBtnAdd;

    ArrayList<CustomListViewTaiKhoan> arrayList;
    AdapterListViewTaiKhoan adapterListViewTaiKhoan;

    Intent intent;
    Bundle bundle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.layout_fragment_tai_khoan, container, false);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lvTai_khoan=(ListView) getActivity().findViewById(R.id.Listview_tai_khoan);
        imgBtnAdd=(ImageButton) getActivity().findViewById(R.id.imgBtnAdd);

        arrayList= new ArrayList<CustomListViewTaiKhoan>();
        adapterListViewTaiKhoan= new AdapterListViewTaiKhoan(getActivity(), R.layout.layout_customlistview_tai_khoan, arrayList);
        lvTai_khoan.setAdapter(adapterListViewTaiKhoan);

        arrayList.add(new CustomListViewTaiKhoan("Ví", "100đ"));

        adapterListViewTaiKhoan.notifyDataSetChanged();

        imgBtnAdd.setOnClickListener(new EventAdd());
    }

    private class EventAdd implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(getActivity(), ActivityThemTaiKhoan.class);
            startActivityForResult(intent, 10);
        }
    }
}
