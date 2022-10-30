package tds.practica2.test;

import tds.practica2.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;



class PedidoTest {

	private ArrayList<Producto> listaProductos;
	private ArrayList<Integer> cantidadProductos;
	private LocalDate fechaCreacion;
	private Pedido prueba;
	private Producto producto;
	private LocalDate fechaModificacion;
	private int[] otrasDimensiones;
	private ArrayList<Integer> cantidadEsperada;
	private ArrayList<Producto> otraListaProductos;
	private LocalDate otraFechaModificacion;
	
	@BeforeEach
	void setUp() throws Exception {
		int[] dimensiones = {1,2,3};
		otrasDimensiones = new int[] {2,3,4};
		producto = new Producto("id","producto de prueba",dimensiones);
		listaProductos = new ArrayList<Producto>();
		listaProductos.add(producto);
		cantidadProductos = new ArrayList<Integer>();
		cantidadProductos.add(2);
		otraFechaModificacion = LocalDate.parse("2021-11-23");
		fechaCreacion = LocalDate.parse("2021-11-24");
		fechaModificacion = LocalDate.parse("2021-11-25");
		prueba = new Pedido("identificador",listaProductos,cantidadProductos
				,fechaCreacion,EstadoPedido.Recibido,"calle falsa 123");
		cantidadEsperada = new ArrayList<Integer>();
		otraListaProductos = new ArrayList<Producto>();
	}
	
	
	
	//TEST VALIDOS CON EL CONSTRUCTOR
	
	
	@Tag("TDD")
	@Test
	void testPedidoLimiteInferior() {
		
		Pedido prueba = new Pedido("i",listaProductos,cantidadProductos
				,fechaCreacion,EstadoPedido.Recibido,"calle falsa 123");
		assertEquals(prueba.getIdentificador(),"i");
		assertEquals(prueba.getListaProductos(),listaProductos);
		assertEquals(prueba.getCantidadProductos(),cantidadProductos);
		assertEquals(prueba.getFechaCreacion(),fechaCreacion);
		assertEquals(prueba.getFechaModificacion(),fechaCreacion);
		assertEquals(prueba.getEstado(),EstadoPedido.Recibido);
		assertEquals(prueba.getDireccionEnvio(),"calle falsa 123");
	}
	
	@Test
	void testPedidoLimiteSuperior() {
		
		Pedido prueba = new Pedido("123456789012",listaProductos,cantidadProductos
				,fechaCreacion,EstadoPedido.Recibido,"calle falsa 123");
		assertEquals(prueba.getIdentificador(),"123456789012");
		assertEquals(prueba.getListaProductos(),listaProductos);
		assertEquals(prueba.getCantidadProductos(),cantidadProductos);
		assertEquals(prueba.getFechaCreacion(),fechaCreacion);
		assertEquals(prueba.getFechaModificacion(),fechaCreacion);
		assertEquals(prueba.getEstado(),EstadoPedido.Recibido);
		assertEquals(prueba.getDireccionEnvio(),"calle falsa 123");
	}
	
	//FIN TEST VALIDOS CON CONSTRUCTOR
	
	
	
	
	//TEST CON IDENTIFICADOR
	
