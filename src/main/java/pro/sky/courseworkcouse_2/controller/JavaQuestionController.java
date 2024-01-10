package pro.sky.courseworkcouse_2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courseworkcouse_2.interfaces.ExaminerService;
import pro.sky.courseworkcouse_2.interfaces.QuestionService;
import pro.sky.courseworkcouse_2.models.Question;

import java.util.Collection;
@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService javaQuestionService;
    private ExaminerService examinerService;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService javaQuestionService, ExaminerService examinerService) {
        this.javaQuestionService = javaQuestionService;
        this.examinerService = examinerService;
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return javaQuestionService.getAll();
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return javaQuestionService.add(new Question(question,answer));
    }


    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {

        return javaQuestionService.remove(new Question(question, answer));
    }
}
