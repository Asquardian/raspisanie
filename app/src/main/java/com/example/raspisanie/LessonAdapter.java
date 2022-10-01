package com.example.raspisanie;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LessonAdapter extends ArrayAdapter<Lesson> {
    private Context mContext;
    private List<Lesson> moviesList = new ArrayList<>();

    public LessonAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Lesson> list) {
        super(context, 0 , list);
        mContext = context;
        moviesList = list;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

        Lesson currentMovie = moviesList.get(position);

        TextView subject = (TextView) listItem.findViewById(R.id.subject);
        subject.setText(currentMovie.getSubject());

        TextView teacher = (TextView) listItem.findViewById(R.id.teacher);
        teacher.setText(currentMovie.getTeacher());

        TextView place = (TextView) listItem.findViewById(R.id.place);
        place.setText(currentMovie.getPlace());

        TextView time = (TextView) listItem.findViewById(R.id.time);
        time.setText(currentMovie.getTimeOf());

        return listItem;
    }
}

