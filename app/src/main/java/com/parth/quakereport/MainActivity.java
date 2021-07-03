package com.parth.quakereport;
import com.parth.quakereport.adapters.earthquakeAdapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //defining the data source of an object named earthquake to link it to the adapter
       ArrayList<earthquake> earthquakes =new ArrayList<>();
       earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
       earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
       earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
       earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
       earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
       earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));
        earthquakes.add(new earthquake((int) 7.2,"San francisco","Feb 2, 2016"));



        //declaring the custom adapter for the earthquake object and providing the list of resources and layout file to it
        earthquakeAdapters adapter =new earthquakeAdapters(getApplicationContext(),R.layout.llist_items,earthquakes);



        //providing the list view to add the adapter to it
        ListView listView =findViewById(R.id.earthquakes_list);

        //setting the adapter to the list view
        listView.setAdapter(adapter);

    }
}