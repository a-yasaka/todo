package todo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import todo.repository.GreetRepository;


@Controller
public class TodoController {
	
	@Autowired
	GreetRepository gr;
	
	@RequestMapping(value="/")
	public void hello(
			HttpServletRequest req,
			HttpServletResponse res) throws IOException{
		PrintWriter pw=res.getWriter();
		pw.print("Hello world!!\n");
		pw.print(gr.findAll().get(0).getGreet());
	}
	
	@RequestMapping(value="/tl")
	public ModelAndView tltest(ModelAndView mav){
		mav.setViewName("hello");
		return mav;
	}
}
