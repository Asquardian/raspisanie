package com.example.raspisanie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    public static String DB_PATH = "/data/data/com.example.raspisanie/databases/";
    public static String DB_NAME = "IP1.db";
    private static final String TAG = "MyActivity";
    private static PagerApadterDay adapter;
    public ViewPager2 viewPager;
    public TextView[] days = new TextView[6];

    public void ActiveDay (View v)
    {
        for(int i = 0; i < 6; i++){
            Log.i(TAG, Integer.toString(i));
            if(days[i] == v){
                viewPager.setCurrentItem(i);
                return;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter  = new PagerApadterDay(this);
        setContentView(R.layout.activity_main);
        Day allWeek[] = new Day[7];
        String dataDir = getApplicationInfo().dataDir;
        Database Helper = new Database(this);
        String s = Helper.checkDataBase();
        SQLiteDatabase db = SQLiteDatabase.openDatabase(s, null, SQLiteDatabase.OPEN_READWRITE);

        days[0] = (TextView) findViewById(R.id.d1);
        days[1] = (TextView) findViewById(R.id.d2);
        days[2] = (TextView) findViewById(R.id.d3);
        days[3] = (TextView) findViewById(R.id.d4);
        days[4] = (TextView) findViewById(R.id.d5);
        days[5] = (TextView) findViewById(R.id.d6);
        Cursor query = db.rawQuery("SELECT * FROM '917'", null);
        query.moveToFirst();
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if(day == Calendar.SUNDAY){
            day = Calendar.MONDAY;
        }
        for (int i = 0; i < 7; i++) {
            allWeek[i] = new Day();
        }
        for (int i = 0; i < query.getCount(); i++) {
            int week = query.getInt(2);
            int time = query.getInt(0);
            allWeek[week].subject[time] = query.getString(1);
            allWeek[week].teacher[time] = query.getString(3);
            allWeek[week].type[time] = query.getInt(4);
            allWeek[week].place[time] = query.getString(5);
            query.moveToNext();
        }
        adapter.setDay(allWeek, this);

        viewPager = (ViewPager2) findViewById(R.id.pager);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(day - 2);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position,
                                       float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                for(int i = 0; i < 6; i++) {
                    if(i != viewPager.getCurrentItem())
                        days[i].setBackgroundColor(Color.parseColor("#303030"));
                    else
                        days[i].setBackgroundColor(Color.parseColor("#202020"));
                }
            }
        });
    }
}