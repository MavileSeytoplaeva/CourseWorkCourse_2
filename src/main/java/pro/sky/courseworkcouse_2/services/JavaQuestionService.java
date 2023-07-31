package pro.sky.courseworkcouse_2.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.courseworkcouse_2.exceptions.StorageIsEmptyException;
import pro.sky.courseworkcouse_2.interfaces.QuestionService;
import pro.sky.courseworkcouse_2.models.Question;
import pro.sky.courseworkcouse_2.repository.JavaQuestionRepository;

import java.util.*;

@Service
@Component("javaService")
public class JavaQuestionService implements QuestionService {


    private JavaQuestionRepository javaQuestionRepository;

    private Random random = new Random();

    public JavaQuestionService(@Qualifier("javaRepository") JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public int getRandom() {
        return random.nextInt(javaQuestionRepository.getAll().size()+1);
    }


    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Question find(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
//        List<Question> questionList = javaQuestionRepository.getAll().stream().toList();
//        return questionList.get(getRandom());
        if (javaQuestionRepository.getAll().isEmpty()) {
            throw new StorageIsEmptyException("Empty");
        }
        return javaQuestionRepository.getAll().stream()
                .skip(random.nextInt(javaQuestionRepository.getAll().size()))
                .findFirst()
                .orElse(null);
    }
}
