package com.haojian.valueanimator;

import android.animation.TypeEvaluator;

/**
 * Created by haojian12583 on 2016/10/24.
 */

public class PointEvaluator implements TypeEvaluator {


    /**
     * FloatEvaluator实现了TypeEvaluator接口，然后重写evaluate()方法。
     * evaluate()方法当中传入了三个参数，
     * 第一个参数fraction非常重要，这个参数用于表示动画的完成度的，我们应该根据它来计算当前动画的值应该是多少，
     * 第二第三个参数分别表示动画的初始值和结束值。那么上述代码的逻辑就比较清晰了，
     * 用结束值减去初始值，算出它们之间的差值，然后乘以fraction这个系数，再加上初始值，
     * 那么就得到当前动画的值了。
     * @param fraction
     * @param startValue
     * @param endValue
     * @return
     */


    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;

        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());

        Point point = new Point(x,y);

        return point;
    }
}
