package com.example.quizappTest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by raghav on 07/08/13.
 */
public class samdatabase  extends SQLiteOpenHelper {

    private static  final  String LOGTAG="EXPLORECA";

    private static  final  String DATABASE_NAME="quiz1.db";

    private static  final  int DATABASE_VERSION=1;
    private static  final  String TABLE_TOURS="questions1";

    private static  final  String COLUMN1="ques";
    private static  final  String ans="answer";
    private static  final  String opt1="opt1";
    private static  final  String opt2="opt2";
    private static  final  String opt3="opt3";
    private static  final  String opt4="opt4";

    private static  final  String TABLE_CREATE=
            "CREATE TABLE "+TABLE_TOURS +" ("+
                    COLUMN1+" TEXT, "+
                    ans +" TEXT, "+opt1+" TEXT, "+opt2+" TEXT, "+opt3+" TEXT, "+opt4+" TEXT "+ ")";

    public samdatabase(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL(TABLE_CREATE);
        Log.i(LOGTAG,"Table is Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_TOURS);
        onCreate(sqLiteDatabase);
    }


}
