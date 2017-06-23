package com.capg.cardservices.service;

import java.util.List;

import com.capg.cardservices.model.Card;
import com.capg.cardservices.model.Transaction;

public interface CardService {

	public List<Card> getCardListByCustomerId(Integer customerId);
	public Card getCardByNo(Long cardNo);
	public List<Transaction> getRecentTransactions(Long cardNo, String startDate, String endDate);
	public String payCreditCardBill(Long cardNo,Double payableAmount) ;
}