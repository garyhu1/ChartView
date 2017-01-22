package com.garyhu.imagedemo.widget.charts.listener;


import com.garyhu.imagedemo.widget.charts.model.SubcolumnValue;

public interface ColumnChartOnValueSelectListener extends OnValueDeselectListener {

    public void onValueSelected(int columnIndex, int subcolumnIndex, SubcolumnValue value);

}
