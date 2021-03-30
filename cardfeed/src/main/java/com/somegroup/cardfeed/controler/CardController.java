package com.somegroup.cardfeed.controler;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.somegroup.cardfeed.model.CardMessage;
import com.somegroup.cardfeed.model.CardType;
import com.somegroup.cardfeed.persistence.AuthorRepo;
import com.somegroup.cardfeed.persistence.ButtonRepo;
import com.somegroup.cardfeed.persistence.CardMessageRepo;
import com.somegroup.cardfeed.persistence.CustomerRepo;
import com.somegroup.cardfeed.util.CardHelper;

@RestController
public class CardController {
	
	@Autowired
	private CardMessageRepo cmRepo;
	@Autowired
	private ButtonRepo bRepo;
	@Autowired
	private AuthorRepo aRepo;
	@Autowired
	private CustomerRepo cRepo;
	
	private static Logger log = LoggerFactory.getLogger(CardController.class);
	
	@GetMapping("/cards/{customerName}")
	public List<Card> getCardFeed(@PathVariable String customerName){
		List<CardMessage> messages = getTodayCardMessages();
		List<Card> cards = CardHelper.toCards(messages, aRepo, bRepo);
		log.info("number of cards "+ (cards!=null?""+cards.size():-1));
		return cards.stream().filter(card->CardHelper.applyCondition(card, customerName, cRepo))
					.collect(Collectors.toList());
	}
	
	@GetMapping("/cards")
	public List<Card> getCards(){
		List<CardMessage> messages = getTodayCardMessages();
		List<Card> cards = CardHelper.toCards(messages, aRepo, bRepo);
		log.info("number of cards "+ (cards!=null?""+cards.size():-1));
		return cards;
	}

	private List<CardMessage> getTodayCardMessages(){
		log.info("getTodayCardMessages is called. ");
		List<CardMessage> list = cmRepo.findByDate(LocalDate.now());
		log.info("retrieved list "+Arrays.toString(list.toArray()));
		return list;
	}

	
}
