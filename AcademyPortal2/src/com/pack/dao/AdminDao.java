package com.pack.dao;

import java.util.List;

import com.pack.entity.Admin;
import com.pack.entity.BatchAllocation;
import com.pack.entity.FacultyRegistration;
import com.pack.entity.Login;
import com.pack.entity.Module;
import com.pack.entity.SkillMaster;

public interface AdminDao {

	public String loginAdmin(Login login);
	public void addBatch(BatchAllocation batchAllocation);
	public void addAdmin(Admin admin);
	public void addFaculty(FacultyRegistration fr);
	public List<SkillMaster> getAllSkill();
	public void module(Module module);
	public List<FacultyRegistration> getAllFaculty();
	public List<Module> getAllModule();
}
