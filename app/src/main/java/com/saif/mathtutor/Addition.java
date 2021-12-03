package com.saif.mathtutor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Addition extends AppCompatActivity {

    int firstNumber;
    int secondNumber;
    private TextView firstAddTextView, secondAddTextView;
    private TextView correctTextView, wrongTextView;
    Random random = new Random();
    int correctAnswer;
    int wrongAnswer;
    int counter = 0;
    int correctAnswerCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        firstAddTextView = findViewById(R.id.firstAddTextview);
        secondAddTextView = findViewById(R.id.secondAddTextView);
        correctTextView = findViewById(R.id.correctTextView);
        wrongTextView = findViewById(R.id.wrongTextView);
        newQuestion();

        correctTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctAnswerCounter++;
                counter++;
                correctTextView.setText("" + correctAnswer);
                newQuestion();
                if (counter == 10){
                    Toast.makeText(getApplicationContext(),
                            "you got " + correctAnswerCounter + " out of "+ 10,
                            Toast.LENGTH_LONG).show();
                    finish();
                }

            }
        });

        wrongTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if (counter == 10){
                    Toast.makeText(getApplicationContext(), "you got " + correctAnswerCounter
                            + " out of " + 10 ,
                            Toast.LENGTH_LONG).show();
                    finish();
                }
                wrongTextView.setText(Integer.toString(firstNumber + random.nextInt(20)));


                newQuestion();

            }
        });
    }

    public void newQuestion(){
        firstNumber = random.nextInt(11);
        secondNumber = random.nextInt(11);
        correctAnswer = firstNumber + secondNumber;
        firstAddTextView.setText(Integer.toString(firstNumber));
        secondAddTextView.setText(Integer.toString(secondNumber));
        correctTextView.setText("" + correctAnswer);
        wrongTextView.setText("" + Integer.toString(firstNumber + random.nextInt(20)));
    }


}