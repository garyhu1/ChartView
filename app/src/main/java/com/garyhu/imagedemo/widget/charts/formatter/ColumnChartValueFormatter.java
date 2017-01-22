package com.garyhu.imagedemo.widget.charts.formatter;


import com.garyhu.imagedemo.widget.charts.model.SubcolumnValue;

public interface ColumnChartValueFormatter {

    public int formatChartValue(char[] formattedValue, SubcolumnValue value);

}
