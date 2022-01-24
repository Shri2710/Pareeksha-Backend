package com.exam.pariksha.Controller;

import com.exam.pariksha.model.Exam.Category;
import com.exam.pariksha.model.Exam.Quiz;
import com.exam.pariksha.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public Quiz addQuiz(@RequestBody Quiz quiz){
        return this.quizService.addQuiz(quiz);
    }

    @GetMapping("/{quizId}")
    public Quiz  getQuizById(@PathVariable("quizId") Long qid){
        return this.quizService.getQuizById(qid);
    }

    @GetMapping("/")
    public Set<Quiz> getQuizs(){
        return this.quizService.getQuiz();
    }

    @PutMapping("/")
    public Quiz updateQuiz(@RequestBody Quiz Quiz){
        return this.quizService.updateQuiz(Quiz);
    }

    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long qid){
        this.quizService.deleteQuiz(qid);
    }

    @GetMapping("/category/{cid}")
    public List<Quiz> getQuizByCategory(@PathVariable("cid") Long cid){

        Category cat=new Category();

        cat.setCid(cid);
        return this.quizService.getQuizByCategory   (cat);
    }

    @GetMapping("/active")

    public List<Quiz> getActiveQuiz(){
        return this.quizService.getActiveQuizzes(true);
    }

    @GetMapping("/category/active/{cid}")

    public List<Quiz> getActiveQuizByCategory(@PathVariable("cid") Long cid){

        Category c=new Category();

        c.setCid(cid);
        return this.quizService.getActiveQuizzesByCategory(c,true);
    }
}
