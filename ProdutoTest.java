package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Produto;

class ProdutoTest {

	@Test
	public void testeDeProduto() {
		Produto tester = new Produto("Rogerio", 10, 1000, 100);
		assertEquals("Rogerio", tester.getNome());
		assertEquals(10, tester.getCodigo());
		assertEquals(1000, tester.getQuantidade());
		assertEquals(100, tester.getQuantidadeMinima());
	}    

}
