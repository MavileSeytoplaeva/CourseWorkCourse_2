package pro.sky.courseworkcouse_2.servicesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.courseworkcouse_2.Consts;
import pro.sky.courseworkcouse_2.exceptions.NotEnoughQuestionsException;
import pro.sky.courseworkcouse_2.interfaces.QuestionService;
import pro.sky.courseworkcouse_2.models.Question;
import pro.sky.courseworkcouse_2.services.ExaminerServiceImpl;

import java.util.Collection;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    public QuestionService questionService;

    @InjectMocks
    public ExaminerServiceImpl examinerService;

    @Test
    void shouldThrowNotEnoughQuestionsException() {
        NotEnoughQuestionsException thrown = Assertions.assertThrows(NotEnoughQuestionsException.class,
                () -> examinerService.getQuestions(4));

    }

    @Test
    void shouldReturnSet() {
        when(questionService.getAll()).thenReturn(Consts.QUESTION_COLLECTION);
        when(questionService.getRandomQuestion()).thenReturn(new Question("when", "then"));

        Collection<Question> actual = examinerService.getQuestions(1);
        Assertions.assertEquals(Consts.COLLECTION_FOR_RANDOM_1, actual);
    }
}
