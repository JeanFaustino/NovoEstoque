package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Controller.Estoquefacade;

import org.junit.Assert.*;
import org.junit.Before;



class EstoqueFacadeTest {
	private Estoquefacade estoquefacade;
		
	@Before
	public void setUp() {
		estoquefacade = Estoquefacade.getInstance();
	}
	
	
	@Test
	void testeEstoqueFacade() {
		Estoquefacade tester = new Estoquefacade();
		
	}

}
