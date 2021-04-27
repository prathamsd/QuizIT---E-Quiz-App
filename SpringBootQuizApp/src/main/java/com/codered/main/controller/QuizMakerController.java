package com.codered.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.codered.main.model.Question;
import com.codered.main.model.Quiz;
import com.codered.main.model.Result;
import com.codered.main.repository.QuestionRepo;
import com.codered.main.repository.QuizRepository;


@Controller
public class QuizMakerController 
{
	
	@Autowired
	private QuestionRepo questionRepo;
	@Autowired
	private QuizRepository quizRepository;
	
	@GetMapping("/createQuiz") 
	public String createQuiz() 
	{ return "adminPortal"; }
	
	@RequestMapping("/viewQuiz")
	public String viewQuiz(Model m) 
	{
		List<Quiz> qList = quizRepository.findAll();
		m.addAttribute("qList", qList);
		return "viewQuizzes";
	}
	
	@RequestMapping( value = "/addQue", method = RequestMethod.POST)
	public String callAddQues(@ModelAttribute Quiz quiz) 
	{
		System.out.println(quiz);
		quizRepository.save(quiz);
		return "addQuestion";
	}
	
	//to save Questions data
	@RequestMapping(value = "/successAddQue",method = RequestMethod.POST)
	public String new_Que(@ModelAttribute Question question )
	{
		System.out.println(question);
		this.questionRepo.save(question);
		System.out.println(question);
		return "addQuestion";
		
	}
	
	@GetMapping("/viewResults") 
	public String viewResults() 
	{ return "viewResults"; }
	
	
}