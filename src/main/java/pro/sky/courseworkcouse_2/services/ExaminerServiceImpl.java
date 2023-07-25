package pro.sky.courseworkcouse_2.services;

import org.springframework.stereotype.Service;
import pro.sky.courseworkcouse_2.exceptions.NotEnoughQuestionsException;
import pro.sky.courseworkcouse_2.interfaces.ExaminerService;
import pro.sky.courseworkcouse_2.interfaces.QuestionService;
import pro.sky.courseworkcouse_2.models.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    Random random;

    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionsSet = new HashSet<>();
        if (amount <= questionService.getAll().size()) {
            while (questionsSet.size() < amount) {
                questionsSet.add(questionService.getRandomQuestion());
            }
        } else {
            throw new NotEnoughQuestionsException();
        }
        return questionsSet;
    }
}
