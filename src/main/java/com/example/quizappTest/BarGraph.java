package com.example.quizappTest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/**
 * Created by raghav on 10/08/13.
 */
public class BarGraph {
    int ques,att,corr,wrong;
    public BarGraph(int a,int b,int c)
    {
        ques=a;
        att=b;
        corr=c;
        wrong=ques-corr;
    }
    public Intent getIntenet( Context con)
    {

        CategorySeries series1=new CategorySeries("No Of Question");
        CategorySeries series=new CategorySeries("No Of Ques. Attempted");
        CategorySeries series2=new CategorySeries("No Of Answer Correct");
        CategorySeries series3=new CategorySeries("No Of Answer Wrong");

            series1.add("Question",ques);
        series.add("Attempts",att);
        series2.add("Answer Correct",corr);
        series3.add("Wrong Answer",wrong);



        XYMultipleSeriesDataset dataset=new XYMultipleSeriesDataset();
        dataset.addSeries(series1.toXYSeries());
        dataset.addSeries(series.toXYSeries());
        dataset.addSeries(series2.toXYSeries());
        dataset.addSeries(series3.toXYSeries());
        XYMultipleSeriesRenderer erenderer=new XYMultipleSeriesRenderer();
        XYSeriesRenderer renderer=new XYSeriesRenderer();
        renderer.setDisplayChartValues(true);
        renderer.setChartValuesSpacing((float) 0.5);
        renderer.setColor(Color.RED);
        XYSeriesRenderer renderer2=new XYSeriesRenderer();
        renderer2.setDisplayChartValues(true);
        renderer2.setChartValuesSpacing((float) 0.5);
        renderer2.setColor(Color.BLUE);
        XYSeriesRenderer renderer3=new XYSeriesRenderer();
        renderer3.setDisplayChartValues(true);
        renderer3.setChartValuesSpacing((float) 0.5);
        renderer3.setColor(Color.GREEN);
        XYSeriesRenderer renderer4=new XYSeriesRenderer();
        renderer4.setDisplayChartValues(true);
        renderer4.setChartValuesSpacing((float) 0.5);
        renderer4.setColor(Color.CYAN);
        erenderer.addSeriesRenderer(renderer);
        erenderer.addSeriesRenderer(renderer2);
        erenderer.addSeriesRenderer(renderer3);
        erenderer.addSeriesRenderer(renderer4);
         erenderer.setChartTitle("Demo");
         erenderer.setXTitle("X Values");
        erenderer.setYTitle("Y Values");
        erenderer.setZoomButtonsVisible(true);
        Intent intenet1= ChartFactory.getBarChartIntent(con, dataset, erenderer, BarChart.Type.DEFAULT, "Bar Graph Title");
        return intenet1;
    }
}
