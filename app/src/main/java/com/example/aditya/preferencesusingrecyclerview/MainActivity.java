package com.example.aditya.preferencesusingrecyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.itemClicked
{

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    Button button , button2, button3;

    ArrayList<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("This User", "***", "plane"));
                myAdapter.notifyDataSetChanged();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("This User", "***", "train"));
                myAdapter.notifyDataSetChanged();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("This User", "***", "train"));
                myAdapter.notifyDataSetChanged();
                
                
            }
        });

        recyclerView = findViewById(R.id.list);

        //size doesn't change depending upon number of items in the list
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        /*  SOME OTHER POSSIBLE LAYOUT MANAGERS OPTIONS:

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
                -> the false in the last indicates that list don't start in reverse

        layoutManager = new GridLayoutManager(this, 2,LinearLayoutManager.VERTICAL,false);

        */
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<Person>();

        people.add(new Person("Aditya", "Sharma", "train"));
        people.add(new Person("Humble" , "Fool" , "plane"));
        people.add(new Person("Tom", "Cruise" , "bus"));
        people.add(new Person("Rohit", "Sharma", "plane"));
        people.add(new Person("Mathew" , "Man" , "plane"));
        people.add(new Person("Ricky", "Ponting" , "bus"));
        people.add(new Person("Joff", "Henry", "bus"));
        people.add(new Person("Harry" , "Staleer" , "plane"));
        people.add(new Person("Tom", "Hardy" , "train"));
        people.add(new Person("Steven", "Archer", "train"));
        people.add(new Person("Joffra" , "Smith" , "plane"));
        people.add(new Person("Hayden", "George" , "bus"));
        people.add(new Person("Oliver", "Hayden", "train"));
        people.add(new Person("George." , "Rayan" , "bus"));
        people.add(new Person("Harry", "Smith" , "plane"));
        people.add(new Person("Noah", "Sharma", "train"));
        people.add(new Person("Charlie" , "Cruise" , "train"));
        people.add(new Person("Mathew", "Cruise" , "pane"));


        myAdapter = new PersonAdapter(this, people);

        recyclerView.setAdapter(myAdapter);


    }

    @Override
    public void onitemClicked(int index) {

    }
}
