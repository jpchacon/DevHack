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
public class ProgramsInformation extends Fragment {


    public ProgramsInformation() {
        // Required empty public constructor
    }

    public static ProgramsInformation getInstance(){
        return new ProgramsInformation();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_programs_information, container, false);
    }

}
