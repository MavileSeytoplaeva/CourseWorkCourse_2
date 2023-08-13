package pro.sky.courseworkcouse_2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courseworkcouse_2.exceptions.MethodNotAllowedException;
import pro.sky.courseworkcouse_2.interfaces.ExaminerService;
import pro.sky.courseworkcouse_2.interfaces.QuestionService;
import pro.sky.courseworkcouse_2.models.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final QuestionService mathQuestionService;
    private ExaminerService examinerService;

    public MathQuestionController(@Qualifier("mathService") QuestionService mathQuestionService, ExaminerService examinerService) {
        this.mathQuestionService = mathQuestionService;
        this.examinerService = examinerService;
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return mathQuestionService.getAll();
//        throw new MethodNotAllowedException();
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return mathQuestionService.add(new Question(question, answer));
//        throw new MethodNotAllowedException();
    }


    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question,
                                   @RequestParam String answer) {
        throw new MethodNotAllowedException();
    }

}

