package com.example.quizappTest;

import android.content.Context;
import android.graphics.Color;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

/**
 * Created by raghav on 10/08/13.
 */
public class PieGraph {
    int ques,att,corr,wrong;
    public PieGraph(int a,int b,int c)
    {
        ques=a;
        att=b;
        corr=c;
        wrong=ques-corr;
    }
    public GraphicalView getIntent(Context con)
    {
        //Intent intenet1=null;

    int values[]={ques,att,corr,wrong};
    CategorySeries series=new CategorySeries("Pie Graph");
    int k=0;

        series.add("No Of Question",values[0]);
            series.add("No Of Attempts",values[1]);
            series.add("No Of Answer Correct",values[2]);
            series.add("No Of Answer Wrong",values[3]);

        int colors[]={Color.YELLOW,Color.BLUE,Color.GREEN,Color.RED};

        DefaultRenderer renderer=new DefaultRenderer();
         for(int color:colors)
         {
             SimpleSeriesRenderer sr=new SimpleSeriesRenderer();
             sr.setColor(color);

             renderer.addSeriesRenderer(sr);
         }
         renderer.setApplyBackgroundColor(true);
            renderer.setDisplayValues(true);
            renderer.setBackgroundColor(Color.BLACK);
        //intenet1= ChartFactory.getPieChartIntent(con, series, renderer, "Marks Chart Title");


        return (ChartFactory.getPieChartView(con, series, renderer));
    }


   }
