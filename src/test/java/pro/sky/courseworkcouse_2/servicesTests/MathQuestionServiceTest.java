package pro.sky.courseworkcouse_2.servicesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.courseworkcouse_2.Consts;
import pro.sky.courseworkcouse_2.models.Question;
import pro.sky.courseworkcouse_2.repository.MathQuestionRepository;
import pro.sky.courseworkcouse_2.services.MathQuestionService;

import java.util.Collection;
import java.util.Random;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {

    @Mock
    public MathQuestionRepository mathQuestionRepository;
    public Random random = new Random();

    @InjectMocks
    public MathQuestionService mathQuestionService;

    @Test
    void returnWhenAdd() {
        when(mathQuestionRepository.add(new Question(Consts.QUESTION, Consts.ANSWER))).thenReturn(new Question(Consts.QUESTION, Consts.ANSWER));
        Question actual = mathQuestionService.add(new Question(Consts.QUESTION, Consts.ANSWER));

        Assertions.assertEquals(new Question(Consts.QUESTION,Consts.ANSWER),actual);
    }

    @Test
    void returnWhenRemove() {
        when(mathQuestionRepository.remove(new Question(Consts.QUESTION, Consts.ANSWER))).thenReturn(new Question(Consts.QUESTION, Consts.ANSWER));
        Question actual = mathQuestionService.remove(new Question(Consts.QUESTION, Consts.ANSWER));

        Assertions.assertEquals(new Question(Consts.QUESTION, Consts.ANSWER), actual);
    }

    @Test
    void returnAll() {
        when(mathQuestionRepository.getAll()).thenReturn(Consts.QUESTION_COLLECTION);
        Collection<Question> actual = mathQuestionService.getAll();

        Assertions.assertEquals(Consts.QUESTION_COLLECTION, actual);
    }

    @Test
    void returnRandomQuestion() {
        when(mathQuestionRepository.getQuestionStorage()).thenReturn((Consts.QUESTION_SET));
        Question actual = mathQuestionService.getRandomQuestion();

        Assertions.assertEquals(new Question(Consts.QUESTION, Consts.ANSWER), actual);
    }
}
