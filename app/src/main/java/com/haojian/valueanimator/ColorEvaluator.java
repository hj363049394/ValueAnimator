package com.haojian.valueanimator;

import android.animation.TypeEvaluator;
import android.graphics.ImageFormat;

/**
 * Created by haojian12583 on 2016/10/24.
 */

public class ColorEvaluator implements TypeEvaluator{

    private int mCurrentRed = -1;
    private int mCurrentGreen = -1;
    private int mCurrentBlue = -1;


    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        String startColor = (String) startValue;
        String endColor = (String) endValue;

        int startRed  = Integer.parseInt(startColor.substring(1,3),16);
        int startGreen  = Integer.parseInt(startColor.substring(3,5),16);
        int startBlue  = Integer.parseInt(startColor.substring(5,7),16);

        int endRed = Integer.parseInt(endColor.substring(1,3),16);
        int endGreen  = Integer.parseInt(endColor.substring(3,5),16);
        int endBlue = Integer.parseInt(endColor.substring(5,7),16);

        //初始化颜色值
        if (mCurrentRed == -1 ){
            mCurrentRed = startRed;
        }
        if (mCurrentGreen == -1) {
            mCurrentGreen = startGreen;
        }
        if(mCurrentBlue == -1){
            mCurrentBlue = startBlue;
        }

        // 计算初始颜色和结束颜色的差值
        int redOff = Math.abs(startRed - endRed);
        int greenOff = Math.abs(startGreen - endGreen);
        int blueOff = Math.abs(startBlue - endBlue);
        int colorDiff = redOff + greenOff + blueOff;

        if (mCurrentRed != endRed) {
            mCurrentRed = getCurrentColor(startRed,endRed,colorDiff,0,fraction);
        }else if (mCurrentGreen != endGreen) {
            mCurrentGreen = getCurrentColor(startGreen,endGreen,colorDiff,redOff,fraction);
        }else if (mCurrentBlue != endBlue) {
            mCurrentBlue = getCurrentColor(startBlue,endBlue,colorDiff,redOff+greenOff,fraction);
        }

        //将现有颜色组装返回
        String currentColor = "#"+getHexString(mCurrentBlue ) + getHexString(mCurrentGreen)
                + getHexString(mCurrentRed);

        return currentColor;
    }

    private int getCurrentColor(int startColor,int endColor,int colorDiff,int offset,float fraction){

        int currentColor;
        if (startColor > endColor) {
            currentColor = (int) (startColor - (fraction * colorDiff - offset));
            if (currentColor < endColor){
                currentColor = endColor;
            }
        }else {
            currentColor = (int) (startColor + (fraction * colorDiff - offset));
            if (currentColor < endColor){
                currentColor = endColor;
            }
        }
        return currentColor;
    }

    //10进制颜色转化为16进制
    private String getHexString(int value){
        String hexString = Integer.toHexString(value);
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        return hexString;
    }
}
