package com.intcomex.api.repositories;

import com.intcomex.api.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
