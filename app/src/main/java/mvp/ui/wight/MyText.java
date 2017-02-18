package mvp.ui.wight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.wight.R;

/**
 * Created by Administrator on 2017/2/17.
 */

public class MyText extends View {
    private int textColor;
    private Paint paint = new Paint();
    private float currentX =50;
    private float currentY = 50;
    public MyText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a =  context.obtainStyledAttributes(attrs, R.styleable.myView);
        textColor = a.getColor(R.styleable.myView_textColor, Color.BLACK);
        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(currentX,currentY,30,paint);
        paint.setColor(textColor);
        canvas.drawText("BY finch",currentX-30,currentY-30,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX = event.getX();
        currentY = event.getY();
        return true;
    }
}
