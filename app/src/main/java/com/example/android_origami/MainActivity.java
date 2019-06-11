package com.example.android_origami;

import android.graphics.Path;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private float temp=5f;


    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private  GLSurfaceView view = null;

    /* Select the Renderer to Show (1 to 4) */
    int RenderObj = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        initGLSurface();

    }

    void initGLSurface(){
        view = new GLSurfaceView(this);

        if(RenderObj == 1) {
            view.setRenderer(new OpenGLRenderer());
        }
        if(RenderObj == 2) {
            view.setEGLContextClientVersion(2); //Required when using OpenGL 2
      //      view.setRenderer(new DemoRenderer2());
        }
        if(RenderObj == 3) {
        //    view.setRenderer(new Obj3DRenderer(this));
        }
        if(RenderObj == 4) {
        //    view.setRenderer(new ObjRenderer(this));
        }

        FrameLayout mainFrame = (FrameLayout) findViewById(R.id.glFrame);
        mainFrame.addView(view);

    }

    @Override
    protected void onPause() {
        super.onPause();
        view.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        view.onResume();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public void play_forward(View view) {
        OpenGLRenderer.rotation= OpenGLRenderer.rotation+temp;
    }

    public void play_backward(View view) {
        OpenGLRenderer.rotation= OpenGLRenderer.rotation-temp;

    }
}
