package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout mLinearLayout;
    ScrollView mScrollView;

    /*
     * 知识储备：
     * View简介
     * View与ViewGroup
     * View的生成(findViewById发生了什么)
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLinearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        mScrollView = (ScrollView) findViewById(R.id.activity_main);
        //adapter的由来: 一个recyclerView，需要什么信息(数据)，来完成任务？
        addViews(R.layout.item, 32, mLinearLayout);
    }

    //Recycler的由来: 一个简单的list,当添加的数量达到1000的时候就炸了，怎么办？
    private void addViews(@LayoutRes int res, int count, ViewGroup parent)
    {
        for (int i = 0; i < count; i++) {
            String str[] = Student.getStudent();
            View view = View.inflate(this, res, null);
            //ViewHolder的由来: 重复findViewById()，造成性能的损失，怎么办？
            TextView textView = (TextView) view.findViewById(R.id.tv);
            textView.setText(String.valueOf(str[i])+String.valueOf("  2016级"));
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,RvActivity.class));
                }
            });
            parent.addView(view);
        }
    }

}
