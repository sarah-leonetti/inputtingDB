package com.iaustin.ggsapi.repository;

import com.iaustin.ggsapi.model.Category;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    Optional<Category> findById(Long id);

    List<Category> findByParentId(Long id);

    List<Category> findByParentIdOrderByRankAsc(Long id);


}

