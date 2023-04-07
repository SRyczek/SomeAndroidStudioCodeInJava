package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public TextView first;
    public TextView second;
    public TextView disp;
    public Button divButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        disp = findViewById(R.id.Display);
        divButton = findViewById(R.id.button2);

        divButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                int firstValue = Integer.parseInt(first.getText().toString());
                int secondValue = Integer.parseInt(second.getText().toString());
                int div = firstValue - secondValue;
                disp.setText(Integer.toString(div));
                Toast.makeText(MainActivity.this, String.valueOf(div), Toast.LENGTH_SHORT).show();
            }

        });



    }

    public void calc(View V)
    {
       int firstValue = Integer.parseInt(first.getText().toString());
       int secondValue = Integer.parseInt(second.getText().toString());
       int sum = firstValue + secondValue;
       disp.setText(Integer.toString(sum));
    }


}