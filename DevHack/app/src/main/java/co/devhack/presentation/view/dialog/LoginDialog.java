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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import co.devhack.R;
import co.devhack.presentation.interfaces.LoginDialogContract;
import co.devhack.presentation.presenters.LoginDialogPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginDialog extends DialogFragment implements LoginDialogContract.View, View.OnClickListener{

    public interface OnFinishListener {
        void onFinissh(boolean success);
    }

    private LoginDialogContract.UserActionsListener mActionListener;
    private LoginDialog.OnFinishListener listener;

    private View view;
    private TextInputLayout email;
    private TextInputLayout password;
    private ProgressBar progressBarLogin;
    private Button btnLogin;
    private Button btnAcepta;
    private Button btnCloseLogin;
    private TextView msjAlerta;
    private ImageView imageLogin;
    private ImageView imageLoginSucessfull;

    public LoginDialog() {
    }

    public static LoginDialog getInstance(LoginDialog.OnFinishListener listener){
        LoginDialog fragment = new LoginDialog();
        fragment.setListener(listener);
        return fragment;
    }
    public void setListener(LoginDialog.OnFinishListener listener) {
        this.listener = listener;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_login_dialog,null);

        mActionListener = new LoginDialogPresenter(this);


        email = view.findViewById(R.id.tilEmailLogin);
        password = view.findViewById(R.id.tilPassword);
        progressBarLogin = view.findViewById(R.id.progressBarLogin);
        btnLogin = view.findViewById(R.id.btnLogin);
        btnAcepta = view.findViewById(R.id.btnAcepta);
        btnCloseLogin = view.findViewById(R.id.btnCloseLogin);
        msjAlerta = view.findViewById(R.id.msjAlerta);
        imageLogin = view.findViewById(R.id.iconLogin);
        imageLoginSucessfull = view.findViewById(R.id.iconLoginSucessfull);

        btnLogin.setOnClickListener(this);
        btnAcepta.setOnClickListener(this);
        btnCloseLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnLogin:
                onLogin();
                break;
            case R.id.btnAcepta:
                dismiss();
                break;
            case R.id.btnCloseLogin:
                dismiss();
                break;
        }
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
    public void sucessfull() {
        btnCloseLogin.setVisibility(View.GONE);
        email.setVisibility(View.GONE);
        password.setVisibility(View.GONE);
        btnLogin.setVisibility(View.GONE);
        imageLogin.setVisibility(View.GONE);

        imageLoginSucessfull.setVisibility(View.VISIBLE);
        msjAlerta.setVisibility(View.VISIBLE);
        msjAlerta.setText(getString(R.string.succesfull_login));
        msjAlerta.setTextColor(getResources().getColor(R.color.success_email));

        btnAcepta.setVisibility(View.VISIBLE);

        listener.onFinissh(true);
    }

    @Override
    public void showMenssageError(Exception error) {
        msjAlerta.setVisibility(View.VISIBLE);
        msjAlerta.setText(error.getMessage());
        msjAlerta.setTextColor(getResources().getColor(R.color.error_email));

        email.getEditText().setText("");
        password.getEditText().setText("");

        listener.onFinissh(false);
    }

    @Override
    public void showProgressbar() {
        progressBarLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        progressBarLogin.setVisibility(View.GONE);
    }

    private void onLogin(){
        try {
            boolean result = true;
            String correo = email.getEditText().getText().toString();
            String contra = password.getEditText().getText().toString();

            if (email.getEditText().getText().toString().isEmpty()){
                email.setError(getString(R.string.is_required));
                email.setErrorEnabled(true);
                result = false;
            }else {
                email.setError(null);
                email.setErrorEnabled(false);
            }

            if (password.getEditText().getText().toString().isEmpty()){
                password.setError(getString(R.string.is_required));
                password.setErrorEnabled(true);
                result = false;
            }else {
                password.setError(null);
                password.setErrorEnabled(false);
            }
            if (result){
                mActionListener.onLogin(correo,contra);
            }

        }catch (Exception e){

        }
    }

}
