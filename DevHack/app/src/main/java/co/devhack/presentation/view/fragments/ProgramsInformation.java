package co.devhack.presentation.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import co.devhack.R;
import co.devhack.domain.model.Program;
import co.devhack.helpers.Utilities;
import co.devhack.presentation.interfaces.ProgramInformationContract;
import co.devhack.presentation.presenters.ProgramInformationPresenter;
import co.devhack.presentation.view.adapters.DetailProgramAdapter;
import co.devhack.presentation.view.dialog.SignUpDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramsInformation extends Fragment implements ProgramInformationContract.View, SignUpDialog.OnFinishListener,
        View.OnClickListener{

    private ProgramInformationContract.UserActionsListener mActionsListener;
    private String image, name, startDate, duration;
    private String schedules, investment, id;
    private RecyclerView rvContentList;
    private FloatingActionButton fab;

    private static final String IMAGE = "image";
    private static final String NAME = "name";
    private static final String STARTDATE = "startDate";
    private static final String DURATION = "duration";
    private static final String SCHEDULES = "schedules";
    private static final String INVESTMENT = "investment";
    private static final String ID = "id";

    private ImageView ivLogoProgram;
    private TextView tvProgram, tvStartDate, tvDuration, tvSchedules, tvInvestment;

    public ProgramsInformation() {
        // Required empty public constructor
    }

    public static ProgramsInformation getInstance(Program program){
        ProgramsInformation programsInformation = new ProgramsInformation();

        Bundle args = new Bundle();
        args.putString(IMAGE, program.getImage());
        args.putString(NAME, program.getName());
        args.putString(STARTDATE, program.getStartDate().toString());
        args.putString(DURATION, program.getDuration());
        args.putString(SCHEDULES, program.getSchedules());
        args.putString(INVESTMENT, program.getInvestment());
        args.putString(ID, program.getId());
        programsInformation.setArguments(args);
        return programsInformation;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            image = getArguments().getString(IMAGE);
            name = getArguments().getString(NAME);
            startDate = getArguments().getString(STARTDATE);
            duration = getArguments().getString(DURATION);
            schedules = getArguments().getString(SCHEDULES);
            investment = getArguments().getString(INVESTMENT);
            id = getArguments().getString(ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_programs_information, container, false);

        mActionsListener = new ProgramInformationPresenter(this, id);
        ivLogoProgram = view.findViewById(R.id.ivLogoProgram);
        tvProgram = view.findViewById(R.id.tvProgram);
        tvStartDate = view.findViewById(R.id.tvStartDate);
        tvDuration = view.findViewById(R.id.tvDuration);
        tvSchedules = view.findViewById(R.id.tvSchedules);
        tvInvestment = view.findViewById(R.id.tvInvestment);
        fab = view.findViewById(R.id.fab);

        fab.setOnClickListener(this);

        rvContentList = view.findViewById(R.id.rvContentList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvContentList.setLayoutManager(layoutManager);

        DetailProgramAdapter programAdapter = new DetailProgramAdapter(mActionsListener.getLstDetails());
        rvContentList.setAdapter(programAdapter);

        mActionsListener.loadAll();

        if(!Utilities.isEmpty(image)) {
            Glide.with(view).load(image).into(ivLogoProgram);
        }
        tvProgram.setText(name);
        tvStartDate.setText(startDate);
        tvDuration.setText(duration);
        tvSchedules.setText(schedules);
        tvInvestment.setText(investment);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab:
                goToOnSignUp();
                break;
        }
    }

    public void goToOnSignUp(){
        SignUpDialog signUpDialog = SignUpDialog.getInstance(this,id);
        signUpDialog.show(getFragmentManager(),null);
    }

    @Override
    public void refreshDetails() {
        rvContentList.getAdapter().notifyDataSetChanged();
    }


    @Override
    public void onFinissh(boolean success) {
        if (success){
            fab.setVisibility(View.GONE);
        }
    }
}
