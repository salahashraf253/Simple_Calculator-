package com.example.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import org.mariuszgromada.math.mxparser.*;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=findViewById(R.id.input);
        display.setShowSoftInputOnFocus(true);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ok=true;
                String s=getString(R.string.display);
                String s2="Enter in a value";
                Compare c =new Compare(s,s2);
                if(c.compare_Strings()){
                    display.setText("");
                }
            }
        });
    }
    private void updateText(String strToAdd){
        String oldstr=display.getText().toString();
        int cursorPos=display.getSelectionStart();
        String leftstr=oldstr.substring(0,cursorPos);
        String rigthstr=oldstr.substring(cursorPos);
        //.......................
        String s=getString(R.string.display);
        String s2=display.getText().toString();
        Compare c =new Compare(s,s2);
        if(c.compare_Strings()){
            display.setText(strToAdd);
            display.setSelection(cursorPos+1);
        }
        else {
            display.setText(String.format("%s%s%s",leftstr,strToAdd,rigthstr));
            display.setSelection(cursorPos+1);
        }

    }
    public void BTN0(View view){
        updateText("0");
    }
    public void BTN1(View view){
        updateText("1");

    }
    public void BTN2(View view){
        updateText("2");

    }
    public void BTN3(View view){
        updateText("3");

    }
    public void BTN4(View view){
        updateText("4");

    }
    public void BTN5(View view){
        updateText("5");

    }
    public void BTN6(View view){
        updateText("6");

    }
    public void BTN7(View view){
        updateText("7");

    }


    public void BTN8(View view){
        updateText("8");

    }

    public void BTN9(View view){
        updateText("9");

    }

    public void BTN_add(View view){
        updateText("+");

    }
    public void BTN_subtract(View view){
        updateText("-");

    }
    public void BTN_multiply(View view){
        updateText("*");

    }
    public void BTN_divide(View view){
        updateText("/");

    }
    public void BTN_plusMinus(View view){
        updateText("-");
    }

    public void BTN_point(View view){
        updateText(".");
    }

    public void BTN_exp(View view){
        updateText("^");

    }

    public void BTN_clear(View view){
        int cursorPos=display.getSelectionStart();
        int textLen =display.getText().length();

        if(cursorPos !=0 && textLen !=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void BTN_par(View view){
        int cursoPos=display.getSelectionStart();
        int openPar=0;
        int closedPar=0;
        int textLen=display.getText().length();
        for(int i=0;i<cursoPos;i++){
            if(display.getText().toString().substring(i,i+1).equals("(")){
                openPar+=1;
            }
            if(display.getText().toString().substring(i,i+1).equals(")")){
                closedPar+=1;
            }
        }
        if(openPar==closedPar || display.getText().toString().substring(textLen-1,textLen).equals("(")){
            updateText("(");
        }
        else if(closedPar<openPar && !display.getText().toString().substring(textLen-1,textLen).equals(")")){
            updateText(")");
        }
        display.setSelection(cursoPos+1);
    }

    public void BTN_equal(View view){
        String userExp=display.getText().toString();
        Expression exp=new Expression(userExp);
        String result=String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());


    }

}