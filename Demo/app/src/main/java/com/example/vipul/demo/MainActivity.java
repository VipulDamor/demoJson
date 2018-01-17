package com.example.vipul.demo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView lv_data;
    AQuery aQuery;
    List<MyBean> myBeanList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_data = findViewById(R.id.lv_data);
        aQuery = new AQuery(MainActivity.this);
        setData();

        lv_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Constant.id = i;
                startActivity(new Intent(MainActivity.this,Detail.class));
            }
        });


    }

    private void setData() {
        String url = "http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors";
        ProgressDialog pd = new ProgressDialog(MainActivity.this);
        pd.setMessage("loading...");

        aQuery.progress(pd).ajax(url, JSONObject.class,new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                super.callback(url, object, status);

                try {
                    JSONArray jsonObject = object.getJSONArray("actors");
                    for (int i=0;i<jsonObject.length();i++){
                        MyBean bean =  new MyBean();
                        JSONObject jobj = jsonObject.getJSONObject(i);

                        bean.setName(jobj.optString("name"));
                        bean.setDescription(jobj.optString("description"));
                        bean.setDob(jobj.optString("dob"));
                        bean.setCountry(jobj.optString("country"));
                        bean.setHeight(jobj.optString("height"));
                        bean.setSpouse(jobj.optString("spouse"));
                        bean.setChildren(jobj.optString("children"));
                        bean.setImage(jobj.optString("image"));


                        myBeanList.add(bean);
                        Constant.beanList = myBeanList;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                lv_data.setAdapter(new MyAdapter(myBeanList,MainActivity.this));

            }
        });

    }
}
