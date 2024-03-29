package com.growskill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.growskill.model.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long>{

}
