package com.somegroup.cardfeed.persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somegroup.cardfeed.model.CardMessage;
import com.somegroup.cardfeed.model.CardType;

public interface CardMessageRepo extends JpaRepository<CardMessage, Long> {
	List<CardMessage> findByDateAndType(LocalDate date, CardType type);
	List<CardMessage> findByDate(LocalDate date);
}
