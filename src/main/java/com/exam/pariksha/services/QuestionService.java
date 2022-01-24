package com.exam.pariksha.services;

import com.exam.pariksha.model.Exam.Category;
import com.exam.pariksha.model.Exam.Question;
import com.exam.pariksha.model.Exam.Quiz;

import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);
    public Set<Question> getQuestions();
    public Set<Question> getQuestionForQuiz(Quiz quiz);
    public Question updateQuestion(Question question);
    public Question getQuestionById(Long qid);
    public void deleteQuestion(Long qid);

}
