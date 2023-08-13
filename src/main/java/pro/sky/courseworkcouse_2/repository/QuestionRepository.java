package pro.sky.courseworkcouse_2.repository;

import pro.sky.courseworkcouse_2.models.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public interface QuestionRepository {

//    Set<Question> questionStorage = new HashSet<>();


    Question add(Question question);

    Question remove(Question question);


    Collection<Question> getAll();
}
