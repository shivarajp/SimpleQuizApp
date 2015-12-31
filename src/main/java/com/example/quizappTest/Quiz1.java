package com.example.quizappTest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Quiz1 extends Activity {

    Button addques,remques,quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz1);
        addques=(Button)findViewById(R.id.addques);
        remques=(Button)findViewById(R.id.remques);
        quiz=(Button)findViewById(R.id.btnquiz);
        addques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent intent1=new Intent("com.example.quizappTest.Addquestion");
                startActivity(intent1);
            }
        });
        remques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent("com.example.quizappTest.Removequestion");
                startActivity(intent1);
            }
        });
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent("com.example.quizappTest.Quiztest");
                startActivity(intent2);
            }
        });
    }



    
}
