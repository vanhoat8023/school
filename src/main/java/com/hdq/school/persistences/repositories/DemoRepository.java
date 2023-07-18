package com.hdq.school.persistences.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdq.school.persistences.entities.Demo;

@Repository
public interface DemoRepository extends JpaRepository<Demo, Long>{

}
