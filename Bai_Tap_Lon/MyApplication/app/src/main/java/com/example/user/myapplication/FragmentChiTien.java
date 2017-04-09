package com.example.user.myapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by user on 09/04/2017.
 */

public class FragmentChiTien extends Fragment{
    EditText edtChitien, editDiengiai;
    Button btnMucchi, btnDiengiai, btnTuTaiKhoan, btnSukien;

    Intent intent;
    Bundle bundle= new Bundle();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.layout_chi_tien, container, false);
        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        edtChitien=(EditText) getActivity().findViewById(R.id.editSo_tien_chi);
        editDiengiai=(EditText)getActivity().findViewById(R.id.edtDienGiai);

        btnMucchi=(Button) getActivity().findViewById(R.id.btnMuc_chi);
        btnDiengiai=(Button) getActivity(). findViewById(R.id.btnDien_giai);
        btnSukien=(Button) getActivity().findViewById(R.id.btnSu_kien);
        btnTuTaiKhoan=(Button) getActivity().findViewById(R.id.btnTu_tai_khoan);


        btnDiengiai.setOnClickListener(new EventDienGiai());
    }

    private class EventDienGiai implements AdapterView.OnClickListener
    {
        @Override
        public void onClick(View v) {
            intent= new Intent(getActivity(), ActivityDienGiai.class);
            startActivity(intent);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onResume() {
        super.onResume();


    }
}
