package br.com.elo7.java8.model;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PaymentTest3 {

	public static void main(String[] args) {
		List<Payment> pagamentos = PaymentsFactory.criarPagamentos();
		
		Map<Product, Long> produtosTotal = pagamentos.stream()
			.flatMap( p->p.getProducts().stream())
			.collect( groupingBy( Function.identity(), Collectors.counting() ) );
		
		produtosTotal.entrySet()
			.stream()
			.max(Map.Entry.comparingByValue())
			.ifPresent( System.out::println );
	}
}
