package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

  BonusService bonusService;

  @BeforeEach
  private void initialize(){
    this.bonusService = new BonusService();
  }

  @Test
  void bonusDeveSerZeroQuandoOSalarioEhMuitoAlto() {
    Funcionario funcionario =
        new Funcionario(
            "João Vitor", LocalDate.of(2021, Month.SEPTEMBER, 13), new BigDecimal("10500"));
//    assertThrows(IllegalArgumentException.class,() -> new BonusService().calcularBonus(funcionario));

    try{
      bonusService.calcularBonus(funcionario);
      fail("Não lançou a exception");
    }catch (Exception e){
      assertEquals("Funcionário não está elegível para receber o bonus",e.getMessage());
    }

  }

  @Test
  void bonusDeveSerDezPorcentoQuandoOSalarioForMenorQueOMaximo() {
    Funcionario funcionario =
            new Funcionario(
                    "João Vitor", LocalDate.of(2021, Month.SEPTEMBER, 13), new BigDecimal("7500"));
    var bonus = bonusService.calcularBonus(funcionario);
    assertEquals(new BigDecimal("750.00"), bonus);
  }

  @Test
  void bonusDeveSerDezPorcentoQuandoOSalarioForIgualAoMaximo() {
    Funcionario funcionario =
            new Funcionario(
                    "João Vitor", LocalDate.of(2021, Month.SEPTEMBER, 13), new BigDecimal("10000"));
    var bonus = bonusService.calcularBonus(funcionario);
    assertEquals(new BigDecimal("1000.00"), bonus);
  }
}
