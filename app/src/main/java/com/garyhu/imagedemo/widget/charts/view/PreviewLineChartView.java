package com.garyhu.imagedemo.widget.charts.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;

import com.garyhu.imagedemo.BuildConfig;
import com.garyhu.imagedemo.widget.charts.computator.PreviewChartComputator;
import com.garyhu.imagedemo.widget.charts.gesture.PreviewChartTouchHandler;
import com.garyhu.imagedemo.widget.charts.model.LineChartData;
import com.garyhu.imagedemo.widget.charts.renderer.PreviewLineChartRenderer;


/**
 * Preview chart that can be used as overview for other LineChart. When you change Viewport of this chart, visible area
 * of other chart will change. For that you need also to use
 * {@link Chart}
 *
 * @author Leszek Wach
 */
public class PreviewLineChartView extends LineChartView {
    private static final String TAG = "PreviewLineChartView";

    protected PreviewLineChartRenderer previewChartRenderer;

    public PreviewLineChartView(Context context) {
        this(context, null, 0);
    }

    public PreviewLineChartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PreviewLineChartView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        chartComputator = new PreviewChartComputator();
        previewChartRenderer = new PreviewLineChartRenderer(context, this, this);
        touchHandler = new PreviewChartTouchHandler(context, this);
        setChartRenderer(previewChartRenderer);
        setLineChartData(LineChartData.generateDummyData());
    }

    public int getPreviewColor() {
        return previewChartRenderer.getPreviewColor();
    }

    public void setPreviewColor(int color) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "Changing preview area color");
        }

        previewChartRenderer.setPreviewColor(color);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override
    public boolean canScrollHorizontally(int direction) {
        final int offset = computeHorizontalScrollOffset();
        final int range = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
        if (range == 0) return false;
        if (direction < 0) {
            return offset > 0;
        } else {
            return offset < range - 1;
        }
    }
}
