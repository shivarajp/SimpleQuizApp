package com.example.quizappTest;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Quiztest extends Activity {

    private static  final  String TABLE_TOURS="questions1";
    private CountDownTimer countDownTimer;
    private  long startTime = 30 * 1000;
    private final long interval = 1 * 1000;
    int i=1,no_of_correct=0,att=0;

    String prev;
    SQLiteOpenHelper dbhelpher;
    List<Boolean> anslist=new ArrayList<Boolean>();
    List<quizdb> qList = new ArrayList<quizdb>();
    Time t1;
    TextView txtques,text;
    RadioButton opt1,opt2,opt3,opt4;
    Button next;
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiztest);
        intial();
        getvalues();
        intialise();

      // t1 =new Time();
       // text.setText( String.valueOf(startTime/1000));
        startTime=qList.size()*30*1000;

        countDownTimer = new MyCountDownTimer(startTime, interval);
        countDownTimer.start();

    }

     public void intial()
     {
         txtques=(TextView)findViewById(R.id.txtques);
         text=(TextView)findViewById(R.id.timer);
         opt1=(RadioButton)findViewById(R.id.opt1);
         opt2=(RadioButton)findViewById(R.id.opt2);
         opt3=(RadioButton)findViewById(R.id.opt3);
         opt4=(RadioButton)findViewById(R.id.opt4);
         next=(Button)findViewById(R.id.btnnext);
         rg=(RadioGroup)findViewById(R.id.rdgroup);
         next.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 next();
             }
         });
     }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public  void evaluate()
    {
        try
        {
        float result=(no_of_correct*100)/qList.size();
        Bundle b1=new Bundle();
        b1.putInt("noofatt",att);
        b1.putInt("noofcorr",no_of_correct);
        b1.putInt("noofques",qList.size());
        b1.putDouble("per",result);

      Intent intenet1=new Intent("com.example.quizappTest.Resultdis");
        intenet1.putExtras(b1);
        startActivity(intenet1);
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
    public void test()
    {
if(opt1.isChecked()==true||opt2.isChecked()==true||opt3.isChecked()==true||opt4.isChecked()==true)
{
    att++;
}

        if((opt1.isChecked()==true) &&(qList.get(i-1).getAns().equals("A")))
        {
            anslist.add(i-1,true);
            no_of_correct++;
            //Toast.makeText(this,"The Result is :"+no_of_correct,Toast.LENGTH_LONG).show();
        }
        else
        if((opt2.isChecked()==true) &&(qList.get(i-1).getAns().equals("B")))
        {
            anslist.add(i-1,true);
            no_of_correct++;
        }
        else
        if((opt3.isChecked()==true) &&(qList.get(i-1).getAns().equals("C")))
        {
            anslist.add(i-1,true);
            no_of_correct++;
        }
        else

        if((opt4.isChecked()==true) &&(qList.get(i-1).getAns().equals("D")))
        {
            anslist.add(i-1,true);
            no_of_correct++;
        }
        else
        {
            anslist.add(i-1,false);
        }


    }
    public void next()
    {
       boolean res;
        test();
        final   quizdb quizc=new quizdb(qList.get(i));
        txtques.setText(quizc.getQues());
        opt1.setText(quizc.getOpt1());
        opt2.setText(quizc.getOpt2());
        opt3.setText(quizc.getOpt3());
        opt4.setText(quizc.getOpt4());

         i++;
        if(i>=qList.size())
        {
            next.setText("Done");
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    try
                    {
                    test();

                   evaluate();
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"Error"+e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

          rg.clearCheck();

    }
    public void getvalues()
    {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_TOURS;
        dbhelpher=new samdatabase(this);
        SQLiteDatabase db = dbhelpher.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                quizdb quizc=new quizdb();
                quizc.setQues(cursor.getString(0));
                quizc.setAns(cursor.getString(1));
                quizc.setOpt1(cursor.getString(2));
                quizc.setOpt2(cursor.getString(3));
                quizc.setOpt3(cursor.getString(4));
                quizc.setOpt4(cursor.getString(5));
                qList.add(quizc);
            } while (cursor.moveToNext());
        }
    }
    public void intialise()
    {
        final   quizdb quizc=new quizdb(qList.get(0));
        txtques.setText(quizc.getQues());
        opt1.setText(quizc.getOpt1());
        opt2.setText(quizc.getOpt2());
        opt3.setText(quizc.getOpt3());
        opt4.setText(quizc.getOpt4());

    }

    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {

           test();
            evaluate();

        }

        @Override
        public void onTick(long millisUntilFinished) {
            String result =  String.format("%02d:%02d", (millisUntilFinished / 1000)/60, (millisUntilFinished / 1000)%60);
            text.setText("" + result);
        }
    }

}
