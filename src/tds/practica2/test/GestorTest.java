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
import tds.practica2.Gestor;
import tds.practica2.Pedido;
import tds.practica2.Producto;

class GestorTest {

	private ArrayList<Producto> listaProductos;
	private ArrayList<Integer> cantidadProductos;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	

	static Gestor gest;
	static ArrayList pedidos=new ArrayList();
	static Pedido prueba;
	static Pedido prueba1;
	static Pedido prueba2;
	static Pedido prueba3;
	static Pedido prueba4;
	static Pedido prueba5;
	static Pedido prueba6;
	static Pedido prueba7;
	
	
	@BeforeEach
	void SetUp(){
		
		listaProductos = new ArrayList<Producto>();
		cantidadProductos = new ArrayList<Integer>();
		
		
		prueba = new Pedido("identificador",listaProductos,cantidadProductos,LocalDate.of(2021, 11, 16),EstadoPedido.Recibido,"calle falsa 123");
		prueba1 = new Pedido("identificador1",listaProductos,cantidadProductos,LocalDate.of(2021, 11, 15),EstadoPedido.Recibido,"calle falsa 123");
		prueba2 = new Pedido("identificador2",listaProductos,cantidadProductos,LocalDate.of(2021, 11, 14),EstadoPedido.Recibido,"calle falsa 123");
		prueba3 = new Pedido("identificador3",listaProductos,cantidadProductos,LocalDate.of(2021, 11, 12),EstadoPedido.Cancelado,"calle falsa 123");
		prueba4 = new Pedido("identificador4",listaProductos,cantidadProductos,LocalDate.of(2021, 11, 11),EstadoPedido.Entregado,"calle falsa 123");
		prueba5 = new Pedido("identificador5",listaProductos,cantidadProductos,LocalDate.of(2021, 11, 11),EstadoPedido.Recibido,"calle falsa 123");
		prueba6 = new Pedido("identificador6",listaProductos,cantidadProductos,LocalDate.of(2021, 11, 11),EstadoPedido.Recibido,"calle falsa 123");
		prueba7 = new Pedido("identificador7",listaProductos,cantidadProductos,LocalDate.of(2021, 11, 17),EstadoPedido.Cancelado,"calle falsa 123");
		
		
		pedidos.add(prueba);
		pedidos.add(prueba1);
		gest=new Gestor(pedidos);
}

	
	//TEST CONSTRUCTOR VALIDO
	
	@Test
	void TestConstructor(){
		Pedido prueba = new Pedido("identificador",listaProductos,cantidadProductos,LocalDate.of(2021, 11, 11),EstadoPedido.Recibido,"calle falsa 123");
		pedidos.add(prueba);
		gest=new Gestor(pedidos);
		fail("test para el constructor");
		assertThat(pedidos, containsInAnyOrder(gest.getPedidos()));	
}
	//FIN TEST CONSTRUCTOR VALIDO
	
	
	
	//TEST PEDIDOS
	
	
	@Tag("TDD")
	@Test
	void TestConstructorSinPedidos(){
		ArrayList pedidos=new ArrayList<Pedido>();
		assertThrows(IllegalArgumentException.class, () -> {
			new Gestor(pedidos);
		});	
}
	

