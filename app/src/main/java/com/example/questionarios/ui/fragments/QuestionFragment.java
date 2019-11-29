package com.example.questionarios.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.questionarios.R;

import model.Question;

public class QuestionFragment extends Fragment {

    private final Question mQuestion;
    private final StudentAnsweredListener mListener;
    private EditText mInputAnswer;


    public QuestionFragment(Question question, StudentAnsweredListener listener) {
        mQuestion = question;
        mListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
    }

    private void initView(View view) {
        mInputAnswer = view.findViewById(R.id.input_answer);
        Button buttonSend = view.findViewById(R.id.button_send);
        Button buttonBack = view.findViewById(R.id.button_back);

        TextView questionNumber = view.findViewById(R.id.question_number);
        TextView questionText = view.findViewById(R.id.question_text);

        questionNumber.setText(mQuestion.getQuestionNumber());
        questionText.setText(mQuestion.getQuestionText());
        mInputAnswer.setText(mQuestion.getAnswer());

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onSendClicked();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackClicked();
            }
        });
    }

    private void onBackClicked() {
        mListener.onStudentBack();
    }

    @Override
    public void onPause() {
        super.onPause();
        String answer = mInputAnswer.getText().toString();
        mQuestion.setAnswer(answer);
    }

    private void onSendClicked() {
        if(mInputAnswer.getText().toString().trim().equals("")){
            Toast.makeText(this.getContext(), "Voce nao respondeu a questao.", Toast.LENGTH_SHORT).show();
        } else{
            mListener.onStudentAnswered();
        }

    }
}
