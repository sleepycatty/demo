package com.somegroup.cardfeed.util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.somegroup.cardfeed.controler.Card;
import com.somegroup.cardfeed.controler.DailyQuoteCard;
import com.somegroup.cardfeed.controler.StatusUpdateCard;
import com.somegroup.cardfeed.model.Button;
import com.somegroup.cardfeed.model.CardMessage;
import com.somegroup.cardfeed.model.CardType;
import com.somegroup.cardfeed.model.Customer;
import com.somegroup.cardfeed.model.CustomerType;
import com.somegroup.cardfeed.persistence.AuthorRepo;
import com.somegroup.cardfeed.persistence.ButtonRepo;
import com.somegroup.cardfeed.persistence.CustomerRepo;

public class CardHelper {

	public static List<Card> toCards(List<CardMessage> msgs, 
									AuthorRepo aRepo, ButtonRepo bRepo) {
		return msgs.stream().map(msg-> { 
								Card card = null;
								switch (msg.getType()) {
									case DAILY_QUOTE:
										card= new DailyQuoteCard(msg.getTitle(), msg.getContent(), aRepo.findByName(msg.getAuthor()));
										break;
									case STATUS_UPDATE:
										card= new StatusUpdateCard(msg.getTitle(), msg.getContent(), bRepo.findByButtonName(msg.getButtonName()), msg.getIconLink());
										break;
								}
								return card;
						})
				.filter(c->c !=null)
				.collect(Collectors.toList());
	}
	
	public static boolean applyCondition(Card card, String customerName, CustomerRepo cRepo) {
		Customer cust = cRepo.findByName(customerName);
		return card.test(cust);
	}
			
	
}
