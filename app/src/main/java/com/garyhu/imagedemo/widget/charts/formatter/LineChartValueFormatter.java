package com.garyhu.imagedemo.widget.charts.formatter;


import com.garyhu.imagedemo.widget.charts.model.PointValue;

public interface LineChartValueFormatter {

    public int formatChartValue(char[] formattedValue, PointValue value);
}
