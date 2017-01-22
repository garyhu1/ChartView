package com.garyhu.imagedemo.widget.charts.listener;


import com.garyhu.imagedemo.widget.charts.model.PointValue;

public interface LineChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int lineIndex, int pointIndex, PointValue value);

}
