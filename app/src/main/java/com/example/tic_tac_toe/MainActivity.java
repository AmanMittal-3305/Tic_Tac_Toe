package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    EditText editText;

    EditText editText1;

    String btnfirst;

    int flag = 0;
    int count = 0;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        editText1 = findViewById(R.id.editTextText3);
        editText1.setFocusable(false); // Disable user input
        editText1.setFocusableInTouchMode(false); // Disable touch mode

        editText = findViewById(R.id.editTextText2);
        editText.setFocusable(false); // Disable user input
        editText.setFocusableInTouchMode(false); // Disable touch mode
    }
    private void init(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);


    }

    public void Check(View view){


        Button btnCurr = (Button) view;
        if(btnCurr.getText().toString().equals("")) {
            count++;
            if (flag == 0) {
                btnCurr.setText("X");
                flag = 1;


            } else {
                btnCurr.setText("0");
                flag = 0;


            }
            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();
                Animation x_win = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.x_win);
                Animation win_0 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.win_0);
                Animation draw = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.win_0);

                //conditions
                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    //1

                    editText1.setText("🎯 Winner - " + b1 + " 🎯");
                    btnfirst = b1;
                    declaring_result(btnfirst);


                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    //2
                    editText1.setText("🎯 Winner - " + b4 + " 🎯");
                    btnfirst = b4;
                    declaring_result(btnfirst);
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    //3
                    editText1.setText("🎯 Winner - " + b7 +" 🎯");
                    btnfirst = b7;
                    declaring_result(btnfirst);
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    //4
                    editText1.setText("🎯 Winner - " + b1 + " 🎯");
                    btnfirst = b1;
                    declaring_result(btnfirst);
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    //5
                    editText1.setText("🎯 Winner - " + b2 + " 🎯");
                    btnfirst = b2;
                    declaring_result(btnfirst);
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    //6
                    editText1.setText("🎯 Winner - " + b3 + " 🎯");
                    btnfirst = b3;
                    declaring_result(btnfirst);
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    //7
                    editText1.setText("🎯 Winner - " + b1 + " 🎯");
                    btnfirst = b1;
                    declaring_result(btnfirst);
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    //8
                    editText1.setText("🎯 Winner - " + b3  + " 🎯");
                    btnfirst = b3;
                    declaring_result(btnfirst);
                } else if (count == 9) {
                    // Draw
                    editText1.setText("😯 It's a draw! 😯");
                    editText1.startAnimation(draw);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            resetGame();
                            editText1.setText("");
                        }
                    }, 4000);
                }
                }
            }
        }

    private void declaring_result(String btnfirst){
        Animation x_win = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.x_win);
        Animation win_0 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.win_0);
        Animation draw = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.win_0);
        if(b1 == "X"){
            editText1.startAnimation(x_win);
        } else {
            editText1.startAnimation(win_0);
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                resetGame();
                editText1.setText("");
            }
        }, 4000);
    }

    private void resetGame() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count = 0;
        flag = 0;
    }
    }


