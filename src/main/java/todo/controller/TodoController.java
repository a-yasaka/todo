package todo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TodoController {
	@RequestMapping(value="/")
	public void hello(
			HttpServletRequest req,
			HttpServletResponse res) throws IOException{
		PrintWriter pw=res.getWriter();
		pw.print("hello");
	}
}
