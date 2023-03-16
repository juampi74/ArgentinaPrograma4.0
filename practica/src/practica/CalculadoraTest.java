package practica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@DisplayName("Validar el funcionamiento de la calculadora")
	@Test
	void test() {

		Calculadora calculadora = new Calculadora();
		
		Assertions.assertEquals(calculadora.multiplicar(80, 3), 240);
		Assertions.assertEquals(calculadora.dividir(calculadora.sumar(150, 180), 3), 110);
		Assertions.assertTrue(calculadora.multiplicar(calculadora.restar(90, 50), 15) != 605);
		Assertions.assertTrue(calculadora.multiplicar(calculadora.sumar(70, 40), 25) != 2700);
		
	}

}
