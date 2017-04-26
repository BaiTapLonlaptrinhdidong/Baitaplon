package com.example.user.myapplication;

import android.app.ActionBar;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.example.user.myapplication.Fragment.FragmentDanhSach;
import com.example.user.myapplication.Fragment.FragmentGhiChep;
import com.example.user.myapplication.Fragment.FragmentTaiKhoan;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    public static final int HANG_MUC_CHI= 1;
    public static final int CALCULATOR= 11;
    public static final int DIEN_GIAI= 3;
    public static final int SU_KIEN= 5;
    public static final int SO_TIEN_CHI= 2;
    public static final int SO_TIEN_THU= 15;
    public static final int DIEN_GIAI_THU= 17;
    public static final int SU_KIEN_THU= 19;
    public static final int VAO_TAI_KHOAN= 16;
    public static final int UPDATE_TAI_KHOAN= 4;
    public static final int CALCULATOR_UPDATE= 6;
    public static final int ADD_TAIKHOAN= 10;
    public static final int CHON_TAI_KHOAN= 7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_bar_bottom);

        bottomNavigationView= (BottomNavigationView) findViewById(R.id.bottom_navi);
        setFragment(0);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()== R.id.Ghi_chep)
                {
                    setFragment(0);
                }
                if(item.getItemId()== R.id.Su_kien)
                {
                    setFragment(1);
                }
                if(item.getItemId()== R.id.Danh_sach)
                {
                    setFragment(2);
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    //setFragment
    public void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                FragmentGhiChep fragmentGhiChep= new FragmentGhiChep();
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.layout_top, fragmentGhiChep);
                fragmentTransaction.commit();
                break;
            case 1:
                FragmentTaiKhoan fragmentTaiKhoan= new FragmentTaiKhoan();
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.layout_top, fragmentTaiKhoan);
                fragmentTransaction.commit();
                break;
            case 2:
                FragmentDanhSach fragmentDanhSach= new FragmentDanhSach();
                fragmentManager= getSupportFragmentManager();
                fragmentTransaction= fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.layout_top, fragmentDanhSach);
                fragmentTransaction.commit();
                break;
        }
    }
}
