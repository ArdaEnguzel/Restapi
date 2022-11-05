package com.example.demo.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class User {
	private Integer id;
	@JsonProperty("user_name")
	private String name;
	private LocalDate birthDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public User(Integer id, String name, LocalDate date) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = date;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", date=" + birthDate + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return birthDate;
	}
	public void setDate(LocalDate date) {
		this.birthDate = date;
	}
	

}
