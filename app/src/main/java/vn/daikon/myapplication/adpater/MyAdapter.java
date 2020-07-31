package vn.daikon.myapplication.adpater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.daikon.myapplication.R;
import vn.daikon.myapplication.model.NhanVien;

public class MyAdapter extends BaseAdapter {
    private ArrayList<NhanVien> list;
    public MyAdapter(List<NhanVien> list){
        this.list = (ArrayList<NhanVien>) list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     return null;
    }
}
