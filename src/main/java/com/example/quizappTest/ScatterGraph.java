package com.example.quizappTest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/**
 * Created by raghav on 10/08/13.
 */
public class ScatterGraph {
    public Intent getIntent(Context con)
    {
    int x[]={1,2,3,4,5,6,7,8,9,10};
    double y[]={35.0,16.5,67.5,78.3,89.3,100.7,123.5,134.2,156.4,157.6};
        int x1[]={1,2,3,4,5,6,7,8,9,10};
        double y1[]={32.0,12.5,63.5,72.3,82.3,103.7,120.5,130.2,151.4,159.6};
    XYSeries series1=new XYSeries("Series 1");
        XYSeries series=new XYSeries("Series 2");
  int k=x.length;
        for(int i=0;i<k;i++)
        {
            series1.add(x[i],y[i]);
            series.add(x1[i],y[i]);
        }
        XYMultipleSeriesDataset dataset=new XYMultipleSeriesDataset();
        dataset.addSeries(series1);
        dataset.addSeries(series);
        XYSeriesRenderer rendere=new XYSeriesRenderer();
        rendere.setColor(Color.RED);
        rendere.setPointStyle(PointStyle.DIAMOND);
        rendere.setLineWidth(10);
        XYSeriesRenderer renderer2=new XYSeriesRenderer();
        renderer2.setColor(Color.BLUE);
        renderer2.setPointStyle(PointStyle.SQUARE);
        renderer2.setLineWidth(10);
        rendere.setDisplayChartValues(true);
        renderer2.setDisplayChartValues(true);

        XYMultipleSeriesRenderer erenderer=new XYMultipleSeriesRenderer();
        erenderer.addSeriesRenderer(rendere);
        erenderer.addSeriesRenderer(renderer2);
        erenderer.setZoomButtonsVisible(true);
        Intent intenet1= ChartFactory.getScatterChartIntent(con, dataset, erenderer, "Scatter Graph Title");
        return intenet1;
    }

  }
