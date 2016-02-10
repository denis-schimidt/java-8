package br.com.elo7.java8.model;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class PaymentTest6 {

	public static void main(String[] args) {
		long tempoInicial = System.currentTimeMillis();
		
		List<Payment> pagamentos = PaymentsFactory.criarPagamentos();
		
		Function<Payment, BigDecimal> valueMapperFunction = p -> p.getProducts()
				.stream()
				.map(Product::getPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		Map<Customer, BigDecimal> totalPorCliente = pagamentos.stream()
			.collect(groupingBy(Payment::getCustomer, 
					reducing( BigDecimal.ZERO, valueMapperFunction, BigDecimal::add)));
			
		totalPorCliente.entrySet()
			.stream()
			.sorted(comparing(Map.Entry::getValue, reverseOrder()))
			.forEach(System.out::println);
		
		long tempoFinal = System.currentTimeMillis();	
		
		System.out.println(tempoFinal-tempoInicial);
	}
}
