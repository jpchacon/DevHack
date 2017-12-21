package co.devhack.presentation.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import co.devhack.R;
import co.devhack.domain.model.Work;
import co.devhack.presentation.view.dialog.LoginDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkInformation extends Fragment implements LoginDialog.OnFinishListener,View.OnClickListener{

    private String empresa;
    private String cargo;
    private String modalidad;
    private String ciudad;
    private String fecha;
    private String descripcion;
    private String email;
    private String celular;

    private static final String EMPRESA = "empresa";
    private static final String CARGO = "cargo";
    private static final String MODALIDAD = "tipo";
    private static final String CIUDAD = "ciudad";
    private static final String FECHA = "fecha";
    private static final String DESCRIPCION = "descripcion";
    private static final String EMAIL = "email";
    private static final String CELULAR = "celular";

    private TextView tvEmpresaWork;
    private TextView tvCargoWork;
    private TextView tvModalidadWork;
    private TextView tvCiudadWork;
    private TextView tvFechaWork;
    private TextView tvDescripcionWork;
    private TextView tvEmailWork;
    private TextView tvTelefonoWork;
    private Button btnInformationWork;
    private LinearLayout lyaDatos;

    public WorkInformation() {
    }

    public static WorkInformation getInstance(Work work){
        WorkInformation workInformation = new WorkInformation();
        Bundle args = new Bundle();
        args.putString(EMPRESA, work.getEmpresa());
        args.putString(CARGO, work.getTitulo());
        args.putString(MODALIDAD, work.getModalidad());
        args.putString(CIUDAD, work.getCiudad());
        args.putString(FECHA, work.getFecha());
        args.putString(DESCRIPCION, work.getDescripcion());
        args.putString(EMAIL, work.getEmail());
        args.putString(CELULAR, work.getTelefono());
        workInformation.setArguments(args);
        return workInformation;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            empresa = getArguments().getString(EMPRESA);
            cargo = getArguments().getString(CARGO);
            modalidad = getArguments().getString(MODALIDAD);
            ciudad = getArguments().getString(CIUDAD);
            fecha = getArguments().getString(FECHA);
            descripcion = getArguments().getString(DESCRIPCION);
            email = getArguments().getString(EMAIL);
            celular = getArguments().getString(CELULAR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work_information, container, false);

        tvEmpresaWork = view.findViewById(R.id.tvEmpresaWork);
        tvCargoWork = view.findViewById(R.id.tvCargoWork);
        tvModalidadWork = view.findViewById(R.id.tvModalidadWork);
        tvCiudadWork = view.findViewById(R.id.tvCiudadWork);
        tvFechaWork = view.findViewById(R.id.tvFechaWork);
        tvDescripcionWork = view.findViewById(R.id.tvDescripcionWork);
        tvEmailWork = view.findViewById(R.id.tvEmailWork);
        tvTelefonoWork = view.findViewById(R.id.tvTelefonoWork);
        btnInformationWork = view.findViewById(R.id.btnInformationWork);
        lyaDatos = view.findViewById(R.id.lyaDatos);

        tvEmpresaWork.setText(empresa);
        tvCargoWork.setText(cargo);
        tvModalidadWork.setText(modalidad);
        tvCiudadWork.setText(ciudad);
        tvFechaWork.setText(fecha);
        tvDescripcionWork.setText(descripcion);
        tvEmailWork.setText(email);
        tvTelefonoWork.setText(celular);

        btnInformationWork.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnInformationWork:
                goToOnLogin();
                break;
        }
    }

    private void goToOnLogin(){
        LoginDialog loginDialog = LoginDialog.getInstance(this);
        loginDialog.show(getFragmentManager(),null);
    }

    public void loginSucessfull(){
        btnInformationWork.setVisibility(View.GONE);
        lyaDatos.setVisibility(View.VISIBLE);
    }


    @Override
    public void onFinissh(boolean success) {
        if (success){
            loginSucessfull();
        }
    }
}
