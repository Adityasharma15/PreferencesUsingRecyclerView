package com.example.aditya.preferencesusingrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
{
    public ArrayList<Person> people;

    public interface itemClicked
    {
        void onitemClicked(int index );
    }


    public PersonAdapter(Context context, ArrayList<Person> list)
    {
        people = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivPref;
        TextView tvname;
        TextView tvSurnmae;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPref = itemView.findViewById(R.id.ivPref);
            tvname = itemView.findViewById(R.id.tvname);
            tvSurnmae = itemView.findViewById(R.id.tvSurname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }



    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int i) {
    //Runs exactly times the number of people we have, i.e. runs for all the objects;

        viewHolder.itemView.setTag(people.get(i));

        viewHolder.tvname.setText(people.get(i).getName());
        viewHolder.tvSurnmae.setText(people.get(i).getSurname());

        if (people.get(i).getPreference().equals("bus"))
        {
            viewHolder.ivPref.setImageResource(R.drawable.bus);
        }

        if(people.get(i).getPreference().equals("plane"))
        {
            viewHolder.ivPref.setImageResource(R.drawable.plane);
        }

        if(people.get(i).getPreference().equals("train"))
        {
            viewHolder.ivPref.setImageResource(R.drawable.train);
        }


    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
