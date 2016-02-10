package br.com.elo7.java8.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class SubscriptionsFactory {

	public static List<Subscription> criarSubscriptions(){
		Customer paulo = new Customer("Paulo Silveira");
		Customer rodrigo = new Customer("Rodrigo Turini");
		Customer adriano = new Customer("Adriano Almeida");
		
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime yesterday = LocalDateTime.now().minusDays(1); 
		
		BigDecimal monthlyFee = new BigDecimal("99.90");
		Subscription s1 = new Subscription(monthlyFee, yesterday.minusMonths(5), paulo);
		Subscription s2 = new Subscription(monthlyFee, yesterday.minusMonths(8), today.minusMonths(1), rodrigo);
		Subscription s3 = new Subscription(monthlyFee, yesterday.minusMonths(5), today.minusMonths(2), adriano);
		
		return Arrays.asList(s1, s2, s3);
	}
}
