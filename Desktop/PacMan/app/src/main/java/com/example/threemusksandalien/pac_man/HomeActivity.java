package com.example.threemusksandalien.pac_man;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends Activity implements GestureDetector.OnGestureListener{
    private PacView pacView;
    private BoardView boardView;
    private MediaPlayer musicPlayer;
    private GestureDetectorCompat gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        pacView = findViewById(R.id.pacView);
        //boardView = new BoardView(this);

        //musicPlayer =  MediaPlayer.create(getApplicationContext(), R.raw.pacman_beginning);
        //musicPlayer.start();
        musicPlayer = MediaPlayer.create(getApplicationContext(), R.raw.pacman_beginning);
        try {
            musicPlayer.start();
            synchronized (musicPlayer){
                musicPlayer.wait(4000);
            }
        }catch(InterruptedException i){

        }
        musicPlayer = MediaPlayer.create(getApplicationContext(), R.raw.siren1);
        musicPlayer.start();
        musicPlayer.setLooping(true);
        this.gestureDetector = new GestureDetectorCompat(this,this);

    }
    @Override
    protected void onResume() {
        super.onResume();
        pacView.resume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        pacView.pause();
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
        switch (getSlope(e1.getX(), e1.getY(), e2.getX(), e2.getY())) {
            case 1:
                pacView.dir = 2;
                return true;
            case 2:
                pacView.dir = 1;
                return true;
            case 3:
                pacView.dir = 3;
                return true;
            case 4:
                pacView.dir = 0;
                return true;
        }
        return false;
    }
    private int getSlope(float x1, float y1, float x2, float y2) {
        Double angle = Math.toDegrees(Math.atan2(y1 - y2, x2 - x1));
        if (angle > 45 && angle <= 135)
            // top
            return 1;
        if (angle >= 135 && angle < 180 || angle < -135 && angle > -180)
            // left
            return 2;
        if (angle < -45 && angle>= -135)
            // down
            return 3;
        if (angle > -45 && angle <= 45)
            // right
            return 4;
        return 0;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
