package co.devhack.presentation.view.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.devhack.R;
import co.devhack.domain.model.Program;
import co.devhack.presentation.interfaces.ListProgramContract;
import co.devhack.presentation.interfaces.ReplaceFragmentProgram;
import co.devhack.presentation.interfaces.ReplaceFragmentWork;
import co.devhack.presentation.presenters.ListProgramPresenter;
import co.devhack.presentation.view.adapters.ProgramAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListPrograms extends Fragment implements ListProgramContract.View{

    private ListProgramContract.UserActionsListener mActionsListener;
    private RecyclerView rvListProgram;
    private ReplaceFragmentProgram mListenerCallback;

    public ListPrograms() {
        // Required empty public constructor
    }

    public static ListPrograms getInstance(){
        return new ListPrograms();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof ReplaceFragmentWork){
            mListenerCallback = (ReplaceFragmentProgram) context;
        }
        else {
            throw new RuntimeException("Debe implementar la interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_programs, container, false);

        mActionsListener = new ListProgramPresenter(this);

        rvListProgram = view.findViewById(R.id.rvListProgram);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvListProgram.setLayoutManager(layoutManager);

        ProgramAdapter programAdapter = new ProgramAdapter(mActionsListener.getLstPrograms(),
                new ProgramAdapter.ListenerClickView(){

                    @Override
                    public void click(Program program) {
                        mListenerCallback.replaceFragmentMainActivity(program);
                    }
                });
        rvListProgram.setAdapter(programAdapter);

        mActionsListener.loadAll();

        return view;
    }

    @Override
    public void refreshPrograms() {
        rvListProgram.getAdapter().notifyDataSetChanged();
    }


}
