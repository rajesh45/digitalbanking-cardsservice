package com.capg.cardservices.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cards_transaction", catalog="postgres", schema="public")
public class Transaction implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sno")
	private int transactionId; 
	
	@Column(name="tx_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	
	@Column(name="tx_type")
	private String transactionType;
	
	@Column(name="tx_description")
	private String transactionDescription;
	
	@Column(name="tx_value")
	private Double transactionValue;
	
	@Column(name="card_no")
	private Long cardNo; 
	
	@Column(name="reward_points")
	private Long rewardPoints; 

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getTransactionValue() {
		return transactionValue;
	}

	public void setTransactionValue(Double transactionValue) {
		this.transactionValue = transactionValue;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public Long getCardNo() {
		return cardNo;
	}

	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}
	
	public Long getRewardPoints() {
		return rewardPoints;
	}
	
	public void setRewardPoints(Long rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionType=" + transactionType + ", transactionDescription=" + transactionDescription
				+ ", transactionValue=" + transactionValue + ", cardNo=" + cardNo + "]";
	}
}