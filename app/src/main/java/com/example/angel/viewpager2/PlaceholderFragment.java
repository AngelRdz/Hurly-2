package com.example.angel.viewpager2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Angel on 09/03/2015.
 */
public class PlaceholderFragment extends Fragment{
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
        private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ListView milista = (ListView) rootView.findViewById(R.id.listView);
        milista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("click","");
            }
        });
          ArrayList<Celda> celdas = new ArrayList<>();

          celdas.add(new Item("The Legend of Zelda Majora's Mask", "Posted by Angel", "2 weeks ago", 1800L, 467L, "Stallon", "1 day ago", "asdfgñlkjhqwert poiuyzxcvb asdfgasdfasdfadf asdfasdfasdfasdf asdfsdfa asdfa asdfasdfasdfasdf asrqwerqwer zs vsdfasdf asfdsdfasdfasdfasdf.,nmnñlkjh asdfg poiuyqwert asdfg ñlkjhzxcvb",R.drawable.majoras,0));
          celdas.add(new Item("The Legend of Zelda Majora's Mask", "Posted by Angel", "2 weeks ago", 1800L, 467L, "Stallon", "1 day ago", "asdfgñlkjhqwert poiuyzxcvb asdfgasdfasdfadf asdfasdfasdfasdf asdfsdfa asdfa asdfasdfasdfasdf asrqwerqwer zs vsdfasdf asfdsdfasdfasdfasdf.,nmnñlkjh asdfg poiuyqwert asdfg ñlkjhzxcvb",R.drawable.images,1));
          celdas.add(new Item("The Legend of Zelda Majora's Mask", "Posted by Angel", "2 weeks ago", 1800L, 467L, "Stallon", "1 day ago", "asdfgñlkjhqwert poiuyzxcvb asdfgasdfasdfadf asdfasdfasdfasdf asdfsdfa asdfa asdfasdfasdfasdf asrqwerqwer zs vsdfasdf asfdsdfasdfasdfasdf.,nmnñlkjh asdfg poiuyqwert asdfg ñlkjhzxcvb",R.drawable.images1,2));
          celdas.add(new Item("The Legend of Zelda Majora's Mask", "Posted by Angel", "2 weeks ago", 1800L, 467L, "Stallon", "1 day ago", "asdfgñlkjhqwert poiuyzxcvb asdfgasdfasdfadf asdfasdfasdfasdf asdfsdfa asdfa asdfasdfasdfasdf asrqwerqwer zs vsdfasdf asfdsdfasdfasdfasdf.,nmnñlkjh asdfg poiuyqwert asdfg ñlkjhzxcvb",R.drawable.images2,3));
          celdas.add(new Item("The Legend of Zelda Majora's Mask", "Posted by Angel", "2 weeks ago", 1800L, 467L, "Stallon", "1 day ago", "asdfgñlkjhqwert poiuyzxcvb asdfgasdfasdfadf asdfasdfasdfasdf asdfsdfa asdfa asdfasdfasdfasdf asrqwerqwer zs vsdfasdf asfdsdfasdfasdfasdf.,nmnñlkjh asdfg poiuyqwert asdfg ñlkjhzxcvb",R.drawable.images3,4));
        celdas.add(new Item("The Legend of Zelda Majora's Mask", "Posted by Angel", "2 weeks ago", 1800L, 467L, "Stallon", "1 day ago", "asdfgñlkjhqwert poiuyzxcvb asdfgasdfasdfadf asdfasdfasdfasdf asdfsdfa asdfa asdfasdfasdfasdf asrqwerqwer zs vsdfasdf asfdsdfasdfasdfasdf.,nmnñlkjh asdfg poiuyqwert asdfg ñlkjhzxcvb",R.drawable.images4,5));
        celdas.add(new Item("The Legend of Zelda Majora's Mask", "Posted by Angel", "2 weeks ago", 1800L, 467L, "Stallon", "1 day ago", "asdfgñlkjhqwert poiuyzxcvb asdfgasdfasdfadf asdfasdfasdfasdf asdfsdfa asdfa asdfasdfasdfasdf asrqwerqwer zs vsdfasdf asfdsdfasdfasdfasdf.,nmnñlkjh asdfg poiuyqwert asdfg ñlkjhzxcvb",R.drawable.images5,6));
          milista.setAdapter(new MyAdapter(celdas));

//        TextView label = (TextView) rootView.findViewById(R.id.section_label);
//
//        label.setText("Hola Mundo View Pager");


        return rootView;
    }
}