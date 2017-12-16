package co.devhack.presentation.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.devhack.R;
import co.devhack.presentation.interfaces.ListWorkContract;
import co.devhack.presentation.presenters.ListWorkPresenter;
import co.devhack.presentation.view.adapters.WorkAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListWork extends Fragment implements ListWorkContract.View{

    private ListWorkContract.UserActionsListener mActionsListener;

    private RecyclerView recyclerView;


    public ListWork() {
    }

    public static ListWork getInstance(){
        return new ListWork();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_work, container, false);

        mActionsListener = new ListWorkPresenter(this);

        recyclerView = view.findViewById(R.id.rvWorkList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        WorkAdapter workAdapter = new WorkAdapter(mActionsListener.getLstWorks());
        recyclerView.setAdapter(workAdapter);

        mActionsListener.loadAll();

        return view;
    }

    @Override
    public void refreshTodos() {
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
