package fr.mycompany.superquiz.data;

import java.util.List;

public class Question {

    private final String question;
    private final List<String> choiceList;
    private final Integer answerIndex;

    public Question(String question, List<String> choiceList, int answerIndex) {
        this.question = question;
        this.choiceList = choiceList;
        this.answerIndex = answerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getChoiceList() {
        return choiceList;
    }

    public Integer getAnswerIndex() {
        return answerIndex;
    }
}
