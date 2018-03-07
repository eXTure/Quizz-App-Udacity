package com.example.tomas.musicquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    /**
     * Intent to switch to main quiz activity when the button "Start Quizz" is clicked
     */
    public void toMainQuiz(View view) {
        Intent intent = new Intent(this, MainQuiz.class);
        startActivity(intent);
    }
}
