package br.com.elo7.java8.model;

import static java.util.stream.Collectors.toMap;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SubscriptionTest {

	public static void main(String[] args) {
		List<Subscription> subscriptions = SubscriptionsFactory.criarSubscriptions();
		
		Map<Customer, BigDecimal> totalPorCliente = subscriptions.stream()
			.collect(toMap( Subscription::getCustomer, s-> s.getMonthlyFee().multiply(
					BigDecimal.valueOf(
							ChronoUnit.MONTHS.between(s.getBegin(), s.getEnd().orElse(LocalDateTime.now()))))));
	
		totalPorCliente.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.forEach(System.out::println);
	}
}
