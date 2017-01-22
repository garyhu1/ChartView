package com.garyhu.imagedemo.widget.charts.provider;


import com.garyhu.imagedemo.widget.charts.model.LineChartData;

public interface LineChartDataProvider {

    public LineChartData getLineChartData();

    public void setLineChartData(LineChartData data);

}
