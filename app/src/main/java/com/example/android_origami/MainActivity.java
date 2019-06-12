package com.example.android_origami;

import android.graphics.Path;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    public static float temp=5f;
    public static float temp_rotate=5f;
    public static float scale_factor=0.01f;

    public static boolean play_button_pressed=false;
    public static boolean plus_x_pressed=false;
    public static boolean minus_x_pressed=false;
    public static boolean plus_y_pressed=false;
    public static boolean minus_y_pressed=false;
    public static boolean plus_z_pressed=false;
    public static boolean minus_z_pressed=false;

    private Button button_forward;
    private Button  button_plus_x ;
    private Button  button_plus_y ;
    private Button  button_plus_z ;
    private Button  button_minus_x ;
    private Button  button_minus_y ;
    private Button  button_minus_z ;

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

        button_forward=findViewById(R.id.button_forward);

        button_plus_x=findViewById(R.id.button_plue_x);
        button_minus_x=findViewById(R.id.button_minus_x);
        button_plus_y=findViewById(R.id.button_plus_y);
        button_minus_y=findViewById(R.id.button_minus_y);
        button_plus_z=findViewById(R.id.button_plus_z);
        button_minus_z=findViewById(R.id.button_minus_z);

        button_forward.setOnTouchListener( new ontouch_play_forward() );
        button_plus_x.setOnTouchListener( new ontouch_plus_x() );
        button_minus_x.setOnTouchListener( new ontouch_minus_x() );
        button_plus_y.setOnTouchListener( new ontouch_plus_y() );
        button_minus_y.setOnTouchListener( new ontouch_minus_y() );
        button_plus_z.setOnTouchListener( new ontouch_plus_z() );
        button_minus_z.setOnTouchListener( new ontouch_minus_z() );
        //button_forward.setOnClickListener( new play_forward());

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
    //public native String stringFromJNI();

    private class ontouch_play_forward implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            Log.d("In OnTouchListener","onTouch");

            if(motionEvent.getAction() == MotionEvent.ACTION_UP)
            {
                Log.d("In OnTouchListener","ACTION_UP");
                /*
                while (true) {
                    OpenGLRenderer.rotation = OpenGLRenderer.rotation - temp;
                }
                */
                play_button_pressed=false;
            }
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
            {
                Log.d("In OnTouchListener","ACTION_DOWN");
                play_button_pressed=true;
            }
            return true;
        }
    }

    private class ontouch_plus_x implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if(motionEvent.getAction() == MotionEvent.ACTION_UP)
            {
                Log.d("In OnTouchListener","ACTION_UP");
                /*
                while (true) {
                    OpenGLRenderer.rotation = OpenGLRenderer.rotation - temp;
                }
                */
                plus_x_pressed=false;
            }
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
            {
                Log.d("In OnTouchListener","ACTION_DOWN");
                plus_x_pressed=true;
            }
            return true;
        }
    }

    private class ontouch_minus_x implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if(motionEvent.getAction() == MotionEvent.ACTION_UP)
            {
                Log.d("In OnTouchListener","ACTION_UP");
                /*
                while (true) {
                    OpenGLRenderer.rotation = OpenGLRenderer.rotation - temp;
                }
                */
                minus_x_pressed=false;
            }
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
            {
                Log.d("In OnTouchListener","ACTION_DOWN");
                minus_x_pressed=true;
            }
            return true;
        }
    }

    private class ontouch_plus_y implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if(motionEvent.getAction() == MotionEvent.ACTION_UP)
            {
                Log.d("In OnTouchListener","ACTION_UP");
                /*
                while (true) {
                    OpenGLRenderer.rotation = OpenGLRenderer.rotation - temp;
                }
                */
                plus_y_pressed=false;
            }
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
            {
                Log.d("In OnTouchListener","ACTION_DOWN");
                plus_y_pressed=true;
            }
            return true;
        }
    }

    private class ontouch_minus_y implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if(motionEvent.getAction() == MotionEvent.ACTION_UP)
            {
                Log.d("In OnTouchListener","ACTION_UP");
                /*
                while (true) {
                    OpenGLRenderer.rotation = OpenGLRenderer.rotation - temp;
                }
                */
                minus_y_pressed=false;
            }
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
            {
                Log.d("In OnTouchListener","ACTION_DOWN");
                minus_y_pressed=true;
            }
            return true;
        }
    }

    private class ontouch_plus_z implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if(motionEvent.getAction() == MotionEvent.ACTION_UP)
            {
                Log.d("In OnTouchListener","ACTION_UP");
                /*
                while (true) {
                    OpenGLRenderer.rotation = OpenGLRenderer.rotation - temp;
                }
                */
                plus_z_pressed=false;
            }
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
            {
                Log.d("In OnTouchListener","ACTION_DOWN");
                plus_z_pressed=true;
            }
            return true;
        }
    }

    private class ontouch_minus_z implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if(motionEvent.getAction() == MotionEvent.ACTION_UP)
            {
                Log.d("In OnTouchListener","ACTION_UP");
                /*
                while (true) {
                    OpenGLRenderer.rotation = OpenGLRenderer.rotation - temp;
                }
                */
                minus_z_pressed=false;
            }
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
            {
                Log.d("In OnTouchListener","ACTION_DOWN");
                minus_z_pressed=true;
            }
            return true;
        }
    }
    public void play_reset(View view) {
        OpenGLRenderer.xRot=0f;
        OpenGLRenderer.yRot=0f;
        OpenGLRenderer.zRot=0f;
        OpenGLRenderer.rotation=0f;
    }

    /*
    public void plus_x(View view) {
        OpenGLRenderer.xRot+=temp_rotate;
    }

    public void minus_x(View view) {
        OpenGLRenderer.xRot-=temp_rotate;
    }

    public void plus_y(View view) {
        OpenGLRenderer.yRot+=temp_rotate;
    }

    public void minus_y(View view) {
        OpenGLRenderer.yRot-=temp_rotate;
    }

    public void plus_z(View view) {
        OpenGLRenderer.zRot+=temp_rotate;
    }

    public void minus_z(View view) {
        OpenGLRenderer.zRot-=temp_rotate;
    }
    */
}
