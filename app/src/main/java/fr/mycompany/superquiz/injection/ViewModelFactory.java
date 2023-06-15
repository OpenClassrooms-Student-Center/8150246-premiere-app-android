package fr.mycompany.superquiz.injection;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import fr.mycompany.superquiz.ui.quiz.QuizViewModel;
import fr.mycompany.superquiz.data.QuestionBank;
import fr.mycompany.superquiz.data.QuestionRepository;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private final QuestionRepository questionRepository;
    private static ViewModelFactory factory;

    public static ViewModelFactory getInstance() {
        if (factory == null) {
            synchronized (ViewModelFactory.class) {
                if (factory == null) {
                    factory = new ViewModelFactory();
                }
            }
        }
        return factory;
    }

    private ViewModelFactory() {
        QuestionBank questionBank = QuestionBank.getInstance();
        this.questionRepository = new QuestionRepository(questionBank);
    }

    @Override
    @NotNull
    public <T extends ViewModel>  T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(QuizViewModel.class)) {
            return (T) new QuizViewModel(questionRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}