package com.codered.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.codered.main.UserLogin;
import com.codered.main.UserLoginRepository;
import com.codered.main.UserRegRepository;
import com.codered.main.UserRegistration;
import com.codered.main.model.Quiz;
import com.codered.main.repository.QuizRepository;


@Controller
public class RegistrationController 
{
	@Autowired
	private UserRegRepository userRegRepository;
	@Autowired
	private UserLoginRepository userLoginRepository;
	@Autowired
	private QuizRepository quizRepository;
	
	
	@RequestMapping("/demo")
	public String home() {
		return "demo";
	}
	
	//index page of LOGIN
	@RequestMapping("/login")
	public String loginUser() {
		return "login";
	}
	
	//Register page
	@RequestMapping("/register")
	public String register() 
	{
		return "signup";
	}
	
	//to save Registration data
	@RequestMapping(value = "/success",method = RequestMethod.POST)
	public String new_Reg(@ModelAttribute UserRegistration userRegistration)
	{
		this.userRegRepository.save(userRegistration);
		System.out.println(userRegistration);
		return "index";
		
	}
	
	/* to check working
	 * @RequestMapping(value = "/loginNow", method=RequestMethod.POST) 
	 * public String handle_login() { return "admin_home"; }
	 */
	
	
	//to check login credentials
	@RequestMapping(value = "/loginNow", method=RequestMethod.POST)
	public String handle_login(@ModelAttribute UserLogin userLogin, Model m)
	{
		List<Quiz> qList = quizRepository.findAll();
		m.addAttribute("qList", qList);
		//this.userLoginRepository.save(userLogin);
		System.out.println(userLogin);
		
		//checking for ADMIN
		Iterable<UserLogin> adminUsers = this.userLoginRepository.findAll();
		for(UserLogin i : adminUsers)
		{
			if(i.getUEmail().equals(userLogin.getUEmail()) && i.getPassword().equals(userLogin.getPassword()))
			{
				//return "Valid Login for ADMIN";
				return "adminPortal";
			}
		}
		
		//checking for STUDENT
		Iterable<UserRegistration> students = this.userRegRepository.findAll();
		for(UserRegistration j : students)
		{
			if(j.getEmailId().equals(userLogin.getUEmail()) && j.getCPassword().equals(userLogin.getPassword()) )
			{
				
				return "index";
			}
		}
		
		//if Invalid
		return "login";
	}
	
	/*
	@RequestMapping("/loginNow")
	public ModelAndView loginCurrent(UserLogin logi) {
		System.out.println("loaging...."+logi.getUEmail());
		
		ModelMap model=new ModelMap();
		model.addAttribute("name", logi.getUEmail());
		model.addAttribute("email", logi.getPassword());
		
		ModelAndView mv=new ModelAndView("user-details");
		mv.addObject("regObj",model);
		return mv;
	}
	*/
}