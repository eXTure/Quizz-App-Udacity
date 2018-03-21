package com.example.tomas.musicquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {

    String resultMessage;
    int resultScore;

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
        resultScore = Integer.parseInt(intent.getStringExtra(MainQuiz.EXTRA_MESSAGE));
        TextView textView = findViewById(R.id.result_answer);
        String result00Msg = getResources().getString(R.string.result_text_00);
        String intentMessageText = result00Msg + resultScore;

        String result0Msg = getResources().getString(R.string.result_text_0);
        String result1Msg = getResources().getString(R.string.result_text_1);
        String result2Msg = getResources().getString(R.string.result_text_2);
        String result3Msg = getResources().getString(R.string.result_text_3);
        String result4Msg = getResources().getString(R.string.result_text_4);
        String result5Msg = getResources().getString(R.string.result_text_5);
        String result6Msg = getResources().getString(R.string.result_text_6);
        String result7Msg = getResources().getString(R.string.result_text_7);

        switch (Integer.parseInt(resultMessage)) {
            case 0:
                intentMessageText += " " + result0Msg;
                break;
            case 1:
                intentMessageText += " " + result1Msg;
                break;
            case 2:
                intentMessageText += " " + result2Msg;
                break;
            case 3:
                intentMessageText += " " + result3Msg;
                break;
            case 4:
                intentMessageText += " " + result4Msg;
                break;
            case 5:
                intentMessageText += " " + result5Msg;
                break;
            case 6:
                intentMessageText += " " + result6Msg;
                break;
            case 7:
                intentMessageText += " " + result7Msg;
                break;
        }
        textView.setText(intentMessageText);
    }

    /**
     * Intent to switch to the welcome activity when the button "Try Again" is clicked
     */
    public void toBeginning(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        String msg = getResources().getString(R.string.onBackPressed_message);
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, msg, duration);
        toast.show();
    }

    /**
     * Share the result to the app of your choise when the button "Share" is clicked
     */
    public void shareButton(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String msg1 = getResources().getString(R.string.shareButton_text_1);
        String msg2 = getResources().getString(R.string.shareButton_text_2);
        String shareText = msg1 + " " + resultScore + " " + msg2;
        intent.putExtra(Intent.EXTRA_TEXT, shareText);
        String msg3 = getResources().getString(R.string.shareButton_text_3);
        startActivity(Intent.createChooser(intent, msg3));
    }
}
