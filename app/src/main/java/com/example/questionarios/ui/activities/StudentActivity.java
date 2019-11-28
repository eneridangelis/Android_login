package com.example.questionarios.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.questionarios.R;

public class StudentActivity extends AppCompatActivity {

    EditText mInputAnswer;
    Button mButtonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        initView();
    }

    private void initView() {
        mInputAnswer = findViewById(R.id.input_answer);
        mButtonSend = findViewById(R.id.button_send);

        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onEnterClicked();
            }
        });

    }

    private void onEnterClicked() {
        mInputAnswer.setText("");
        Toast.makeText(this, R.string.answer_send, Toast.LENGTH_LONG).show();
    }
}
