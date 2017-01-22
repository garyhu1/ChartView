package com.garyhu.imagedemo.widget.charts.listener;


import com.garyhu.imagedemo.widget.charts.model.BubbleValue;

public interface BubbleChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int bubbleIndex, BubbleValue value);

}
