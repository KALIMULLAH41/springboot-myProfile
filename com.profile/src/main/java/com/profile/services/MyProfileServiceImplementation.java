package com.profile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profile.entities.MyProfile;
import com.profile.repositories.MyProfileRepository;
@Service
public class MyProfileServiceImplementation
             implements MyProfileService {
	
     @Autowired
	MyProfileRepository repo;
	
	@Override
	public void createProfile(MyProfile profile) {
		repo.save(profile);
	}

	}


