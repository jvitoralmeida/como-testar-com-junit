package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

	private ReajusteService reajusteService;
	private Funcionario funcionario;

	@BeforeEach
	private void initialize(){
		this.reajusteService = new ReajusteService();
		this.funcionario =
				new Funcionario(
						"João Vitor", LocalDate.of(2021, Month.SEPTEMBER, 13), new BigDecimal("1000"));
	}

	@Test
	void reajuste3PorcentoQuandoResultoForA_Desejar(){
		reajusteService.calcularReajuste(funcionario, Desempenho.A_DESEJAR);

		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	void reajuste3PorcentoQuandoResultoForBom(){
		reajusteService.calcularReajuste(funcionario, Desempenho.BOM);

		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	void reajuste3PorcentoQuandoResultoForOtimo(){
		reajusteService.calcularReajuste(funcionario, Desempenho.OTIMO);

		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
}
