package com.garyhu.imagedemo.widget.charts.listener;


import com.garyhu.imagedemo.widget.charts.model.PointValue;
import com.garyhu.imagedemo.widget.charts.model.SubcolumnValue;

public interface ComboLineColumnChartOnValueSelectListener extends OnValueDeselectListener {

    public void onColumnValueSelected(int columnIndex, int subcolumnIndex, SubcolumnValue value);

    public void onPointValueSelected(int lineIndex, int pointIndex, PointValue value);

}
