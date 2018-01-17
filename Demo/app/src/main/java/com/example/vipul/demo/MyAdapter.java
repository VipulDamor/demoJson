package com.example.vipul.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vipul on 17-01-2018.
 */

public class MyAdapter extends BaseAdapter {

    List<MyBean> beanList;
    Context context;


    public MyAdapter(List<MyBean> beanList, Context context) {
        this.beanList = beanList;
        this.context = context;
    }

    @Override    public int getCount() {
        return beanList.size();
    }

    @Override    public Object getItem(int i) {
        return beanList.get(i);
    }

    @Override    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.singlerow,null);
        TextView textView = view.findViewById(R.id.tv_data);
        textView.setText(beanList.get(i).getName());
        return view;
    }


}
