package com.profile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profile.entities.MyProfile;

public interface MyProfileRepository
extends JpaRepository<MyProfile,Long> {

}
