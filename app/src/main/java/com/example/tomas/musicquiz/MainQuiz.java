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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz);
    }

    int score1;
    int score2;
    int score3;
    int score4;
    int score5;
    int score6;
    int score7;

    public void toastMaker(String msg){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, msg, duration);
        toast.show();
    }

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

        radioButtonQuestionOne();
        radioButtonQuestionTwo();
        radioButtonQuestionThree();
        radioButtonQuestionFour();
        radioButtonQuestionFive();
        checkboxQuestion();
        questionSevenFieldCheck();

        Intent intent = new Intent(this, ResultsActivity.class);
        int score = score1 + score2 + score3 + score4 + score5 + score6 + score7;
        String scoreString = score + "";
        intent.putExtra(EXTRA_MESSAGE, scoreString);
        toastMaker("Your score: " + score);
        startActivity(intent);
    }

    /**
     * Checks the choise of question one
     */
    public void radioButtonQuestionOne() {
        boolean correctChoice = false;
        RadioButton choiceView = findViewById(R.id.volbeat_rb);
        correctChoice = choiceView.isChecked();
        if (correctChoice == true){
            score1 = 1;
        }else {
            score1 = 0;
        }
    }

    /**
     * Checks the choise of question two
     */
    public void radioButtonQuestionTwo() {
        boolean correctChoice = false;
        RadioButton choiceView = findViewById(R.id.tenacious_rb);
        correctChoice = choiceView.isChecked();
        if (correctChoice == true){
            score2 = 1;
        }else {
            score2 = 0;
        }
    }

    /**
     * Checks the choise of question three
     */
    public void radioButtonQuestionThree() {
        boolean correctChoice = false;
        RadioButton choiceView = findViewById(R.id.ukulele_rb);
        correctChoice = choiceView.isChecked();
        if (correctChoice == true){
            score3 = 1;
        }else {
            score3 = 0;
        }
    }

    /**
     * Checks the choise of question four
     */
    public void radioButtonQuestionFour() {
        boolean correctChoice = false;
        RadioButton choiceView = findViewById(R.id.sol_note_rb);
        correctChoice = choiceView.isChecked();
        if (correctChoice == true){
            score4 = 1;
        }else {
            score4 = 0;
        }
    }

    /**
     * Checks the choise of question five
     */
    public void radioButtonQuestionFive() {
        boolean correctChoice = false;
        RadioButton choiceView = findViewById(R.id.date_one_rb);
        correctChoice = choiceView.isChecked();
        if (correctChoice == true){
            score5 = 1;
        }else {
            score5 = 0;
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
            score6 = 1;
        } else {
            score6 = 0;
        }
    }

    public void questionSevenFieldCheck() {
        EditText editText = findViewById(R.id.question_seven_edit_field);
        String fieldCheck = editText.getText().toString();

        if (fieldCheck.equalsIgnoreCase("paul") || fieldCheck.equalsIgnoreCase("gene") || fieldCheck.equalsIgnoreCase("tommy") || fieldCheck.equalsIgnoreCase("eric")) {
            score7 = 1;
        } else {
            score7 = 0;
        }
    }
}
