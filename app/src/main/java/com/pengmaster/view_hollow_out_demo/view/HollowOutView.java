package com.pengmaster.view_hollow_out_demo.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * <pre>
 *     author : Wp
 *     e-mail : 1101313414@qq.com
 *     time   : 2020-05-01 11:03
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class HollowOutView extends View {

    private Paint paint;
    private Path path;

    public HollowOutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        //ANTI_ALIAS_FLAG 抗锯齿
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        path = new Path();
        //  2.1  默认path.fileType = WINDING  （需要看方向）
        //        2.1.1 如果方向相同，全部内部，带有涂色
        //        2.1.2 如果方向相反的穿插次数相等则为内部，不等则为外部
//        path.setFillType(Path.FillType.WINDING);
        //2.2 path.fileType = EVEN_ODD （常用）
        //        2.2.1 不考虑方向。穿插奇数次则为内部，偶数次则为外部：
        path.setFillType(Path.FillType.EVEN_ODD);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        path.addRect((float) getWidth()/2-px2dp(100),
                (float) getHeight() / 2 - px2dp(100) ,
                (float) getWidth()/2+px2dp(100),
                (float) getHeight() / 2 + px2dp(100),
                Path.Direction.CW);

        path.addCircle(getWidth() / 2 ,(float) getHeight() / 2 - px2dp(100),px2dp(100), Path.Direction.CCW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path,paint);


    }

    private float px2dp(float value){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, Resources.getSystem().getDisplayMetrics());
    }
}
