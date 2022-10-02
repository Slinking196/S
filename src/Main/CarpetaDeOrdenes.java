package Main;

import java.util.ArrayList;
import java.util.HashMap;

public class CarpetaDeOrdenes {
	private HashMap<Integer, OrdenDeTrabajo> ordenesId;
	private HashMap<String, OrdenDeTrabajo> ordenesDispositivo;
	private ArrayList<OrdenDeTrabajo> listOrdenes;
	
	public CarpetaDeOrdenes() {
		ordenesId = new HashMap<Integer, OrdenDeTrabajo>();
		ordenesDispositivo = new HashMap<String, OrdenDeTrabajo>();
		listOrdenes = new ArrayList<OrdenDeTrabajo>();
	}
	
	public boolean agregarOrden(OrdenDeTrabajo newOrden) {
		if(!ordenesId.containsKey(newOrden.getId())) {
			ordenesId.put(newOrden.getId(), newOrden);
			ordenesDispositivo.put(newOrden.getDispositivo(), newOrden);
			if(!ordenesId.containsKey(newOrden.getId())) return false;
			if(!ordenesDispositivo.containsKey(newOrden.getDispositivo())) return false;
			if(!listOrdenes.add(newOrden)) return false;
		}
		
		return true;
	}
	
	public void cloneOrdenes(ArrayList<OrdenDeTrabajo> ordenes) {
		OrdenDeTrabajo aux;
		
		ordenesId = new HashMap<Integer, OrdenDeTrabajo>();
		ordenesDispositivo = new HashMap<String, OrdenDeTrabajo>();
		listOrdenes = new ArrayList<OrdenDeTrabajo>();
		
		for(int i = 0; i < ordenes.size(); i++) {
			aux = ordenes.get(i);
			ordenesId.put(aux.getId(), aux);
			ordenesDispositivo.put(aux.getDispositivo(), aux);
			listOrdenes.add(aux);
		}
	}
	
	public boolean agregarOrden(Persona usuario, Empleado empleado, String dispositivo, String descripcion, int id) {
		OrdenDeTrabajo auxOrden = new OrdenDeTrabajo(usuario, empleado, dispositivo, descripcion, id);
		
		if(!ordenesId.containsKey(id)) {
			ordenesId.put(id, auxOrden);
			ordenesDispositivo.put(dispositivo, auxOrden);
			if(!ordenesId.containsKey(id)) return false;
			if(!ordenesDispositivo.containsKey(dispositivo)) return false;
			if(!listOrdenes.add(auxOrden)) return false;
		}
		
		return true;
	}
	
	public boolean eliminarOrden(int id) {
		OrdenDeTrabajo aux = ordenesId.get(id);
		
		ordenesId.remove(id);
		ordenesDispositivo.remove(aux.getDispositivo());
		if(ordenesId.containsKey(aux.getId())) return false;
		if(ordenesDispositivo.containsKey(aux.getDispositivo())) return false;
		listOrdenes.remove(aux);
		
		return true;
	}
	
	public boolean eliminarOrden(String dispositivo) {
		OrdenDeTrabajo aux = ordenesDispositivo.get(dispositivo);
		
		ordenesId.remove(aux.getId());
		ordenesDispositivo.remove(dispositivo);
		if(ordenesId.containsKey(aux.getId())) return false;
		if(ordenesDispositivo.containsKey(aux.getDispositivo())) return false;
		listOrdenes.remove(aux);
		
		return true;
	}
	
	public OrdenDeTrabajo getOrden(int id) {
		return ordenesId.get(id);
	}
	
	public OrdenDeTrabajo getOrden(String dispositivo) {
		return ordenesDispositivo.get(dispositivo);
	}
	
	public OrdenDeTrabajo getListOrden(int i) {
		return listOrdenes.get(i);
	}
	
	public int getSizeListOrdenes() {
		return listOrdenes.size();
	}
}
