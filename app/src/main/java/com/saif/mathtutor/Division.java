package com.saif.mathtutor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Division extends AppCompatActivity {

    int firstNumber;
    int secondNumber;
    private TextView firstAddTextView, secondAddTextView;
    private TextView correctTextView, wrongTextView;
    Random random = new Random();
    double correctAnswer;
    int wrongAnswer;
    int counter = 0;
    int correctAnswerCounter;
    String correctAnsString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);

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
                wrongTextView.setText(Double.toString( random.nextInt(5)+10));


                newQuestion();

            }
        });


    }

    public void newQuestion(){
        firstNumber = random.nextInt(11);
        secondNumber = random.nextInt(11) + 1;
        correctAnswer =  (double) firstNumber / secondNumber;
        firstAddTextView.setText(Integer.toString(firstNumber));
        secondAddTextView.setText(Integer.toString(secondNumber));
        correctTextView.setText("" + correctAnswer);
        wrongTextView.setText("" + Double.toString(random.nextInt(10)+5));
    }
}