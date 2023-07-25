package pro.sky.courseworkcouse_2.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.courseworkcouse_2.interfaces.ExaminerService;
import pro.sky.courseworkcouse_2.interfaces.QuestionService;
import pro.sky.courseworkcouse_2.models.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")

public class ExamController {

    private QuestionService questionService;
    private ExaminerService examinerService;

    public ExamController(QuestionService questionService, ExaminerService examinerService) {
        this.questionService = questionService;
        this.examinerService = examinerService;
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }


    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {

        return questionService.remove(new Question(question, answer));
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}

