package com.example.angel.viewpager2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
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

        Item item;
        final ListView milista = (ListView) rootView.findViewById(R.id.listView);

      //  final ImageView upvote = (ImageView) rootView.findViewById(R.id.post_upvote);
      //  final ImageView downvote = (ImageView) rootView.findViewById(R.id.post_downvote);

        milista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("click","");
            }
        });

        ArrayList<Celda> celdas = new ArrayList<>();

        celdas.add(new Item("The Legend of Zelda Majora's Mask", "Posted by Francisco", "2 weeks ago", 1800L, 117L, "Man", "1 day ago", "So I like to change the android fontFamily in Android but I don't...",R.drawable.majoras,0,1,"upvote"));
        celdas.add(new Item("The Legend of Zelda Ocarina of Time", "Posted by Emiliano", "3 weeks ago", 1830L, 167L, "Boy", "2 day ago", "So I like to change the android fontFamily in Android but I don't...",R.drawable.images,1,2,"downvote"));
        celdas.add(new Item("The Legend of Zelda Twilight Princess", "Posted by Alondra", "4 weeks ago", 433L, 67L, "Girl", "3 day ago", "So I like to change the android fontFamily in Android but I don't...",R.drawable.images1,2,1,"upvote"));
        celdas.add(new Item("The Legend of Zelda Windwaker", "Posted by Diana", "5 weeks ago", 180L, 967L, "Woman", "4 day ago", "So I like to change the android fontFamily in Android but I don't...",R.drawable.images2,3,2,"downvote"));
        celdas.add(new Item("The Legend of Zelda Skyward Sword", "Posted by Andrea", "6 weeks ago", 1145L, 767L, "Girl", "5 day ago", "So I like to change the android fontFamily in Android but I don't...",R.drawable.images3,4,1,"upvote"));
        celdas.add(new Item("The Legend of Zelda A Link to the Past", "Posted by Damián", "7 weeks ago", 1542L, 517L, "Boy", "6 day ago", "So I like to change the android fontFamily in Android but I don't...",R.drawable.images4,5,2,"downvote"));
        celdas.add(new Item("The Legend of Zelda Phantom Hourglass", "Posted by Lucia", "8 weeks ago", 541L, 412L, "Woman", "7 day ago", "So I like to change the android fontFamily in Android but I don't...",R.drawable.images5,6,1,"upvote"));
        milista.setAdapter(new MyAdapter(celdas));



        return rootView;
    }
}