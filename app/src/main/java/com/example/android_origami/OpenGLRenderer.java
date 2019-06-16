package com.example.android_origami;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.util.Log;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLRenderer implements GLSurfaceView.Renderer {
    private Triangle triangle=new Triangle();
    private part_1 part_1=new part_1();
    private part_1_2 part_1_2=new part_1_2();
    private part_1_3 part_1_3=new part_1_3();
    private part_2 part_2=new part_2();
    private part_3 part_3=new part_3();
    private part_4 part_4=new part_4();
    private part_5 part_5=new part_5();
    private part_6 part_6=new part_6();
    private part_7 part_7=new part_7();
    private part_8 part_8=new part_8();
    private part_9 part_9=new part_9();
    private part_10 part_10=new part_10();
    private part_11 part_11=new part_11();
    private part_12 part_12=new part_12();
    private part_13 part_13=new part_13();
    private part_13_2 part_13_2=new part_13_2();
    private part_13_3 part_13_3=new part_13_3();

    private float angle1 = 135f;
    private float angle2 = 90;
    private float angle3a = 45f;
    private float angle3b = 0;
    private float angle4 = 45f;
    private float angle5a = 90f;
    private double angle5b_double = MainActivity.angle(0, 0, 20, 25);
    private float angle5b=(float) angle5b_double;
    private double angle6_double = 90f + MainActivity.angle(0, 0, 25, 20);
    private float angle6=(float) angle6_double;
    private float angle7 = 0;
    private float angle8 = 0;
    private float angle9a = 45f;
    private float angle9b = 0;
    private float angle10 = 45f;
    private double angle11_double = 90f + MainActivity.angle(0, 0, 20, 25);
    private float angle11=(float) angle11_double;
    private float angle12a = 0;
    private double angle12b_double = -( 90f + MainActivity.angle(0, 0, 20, 25) );
    private float angle12b=(float) angle12b_double;
    private float angle13 = 135f;


    public static float xRot;
    public static float yRot;
    public static float zRot;
    public static float rotation;
    public static float totalangle=0.0f;
    public static float flip = 0.0f ;
    public static float flip1  = 0.0f;
    public static float flip2 = 0.0f ;
    public static float flip3 = 0.0f ;
    public static float flip4 = 0.0f ;
    public static float flip5 = 0.0f ;
    public static float flip6 = 0.0f ;
    public static float flip7  = 0.0f;
    public static float flip8  = 0.0f;
    public static int step1=1 ;
    public static int step2=0 ;
    public static int step3=0 ;
    public static int step4=0 ;
    public static int step5=0 ;
    public static int step6=0 ;
    public static int step7=0 ;
    public static int step8=0 ;
    public static int finish=0 ;



    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        // Depth buffer setup.
        gl.glClearDepthf(1.0f);
        // Enables depth testing.
        gl.glEnable(GL10.GL_DEPTH_TEST);
        // The type of depth testing to do.
        gl.glDepthFunc(GL10.GL_LEQUAL);
        // Really nice perspective calculations.
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);


        // add the following two so that the alpha value of glColor4f can be enabled
        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE);

        Log.d("onSurfaceCreated","Finished");

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // Sets the current view port to the new size.
        gl.glViewport(0, 0, width, height);
        // Select the projection matrix
        gl.glMatrixMode(GL10.GL_PROJECTION);
        // Reset the projection matrix
        gl.glLoadIdentity();
        // Calculate the aspect ratio of the window
        GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f, 100.0f);
        // Select the modelview matrix
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        // Reset the modelview matrix
        gl.glLoadIdentity();
        Log.d("onSurfaceChanged","Finished");
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        Log.d("OnDrawFrame: ","triangle");
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        /* Testing with Triangle
        gl.glTranslatef(0.0f, 0.0f, -4.0f);
        gl.glRotatef(rotation, 0f,0f,1f);
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        // gl.glScalef(10f,10f,1f);
        triangle.draw(gl);
        */

        // Handling Keys below
        if(MainActivity.play_button_pressed==true)
        {
            //rotation+=MainActivity.temp;
            flip+=MainActivity.play_speed;
            totalangle=flip;
        }

        if (totalangle <= 180f && totalangle >= 0f)
        {
            step1 = 1;
            flip1 = flip;
        }

        if (totalangle >= 181f && totalangle <= 180f * 2f)
        {
            step1 = 0;
            step2 = 1;
            flip2 = flip - 180f * 1f;

        }

        if (totalangle >= 180f* 2f + 1f && totalangle <= 180f * 3f)
        {
            step2 = 0;
            step3 = 1;
            flip3 = flip - 180f * 2f;

        }
        if (totalangle >= 180f * 3f + 1f && totalangle <= 180f * 4f)
        {
            step3 = 0;
            step4 = 1;
            flip4 = flip - 180f * 3f;

        }
        if (totalangle >= 180f * 4f + 1f && totalangle <= 180f * 5f)
        {
            step4 = 0;
            step5 = 1;
            flip5 = flip - 180f * 4f;

        }
        if (totalangle>180 * 5 && totalangle <= 180 * 6)
        {
            step5 = 0;
            step6 = 1;
            flip6 = flip - 180f * 5f;

        }
        if (totalangle>180f * 6f && totalangle <= 180f* 7f)
        {
            step6 = 0;
            step7 = 1;
            flip7 = flip - 180f * 6f;

        }
        if (totalangle>180f * 7f && totalangle <= 180f * 8f)
        {
            step7 = 0;
            step8 = 1;
            flip8 = flip - 180f * 7f;
        }
        if (totalangle >= 180f * 8f)
        {
            finish = 1;
        }
        if(MainActivity.plus_x_pressed==true)
        {
            xRot+=MainActivity.temp_rotate;
        }

        if(MainActivity.minus_x_pressed==true)
        {
            xRot-=MainActivity.temp_rotate;
        }

        if(MainActivity.plus_y_pressed==true)
        {
            yRot -= MainActivity.temp_rotate;
        }

        if(MainActivity.minus_y_pressed==true)
        {
            yRot += MainActivity.temp_rotate;
        }

        if(MainActivity.plus_z_pressed==true)
        {
            zRot -= MainActivity.temp_rotate;
        }

        if(MainActivity.minus_z_pressed==true)
        {
            zRot += MainActivity.temp_rotate;
        }
        // Handling Keys above


        gl.glPushMatrix();

        gl.glTranslatef(0f,0f, -3.5f);
        gl.glRotatef(xRot, -100f*MainActivity.scale_factor, 0.0f, 0.0f);
        gl.glRotatef(yRot, 0.0f, -100f*MainActivity.scale_factor, 0.0f);
        gl.glRotatef(zRot, 0.0f, 0.0f, 1.0f);

        // gl.glTranslatef(-100f*MainActivity.scale_factor, -100f*MainActivity.scale_factor, -3.0f);
        gl.glTranslatef(-100f*MainActivity.scale_factor, -100f*MainActivity.scale_factor, 0.0f);
        gl.glRotatef(rotation, 0f,0f,1f);


        // part 1 below
        gl.glPushMatrix();
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        if(step1==1 || step2==1)
        {

            gl.glTranslatef(215f * MainActivity.scale_factor, 190f * MainActivity.scale_factor, 0f);
            gl.glRotatef(-flip3, 0, 1, 0);
            //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
            part_1.draw(gl);
        }

        if (step3 == 1)
        {
            gl.glColor4f( 1f, 1f, 1f, 1f);
            gl.glTranslatef(130f * MainActivity.scale_factor, 190f * MainActivity.scale_factor, 0f);
            gl.glRotatef(-flip3, 0, 1, 0);
            //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
            part_1_2.draw(gl);
        }
        if (step4 == 1)
        {
            gl.glTranslatef(130f * MainActivity.scale_factor, 190f * MainActivity.scale_factor, 0f);
            gl.glRotatef(-180f, 0, 1, 0);
            //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
            part_1_2.draw(gl);
        }
        if(step5 == 1 )
        {
            gl.glTranslatef(130f * MainActivity.scale_factor, 190f * MainActivity.scale_factor, 0f);
            gl.glRotatef(-180f, 0, 1, 0);
            //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
            part_1_2.draw(gl);
        }
        if(step6==1)
        {
            gl.glTranslatef(130f * MainActivity.scale_factor, 190f * MainActivity.scale_factor, 0f);
            gl.glRotatef(-180f, 0, 1, 0);
            //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
            part_1_2.draw(gl);
        }
        if (step7==1)
        {
            gl.glColor4f( 1f, 1f, 1f, 1f);
            gl.glTranslatef((130f - 85f)* MainActivity.scale_factor, (20f + 85f + 85f)* MainActivity.scale_factor, 0);
            gl.glRotatef(-45, 0, 0, 1);
            gl.glRotatef(flip7, 0, 1, 0);
            gl.glRotatef(45, 0, 0, 1);
            // gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
            part_1_3.draw(gl);

        }
        if (step8==1)
        {
            gl.glTranslatef((130f - 85f)* MainActivity.scale_factor, (20f + 85f + 85f)* MainActivity.scale_factor, 0);
            gl.glRotatef(-45, 0, 0, 1);
            gl.glRotatef(180, 0, 1, 0);
            gl.glRotatef(45, 0, 0, 1);
            //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
            part_1_3.draw(gl);

        }
        gl.glPopMatrix();
        // part 1 above

        // part 2 below
        gl.glPushMatrix();
        gl.glColor4f( 1f,0f,0f, 1f);
        gl.glTranslatef(130f * MainActivity.scale_factor, 85f * MainActivity.scale_factor, 0f);

        if (step3 == 1)
        {
            gl.glColor4f( 1f, 1f, 1f, 1f);
            gl.glRotatef(angle2, 0, 0, 1);
            gl.glRotatef(-flip3, 1, 0, 0);
            gl.glRotatef(-angle2, 0, 0, 1);
        }
        if (step4 == 1)
        {
            gl.glRotatef(angle2, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle2, 0, 0, 1);
        }
        if (step5 == 1 || step6 == 1 || step7 == 1 || step8 == 1)
        {
            gl.glRotatef(angle2, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle2, 0, 0, 1);
        }

        //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_2.draw(gl);

        gl.glPopMatrix();
        // part 2 above

        // part 3 below
        gl.glPushMatrix();
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(130f * MainActivity.scale_factor,85f * MainActivity.scale_factor,0f );
        if (step2 == 1)
        {
            gl.glColor4f( 1f, 1f, 1f, 1f);
            gl.glRotatef(angle3a, 0, 0, 1);
            gl.glRotatef(-flip2, 1, 0, 0);
            gl.glRotatef(-angle3a, 0, 0, 1);
        }

        if (step3 == 1)
        {

            gl.glRotatef(angle3a, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle3a, 0, 0, 1);

            gl.glRotatef(angle3b, 0, 0, 1);
            gl.glRotatef(-flip3, 1, 0, 0);
            gl.glRotatef(-angle3b, 0, 0, 1);

        }
        if (step4 == 1)
        {
            gl.glRotatef(angle3a, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle3a, 0, 0, 1);

            gl.glRotatef(angle3b, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle3b, 0, 0, 1);
        }
        if (step5 == 1 || step6 == 1 || step7 == 1 || step8 == 1)
        {
            gl.glRotatef(angle3a, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle3a, 0, 0, 1);

            gl.glRotatef(angle3b, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle3b, 0, 0, 1);
        }
        //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_3.draw(gl);
        gl.glPopMatrix();
        // part 3 above

        // part 4 below
        gl.glPushMatrix();
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(130f * MainActivity.scale_factor,85f * MainActivity.scale_factor,0f );
        if (step2 == 1)
        {
            gl.glColor4f( 1f, 1f, 1f, 1f);
            gl.glRotatef(angle4, 0, 0, 1);
            gl.glRotatef(-flip2, 1, 0, 0);
            gl.glRotatef(-angle4, 0, 0, 1);
        }
        if (step3 == 1)
        {
            gl.glRotatef(angle4, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle4, 0, 0, 1);
        }
        if (step4 == 1)
        {
            gl.glRotatef(angle4, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle4, 0, 0, 1);
        }
        if (step5 == 1 || step6 == 1 || step7 == 1 || step8 == 1)
        {
            gl.glRotatef(angle4, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle4, 0, 0, 1);
        }
        //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_4.draw(gl);
        gl.glPopMatrix();
        // part 4 above

        // part 5 below
        gl.glPushMatrix();
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(130f * MainActivity.scale_factor,190f * MainActivity.scale_factor,0f );
        if (step3 == 1)
        {
            gl.glColor4f( 1f, 1f, 1f, 1f);
            gl.glRotatef(angle5a, 0, 0, 1);
            gl.glRotatef(-flip3, 1, 0, 0);
            gl.glRotatef(-angle5a, 0, 0, 1);
        }
        if (step4 == 1)
        {
            gl.glRotatef(angle5a, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle5a, 0, 0, 1);
        }
        if (step5 == 1)
        {
            gl.glColor4f( 1f, 1f, 1f, 1f);
            gl.glRotatef(angle5a, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle5a, 0, 0, 1);

            gl.glRotatef(angle5b, 0, 0, 1);
            gl.glRotatef(-flip5, 1, 0, 0);
            gl.glRotatef(-angle5b, 0, 0, 1);

        }
        if (step6 == 1 || step7 == 1 || step8 == 1)
        {
            gl.glRotatef(angle5a, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle5a, 0, 0, 1);

            gl.glRotatef(angle5b, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle5b, 0, 0, 1);
        }
        //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_5.draw(gl);
        gl.glPopMatrix();
        // part 5 above

        // part 6 below
        gl.glPushMatrix();
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(130f * MainActivity.scale_factor,190f * MainActivity.scale_factor,0f );
        if (step5 == 1)
        {
            gl.glColor4f( 1f, 1f, 1f, 1f);
            gl.glRotatef(angle6, 0, 0, 1);
            gl.glRotatef(-flip5, 1, 0, 0);
            gl.glRotatef(-angle6, 0, 0, 1);
        }
        if (step6 == 1 || step7 == 1 || step8 == 1)
        {
            gl.glRotatef(angle6, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle6, 0, 0, 1);
        }

        //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_6.draw(gl);
        gl.glPopMatrix();
        // part 6 above

        // part 7 below
        gl.glPushMatrix();
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(130f * MainActivity.scale_factor,85f * MainActivity.scale_factor,0f );
        //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_7.draw(gl);
        gl.glPopMatrix();
        // part 7 above

        // part 8 below
        gl.glPushMatrix();
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(130f * MainActivity.scale_factor,85f * MainActivity.scale_factor,0f );
        if (step4 == 1)
        {
            gl.glColor4f( 1f, 1f, 1f, 1f);
            gl.glRotatef(-flip4, 1, 0, 0);
        }
        if (step5 == 1 || step6 == 1 || step7 == 1 || step8 == 1)
        {
            gl.glRotatef(-180, 1, 0, 0);
        }
        //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_8.draw(gl);
        gl.glPopMatrix();
        // part 8 above

        // part 9 below
        gl.glPushMatrix();
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(130f * MainActivity.scale_factor,85f * MainActivity.scale_factor,0f );
        if (step2 == 1)
        {
            gl.glColor4f( 1f, 1f, 1f, 1f);
            gl.glRotatef(angle9a, 0, 0, 1);
            gl.glRotatef(-flip2, 1, 0, 0);
            gl.glRotatef(-angle9a, 0, 0, 1);
        }
        if (step3 == 1)
        {
            gl.glRotatef(angle9a, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle9a, 0, 0, 1);

        }
        if (step4 == 1)
        {
            gl.glRotatef(angle9a, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle9a, 0, 0, 1);

            gl.glRotatef(angle9b, 0, 0, 1);
            gl.glRotatef(-flip4, 0, 1, 0);
            gl.glRotatef(-angle9b, 0, 0, 1);

        }
        if (step5 == 1 || step6 == 1 || step7 == 1 || step8 == 1)
        {
            gl.glRotatef(angle9a, 0, 0, 1);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(-angle9a, 0, 0, 1);

            gl.glRotatef(angle9b, 0, 0, 1);
            gl.glRotatef(-180, 0, 1, 0);
            gl.glRotatef(-angle9b, 0, 0, 1);
        }
        //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_9.draw(gl);
        gl.glPopMatrix();
        // part 9 above

        // part 10 below
        gl.glPushMatrix();
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(0f * MainActivity.scale_factor,105f * MainActivity.scale_factor,0f );

        if (step1==1)
        {
            if(totalangle!=0) {
                gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                //Toast toast = Toast.makeText(this, "Start!", Toast.LENGTH_LONG);
                //toast.show();
            }
            gl.glRotatef(angle10,0,0,1f);
            gl.glRotatef(flip1, 1f, 0, 0);
            gl.glRotatef(-angle10, 0, 0, 1);
        }
        if (step2 == 1 || step3 == 1 || step4 == 1 || step5 == 1 || step6 == 1 || step7 == 1 || step8 == 1)
        {
            gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
            gl.glRotatef(angle10, 0, 0, 1);
            gl.glRotatef(180, 1, 0, 0);
            gl.glRotatef(-angle10, 0, 0, 1);
        }
        //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_10.draw(gl);
        gl.glPopMatrix();
        // part 10 above

        // part 11 below
        gl.glPushMatrix();
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(25f * MainActivity.scale_factor,85f * MainActivity.scale_factor,0f );
        if (step6 == 1)
        {
            gl.glColor4f( 1f, 1f, 1f, 1f);
            gl.glRotatef(angle11, 0, 0, 1);
            gl.glRotatef(flip6, 1, 0, 0);
            gl.glRotatef(-angle11, 0, 0, 1);
        }
        if (step7 == 1 || step8 == 1)
        {
            gl.glRotatef(angle11, 0, 0, 1);
            gl.glRotatef(180, 1, 0, 0);
            gl.glRotatef(-angle11, 0, 0, 1);
        }
        //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_11.draw(gl);
        gl.glPopMatrix();
        // part 11 above

        // part 12 below
        gl.glPushMatrix();
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(25f * MainActivity.scale_factor,85f * MainActivity.scale_factor,0f );
        if (step4 == 1)
        {
            gl.glColor4f( 1f, 1f, 1f, 1f);
            gl.glRotatef(-flip4, 1, 0, 0);
        }
        if (step5 == 1)
        {
            gl.glRotatef(-180, 1, 0, 0);
        }
        if (step6 == 1)
        {
            gl.glColor4f( 1f, 1f, 1f, 1f);
            gl.glRotatef(-180, 1, 0, 0);
            gl.glRotatef(angle12b, 0, 0, 1);
            gl.glRotatef(flip6, 1, 0, 0);
            gl.glRotatef(-angle12b, 0, 0, 1);
        }

        if (step7 == 1 || step8 == 1)
        {
            gl.glRotatef(-180, 1, 0, 0);

            gl.glRotatef(angle12b, 0, 0, 1);
            gl.glRotatef(180, 1, 0, 0);
            gl.glRotatef(-angle12b, 0, 0, 1);
        }
        //gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_12.draw(gl);
        gl.glPopMatrix();
        // part 12 above

        // part 13 below
        gl.glPushMatrix();
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        if (step1 == 1 || step2 == 1 || step3 == 1)
        {
            gl.glTranslatef(25f * MainActivity.scale_factor, 0f * MainActivity.scale_factor, 0f);
            // gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
            part_13.draw(gl);
        }
        if (step4 == 1)
        {
            gl.glColor4f( 1f, 1f, 1f, 1f);
            gl.glTranslatef(25f* MainActivity.scale_factor, 85f* MainActivity.scale_factor, 0);
            gl.glRotatef(-flip4, 1, 0, 0);
            part_13_2.draw(gl);
        }

        if (step5 == 1 || step6 == 1 || step7 == 1)
        {
            gl.glTranslatef(25f* MainActivity.scale_factor, 85f* MainActivity.scale_factor, 0);
            gl.glRotatef(-180f, 1, 0, 0);
            part_13_2.draw(gl);
        }
        if (step8 == 1)
        {
            gl.glColor4f( 1f, 1f, 1f, 1f);
            if(totalangle >= 180f * 8f)
            {
                gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
            }
            gl.glTranslatef(0f* MainActivity.scale_factor, (85f * 2f - 25f) * MainActivity.scale_factor, 0);
            gl.glRotatef(-45, 0, 0, 1);
            gl.glRotatef(flip8, 0, 1, 0);
            gl.glRotatef(45, 0, 0, 1);
            part_13_3.draw(gl);
        }

        gl.glPopMatrix();
        // part 13 above


        gl.glPopMatrix();

        gl.glLoadIdentity();

    }

}
