package com.example.user.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by user on 09/04/2017.
 */

public class FragmentGhiChep extends Fragment {

    Spinner spnTitle;

    String [] tile= {"Chi tiền", "Thu tiền"};
    ArrayAdapter<String>  arrayAdapter;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private class MyEnvent implements AdapterView.OnItemSelectedListener
    {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(position== 0)
            {
                FragmentChiTien fragmentChiTien= new FragmentChiTien();
                fragmentManager= getChildFragmentManager();
                fragmentTransaction= fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.lin_replace, fragmentChiTien);
                fragmentTransaction.commit();
            }
            if(position== 1)
            {
                FragmentThuTien fragmentThuTien= new FragmentThuTien();
                fragmentManager= getChildFragmentManager();
                fragmentTransaction= fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.lin_replace, fragmentThuTien);
                fragmentTransaction.commit();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.layout_spn_ghi_chep, container, false);

        arrayAdapter= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, tile);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        spnTitle =(Spinner) getActivity().findViewById(R.id.spnTitle);
        spnTitle.setAdapter(arrayAdapter);
        spnTitle.setOnItemSelectedListener(new MyEnvent());
    }
}
