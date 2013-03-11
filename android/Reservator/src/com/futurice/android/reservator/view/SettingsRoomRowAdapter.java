package com.futurice.android.reservator.view;

import java.util.ArrayList;
import java.util.HashSet;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import com.futurice.android.reservator.R;

public class SettingsRoomRowAdapter extends ArrayAdapter<String> {
	  private final Context context;
	  private final ArrayList<String> values;
	  private SharedPreferences preferences;
	  private HashSet<String> unselectedRooms;
	  
	  public SettingsRoomRowAdapter(Context context, int view, ArrayList<String> values) {
	    super(context, view, values);
	    this.context = context;
	    this.values = values;
	    
		/*preferences = context.getSharedPreferences(
				context.getString(R.string.PREFERENCES_NAME), Context.MODE_PRIVATE);
		
		// load the unselected rooms
    	preferences.getStringSet(context.getString(R.string.PREFERENCES_UNSELECTED_ROOMS), unselectedRooms);*/
	  }

	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.custom_settings_row, parent, false);
	    
	    CheckBox t = (CheckBox) rowView.findViewById(R.id.checkBox1);
	    String current = values.get(position);
	    t.setText(current);
	    if (unselectedRooms.contains(current)) {
	    	t.setChecked(false);
	    }

	    return rowView;
	  }
	} 
