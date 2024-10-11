package com.profile.controller;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.profile.entities.MyProfile;
import com.profile.services.MyProfileService;



@Controller
public class MyProfileController {
	
	@Autowired
	MyProfileService service;
	
	  @PostMapping("/create")
	    public String createProfile(@RequestParam("name") String name,
	                                @RequestParam("email") String email,
	                                @RequestParam("dob") LocalDate dob,
	                                @RequestParam("gender") String gender,
	                                @RequestParam("city") String city,
	                                @RequestParam("photo") MultipartFile photo,
	                                Model model) {
	        
	        MyProfile profile = new MyProfile();
	        profile.setName(name);
	        profile.setEmail(email);
	        profile.setDob(dob);
	        profile.setGender(gender);
	        profile.setCity(city);
	        
	        try {
	            if (!photo.isEmpty()) {
	                profile.setPhoto(photo.getBytes());  // Save photo bytes
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        service.createProfile(profile);

	        model.addAttribute("profile", profile);
	        return "profile";
	    }
	}

