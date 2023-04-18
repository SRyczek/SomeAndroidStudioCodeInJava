package com.example.stoper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
   public Button start, save, stop;
   public TextView timer;
   long now, time, init, stopValue, initStop;
   boolean running;
   RecyclerView recyclerView;



   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      timer =  findViewById(R.id.time);
      start = findViewById(R.id.startButton);
      stop = findViewById(R.id.stopButton);
      save = findViewById(R.id.saveButton);

      Handler handler = new Handler();
      running = false;

      RecyclerView recyclerView = findViewById(R.id.recyclerView);

      ArrayList<timeData> items = new ArrayList<timeData>();
      items.add(new timeData(10, 10));
      items.add(new timeData(12, 13));
      recyclerView.setLayoutManager(new LinearLayoutManager(this));
      recyclerView.setAdapter(new myAdapter(getApplicationContext(), items));


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
      save.setOnClickListener(new View.OnClickListener()
      {
         @Override
         public void onClick(View v)
         {
            items.add(new timeData(12, 13));
            recyclerView.setAdapter(new myAdapter(getApplicationContext(), items));
         }

      });

   }
}