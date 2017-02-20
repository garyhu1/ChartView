package com.garyhu.imagedemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;

import com.garyhu.imagedemo.R;

/**
 * 作者： garyhu.
 * 时间： 2016/10/22.
 * 圆弧显示进度
 */
public class CustomProgressBar extends View {

    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 画TextView的画笔
     */
    private Paint tvPaint;
    private float textSize1 = 40f;
    private float textSize2 = 70f;
    private float textSize3 = 40f;
    /**
     * 第一个圆环颜色
     */
    private int firstColor;
    /**
     * 第二个圆环颜色
     */
    private int secondColor;
    /**
     * 圆环宽度
     */
    private int circleWidth;
    /**
     * 进度速度
     */
    private int progressSpeed;
    /**
     * 当前进度
     */
    private int mProgress;
    /**
     * 终止进度
     */
    private int mOverProgress;
    /**
     * 是否下一个
     */
    private boolean isNext;
    /**
     * 进度条的标题
     */
    private String mTitle="";
    /**
     * 所占百分比
     */
    private String mPercent="";
    private int percent = 0;
    /**
     * 当前百分比
     */
    private int mCurPercent=0;
    /**
     * 是否显示百分号
     */
    private boolean mIsShow;

    public CustomProgressBar(Context context) {
        this(context,null);
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int h = getMeasuredHeight();
//        int height = h+dipToPx(120);
//        int w = getScreenWidth();
        int w = getMeasuredWidth();

        setMeasuredDimension(w,h);

    }

    /**
     * 初始化参数
     * @param context 上下文
     * @param attrs 自定义参数
     */
    public void init(Context context,AttributeSet attrs){
        if(attrs == null){
            return;
        }
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar);
        int count = a.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attr = a.getIndex(i);
            switch (attr){
                case R.styleable.CustomProgressBar_firstColor:
                    firstColor = a.getInt(R.styleable.CustomProgressBar_firstColor, Color.BLACK);
                    break;
                case R.styleable.CustomProgressBar_secondColor:
                    secondColor = a.getInt(R.styleable.CustomProgressBar_secondColor,Color.RED);
                    break;
                case R.styleable.CustomProgressBar_circleWidth:
                    circleWidth = a.getInt(R.styleable.CustomProgressBar_circleWidth,
                            (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,20,
                                    context.getResources().getDisplayMetrics()));//默认20
                    break;
                case R.styleable.CustomProgressBar_progressSpeed:
                    progressSpeed = a.getInt(R.styleable.CustomProgressBar_progressSpeed,20);
                    break;
            }
        }
        a.recycle();
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        circleWidth = 20;
        int center = getHeight()/2;//圆环圆心
        int radius = center-circleWidth;//圆环半径
        mPaint.setStrokeWidth(circleWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeCap(Paint.Cap.ROUND);


        tvPaint = new Paint();
        tvPaint.setTextSize(textSize1);
        tvPaint.setColor(Color.BLACK);
        tvPaint.setTextAlign(Paint.Align.CENTER);
        // 用于定义的圆弧的形状和大小的界限
        RectF oval = new RectF(center - radius, center - radius, center + radius, center + radius);

        canvas.drawText(mTitle,center,center-textSize1/3,tvPaint);
        tvPaint.setTextSize(textSize2);
        tvPaint.setColor(0xffFA7229);
        float v = tvPaint.measureText(mPercent);
        if(!mIsShow){
            canvas.drawText(mPercent,center,center+textSize2*2/3+dipToPx(10),tvPaint);
        }else {
            canvas.drawText(mPercent,center-v/3,center+textSize2*2/3+dipToPx(10),tvPaint);
        }

        if(mIsShow){
            tvPaint.setTextSize(textSize3);
            tvPaint.setColor(Color.BLACK);
            float x = tvPaint.measureText(mPercent+"%");
            canvas.drawText("%",center+x/2,center+textSize2*2/3+dipToPx(10),tvPaint);
        }
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(center,center,radius,mPaint);
        mPaint.setColor(secondColor);
        canvas.drawArc(oval,-90,mProgress,false,mPaint);

    }

    /**
     * 设置是否显示百分号
     */
    public CustomProgressBar setIsShow(boolean show){
        mIsShow = show;
        invalidate();
        return this;
    }

    /**
     * 设置标题
     */
    public CustomProgressBar setmTitle(String title){
        mTitle = title;
        invalidate();
        return this;
    }

    public CustomProgressBar setPercent(int percent){
        mCurPercent = percent;
//        invalidate();
        return this;
    }

    public CustomProgressBar setSubTitle(String subTitle){
        mPercent = subTitle;
        invalidate();
        return this;
    }

    /**
     * 设置终止进度
     */
    public CustomProgressBar setOverProgress(int progress){
        mOverProgress = progress;
        return this;
    }

    /**
     * 开始进度
     */
    public void start(){
        if(!mIsShow){
            return;
        }
        mProgress = 0;
        mPercent = "";
        percent=0;
        if(!isNext){
            new Thread(){
                @Override
                public void run() {
                    while(true){
                        isNext = true;
                        percent++;
                        mPercent = percent+"";
                        mProgress = (int) (0.01f*percent*360);
                        if(percent > mCurPercent){
                            isNext = false;
                            break;
                        }
                        postInvalidate();
                        try {
                            Thread.sleep(progressSpeed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }

    /**
     * dip 转换成px
     * @param dip
     * @return
     */
    private int dipToPx(float dip) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int)(dip * density + 0.5f * (dip >= 0 ? 1 : -1));
    }

}
