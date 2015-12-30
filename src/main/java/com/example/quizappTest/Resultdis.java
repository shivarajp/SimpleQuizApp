package com.example.quizappTest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graphsdemos.R;

import org.achartengine.GraphicalView;

public class Resultdis extends Activity {
 TextView t1,t2,t3,t4;
    Button bt1,bt2;
    Bundle b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultdis);
       b1=getIntent().getExtras();
        initial();

    }

public  void initial()
{
    t1=(TextView)findViewById(R.id.noofques);
    t2=(TextView)findViewById(R.id.no_of_att);
    t3=(TextView)findViewById(R.id.noofcorr);
    t4=(TextView)findViewById(R.id.per);
    bt1=(Button)findViewById(R.id.btngrph);
   //bt2=(Button)findViewById(R.id.rbargraph);
    t1.append(b1.getInt("noofques") + " ");
    t2.append(b1.getInt("noofatt")+"");
    t3.append(b1.getInt("noofcorr")+"");
    t4.append(b1.getDouble("per")+"");

    bt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
  try
  {
      PieGraph l1=new PieGraph(b1.getInt("noofques"),b1.getInt("noofatt"),b1.getInt("noofcorr"));
     //Intent i1=l1.getIntent(getApplicationContext());
      try
      {
          GraphicalView g1=l1.getIntent(getApplicationContext());
          LinearLayout layout1=(LinearLayout)findViewById(R.id.layout1);
          layout1.addView(g1);
       //   startActivity(i1);
      }
      catch (Exception e)
      {
          Toast.makeText(getApplicationContext(),"worked",Toast.LENGTH_LONG).show();
      }
  }
  catch (Exception e)
  {
      Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
  }
        }
    });
   // Toast.makeText(Resultdis.this,"YES",Toast.LENGTH_LONG).show();
   /* bt2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try
            {
                BarGraph l1=new BarGraph(b1.getInt("noofques"),b1.getInt("noofatt"),b1.getInt("noofcorr"));
                Intent i1=l1.getIntenet(getApplicationContext());
                try
                {

                    startActivity(i1);
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"worked",Toast.LENGTH_LONG).show();
                }
            }
            catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
    });
    */

}

    
}
