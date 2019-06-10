package com.example.android_origami;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import java.util.jar.Attributes;

public class OpenGLView extends GLSurfaceView {
    private  OpenGLRenderer mRenderer;

    public OpenGLView(Context context){
        super(context);
        init();

    }
    public OpenGLView(Context context, AttributeSet attrs){
        super(context,attrs);
        init();
    }
    private void init(){
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        mRenderer=new OpenGLRenderer();
        //setRenderer(new OpenGLRenderer());
        setRenderer(mRenderer);

        //setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mPreviousX;
    private float mPreviousY;

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        float x = e.getX();
        float y = e.getY();

        Log.d("click x: ",Float.toString(x));
        Log.d("click y: ",Float.toString(y));

        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:

                float dx = x - mPreviousX;
                float dy = y - mPreviousY;

                // reverse direction of rotation above the mid-line
                if (y > getHeight() / 2) {
                    dx = dx * -1 ;
                }

                // reverse direction of rotation to left of the mid-line
                if (x < getWidth() / 2) {
                    dy = dy * -1 ;
                }

                mRenderer.setAngle(
                        mRenderer.getAngle() +
                                ((dx + dy) * TOUCH_SCALE_FACTOR));  // = 180.0f / 320
                requestRender();
        }

        mPreviousX = x;
        mPreviousY = y;
        return true;
    }
}
