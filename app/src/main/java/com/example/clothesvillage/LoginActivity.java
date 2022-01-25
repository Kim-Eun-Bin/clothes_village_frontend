package com.example.clothesvillage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.clothesvillage.base.BaseActivity;
import com.example.clothesvillage.databinding.ActivityLoginBinding;
import com.example.clothesvillage.remote.ClothesRepository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {
    private static final String TAG = "SignUpActivity";
    private FirebaseAuth mAuth;
    private ClothesRepository clothesRepository;

    @Override
    protected int layoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void onViewCreated() {
        mAuth = FirebaseAuth.getInstance();
        clothesRepository = ClothesRepository.getInstance();

        binding.btnLogin.setOnClickListener(view -> signup());
        binding.btnGotoSignup.setOnClickListener(view -> startSignUpActivity());

        binding.editId.setText("test@test.com");
        binding.editPass.setText("test123");
    }


    private void signup() {
        String email =   binding.editId.getText().toString();
        String password = binding.editPass.getText().toString();

        if(email.length() > 0 && password.length() > 0) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                startToast("login success");
                                startMainActivity();
                            } else {
                                // If sign in fails, display a message to the user.
                                if(task.getException() != null) {
                                    startToast(task.getException().toString());
                                }
                            }
                        }
                    });
        } else {
            startToast("please enter again");
        }

    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void startSignUpActivity() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}
