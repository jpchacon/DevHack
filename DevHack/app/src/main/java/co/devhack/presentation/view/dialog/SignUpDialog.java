package co.devhack.presentation.view.dialog;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import co.devhack.R;
import co.devhack.presentation.interfaces.SignUpProgramContract;
import co.devhack.presentation.presenters.SignUpProgramPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpDialog extends DialogFragment implements SignUpProgramContract.View ,View.OnClickListener{



    public interface OnFinishListener {
        void onFinissh(boolean success);
    }

    private static String idProgram;

    private View view;
    private Button btnCloseSignUp;
    private Button sendDataUserProgram;
    private Button btnAceptaRegistro;
    private ProgressBar progressSignUp;
    private SignUpDialog.OnFinishListener listener;
    private SignUpProgramContract.UserActionsListener mActionListener;

    private TextInputLayout nameUserProgram;
    private TextInputLayout emailUserProgram;
    private TextInputLayout numberUserProgram;

    private TextView msjAlertaPrograma;


    public SignUpDialog() {
    }

    public static SignUpDialog getInstance(SignUpDialog.OnFinishListener listener, String id){
        SignUpDialog signUpDialog = new SignUpDialog();
        signUpDialog.setListener(listener);
        idProgram = id;
        return signUpDialog;
    }
    public void setListener(SignUpDialog.OnFinishListener listener) {
        this.listener = listener;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_sign_up_dialog,null);
        mActionListener = new SignUpProgramPresenter(this);

        btnCloseSignUp = view.findViewById(R.id.btnCloseSignUp);
        sendDataUserProgram = view.findViewById(R.id.sendDataUserProgram);
        nameUserProgram = view.findViewById(R.id.nameUserProgram);
        emailUserProgram = view.findViewById(R.id.emailUserProgram);
        numberUserProgram = view.findViewById(R.id.numberUserProgram);
        btnAceptaRegistro = view.findViewById(R.id.btnAceptaRegistro);
        msjAlertaPrograma = view.findViewById(R.id.msjAlertaPrograma);
        progressSignUp = view.findViewById(R.id.progressSignUp);

        btnCloseSignUp.setOnClickListener(this);
        sendDataUserProgram.setOnClickListener(this);
        btnAceptaRegistro.setOnClickListener(this);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        return builder.create();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sendDataUserProgram:
                onSignUp();
                break;
            case R.id.btnCloseSignUp:
                dismiss();
                break;
            case R.id.btnAceptaRegistro:
                dismiss();
                break;
        }
    }

    @Override
    public void sucessfull() {

        clearTextInputLayout();

        nameUserProgram.setVisibility(View.GONE);
        emailUserProgram.setVisibility(View.GONE);
        numberUserProgram.setVisibility(View.GONE);
        sendDataUserProgram.setVisibility(View.GONE);
        btnCloseSignUp.setVisibility(View.GONE);

        msjAlertaPrograma.setVisibility(View.VISIBLE);
        msjAlertaPrograma.setText(getString(R.string.succesfull_signup));
        msjAlertaPrograma.setTextColor(getResources().getColor(R.color.success_email));

        btnAceptaRegistro.setVisibility(View.VISIBLE);

        listener.onFinissh(true);
    }

    @Override
    public void showMenssageError(Exception error) {
        msjAlertaPrograma.setVisibility(View.VISIBLE);
        msjAlertaPrograma.setText(error.getMessage());
        msjAlertaPrograma.setTextColor(getResources().getColor(R.color.error_email));

        nameUserProgram.getEditText().setText("");
        emailUserProgram.getEditText().setText("");
        numberUserProgram.getEditText().setText("");


        listener.onFinissh(false);
    }

    @Override
    public void showProgressbar() {
        progressSignUp.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        progressSignUp.setVisibility(View.GONE);
    }

    private void onSignUp(){
        try {
            boolean result = true;
            String celular = numberUserProgram.getEditText().getText().toString();
            String email = emailUserProgram.getEditText().getText().toString();
            String nombre = nameUserProgram.getEditText().getText().toString();

            if (numberUserProgram.getEditText().getText().toString().isEmpty()){
                numberUserProgram.setError(getString(R.string.is_required));
                numberUserProgram.setErrorEnabled(true);
                result = false;
            }else {
                numberUserProgram.setError(null);
                numberUserProgram.setErrorEnabled(false);
            }

            if (emailUserProgram.getEditText().getText().toString().isEmpty()){
                emailUserProgram.setError(getString(R.string.is_required));
                emailUserProgram.setErrorEnabled(true);
                result = false;
            }else {
                emailUserProgram.setError(null);
                emailUserProgram.setErrorEnabled(false);
            }
            //
            if (nameUserProgram.getEditText().getText().toString().isEmpty()){
                nameUserProgram.setError(getString(R.string.is_required));
                nameUserProgram.setErrorEnabled(true);
                result = false;
            }else {
                nameUserProgram.setError(null);
                nameUserProgram.setErrorEnabled(false);
            }
            if (result){
                mActionListener.onSignUp(idProgram.toLowerCase(),celular,email,nombre);
            }

        }catch (Exception e){

        }
    }

    private void clearTextInputLayout(){
        nameUserProgram.getEditText().setText("");
        emailUserProgram.getEditText().setText("");
        numberUserProgram.getEditText().setText("");
    }
}
