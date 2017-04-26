package com.example.user.myapplication.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.myapplication.Activity.ActivityThemTaiKhoan;
import com.example.user.myapplication.Activity.ActivityUpdateTaiKhoan;
import com.example.user.myapplication.Adapter.AdapterTaiKhoan;
import com.example.user.myapplication.Modify.TaiKhoanModify;
import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.R;

/**
 * Created by user on 09/04/2017.
 */

public class FragmentTaiKhoan extends Fragment {

    private ListView lvTai_khoan;
    private ImageButton imgBtnAdd;

    private Intent intent;
    private Bundle bundle= new Bundle();
    private AdapterTaiKhoan adapter;
    private TaiKhoanModify taiKhoanModify;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.layout_fragment_tai_khoan, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lvTai_khoan=(ListView) getActivity().findViewById(R.id.Listview_tai_khoan);
        imgBtnAdd=(ImageButton) getActivity().findViewById(R.id.imgBtnAdd);
        taiKhoanModify= new TaiKhoanModify(getActivity());
        Load();
        //sự kiện của button
        imgBtnAdd.setOnClickListener(new EventAdd());
        //Context menu
        registerForContextMenu(lvTai_khoan);
    }

    private class EventAdd implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            intent= new Intent(getActivity(), ActivityThemTaiKhoan.class);
            startActivityForResult(intent, MainActivity.ADD_TAIKHOAN);
        }
    }
    //hàm adapter
    public void Load()
    {
        adapter= new AdapterTaiKhoan(getActivity(),taiKhoanModify.getListTaiKhoan(), true);
        lvTai_khoan.setAdapter(adapter);
    }
    //kết quả trả về
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if(requestCode== MainActivity.ADD_TAIKHOAN)
            {
                Load();
            }
            if (requestCode== MainActivity.UPDATE_TAI_KHOAN)
            {
                Load();
            }
    }

    //khởi tạo menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater= getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Cursor cursor= (Cursor) lvTai_khoan.getItemAtPosition(info.position);
        int id= cursor.getInt(0);
        switch (item.getItemId())
        {
            case R.id.menuDel:
                taiKhoanModify.delete(id);
                Load();
                Toast.makeText(getActivity(), "Xóa thành công", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuUpdate:
                intent= new Intent(getActivity(), ActivityUpdateTaiKhoan.class);
                bundle.putInt("KeyId", taiKhoanModify.getOneTaiKhoan(id).getmId());
                bundle.putString("KeyName", taiKhoanModify.getOneTaiKhoan(id).getmName());
                bundle.putString("KeyMoney", taiKhoanModify.getOneTaiKhoan(id).getmMoney());
                bundle.putByteArray("KeyImg", taiKhoanModify.getOneTaiKhoan(id).getmImg());
                intent.putExtras(bundle);
                startActivityForResult(intent, MainActivity.UPDATE_TAI_KHOAN);
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
