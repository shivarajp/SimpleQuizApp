package com.example.quizappTest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.graphsdemos.R;

public class MainActivity extends Activity {
    Button bt1,bt2,bt3,bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=(Button)findViewById(R.id.bargraph);
        bt2=(Button)findViewById(R.id.linegraph);
        bt3=(Button)findViewById(R.id.scattergraph);
        bt4=(Button)findViewById(R.id.Piegraph);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BarGraph l1=new BarGraph(12,13,14);
                Intent i1=l1.getIntenet(getApplicationContext());
                try
                {
                    startActivity(i1);
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LineGraph l1=new LineGraph();
                Intent i1=l1.getIntenet(getApplicationContext());
                try
                {
                    startActivity(i1);
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScatterGraph l1=new ScatterGraph();
                Intent i1=l1.getIntent(getApplicationContext());
                try
                {
                    startActivity(i1);
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }

        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PieGraph l1=new PieGraph(12,13,14);
               /* Intent i1=l1.getIntent(getApplicationContext());
                try
                {

                    startActivity(i1);
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }*/
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}