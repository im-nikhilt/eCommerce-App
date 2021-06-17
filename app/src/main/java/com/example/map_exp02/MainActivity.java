package com.example.map_exp02;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private TextView display2;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView2);
        display2 = findViewById(R.id.result);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if("0".equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursor = display.getSelectionStart();
        String lStr = oldStr.substring(0,cursor);
        String rStr = oldStr.substring(cursor);
        if("0".equals(display.getText().toString())){
            display.setText(strToAdd);
        }
        else{
            display.setText(String.format("%s%s%s", lStr, strToAdd, rStr));
        }
        display.setSelection(cursor+1);
    }

    public void zeroBTN(View view){
        updateText("0");
    }

    public void oneBTN(View view){
        updateText("1");
    }

    public void twoBTN(View view){
        updateText("2");
    }

    public void threeBTN(View view){
        updateText("3");
    }

    public void fourBTN(View view){
        updateText("4");
    }

    public void fiveBTN(View view){
        updateText("5");
    }

    public void sixBTN(View view){
        updateText("6");
    }

    public void sevenBTN(View view){
        updateText("7");
    }

    public void eightBTN(View view){
        updateText("8");
    }

    public void nineBTN(View view){
        updateText("9");
    }

    public void clearBTN(View view){
        display.setText("0");
        display2.setText("=0");
    }

    public void lpBTN(View view){
        updateText("(");
    }

    public void rpBTN(View view){
        updateText(")");
    }

    public void divBTN(View view){
        updateText("/");
    }

    public void mulBTN(View view){
        updateText("×");
    }

    public void minusBTN(View view){
        updateText("-");
    }

    public void plusBTN(View view){
        updateText("+");
    }

    public void equalBTN(View view){
        String userExp = display.getText().toString();
        userExp = userExp.replaceAll("×","*");

        Expression exp = new Expression(userExp);
        String res = String.valueOf(exp.calculate());

        display2.setText(res);
        display.setSelection(res.length());
    }

    public void dotBTN(View view){
        updateText(".");
    }
}