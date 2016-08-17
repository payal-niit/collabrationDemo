package com.hubworld.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hubworld.model.Blog;
import com.hubworld.model.User;
import com.hubworld.model.UserProfile;
import com.hubworld.service.UserFriendService;
import com.hubworld.service.UserProfileService;
import com.hubworld.service.UserService;

@Controller

public class UserProfileController {
	@Autowired
	private UserProfileService userProfileService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserFriendService userFriendService;
	
	@RequestMapping(value = "/profiletoadd")
	public ModelAndView register(Model model) {

		model.addAttribute("userProfile", new UserProfile());
		initModelList(model);
		
		ModelAndView mv = new ModelAndView("userprofile");
		return mv;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    binder.registerCustomEditor(Date.class,"dob", new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping("/addprofile")
	public ModelAndView addBlog(@Valid @ModelAttribute("userProfile") UserProfile userProfile, BindingResult result,Model model) {
		if (result.hasErrors()) {

			return new ModelAndView("userprofile");

		} else {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String user = authentication.getName();
			userProfile.setUsername(user);
			userProfile.setUserId(getUserId(model));
			System.out.println(user + user_Id);
			userProfileService.saveOrUpdate(userProfile);
		}
		return new ModelAndView("redirect:/indexOfUser");
	}
	
	@RequestMapping("/viewprofile--{userId}--user")
	public ModelAndView viewproductdetails(@ModelAttribute User user, @PathVariable int userId,Model m) {

		User u = userService.getUserById(userId);

		ModelAndView model = new ModelAndView("userprofileuserwise");
		model.addObject("user", u);
		model.addObject("userDetail", userService.getUserById(userId));
		try{
		model.addObject("userProfile", userProfileService.getProfileById(userId));
		}catch(Exception e) {
			System.out.println("No profile added");
		}
		
		return model;
	}
	
	@RequestMapping("/confirmprofile--{userId}--user")
	public ModelAndView confirmprofile(@ModelAttribute User user, @PathVariable int userId,Model m) {

		User u = userService.getUserById(userId);

		ModelAndView model = new ModelAndView("acceptfriend");
		List userFriendList=userFriendService.getFriendById(getUserId(m));
		model.addObject("user", u);
		model.addObject("userDetail", userService.getUserById(userId));
		model.addObject("friendList",userFriendList.toString());
		try{
		model.addObject("userProfile", userProfileService.getProfileById(userId));
		}catch(Exception e) {
			System.out.println("No profile added");
		}
		
		return model;
	}
	
		
	private void initModelList(Model model) {

		List<String> interestList = new ArrayList<String>();
		interestList.add("Coding");
		interestList.add("Reading");
		interestList.add("Dancing");
		interestList.add("Indoor Games");
		interestList.add("Outdoor Games");

		model.addAttribute("interestOptions", interestList);	
//--------------new-----------------------------------------
		List<String> joinList = new ArrayList<String>();
		joinList.add("Friends");
		joinList.add("Being in Touch");
		joinList.add("TP");
		joinList.add("Managing Events");
		

		model.addAttribute("joinOptions", joinList);

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
