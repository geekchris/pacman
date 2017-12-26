package com.example.threemusksandalien.pac_man;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;

public class HomeActivity extends Activity {
    private GameView gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
    }
    class GameView extends SurfaceView implements Runnable{
        private Thread pacThread;
        private SurfaceHolder ourHolder; // Allows you to edit pixels on screen
        private volatile boolean playing;
        private Canvas canvas;
        private Bitmap pacMan_StartingAni;
        private boolean isMoving;
        private float runSpeedperSecond = 250;
        private float manXPos = 10, manYPos = 10;
        private int frameWidth = 115, frameHeight = 137;
        private int frameCount = 8;
        private int currentFrame = 0;
        private long fps;
        private long timethisFrame;

        public GameView(Context mContext)
        {
            super(mContext);
        }
        public void run()
        {

        }
    }
}
