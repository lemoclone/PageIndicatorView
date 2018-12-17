package com.rd.utils;

import android.graphics.RectF;

public class CustomerSliderIndicator {
    private RectF rectF;
    private int radius;

    public RectF getRectF() {
        return rectF;
    }

    public int getRadius() {
        return radius;
    }

    public CustomerSliderIndicator(RectF rectF, int radius) {
        this.rectF = rectF;
        this.radius = radius;
    }

    public static CustomerSliderIndicator getCustomerSliderIndicator(int coordinateX, int coordinateY) {
        int basic = DensityUtils.dpToPx(2);
        int left = coordinateX - basic * 4;
        int top = coordinateY - basic;
        int right = coordinateX + basic * 4;
        int bottom = coordinateY + basic;
        int radius = basic;
        RectF rectF = new RectF(left,top,right,bottom);
        return new CustomerSliderIndicator(rectF,radius);
    }
}
