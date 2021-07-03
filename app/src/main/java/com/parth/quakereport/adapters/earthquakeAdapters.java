package com.parth.quakereport.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.parth.quakereport.R;
import com.parth.quakereport.earthquake;

import java.util.List;

public class earthquakeAdapters extends ArrayAdapter<earthquake> {
    public earthquakeAdapters(@NonNull Context context, int resource, @NonNull List<earthquake> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView =convertView;
        if(listItemView ==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.llist_items,parent,false);
        }
        earthquake current_earthquake_object = (earthquake) getItem(position);
        TextView magnitude,location,date;


//        getting the views from the convert view after attach the main view group
        magnitude = listItemView.findViewById(R.id.tvMagnitude);
        location = listItemView.findViewById(R.id.tvLocation);
        date = listItemView.findViewById(R.id.tvDate);

        //setting the text
        magnitude.setText(Integer.toString(current_earthquake_object.getMagnitude()));
        location.setText(current_earthquake_object.getLocation());
        date.setText(current_earthquake_object.getDate());

        return listItemView;

    }
}