	@Tag("TDD")
	@Test
	void testPedidoIdentificadorMenosDeUnCaracter() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido("",listaProductos,cantidadProductos
					,fechaCreacion,EstadoPedido.Recibido,"calle falsa 123");
		});
	}
	
		
	
	@Test
	void testPedidoConProductosConIdentificadorNoUnico() {
		Producto otroProducto = new Producto("id","otro producto de prueba",otrasDimensiones);
		
		listaProductos.add(otroProducto);
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido("identificador",listaProductos,cantidadProductos
					,fechaCreacion,EstadoPedido.Recibido,"calle falsa 123");
		});
	}
	

	@Test
	void testPedidoIdentificadorNulo() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido(null,listaProductos,cantidadProductos
					,fechaCreacion,EstadoPedido.Recibido,"calle falsa 123");
		});
	}

	
	
	@Test
	void testPedidoIdentificadorMasDeDoceCaracteres() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido("codigoconmasd",listaProductos,cantidadProductos
					,fechaCreacion,EstadoPedido.Recibido,"calle falsa 123");
		});
	}
	
	//FIN TEST CON IDENTIFICADOR
	

	
	
	
	
	
	//TEST CON DIRECCION
	
	
	@Tag("TDD")
	@Test
	void testPedidoDireccionNula() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido("identificador",listaProductos,cantidadProductos
					,fechaCreacion,EstadoPedido.Recibido,null);
		});
	}
	
	@Test
	void testPedidoDireccionVacia() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido("codigoconma",listaProductos,cantidadProductos
					,fechaCreacion,EstadoPedido.Recibido,"");
		});
	}
	
	
	
	//FIN TEST CON DIRECCION
	
	
	
	//TEST LISTA PRODUCTOS
	
	@Tag("TDD")
	@Test
	void testPedidoListaProductosNula() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido("identificador",null,cantidadProductos
					,fechaCreacion,EstadoPedido.Recibido,"calle falsa 123");
		});
	}
	
	
	
	@Test
	void testPedidoSinProducto() {
		ArrayList<Producto> listaSinProducto = new ArrayList<Producto>();
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido("identificador",listaSinProducto,cantidadProductos
					,fechaCreacion,EstadoPedido.Recibido,"calle falsa 123");
		});
	}
	
	//FIN TEST LISTA PRODUCTOS
	

	
	//TEST CON ESTADO
	
	@Tag("TDD")
	@Test
	void testPedidoEstadoNoAceptado() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido("identificador",listaProductos,cantidadProductos
					,fechaCreacion,null,"calle falsa 123");
		});
	}
	
	
	@Test
	void testPedidoEstadoDeCreacionIncorrecto() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido("identificador",listaProductos,cantidadProductos
					,fechaCreacion,EstadoPedido.Pagado,"calle falsa 123");
		});
	}
	
	//FIN TEST CON ESTADO
	
	
	
	//TEST CON CANTIDAD PRODUCTOS
	
	@Tag("TDD")
	@Test
	void testPedidoCantidadProductosNula() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido("identificador",listaProductos,null
					,fechaCreacion,EstadoPedido.Recibido,"calle falsa 123");
		});
	}
	
	//FIN TEST CON CANTIDAD PRODUCTOS
	
	
	//TEST CON FECHA DE CREACION
	
	@Tag("TDD")
	@Test
	void testPedidoFechaCreacionNula() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido("identificador",listaProductos,cantidadProductos
					,null,EstadoPedido.Recibido,"calle falsa 123");
		});
	}
	
	
	//FIN TEST FECHA DE CREACION
	
	
	
	
	
	
	
	//INICIO TEST DE GET
	
	
	
	@Test
	void testGetIdentificador() {
		
		assertEquals(prueba.getIdentificador(),"identificador");
	}
	
	
	
	
	
	
	
	@Test
	void testGetListaProductos() {
		
		assertEquals(prueba.getListaProductos(),listaProductos);
	}
	
	
	
	
	
	
	
	
	@Test
	void testGetCantidadProductos() {
		cantidadEsperada.add(2);
		
		assertEquals(prueba.getCantidadProductos(),cantidadEsperada);
	}
	
	
	
	
	
	@Test
	void testGetDireccionEnvio() {
		
		assertEquals(prueba.getDireccionEnvio(),"calle falsa 123");
	}
	
	
	@Test
	void testGetFechaCreacion() {
		
		assertEquals(prueba.getFechaCreacion(),fechaCreacion);
	}
	
	
	@Test
	void testGetFechaModificacion() {
		
		assertEquals(prueba.getFechaModificacion(),fechaCreacion);
	}
	
	
	@Test
	void testGetEstado() {
		
		assertEquals(prueba.getEstado(),EstadoPedido.Recibido);
	}
	
	
	
	//FIN TEST DE GET
	
	
	
	
	
	
	
	
	
	//TEST PARA PAGAR PEDIDO
	
	@Tag("TDD")
	@Test
	void testPagarPedidoFechaModificacionAnteriorCreacion() {
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.enviarPedido("calle falsa 124",otraFechaModificacion);
		});
		
	}
	
	
	
	
	@Test
	void testPagarPedido() {
		
		prueba.pagarPedido(fechaModificacion);
		
		assertEquals(prueba.getEstado(),EstadoPedido.Pagado);
	}
	
	
	
	
	@Test
	void testPagarPedidoFechaModificacionNula() {
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.enviarPedido("calle falsa 124",null);
		});
		
	}
	
	@Test
	void testPagarPedidoNoRecibido() {
		
		prueba.cancelarPedido(fechaModificacion);
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.pagarPedido(fechaModificacion);
		});
		
	}
	
	//FIN TEST PARA PAGAR PEDIDO
	
	
	
	
	
	
	//TEST PARA ENVIAR PEDIDO
	
	@Tag("TDD")
	@Test
	void testEnviarPedidoFechaModificacionAnteriorCreacion() {
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.enviarPedido("calle falsa 124",otraFechaModificacion);
		});
		
	}
	
	
	
	@Test
	void testEnviarPedido() {
		
		prueba.pagarPedido(fechaModificacion);
		prueba.enviarPedido("calle falsa 124",fechaModificacion);
		
		assertEquals(prueba.getEstado(),EstadoPedido.Enviado);
	}
	
	
	
	@Test
	void testEnviarPedidoFechaModificacionNula() {
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.enviarPedido("calle falsa 124",null);
		});
		
	}
	
	
	@Test
	void testEnviarPedidoNoPagado() {
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.enviarPedido("calle falsa 124",fechaModificacion);
		});
	}
	
	//FIN TEST PARA ENVIAR PEDIDO
	
	
	//TEST PARA ENVIAR PEDIDO
	
	@Tag("TDD")
	@Test
	void testEnviarPedidoDireccionVacia() {
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.enviarPedido("",fechaModificacion);
		});
	}
	
	@Test
	void testEnviarPedidoDireccionNula() {
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.enviarPedido(null,fechaModificacion);
		});
	}
	
	
	//FIN TEST ENVIAR PEDIDO
	
	
	//TEST PARA ENTREGAR PEDIDO
	
	
	@Tag("TDD")
	@Test
	void testEntregarPedidoFechaModificacionNula() {
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.enviarPedido("calle falsa 124",null);
		});
		
	}
	
	
	@Test
	void testEntregarPedido() {
		
		prueba.pagarPedido(fechaModificacion);
		prueba.enviarPedido("calle falsa 124",fechaModificacion);
		prueba.entregarPedido(fechaModificacion);
		
		assertEquals(prueba.getEstado(),EstadoPedido.Entregado);
	}
	
	
	@Test
	void testEntregarPedidoFechaModificacionAnteriorCreacion() {
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.enviarPedido("calle falsa 124",otraFechaModificacion);
		});
		
	}
	
	
	
	
	@Test
	void testEntregarPedidoNoEnviado() {
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.entregarPedido(fechaModificacion);
		});
		
	}
	
	//FIN TEST ENTREGAR PEDIDO
	
	
	
	//TEST PARA CANCELAR PEDIDO
	
	
	@Tag("TDD")
	@Test
	void testCancelarPedidoFechaModificacionNula() {
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.enviarPedido("calle falsa 124",null);
		});
		
	}
	
	
	
	@Test
	void testCancelarPedido() {
		
		prueba.cancelarPedido(fechaModificacion);
		
		assertEquals(prueba.getEstado(),EstadoPedido.Cancelado);
	}
	
	
	@Test
	void testCancelarPedidoFechaModificacionAnteriorCreacion() {
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.enviarPedido("calle falsa 124",otraFechaModificacion);
		});
		
	}
	
	
	
	
	@Test
	void testCancelarPedidoNoRecibido() {
		
		prueba.pagarPedido(fechaModificacion);
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.cancelarPedido(fechaModificacion);
		});
		
	}
	
	//FIN TEST PARA CANCELAR PEDIDO
	
	
	//TEST PARA COMPARAR PEDIDO
	
	@Tag("TDD")
	@Test
	void testCompararConPedidoPosterior() {
		LocalDate otraFechaCreacion = LocalDate.parse("2021-11-25");
		Pedido otroPedido = new Pedido("identificador2",listaProductos,cantidadProductos
				,otraFechaCreacion,EstadoPedido.Recibido,"calle falsa 123");
		
		assertEquals(prueba.compararPedido(otroPedido),"anterior");
	}
	
	@Test
	void testCompararConPedidoMismaFecha() {
		LocalDate otraFechaCreacion = LocalDate.parse("2021-11-24");
		Pedido otroPedido = new Pedido("identificador2",listaProductos,cantidadProductos
				,otraFechaCreacion,EstadoPedido.Recibido,"calle falsa 123");
		
		assertEquals(prueba.compararPedido(otroPedido),"igual");
	}
	
	@Test
	void testCompararConPedidoAnterior() {
		LocalDate otraFechaCreacion = LocalDate.parse("2021-11-23");
		Pedido otroPedido = new Pedido("identificador2",listaProductos,cantidadProductos
				,otraFechaCreacion,EstadoPedido.Recibido,"calle falsa 123");
		
		assertEquals(prueba.compararPedido(otroPedido),"posterior");
	}
	
	
	
	
	@Test
	void testCompararConPedidoNulo() {
		
		
		assertThrows(IllegalArgumentException.class, () -> {
			prueba.compararPedido(null);
		});
	}
	
	//FIN TEST PARA COMPARAR PEDIDO
	
	
	//TEST PARA AGREGAR PRODUCTO
	
	@Tag("TDD")
	@Test
	void testAgregarProductoYaEnLista() {
		otraListaProductos.add(producto);
		cantidadEsperada.add(3);
		
		prueba.agregarProducto(producto);
		
		assertEquals(prueba.getListaProductos(),otraListaProductos);
		assertEquals(prueba.getCantidadProductos(),cantidadEsperada);
	}
	
	
	@Test
	void testAgregarProductoNuevo() {
		Producto otroProducto = new Producto("id2","otro producto de prueba",otrasDimensiones);
		otraListaProductos.add(otroProducto);
		
		prueba.agregarProducto(otroProducto);
		
		assertEquals(prueba.getListaProductos(),otraListaProductos);
	}
	
	
	
	
	@Test
	void testAgregarProductoIdentificadorNoUnico() {
		Producto otroProducto = new Producto("id","otro producto de prueba",otrasDimensiones);
		
		assertThrows(IllegalArgumentException.class, () -> {
			prueba.agregarProducto(otroProducto);
		});
	}
	
	
	@Test
	void testAgregarProductoNoRecibido() {
		
		prueba.pagarPedido(fechaModificacion);
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.agregarProducto(producto);
		});
	}
	
	
	@Test
	void testAgregarProductoNulo() {
		
		
		assertThrows(IllegalArgumentException.class, () -> {
			prueba.agregarProducto(null);
		});
	}
	
	//FIN TEST AGREGAR PRODUCTO
	
	//TEST PARA ELIMINAR PRODUCTO
	
	@Tag("TDD")
	@Test
	void testEliminarProductoNoEnLista() {
		
		Producto otroProducto = new Producto("id2","otro producto de prueba",otrasDimensiones);
		
		assertThrows(IllegalArgumentException.class, () -> {
			prueba.eliminarProducto(otroProducto);
		});
		
	}
	
	
	
	@Test
	void testEliminarProductoConMasDeUnaCantidad() {
		otraListaProductos.add(producto);
		cantidadEsperada.add(1);
		
		prueba.eliminarProducto(producto);
		
		assertEquals(prueba.getListaProductos(),otraListaProductos);
		assertEquals(prueba.getCantidadProductos(),cantidadEsperada);
	}
	
	
	@Test
	void testEliminarProductoHastaCantidadCero() {
		Producto otroProducto = new Producto("id2","otro producto de prueba",otrasDimensiones);
		otraListaProductos.add(otroProducto);
		
		prueba.agregarProducto(otroProducto);
		
		prueba.eliminarProducto(producto);
		prueba.eliminarProducto(producto);
		
		assertEquals(prueba.getListaProductos(),otraListaProductos);
	}
	
	
	@Test
	void testEliminarProductoNoRecibido() {
		
		prueba.pagarPedido(fechaModificacion);
		
		assertThrows(IllegalStateException.class, () -> {
			prueba.eliminarProducto(producto);
		});
	}
	
	
	
	
	@Test
	void testEliminarProductoNulo() {
		
		
		assertThrows(IllegalArgumentException.class, () -> {
			prueba.eliminarProducto(null);
		});
	}
	
	//FIN TEST ELIMINAR PRODUCTO
	
	//TEST SET
	
	@Test
	void testSetDireccion() {
			prueba.setDireccionEnvio("bodegas");
			assertEquals(prueba.getDireccionEnvio(),"bodegas");
		}
	
	@Test
	void setFechaModificacion() {
		prueba.setFechaModificacion(LocalDate.of(2021, 2, 10));
		assertEquals(prueba.getFechaModificacion(),LocalDate.of(2021, 2, 10));
	}
	
	@Test
	void setEstado() {
		prueba.setEstado(EstadoPedido.Pagado);
		assertEquals(prueba.getEstado(),EstadoPedido.Pagado);
	}
		
		
		
	//FIN TEST SET
	
	
	
	//TEST EQUALS
	
	@Tag("TDD")
	@Test
	void testEqualsPedidosIguales() {
		Pedido otroPedido = new Pedido("identificador",listaProductos,cantidadProductos
				,fechaCreacion,EstadoPedido.Recibido,"calle falsa 123");
		
		assertTrue(prueba.equals(otroPedido));
		fail("test para equals donde los dos pedidos son iguales");
	}
	
	@Test
	void testEqualsPedidosDistintos() {
		Pedido otroPedido = new Pedido("identificador2",otraListaProductos,cantidadProductos
				,fechaCreacion,EstadoPedido.Recibido,"calle falsa 123");
		
		assertFalse(prueba.equals(otroPedido));
		fail("test para equals donde los dos pedidos son distintos");
	}
	
	
	@Test
	void testEqualsPedidoNulo() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			prueba.equals(null);
		});
		fail("test para equals donde el pedido es nulo");
	}
	
	
	@Test
	void testEqualsNoPedido() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			prueba.equals(producto);
		});
		fail("test para equals donde no es un pedido");
	}
	
	//FIN TEST EQUALS
	
	@AfterEach
	void tearDown() throws Exception {
		listaProductos = null;
		cantidadProductos = null;
		fechaCreacion = null;
		prueba = null;
		producto = null;
		fechaModificacion = null;
		otrasDimensiones = null;
		cantidadEsperada = null;
		otraListaProductos = null;
		otraFechaModificacion = null;
		assertNull(listaProductos);
		assertNull(cantidadProductos);
		assertNull(fechaCreacion);
		assertNull(prueba);
		assertNull(producto);
		assertNull(fechaModificacion);
		assertNull(otrasDimensiones);
		assertNull(cantidadEsperada);
		assertNull(otraListaProductos);
		assertNull(otraFechaModificacion);
		//despues de cada test
	}

}
