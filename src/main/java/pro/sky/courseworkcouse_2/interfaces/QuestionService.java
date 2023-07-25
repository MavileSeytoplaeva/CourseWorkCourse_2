package pro.sky.courseworkcouse_2.interfaces;


import pro.sky.courseworkcouse_2.models.Question;

import java.util.Collection;

public interface QuestionService {
    int getRandom();

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Question find(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

}

