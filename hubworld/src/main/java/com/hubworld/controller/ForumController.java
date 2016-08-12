package com.hubworld.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hubworld.model.Blog;
import com.hubworld.model.Forum;
import com.hubworld.service.ForumService;

@Controller
public class ForumController {
	@Autowired
	private ForumService forumService;

	@RequestMapping(value = "/forumpage")
	public ModelAndView register(Model model) {

		model.addAttribute("forum", new Forum());

		ModelAndView mv = new ModelAndView("addforum");
		return mv;

	}

	Path path;

	@RequestMapping(value = "/addingforum")
	public ModelAndView addForum(@Valid @ModelAttribute("forum") Forum forum,BindingResult result, Map<String, Object> model, HttpServletRequest request) {
		if (result.hasErrors()) {

			return new ModelAndView("addforum");

		} else {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String user = authentication.getName();
			forum.setUsername(user);
			
			Date date=new Date();
			forum.setDateOfCreation(date);

			MultipartFile productImage = forum.getForumImage();
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			path = Paths.get(rootDirectory + "/resources/images/" + forum.getForumId() + ".jpg");

			if (productImage != null && !productImage.isEmpty()) {
				try {
					productImage.transferTo(new File(path.toString()));
				} catch (Exception ex) {
					ex.printStackTrace();
					throw new RuntimeException("Product image saving failed", ex);
				}
			}

			forumService.saveOrUpdate(forum);
		}
		return new ModelAndView("redirect:/allforums");
			// return "redirect:/uploadFile";

		}

	

	@RequestMapping(value = "/allforums", method = RequestMethod.GET)
	public String getBlogList(Model model) {
		model.addAttribute("forumList", this.forumService.list());
		return "forumlist";

	}
	
	@RequestMapping("/viewblogdetail--{forumId}--forum")
	public ModelAndView viewproductdetails(@ModelAttribute Forum forum,@PathVariable int forumId)
	{
		
		Forum b = forumService.getForumById(forumId);
		
		ModelAndView model=new ModelAndView("viewforums");
		model.addObject("forum",b);
		return model;
	}
	
	@RequestMapping("forum/remove/{forumId}")
	public String removeProduct(@PathVariable("forumId") int forumId, ModelMap model) throws Exception {

		try {
			forumService.deleteForum(forumId);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/allforums";
	}


}
