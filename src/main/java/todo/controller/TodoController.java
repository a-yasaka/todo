package todo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import todo.model.Challenge;
import todo.repository.ChallengeRepository;
import todo.util.StringUtil;


@Controller
public class TodoController {
	
	@Autowired
	ChallengeRepository cr;
	
	@RequestMapping(value="/")
	public ModelAndView view(
			HttpServletRequest req,
			ModelAndView mav,
			@ModelAttribute("formModel") Challenge c) throws IOException{
		mav.setViewName("view");
		List<Challenge> challengeList=cr.findAll();
		for(int i=0;i<challengeList.size();i++){
			challengeList.get(i).setChallenge(StringUtil.changeBr(challengeList.get(i).getChallenge()));
			challengeList.get(i).setMemo(StringUtil.changeBr(challengeList.get(i).getMemo()));
		}
		mav.addObject("challenge",challengeList);
		return mav;
	}
	
	@RequestMapping(value="/input")
	public ModelAndView input(
			HttpServletRequest req,
			ModelAndView mav,
			@ModelAttribute("formModel") Challenge c){
		mav.setViewName("input");
		return mav;
	}
	
	@RequestMapping(value="/create")
	public ModelAndView create(
			HttpServletResponse res,
			ModelAndView mav,
			@ModelAttribute("formModel") @Validated Challenge c,
			BindingResult br){
		ArrayList<String> custErr=new ArrayList<String>();
		if(c.getStartDate()==null) custErr.add("日付は必須です");
		if(br.hasErrors()||!custErr.isEmpty()){
			mav.addObject("custErr",custErr);
			mav.setViewName("view");
		}else{
			cr.save(c);
			mav=new ModelAndView("redirect:/");
		}
		return mav;
	}
	
}
