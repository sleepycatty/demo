package com.somegroup.cardfeed.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somegroup.cardfeed.model.Button;

public interface ButtonRepo extends JpaRepository<Button, String> {
	Button findByButtonName(String buttonName);
}
