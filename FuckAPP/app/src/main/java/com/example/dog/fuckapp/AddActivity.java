package com.example.dog.fuckapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editdeta;
    private Button btnsave;
    private Context mContext;
    private RadioGroup RG;
    private RadioButton R1, R2, R3, R4;
    private int i=0;
    String filename = "day";

    //获取当前时间
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
    Date curDate = new Date(System.currentTimeMillis());
    String str = formatter.format(curDate);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        this.setTitle("添加事项");
        mContext = getApplicationContext();
        bindViews();

        RG = (RadioGroup) findViewById(R.id.radioGroup);
        R1 = (RadioButton) findViewById(R.id.btn1);
        R2 = (RadioButton) findViewById(R.id.btn2);
        R3 = (RadioButton) findViewById(R.id.btn3);
        R4 = (RadioButton) findViewById(R.id.btn4);

        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(R1.getId()==checkedId) {
                    i = 1;
                }
                if(R2.getId()==checkedId) {
                    i = 2;
                }
                if(R3.getId()==checkedId) {
                    i = 3;
                }
                if(R4.getId()==checkedId) {
                    i = 4;
                }
            }
        });
    }


    private void bindViews() {
        editdeta = (EditText) findViewById(R.id.editText1);//获取文本内容
        btnsave = (Button) findViewById(R.id.button2);

        btnsave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnsave) {
            if(editdeta.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "请输入内容哦", Toast.LENGTH_SHORT).show();
            }
            else {
                //设置优先级
                View.OnClickListener handle =  new View.OnClickListener(){
                    public void onClick(View v){
                        switch (v.getId()){
                            case R.id.btn1:
                                i = 1;
                                break;
                            case R.id.btn2:
                                i = 2;
                                break;
                            case R.id.btn3:
                                i = 3;
                                break;
                            case R.id.btn4:
                                i = 4;
                                break;
                        }
                    }
                };

                FileHelper fHelper = new FileHelper(mContext);
                String filedetail =  str + ":" + "\n" + "优先级" +String.valueOf(i) + "·" + editdeta.getText().toString() + "\n\n";
                try {
                    fHelper.save(filename, filedetail);
                    Toast.makeText(getApplicationContext(), "数据写入成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "数据写入失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    public String getFilename() {
        return filename;
    }
}
