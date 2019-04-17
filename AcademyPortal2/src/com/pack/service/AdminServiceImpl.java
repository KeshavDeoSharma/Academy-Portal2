package com.pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.dao.AdminDao;
import com.pack.entity.Admin;
import com.pack.entity.BatchAllocation;
import com.pack.entity.FacultyRegistration;
import com.pack.entity.Login;
import com.pack.entity.Module;
import com.pack.entity.SkillMaster;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Transactional
	public String loginAdmin(Login login) {
		// TODO Auto-generated method stub

		System.out.println("inside service");
		String l = null;
		l = adminDao.loginAdmin(login);
		return l;
	}

	@Transactional
	public void addBatch(BatchAllocation batchAllocation) {
		// TODO Auto-generated method stub
		adminDao.addBatch(batchAllocation);
	}

	@Transactional
	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.addAdmin(admin);
		
	}
	
	@Transactional
	public void addFaculty(FacultyRegistration fr){
		adminDao.addFaculty(fr);
	}

	@Transactional
	public List<SkillMaster> getAllSKill() {
		// TODO Auto-generated method stub
	return	adminDao.getAllSkill();
		
	}

	@Transactional
	public void module(Module module) {
		// TODO Auto-generated method stub
	adminDao.module(module);
	}

	@Transactional
	public List<FacultyRegistration> getAllFaculty() {
		// TODO Auto-generated method stub
		return adminDao.getAllFaculty();
	}

	@Transactional
	public List<Module> getAllModule() {
		// TODO Auto-generated method stub
		return adminDao.getAllModule();
	}

}
