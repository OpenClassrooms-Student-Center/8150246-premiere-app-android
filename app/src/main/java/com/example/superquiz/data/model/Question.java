package com.example.superquiz.data.model;

import androidx.annotation.NonNull;

import java.util.List;

public class Question {
    @NonNull
    private final String mQuestion;
    @NonNull
    private final List<String> mChoiceList;
    @NonNull
    private final Integer mAnswerIndex;

    public Question(@NonNull String question, @NonNull List<String> choiceList,@NonNull Integer answerIndex) {
        mQuestion = question;
        mChoiceList = choiceList;
        mAnswerIndex = answerIndex;
    }

    @NonNull
    public String getQuestion() {
        return mQuestion;
    }

    @NonNull
    public List<String> getChoiceList() {
        return mChoiceList;
    }

    @NonNull
    public Integer getAnswerIndex() { return mAnswerIndex; }
}
