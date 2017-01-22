package com.garyhu.imagedemo.widget.charts.formatter;


import com.garyhu.imagedemo.widget.charts.model.SliceValue;

public interface PieChartValueFormatter {

    public int formatChartValue(char[] formattedValue, SliceValue value);
}
