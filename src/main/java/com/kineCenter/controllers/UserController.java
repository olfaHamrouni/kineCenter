package com.kineCenter.controllers;



import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.kineCenter.entities.User;
import com.kineCenter.services.UserService;

@Controller
public class UserController {

	
	@Autowired
	UserService userService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping("/inscriptionUser")
	public String inscriptionUser(ModelMap modelMap)
	{
	modelMap.addAttribute("user", new User());
	return "createUser";
	}
	
	
	
	@RequestMapping("/saveUser")
	public String saveUser(@Valid User user,  BindingResult bindingResult, ModelMap modelMap)
	{
		
	if (bindingResult.hasErrors()) return "createUser";
		
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	userService.saveUser(user);
	modelMap.addAttribute("msg", "Inscription effectuée avec succès");
	return "index";
	
	}
	
	
	@RequestMapping("/profilUser")
	public String profilUser(ModelMap modelMap)
	{
		
		//User user = userService.findByUsername(username);
		String un = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findByUsername(un);
		modelMap.addAttribute("user", user);
		return "editUser";
	}
	
	
	@RequestMapping("updateUser")
	public String updateUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap)
	{
	if (bindingResult.hasErrors()) return "editUser";
	
	//user.setPassword(passwordEncoder.encode(user.getPassword()));
	userService.updateUser(user);
	return "index";
	
	}
	
	@RequestMapping("/ListeUsers")
	public String ListeUsers(ModelMap modelMap)
	{
	List<User> users = userService.ListUsers2();
	modelMap.addAttribute("users", users);
	return "ListeUsers";
	}
	
	@RequestMapping("/supprimerUser")
	public String supprimerUser(@RequestParam("id") Long id,ModelMap modelMap)
	{
	userService.deleteUserById(id);
	List<User> users = userService.ListUsers2();
	modelMap.addAttribute("users", users);
	return "listeUsers";
	}
	
	@RequestMapping("/changerEtat")
	public String changerEtat(@RequestParam("id") Long id, @RequestParam("e") boolean e, ModelMap modelMap)
	{
		boolean ee = !e;
			User user = userService.getUser(id);
			user.setEnabled(ee);
			userService.saveUser(user);
				
	List<User> users = userService.ListUsers2();
	modelMap.addAttribute("users", users);
	return "listeUsers";
	}
	
}