package com.example.stoper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
   public Button start;
   public Button stop;
   public TextView timer;
   long now, time, init, stopValue, initStop;
   boolean running;
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      timer =  findViewById(R.id.time);
      start = findViewById(R.id.startButton);
      stop = findViewById(R.id.stopButton);
      Handler handler = new Handler();
      running = false;
      final Runnable updater = new Runnable()
      {
         @Override
         public void run()
         {
            if(running == true)
            {
               now = System.currentTimeMillis();
               time = now - init - stopValue;
               timer.setText(time / 1000 + ":" + (time / 10) % 100);
               handler.postDelayed(this, 30);
            }
         }
      };

      start.setOnClickListener(new View.OnClickListener()
      {
         @Override
         public void onClick(View v)
         {
            start.setText("Restart");
            stop.setText("Stop");
            running = true;
            stopValue = 0;
            init = System.currentTimeMillis();
            handler.post(updater);
         }
      });

      stop.setOnClickListener(new View.OnClickListener()
      {
         @Override
         public void onClick(View v)
         {
            if(running == true)
            {
               initStop = System.currentTimeMillis();
               stop.setText("Resume");
            }
            else if(running == false)
            {
               stopValue = stopValue  + System.currentTimeMillis() - initStop;
               stop.setText("Stop");
            }
            running = !running;
            handler.post(updater);
         }
      });


   }
}