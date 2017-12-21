package co.devhack.presentation.view.dialog;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import co.devhack.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsDialog extends DialogFragment implements View.OnClickListener{

    private View view;
    private Button btnCloseContacts;


    public ContactsDialog() {
    }

    public static ContactsDialog getInstance(){
        return new ContactsDialog();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_contacts_dialog,null);

        btnCloseContacts = view.findViewById(R.id.btnCloseContacts);

        btnCloseContacts.setOnClickListener(this);
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
            case R.id.btnCloseContacts:
                dismiss();
                break;
        }
    }
}
