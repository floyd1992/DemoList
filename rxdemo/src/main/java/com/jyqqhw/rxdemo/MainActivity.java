package com.jyqqhw.rxdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.jyqqhw.rxdemo.testleak.LeakActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        Button leak = findViewById(R.id.item_leak);
        leak.setOnClickListener(v -> activityStart(LeakActivity.class));
    }

    private void activityStart(Class className){
        Intent intent = new Intent(MainActivity.this, className);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
