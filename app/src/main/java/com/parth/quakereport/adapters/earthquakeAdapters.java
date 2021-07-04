package com.parth.quakereport.adapters;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.parth.quakereport.R;
import com.parth.quakereport.earthquake;

import java.util.List;

public class earthquakeAdapters extends ArrayAdapter<earthquake> {
    public earthquakeAdapters(@NonNull Context context, int resource, @NonNull List<earthquake> objects) {
        super(context, resource, objects);
    }

    public int getMagnitudeColor(String s){
        int mag = (int)(Double.parseDouble(s));
        Log.e("mag",Integer.toString(mag));

        switch (mag){

            case 0:
            case 1:
                return  R.color.magnitude1;

            case 2:
                return R.color.magnitude2;

            case 3:
                return R.color.magnitude3;

            case 4:
                return R.color.magnitude4;

            case 5:
                return R.color.magnitude5;

            case 6:
                return (int)R.color.magnitude6;

            case 7:
                return (int)R.color.magnitude7;

            case 8:
                return R.color.magnitude8;

            case 9:
                return R.color.magnitude9;

            default:
                return R.color.magnitude10plus;
        }

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView =convertView;
        if(listItemView ==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.llist_items,parent,false);
        }
        earthquake current_earthquake_object = (earthquake) getItem(position);
        TextView magnitude,location,date,direction,time;


//        getting the views from the convert view after attach the main view group
        magnitude = listItemView.findViewById(R.id.tvMagnitude);
        time =listItemView.findViewById(R.id.tvTime);
        direction = listItemView.findViewById(R.id.tvDirection);
        location = listItemView.findViewById(R.id.tvLocation);
        date = listItemView.findViewById(R.id.tvDate);


        //setting the text
        magnitude.setText(current_earthquake_object.getMagnitude());
        String Date =current_earthquake_object.getDate().substring(0,13);
        String Time  = current_earthquake_object.getDate().substring(13,25);
        String[] array = current_earthquake_object.getLocation().split("of ",10);

        date.setText(Date);
        time.setText(Time);
        if(array.length>1){
                    direction.setText(array[0]+" of");
                    location.setText(array[1]);
        }
        else{
            location.setText(current_earthquake_object.getLocation());
        }

        //fetch the background from the magnitude text view
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(current_earthquake_object.getMagnitude());
        Log.e("magnitude color",Integer.toString(R.color.magnitude1));

        //context compat class is used to convert the resid to argb integer
        magnitudeCircle.setColor(ContextCompat.getColor(getContext(),magnitudeColor));

        return listItemView;

    }
}
