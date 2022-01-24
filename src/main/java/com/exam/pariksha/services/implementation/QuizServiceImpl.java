package com.exam.pariksha.services.implementation;

import com.exam.pariksha.model.Exam.Category;
import com.exam.pariksha.model.Exam.Quiz;
import com.exam.pariksha.repo.QuizRepo;
import com.exam.pariksha.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepo quizRepo;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepo.save(quiz);
    }

    @Override
    public Set<Quiz> getQuiz() {
        return new HashSet<>(this.quizRepo.findAll());
    }

    @Override
    public Quiz getQuizById(Long quizId) {
        return this.quizRepo.findById(quizId).get();
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepo.save(quiz);
    }

    @Override
    public void deleteQuiz(Long quizId) {
        this.quizRepo.deleteById(quizId);
    }

    @Override
    public List<Quiz> getQuizByCategory(Category cat) {
        return this.quizRepo.findBycategory(cat);
    }

    @Override
    public List<Quiz> getActiveQuizzesByCategory(Category c,Boolean b) {
        return this.quizRepo.findByCategoryAndActive(c,true);
    }

    @Override
    public List<Quiz> getActiveQuizzes(Boolean b) {
        return this.quizRepo.findByActive(true);
    }


}
