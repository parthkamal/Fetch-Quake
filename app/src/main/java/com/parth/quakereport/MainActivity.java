package com.parth.quakereport;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.parth.quakereport.adapters.earthquakeAdapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private RequestQueue queue;
    private static final String USGS_REQUEST_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query";

    //inflating the settings menu in the activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActitvity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //defining the data source of an object named earthquake to link it to the adapter
       ArrayList<earthquake> earthquakes =new ArrayList<>();

//       using volley library for managing threads
        // Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(this);
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String minMagnitude = sharedPrefs.getString(
                getString(R.string.settings_min_magnitude_key),
                getString(R.string.settings_min_magnitude_default));
        Uri baseUri = Uri.parse(USGS_REQUEST_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        uriBuilder.appendQueryParameter("format", "geojson");
        uriBuilder.appendQueryParameter("limit", "10");
        uriBuilder.appendQueryParameter("minmag", minMagnitude);
        uriBuilder.appendQueryParameter("orderby", "time");


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, uriBuilder.toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        if(response!=null){
                            try {
                                JSONObject jsonObj = new JSONObject(response);
                                JSONArray array = jsonObj.getJSONArray("features");
                                for(int i=0;i<array.length();i++){
                                    JSONObject item_earthquake = array.getJSONObject(i);
                                    JSONObject properties = item_earthquake.getJSONObject("properties");
                                    String magnitude = properties.getString("mag");
                                    String Location =properties.getString("place");
                                    String Date = properties.getString("time");
                                    String Url = properties.getString("url");
                                    long timeInMilliseconds = Long.parseLong(Date);
                                    java.util.Date dateObject = new Date(timeInMilliseconds);

                                    SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy HH:mm:ss a");
                                    String dateToDisplay = dateFormatter.format(dateObject);

                                    earthquakes.add(new earthquake(magnitude,Location,dateToDisplay,Url));
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        earthquakeAdapters adapter =new earthquakeAdapters(getApplicationContext(),R.layout.llist_items,earthquakes);
                        ListView listView =findViewById(R.id.earthquakes_list);
                        listView.setAdapter(adapter);

                        //implementing item click listener to navigate to the website
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                //implicit intent to be implemented
                                earthquake current_earthquake= (earthquake)adapterView.getItemAtPosition(i);
                                Uri webpage = Uri.parse(current_earthquake.getUrl());
                                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                                startActivity(webIntent);
                            }
                        });

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"not able to load",Toast.LENGTH_SHORT).show();
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}