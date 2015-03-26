package com.example.angel.viewpager2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.getbase.floatingactionbutton.CustomFam;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.viewpagerindicator.TabPageIndicator;
import java.util.ArrayList;


public class MainActivity extends FragmentActivity {

    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;
    TabPageIndicator indicator;
    RelativeLayout actividad;
    FrameLayout menubtn;
    FloatingActionButton fab;
    CustomFam Cfam;
    View floatingview;
    int x;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), this);
        actividad = (RelativeLayout) findViewById(R.id.relative);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        indicator = (TabPageIndicator)findViewById(R.id.indicator);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        indicator.setViewPager(mViewPager);
        menubtn = (FrameLayout) findViewById(R.id.menu_frame);
        fab = (FloatingActionButton) findViewById(R.id.action_a);
        Cfam = (CustomFam) findViewById(R.id.multiple_actions);
        floatingview = findViewById(R.id.floating_view);

        floatingview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cfam.toggle();
                Cfam.getmAddButton().setIcon(com.example.angel.viewpager2.R.drawable.pencil_ico);
                x = 0;
                ObjectAnimator alpha = ObjectAnimator.ofFloat(floatingview,"alpha", 0.85f, 0.0f);
                alpha.setDuration(500);
                alpha.start();
                alpha.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) { }
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        floatingview.setVisibility(View.INVISIBLE);
                    }
                    @Override
                    public void onAnimationCancel(Animator animation) {}
                    @Override
                    public void onAnimationRepeat(Animator animation) {}
                });
            }
        });

        Cfam.getmAddButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x == 0) {
                    Cfam.toggle();
                    Cfam.getmAddButton().setIcon(R.drawable.gallery_ico);
                    x = 1;
                    floatingview.setVisibility(View.VISIBLE);
                    ObjectAnimator alpha = ObjectAnimator.ofFloat(floatingview,"alpha", 0.0f, 0.85f);
                    alpha.setDuration(500);
                    alpha.start();

                } else if (x == 1) {
                    Cfam.toggle();
                    Cfam.getmAddButton().setIcon(com.example.angel.viewpager2.R.drawable.pencil_ico);
                    x = 0;
                    ObjectAnimator alpha = ObjectAnimator.ofFloat(floatingview,"alpha", 0.85f, 0.0f);
                    alpha.setDuration(500);
                    alpha.start();
                    alpha.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) { }
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            floatingview.setVisibility(View.INVISIBLE);
                        }
                        @Override
                        public void onAnimationCancel(Animator animation) { }
                        @Override
                        public void onAnimationRepeat(Animator animation) { }
                    });
                }
            }
        });

        final SlidingMenu menu =  new SlidingMenu(this);

        menu.setOnCloseListener(new SlidingMenu.OnCloseListener() {
            @Override
            public void onClose() {
                ObjectAnimator alpha = ObjectAnimator.ofFloat(actividad,"alpha", 0.65f, 1.0f);
                alpha.setDuration(500);
                alpha.start();
            }
        });
        menu.setOnOpenListener(new SlidingMenu.OnOpenListener() {
            @Override
            public void onOpen() {
                ObjectAnimator alpha = ObjectAnimator.ofFloat(actividad,"alpha", 1.0f, 0.65f);
                alpha.setDuration(500);
                alpha.start();
            }
        });

        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0)
                    menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                else
                    menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
            }
            @Override
            public void onPageSelected(int position) {}
            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.sliding_menu_shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        menu.setMenu(R.layout.sliding_menu);

        ListView rooms = (ListView) menu.findViewById(R.id.listViewMenu);

        ArrayList<Celda> celdaMenu = new ArrayList<>();
        celdaMenu.add(new Room("Mi Cuenta"));
        rooms.setAdapter(new MyAdapter(celdaMenu));

        menubtn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle(true);
            }
        });

        final Intent posting = new Intent(this, PostingActivity.class);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(posting);
            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


}
