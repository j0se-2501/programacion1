package Calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest2 {
	
	Calculadora cal;
	
	@BeforeEach
	public void inicializaCalculadora() {
		cal = new Calculadora();
	}

	@Test
	void testSuma() {
		cal.suma(10);
		cal.suma(10);
		assertEquals(20, cal.getPantalla());
	}
	
	@Test
	void testSumaMultiple() {
		cal.suma(10);
		cal.suma(10);
		cal.suma(10);
		cal.suma(10);
		cal.suma(10);
		assertEquals(50, cal.getPantalla());
	}

	@Test
	void testResta() {
		cal.suma(10);
		cal.resta(10);
		assertEquals(0, cal.getPantalla());
	}

	@Test
	void testMultiplica() {
		cal.suma(10);
		cal.multiplica(10);
		assertEquals(100, cal.getPantalla());
	}
	
	@Test
	void testMultiplicaNegativo() {
		cal.suma(10);
		cal.multiplica(-10);
		assertEquals(-100, cal.getPantalla());
	}

	@Test
	void testDivide() {
		cal.suma(10);
		cal.divide(10);
		assertEquals(1, cal.getPantalla());
	}
	
	@Test
	void testDivideEntre0() { //da 10 porque al ser el dividendo 0 no entra en la divisi�n y pantalla permanece en 10
		cal.suma(10);
		cal.divide(0);
		assertEquals(10, cal.getPantalla());
	}

	@Test
	void testPorcentaje() {
		cal.suma(20);
		cal.porcentaje(25);
		assertEquals(5, cal.getPantalla());
	}
	
	@Test
	void testPorcentajeNegativo() {
		cal.suma(-20);
		cal.porcentaje(25);
		assertEquals(-5, cal.getPantalla());
	}

	@Test
	void testResetea() {
		cal.suma(20);
		cal.resetea();
		assertEquals(0, cal.getPantalla());
	}
	
	@Test
	void testSumarRestarDividirMultiplicar() { //pruebo los cuatro operandos simultaneamente
		cal.suma(20);
		cal.resta(10);
		cal.multiplica(10);
		cal.divide(2);
		assertEquals(50, cal.getPantalla());
	}
	

}
