package com.exam.pariksha.repo;

import com.exam.pariksha.model.Exam.Category;
import com.exam.pariksha.model.Exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepo extends JpaRepository<Quiz,Long> {

    public List<Quiz> findBycategory(Category cat);

    public List<Quiz> findByActive(Boolean b);
    public List<Quiz> findByCategoryAndActive(Category c,Boolean b);
}
