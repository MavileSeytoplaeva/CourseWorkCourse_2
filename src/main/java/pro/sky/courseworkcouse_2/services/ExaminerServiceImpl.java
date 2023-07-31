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

    @Override
    public Collection<Question> getJavaQuestions() {
        return Stream.generate(fields.get("java")::getRandomQuestion)
                .distinct()
                .limit(random.nextInt(fields.get("java").getAll().size()))
                .collect(Collectors.toList());
//        return Stream.generate(javaQuestionService::getRandomQuestion)
//                .distinct()
//                .limit(random.nextInt(javaQuestionService.getAll().size()))
//                .collect(Collectors.toList());
    }
    @Override
    public Collection<Question> getMathQuestions() {
        return Stream.generate(fields.get("math")::getRandomQuestion)
                .distinct()
                .limit(random.nextInt(fields.get("math").getAll().size()))
                .collect(Collectors.toList());
//        return Stream.generate(mathQuestionService::getRandomQuestion)
//                .distinct()
//                .limit(random.nextInt(mathQuestionService.getAll().size()))
//                .collect(Collectors.toList());
    }
}
