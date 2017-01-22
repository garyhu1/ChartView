package com.garyhu.imagedemo.widget.charts.listener;


import com.garyhu.imagedemo.widget.charts.model.SliceValue;

public interface PieChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int arcIndex, SliceValue value);

}
