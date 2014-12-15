package com.example.citlalig.t5_mob_uag.list;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.citlalig.t5_mob_uag.R;

import java.util.ArrayList;

/**
 * Created by jerry on 15/11/14.
 */
public class ListItemAdapter extends BaseAdapter {
    //Variables
    private Context mContext = null;
    private ArrayList<ListItem> mArrayList = null;
    private LayoutInflater mLayoutInflater = null;

    public ListItemAdapter (Context context, ArrayList <ListItem> arrayList) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mArrayList = arrayList;
    }

    @Override
    public Object getItem(int position) {

        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public int getCount (){
        return mArrayList.size();
    }

    static class Holder {
        ImageView imageUser;
        TextView txtHeader;
        TextView txtsubHeader;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        View view = convertView;
        //Check if view is null
        if (view == null){
            holder = new Holder ();
            view = mLayoutInflater.inflate(R.layout.list_item,null);
            holder.imageUser = (ImageView)view.findViewById(R.id.image_user);
            holder.txtHeader = (TextView)view.findViewById(R.id.txt_header);
            holder.txtsubHeader = (TextView)view.findViewById(R.id.txt_subheader);
            view.setTag(holder);
        }
        else{
            holder=(Holder)view.getTag();

        }
        holder.imageUser.setImageDrawable(mArrayList.get(position).getImageUser());
        holder.txtHeader.setText(mArrayList.get(position).getHeader());
        holder.txtsubHeader.setText(mArrayList.get(position).getSubHeader());

        return view;
    }



}


