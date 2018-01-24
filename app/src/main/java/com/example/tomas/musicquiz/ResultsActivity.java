package com.example.tomas.musicquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    String resultMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        /**
         * Get the answer of the quiz from the previous activity
         * and display it to the screen when the activity is loaded
         */
        Intent intent = getIntent();
        resultMessage = intent.getStringExtra(MainQuiz.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.result_answer);
        textView.setText(resultMessage);
    }

    /**
     * Intent to switch to the welcome activity when the button is clicked
     */
    public void toBeginning(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    /**
     * Share the result to the app of your choise when the button is clicked
     */
    public void shareButton(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String shareText = "My result:\n" + resultMessage;
        intent.putExtra(Intent.EXTRA_TEXT, shareText);
        startActivity(Intent.createChooser(intent, "Choose where to share!"));
    }
}
