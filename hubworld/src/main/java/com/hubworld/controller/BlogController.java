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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hubworld.model.Blog;
import com.hubworld.model.BlogApproved;
import com.hubworld.model.BlogComment;
import com.hubworld.model.User;
import com.hubworld.service.BlogCommentService;
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
	private int getPrincipal() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		com.hubworld.model.User user = (com.hubworld.model.User) authentication.getPrincipal();
		uid = user.getUserId();
		System.out.println("The userId is" + uid);

		return uid;

	}

	@RequestMapping(value = "/blogpage")
	public ModelAndView register(Model model) {

		model.addAttribute("blog", new Blog());
		initModelList(model);
		ModelAndView mv = new ModelAndView("addblogs");
		return mv;

	}

	@RequestMapping(value="/addblog" , method=RequestMethod.POST)
	public ModelAndView addBlog(@Valid @ModelAttribute("blog") Blog blog, BindingResult result) {
		if (result.hasErrors()) {

			return new ModelAndView("addblogs");

		} else {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String user = authentication.getName();
			blog.setUsername(user);

			blogService.saveOrUpdate(blog);
		}
		return new ModelAndView("blogsaccepted");
	}

	@RequestMapping(value = "/allblog", method = RequestMethod.GET)
	public String getBlogList(Model model) {
		model.addAttribute("blogList", this.blogService.list());
		return "bloglist";

	}

	@RequestMapping("/viewblogdetail--{blogId}--blog")
	public ModelAndView viewproductdetails(@ModelAttribute Blog blog, @PathVariable int blogId) {

		Blog b = blogService.getBlogById(blogId);

		ModelAndView model = new ModelAndView("viewblogs");
		model.addObject("blog", b);
		return model;
	}

	private void initModelList(Model model) {

		List<String> blogList = new ArrayList<String>();
		blogList.add("Core JAVA");
		blogList.add("Advance JAVA");
		blogList.add("Angular JS");
		blogList.add("HTML5");
		blogList.add("CSS");
		blogList.add("Interfaces");
		blogList.add("Abstraction");
		blogList.add("Web flow");
		blogList.add("Spring MVC Architecture");
		blogList.add("Inheritance");
		blogList.add("Slider");
		blogList.add("JSTL");
		blogList.add("JSON");
		blogList.add("JAVA - NIO");
		blogList.add("JAVA Collections");
		blogList.add("Bootstrap Navbar");
		blogList.add("Bootstrap GRID");
		blogList.add("Spring MVC");
		blogList.add("Hibernate");
		blogList.add("Oracle - SQL");
		blogList.add("Normailization");
		blogList.add("Spring-Security");
		blogList.add("ORM");
		blogList.add("J-Query");
		blogList.add("JS Frameworks");
		blogList.add("Maven");
		blogList.add("DEv-ops");
		blogList.add("Carusoeal Slider");

		model.addAttribute("blogOptions", blogList);

	}

	// ------------------Approved Blog Controller-----------------------------

	@RequestMapping(value = "/blogtoapprove")
	public ModelAndView addApprove(@ModelAttribute("blogApproved") BlogApproved blogApproved,
			@RequestParam("blogId") int blogId) {

		String blogName = blogService.getBlogName(blogId);
		blogApproved.setBlogName(blogName);
		String blogCategory = blogService.getCategory(blogId);
		blogApproved.setBlogCategory(blogCategory);
		String blogDescription = blogService.getDescription(blogId);
		blogApproved.setBlogDescription(blogDescription);
		String username = blogService.getUsername(blogId);
		blogApproved.setUsername(username);

		blogService.saveApprovedBlog(blogApproved);
		blogService.deleteBlog(blogId);
		@SuppressWarnings("rawtypes")
		List blogAppList = blogService.approvedList();
		ModelAndView model = new ModelAndView("blogapproved");
		model.addObject("blogAppList", blogAppList.toString());

		return model;

	}

	@RequestMapping(value = "/approvedblogs", method = RequestMethod.GET)
	public String listBlogs(Model model) {

		model.addAttribute("blogAppList", this.blogService.approvedList());
		return "blogapproved";
	}

	@RequestMapping("/viewappblogdetail--{blogAppId}--blogApproved")
	public ModelAndView viewAppBlogdetails(@ModelAttribute BlogApproved blogApproved, @PathVariable int blogAppId) {

		BlogApproved b = blogService.getBlogAppById(blogAppId);

		ModelAndView model = new ModelAndView("viewappblogs");
		model.addObject("blogapp", b);
		@SuppressWarnings("rawtypes")
		List blogCommentListById=blogCommentService.getCommentById(blogAppId);
		model.addObject("blogCommentList", blogCommentListById.toString());
		return model;
	}
	
	@RequestMapping("blog/remove/{blogAppId}")
	public String removeProduct(@PathVariable("blogAppId") int blogAppId, ModelMap model) throws Exception {

		try {
			blogService.deleteBlog(blogAppId);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/approvedblogs";
	}

	// ----------------------------for blog comments section------------------------------

	@Autowired
	private BlogCommentService blogCommentService;

	@RequestMapping(value="viewappblogs/addcomment",method = RequestMethod.POST)
	public ModelAndView addBlogComment(@Valid @ModelAttribute("blogComment") BlogComment blogComment,
			BindingResult result,@PathVariable @RequestParam("blogAppId") int blogAppId, Model model) {
		if (result.hasErrors()) {

			return new ModelAndView("viewappblogs");

		} else {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String user = authentication.getName();
			blogComment.setUsername(user);
			int blog_id = blogService.getblogAppId(blogAppId);
			blogComment.setBlogAppId(blog_id);
			
			System.out.println("success" + blog_id + user);
			blogCommentService.saveOrUpdate(blogComment);
			int a=blogComment.getBlogCommentId();
			System.out.println("success" + blog_id + user+a);
			BlogApproved b = blogService.getBlogAppById(blogAppId);
			model.addAttribute("userId",getUserId(model));
		}
		return new ModelAndView("redirect:/approvedblogs");
	}
	
	@ModelAttribute("blogComment")
	public BlogComment construct()
	{
		return new BlogComment();
	}
	
	int user_Id;
	public int  getUserId(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		user_Id=userService.getById(user);
		model.addAttribute("userId",user_Id);
		return user_Id;
	}


}
