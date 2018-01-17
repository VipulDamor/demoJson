package com.example.vipul.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tv_detail = findViewById(R.id.detail);
        imageView = findViewById(R.id.iv_image);

        //String id = Constant.beanList.get(Constant.id).getName();
        String Name = Constant.beanList.get(Constant.id).getDescription();
        String email = Constant.beanList.get(Constant.id).getDob();
        String address = Constant.beanList.get(Constant.id).getCountry();
        String gender = Constant.beanList.get(Constant.id).getHeight();
        String Mobile = Constant.beanList.get(Constant.id).getSpouse();
        String Home = Constant.beanList.get(Constant.id).getChildren();
        //String Office = Constant.beanList.get(Constant.id).getOffice();

       // tv_detail.append("id : "+ id +"\n");
        tv_detail.append("Desc : "+ Name +"\n");
        tv_detail.append("Dob : "+ email +"\n");
        tv_detail.append("Country : "+ address +"\n");
        tv_detail.append("height : "+ gender +"\n");
        tv_detail.append("spouse : "+ Mobile +"\n");
        tv_detail.append("children : "+ Home +"\n");
       // tv_detail.append("Office : "+ Office +"\n");

        Glide
                .with(this)
                .load(Constant.beanList.get(Constant.id).getImage())
                .into(imageView);



    }
}
