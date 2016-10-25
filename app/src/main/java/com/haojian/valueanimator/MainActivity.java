package com.haojian.valueanimator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        调用ValueAnimator的ofFloat()方法就可以构建出一个ValueAnimator的实例，
//        ofFloat()方法当中允许传入多个float类型的参数，这里传入0和1就表示将值从0平滑过渡到1，
//        然后调用ValueAnimator的setDuration()方法来设置动画运行的时长，最后调用start()方法启动动画
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0F,1F);
        valueAnimator.setDuration(300);
        valueAnimator.setRepeatCount(5);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float)animation.getAnimatedValue();
                Log.d("TAG","currentValue = "+currentValue);

            }
        });
        valueAnimator.start();

//        Button startBtn = (Button) findViewById(R.id.start_btn);
//        final TextView textView = (TextView) findViewById(R.id.txt1);
//
//        startBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView,"alpha",1f,0f,1f); // 透明度变化 常规--全透明--常规
//
////                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView,"rotation",0f,360f/*,270f*/);  // 旋转360度
//
//                // 将TextView先向左移出屏幕，然后再移动回来
////                float currentTranstationX = textView.getTranslationX();
////                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView,"translationX",currentTranstationX,-500f,currentTranstationX);
//
//                // TextView进行缩放操作，比如说将TextView在垂直方向上放大3倍再还原
////                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "scaleY", 1f, 3f, 1f);
////                objectAnimator.setDuration(5000);
////                objectAnimator.start();
//
//                // 组合动画
//                // TextView先从屏幕外移动进屏幕，然后开始旋转360度，旋转的同时进行淡入淡出操作
//                ObjectAnimator moveAnimation = ObjectAnimator.ofFloat(textView,"translationX",-1000f,0f);
//                ObjectAnimator rotationAnimation = ObjectAnimator.ofFloat(textView,"rotation",0f,360f);
//                ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(textView,"alpha",1f,0f,1f);
//                AnimatorSet animatorSet = new AnimatorSet();
//                animatorSet.play(rotationAnimation).with(alphaAnimation).after(moveAnimation);
//                animatorSet.setDuration(5000);
//                animatorSet.start();
//
//
//
//
//            }
//        });


    }}
