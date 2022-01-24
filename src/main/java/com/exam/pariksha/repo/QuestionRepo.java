package com.exam.pariksha.repo;

import com.exam.pariksha.model.Exam.Question;
import com.exam.pariksha.model.Exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepo extends JpaRepository<Question,Long> {
    public Set<Question> findByQuiz(Quiz quiz);
}
