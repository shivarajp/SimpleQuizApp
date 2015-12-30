package com.example.quizappTest;

/**
 * Created by raghav on 10/08/13.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class LineGraph {
public Intent getIntenet( Context con)
{
    int x[]={1,2,3,4,5,6,7,8,9,10};
    int y[]={35,16,67,78,89,100,123,134,156,157};
    TimeSeries series=new TimeSeries("Line1");
    TimeSeries series2=new TimeSeries("Line2");


    int x1[]={1,2,3,4,5,6,7,8,9,10};
    int y1[]={157,156,134,123,100,89,78,67,16,35};
    for(int i=0;i<x.length;i++)
    {
        series.add(x[i],y[i]);
        series2.add(x1[i],y1[i]);
    }
    XYMultipleSeriesDataset dataset=new XYMultipleSeriesDataset();
    dataset.addSeries(series);
    dataset.addSeries(series2);
    XYMultipleSeriesRenderer erenderer=new XYMultipleSeriesRenderer();
    XYSeriesRenderer renderer=new XYSeriesRenderer();
    renderer.setColor(Color.BLACK);
    renderer.setPointStyle(PointStyle.SQUARE);
    renderer.setFillPoints(true);
    XYSeriesRenderer renderer2=new XYSeriesRenderer();
    renderer.setColor(Color.RED);
    renderer.setPointStyle(PointStyle.DIAMOND);
    renderer.setFillPoints(true);
    erenderer.setPointSize((Float.parseFloat("3.5")));
    erenderer.setBackgroundColor(Color.RED);

    erenderer.addSeriesRenderer(renderer);
    erenderer.addSeriesRenderer(renderer2);
    Intent intenet1= ChartFactory.getLineChartIntent(con, dataset, erenderer, "Line Graph Title");
       return intenet1;
}
}
