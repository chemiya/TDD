package tds.practica2;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 * 
 * 
 * clase en la que se agrupan pedidos. se puede eliminar un pedido o añadir un pedido a este gestor
 * se pueden obtener sus pedidos ordenados por su fecha y obtener su pedido mas reciente o mas antiguo
 * ademas se puede crear otro gestor a partir de el
 * @author josloza
 * @author garicat
 * @author carlgom


 *
 */
public class Gestor{
	private ArrayList pedidos;//NO NECESITA SETPEDIDOS PORQUE EN AÑADIR Y ELIMINAR PEDIDO SERA CON ADD Y REMOVE

	/**
	 * 
	 * constructor del gestor de pedidos
	 * @param pedidos ArrayList de pedidos iniciales en el gestor
	 * @throws IllegalArgumentException La lista de pedidos introducida esta vacia
	 * @throws IllegalArgumentException La lista de pedidos introducida es null
	 */
	public Gestor(ArrayList pedidos){
		
}
	
	/**
	 * Recupera el listado de pedidos existentes del gestor
	 *
	 * @return Lista de pedidos gestionados por el gestor
	 */
	public ArrayList getPedidos(){
		return null;
}
	
	/**
	 * Inserta un nuevo pedido para que sea gestionado por la instancia del gestor.
	 *
	 * El pedido se insertara al final de la cola de pedidos del gestor
	 *
	 * @param pedido Pedido a añadir al gestor
	 * @throws IllegalArgumentException El pedido introducido ya existe
	 * @throws IllegalArgumentException El pedido introducido es null
	 */
	public void anadirPedido(Pedido pedido){


}

	
	/**
	 * Elimina un pedido del control del gestor.
	 *
	 * El pedido eliminado sigue existiendo, pero ya no es gestionado por la instancia del gestor.
	 *
	 * @param pedido Pedido a eliminar del gestor
	 * @throws IllegalArgumentException El pedido introducido no esta en la lista de pedidos
	 * @throws IllegalArgumentException El pedido introducido es null
	 */
	public void eliminarPedido(Pedido pedido){

}

	
	/**
	 * Devuelve la cantidad de pedidos que estan siendo gestionados por el gestor.
	 *
	 * @return numero de pedidos que gestiona la instancia del gestor. Nunca es negativo.
	 */
	public int numeroPedidos(){
		return 0;
}	

	
	/**
	 * se obtiene la fecha del pedido mas reciente del gestor
	 * 
	 * @return la fecha del pedido mas reciente
	 */
	public LocalDate pedidosMasReciente(){
		return null;
}

	
	/**
	 * se obtiene la fecha del pedido mas antiguo del gestor
	 * 
	 * @return la fecha del pedido mas antiguo
	 */
	public LocalDate pedidosMasAntiguo(){
		return null;
}

	
	/**
	 * 
	 * ordena los pedidos del gestor de mas viejos a mas nuevos, 
	 * si son de misma fecha el que primero lea se pone antes
	 * @return el arraylist con los pedidos ordenados por fecha siendo el primer elemento el pedido mas antiguo
	 */
	public ArrayList obtenerOrdenado(){
		return null;

}

	/**
	 * se obtiene un gestor a partir del gestor inicial, 
	 * solo con los pedidos en una determinada fecha dentro gestor inicial
	 * 
	 * @param fecha fecha en la que queremos que se encuentren los pedidos del nuevo gestor
	 * @return nuevo gestor creado a partir del gestor inicial, con todos sus pedidos en una fecha
	 * @throws IllegalArgumentException La fecha introducida es null
	 */
	public Gestor obtenerGestorFecha(LocalDate fecha){
		return null;
}

	
	/**
	 * se obtiene un gestor a partir del gestor inicial, 
	 * solo con los pedidos en un determinado intervalo dentro gestor inicial
	 * 
	 * @param inicio fecha en la que empieza el intervalo
	 * @param fin fecha en la que acaba el intervalo
	 * @return nuevo gestor creado a partir del gestor inicial, con todos sus pedidos con su fecha dentro del intervalo
	 * @throws IllegalArgumentException El intervalo de fechas introducido es null
	 */
	public Gestor obtenerGestorIntervalo(LocalDate inicio, LocalDate fin){
		return null;
}
	
	/**
	 * 
	 * se obtiene un gestor a partir del gestor inicial, 
	 * solo con los pedidos en un determinado estado dentro gestor inicial
	 * 
	 * @param estado estado en el que queremos que esten los pedidos del nuevo gestor
	 * @return nuevo gestor creado a partir del gestor inicial, con todos sus pedidos en el estado solicitado
	 * @throws IllegalArgumentException El estado introducido es null
	 */
	public Gestor obtenerGestorEstado(EstadoPedido estado){
		return null;
}

	
	/**
	 * 
	 * se obtiene un gestor a partir del gestor inicial, 
	 * solo con los pedidos en un determinado estado y en una fecha dentro gestor inicial
	 * 
	 * @param estado estado en el que queremos que esten los pedidos del nuevo gestor
	 * @param fecha fecha en la que queremos que esten los pedidos
	 * @return nuevo gestor creado a partir del gestor inicial, con todos sus pedidos en el estado solicitado y en la fecha solicitada
	 * @throws IllegalArgumentException La fecha introducida es null
	 * @throws IllegalArgumentException El estado introducido es null
	 */
	public Gestor obtenerGestorEstadoFecha(EstadoPedido estado, LocalDate fecha){
		return null;
}

	
	/**
	 * 
	 * se obtiene un gestor a partir del gestor inicial, 
	 * solo con los pedidos en un determinado estado y en una intervalo dentro gestor inicial
	 * 
	 * @param estado estado en el que queremos que esten los pedidos del nuevo gestor
	 * @param inicio fecha en la que empieza el intervalo
	 * @param fin fecha en la que acaba el intervalo
	 * @return nuevo gestor creado a partir del gestor inicial, con todos sus pedidos en el estado solicitado y en el intervalo solicitado
	 * @throws IllegalArgumentException El intervalo introducido es incorrecto
	 * @throws IllegalArgumentException El estado introducido es null
	 */
	public Gestor obtenerGestorEstadoIntervalo(EstadoPedido estado, LocalDate inicio, LocalDate fin){
		return null;
}



}
