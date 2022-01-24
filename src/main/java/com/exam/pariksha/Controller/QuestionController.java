package com.exam.pariksha.Controller;


import com.exam.pariksha.model.Exam.Question;
import com.exam.pariksha.model.Exam.Quiz;
import com.exam.pariksha.services.QuestionService;
import com.exam.pariksha.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.sun.tools.javac.util.List.of;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {


    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public Question addQuestion(@RequestBody Question question){
        return this.questionService.addQuestion(question);
    }

    @GetMapping("/")
    public Set<Question> getQuestion(){
        return this.questionService.getQuestions();
    }

    @GetMapping("/{qid}")
    public Question getQuestionById(@PathVariable("qid") Long qid){
        return this.questionService.getQuestionById(qid);
    }

    @PutMapping("/")
    public Question updateQuestion(@RequestBody Question question){
        return this.questionService.updateQuestion(question);
    }

    @DeleteMapping("/{qid}")
    public void deleteQuestion(@PathVariable("qid") Long qid){
        this.questionService.deleteQuestion(qid);
    }

    @GetMapping("/quiz/{qid}")
    public  List<Question> getQuestionByQuiz(@PathVariable Long qid){

//        Quiz quiz=new Quiz();
//        quiz.setQid(qid);
//        return this.questionService.getQuestionForQuiz(quiz);

        Quiz quiz=this.quizService.getQuizById(qid);

        Set<Question> questions=quiz.getQuestions();

        List list=new ArrayList(questions);

        if(list.size() > Integer.parseInt(quiz.getNumberOfQuestions())){
            list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions())+1);
        }

        Collections.shuffle(list);
        return list;
    }

    @GetMapping("/quiz/all/{qid}")
    public  Set<Question> getQuestionAdminByQuiz(@PathVariable Long qid){

        Quiz quiz=new Quiz();
        quiz.setQid(qid);
        return this.questionService.getQuestionForQuiz(quiz);


    }

    @PostMapping("/eval-quiz")

    public ResponseEntity<?> evaluateQuiz(@RequestBody List<Question> questions){

        double marksGot=0;
        int correctAnswers=0;
        int attempted=0;

        for(Question q : questions){

            Question ques= this.questionService.getQuestionById(q.getQuesId());
            if(ques.getAnswer().equals(q.getGivenAnswer())){
              correctAnswers++;

              double marksSingle= Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
              marksGot+=marksSingle;
            }

            if(!q.getAnswer().equals("")){
                attempted++;
            }
        };

        HashMap<Object,Object> map=new HashMap<>() ;

        map.put("attempted",attempted);
        map.put("correct",correctAnswers);
        map.put("marksGot",marksGot);


        return ResponseEntity.ok(map);
    }

}
