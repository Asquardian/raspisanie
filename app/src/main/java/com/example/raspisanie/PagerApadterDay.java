package com.example.raspisanie;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerApadterDay extends FragmentStateAdapter {

    private static Day[] week = new Day[6];
    private static Context mContext;

    public PagerApadterDay(@NonNull FragmentActivity fa) {
        super(fa);
    }

    public void setDay(Day[] allWeek, Context context){
        for(int i = 0; i < 6; i++){
            week[i] = allWeek[i];
        }
        mContext = context;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        ShowDayFragment thisDay = new ShowDayFragment(mContext, week[position]);
        return thisDay;
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
