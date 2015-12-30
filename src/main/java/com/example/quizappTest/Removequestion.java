package com.example.quizappTest;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.graphsdemos.R;

import java.util.ArrayList;
import java.util.List;

public class Removequestion extends Activity {

    SQLiteOpenHelper dbhelpher;
    private static  final  String COLUMN1="ques";
    List<String> contactList = new ArrayList<String>();
    private static  final  String TABLE_TOURS="questions1";
    ListView lv;
    Button del,clr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.removequestion);
         lv=(ListView)findViewById(R.id.listView);
        getvalues();
        final ArrayAdapter adapter = new ArrayAdapter(Removequestion.this,android.R.layout.simple_list_item_checked, contactList);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        del=(Button)findViewById(R.id.btndel);
        clr=(Button)findViewById(R.id.btnclr);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray checked = lv.getCheckedItemPositions();
                for(int i=0;i<lv.getCount();i++)
                {
                   if(checked.get(i))
                   {
                       delrecord(i);
                       contactList.remove(i);
                   }
                   }
                adapter.notifyDataSetChanged();
                Toast.makeText(Removequestion.this, "Questions Deleted Successfully", Toast.LENGTH_LONG).show();


            }
        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lv.clearChoices();
                lv.requestLayout();
            }
        });


       // setListAdapter(new ArrayAdapter<String>(Removequestion.this,android.R.layout.simple_list_item_checked,contactList));
    }

public  void delrecord(int n)
{
    dbhelpher=new samdatabase(this);
    SQLiteDatabase db =dbhelpher.getWritableDatabase();
    db.delete(TABLE_TOURS, COLUMN1 + " = ?",
            new String[] { String.valueOf(lv.getItemAtPosition(n)) });
    db.close();


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


            contactList.add(cursor.getString(0));
        } while (cursor.moveToNext());
    }
}

    
}
