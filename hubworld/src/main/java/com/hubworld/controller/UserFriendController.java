package com.hubworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hubworld.model.BlogApproved;
import com.hubworld.model.UserFriend;
import com.hubworld.model.UserFriendTemp;
import com.hubworld.service.UserFriendService;
import com.hubworld.service.UserService;

@Controller
public class UserFriendController {
	
	@Autowired
	private UserFriendService userFriendService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/addfriend")
	public ModelAndView addFriend(@ModelAttribute("userFriendTemp") UserFriendTemp userFriendTemp,
			@RequestParam("userId") int userId,Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		userFriendTemp.setUsername(user);
		String friend=userService.getName(userId);
		userFriendTemp.setFriendName(friend);
		userFriendTemp.setUserId(getUserId(model));
		int user_Id=userService.getById(friend);
		userFriendTemp.setFriendId(user_Id);
		userFriendTemp.setFlag("Y");
		userFriendService.saveOrUpdateTemp(userFriendTemp);
		return new ModelAndView("redirect:/");		
	}
	
	/*@RequestMapping(value = "/confirmfriend")
	public ModelAndView addApprove(@ModelAttribute("userFriend") UserFriend userFriend,
			@RequestParam("userId") int userId, Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		userFriend.setUsername(user);
		String friend=userService.getName(userId);
		userFriend.setFriendName(friend);
		userFriend.setUserId(getUserId(model));
		int user_Id=userService.getById(friend);
		userFriend.setFriendId(user_Id);
		userFriendService.getFriendListById(userId);
		userFriendService.saveOrUpdate(userFriend);
	

		return new ModelAndView("redirect:/");

	}*/
	
	@RequestMapping(value = "/confirmfriend")
	public ModelAndView addApprove(@ModelAttribute("userFriendTemp") UserFriendTemp userFriendTemp,
			@RequestParam("userId") int userId, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		userFriendTemp.setUsername(user);
		String friend=userService.getName(userId);
		userFriendTemp.setFriendName(friend);
		userFriendTemp.setUserId(getUserId(model));
		int user_Id=userService.getById(friend);
		userFriendTemp.setFriendId(user_Id);
		userFriendTemp.setFlag("N");
		userFriendService.saveOrUpdateTemp(userFriendTemp);
	

		return new ModelAndView("redirect:/");

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
