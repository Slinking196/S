package Modulos;

import java.util.HashMap;
import java.util.ArrayList;
import Main.Empleado;
import Main.OrdenDeTrabajo;
import Main.Inventario;

public class ModuloEmpleado {
	private ModuloPrincipal moduloPrincipal;
	private HashMap<Integer, OrdenDeTrabajo> ordenesId;
	private ArrayList<OrdenDeTrabajo> listOrdenes;
	private Empleado empleadoActual;
	
	public ModuloEmpleado() {
		ordenesId = new HashMap<Integer, OrdenDeTrabajo>();
		listOrdenes = new ArrayList<OrdenDeTrabajo>();
	}
	
	public void setModuloPrincipal(ModuloPrincipal moduloPrincipal) {
		this.moduloPrincipal = moduloPrincipal;
	}
	
	public void setEmpleadoActual(Empleado empleadoActual) {
		this.empleadoActual = empleadoActual;
	}
	
	public ModuloPrincipal getModuloPrincipal() {
		return moduloPrincipal;
	}
	
	public Empleado getEmpleadoActual() {
		return empleadoActual;
	}
	
	public void agregarOrdenId(OrdenDeTrabajo auxOrden) {
		if(!ordenesId.containsKey(auxOrden.getId())) {
			ordenesId.put(auxOrden.getId(), auxOrden);
			listOrdenes.add(auxOrden);
		}
	}
	
	public int getSizeListOrdenes() {
		return listOrdenes.size();
	}
	
	public Inventario getAlmacen() {
		return moduloPrincipal.getInventario();
	}
	
	public OrdenDeTrabajo getOrden(int id) {
		return ordenesId.get(id);
	}
	
	public OrdenDeTrabajo getListOrden(int i) {
		return listOrdenes.get(i);
	}
	
}
