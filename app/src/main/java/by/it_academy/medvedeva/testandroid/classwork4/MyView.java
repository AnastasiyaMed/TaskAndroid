package by.it_academy.medvedeva.testandroid.classwork4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import by.it_academy.medvedeva.testandroid.R;

/**
 * Created by Medvedeva Anastasiya
 * on 31.07.2017.
 */

public class MyView extends View {
    private Paint myPaint = new Paint();
    private RectF arcRectF = new RectF();
    private int cx;
    private int cy;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context) {
        super(context);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void init() {
        myPaint.setAntiAlias(true);
        myPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        // myPaint.setStyle(Paint.Style.FILL); // полностью заливает цветом фигуру
        myPaint.setStyle(Paint.Style.STROKE); // заливает цветом только контур фигуры

        Resources r = getResources();
        float strokeWidthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, r.getDisplayMetrics());
        myPaint.setStrokeWidth(strokeWidthInPx);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(cx, cy, (Math.min(getWidth(), getHeight())) / 4, myPaint); // рисует круг. первые два параметра - координаты центра. потом радиус, потом ручка
        canvas.drawLine(0, 0, getWidth(), getHeight(), myPaint); // рисует линию. первые две - координаты начала, потом 2 переменные, .координаты конца. потом рисовалка

        arcRectF.left = 0; // координата левого края
        arcRectF.top = 0; // координата верха
        arcRectF.bottom = getWidth(); // координата низа здесь использовала ширину экрана, чтобы обе стороны от центра были одного размера
        arcRectF.right = getWidth();

        canvas.drawArc(arcRectF, 0, 90, true, myPaint); // рисует часть круга arcRectF задает область, где рисуется объект. Первый float градус, где начать, 90 на сколько отклониться

        canvas.drawRect(50, 50, 100, 120, myPaint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        arcRectF.contains(event.getX(), event.getY());
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            cx = (int) event.getX();
            cy = (int) event.getY();
            invalidate();
        }
        return true;
    }
}
