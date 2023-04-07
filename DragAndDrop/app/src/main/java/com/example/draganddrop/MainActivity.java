package com.example.draganddrop;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.jmedeisis.draglinearlayout.DragLinearLayout;


public class MainActivity extends AppCompatActivity
{

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      DragLinearLayout dragLinearLayout = (DragLinearLayout) findViewById(R.id.container);
      for(int i = 0; i < dragLinearLayout.getChildCount(); i++){
         View child = dragLinearLayout.getChildAt(i);
         // the child will act as its own drag handle
         dragLinearLayout.setViewDraggable(child, child);
      }


   }
}