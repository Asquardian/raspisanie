package com.example.raspisanie;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class ShowDayFragment extends Fragment {
    private static Context mContext;
    private static Day thisDay;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public void setDay(Day this_){
        thisDay = this_;
    }
    public ShowDayFragment(Context context, Day this_){
        mContext = context;
        setDay(this_);
    }

    public static ShowDayFragment newInstance(String param1, String param2) {
        ShowDayFragment fragment = new ShowDayFragment(mContext, thisDay);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Calendar cal = Calendar.getInstance();
        int week = cal.get(Calendar. WEEK_OF_YEAR);
        int typeOfWeek = week % 2 + 1;
        Log.i("", Integer.toString(typeOfWeek));
        View view = inflater.inflate(R.layout.day_list, container, false);
        ArrayList<Lesson> list = new ArrayList<Lesson>();
        for (int i = 0; i < 6; i++) {
            if (thisDay.type[i] != typeOfWeek && thisDay.type[i] != 3) {
                Lesson thisLesson = new Lesson(thisDay, i);
                list.add(thisLesson);
                Log.i("Subject ", BuildConfig.APPLICATION_ID);
            }

        }

        LessonAdapter adapter = new LessonAdapter(mContext, list);
        ListView listviewData = (ListView) view.findViewById(R.id.list);
        listviewData.setAdapter(adapter);
        return view;
    }

}
