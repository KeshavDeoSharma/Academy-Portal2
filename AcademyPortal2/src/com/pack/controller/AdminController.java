package com.pack.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.entity.Admin;
import com.pack.entity.BatchAllocation;
import com.pack.entity.FacultyRegistration;
import com.pack.entity.Login;
import com.pack.entity.Module;
import com.pack.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	@RequestMapping(value = "/viewfaculty", method = RequestMethod.GET)
	public String viewfaculty(ModelMap model) {
	
		System.err.println("Inside viewfaculty controller");
		model.addAttribute("listUsers", adminService.getAllFaculty());
		model.addAttribute("faculty", new FacultyRegistration());
		return "viewfaculty";
	}
	@RequestMapping(value = "/viewmodule", method = RequestMethod.GET)
	public String viewmodule(ModelMap model) {
	
		System.err.println("Inside viewfaculty controller");
		model.addAttribute("listModules", adminService.getAllModule());
		model.addAttribute("module", new Module());
		return "viewmodule";
	}

	@RequestMapping(value = "/logOption", method = RequestMethod.GET)
	public String loginoption(ModelMap model) {
		System.out.println("aasaasasas");
		System.err.println("Inside login controller");
		model.addAttribute("login", new Login());
		return "LogOption";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(ModelMap model) {
		System.err.println("Inside login controller");
		model.addAttribute("login", new Login());
		model.addAttribute("addadmin", new Admin());
		return "SignUp";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.err.println("Inside login controller");
		model.addAttribute("login", new Login());
		return "login";
	}
	@RequestMapping(value = "/addfaculty", method = RequestMethod.GET)
	public String addFaculty(ModelMap model) {
		System.err.println("Inside addfaculty controller");
		model.addAttribute("login", new Login());
	model.addAttribute("addfaculty", new FacultyRegistration());
	model.addAttribute("skillMaster", adminService.getAllSKill());
	
		return "AddFaculty";
	}
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validate(@ModelAttribute(value = "login") Login login, ModelMap model) {

		System.out.println("Inside admin controller");
		String l = null;
		l = adminService.loginAdmin(login);
		return l;
	}

	@RequestMapping(value = "/BatchAllocation", method = RequestMethod.GET)
	public String batchAllocation(ModelMap model) {
		System.err.println("Inside batchAllocation controller");
		model.addAttribute("batchAllocation", new BatchAllocation());
		return "BatchAllocation";
	}
	@RequestMapping(value = "/module", method = RequestMethod.GET)
	public String moduleopen(ModelMap model) {
	
		System.err.println("Inside module controller");
		model.addAttribute("login", new Login());
		model.addAttribute("module", new Module());
		model.addAttribute("skillMaster", adminService.getAllSKill());
		return "Module";
	}

	@RequestMapping(value = "/addBatch", method = RequestMethod.POST)
	public String addBatch(@ModelAttribute(value = "batchAllocation") BatchAllocation batchAllocation, ModelMap model,
			BindingResult result, final HttpServletRequest request) {
		System.err.println("Inside addBatch controller");
		model.addAttribute("batchAllocation", new BatchAllocation());
		String startDatestr = request.getParameter("nday");
		String endDatestr = request.getParameter("eday");
		String closeDatestr = request.getParameter("cday");
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		/*
		 * Date startDate = sdf. parse(startDatestr); Date
		 * endDate=sdf.parse(endDatestr); Date
		 * closeDate=sdf.parse(closeDatestr);
		 */
		adminService.addBatch(batchAllocation);
		return "BatchAllocation";
	}
	@RequestMapping(value="/addadmin", method= RequestMethod.POST)
	public String addAdmin(	@ModelAttribute(value = "addadmin") Admin admin1)
	{
		adminService.addAdmin(admin1);
		System.out.println("HELLO SUUCESSFULLY ADDED");
		return "redirect:/login";
		
}
	@RequestMapping(value="/addfaculty1", method= RequestMethod.POST)
	public String addFaculty(	@ModelAttribute(value = "addfaculty") FacultyRegistration fr,ModelMap model)
	{
		//model.addAttribute("addFaculty", new FacultyRegistration());
		Random r=new Random();
		int num=r.nextInt(900000)+100000;
		String str=Integer.toString(num);
		str="T-"+str;
		fr.setFacultyid(str);
		adminService.addFaculty(fr);
		System.out.println("HELLO SUUCESSFULLY ADDED");
		return "redirect:/addfaculty";
		
}
	@RequestMapping(value="/module1", method= RequestMethod.POST)
	public String module(	@ModelAttribute(value = "module") Module m,ModelMap model)
	{
		//model.addAttribute("addFaculty", new FacultyRegistration());
		Random r=new Random();
		int num=r.nextInt(900000)+100000;
		String str=Integer.toString(num);
		str="B-"+str;
		m.setModuleid(str);
		adminService.module(m);
		System.out.println("HELLO SUUCESSFULLY ADDED");
		return "redirect:/viewmodule";
		
}
}