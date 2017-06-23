package com.capg.cardservices.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.capg.cardservices.dao.CardDAO;
import com.capg.cardservices.dao.TransactionDAO;
import com.capg.cardservices.model.Card;
import com.capg.cardservices.model.Transaction;
import com.capg.cardservices.service.CardService;
/***
 * Service layer for getting the card details from DB
 * @author sujillel
 *
 */
@Service
public class CardServiceImpl implements CardService {
	static Logger logger = Logger.getLogger(CardServiceImpl.class);

	@Value("${max.recent.transactions}")
	private Integer maxRecentTransactions;
	
	@Autowired
	private CardDAO cardDao;
	
	@Autowired
	private TransactionDAO transactionDao;
	
	@Override
	public List<Card> getCardListByCustomerId(Integer customerId){
		if(customerId == null) {
			logger.warn("Invalid customerId for finding card list By CustomerId : "+customerId);
			return null;
		}
		
		List<Card> cardList= cardDao.findByCustomerId(customerId);
		int size=cardList.size();
		logger.info("Cards count found for the customer : "+size);
		return cardList;
	}
	
	@Override
	public Card getCardByNo(Long cardNo){
		if(cardNo == null) {
			logger.warn("Invalid CardNo for finding card By CardNo : "+cardNo);
			return null;
		}
		logger.info("Getting card by no.");
		return cardDao.findByCardNo(cardNo);
	}

	@Override
	public List<Transaction> getRecentTransactions(Long cardNum
			, String startDate
			, String endDate) {
		Date startDt;
		List<Transaction> txList = null;
		try {
			startDt = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			Date endDt =new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			txList = transactionDao.getTransactions(cardNum, startDt, endDt);
			
			// Get max 10 recent transactions
			if(txList!= null && txList.size()>maxRecentTransactions){
				txList = txList.subList(0, maxRecentTransactions-1);
			}
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
		logger.info("Getting recent transactions");
		return txList;
	}
	
	@Override
	public String payCreditCardBill(Long cardNo,Double payableAmount) {
		System.out.println("REQUEST IN CREDIT CARD BILL PAYMENT SERVICE");
		Card credit_card = cardDao.findByCardNo(cardNo);		
		double newBalance = credit_card.getCreditLimit() + payableAmount;
		credit_card.setCreditLimit(newBalance);
		cardDao.save(credit_card);		
		return "SUCCESS!";
	}
}