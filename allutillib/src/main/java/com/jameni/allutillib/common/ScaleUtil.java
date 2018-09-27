package com.jameni.allutillib.common;

public class ScaleUtil {
    //知道x  和 比例， 求y
    public static int getScaleY(int originalX, int x, int y) {
        return originalX * y / x;
    }

    //知道Y  和 比例， 求x
    public static int getScaleX(int originalY, int x, int y) {
        return originalY * x / y;
    }

}
