package br.com.elo7.java8.model;

import java.math.BigDecimal;
import java.util.List;

public class PaymentTest2 {

	public static void main(String[] args) {
		List<Payment> pagamentos = PaymentsFactory.criarPagamentos();
		
		BigDecimal total = pagamentos.stream()
			.flatMap( p->p.getProducts().stream().map(Product::getPrice))
			.reduce(BigDecimal.ZERO, BigDecimal::add );
		
		System.out.println(total);
	}
}
