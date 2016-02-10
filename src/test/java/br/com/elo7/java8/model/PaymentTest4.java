package br.com.elo7.java8.model;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class PaymentTest4 {

	public static void main(String[] args) {
		long tempoInicial = System.currentTimeMillis();
		
		List<Payment> pagamentos = PaymentsFactory.criarPagamentos();
		
		pagamentos.stream()
			.flatMap( p-> p.getProducts().stream() )
			.collect( groupingBy( Function.identity(), 
					  reducing( BigDecimal.ZERO, Product::getPrice, BigDecimal::add ) ) )
			.entrySet()
			.stream()
			.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
			.forEach( System.out::println );
		
		long tempoFinal = System.currentTimeMillis();	
		
		System.out.println(tempoFinal-tempoInicial);
	}
}
