package com.example.angel.viewpager2;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Angel on 10/03/2015.
 */
public class AspectRatioImageView extends ImageView {
    float aspectRatio = 2;

    public AspectRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (MeasureSpec.getSize(widthMeasureSpec)/aspectRatio), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
