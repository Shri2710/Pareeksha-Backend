package com.exam.pariksha.services.implementation;

import com.exam.pariksha.model.Exam.Question;
import com.exam.pariksha.model.Exam.Quiz;
import com.exam.pariksha.repo.QuestionRepo;
import com.exam.pariksha.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class QuestionServiceImpl implements QuestionService {


    @Autowired
    private QuestionRepo questionRepo;
    @Override
    public Question addQuestion(Question question) {
        return this.questionRepo.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepo.findAll());
    }

    @Override
    public Set<Question> getQuestionForQuiz(Quiz quiz) {
        return new HashSet<>(this.questionRepo.findByQuiz(quiz));
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepo.save(question);
    }

    @Override
    public Question getQuestionById(Long qid) {
        return this.questionRepo.findById(qid).get();
    }

    @Override
    public void deleteQuestion(Long qid) {
       this.questionRepo.deleteById(qid);
    }

}
