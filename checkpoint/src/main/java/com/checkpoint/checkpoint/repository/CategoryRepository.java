package com.checkpoint.checkpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkpoint.checkpoint.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
