package tds.practica2;

import java.time.LocalDate;
import java.util.ArrayList;


/**
 * Clase que representa la instancia de un pedido. Un pedido consiste en una colección de productos solicitados
 * por un cliente, los cuales son pagados y enviados a este.
 *
 * Un pedido puede contener multiples copias del mismo producto, y puede encontrarse en distintos estados. Para
 * una lista de todos los estados por los que puede transaccionar un pedido, consultar @see tds.practica2.EstadoPedido
 *
 * Por lo general, un pedido pasa por el siguiente flujo de estados:
 * Recibido -> Pagado -> Enviado -> Entregado
 * @author josloza
 * @author garicat
 * @author carlgom
 */
public class Pedido {

	private String identificador;
	private ArrayList<Producto> listaProductos;//NO NECESITA SET PORQUE AGREGAR Y ELIMINAR SERIA CON ADD Y REMOVE
	private ArrayList<Integer> cantidadProductos;
	private LocalDate fechaCreacion;
	private LocalDate fechaModificacion;//NECESITA SET PORQUE CUANDO SE ENVIAR PEDIDO, SE PAGA... SE CAMBIA
	private EstadoPedido estado;//NECEISTA SET PORQUE SE CAMBIA EL ESTADO CON PAGAR PEDIDO, ENVIAR PEDIDO...
	private String direccionEnvio;//NECESITA SET POR ENVIAR PEDIDO
	
	
	/**
	 * Inicializa un nuevo pedido.
	 *
	 * @param identificador Identificador único del pedido.
	 * @param listaProductos Lista de productos, sin duplicados, contenidos en el pedido
	 * @param cantidadProductos Cantidad de productos de cada tipo contenidos en el pedido
	 * @param fechaCreacion Fecha de creación del pedido
	 * @param estado Estado inicial del pedido
	 * @param direccionEnvio Dirección física donde el pedido ha de ser entregado
	 * @throws IllegalArgumentException Identificador introducido es null
	 * @throws IllegalArgumentException Identificador introducido no tiene entre 1 y 12 caracteres
	 * @throws IllegalArgumentException La lista de productos introducida contiene productos con identificadores no unicos
	 * @throws IllegalArgumentException Direccion introducida es null
	 * @throws IllegalArgumentException Direccion introducida esta vacia
	 * @throws IllegalArgumentException Lista de productos introducida es null
	 * @throws IllegalArgumentException Lista de productos esta vacia
	 * @throws IllegalArgumentException Estado introducido no es Recibido
	 * @throws IllegalArgumentException Estado introducido es null
	 * @throws IllegalArgumentException Cantidad de productos introducida es null
	 * @throws IllegalArgumentException Fecha de creacion introducida es null
	 */
	public Pedido(String identificador,ArrayList<Producto> listaProductos,
			ArrayList<Integer> cantidadProductos,LocalDate fechaCreacion,
			EstadoPedido estado,String direccionEnvio) {
		
	}
	
	
	
	/**
	 * 
	 * 
	 * establece una fecha de modificacion a ese pedido
	 * @param fechaNueva fecha en la que queremos poner que ha sido modificado
	 * @throws IllegalArgumentException Fecha introducida es null
	 */
	public void setFechaModificacion(LocalDate fechaNueva) {
		
	}
	
	/**
	 * 
	 * establece un nuevo estado al pedido
	 * @param nuevo nuevo estado que queremos poner al pedido
	 * @throws IllegalArgumentException Estado introducido es null
	 */
	public void setEstado(EstadoPedido nuevo) {
		
	}
	
	
	/**
	 * 
	 * 
	 * establece la direccion a la que se enviara el pedido
	 * @param direccion direccion a la que se enviara el pedido
	 * @throws IllegalArgumentException Direccion introducida es null
	 * @throws IllegalArgumentException Direccion introducida esta vacia
	 */
	public void setDireccionEnvio(String direccion) {
		
	}
	
	
	//GETS
	
	
	/**
	 * Recupera el identificador único del pedido.
	 *
	 * @return Identificador único del pedido
	 */
	public String getIdentificador() {
		return null;
	}
	
	
	/**
	 * Recupera la lista de productos, sin duplicados, del pedido.
	 *
	 * @return Lista de productos, sin duplicados, del envío
	 */
	public ArrayList<Producto> getListaProductos(){
		return null;
	}
	
	
	/**
	 * Recupera la cantidad de cada producto del pedido.
	 *
	 * @return Lista de cantidades de productos del pedido.
	 */
	public ArrayList<Integer> getCantidadProductos(){
		return null;
	}
	
	
	/**
	 * Recupera la dirección donde ha de ser entregado el pedido.
	 *
	 * @return Dirección física donde el pedido ha de ser enviado
	 */
	public String getDireccionEnvio() {
		return null;
	}
	
	
	/**
	 * Recupera la fecha de creación del pedido
	 *
	 * @return Fecha de creación del pedido
	 */
	public LocalDate getFechaCreacion() {
		return null;
	}
	
	
	/**
	 * Recupera la fecha de modificación más reciente del pedido.
	 *
	 *
	 * @return fecha de modificación más reciente del pedido.
	 */
	public LocalDate getFechaModificacion() {
		return null;
	}
	
	
	/**
	 * Recupera el estado en el que se encuentra el pedido.
	 *
	 * Para una descripción de todos los estados, @see tds.practica2.EstadoPedido
	 *
	 * @return Estado en el que se encuentra el pedido
	 */
	public EstadoPedido getEstado() {
		return null;
	}
	
	
	//FIN GETS
	
	
	
	
	
	
	
