package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import androidx.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.SlideAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
import com.rd.utils.CustomerSliderIndicator;

public class SlideDrawer extends BaseDrawer {

    public SlideDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
    }

    public void draw(
            @NonNull Canvas canvas,
            @NonNull Value value,
            int coordinateX,
            int coordinateY) {

        if (!(value instanceof SlideAnimationValue)) {
            return;
        }

        SlideAnimationValue v = (SlideAnimationValue) value;
        int coordinate = v.getCoordinate();
        int unselectedColor = indicator.getUnselectedColor();
        int selectedColor = indicator.getSelectedColor();
        int radius = indicator.getRadius();

        paint.setColor(unselectedColor);
        //canvas.drawCircle(coordinateX, coordinateY, radius, paint);
        CustomerSliderIndicator customerSliderIndicator = CustomerSliderIndicator.getCustomerSliderIndicator(coordinateX,coordinateY);
        canvas.drawRoundRect(customerSliderIndicator.getRectF(),customerSliderIndicator.getRadius(),customerSliderIndicator.getRadius(),paint);

        paint.setColor(selectedColor);
        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            //canvas.drawCircle(coordinate, coordinateY, radius, paint);
            RectF rectF = customerSliderIndicator.getRectF();
            rectF.offset(coordinate-coordinateX,0);
            RectF recFNew = new RectF(rectF);
            canvas.drawRoundRect(recFNew,customerSliderIndicator.getRadius(),customerSliderIndicator.getRadius(),paint);

        } else {
            //canvas.drawCircle(coordinateX, coordinate, radius, paint);
            //canvas.drawRoundRect(customerSliderIndicator.getRectF(),customerSliderIndicator.getRadius(),customerSliderIndicator.getRadius(),paint);

        }
    }
}
