package com.an;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.an.jdbc.dao.PersonDao;
import com.an.jdbc.utils.Person;
@Controller
public class MainController {
	
	Person loginPn=new Person();
	
	@Autowired
	Person pn;
	
	@Autowired
	PersonDao dao;
	
	@Autowired
	JdbcTemplate jt;
	
	
	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/login")
	public String getLoign(Model model,
			@RequestParam(value="id",defaultValue = "")String id,
			@RequestParam(value="pass",defaultValue = "")String pass) {
		List<Person>list=dao.getById(jt,id);
		System.out.println(id);
		String message="";
		String page="login";
		for(Person pn:list) {
			if(pn.getPass().equals(pass)) {
				loginPn.setPk(pn.getPk());
				loginPn.setId(id);
				loginPn.setPass(pass);
				page="home";		
			}else {message="check your id or password";	}
		}
		if(page=="login") model.addAttribute("message",message);
		return page;
	}
	
	@GetMapping("/home")
	public String getHome() {
		System.out.println("home");
		return "home";
	}
	
	@GetMapping("/showpk")
	public String getShowPk(Model model) {
		model.addAttribute("showPk",loginPn.getPk());
		return "showpk";
	}
	
	@GetMapping("/setpass")
	public String getSetPass(Model model,
			@RequestParam(value = "pk",defaultValue = "")String Strpk,
			@RequestParam(value = "olepass",defaultValue = "")String oldpass,
			@RequestParam(value = "newpass",defaultValue = "")String newpass) {
		String message="";
		model.addAttribute("message",message);
		int pk=0;
		try {
			pk=Integer.parseInt(Strpk);
		} catch (Exception e) {
			message="pk is number";
		}
		if(pk!=0 && loginPn.getPk()==pk) {
			if(loginPn.getPass().equals(oldpass)) {
				loginPn.setPass(newpass);
				dao.update(jt, loginPn);
				loginPn=new Person();
				message="PassWord is Change";
			}else {
				message="check your oldpass";	
			}
		}else {message="check your pk";}
		model.addAttribute("message",message);
		return "setpass";
	}
	
	@GetMapping("/jspLoin")
	public String jsplogin() {
		return "/jsp01/jsplogin";
	}

}
