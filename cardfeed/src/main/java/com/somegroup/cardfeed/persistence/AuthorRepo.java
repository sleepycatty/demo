package com.somegroup.cardfeed.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somegroup.cardfeed.model.Author;

public interface AuthorRepo extends JpaRepository<Author, String> {
	Author findByName(String name);
}
