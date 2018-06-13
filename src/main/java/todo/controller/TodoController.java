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
import org.springframework.web.bind.annotation.PathVariable;
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
		List<Challenge> challengeList=cr.makeView();
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
		mav.addObject("actionName","/create");
		mav.addObject("actionLabel","起票");
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
	
	@RequestMapping(value="/edit/{id}")
	public ModelAndView edit(
			HttpServletRequest req,
			ModelAndView mav,
			@PathVariable long id){
		mav.setViewName("input");
		Challenge c=cr.findById(id);
		mav.addObject("formModel",c);
		mav.addObject("actionName","/update");
		mav.addObject("actionLabel","修正");
		return mav;
	}
	
	@RequestMapping(value="/update")
	public ModelAndView update(
			@ModelAttribute("formModel") @Validated Challenge c){
		cr.saveAndFlush(c);
		ModelAndView mav=new ModelAndView("redirect:/");
		return mav;
	}
}
