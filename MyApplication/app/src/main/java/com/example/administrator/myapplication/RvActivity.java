package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        //实例化RecyclerView，注意要在Gradle里导包
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        //设置LayoutManager，它决定了怎么来布局
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置Adapter，Adapter的构造方法一般会传ArrayList进去
        recyclerView.setAdapter(new MyAdapter(10000));
    }
}
