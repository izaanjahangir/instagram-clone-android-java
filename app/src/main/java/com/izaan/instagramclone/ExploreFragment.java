package com.izaan.instagramclone;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.izaan.instagramclone.adapters.PostAdapter;

public class ExploreFragment extends Fragment {

    public ExploreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_explore, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        String[] names = {"izaan", "faraz", "hasan"};
        Activity activity = this.getActivity();

        PostAdapter postAdapter = new PostAdapter(activity, names);
        RecyclerView recyclerView = getView().findViewById(R.id.rvPost);
        recyclerView.setAdapter(postAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
    }
}