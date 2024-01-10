package pro.sky.courseworkcouse_2.interfaces;

import pro.sky.courseworkcouse_2.models.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getJavaQuestions();
    Collection<Question> getMathQuestions();
}
