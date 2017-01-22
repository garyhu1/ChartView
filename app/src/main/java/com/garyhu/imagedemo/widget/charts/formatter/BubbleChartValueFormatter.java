package com.garyhu.imagedemo.widget.charts.formatter;


import com.garyhu.imagedemo.widget.charts.model.BubbleValue;

public interface BubbleChartValueFormatter {

    public int formatChartValue(char[] formattedValue, BubbleValue value);
}
