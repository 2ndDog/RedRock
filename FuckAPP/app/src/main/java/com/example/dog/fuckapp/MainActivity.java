package com.example.dog.fuckapp;

/** * * ━━━━━━神兽出没━━━━━━
 *        ┏┓　　　┏┓
 *     ┏┛┻━━━┛┻┓
 *     ┃　　　　　　　┃ 　
 *     ┃　　　━　　　┃
 *     ┃　＞　　　＜　┃
 *     ┃　... 　  ... ┃
 *     ┃ 　   ⌒　    ┃
 *     ┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃   神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 ** * ━━━━━━感觉萌萌哒━━━━━━ */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private DrawerLayout drawer_layout;
    private ListView list_left_drawer;
    private ArrayList<Item> menuLists;
    private MyAdapter<Item> myAdapter = null;
    private Button btn1;

    //获取当前年月日
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
    String date=sdf.format(new java.util.Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_0);

        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        list_left_drawer = (ListView) findViewById(R.id.list_left_drawer);

        menuLists = new ArrayList<Item>();
        menuLists.add(new Item(R.mipmap.iv_menu_today, "全部"));
        menuLists.add(new Item(R.mipmap.iv_menu_future, "今天"));
        menuLists.add(new Item(R.mipmap.iv_menu_settings, "设置"));
        myAdapter = new MyAdapter<Item>(menuLists, R.layout.item_list) {
            @Override
            public void bindView(ViewHolder holder, Item obj) {
                holder.setImageResource(R.id.img_icon, obj.getIconId());
                holder.setText(R.id.txt_content, obj.getIconName());
            }
        };
        list_left_drawer.setAdapter(myAdapter);
        list_left_drawer.setOnItemClickListener(this);


        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn1 == v) {
                    startActivity(new Intent(MainActivity.this, AddActivity.class));
                }
            }
        });
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ContentFragment contentFragment = new ContentFragment();
        Bundle args = new Bundle();

        //获取文件内容
        String detail = null;
        AddActivity fname = new AddActivity();//获取文件名
        FileHelper fHelper2 = new FileHelper(getApplicationContext());
        try {
            detail = fHelper2.read(fname.getFilename());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String txt = "";
        String str[] = detail.split(date);
        for(int i = 1;i<str.length;i++) {
            txt = txt + str[i];
        }

        switch (menuLists.get(position).getIconName()) {
            case "全部":
                args.putString("text", detail);
                this.setTitle("全部事项");//Activity标题
                break;
            case "今天":
                args.putString("text", txt);
                this.setTitle("今日事项");//Activity标题
                break;
            case "设置":
                args.putString("text", detail);
                this.setTitle("全部事项");//Activity标题
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        }

        contentFragment.setArguments(args);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.ly_content, contentFragment).commit();
        drawer_layout.closeDrawer(list_left_drawer);
    }
}