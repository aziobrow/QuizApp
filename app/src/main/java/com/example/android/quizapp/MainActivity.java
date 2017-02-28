package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method calculates the user's score by checking the status of each correct answer condition and assigning the user one point for each correct answer
     *
     * @param view initiated from Submit button onClick
     */
    public void finalScore(View view) {
        int pointsEarned = 0;

        // Checks status of each correct answer condition and stores each value in a boolean
        RadioButton OneD = (RadioButton) findViewById(R.id.correct_answer_one);
        boolean hasAnswerOne = OneD.isChecked();

        RadioButton TwoC = (RadioButton) findViewById(R.id.correct_answer_two);
        boolean hasAnswerTwo = TwoC.isChecked();

        CheckBox checkboxOne = (CheckBox) findViewById(R.id.incorrect_checkbox_one);
        boolean hasCheckboxOne = checkboxOne.isChecked();

        CheckBox checkboxTwo = (CheckBox) findViewById(R.id.correct_checkbox_two);
        boolean hasCheckboxTwo = checkboxTwo.isChecked();

        CheckBox checkboxThree = (CheckBox) findViewById(R.id.correct_checkbox_three);
        boolean hasCheckboxThree = checkboxThree.isChecked();

        CheckBox checkboxFour = (CheckBox) findViewById(R.id.correct_checkbox_four);
        boolean hasCheckboxFour = checkboxFour.isChecked();

        // Converts user input from EditView to lowercase string
        TextView editText = (TextView) findViewById(R.id.edit_text_input);
        String userAnswer = editText.getText().toString().toLowerCase();

        // Assigns a point for correctly answering first question
        if (hasAnswerOne) {
            pointsEarned += 1;
        }

        // Assigns a point for correctly answering second question
        if (hasAnswerTwo) {
            pointsEarned += 1;
        }

        // Assigns a point for accurately checking CheckBoxes 2-4 but not CheckBox 1
        if (hasCheckboxTwo && hasCheckboxThree && hasCheckboxFour) {
            if (!hasCheckboxOne) {
                pointsEarned += 1;
            }
        }

        // Assigns a point for entering the correct word into the EditView
        if (userAnswer.equals("have")) {
            pointsEarned += 1;
        }

        // Calls toastMessage method, passing in pointsEarned calculated within this method
        toastMessage(pointsEarned);
    }

    /**
     * This method displays a toast including the user's score and a specified message based on the number of questions the user got correct
     *
     * @param pointsEarned retrieved from the finalScore method
     */
    private void toastMessage(int pointsEarned) {
        if (pointsEarned < 3) {
            Toast.makeText(this, "You got " + pointsEarned + "/4 questions correct." + "\nKeep Studying!", Toast.LENGTH_LONG).show();
        } else if (pointsEarned < 4) {
            Toast.makeText(this, "You scored " + pointsEarned + "/4 questions correct." + "\nNot Bad!", Toast.LENGTH_LONG).show();
        } else if (pointsEarned < 5) {
            Toast.makeText(this, "You scored " + pointsEarned + "/4 questions correct." + "\nGreat Job!", Toast.LENGTH_LONG).show();
        }
    }
}
