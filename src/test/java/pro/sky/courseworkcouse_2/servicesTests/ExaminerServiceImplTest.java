package pro.sky.courseworkcouse_2.servicesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.courseworkcouse_2.Consts;
import pro.sky.courseworkcouse_2.exceptions.NotEnoughQuestionsException;
import pro.sky.courseworkcouse_2.models.Question;
import pro.sky.courseworkcouse_2.repository.JavaQuestionRepository;
import pro.sky.courseworkcouse_2.repository.MathQuestionRepository;
import pro.sky.courseworkcouse_2.services.ExaminerServiceImpl;
import pro.sky.courseworkcouse_2.services.JavaQuestionService;
import pro.sky.courseworkcouse_2.services.MathQuestionService;

import java.util.Collection;
import java.util.Random;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    public JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository();
    public JavaQuestionService javaQuestionService = new JavaQuestionService(javaQuestionRepository);
    public MathQuestionService mathQuestionService;
    public MathQuestionRepository mathQuestionRepository;
    public Random random = new Random();

    @InjectMocks
    public ExaminerServiceImpl examinerService = new ExaminerServiceImpl(javaQuestionService,mathQuestionService);

//    @BeforeEach
//    void setUp() {
//        this.examinerService = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);
//        this.javaQuestionService = new JavaQuestionService(javaQuestionRepository);
//        this.mathQuestionService = new MathQuestionService(mathQuestionRepository);
//    }


//    @Test
//    void shouldThrowNotEnoughQuestionsExceptionJava() {
//        when(javaQuestionRepository.getAll()).thenReturn(Consts.QUESTION_COLLECTION);
//        when(javaQuestionService.getRandomQuestion()).thenReturn(new Question(Consts.QUESTION, Consts.ANSWER));
//
////        Collection<Question> actual = examinerService.getJavaQuestions();
////        Assertions.assertEquals(Consts.QUESTION_SET, actual);
//
//        NotEnoughQuestionsException thrown = Assertions.assertThrows(NotEnoughQuestionsException.class,
//                () -> examinerService.getJavaQuestions());
//    }
//    @Test
//    void shouldThrowNotEnoughQuestionsExceptionMath() {
//        NotEnoughQuestionsException thrown = Assertions.assertThrows(NotEnoughQuestionsException.class,
//                () -> examinerService.getMathQuestions());
//    }

    @Test
    void shouldReturnSetJava() {
        when(javaQuestionRepository.getAll()).thenReturn(Consts.QUESTION_COLLECTION);
//        when(javaQuestionService.getRandomQuestion()).thenReturn(new Question("when", "then"));

        Collection<Question> actual = examinerService.getJavaQuestions();
        Assertions.assertEquals(Consts.COLLECTION_FOR_RANDOM_1, actual);
    }
    @Test
    void shouldReturnSetMath() {
        when(mathQuestionRepository.getAll()).thenReturn(Consts.QUESTION_COLLECTION);
//        when(mathQuestionService.getRandomQuestion()).thenReturn(new Question("when", "then"));

        Collection<Question> actual = examinerService.getMathQuestions();
        Assertions.assertEquals(Consts.COLLECTION_FOR_RANDOM_1, actual);
    }

    @Test
    void returnAll() {
        when(javaQuestionRepository.getAll()).thenReturn(Consts.QUESTION_COLLECTION);
        Collection<Question> actual = javaQuestionService.getAll();

        Assertions.assertEquals(Consts.QUESTION_COLLECTION, actual);
    }

    @Test
    void shouldGetJavaQuestions() {
        when(javaQuestionRepository.getAll()).thenReturn(Consts.QUESTION_COLLECTION);
        when(javaQuestionService.getRandomQuestion()).thenReturn(new Question(Consts.QUESTION, Consts.ANSWER));

        Collection<Question> actual = examinerService.getJavaQuestions();
        Assertions.assertEquals(Consts.QUESTION_SET, actual);
    }
}