	/**
	 * Marca un pedido como pagado.
	 *
	 * Intentar marcar un pedido que ya ha sido pagado previamente como pagado resulta en una excepción.
	 *
	 * @param fecha Fecha de pago del pedido
	 * @throws IllegalArgumentException Fecha introducida es anterior a la fecha de creacion
	 * @throws IllegalArgumentException Fecha introducida es null
	 * @throws IllegalStateException El pedido no esta en estado Recibido
	 */
	public void pagarPedido(LocalDate fecha) {
		
	}
	
	
	/**
	 * Marca un pedido como enviado.
	 *
	 * Intentar marcar un pedido que ya ha sido enviado previamente como enviado, o enviar un pedido que
	 * no ha sido pagado, resulta en una excepción.
	 *
	 * @param fecha Fecha de envio del pedido
	 * @throws IllegalArgumentException Fecha introducida es anterior a la fecha de creacion
	 * @throws IllegalArgumentException Fecha introducida es null
	 * @throws IllegalArgumentException Direccion introducida es null
	 * @throws IllegalArgumentException Fecha introducida esta vacia
	 * @throws IllegalStateException El pedido no esta en estado Pagado
	 */
	public void enviarPedido(String direccion,LocalDate fecha) {
		
	}
	
	
	/**
	 * Marca un pedido como entregado.
	 *
	 * Intentar marcar un pedido que ya ha sido entregado previamente como entregado, o entregar un pedido que
	 * no ha sido enviado, resulta en una excepción.
	 *
	 * @param fecha Fecha de la entrega del pedido
	 * @throws IllegalArgumentException Fecha introducida es anterior a la fecha de creacion
	 * @throws IllegalArgumentException Fecha introducida es null
	 * @throws IllegalStateException El pedido no esta en estado Enviado
	 */
	public void entregarPedido(LocalDate fecha) {
		
	}
	
	
	/**
	 * Marca un pedido como cancelado.
	 *
	 * Intentar marcar un pedido que ya ha sido cancelado previamente como pagado resulta en una excepción.
	 *
	 * @param fecha Fecha de cancelacion del pedido
	 * @throws IllegalArgumentException Fecha introducida es anterior a la fecha de creacion
	 * @throws IllegalArgumentException Fecha introducida es null
	 * @throws IllegalStateException El pedido no esta en estado Recibido
	 */
	public void cancelarPedido(LocalDate fecha) {
		
	}
	
	
	/**
	 * 
	 * Compara si dos pedidos segun su fecha de creacion
	 * 
	 * @param otroPedido pedido con el que comparar
	 * @return anterior si el pedido con el que llamo la funcion es anterior al pedido del argumento,igual si tienen la misma fecha, posterior en otro caso
	 * @throws IllegalArgumentException Pedido introducido es null
	 */
	public String compararPedido(Pedido otroPedido) {
		return null;
	}
	
	
	/**
	 * Agrega un nuevo producto al pedido.
	 *
	 * @param producto Producto a añadir en el pedido
	 * @throws IllegalArgumentException El identificador del producto introducido no es unico
	 * @throws IllegalArgumentException El producto introducido es null
	 * @throws IllegalStateException El pedido no esta en estado Recibido
	 */
	public void agregarProducto(Producto producto) {
		
	}
	
	
	/**
	 * Elimina un producto del pedido.
	 *
	 * @param producto Producto a eliminar del pedido
	 * @throws IllegalArgumentException El producto introducido no esta en la lista de productos
	 * @throws IllegalArgumentException El producto introducido es null
	 * @throws IllegalStateException El pedido no esta en estado Recibido
	 */
	public void eliminarProducto(Producto producto) {
		
	}
	
	
	/**
	 * compara un pedido con otro objeto
	 * 
	 * @param o objeto para comparar
	 * @return true si son iguales los pedidos porque coinciden los identificadores, false en caso contrario
	 * @throws IllegalArgumentException El objeto introducido es null
	 * @throws IllegalArgumentException El objeto introducido no es un pedido
	 */
	@Override
	public boolean equals(Object o) {
		return true;
	}
}
