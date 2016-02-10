package br.com.elo7.java8.model;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

public class PaymentTest8 {

	public static void main(String[] args) {
		long tempoInicial = System.currentTimeMillis();
		
		List<Payment> pagamentos = PaymentsFactory.criarPagamentos();
		
		Function<Payment, BigDecimal> valueMapperfunction = p-> p.getProducts()
				.stream()
				.map(Product::getPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		pagamentos.stream()
			.collect( groupingBy( p-> DateTimeFormatter.ofPattern("MM/yyyy").format(YearMonth.from(p.getDate())), 
					reducing(BigDecimal.ZERO, valueMapperfunction, BigDecimal::add)))
			.entrySet()
			.stream()
			.forEach( System.out::println);
		
		long tempoFinal = System.currentTimeMillis();	
		
		System.out.println(tempoFinal-tempoInicial);
	}
}
