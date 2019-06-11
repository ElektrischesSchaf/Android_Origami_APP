package com.example.android_origami;

import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/*
 * A triangle with 3 vertices.
 */
public class part_8 {
    private FloatBuffer vertexBuffer;  // Buffer for vertex-array
    private ByteBuffer indexBuffer;    // Buffer for index-array

    private float[] vertices = {  // Vertices of the triangle
            0f * MainActivity.scale_factor, 0f * MainActivity.scale_factor, 0.0f,
            -105f * MainActivity.scale_factor, 0f * MainActivity.scale_factor, 0.0f,
            -130 * MainActivity.scale_factor, -20f * MainActivity.scale_factor, 0.0f,
            -130f * MainActivity.scale_factor, -60f * MainActivity.scale_factor, 0.0f,
            -105f * MainActivity.scale_factor, -85f * MainActivity.scale_factor, 0.0f,
            -85f * MainActivity.scale_factor, -85f * MainActivity.scale_factor, 0.0f
    };
    private byte[] indices = { 0, 1, 2 ,0, 2, 3,0, 3, 4,0,4,5}; // Indices to above vertices (in CCW)

    // Constructor - Setup the data-array buffers
    public part_8() {
        // Setup vertex-array buffer. Vertices in float. A float has 4 bytes.
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder()); // Use native byte order
        vertexBuffer = vbb.asFloatBuffer(); // Convert byte buffer to float
        vertexBuffer.put(vertices);         // Copy data into buffer
        vertexBuffer.position(0);           // Rewind

        // Setup index-array buffer. Indices in byte.
        indexBuffer = ByteBuffer.allocateDirect(indices.length);
        indexBuffer.put(indices);
        indexBuffer.position(0);
    }

    // Render this shape
    public void draw(GL10 gl) {
        // Enable vertex-array and define the buffers
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

        // Draw the primitives via index-array
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_BYTE, indexBuffer);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        Log.d("In part_8: ","draw(GL10 gl)");
    }
}