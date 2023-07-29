package pro.sky.courseworkcouse_2.services;

import org.springframework.beans.factory.annotation.Qualifier;
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

    private Random random = new Random();

    QuestionService javaQuestionService;
    QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaService") QuestionService javaQuestionService,
                               @Qualifier("mathService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getJavaQuestions() {
        Set<Question> questionsSet = new HashSet<>();
        int random = javaQuestionService.getRandom();
        if (random <= javaQuestionService.getAll().size()) {
            while (questionsSet.size() < random) {
                questionsSet.add(javaQuestionService.getRandomQuestion());
            }
        } else {
            throw new NotEnoughQuestionsException();
        }
        return questionsSet;
    }
    @Override
    public Collection<Question> getMathQuestions() {
        Set<Question> questionsSet = new HashSet<>();
        int random = mathQuestionService.getRandom();
        if (random <= mathQuestionService.getAll().size()) {
            while (questionsSet.size() < random) {
                questionsSet.add(mathQuestionService.getRandomQuestion());
            }
        } else {
            throw new NotEnoughQuestionsException();
        }
        return questionsSet;
    }

}
