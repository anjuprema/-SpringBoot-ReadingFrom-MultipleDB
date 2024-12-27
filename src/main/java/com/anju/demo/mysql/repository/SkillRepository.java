package com.anju.demo.mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anju.demo.mysql.model.Skill;


public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
