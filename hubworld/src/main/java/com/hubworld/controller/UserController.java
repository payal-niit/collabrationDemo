package com.hubworld.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hubworld.model.Message;
import com.hubworld.model.OutputMessage;
import com.hubworld.model.User;
import com.hubworld.model.UserFriendTemp;
import com.hubworld.service.EmailService;
import com.hubworld.service.UserFriendService;
import com.hubworld.service.UserProfileService;
import com.hubworld.service.UserService;

@Controller
public class UserController {

	@Autowired(required = true)
	private UserService userService;

	@Autowired(required = true)
	private EmailService emailService;
	
	@Autowired
	private UserProfileService userProfileService;
	
	@Autowired
	private UserFriendService userFriendService;

	public UserController() {

	}

	public UserController(UserService userService,EmailService emailService) {
		super();
		this.userService = userService;
		
	}
	@RequestMapping("/")
	public String getHome() {
		return "welcome";
	}

	@RequestMapping("/indexOfUser")
	public String getHomeAfterLogin(Model model) {
		model.addAttribute("userId",getUserId(model));
		return "userprofilehomepage";
	}

	@RequestMapping("/profile")
	public String getProfileOfuser(Model model) {
		model.addAttribute("userId",getUserId(model));
		try {
		model.addAttribute("userProfile",userProfileService.getProfileById(getUserId(model)));
		model.addAttribute("userDetail", userService.getUserById(getUserId(model)));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "profile";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/index")
	public String getIndex(Model model) {
		
		model.addAttribute("userId",getUserId(model));
		
		model.addAttribute("userProfile",userProfileService.getProfileById(getUserId(model)));
		model.addAttribute("userDetail", userService.getUserById(getUserId(model)));
		List userFriendList=userFriendService.getFriendById(getUserId(model));
		System.out.println("friends are"+getUserId(model));
		System.out.println("friends are"+userFriendList);
		model.addAttribute("friendList", userFriendList.toString());
		
		return "index";
	}
	
	@RequestMapping("/friendinvites")
	public String getFriendInvitelist(Model model) {				
		@SuppressWarnings("rawtypes")
		List userFriendList=userFriendService.getFriendById(getUserId(model));
		System.out.println("friends are"+getUserId(model));
		System.out.println("friends are"+userFriendList);
		model.addAttribute("friendList", userFriendList.toString());
		
		return "friendinvites";
	}
	
	@RequestMapping("/friendlist")
	public String getFriendlist(Model model) {				
		@SuppressWarnings("rawtypes")
		List userFriendList=userFriendService.getFriendByIdAccept(getUserId(model));
		System.out.println("friends are"+getUserId(model));
		System.out.println("friends are"+userFriendList);
		model.addAttribute("friendList", userFriendList.toString());
		
		return "friendlist";
	}
	
	@RequestMapping("friend/remove/{id}")
	public String removeFriend(@PathVariable("id") int id, ModelMap model) throws Exception {

		try {
			userFriendService.deleteFriend(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/friendinvites";
	}
	
	/*@RequestMapping("friend/accept/{id}")
	public String acceptFriend(@PathVariable("id") int id, ModelMap model) throws Exception {

		try {
			userFriendService.acceptfriend(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/friendinvites";
	}
	*/
	
	@RequestMapping("friend/accept/{id}")
	public String acceptFriend(@ModelAttribute("userFriendTemp") UserFriendTemp userFriendTemp,@PathVariable("id") int id, ModelMap model) throws Exception {

		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String user = authentication.getName();
			userFriendTemp.setUsername(user);
			
			userFriendTemp.setFlag("N");
			userFriendService.acceptfriend(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/friendinvites";
	}
	
	
	@RequestMapping("/dp")
	public String getProfilePicture(Model model) {
		model.addAttribute("userId",getUserId(model));
		return "header";
	}
	
	/*@RequestMapping("/")
	public String getIndex(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth==null) {
			return "header";
		}
		
		else {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String user = authentication.getName();
		int userId=userService.getById(user);
		model.addAttribute("userId",userId);
		
		return "welcome";
	}
	}*/

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

	@RequestMapping(value = "/perform_logout")
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/register")
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
			userService.saveOrUpdate(user);
			MultipartFile productImage = user.getImage();
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			System.out.println(rootDirectory);
			path = Paths.get(rootDirectory + "/resources/images/" + user.getUserId() + ".jpg");

			if (productImage != null && !productImage.isEmpty()) {
				try {
					productImage.transferTo(new File(path.toString()));
				} catch (Exception ex) {
					ex.printStackTrace();
					throw new RuntimeException("Product image saving failed", ex);
				}
			}
			try {
				emailService.send(user, "Account Activation",
						"Welcome to Anytime Connect. We are happy to have you in our team");
			} catch (MessagingException ms) {
				ms.printStackTrace();

			}
		}

		return new ModelAndView("welcome");
	}

	@RequestMapping("/deleteuser--{userId}--user")
	public ModelAndView deleteUser(@PathVariable int userId) {

		userService.delete(userId);
		return new ModelAndView("redirect:/userlist");
	}

	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public String listCategorys(Model model) {

		model.addAttribute("userList", this.userService.list());
		return "listusers";
	}

	@SuppressWarnings("unused")
	private int getPrincipal() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		int uid = user.getUserId();
		return uid;
	}
	
	// -------------------displaying profile picture-----------------
	int user_Id;
	public int  getUserId(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		user_Id=userService.getById(user);
		model.addAttribute("userId",user_Id);
		return user_Id;
	}

//	----------------------Chat----------------------------
	
	@RequestMapping("/chatpage")
	public ModelAndView chat() {
		ModelAndView model = new ModelAndView("chat");
		return model;
	}
	
	@MessageMapping("/chat")
	  @SendTo("/topic/message")
	  public OutputMessage sendMessage(Message message, Principal principal) {
	    return new OutputMessage(message, new Date(),principal.getName());
	  }

}
