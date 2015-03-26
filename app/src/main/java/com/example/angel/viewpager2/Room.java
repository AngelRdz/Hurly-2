package com.example.angel.viewpager2;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Angel on 18/03/2015.
 */
public class Room extends Celda{

    private String title;

    public Room(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }





    @Override
    public int layoutId() {
        return R.layout.room;
    }

    @Override
    public void adaptView(View view) {

        TextView titleTextView = (TextView) view.findViewById(R.id.mi_cuenta);
        titleTextView.setText(getTitle());
    }
}
