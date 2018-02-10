package felix.kawasakiapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


class DrawableImageView extends View {
    Paint mPaint,paint;
    Bitmap mBitmap;
    Canvas mCanvas;
    Path mPath;
    Paint mBitmapPaint;
    //Paint paint = new Paint();
    List<Point> points = new ArrayList<Point>();
    ImageDraw imageDraw = new ImageDraw();


    public DrawableImageView(Context context) {
        super(context);

        // TODO Auto-generated constructor stub


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(0xFFFF0000);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(10);

        mPath = new Path();
        mBitmapPaint = new Paint();
        mBitmapPaint.setColor(Color.RED);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    @Override
    public void draw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.draw(canvas);
        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
       // canvas.drawCircle(mX, mY, 15, mBitmapPaint);
        canvas.drawPath(mPath, mPaint);
    }

    private float mX, mY;
    private static final float TOUCH_TOLERANCE = 4;

    public void touch_start(float x, float y) {
        //mPath.reset();
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
    }

    public void touch_move(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;
        }
    }

    public void touch_up() {
        mPath.lineTo(mX, mY);
        // commit the path to our offscreen
        mCanvas.drawPath(mPath, mPaint);
        //mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
        // kill this so we don't double draw
        mPath.reset();
        // mPath= new Path();
    }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touch_start(x, y);
                Log.d("Co-ords down", String.valueOf(x) + "," + String.valueOf(y));
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                touch_move(x, y);
                invalidate();
                Log.d("Co-ords move", String.valueOf(x) + "," + String.valueOf(y));
                break;
            case MotionEvent.ACTION_UP:
                touch_up();
                invalidate();
                Log.d("Co-ords up", String.valueOf(x) + "," + String.valueOf(y));
                break;
        }
        return true;
    }*/

   /* protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
       // paint = new Paint();
       // paint.setColor(Color.GREEN);
        for(Point p: points){
            canvas.drawCircle(p.x, p.y, 20, paint);
        }
        invalidate();
    }*/

 /*   @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                Point p = new Point();
                p.x = (int)event.getX();
                p.y = (int)event.getY();
                points.add(p);
                invalidate();
                if(p.x>800 && p.x<1000){
                    Toast.makeText(getContext(),"Pressed",Toast.LENGTH_SHORT).show();
                }

                break;
            case MotionEvent.ACTION_MOVE:  // a pointer was moved
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
            {
                break;
            }
        }
        invalidate();
        return true;
    }*/
}

