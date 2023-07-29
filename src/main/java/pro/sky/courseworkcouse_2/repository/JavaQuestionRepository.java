package pro.sky.courseworkcouse_2.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pro.sky.courseworkcouse_2.models.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Repository
@Component("java")
public class JavaQuestionRepository implements QuestionRepository{

    private Set<Question> questionStorage;

    public JavaQuestionRepository() {
        this.questionStorage = new HashSet<>();
    }

    @PostConstruct
    void init() {
        this.questionStorage = new HashSet<>();
    }



    public Set<Question> getQuestionStorage() {
        return questionStorage;
    }

    @Override
    public Question add(Question question) {
        if (!question.getQuestion().equals(question.getAnswer())) {
            questionStorage.add(question);
            return question;
        }
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
    public Collection<Question> getAll() {
        return questionStorage;
    }


}
