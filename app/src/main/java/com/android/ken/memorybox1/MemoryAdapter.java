package com.android.ken.memorybox1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class MemoryAdapter extends ArrayAdapter<Memory> {

    public LayoutInflater layoutInflater;

    public MemoryAdapter(Context context, int layoutResourceId, List<Memory> objects){
        super(context, layoutResourceId, objects);
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        Memory memory = getItem(position);

        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.layout_item_memo, null);
        }
    }
}
