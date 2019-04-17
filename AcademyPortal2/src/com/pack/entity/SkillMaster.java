package com.pack.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SKILL_MASTER")
public class SkillMaster {
	@Id
private String skillid;
private String skill;
private String certification;
public String getSkillid() {
	return skillid;
}
public void setSkillid(String skillid) {
	this.skillid = skillid;
}
public String getSkill() {
	return skill;
}
public void setSkill(String skill) {
	this.skill = skill;
}
public String getCertification() {
	return certification;
}
public void setCertification(String certification) {
	this.certification = certification;
}
}
