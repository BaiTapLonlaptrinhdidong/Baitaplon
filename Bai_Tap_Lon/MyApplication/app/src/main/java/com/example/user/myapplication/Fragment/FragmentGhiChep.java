package com.example.user.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.myapplication.Activity.ActivityChiTien;
import com.example.user.myapplication.Activity.ActivityThuTien;
import com.example.user.myapplication.Adapter.AdapterListViewGhiChep;
import com.example.user.myapplication.CustomList.CustomListViewGhiChep;
import com.example.user.myapplication.R;

import java.util.ArrayList;

/**
 * Created by user on 09/04/2017.
 */

public class FragmentGhiChep extends Fragment {

    ListView listGhi_chep;

    AdapterListViewGhiChep adapterListViewGhiChep;
    ArrayList<CustomListViewGhiChep> arrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.layout_listview_ghi_chep, container, false);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listGhi_chep= (ListView) getActivity().findViewById(R.id.list_ghi_chep);

        arrayList= new ArrayList<CustomListViewGhiChep>();
        adapterListViewGhiChep = new AdapterListViewGhiChep(getActivity(), R.layout.layout_customlistview_ghi_chep, arrayList);
        listGhi_chep.setAdapter(adapterListViewGhiChep);

        CustomListViewGhiChep custom= new CustomListViewGhiChep("Chi tiền", "Khi chi tiêu, cho vay, trả nợ");
        arrayList.add(custom);
        CustomListViewGhiChep custom1= new CustomListViewGhiChep("Thu tiền", "Khi có thu nhập, đi vay, thu nợ");
        arrayList.add(custom1);

        adapterListViewGhiChep.notifyDataSetChanged();

        listGhi_chep.setOnItemClickListener(new MySelect());
    }

    private class MySelect implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(position == 0)
            {
                Intent intent0= new Intent(getActivity(), ActivityChiTien.class);
                startActivity(intent0);
            }
            if(position== 1)
            {
                Intent intent1= new Intent(getActivity(), ActivityThuTien.class);
                startActivity(intent1);
            }
        }
    }
}
