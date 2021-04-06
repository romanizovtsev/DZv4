package com.example.myapplication;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListFragment extends Fragment {
    static private int countAd=0;
    int orient,orient1;
    Boolean change;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.listfragment,container,false);
        RecyclerView recyclerView= view.findViewById(R.id.numb_rec);
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                orient1=0;
            }
            else {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
                    orient1=1;
                }
            }
            final NumbAdapter NumbAdapterEx=new NumbAdapter();
        recyclerView.setAdapter(NumbAdapterEx);
        isChangeOrient(savedInstanceState);
        if((savedInstanceState!=null)&&(!change)) {
            countAd=savedInstanceState.getInt("AddedNumb");
          change=false;
            if (countAd > 0) {
                for (int i = 0; i < countAd; i++) {
                    NumbAdapterEx.insert(DataSource.AddItem());
                }
            }
        }
        Button AddBut=view.findViewById(R.id.AddBut2);
        AddBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NumbAdapterEx.insert(DataSource.AddItem());
                countAd++;
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("AddedNumb", countAd);
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT)
        {
            outState.putInt("Orientation", 0);
        }
        else
            if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE)
            {
                outState.putInt("Orientation", 1);
            }
    }
    public void isChangeOrient(Bundle savedInstanceState)
    {
        if(savedInstanceState!=null) {
            orient = savedInstanceState.getInt("Orientation");
            if (orient != orient1)
                change = true;
            else
                change = false;
        }

    }
}
