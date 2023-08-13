package pro.sky.courseworkcouse_2.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.courseworkcouse_2.exceptions.NotEnoughQuestionsException;
import pro.sky.courseworkcouse_2.interfaces.ExaminerService;
import pro.sky.courseworkcouse_2.interfaces.QuestionService;
import pro.sky.courseworkcouse_2.models.Question;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private Random random = new Random();

    private Map<String, QuestionService> fields = new HashMap<>();

    public ExaminerServiceImpl(@Qualifier("javaService") QuestionService javaQuestionService,
                               @Qualifier("mathService") QuestionService mathQuestionService) {
        fields.put("java", javaQuestionService);
        fields.put("math", mathQuestionService);
    }

//    QuestionService javaQuestionService;
//    QuestionService mathQuestionService;
//
//    public ExaminerServiceImpl(@Qualifier("javaService") QuestionService javaQuestionService,
//                               @Qualifier("mathService") QuestionService mathQuestionService) {
//        this.javaQuestionService = javaQuestionService;
//        this.mathQuestionService = mathQuestionService;
//    }

    private QuestionService getService(int num) {
        if (num == 1) {
            return fields.get("java");
        }
        return fields.get("math");
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if ((fields.get("math").getAll().size() + fields.get("java").getAll().size()) < amount) {
            throw new NotEnoughQuestionsException();
        }
        Set<Question> questions = new HashSet<>(Set.of());
        while (amount > questions.size()) {
            QuestionService question = getService(random.nextInt(2));
            questions.add(question.getRandomQuestion());
        }
        return questions;
    }
}

