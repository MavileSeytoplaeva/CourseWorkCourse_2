package pro.sky.courseworkcouse_2.servicesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.courseworkcouse_2.Consts;
import pro.sky.courseworkcouse_2.models.Question;
import pro.sky.courseworkcouse_2.repository.JavaQuestionRepository;
import pro.sky.courseworkcouse_2.services.ExaminerServiceImpl;
import pro.sky.courseworkcouse_2.services.JavaQuestionService;

import java.util.Collection;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    public JavaQuestionRepository javaQuestionRepository;

    @InjectMocks
    public JavaQuestionService javaQuestionService;

    @Test
    void shouldAddQuestion() {
        when(javaQuestionRepository.add(new Question(Consts.QUESTION, Consts.ANSWER))).thenReturn(new Question(Consts.QUESTION, Consts.ANSWER));
        Question actual = javaQuestionService.add(new Question(Consts.QUESTION, Consts.ANSWER));


        Assertions.assertEquals(new Question(Consts.QUESTION, Consts.ANSWER), actual);
    }

    @Test
    void shouldReturnNullIfNotFoundWhenRemove() {
        Question actual = javaQuestionService.remove(new Question(Consts.QUESTION, Consts.ANSWER));
        Question expected = null;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void returnWhenRemove() {
        when(javaQuestionRepository.remove(new Question(Consts.QUESTION, Consts.ANSWER))).thenReturn(new Question(Consts.QUESTION, Consts.ANSWER));
        Question actual = javaQuestionService.remove(new Question(Consts.QUESTION, Consts.ANSWER));

        Assertions.assertEquals(new Question(Consts.QUESTION, Consts.ANSWER), actual);
    }

    @Test
    void returnAll() {
        when(javaQuestionRepository.getAll()).thenReturn(Consts.QUESTION_COLLECTION);
        Collection<Question> actual = javaQuestionService.getAll();

        Assertions.assertEquals(Consts.QUESTION_COLLECTION, actual);
    }

    @Test
    void returnRandomQuestion() {
        when(javaQuestionRepository.getQuestionStorage()).thenReturn((Consts.QUESTION_SET));
        Question actual = javaQuestionService.getRandomQuestion();

        Assertions.assertEquals(new Question(Consts.QUESTION, Consts.ANSWER), actual);
    }
}
