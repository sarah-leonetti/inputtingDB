package com.iaustin.ggsapi.repository;

import com.iaustin.ggsapi.model.EducationItem;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


public interface EducationItemRepository extends JpaRepository<EducationItem, Long> {

    Optional<EducationItem> findById(Long id);



    
    //List<EducationItem> findByCategoryId(Long categoryId);
}
