package com.example.angel.viewpager2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;

/**
 * Created by Angel on 25/03/2015.
 */
public class PostingActivity extends FragmentActivity {

    int x = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posting_layout);

        AspectRatioImageView imageView = (AspectRatioImageView) findViewById(R.id.posting_image);
        final ImageView check = (ImageView) findViewById(R.id.checkbox);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x == 0) {
                    check.setImageResource(R.drawable.checked_box);
                    x = 1;
                } else {
                    check.setImageResource(R.drawable.unchecked_box);
                    x = 0;
                }
            }
        });

        imageView.setAspectRatio(1f * 460 / 575);

        Ion.with(imageView).load("http://img-9gag-ftw.9cache.com/photo/adYv0y2_460s.jpg");
    }
}
