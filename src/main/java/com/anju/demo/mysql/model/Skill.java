package com.anju.demo.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="skills")
public class Skill {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Skill")
	private Integer idSkill;
	
	@Column(name="skill_name")
	private String skillName;
	
	@Column(name="is_active")
	private Integer isActive = 1;	
	
	public Skill() {
		
	}
	public Skill(Integer idSkill, String skillName, Integer isActive) {
		this.idSkill = idSkill;
		this.skillName = skillName;
		this.isActive = isActive;
	}

	public Integer getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(Integer idSkill) {
		this.idSkill = idSkill;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Skill [idSkill=" + idSkill + ", skillName=" + skillName + ", isActive=" + isActive + "]";
	}	
}
