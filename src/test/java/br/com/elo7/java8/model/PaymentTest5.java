package br.com.elo7.java8.model;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

public class PaymentTest5 {

	public static void main(String[] args) {
		List<Payment> pagamentos = PaymentsFactory.criarPagamentos();
		
		Function<Entry<Customer, List<List<Product>>>,List<Product>> valueMapperFunction = e-> e.getValue()
				.stream()
				.flatMap(List::stream)
				.sorted(comparing(Product::getName))
				.collect(toList());
		
		Map<Customer, List<Product>> clientesComProdutos = pagamentos.stream()
			.collect(groupingBy( Payment::getCustomer, mapping( pay-> pay.getProducts(), toList())))
			.entrySet()
			.stream()
			.collect(toMap(Map.Entry::getKey, valueMapperFunction));
			
		clientesComProdutos
			.entrySet()
			.forEach(System.out::println);
	}
}
