package pro.sky.courseworkcouse_2.servicesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.courseworkcouse_2.Consts;
import pro.sky.courseworkcouse_2.models.Question;
import pro.sky.courseworkcouse_2.services.JavaQuestionService;

public class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        this.javaQuestionService = new JavaQuestionService();
    }

    @Test
    void shouldAddQuestion() {
        Question actual = javaQuestionService.add(Consts.QUESTION, Consts.ANSWER);
        Question expected = new Question(Consts.QUESTION, Consts.ANSWER);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNullIfNotFoundWhenRemove() {
        Question actual = javaQuestionService.remove(new Question(Consts.QUESTION, Consts.ANSWER));
        Question expected = null;

        Assertions.assertEquals(expected, actual);
    }
}