	@Test
	void TestConstructorPedidosNulos(){
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Gestor(null);
		});	
}
	
	//FIN TEST PEDIDOS
	
	
	//TEST GET
	
	@Test
	void TestGetPedidosCorrecto(){
		fail("test para obtener pedidos");
		assertThat(pedidos, containsInAnyOrder(gest.getPedidos()));	
}
	//FIN TEST GET
	
	
	
	//TEST AÑADIR PEDIDO
	
	@Tag("TDD")
	@Test
	void TestAñadirPedidoYaExistente(){
		
		assertThrows(IllegalArgumentException.class, () -> {
			gest.anadirPedido(prueba);
		});
		

}
	
	
	@Test
	void TestAñadirPedidoCorrecto(){

		
		Pedido prueba8 = new Pedido("identificador8",listaProductos,cantidadProductos,LocalDate.of(2021, 11, 11),EstadoPedido.Recibido,"calle falsa 123");
		ArrayList obtenido=new ArrayList();
		
		pedidos.add(prueba8);
		gest.anadirPedido(prueba8);
		fail("test para añadir pedido correcto");
		assertThat(pedidos, containsInAnyOrder(gest.getPedidos()));// nos lanza null pointer exception porque nos devuelve null la funcion


}
	
	
	@Test
	void TestAñadirPedidoNulo(){

		
		assertThrows(IllegalArgumentException.class, () -> {
			gest.anadirPedido(null);
		});
		

}
	


	
	//FIN TEST AÑADIR PEDIDO
	
	//TEST ELIMINAR PRODUCTO

	@Tag("TDD")
	@Test
	void TestEliminarPedidoNoExistenteEnGestor(){

		Pedido prueba9 = new Pedido("identificador9",listaProductos,cantidadProductos,LocalDate.of(2021, 11, 11),EstadoPedido.Recibido,"calle falsa 123");
		
		assertThrows(IllegalArgumentException.class, () -> {
			gest.eliminarPedido(prueba9);
		});

}
	
	
	
	@Test
	void TestEliminarPedidoCorrecto(){

		pedidos.remove(prueba);
		gest.eliminarPedido(prueba);
		fail("test para eliminar pedido");
		assertThat(pedidos, containsInAnyOrder(gest.getPedidos()));

}
	
	
	
	@Test
	void TestEliminarPedidoNulo(){

		assertThrows(IllegalArgumentException.class, () -> {
			gest.eliminarPedido(null);
		});

}
	
	
	
	
	
	//FIN TEST ELIMINAR PRODUCTO
	
	//TEST NUMERO PEDIDOS
	
	
	@Test
	void TestNumeroPedidos(){

		assertEquals(8,gest.numeroPedidos());
}
	
	//FIN TEST NUMERO PEDIDOS
	
	//TEST ORDENADO

	
	@Test
	void TestObtenerOrdenado(){
		ArrayList ordenado=new ArrayList();
		ordenado=gest.obtenerOrdenado();
		fail("test para ordenado");//nos devuelve null la funcion, si hacemos get de eso nos lanza null pointer exception
		assertEquals(prueba4,ordenado.get(0));
		assertEquals(prueba5,ordenado.get(1));
		assertEquals(prueba6,ordenado.get(2));
		assertEquals(prueba3,ordenado.get(3));
		assertEquals(prueba2,ordenado.get(4));
		assertEquals(prueba1,ordenado.get(5));
		assertEquals(prueba,ordenado.get(6));
		assertEquals(prueba7,ordenado.get(7));

}
	
	//FIN TEST ORDENADO
	
	
	//TEST GESTOR FECHA
	
	@Tag("TDD")
	@Test
	void TestObtenerGestorFechaNula(){
		assertThrows(IllegalArgumentException.class, () -> {
			Gestor gestFecha=gest.obtenerGestorFecha(null);
		});
		
		
}
	
	
	@Test
	void TestObtenerGestorFecha(){
		
		LocalDate fecha=LocalDate.of(2021, 11, 11);
		Gestor gestFecha=gest.obtenerGestorFecha(fecha);
		ArrayList pedidosFecha=new ArrayList();
		pedidosFecha.add(prueba4);
		pedidosFecha.add(prueba5);
		pedidosFecha.add(prueba6);
		fail("test para obtener gestor en una fecha");
		assertThat(pedidosFecha,containsInAnyOrder(gestFecha.getPedidos()));

}
	
	
	//FIN TEST GESTOR FECHA

	//TEST GESTOR INTERVALO
	

	@Tag("TDD")
	@Test
	void TestObtenerGestorIntervaloIncorrecto(){
		
		LocalDate inicio=LocalDate.of(2021,11,21);
		LocalDate fin=LocalDate.of(2021,11,20);
		
		assertThrows(IllegalArgumentException.class, () -> {
			gest.obtenerGestorIntervalo(inicio,fin);
		});

}
	
	@Test
	void TestObtenerGestorIntervalo(){
		
		LocalDate inicio=LocalDate.of(2021,11,13);
		LocalDate fin=LocalDate.of(2021,11,20);
		Gestor gestFecha=gest.obtenerGestorIntervalo(inicio,fin);
		ArrayList pedidosFecha=new ArrayList();
		pedidosFecha.add(prueba2);
		pedidosFecha.add(prueba1);
		pedidosFecha.add(prueba);
		pedidosFecha.add(prueba7);
		fail("test para obtener gestor con un estado en un intervalo");
		assertThat(pedidosFecha,containsInAnyOrder(gestFecha.getPedidos()));

}
	
	
	//FIN TEST GESTOR INTERVALO
	
	//TEST GESTOR ESTADO

	
	@Tag("TDD")
	@Test
	void TestObtenerGestorEstadoNulo(){
		
		assertThrows(IllegalArgumentException.class, () -> {
			 Gestor gestFecha=gest.obtenerGestorEstado(null);
		});
		

}
	
	@Test
	void TestObtenerGestorEstado(){
		
		
		Gestor gestFecha=gest.obtenerGestorEstado(EstadoPedido.Recibido);//hacer enum para este estado como pracitca anterior
		ArrayList pedidosFecha=new ArrayList();
		pedidosFecha.add(prueba5);
		pedidosFecha.add(prueba2);
		pedidosFecha.add(prueba1);
		pedidosFecha.add(prueba);
		pedidosFecha.add(prueba6);
		fail("test para obtener gestor con un estado ");
		assertThat(pedidosFecha,containsInAnyOrder(gestFecha.getPedidos()));

}
	
	//FIN TEST GESTOR ESTADO
	
	
	
	//TEST GESTOR ESTADO FECHA
	
	
	@Tag("TDD")
	@Test
	void TestObtenerGestorEstadoFechaNula(){
		assertThrows(IllegalArgumentException.class, () -> {
			 Gestor gestFecha=gest.obtenerGestorEstadoFecha(EstadoPedido.Recibido,null);
		});
				

}
	
	@Test
	void TestObtenerGestorEstadoFecha(){
		
		LocalDate fecha=LocalDate.of(2021,11,11);
		Gestor gestFecha=gest.obtenerGestorEstadoFecha(EstadoPedido.Recibido,fecha);
		ArrayList pedidosFecha=new ArrayList();
		pedidosFecha.add(prueba5);
		pedidosFecha.add(prueba6);
		fail("test para obtener gestor con un estado en una fecha");
		assertThat(pedidosFecha,containsInAnyOrder(gestFecha.getPedidos()));

}
	
	
	
	
	@Test
	void TestObtenerGestorEstadoNuloFecha(){
		LocalDate fecha=LocalDate.of(2021,11,11);
		
		assertThrows(IllegalArgumentException.class, () -> {
			 Gestor gestFecha=gest.obtenerGestorEstadoFecha(null,fecha);
		});
		

}

	
	//FIN TEST GESTOR ESTADO FECHA
	
	//TEST GESTOR ESTADO INTERVALO
	
	@Tag("TDD")
	@Test
	void TestObtenerGestorEstadoIntervaloIncorrecto(){
		
		LocalDate inicio=LocalDate.of(2021,11,21);
		LocalDate fin=LocalDate.of(2021,11,20);
		
		assertThrows(IllegalArgumentException.class, () -> {
			gest.obtenerGestorEstadoIntervalo(EstadoPedido.Recibido,inicio,fin);
		});

}
	
	
	@Test
	void TestObtenerGestorEstadoIntervalo(){
		
		LocalDate inicio=LocalDate.of(2021,11,13);
		LocalDate fin=LocalDate.of(2021,11,20);
		Gestor gestFecha=gest.obtenerGestorEstadoIntervalo(EstadoPedido.Recibido,inicio,fin);
		ArrayList pedidosFecha=new ArrayList();
		pedidosFecha.add(prueba2);
		pedidosFecha.add(prueba1);
		pedidosFecha.add(prueba);
		fail("test para obtener gestor con un estado en un intervalo");
		assertThat(pedidosFecha,containsInAnyOrder(gestFecha.getPedidos()));

}
	
	

	

	
	
	@Test
	void TestObtenerGestorEstadoNuloIntervalo(){
		LocalDate inicio=LocalDate.of(2021,11,21);
		LocalDate fin=LocalDate.of(2021,11,20);
		
		assertThrows(IllegalArgumentException.class, () -> {
			 Gestor gestFecha=gest.obtenerGestorEstadoIntervalo(null,inicio,fin);
		});
		

}
	
	//FIN TEST GESTOR ESTADO INTERVALO
	
	
	//TEST MAS RECIENTE Y MAS ANTIGUO
	
	
	@Test
	void TestMasReciente() {
		LocalDate fecha =gest.pedidosMasReciente();
		
		assertEquals(LocalDate.of(2021, 11, 17),fecha);
	}
	
	
	
	@Test
	void TestMasAntiguo() {
		LocalDate fecha=gest.pedidosMasAntiguo();
		assertEquals(LocalDate.of(2021, 11, 11),fecha);
	}
	
	//FIN TEST MAS RECIENTE Y MAS ANTIGUO
	
	
	@AfterEach
	void tearDown() throws Exception {
		gest=null;
		assertNull(gest);
		//despues de cada test
	}


}
