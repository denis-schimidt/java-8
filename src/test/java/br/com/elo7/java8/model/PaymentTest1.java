package br.com.elo7.java8.model;

import java.util.Comparator;
import java.util.List;

public class PaymentTest1 {

	public static void main(String[] args) {
		List<Payment> pagamentos = PaymentsFactory.criarPagamentos();
		
		pagamentos.stream()
			.sorted( Comparator.comparing(Payment::getDate).reversed())
			.forEach( System.out::println);
	}
}
