package com.profile.entities;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Base64;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class MyProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private LocalDate dob;
	private String gender;
	private String city;

	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(columnDefinition="LONGBLOB")
	private byte[] photo;
	
	public String getPhotoBase64() {
        if (photo == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(photo);
    }

	public MyProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyProfile(Long id, String name, String email, LocalDate dob, String gender, String city, byte[] photo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.city = city;
		this.photo = photo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "MyProfile [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", gender=" + gender
				+ ", city=" + city + ", photo=" + Arrays.toString(photo) + "]";
	}

	
}
