package com.example.questionarios.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.questionarios.R;
import com.example.questionarios.ui.adapters.QuestionsAdapter;
import com.example.questionarios.ui.fragments.StudentAnsweredListener;
import java.util.ArrayList;
import java.util.List;
import model.Question;

public class StudentActivity extends AppCompatActivity implements StudentAnsweredListener {
    ViewPager mPagerQuestions;
    private View viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        initView();
    }

    private void initView() {
        mPagerQuestions = findViewById(R.id.pager_questions);
        viewPager = findViewById(R.id.pager_questions);

        List<Question> questions = mockQuestions();

        mPagerQuestions.setAdapter(new QuestionsAdapter(getSupportFragmentManager(), questions, this));

        viewPager.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View source, MotionEvent e) {
                return true;
            }
        });


    }

    private List<Question> mockQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("Questao 1","Java possui passagem por referencia?"));
        questions.add(new Question("Questao 2", "Quantos pokemons voce capturou hoje?"));
        questions.add(new Question("Questao 3", "Qual seu pokemon preferido?"));
        questions.add(new Question("Questao 4", "Com quantos paus se faz uma canoa?"));
        questions.add(new Question("Questao 5", "Quem nasceu primeiro, o ovo ou a galinha?"));
        questions.add(new Question("Questao 6", "É para ver ou para comer?"));

        return questions;
    }

    @Override
    public void onStudentAnswered() {
        int currentPage = mPagerQuestions.getCurrentItem();
        int nextPage = currentPage+1;

        mPagerQuestions.setCurrentItem(nextPage, true);

    }

    @Override
    public void onStudentBack() {
        int currentPage = mPagerQuestions.getCurrentItem();
        int backPage = currentPage-1;

        mPagerQuestions.setCurrentItem(backPage, true);
    }
}
