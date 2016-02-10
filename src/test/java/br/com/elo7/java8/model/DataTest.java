package br.com.elo7.java8.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class DataTest {
	public static void main(String[] args) {
		LocalDate aniversario = LocalDate.of(1978, 5, 22);
		LocalDate hoje = LocalDate.now();
		
		Period periodoVivido = Period.between(aniversario, hoje);
		
		System.out.printf( "Até hoje vivi %d anos, %d meses e %d dias", periodoVivido.getYears(), periodoVivido.getMonths(), 
				periodoVivido.getDays() );
		
		LocalDateTime hojeInicioDia = LocalDateTime.now();
		LocalDateTime aniversarioHorario = aniversario.atTime(22, 10, 0);
	
		Duration tempoDecorrido = Duration.between(hojeInicioDia, aniversarioHorario);
		
		if( tempoDecorrido.isNegative() ){
			tempoDecorrido = tempoDecorrido.negated();
		}
		
		System.out.printf( "\nAté hoje vivi %d horas, %d minutos e %d segundos", tempoDecorrido.toHours(), tempoDecorrido.toMinutes(), 
				tempoDecorrido.getSeconds() );
	}
}
