package com.example.questionarios.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.questionarios.R;

public class TeacherActivity extends AppCompatActivity {

    EditText mInputQuestion;
    Button mButtonUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        initView();
    }

    private void initView() {
        mInputQuestion = findViewById(R.id.input_question);
        mButtonUpload = findViewById(R.id.button_upload);

        mButtonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUploadClicked();
            }
        });
    }

    private void onUploadClicked() {
        mInputQuestion.setText("");
        Toast.makeText(this, R.string.upload_ok, Toast.LENGTH_LONG).show();
    }
}
