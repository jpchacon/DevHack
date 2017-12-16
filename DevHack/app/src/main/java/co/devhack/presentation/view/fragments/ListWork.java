package co.devhack.presentation.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.devhack.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListWork extends Fragment {

    private RecyclerView recyclerView;


    public ListWork() {
        // Required empty public constructor
    }

    public static ListWork getInstance(){
        return new ListWork();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_work, container, false);

        recyclerView = view.findViewById(R.id.rvWorkList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }

}
