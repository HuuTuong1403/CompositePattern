package com.example.compositepatternphone;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListPhoneAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Phone> lstPhones;

    public ListPhoneAdapter(Context context, int layout, ArrayList<Phone> lstPhones) {
        this.context = context;
        this.layout = layout;
        this.lstPhones = lstPhones;
    }

    @Override
    public int getCount() {
        return lstPhones.size();
    }

    @Override
    public Object getItem(int position) {
        return lstPhones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        ImageView imgPhone;
        TextView txvPhoneName, txvDescription, txvPrice;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.imgPhone = (ImageView)convertView.findViewById(R.id.imgPhone);
            holder.txvPhoneName = (TextView)convertView.findViewById(R.id.txvPhoneName);
            holder.txvDescription = (TextView)convertView.findViewById(R.id.txvDescription);
            holder.txvPrice = (TextView)convertView.findViewById(R.id.txvPrice);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }

        Phone phone = lstPhones.get(position);
        holder.imgPhone.setImageResource(phone.getImage());
        holder.txvPhoneName.setText(phone.getName());
        holder.txvDescription.setText(phone.getDescription());
        holder.txvPrice.setText(phone.getPrice());

        return convertView;
    }
}
