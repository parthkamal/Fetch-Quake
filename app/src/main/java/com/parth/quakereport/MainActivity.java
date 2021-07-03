package com.parth.quakereport;

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

        //defining the data source to link it to the adapter
        ArrayList<String> earthquakes = new ArrayList<>();
        earthquakes.add("San Francisco");
        earthquakes.add("London");
        earthquakes.add("Tokyo");
        earthquakes.add("Mexico City");
        earthquakes.add("Moscow");
        earthquakes.add("Rio de Janeiro");
        earthquakes.add("Paris");


        //declaring the standard adapter and provided the context and the layout resource to it
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.llist_items,earthquakes);

        //providing the list view to add the adapter to it
        ListView listView =findViewById(R.id.earthquakes_list);

        //setting the adapter to the list view
        listView.setAdapter(adapter);

    }
}