package com.jyqqhw.rxdemo.testleak;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.jyqqhw.rxdemo.R;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wj on 2018/12/28 0028.
 */
public class LeakActivity extends AppCompatActivity {

    private static final String TAG = "LeakActivity";
    AppCompatActivity appCompatActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
        appCompatActivity = this;
        initView();
    }

    private void initView(){
        Button button = findViewById(R.id.click_to_leak);
        button.setOnClickListener(v -> {
            Observable.interval(1000, TimeUnit.MILLISECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(LeakActivity.this)))
                    .subscribe(result -> Log.d(TAG, "interval result "+result),
                            error -> Log.d(TAG, "send interval event catch error = "+error));
        });
    }

}
