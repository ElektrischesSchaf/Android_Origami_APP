package com.example.android_origami;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLRenderer implements GLSurfaceView.Renderer {

    private Triangle triangle;
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // 01
        // GLES20.glClearColor(1f,0,0,1f);

        GLES20.glClearColor(0f,0,0,1f);
        triangle =new Triangle();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        //GLES20.glClearColor(1f,0,0,1f);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);

        triangle.draw();
    }
}
