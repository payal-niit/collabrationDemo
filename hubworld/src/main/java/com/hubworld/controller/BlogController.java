package com.hubworld.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hubworld.model.Blog;
import com.hubworld.model.User;
import com.hubworld.service.BlogService;
import com.hubworld.service.UserService;

@Controller
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private UserService userService;
	int uid;
	@SuppressWarnings("unused")
	private int getPrincipal(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		com.hubworld.model.User user=(com.hubworld.model.User)authentication.getPrincipal();
		uid=user.getUserId();
		System.out.println("The userId is"+uid);

		return uid;
		
    }
	
	
	@RequestMapping(value="/blogpage")
	public ModelAndView register(Model model) {
		
		model.addAttribute("blog", new Blog());
		
		ModelAndView mv = new ModelAndView("addblogs");
		return mv;

	}
	
	@RequestMapping("/addblog")
	public ModelAndView addBlog(@Valid @ModelAttribute("blog") Blog blog, BindingResult result)
	{
		if (result.hasErrors()) {

			return new ModelAndView("addblogs");

		} else {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String user=authentication.getName();
			blog.setUsername(user);
			
			blogService.saveOrUpdate(blog);
		}
		return new ModelAndView("redirect:/allblog");
	}
		
	
	@RequestMapping(value="/allblog",method = RequestMethod.GET)
	public String getBlogList(Model model)
	{
		model.addAttribute("blogList", this.blogService.list());
		return "bloglist";

	}
	
	@RequestMapping("/viewblogdetail--{blogId}--blog")
	public ModelAndView viewproductdetails(@ModelAttribute Blog blog,@PathVariable int blogId)
	{
		
		Blog b = blogService.getBlogById(blogId);
		
		ModelAndView model=new ModelAndView("viewblogs");
		model.addObject("blog",b);
		return model;
	}

	protected Map referenceData(HttpServletRequest request) throws Exception {
		  
        Map referenceData = new HashMap();
        List<String> hobbiesList = new ArrayList<String>();
        hobbiesList.add("Gardening");
        hobbiesList.add("Listening Music");
        hobbiesList.add("Writing Technical Tutorials");
        referenceData.put("hobbiesList", hobbiesList);
  
        return referenceData;
  
    }
	
	



}
