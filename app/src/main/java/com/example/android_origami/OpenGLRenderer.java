package com.example.android_origami;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLRenderer implements GLSurfaceView.Renderer {
    private Triangle triangle=new Triangle();
    private part_1 part_1=new part_1();
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


    public static float xRot;
    public static float yRot;
    public static float zRot;
    public static float rotation;
    public static float flip3;
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


        gl.glPushMatrix();

        gl.glTranslatef(0f,0f, -3.0f);
        gl.glRotatef(xRot, -100f*MainActivity.scale_factor, 0.0f, 0.0f);
        gl.glRotatef(yRot, 0.0f, -100f*MainActivity.scale_factor, 0.0f);
        gl.glRotatef(zRot, 0.0f, 0.0f, 1.0f);

      //  gl.glTranslatef(-100f*MainActivity.scale_factor, -100f*MainActivity.scale_factor, -3.0f);
        gl.glTranslatef(-100f*MainActivity.scale_factor, -100f*MainActivity.scale_factor, 0.0f);
        gl.glRotatef(rotation, 0f,0f,1f);


        // part 1 below
        gl.glPushMatrix();
        gl.glTranslatef(130f * MainActivity.scale_factor,190f * MainActivity.scale_factor,0f );
        gl.glRotatef(-flip3, 0, 1, 0);
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_1.draw(gl);
        gl.glPopMatrix();
        // part 1 above

        // part 2 below
        gl.glPushMatrix();
        gl.glTranslatef(130f * MainActivity.scale_factor,85f * MainActivity.scale_factor,0f );
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_2.draw(gl);
        gl.glPopMatrix();
        // part 2 above

        // part 3 below
        gl.glPushMatrix();
        gl.glTranslatef(130f * MainActivity.scale_factor,85f * MainActivity.scale_factor,0f );
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_3.draw(gl);
        gl.glPopMatrix();
        // part 3 above

        // part 4 below
        gl.glPushMatrix();
        gl.glTranslatef(130f * MainActivity.scale_factor,85f * MainActivity.scale_factor,0f );
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_4.draw(gl);
        gl.glPopMatrix();
        // part 4 above

        // part 5 below
        gl.glPushMatrix();
        gl.glTranslatef(130f * MainActivity.scale_factor,190f * MainActivity.scale_factor,0f );
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_5.draw(gl);
        gl.glPopMatrix();
        // part 5 above

        // part 6 below
        gl.glPushMatrix();
        gl.glTranslatef(130f * MainActivity.scale_factor,190f * MainActivity.scale_factor,0f );
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_6.draw(gl);
        gl.glPopMatrix();
        // part 6 above

        // part 7 below
        gl.glPushMatrix();
        gl.glTranslatef(130f * MainActivity.scale_factor,85f * MainActivity.scale_factor,0f );
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_7.draw(gl);
        gl.glPopMatrix();
        // part 7 above

        // part 8 below
        gl.glPushMatrix();
        gl.glTranslatef(130f * MainActivity.scale_factor,85f * MainActivity.scale_factor,0f );
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_8.draw(gl);
        gl.glPopMatrix();
        // part 8 above

        // part 9 below
        gl.glPushMatrix();
        gl.glTranslatef(130f * MainActivity.scale_factor,85f * MainActivity.scale_factor,0f );
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_9.draw(gl);
        gl.glPopMatrix();
        // part 9 above

        // part 10 below
        gl.glPushMatrix();
        gl.glTranslatef(0f * MainActivity.scale_factor,105f * MainActivity.scale_factor,0f );
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_10.draw(gl);
        gl.glPopMatrix();
        // part 10 above

        // part 11 below
        gl.glPushMatrix();
        gl.glTranslatef(25f * MainActivity.scale_factor,85f * MainActivity.scale_factor,0f );
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_11.draw(gl);
        gl.glPopMatrix();
        // part 11 above

        // part 12 below
        gl.glPushMatrix();
        gl.glTranslatef(25f * MainActivity.scale_factor,85f * MainActivity.scale_factor,0f );
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_12.draw(gl);
        gl.glPopMatrix();
        // part 12 above

        // part 13 below
        gl.glPushMatrix();
        gl.glTranslatef(25f * MainActivity.scale_factor,0f * MainActivity.scale_factor,0f );
        gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);
        part_13.draw(gl);
        gl.glPopMatrix();
        // part 13 above


        gl.glPopMatrix();

        gl.glLoadIdentity();

    }

}
