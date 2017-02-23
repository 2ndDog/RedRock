package com.example.dog.fuckapp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView version;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        this.setTitle("设置");//Activity标题

        button1 = (Button) this.findViewById(R.id.s_btn1);
        button1.setOnClickListener(this);

        version=(TextView) findViewById(R.id.txt_version);//获取版本号
        version.setText("v"+getAppversion(this));
    }

    @Override
    public void onClick(View v) {
        if (v == button1) {
            AddActivity fname = new AddActivity();
            String filename = fname.filename+".txt";
            File file = new File(filename);
            file.delete();
            if (file.isFile() && file.exists()) {
                Toast.makeText(getApplicationContext(), "文件删除成功", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(getApplicationContext(), "文件删除失败", Toast.LENGTH_SHORT).show();
        }
    }


    //获取版本号
    private String getAppversion(Context context) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo;
        String versionName = "";
        try {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }
}
