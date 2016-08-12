package com.hubworld.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hubworld.model.User;
import com.hubworld.service.UserService;

@Controller
public class UserController {

	@Autowired(required = true)
	private UserService userService;
	
	public UserController() {
		
	}

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping("/")
	public String getIndex() {
		return "welcome";
	}

	@RequestMapping("/loginpage")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		if (error != null) {
			model.addAttribute("error", "Invalid username and password");
		}

		if (logout != null) {
			model.addAttribute("msg", "You have been logged out successfully");
		}

		return "login";
	}
	@RequestMapping(value="/perform_logout")
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response)
	{
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth != null){
	new SecurityContextLogoutHandler().logout(request, response, auth);
	}
	return new ModelAndView("redirect:/");
	}

	

	@RequestMapping(value="/register")
	public ModelAndView register(Model model) {
		model.addAttribute("user", new User());
		
		ModelAndView mv = new ModelAndView("registration");
		return mv;

	}

	Path path;

	@RequestMapping(value = "/add")
	public ModelAndView addUser(@Valid @ModelAttribute("user") User user, BindingResult result,
			Map<String, Object> model, HttpServletRequest request) {
		// ModelAndView m1=new ModelAndView("redirect:reg_product");
		if (result.hasErrors()) {

			return new ModelAndView("registration");

		} else {
			user.setEnabled(true);
			user.setRole("ROLE_USER");
			
			MultipartFile productImage = user.getImage();
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			System.out.println(rootDirectory);
			path = Paths.get(rootDirectory + "resources/images/" + user.getUserId() + ".jpg");

			if (productImage != null && !productImage.isEmpty()) {
				try {
					productImage.transferTo(new File(path.toString()));
				} catch (Exception ex) {
					ex.printStackTrace();
					throw new RuntimeException("Product image saving failed", ex);
				}
			}
			userService.saveOrUpdate(user);
		}

		return new ModelAndView("welcome");
	}

	@RequestMapping("/deleteuser--{userId}--user")
	public ModelAndView deleteUser(@PathVariable int userId) {

		userService.delete(userId);
		return new ModelAndView("redirect:/userlist");
	}

	@RequestMapping(value="/userlist", method = RequestMethod.GET)
	public String listCategorys(Model model) {
		
		model.addAttribute("userList", this.userService.list());
		return "listusers";
	}
	
	@SuppressWarnings("unused")
	private int getPrincipal(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user=(User)authentication.getPrincipal();
		int uid=user.getUserId();
		return uid;
    }
	
	


}
