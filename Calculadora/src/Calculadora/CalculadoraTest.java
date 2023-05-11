/** https://es.parasoft.com/blog/junit-tutorial-setting-up-writing-and-running-java-unit-tests/  */

package Calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {
	
	Calculadora cal;
	
	@BeforeEach
	public void inicializaCalculadora() {
		cal = new Calculadora();
	}

	@Test
	public void sumaDoble() {
		cal.suma(10);
		cal.suma(15);
		assertEquals(25, cal.getPantalla());
	}
	
	@Test
	public void sumaNegativo( ) {
		cal.suma(10);
		cal.suma(-10);
		assertEquals(0, cal.getPantalla());
	}

}
