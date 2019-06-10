package com.example.android_origami;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLRenderer implements GLSurfaceView.Renderer {

    private static final String TAG = "OpenGLRenderer";
    private Triangle triangle;
    private  Triangle_2 triangle_2;
    private part_2 part_2;

    private final float[] mRotationMatrix = new float[16];
    private final float[] mTranslateMatrix = new float[16];
    private final float[] mMVPMatrix = new float[16];
    private final float[] mViewMatrix = new float[16];
    private final float[] mProjectionMatrix = new float[16];

    private float mAngle=0f;
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // 01
        // GLES20.glClearColor(1f,0,0,1f);

        GLES20.glClearColor(0f,0,0,1f);
        triangle =new Triangle();
        triangle_2=new Triangle_2();
        part_2=new part_2();
    }


    @Override
    public void onDrawFrame(GL10 gl) {
        float[] scratch = new float[16];
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        Matrix.setLookAtM(mViewMatrix, 0, 0, 0, +5, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);

        Matrix.translateM(triangle.mModelMatrix,0,0,0,0);
        Matrix.rotateM(triangle.mModelMatrix, 0, mAngle, 0, 0, 1.0f);


        Matrix.multiplyMM(scratch, 0, mMVPMatrix, 0, triangle.mModelMatrix, 0);
        //Matrix.multiplyMM(scratch, 0, mMVPMatrix, 0, mTranslateMatrix, 0);
        //GLES20.glClearColor(1f,0,0,1f);

        //triangle.draw();
        triangle.draw(scratch);
        // triangle_2.draw();

        Matrix.translateM(part_2.mModelMatrix,0,0,0,0);
        Matrix.rotateM(part_2.mModelMatrix, 0, mAngle, 0, 0, 1.0f);
        Matrix.multiplyMM(scratch, 0, mMVPMatrix, 0, part_2.mModelMatrix, 0);
        part_2.draw(scratch);
        mAngle=0f;

    }

    public static void checkGlError(String glOperation) {
        int error;
        while ((error = GLES20.glGetError()) != GLES20.GL_NO_ERROR) {
            Log.e(TAG, glOperation + ": glError " + error);
            throw new RuntimeException(glOperation + ": glError " + error);
        }
    }

    @Override
    public void onSurfaceChanged(GL10 unused, int width, int height) {
        // Adjust the viewport based on geometry changes,
        // such as screen rotation
        GLES20.glViewport(0, 0, width, height);

        float ratio = (float) width / height;

        // this projection matrix is applied to object coordinates
        // in the onDrawFrame() method
        Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 3, 7);

    }

    public float getAngle() {
        return mAngle;
    }

    /**
     * Sets the rotation angle of the triangle shape (mTriangle).
     */
    public void setAngle(float angle) {
        mAngle = angle;
    }


}
