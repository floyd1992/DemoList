package com.jyqqhw.javalock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jyqqhw.javalock.lockoneclass.LockOneInstanceActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        findViewById(R.id.lock_one_instance).setOnClickListener(v -> {
            Intent intent = new Intent(this, LockOneInstanceActivity.class);
            startActivity(intent);
        });
    }

}
