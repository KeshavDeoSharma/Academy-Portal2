package com.pack.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.entity.Admin;
import com.pack.entity.BatchAllocation;
import com.pack.entity.FacultyRegistration;
import com.pack.entity.Login;
import com.pack.entity.Module;
import com.pack.entity.SkillMaster;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;

	public String loginAdmin(Login login) {
		// TODO Auto-generated method stub
		String page = null;
		Session s = this.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("from Login l where l.username=:username and l.password=:password");
		q.setParameter("username", login.getUsername());
		q.setParameter("password", login.getPassword());
		
		Login l1 = (Login) q.uniqueResult();
	
		if (l1 != null)
			page = "Home";
		else
			page = "denied";
		t.commit();
		return page;
	}

	public void addBatch(BatchAllocation batchAllocation) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(batchAllocation);
	}

	public void addAdmin(Admin admin) {
		this.sessionFactory.getCurrentSession().save(admin);
		Session s = this.sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		Login login=new Login();
		login.setUsername(admin.getId());
		login.setPassword(admin.getPassword());
		this.sessionFactory.getCurrentSession().save(login);
		
		
	}

	@Override
	public void addFaculty(FacultyRegistration fr) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(fr);
	}
	@Override
	public List<SkillMaster> getAllSkill() {
		// TODO Auto-generated method stub
		List<SkillMaster> l=new ArrayList();
		l=this.sessionFactory.getCurrentSession().createQuery("from SkillMaster").list();
		/*return this.sessionFactory.getCurrentSession().createQuery("from SkillMaster").list();*/
		System.out.println(l);
		return l;
	}

	@Override
	public void module(Module module) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(module);
		
	}

	@Override
	public List<FacultyRegistration> getAllFaculty() {
		// TODO Auto-generated method stub
		List<FacultyRegistration> f=new ArrayList();
		f=this.sessionFactory.getCurrentSession().createQuery("from FacultyRegistration").list();
		return f;
	}

	@Override
	public List<Module> getAllModule() {
		// TODO Auto-generated method stub
		List<Module> m=new ArrayList();
		m=this.sessionFactory.getCurrentSession().createQuery("from Module").list();
		return m;
	}

}
