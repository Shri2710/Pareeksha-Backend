package com.exam.pariksha.services;

import com.exam.pariksha.model.Exam.Category;
import com.exam.pariksha.model.Exam.Quiz;

import java.util.List;
import java.util.Set;

public interface QuizService {


    public Quiz addQuiz(Quiz quiz);
    public Set<Quiz>  getQuiz();
    public Quiz getQuizById(Long quizId);
    public Quiz updateQuiz(Quiz quiz);
    public void deleteQuiz(Long quizId);

    List<Quiz> getQuizByCategory(Category cat);

    List<Quiz> getActiveQuizzesByCategory(Category cat,Boolean b);

    List<Quiz> getActiveQuizzes(Boolean b);
}
