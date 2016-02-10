package br.com.elo7.java8.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class Subscription {
	private BigDecimal monthlyFee;
	private LocalDateTime begin;
	private Optional<LocalDateTime> end;
	private Customer customer;
	
	public Subscription(BigDecimal monthlyFee, LocalDateTime begin, Customer customer) {
		this(monthlyFee,begin,null,customer);
	}

	public Subscription(BigDecimal monthlyFee, LocalDateTime begin, LocalDateTime end, Customer customer) {
		super();
		this.monthlyFee = monthlyFee;
		this.begin = begin;
		this.end = Optional.ofNullable(end);
		this.customer = customer;
	}

	public BigDecimal getMonthlyFee() {
		return monthlyFee;
	}

	public LocalDateTime getBegin() {
		return begin;
	}

	public Optional<LocalDateTime> getEnd() {
		return end;
	}

	public Customer getCustomer() {
		return customer;
	}
}
