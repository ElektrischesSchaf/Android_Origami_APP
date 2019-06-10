package com.example.android_origami;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // 01
    //private OpenGLView openGLView;
    public static float offset1=85;
    public static float scale_heart=0.01f;
    private OpenGLView mainSurfaceview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 01
        //setContentView(R.layout.activity_main);
        //openGLView=(OpenGLView)  findViewById(R.id.openGLView_1);
        mainSurfaceview=new OpenGLView(this);
        this.setContentView(mainSurfaceview);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //01
        //openGLView.onResume();

        mainSurfaceview.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        //01
        //openGLView.onPause();

        mainSurfaceview.onPause();
    }
}
