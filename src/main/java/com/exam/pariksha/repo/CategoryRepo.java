package com.exam.pariksha.repo;

import com.exam.pariksha.model.Exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
