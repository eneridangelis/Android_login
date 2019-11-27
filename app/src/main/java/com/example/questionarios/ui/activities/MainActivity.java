package com.example.questionarios.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.questionarios.R;

import model.FakeData;

public class MainActivity extends AppCompatActivity {

    EditText mInputUsername;
    EditText mInputPassword;
    Button mButtonEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mInputUsername = findViewById(R.id.input_username);
        mInputPassword = findViewById(R.id.input_password);
        mButtonEnter = findViewById(R.id.button_enter);

        mButtonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEnterClicked();
            }
        });
    }

    private void onEnterClicked() {
        String username = mInputUsername.getText().toString();
        String password = mInputPassword.getText().toString();

        if(username.equals(FakeData.TEACHER_USERNAME) && password.equals(FakeData.TEACHER_PASSWORD)){
            Intent teacherIntent = new Intent(this, TeacherActivity.class);
            startActivity(teacherIntent);
        }
        else if(username.equals(FakeData.STUDENT_USERNAME) && password.equals(FakeData.STUDENT_PASSWORD)){
            Intent studentIntent = new Intent(this, StudentActivity.class);
            startActivity(studentIntent);
        }
        else{
            Toast.makeText(this, R.string.login_invalid, Toast.LENGTH_LONG).show();
        }


    }


}
