package co.devhack.presentation.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.devhack.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkInformation extends Fragment {

    private String id;

    public WorkInformation() {
        this.id = id;
    }

    public static WorkInformation getInstance(String id){
        WorkInformation workInformation = new WorkInformation();
        Bundle args = new Bundle();
        args.putString("IdEmpleo", id);
        workInformation.setArguments(args);
        return workInformation;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            id = getArguments().getString("IdEmpleo");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work_information, container, false);
        return view;
    }

}
