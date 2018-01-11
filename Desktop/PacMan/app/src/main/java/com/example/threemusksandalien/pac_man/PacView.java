package com.example.threemusksandalien.pac_man;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
<<<<<<< HEAD
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
=======
import android.graphics.Rect;
import android.graphics.RectF;
>>>>>>> 3cee88926b69f956234c6dccbc9a5081d29052b0
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
<<<<<<< HEAD
import android.widget.ImageView;
=======
>>>>>>> 3cee88926b69f956234c6dccbc9a5081d29052b0

/**
 * Created by squar on 1/6/2018.
 */

public class PacView extends SurfaceView implements Runnable {
    private Thread pacThread;
    private SurfaceHolder ourHolder; // Allows you to edit pixels on screen
    private volatile boolean playing;
    private Canvas canvas;
    private Bitmap pacAnimation;
    private boolean isMoving;
    private float runSpeedperSecond = 1000;
    private float manXPos = 10, manYPos = 10;
<<<<<<< HEAD
    private int frameWidth = 60, frameHeight = 60;
=======
    private int frameWidth = 30, frameHeight = 30;
>>>>>>> 3cee88926b69f956234c6dccbc9a5081d29052b0
    private int frameCount = 3;
    private int currentFrame = 0;
    private long fps;
    protected int dir;
    private int frameCounter = 0;
    private long timethisFrame;
    private long lastFrameChangeTime = 0;
    private int frameLengthInMilliSecond = 50;
    private Rect frameToDraw = new Rect(0, 0, frameWidth, frameHeight);
    private RectF whereToDraw = new RectF(manXPos, manYPos, manXPos + frameWidth, frameHeight);
<<<<<<< HEAD
    public PacView(Context mContext, AttributeSet set) {
        super(mContext, set);
        setZOrderOnTop(true);
        ourHolder = getHolder();
        ourHolder.setFormat(PixelFormat.TRANSPARENT);
=======

    public PacView(Context mContext) {
        super(mContext);
        ourHolder = getHolder();
>>>>>>> 3cee88926b69f956234c6dccbc9a5081d29052b0
        pacAnimation = BitmapFactory.decodeResource(getResources(), R.drawable.pacman2);
        dir = 0;
        isMoving = !isMoving;

    }

    @Override
    public void run() {
        while (playing) {
            long startFrameTime = System.currentTimeMillis();
            update();
            draw();
            try{
                Thread.sleep(30);
            }catch(InterruptedException i){
            }
            timethisFrame = System.currentTimeMillis() - startFrameTime;
            if (timethisFrame >= 1) {
                fps = 100000 / timethisFrame;
            }
        }
    }

    public void update() {
        if (isMoving) {
<<<<<<< HEAD
            if(dir == 0) manXPos += 7;
            else if(dir == 1) manXPos -=7;
            else if(dir == 2) manYPos -=7;
            else if(dir == 3) manYPos +=7;
            if (manXPos > getWidth()) {
            }
            if (manYPos + frameHeight > getHeight()) {
=======
            if(dir == 0) manXPos += 5;
            else if(dir == 1) manXPos -=5;
            else if(dir == 2) manYPos -=5;
            else if(dir == 3) manYPos +=5;
            if (manXPos > getWidth()) {

            }
            if (manYPos + frameHeight > getHeight()) {

>>>>>>> 3cee88926b69f956234c6dccbc9a5081d29052b0
            }
            else{

            }
        }
    }

    public void manageCurrentFrame() {
        long time = System.currentTimeMillis();

        if (isMoving) {
            if (time > lastFrameChangeTime + frameLengthInMilliSecond) {
                lastFrameChangeTime = time;
                currentFrame++;

                if (currentFrame >= frameCount) {
                    currentFrame = 0;
                }
            }
        }
<<<<<<< HEAD
=======

>>>>>>> 3cee88926b69f956234c6dccbc9a5081d29052b0
        frameToDraw.left = currentFrame * frameWidth;
        frameToDraw.right = frameToDraw.left + frameWidth;
    }

    public void draw() {
        if (ourHolder.getSurface().isValid()) {
<<<<<<< HEAD

            canvas = ourHolder.lockCanvas();
            canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
=======
            canvas = ourHolder.lockCanvas();
            canvas.drawColor(Color.BLACK);
>>>>>>> 3cee88926b69f956234c6dccbc9a5081d29052b0
            whereToDraw.set((int) manXPos, (int) manYPos, (int) manXPos
                    + frameWidth, (int) manYPos + frameHeight);
            manageCurrentFrame();
            if (dir == 0) {
                switch (frameCounter) {
                    case 0:
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pacman1), null, whereToDraw, null);
                        frameCounter++;
                        break;
                    case 1:
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pacman0), null, whereToDraw, null);
                        frameCounter++;
                        break;
                    case 2:
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pacman2), null, whereToDraw, null);
                        frameCounter = 0;
                        break;
                }
            } else if (dir == 1) {
                switch (frameCounter) {
                    case 0:
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pacman4), null, whereToDraw, null);
                        frameCounter++;
                        break;
                    case 1:
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pacman3), null, whereToDraw, null);
                        frameCounter++;
                        break;
                    case 2:
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pacman2), null, whereToDraw, null);
                        frameCounter = 0;
                        break;
                }
            } else if (dir == 2) {
                switch (frameCounter) {
                    case 0:
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pacman6), null, whereToDraw, null);
                        frameCounter++;
                        break;
                    case 1:
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pacman5), null, whereToDraw, null);
                        frameCounter++;
                        break;
                    case 2:
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pacman2), null, whereToDraw, null);
                        frameCounter = 0;
                        break;
                }
            } else if (dir == 3) {
                switch (frameCounter) {
                    case 0:
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pacman8), null, whereToDraw, null);
                        frameCounter++;
                        break;
                    case 1:
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pacman7), null, whereToDraw, null);
                        frameCounter++;
                        break;
                    case 2:
                        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pacman2), null, whereToDraw, null);
                        frameCounter = 0;
                        break;
                }
            }
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void pause() {
        playing = false;
        try {
            pacThread.join();
        } catch (InterruptedException e) {
            Log.e("ERR", "Joining Thread");
        }
    }

    public void resume() {
        playing = true;
        pacThread = new Thread(this);
        pacThread.start();
    }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                isMoving = !isMoving;
                break;
        }

        return true;
    }*/
<<<<<<< HEAD
=======

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        System.out.println("wow");
        switch (keyCode) {
            case KeyEvent.KEYCODE_D:
                dir = 0;
                System.out.println("hi");
                return true;
            case KeyEvent.KEYCODE_A:
                dir = 1;
                return true;
            case KeyEvent.KEYCODE_W:
                dir = 2;
                return true;
            case KeyEvent.KEYCODE_S:
                dir = 3;
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }
>>>>>>> 3cee88926b69f956234c6dccbc9a5081d29052b0
}