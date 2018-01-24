package com.example.tomas.musicquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainQuiz extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.tomas.musicquiz.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz);
    }

    public int score = 0;

    /**
     * Method to play the song "Thanks"
     */
    public void playSongThanks(View view) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.thankscut);
        mediaPlayer.start();
    }

    /**
     * Method to play the note G
     */
    public void playNote(View view) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.note);
        mediaPlayer.start();
    }

    /**
     * Intent to switch to results activity screen when the button is clicked
     * Switch statement to choose the correct result based on the score
     */
    public void toResultsActivity(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);
        //String toastMessage = "The score is: " + score;
        String intentMessageText = "";
        switch (score) {
            case 0:
                intentMessageText = "Correct answers:\n0 out of 5\nTry again!";
                break;
            case 1:
                intentMessageText = "Correct answers:\n1 out of 5\nTry again!";
                break;
            case 2:
                intentMessageText = "Correct answers:\n2 out of 5\nNot bad!\nTry again";
                break;
            case 3:
                intentMessageText = "Correct answers:\n3 out of 5\nAlmost!";
                break;
            case 4:
                intentMessageText = "Correct answers:\n4 out of 5\nGood job!\nCan you answer all of them correctly?";
                break;
            case 5:
                intentMessageText = "Correct answers:\n5 out of 5\nExcellent!\nYou are a pro musician!";
                break;
        }
        //Toast.makeText(MainQuiz.this, toastMessage, Toast.LENGTH_SHORT).show();
        intent.putExtra(EXTRA_MESSAGE, intentMessageText);
        startActivity(intent);
    }

    /**
     * Checks the choise of question one
     */
    public void radioButtonQuestionOne(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.volbeat:
                if (checked)
                    score += 1;
                break;
            case R.id.metallica:
                if (checked)
                    score += 0;
                break;
            case R.id.ozzy:
                if (checked)
                    score += 0;
                break;
        }
    }

    /**
     * Checks the choise of question two
     */
    public void radioButtonQuestionTwo(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.the_calling:
                if (checked)
                    score += 0;
                break;
            case R.id.tenacious:
                if (checked)
                    score += 1;
                break;
            case R.id.eurythmics:
                if (checked)
                    score += 0;
                break;
        }
    }

    /**
     * Checks the choise of question three
     */
    public void radioButtonQuestionThree(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.mandolin:
                if (checked)
                    score += 0;
                break;
            case R.id.guitar:
                if (checked)
                    score += 0;
                break;
            case R.id.ukulele:
                if (checked)
                    score += 1;
                break;
        }
    }

    /**
     * Checks the choise of question four
     */
    public void radioButtonQuestionFour(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.do_note:
                if (checked)
                    score += 0;
                break;
            case R.id.sol_note:
                if (checked)
                    score += 1;
                break;
            case R.id.la_note:
                if (checked)
                    score += 0;
                break;
        }
    }

    /**
     * Checks the choise of question five
     */
    public void radioButtonQuestionFive(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.date_one:
                if (checked)
                    score += 1;
                break;
            case R.id.date_two:
                if (checked)
                    score += 0;
                break;
            case R.id.date_three:
                if (checked)
                    score += 0;
                break;
        }
    }
}
