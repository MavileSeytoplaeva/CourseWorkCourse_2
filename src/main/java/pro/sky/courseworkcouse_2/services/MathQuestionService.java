package pro.sky.courseworkcouse_2.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.courseworkcouse_2.interfaces.QuestionService;
import pro.sky.courseworkcouse_2.models.Question;
import pro.sky.courseworkcouse_2.repository.MathQuestionRepository;

import java.util.*;

@Service
@Component("mathService")
public class MathQuestionService implements QuestionService {

    private MathQuestionRepository mathQuestionRepository;

    private Random random = new Random();

    @Override
    public int getRandom() {
        return random.nextInt(0, mathQuestionRepository.getQuestionStorage().size());
    }


    public MathQuestionService(@Qualifier("mathRepository") MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestionRepository.remove(question);
    }

    @Override
    public Question find(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return mathQuestionRepository.getAll().stream()
                .skip(random.nextInt(mathQuestionRepository.getAll().size()))
                .findFirst()
                .orElse(null);
    }
}
