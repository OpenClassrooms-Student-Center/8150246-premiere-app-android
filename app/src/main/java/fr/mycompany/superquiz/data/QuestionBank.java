package fr.mycompany.superquiz.data;

import java.util.Arrays;
import java.util.List;

public class QuestionBank {
    public List<Question> getQuestions() {
        return Arrays.asList(
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
                        "What is the house number of The Simpsons?",
                        Arrays.asList(
                                "42",
                                "101",
                                "666",
                                "742"
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

    private static QuestionBank instance;
    public static QuestionBank getInstance() {
        if (instance == null) {
            instance = new QuestionBank();
        }
        return instance;
    }
}
