package by.it_academy.medvedeva.testandroid.task4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import by.it_academy.medvedeva.testandroid.R;

/**
 * Created by Medvedeva Anastasiya
 * on 05.08.2017.
 */

public class ClockView extends View {
    private final static int HALF_SIZE = 2;
    private final static int COUNT_HOURS = 12;
    private final static int ANGLE = 360 / COUNT_HOURS;
    private final static int SEGMENT_LENGTH = 20;
    private static final int HAND_TAIL_LENGTH = 25;
    private static final int DEGREE_PER_MINUTE = 6;
    private static final int DEGREE_PER_SECOND = 6;

    Paint paint = new Paint();
    private int textSize = 40;
    private float hours;
    private float minutes;
    private float seconds;


    public ClockView(Context context) {
        super(context);
        init();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimary)); // цвет карандаша
        paint.setStyle(Paint.Style.STROKE); // делаем окантовку
        paint.setStrokeWidth(3.0f); // толщина окантовки
        paint.setAntiAlias(true); // сглаживание
        paint.setTextSize(textSize); // размер текста

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int xCetntre = getWidth() / HALF_SIZE;
        int yCetntre = getHeight() / HALF_SIZE;
        int radius = getWidth() / HALF_SIZE;

        canvas.drawCircle(xCetntre, yCetntre, radius, paint);

        paint.setStrokeWidth(10.0f); // толщина окантовки для точки
        // рисуем точку в центре
        canvas.drawPoint(xCetntre, yCetntre, paint);

        // Draw the marker and text every 30 degrees
        for (int i = 0; i < COUNT_HOURS; i++) {
            // Draw a marker
            canvas.drawLine(xCetntre, yCetntre - radius, xCetntre, (yCetntre - radius + SEGMENT_LENGTH), paint);

            canvas.rotate(30, xCetntre, yCetntre);
        }

        // Draw numbers
        paint.setStrokeWidth(2.0f); // толщина линии для отрисовки цифр
        for (int i = 1; i <= COUNT_HOURS; i++) {
            int textWidth = (int) paint.measureText(String.valueOf(i));

            int dx = (int) ((radius - 50) * Math.sin(Math.toRadians(i * ANGLE)));
            int dy = (int) ((radius - 50) * Math.cos(Math.toRadians(i * ANGLE)));

            int cardinalX = -textWidth / 2;

            canvas.drawText(String.valueOf(i), xCetntre + dx + cardinalX, yCetntre - dy + textSize / 3,
                    paint);
        }

        // Make sure we update to the current time
        onTimeChanged();

        // tick the seconds
        post(clockTick);

        // Draw hours hand
        paint.setStrokeWidth(10.0f); // толщина стрелки
        int dx = (int) ((radius / 3) * Math
                .sin(Math.toRadians(hours * ANGLE + (ANGLE * minutes / 60))));
        int dy = (int) ((radius / 3) * Math
                .cos(Math.toRadians(hours * ANGLE + (ANGLE * minutes / 60))));

        canvas.drawLine(
                (float) (xCetntre - HAND_TAIL_LENGTH * Math
                        .sin(Math.toRadians(hours * ANGLE + (ANGLE * minutes / 60)))),
                (float) (yCetntre + HAND_TAIL_LENGTH * Math
                        .cos(Math.toRadians(hours * ANGLE + (ANGLE * minutes / 60)))),
                xCetntre + dx, yCetntre - dy, paint);

        // Draw minute hand
        dx = (int) ((radius / 1.5) * Math.sin(Math.toRadians(minutes * DEGREE_PER_MINUTE)));
        dy = (int) ((radius / 1.5) * Math.cos(Math.toRadians(minutes * DEGREE_PER_MINUTE)));

        canvas.drawLine((float) (xCetntre - HAND_TAIL_LENGTH * Math
                        .sin(Math.toRadians(minutes * DEGREE_PER_MINUTE))),
                (float) (yCetntre + HAND_TAIL_LENGTH * Math
                        .cos(Math.toRadians(minutes * DEGREE_PER_MINUTE))), xCetntre + dx,
                yCetntre - dy, paint);

        // Draw second hand
        dx = (int) ((radius / 1.2) * Math.sin(Math.toRadians(seconds * DEGREE_PER_SECOND)));
        dy = (int) ((radius / 1.2) * Math.cos(Math.toRadians(seconds * DEGREE_PER_SECOND)));

        canvas.drawLine((float) (xCetntre - 2 * HAND_TAIL_LENGTH * Math
                        .sin(Math.toRadians(seconds * DEGREE_PER_SECOND))),
                (float) (yCetntre + 2 * HAND_TAIL_LENGTH * Math.cos(
                        Math.toRadians(seconds * DEGREE_PER_SECOND))), xCetntre + dx, yCetntre - dy,
                paint);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void onTimeChanged() {
        GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        seconds = calendar.get(Calendar.SECOND);
        minutes = minute;
        hours = hour;
    }

    private final Runnable clockTick = new Runnable() {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void run() {
            onTimeChanged();
            invalidate();
            ClockView.this.postDelayed(clockTick, 1000);
        }
    };


}

