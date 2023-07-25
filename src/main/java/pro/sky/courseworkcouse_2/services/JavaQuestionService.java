package pro.sky.courseworkcouse_2.services;

import org.springframework.stereotype.Service;
import pro.sky.courseworkcouse_2.interfaces.QuestionService;
import pro.sky.courseworkcouse_2.models.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questionStorage;

    private Random random;


    public JavaQuestionService() {
        this.questionStorage = new HashSet<>();
    }

    @Override
    public int getRandom() {
        return random.nextInt(1, questionStorage.size());
    }

    public Set<Question> getQuestionStorage() {
        return questionStorage;
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (!question.equals(answer)) {
            questionStorage.add(question1);
            return question1;
        }
        return null;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        if (questionStorage.contains(question)) {
            questionStorage.remove(question);
            return question;
        }
        return null;
    }

    @Override
    public Question find(Question question) {
        if (questionStorage.contains(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return questionStorage;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionList = questionStorage.stream().toList();
//        Question[] questionArray = questionStorage.toArray(new Question[0]);
        if (getRandom() <= questionList.size()) {
            return questionList.get(getRandom());
        }
        return null;
    }
}
