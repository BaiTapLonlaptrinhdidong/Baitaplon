package com.example.user.myapplication.Fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.myapplication.Modify.ThongKeModify;
import com.example.user.myapplication.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 04/06/2017.
 */

public class FragmentThongKe extends android.support.v4.app.Fragment {

    Button btnBao_cao;
    private float tongChi= 0;
    private float tongThu= 0;
    ThongKeModify thongKeModify;
    PieChart pieChart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.layout_fragment_thong_ke, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        thongKeModify= new ThongKeModify(getActivity());
        pieChart = (PieChart) getActivity().findViewById(R.id.chartThong_ke);
        btnBao_cao= (Button) getActivity().findViewById(R.id.btnBao_cao);

        btnBao_cao.setOnClickListener(new EventReport());
    }

    private void setupPieChart(float chi){
        List<PieEntry> pieEntryList= new ArrayList<PieEntry>();
        pieEntryList.add(new PieEntry(chi, "Chi"));
        pieEntryList.add(new PieEntry(100f- chi, "Thu"));
        PieDataSet dataSet= new PieDataSet(pieEntryList, "");
        dataSet.setColor(R.color.colorDeepSkyBlue);
        PieData data= new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate();
        pieChart.animateY(1000);
    }

    private class EventReport implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Cursor cursor= thongKeModify.getMonth();
            for(int i= 0; i< cursor.getCount(); i++)
            {
                tongChi+= Float.parseFloat(cursor.getString(1));
                cursor.moveToNext();
            }

            Cursor cursor1= thongKeModify.getMonthThu();
            for(int i= 0; i< cursor1.getCount(); i++)
            {
                tongThu+= Float.parseFloat(cursor1.getString(1));
                cursor1.moveToNext();
            }

            float Tong= tongChi+ tongThu;
            tongChi= (tongChi / Tong) * 100;
            tongChi= tongChi * 3.6f;

            setupPieChart(tongChi);
        }
    }
}
