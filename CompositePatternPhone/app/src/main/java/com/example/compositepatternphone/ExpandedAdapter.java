package com.example.compositepatternphone;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpandedAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listMenu;
    private HashMap<String, List<String>> listSubMenu;

    public ExpandedAdapter(Context context, List<String> listMenu, HashMap<String, List<String>> listSubMenu) {
        this.context = context;
        this.listMenu = listMenu;
        this.listSubMenu = listSubMenu;
    }

    @Override
    public int getGroupCount() {
        return listMenu.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listSubMenu.get(this.listMenu.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listMenu.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listSubMenu.get(this.listMenu.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String menu = (String)getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_menu, null);
        }
        TextView txtTitle = (TextView)convertView.findViewById(R.id.expandabledListMenu);
        txtTitle.setText(menu);
        txtTitle.setTypeface(null, Typeface.BOLD);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String submenu = (String)getChild(groupPosition, childPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_submenu, null);
        }
        TextView txtItem = (TextView)convertView.findViewById(R.id.expandabledListSubMenu);
        txtItem.setText(submenu);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
