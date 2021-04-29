package com.example.compositepatternphone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentPhone extends Fragment {
    private ArrayList<Phone> arrayListPhone;
    private ListPhoneAdapter adapter;
    private ListView listView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        arrayListPhone = (ArrayList<Phone>) getArguments().getSerializable("key");

        adapter = new ListPhoneAdapter(getActivity(), R.layout.custom_layout_phone, arrayListPhone);
        listView.setAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_phone, container, false);
        listView = (ListView)v.findViewById(R.id.listViewPhone);
        return v;
    }

}
