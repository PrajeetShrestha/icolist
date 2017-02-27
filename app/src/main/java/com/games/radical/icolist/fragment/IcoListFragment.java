package com.games.radical.icolist.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.games.radical.icolist.R;
import com.games.radical.icolist.adapter.ListRecycleViewAdapter;
import com.games.radical.icolist.model.IcoModel;
import com.games.radical.icolist.service.FirebaseDataService;
import com.games.radical.icolist.service.FirebaseDataServiceDelegate;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class IcoListFragment extends Fragment implements FirebaseDataServiceDelegate {
    private FirebaseDataService service;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ArrayList<IcoModel> list = new ArrayList<>();

    public IcoListFragment() {
        service = new FirebaseDataService(this);
        //service.setupSeedData();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ico_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        service.getData();
        recyclerView = (RecyclerView) view.findViewById(R.id.ico_recycler);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

    }

    @Override
    public void fetchedData(ArrayList<IcoModel> newList) {

        this.list = newList;
        adapter = new ListRecycleViewAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
