package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import androidx.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.ColorAnimationValue;
import com.rd.draw.data.Indicator;

public class ColorDrawer extends BaseDrawer {

    public ColorDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
    }

    public void draw(@NonNull Canvas canvas,
              @NonNull Value value,
              int position,
              int coordinateX,
              int coordinateY) {

        if (!(value instanceof ColorAnimationValue)) {
            return;
        }

        ColorAnimationValue v = (ColorAnimationValue) value;
        float radius = indicator.getRadius();
        int color = indicator.getSelectedColor();

        int selectedPosition = indicator.getSelectedPosition();
        int selectingPosition = indicator.getSelectingPosition();
        int lastSelectedPosition = indicator.getLastSelectedPosition();

        if (indicator.isInteractiveAnimation()) {
            if (position == selectingPosition) {
                color = v.getColor();

            } else if (position == selectedPosition) {
                color = v.getColorReverse();
            }

        } else {
            if (position == selectedPosition) {
                color = v.getColor();

            } else if (position == lastSelectedPosition) {
                color = v.getColorReverse();
            }
        }

        paint.setColor(color);

        RectF rectF = new RectF(coordinateX-8,coordinateY-2,coordinateX+8,coordinateY+2);

        canvas.drawRoundRect(rectF,2,2,paint);
        //canvas.drawCircle(coordinateX, coordinateY, radius, paint);
    }
}
