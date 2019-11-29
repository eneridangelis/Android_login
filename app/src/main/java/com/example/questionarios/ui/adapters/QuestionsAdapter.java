package com.example.questionarios.ui.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.example.questionarios.ui.fragments.QuestionFragment;
import com.example.questionarios.ui.fragments.StudentAnsweredListener;

import java.util.List;

import model.Question;

public class QuestionsAdapter extends FragmentPagerAdapter {

    private List<Question> mQuestions;
    private StudentAnsweredListener mListener;

    public QuestionsAdapter(@NonNull FragmentManager fm, List<Question> questions, StudentAnsweredListener listener) {
        super(fm);
        mQuestions = questions;
        mListener = listener;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Question question = mQuestions.get(position);
        return new QuestionFragment(question, mListener);
    }

    @Override
    public int getCount() {
        return mQuestions.size();
    }
}
