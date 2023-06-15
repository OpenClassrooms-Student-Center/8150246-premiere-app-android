package fr.mycompany.superquiz.data;

import java.util.List;

public class QuestionRepository {
    private final QuestionBank questionBank;

    public QuestionRepository(QuestionBank questionBank) {
        this.questionBank = questionBank;
    }

    public List<Question> getQuestions() {
        return questionBank.getQuestions();
    }
}
