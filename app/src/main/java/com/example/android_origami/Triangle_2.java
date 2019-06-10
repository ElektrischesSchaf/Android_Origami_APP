package com.example.android_origami;

import android.opengl.GLES20;
import android.opengl.GLException;
import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL;

public class Triangle_2 {

    private FloatBuffer vertexBuffer;
    static final int COORDS_PER_VERTEX = 3;
    private float vertices[] = {
            +0.5f, +0.5f, 0.0f,
            -0.5f, 0.5f, 0.0f,
            0.0f, -0.5f, 0.0f
    };

    private final int vertexCount = vertices.length / COORDS_PER_VERTEX;
    private final int vertexStride = COORDS_PER_VERTEX * 4; // 4 bytes per vertex

    private float color[]=new float[]{0.0f,0.6f,1.0f,0.0f};

    private final String vertexShaderCode =
            // This matrix member variable provides a hook to manipulate
            // the coordinates of the objects that use this vertex shader
            "attribute vec4 vPosition;" +
                    "void main() {" +
                    // the matrix must be included as a modifier of gl_Position
                    // Note that the uMVPMatrix factor *must be first* in order
                    // for the matrix multiplication product to be correct.
                    // 以下需有 "=" 否則會出錯
                    "  gl_Position = vPosition;"+
                    "}";

    private final String fragmentShaderCode =
            "precision mediump float;" +
                    "uniform vec4 vColor;" +
                    "void main() {" +
                    // 以下需有 "=" 否則會出錯
                    "  gl_FragColor = vColor;" +
                    "}";

    private int shaderProgram;

    public static int loadShader(int type, String shaderCode){
        int shader= GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader,shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }

    public Triangle_2(){
        ByteBuffer bb =ByteBuffer.allocateDirect(vertices.length*4);
        bb.order(ByteOrder.nativeOrder());

        vertexBuffer=bb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);
        int vertexShader =loadShader(GLES20.GL_VERTEX_SHADER,vertexShaderCode);
        int fragmentShader=loadShader(GLES20.GL_FRAGMENT_SHADER,fragmentShaderCode);

        shaderProgram=GLES20.glCreateProgram();
        GLES20.glAttachShader(shaderProgram,vertexShader);
        GLES20.glAttachShader(shaderProgram,fragmentShader);
        GLES20.glLinkProgram(shaderProgram);
    }

    public void draw()
    {
        Log.d("Log tag:  ","In draw()");
        Log.d("vertexCount=  ", Integer.toString(vertexCount));
        GLES20.glUseProgram(shaderProgram);
        int positionAttrib=GLES20.glGetAttribLocation(shaderProgram,"vPosition");
        GLES20.glEnableVertexAttribArray(positionAttrib);

        Log.d("Log tag:  ","Before vertexBuffer");
        // 02
        //GLES20.glVertexAttribPointer(positionAttrib,3,GLES20.GL_FLOAT,false,0,vertexBuffer);

        GLES20.glVertexAttribPointer(positionAttrib,COORDS_PER_VERTEX, GLES20.GL_FLOAT,false, vertexStride,vertexBuffer);

        Log.d("Log tag:  ","After vertexBuffer");

        int colorUniform= GLES20.glGetUniformLocation(shaderProgram,"vColor");
        GLES20.glUniform4fv(colorUniform,1,color,0);
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES,0,vertexCount);
        GLES20.glDisableVertexAttribArray(positionAttrib);

    }

}
