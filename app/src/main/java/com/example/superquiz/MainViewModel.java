package com.example.superquiz;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.superquiz.data.model.Question;

import java.util.Arrays;
import java.util.List;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<Question> _currentQuestion = new MutableLiveData<Question>();
    public LiveData<Question> currentQuestion = _currentQuestion;

    private final MutableLiveData<Integer> _currentQuestionIndex = new MutableLiveData<Integer>(0);

    public List<Question> questions = generateFakeQuestionList();

    private final MutableLiveData<Integer> _score = new MutableLiveData<Integer>(0);
    public LiveData<Integer> score = _score;

    public LiveData<Boolean> isLastQuestion = Transformations.map(_currentQuestionIndex, index -> {
         return index == questions.size() - 1;
    });
    public void startQuiz() {
        _currentQuestionIndex.postValue(0);
        _currentQuestion.postValue(questions.get(0));
    }

    public void nextQuestion() {
        Integer currentIndex = _currentQuestionIndex.getValue();
        if(currentIndex != null) {
            int nextIndex = currentIndex + 1;
            _currentQuestionIndex.postValue(nextIndex);
            _currentQuestion.postValue(questions.get(nextIndex));
        }
    }


    public Boolean isAnswerValid(Integer answerIndex) {
        Question question = _currentQuestion.getValue();
        boolean isValid = question != null && question.getAnswerIndex().equals(answerIndex);
        Integer currentScore = _score.getValue();
        if(currentScore != null && isValid) {
            _score.setValue(currentScore + 1);
        }
        return isValid;
    }

    private List<Question> generateFakeQuestionList() {
        return List.of(
                new Question(
                        "Who is the creator of Android?",
                        Arrays.asList(
                                "Andy Rubin",
                                "Steve Wozniak",
                                "Jake Wharton",
                                "Paul Smith"
                        ),
                        0
                ),
                new Question(
                        "When did the first man land on the moon?",
                        Arrays.asList(
                                "1958",
                                "1962",
                                "1967",
                                "1969"
                        ),
                        3
                ),
                new Question(
                        "Who did the Mona Lisa paint?",
                        Arrays.asList(
                                "Michelangelo",
                                "Leonardo Da Vinci",
                                "Raphael",
                                "Carravagio"
                        ),
                        1
                ),
                new Question(
                        "What is the country top-level domain of Belgium?",
                        Arrays.asList(
                                ".bg",
                                ".bm",
                                ".bl",
                                ".be"
                        ),
                        3
                )
        );
    }
}