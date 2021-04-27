package com.codered.main.controller;

import java.util.List;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codered.main.UserLogin;
import com.codered.main.UserLoginRepository;
import com.codered.main.UserRegRepository;
import com.codered.main.model.QuestionForm;
import com.codered.main.model.Quiz;
import com.codered.main.model.Result;
import com.codered.main.repository.QuizRepository;
import com.codered.main.service.QuizService;

@Controller
public class MainController {
	
	@Autowired
	Result result;
	@Autowired
	QuizService qService;
	
	@Autowired
	private UserRegRepository userRegRepository;
	@Autowired
	private UserLoginRepository userLoginRepository;
	@Autowired
	private QuizRepository quizRepository;
	
	Boolean submitted = false;
	
	@ModelAttribute("result")
	public Result getResult() {
		return result;
	}
	
	
	 @GetMapping("/") public String home() { return "login"; }
	 
	
	 @RequestMapping(value = "/quiz",method = RequestMethod.POST)
	 public String quiz(@ModelAttribute Quiz quiz, Model m, RedirectAttributes ra) 
	 {
		 System.out.println(quiz);
		if(quiz.getQuiz_key().equals("")) {
				ra.addFlashAttribute("warning", "Enter Quiz Key!");
				return "index.html";
			}
			submitted = false;
			//to check later for result
			result.setUsername(quiz.getQuiz_name());
		
			
			Iterable<Quiz> quizs = this.quizRepository.findAll();
			for(Quiz i : quizs)
			{
				if(quiz.getQuiz_key().equals(i.getQuiz_key()))
				{
					System.out.println(i);
					if(i.getQuiz_name().equals(quiz.getQuiz_name()))
					{
						QuestionForm qForm = qService.getQuestions();
						m.addAttribute("qForm", qForm);
						return "quiz";
					}
					//IF NOT THEN REDIRECT
					return "index.html";
				}
			}
			//IF NOT THEN REDIRECT
			return "index.html";
		}
	 
	
	 
	 
	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionForm qForm, Model m) {
		if(!submitted) {
			result.setTotalCorrect(qService.getResult(qForm));
			qService.saveScore(result);
			submitted = true;
		}
		
		return "result.html";
	}
	
	@GetMapping("/score")
	public String score(Model m) 
	{
		List<Result> sList = qService.getTopScore();
		m.addAttribute("sList", sList);
		
		return "scoreboard.html";
	}

}
