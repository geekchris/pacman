package com.example.threemusksandalien.pac_man;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.constraint.solver.widgets.Rectangle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Christian Cuison on 1/7/2018.
 */

public class BoardView extends SurfaceView
{
    protected Rect[] pixels;
    private Bitmap board;
    private SurfaceHolder ourHolder;
    private Canvas canvas;
    private Rect whereToDraw = new Rect(0, 0, 0,0);
    public BoardView(Context mContext){
        super(mContext);
        System.out.println("Board created");
        pixels = new Rect[16];
        board = BitmapFactory.decodeResource(getResources(), R.drawable.board);
        System.out.println(board);
        ourHolder = getHolder();
        drawBoard();
    }
    private void drawBoard(){
        if (ourHolder.getSurface().isValid()) {
            canvas = ourHolder.lockCanvas();
            canvas.drawBitmap(board, null, whereToDraw, null);
            System.out.println("Board drawn.");
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }
}
