package com.capg.cardservices.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Entity
@Table(name = "CARD")
@XmlRootElement
public class Card {
	//card_no
	@Id
	@Column(name = "card_no")
	@XmlElement
	Long cardNo ;
	
	//cvv

	@Column(name = "cvv")
	int cvv;
	
	//expiry_date
	@Column(name = "expiry_date")
	Date expiryDate;
	
	//card_type
	@Column(name = "card_type")
	String cardType; 
	
	//customer_id
	@Column(name = "customer_id")
	Integer customerId;
	
	//card_company
	@Column(name = "card_company")
	String cardCompany;
	
	//credit_limit
	@XmlElement
	@Column(name = "credit_limit")
	double creditLimit; 
	
	//card_status
	@Column(name = "card_status")
	Integer cardStatus ;
	
	public Long getCardNo() {
		return cardNo;
	}
	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCardCompany() {
		return cardCompany;
	}
	public void setCardCompany(String cardCompany) {
		this.cardCompany = cardCompany;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public Integer isCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(Integer cardStatus) {
		this.cardStatus = cardStatus;
	}
	@Override
	public String toString() {
		return "Card [cardNo=" + cardNo + ", cvv=" + cvv + ", expiryDate=" + expiryDate + ", cardType=" + cardType
				+ ", customerId=" + customerId + ", cardCompany=" + cardCompany + ", creditLimit=" + creditLimit
				+ ", cardStatus=" + cardStatus + "]";
	}
}