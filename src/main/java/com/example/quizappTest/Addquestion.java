package com.example.quizappTest;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.graphsdemos.R;

public class Addquestion extends Activity {
Button submit,cancel;
   EditText ques,opt1,opt2,opt3,opt4,ans;
SQLiteOpenHelper dbhelper;
 SQLiteDatabase database;
    private static  final  String DATABASE_NAME="quiz1.db";

    private static  final  int DATABASE_VERSION=1;
    private static  final  String TABLE_TOURS="questions1";

    private static  final  String COLUMN1="ques";
    private static  final  String ans1="answer";
    private static  final  String opt11="opt1";
    private static  final  String opt22="opt2";
    private static  final  String opt33="opt3";
    private static  final  String opt44="opt4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addquestion);

        submit=(Button)findViewById(R.id.btnsub);
        cancel=(Button)findViewById(R.id.btncan);
         ques=(EditText)findViewById(R.id.quest);
        ans=(EditText)findViewById(R.id.ans);
        opt1=(EditText)findViewById(R.id.opta);
        opt2=(EditText)findViewById(R.id.optb);
        opt3=(EditText)findViewById(R.id.optc);
        opt4=(EditText)findViewById(R.id.optd);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addcontact();
                clear();
            }
        });

    }
    public void clear()
    {
        ques.setText("");
        ans.setText("");
        opt1.setText("");
        opt2.setText("");
        opt3.setText("");
        opt4.setText("");
    }
public void addcontact()
{
    dbhelper=new samdatabase(this);
    database=dbhelper.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(COLUMN1,ques.getText().toString());
    values.put(ans1, ans.getText().toString());
    values.put(opt11,opt1.getText().toString());
    values.put(opt22,opt2.getText().toString());
    values.put(opt33,opt3.getText().toString());
    values.put(opt44,opt4.getText().toString());

    database.insert(TABLE_TOURS, null, values);
    database.close();
    Toast.makeText(this,"Question Added Successfully" ,Toast.LENGTH_LONG).show();
}


}
