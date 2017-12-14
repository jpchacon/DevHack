package co.devhack.presentation.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.devhack.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListPrograms extends Fragment {


    public ListPrograms() {
        // Required empty public constructor
    }

    public static ListPrograms getInstance(){
        return new ListPrograms();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_programs, container, false);
        return view;
    }

}
