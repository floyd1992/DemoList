package com.jyqqhw.javalock.lockoneclass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jyqqhw.javalock.R;

/**
 * Created by wj on 2019/1/15 0015.
 */
public class LockOneInstanceActivity extends AppCompatActivity {

    private static final String TAG = "TestLockOneInstance";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_one_instance);
        test();
    }

    private void test(){
        Person person = new Person();
        MyRunable myRunable1 = new MyRunable(person, 1);
        MyRunable myRunable2 = new MyRunable(person, 2);
        MyRunable myRunable3 = new MyRunable(person, 3);
        for (int i=0;i<25;i++){
            person.eat(i);
            new Thread(myRunable1).start();
            new Thread(myRunable2).start();
            new Thread(myRunable3).start();
        }
    }

    static class Person{

        public synchronized void work(int i){
            Log.d(TAG, "哈哈哈，开始工作! "+i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void sleep(int i){
            Log.d(TAG, "哈哈哈，开始睡觉! "+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void drink(int i){
            Log.d(TAG, "哈哈哈，开始喝水! "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void eat(int i){
            Log.i(TAG, "哈哈哈，开始吃饭! "+i);
        }

    }

    static class MyRunable implements Runnable{

        Person mPerson;
        int mTask;
        int mIndex;

        public MyRunable(Person person, int task){
            mPerson = person;
            mTask = task;
        }

        @Override
        public void run() {
            if(mTask==1){
                mPerson.sleep(++mIndex);
            }if(mTask==2){
                mPerson.drink(++mIndex);
            }else{
                mPerson.work(+mIndex);
            }
        }
    }



}
