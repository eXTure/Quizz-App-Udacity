package com.example.tomas.musicquiz;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainQuiz extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";
    public static final String EXTRA_MESSAGE_TWO = "";

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
        Button button = findViewById(R.id.song_button);
        button.setClickable(false);
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
     * Intent to switch to results activity screen when the button "Complete Quiz" is clicked
     */
    public void toResultsActivity(View view) {
        questionSevenFieldCheck();
        checkboxQuestion();
        Intent intent = new Intent(this, ResultsActivity.class);
        String scoreString = score + "";
        intent.putExtra(EXTRA_MESSAGE, scoreString);
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

    public void checkboxQuestion() {
        boolean choice1 = true;
        boolean choice2 = false;
        boolean choice3 = false;
        CheckBox questionOneBox = findViewById(R.id.checkbox_choice_1);
        CheckBox questionTwoBox = findViewById(R.id.checkbox_choice_2);
        CheckBox questionThreeBox = findViewById(R.id.checkbox_choice_3);
        choice1 = questionOneBox.isChecked();
        choice2 = questionTwoBox.isChecked();
        choice3 = questionThreeBox.isChecked();
        if (choice1 == false && choice2 == true && choice3 == true) {
            score += 1;
        } else {
            score += 0;
        }
    }

    public void questionSevenFieldCheck() {
        EditText editText = findViewById(R.id.question_seven_edit_field);
        String fieldCheck = editText.getText().toString().toLowerCase();

        if (fieldCheck.equals("paul") || fieldCheck.equals("gene") || fieldCheck.equals("tommy") || fieldCheck.equals("eric")) {
            score += 1;
        } else {
            score += 0;
        }
    }
}
