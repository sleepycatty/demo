package com.somegroup.cardfeed;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.somegroup.cardfeed.model.Author;
import com.somegroup.cardfeed.model.Button;
import com.somegroup.cardfeed.model.CardMessage;
import com.somegroup.cardfeed.model.CardType;
import com.somegroup.cardfeed.model.Customer;
import com.somegroup.cardfeed.model.CustomerType;
import com.somegroup.cardfeed.persistence.AuthorRepo;
import com.somegroup.cardfeed.persistence.ButtonRepo;
import com.somegroup.cardfeed.persistence.CardMessageRepo;
import com.somegroup.cardfeed.persistence.CustomerRepo;

@Configuration
public class initDataLoader {

	private static final Logger log = LoggerFactory.getLogger(initDataLoader.class);
	
	@Bean
	CommandLineRunner runLoadingData(CardMessageRepo cmRepo,
										ButtonRepo bRepo,
										AuthorRepo aRepo,
										CustomerRepo cRepo) {
		return args->{
			log.info("start loading intial data ...");
			//String content, String author, LocalDate date, CardType type, String iconLink, String buttonName
			CardMessage cm1 = new CardMessage("Daily Quote1","quote1", "author1", LocalDate.now(), CardType.DAILY_QUOTE, "", "");
			CardMessage cm2 = new CardMessage("Daily Quote2","quote2", "author2", LocalDate.now(), CardType.DAILY_QUOTE, "", "");
			CardMessage cm3 = new CardMessage("Daily Quote3","quote3", "author3", LocalDate.now(), CardType.DAILY_QUOTE, "", "");
			CardMessage cm4 = new CardMessage("Important Security Update","For your security, we support 2 factor authentication, "
					+ "and would recommend that you turn it on.", "author2", LocalDate.now(), CardType.STATUS_UPDATE, 
					"https://tinyurl.com/y5mdph2g", Button.STATUS_BUTTON_NAME);			
			List<CardMessage> listCardMessages = cmRepo.saveAll(Arrays.asList(cm1,cm2,cm3,cm4));
			log.info("Loaded Card Messages"+Arrays.toString(listCardMessages.toArray()));
			
			Author a1 = new Author("author1");
			Author a2 = new Author("author2");
			Author a3 = new Author("author3");
			Author a4 = new Author("author2");
			List<Author> listAuthors = aRepo.saveAll(Arrays.asList(a1,a2,a3,a4));
			log.info("Loaded Authors. "+Arrays.toString(listAuthors.toArray()));
			
			Button b1 = new Button(Button.STATUS_BUTTON_NAME, "Got it, thanks");
			Button btn = bRepo.save(b1);
			log.info("Loaded Buttons. "+btn.toString());
			
			Customer c1 = new Customer("customer1", CustomerType.TYPE_A);
			Customer c2 = new Customer("customer2", CustomerType.TYPE_B);
			Customer c3 = new Customer("customer3", CustomerType.TYPE_C);
			List<Customer> listCustomers = cRepo.saveAll(Arrays.asList(c1,c2,c3));
			log.info("Loaded Customers. "+Arrays.toString(listCustomers.toArray()));
		};
	}
}
