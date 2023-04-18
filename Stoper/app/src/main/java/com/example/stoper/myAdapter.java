package com.example.stoper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder>
{


   Context context;
   ArrayList<timeData> data;

   public myAdapter(Context context, ArrayList<timeData> data)
   {
      this.context = context;
      this.data = data;
   }

   @NonNull
   @Override
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
   {

      return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.my_row, parent, false));
   }

   @Override
   public void onBindViewHolder(@NonNull ViewHolder holder, int position)
   {
      timeData tD = data.get(position);
      holder.num.setText("xxx");
      holder.tim.setText("yyyy");

   }

   @Override
   public int getItemCount()
   {
      if(data != null)
      {
         return data.size();
      }
      else
      {
         return 0;
      }

   }

   public static class ViewHolder extends RecyclerView.ViewHolder
   {
      public final View view;
      public final TextView num;
      public final TextView tim;
      public ViewHolder(View view)
      {
         super(view);
         this.view = view;
         num = view.findViewById(R.id.textView);
         tim = view.findViewById(R.id.textView2);

      }

   }



}




