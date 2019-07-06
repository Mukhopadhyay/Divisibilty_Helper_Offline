package com.example.disibilityhelp;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    EditText etInput;
    Button btnCheck, btnTell, btnSecond;
    TextView tvInfo,tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        etInput = findViewById(R.id.etInput);
        btnCheck = findViewById(R.id.btnCheck);
        btnTell = findViewById(R.id.btnTell);
        btnSecond = findViewById(R.id.btnSecond);
        tvInfo = findViewById(R.id.tvInfo);
        tvResult = findViewById(R.id.tvResult);

        tvInfo.setVisibility(View.GONE);
        tvResult.setVisibility(View.GONE);

        String op = getIntent().getStringExtra("operation");
        //Toast.makeText(this, op, Toast.LENGTH_LONG).show();

        final String operation = op.substring(2);
        Toast.makeText(this, operation,Toast.LENGTH_SHORT).show();

        switch (Integer.parseInt(operation)) {
            case 2:
                tvInfo.setText(getString(R.string.by2String));
                tvInfo.setVisibility(View.VISIBLE);
                break;
            case 3:
                tvInfo.setText(getString(R.string.by3String));
                tvInfo.setVisibility(View.VISIBLE);
                break;
            case 8:
                tvInfo.setText(getString(R.string.by8String));
                tvInfo.setVisibility(View.VISIBLE);
                break;
            case 9:
                tvInfo.setText(getString(R.string.by9String));
                tvInfo.setVisibility(View.VISIBLE);
                break;
            case 10:
                tvInfo.setText(getString(R.string.by10String));
                tvInfo.setVisibility(View.VISIBLE);
                break;
            case 11:
                tvInfo.setTextSize(18);
                tvInfo.setText(getString(R.string.by11String));
                tvInfo.setVisibility(View.VISIBLE);
                tvResult.setTextSize(20);
                break;
        }

        btnTell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: +919674770912"));
                startActivity(intent);
            }
        });
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "praneshmukherjee7@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Check out this app");
                intent.putExtra(Intent.EXTRA_TEXT, "Download today to learn these techniques!");

                startActivity(Intent.createChooser(intent, "Send Email!"));
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etInput.getText().toString().isEmpty()) {
                    Toast.makeText(Main3Activity.this, getString(R.string.enterNumberWarningString), Toast.LENGTH_SHORT).show();
                }
                else {
                    //Toast.makeText(Main3Activity.this, getString(R.string.numberEnteredString), Toast.LENGTH_SHORT).show();
                    String message = checkDivisibility(operation, etInput.getText().toString().trim());
                    tvResult.setText(message);
                    tvResult.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    private String checkDivisibility(String op, String input) {
        int number = Integer.parseInt(input);
        int operation = Integer.parseInt(op);
        String message = "";
        switch (operation) {
            case 2:
                if((number % 2) == 0) {
                    message = getString(R.string.as_last_digit_is)+" "+input.charAt(input.length() - 1)+"\n It is divisible by 2\nResult: " + (number / 2);
                }
                else {
                    message = getString(R.string.as_last_digit_is)+" "+input.charAt(input.length() - 1)+"\n It is not divisible by 2";
                }
                break;
            case 3:
                if((number % 3) == 0) {
                    message = "As sum of digits is divisible by 3 \n It is divisible by 3\nResult: " + (number / 3);
                }
                else {
                    message ="As sum of digits is not divisible by 3 \n It is not divisible by 3";
                }
                break;
            case 8:
                if((number % 8) == 0) {
                    message = "As the LSB 3 digits are divisible by 8 (" + input.charAt(input.length() - 3) +  input.charAt(input.length() - 2) +  input.charAt(input.length() - 1) + ")\nIt is divisible by 8\nResult: " + (number / 8);
                }
                else {
                    message = "As the LSB 3 digits are not divisible by 8 (" + input.charAt(input.length() - 3) + input.charAt(input.length() - 2) + input.charAt(input.length() - 1) + ")\nIt is not divisible by 8";
                }
                break;
            case 9:
                if((number % 9) == 0) {
                    message = "As sum of digits is divisible by 9 \n It is divisible by " + operation + "\nResult: " + (number / 9);
                }
                else {
                    message ="As sum of digits is not divisible by 9 \n It is not divisible by " + operation;
                }
                break;
            case 10:
                if(number % 10 == 0) {
                    message = "As last digit is 0,\nIt is divisible by 10\nResult: "+ (number / 10);
                }
                else {
                    message = "As last digit is not 0,\nIt is not divisible by 10";
                }
                break;
            case 11:
                int eSum = 0;
                int oSum = 0;
                if(input.length() % 2 == 0) {
                    for(int i=0;i<input.length();i+=2) {
                        eSum += Integer.parseInt("" + input.charAt(i));
                    }
                    for(int i=1;i<input.length();i+=2) {
                        oSum += Integer.parseInt("" + input.charAt(i));
                    }
                }
                else {
                    for(int i=0;i<input.length();i+=2) {
                        oSum += Integer.parseInt("" + input.charAt(i));
                    }
                    for(int i=1;i<input.length();i+=2) {
                        eSum += Integer.parseInt("" + input.charAt(i));
                    }
                }

                int diff = oSum - eSum;
                if(number % 11 == 0) {
                    message = "As difference between the sum of digits of odd places and even places ("+ diff +") is divisible by 11\nThe number is DIVISIBLE BY 11.\nResult: "+(number/11);
                }
                else {
                    message = "As difference between the sum of digits of odd places and even places (" + diff + ") is not divisible by 11\nThe number is NOT DIVISIBLE BY 11.";
                }
                break;
        }
        return message;
    }
}
