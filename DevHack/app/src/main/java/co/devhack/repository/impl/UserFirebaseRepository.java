package co.devhack.repository.impl;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import co.devhack.helpers.Callback;
import co.devhack.repository.UserRepository;

/**
 * Created by Juanpa on 20/12/2017.
 */

public class UserFirebaseRepository implements UserRepository{
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    public UserFirebaseRepository(){
        this.mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void login(String email, String password, final Callback<Boolean> callback) {
        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful() && task.getResult() != null){
                            callback.success(true);
                        }else {
                            callback.error(task.getException());
                        }

                    }
                });
    }
}
