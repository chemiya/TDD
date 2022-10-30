package tds.practica2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.hamcrest.Matchers;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import tds.practica2.EstadoPedido;
import tds.practica2.Pedido;
import tds.practica2.Producto;

class ProductoTest {

	
	static Producto product;
	static int[] dimensiones;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		dimensiones=new int[3];
		dimensiones[0]=58;
		dimensiones[1]=63;
		dimensiones[2]=65;
		product=new Producto("GSHB129","playstation 5 de 2 tb",dimensiones);
		
		//antes de cada test
	}
	
	//TEST CONSTRUCTOR VALIDOS
	
	@Test
	void testConstructorLimiteInferior() {
		int dimensiones[]= {1,1,1};
		Producto product=new Producto("G","p",dimensiones);
		assertEquals("G", product.getIdentificador());
		assertEquals("p", product.getDescripcion());
		assertArrayEquals(dimensiones, (product.getDimensiones()));
		

	}
	
	
	@Test
	void testConstructorLimiteSuperior() {
			int dimensiones[]= {1,1,1};
			Producto product=new Producto("asdsdsdfgf","texto",dimensiones);
			assertEquals("asdsdsdfgf", product.getIdentificador());
			assertEquals("texto", product.getDescripcion());
			assertArrayEquals(dimensiones, (product.getDimensiones()));
			

		}
	
	//FIN TEST CONSTRUCTOR VALIDOS
	
	//TEST PARA IDENTIFICADOR
	
	
	@Tag("TDD")
	@Test
	void testFalloIdentificadorMasDelLimiteSuperior() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Producto("asdsdsdfgfa","playstation 5 de 2 tb",dimensiones);
		});
	}
	
	

	@Test
	void testFalloIdentificadorVacio() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Producto("","playstation 5 de 2 tb",dimensiones);
		});
	}
	
	@Test
	void testFalloIdentificadorNulo() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Producto(null,"playstation 5 de 2 tb",dimensiones);
		});
	}
	
	//FIN TEST IDENTIFICADOR
	
	
	//TEST DESCRIPCION
	
	@Tag("TDD")
	@Test
	void testFalloDescripcionVacia() {
			
			assertThrows(IllegalArgumentException.class, () -> {
				new Producto("sssss","",dimensiones);
			});
		}
	
	
	@Test
	void testFalloDescripcionNula() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Producto("sssss",null,dimensiones);
		});
	}
	
	
	
	//FIN TEST DESCRIPCION
		
	//TEST DIMENSIONES
	
	@Tag("TDD")
	@Test
	void testFalloDimensionesNegativas() {
		int dimensiones[]= {-1,-1,-1};
		assertThrows(IllegalArgumentException.class, () -> {
			new Producto("sssss","www",dimensiones);
		});
	}
	
	@Test
	void testFalloDimensionesAncho() {
		int dimensiones[]= {0,1,1};
		assertThrows(IllegalArgumentException.class, () -> {
			new Producto("sssss","www",dimensiones);
		});
	}
	
	@Test
	void testFalloDimensionesLargo() {
		int dimensiones[]= {2,0,1};
		assertThrows(IllegalArgumentException.class, () -> {
			new Producto("sssss","www",dimensiones);
		});
	}
	
	@Test
	void testFalloDimensionesAlto() {
		int dimensiones[]= {2,1,0};
		assertThrows(IllegalArgumentException.class, () -> {
			new Producto("sssss","www",dimensiones);
		});
	}
	

	
	
	
	
	@Test
	void testFalloDimensionesNulas() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Producto("sssss","www",null);
		});
	}
	
	
	
	
	
	//FIN TEST DIMENSIONES
	
	//TEST GET
	
	@Test
	void testDimensionesCorrectas() {
		
		
		assertArrayEquals(dimensiones, (product.getDimensiones()));
	}
	
	@Test
	void testGetIdentificadorCorrecto() {
		
		assertEquals("GSHB129",product.getIdentificador());
	}
	
	@Test
	void testGetDescripcionCorrecto() {
	
		assertEquals("playstation 5 de 2 tb",product.getDescripcion());
	}
	
	//FIN TEST GET
	
	
	//TEST EQUALS
	
	
	@Tag("TDD")
	@Test
	void testEqualsDiferenteTipo() {
			
			ArrayList listaProductos = new ArrayList<Producto>();
			ArrayList cantidadProductos = new ArrayList<Integer>();
			product=new Producto("GSHB129","playstation 5 de 2 tb",dimensiones);
			Pedido prueba = new Pedido("identificador",listaProductos,cantidadProductos,LocalDate.of(2021, 11,11),EstadoPedido.Recibido,"calle falsa 123");
			assertTrue(product.equals(prueba));
			fail("test para equals donde son de diferente tipo");
		}
	
	@Test
	void testEqualsIguales() {
	
		
		assertTrue(product.equals(product));
		fail("test para equals");
	}
	
	
	
		
		
	@Test
	void testEqualsNulo() {
		
			
			
			assertTrue(product.equals(null));
			fail("test para equals donde uno es null");
		}
		
		
	@Test
	void testEqualsDiferentes() {
					
					
			Producto product2=new Producto("ssssdd","playstation 5 de 2 tb",dimensiones);
			assertTrue(product.equals(product2));
			fail("test para equals donde son diferentes");
				}
	
	//FIN TEST EQUALS

	@AfterEach
	void tearDown() throws Exception {
		product=null;
		assertNull(product);
		//despues de cada test
	}
	
	
	
	/*@AfterAll
	static void tearDownAfterClass() throws Exception {
		//una vez despues de todos
	}*/

	

	

	

}
