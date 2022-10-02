package Main;

import java.util.HashMap;
import java.util.ArrayList;

public class Inventario {
	private HashMap<String, Repuesto> repuestosName;
	private HashMap<Integer, Repuesto> repuestosId;
	private ArrayList<Repuesto> listRepuesto;
	
	public Inventario() {
		repuestosName = new HashMap<String, Repuesto>();
		repuestosId = new HashMap<Integer, Repuesto>();
		listRepuesto = new ArrayList<Repuesto>();
	}
	
	public boolean agregarRepuesto(Repuesto newRepuesto) {
		Repuesto repuestoAux;
		
		if(repuestosName.containsKey(newRepuesto.getNombre())) {
			repuestoAux = repuestosName.get(newRepuesto.getNombre());
			repuestoAux.setCantidad(repuestoAux.getCantidad() + newRepuesto.getCantidad());
		}
		else {
			repuestosName.put(newRepuesto.getNombre(), newRepuesto);
			repuestosId.put(newRepuesto.getId(), newRepuesto);
			if(!repuestosName.containsKey(newRepuesto.getNombre())) return false;
			if(!repuestosId.containsKey(newRepuesto.getId())) return false;
			if(!listRepuesto.add(newRepuesto)) return false;
		}
		
		return true;
	}
	
	public boolean agregarRepuesto(String nombre, int id, int cantidad, int precio) {
		Repuesto repuestoAux = new Repuesto(nombre, id, cantidad, precio);
		
		if(repuestosName.containsKey(nombre)) {
			repuestoAux = repuestosName.get(nombre);
			repuestoAux.setCantidad(repuestoAux.getCantidad() + cantidad);
		}
		else {
			repuestosName.put(nombre, repuestoAux);
			repuestosId.put(id, repuestoAux);
			if(!repuestosName.containsKey(nombre)) return false;
			if(!repuestosId.containsKey(id)) return false;
			if(!listRepuesto.add(repuestoAux)) return false;
		}
		
		return true;
	}
	
	public boolean eliminarRepuesto(int id) {
		Repuesto repuestoAux = repuestosId.remove(id);
		if(repuestosId.containsKey(id)) return false;
		repuestosName.remove(repuestoAux.getNombre());
		if(repuestosName.containsKey(repuestoAux.getNombre())) return false;
		listRepuesto.remove(repuestoAux);
		
		return true;
	}
	
	public boolean eliminarRepuesto(String nombre) {
		Repuesto repuestoAux = repuestosName.remove(nombre);
		if(repuestosName.containsKey(nombre)) return false;
		repuestosId.remove(repuestoAux.getId());
		if(repuestosId.containsKey(repuestoAux.getId())) return false;
		listRepuesto.remove(repuestoAux);
		
		return true;
	}
	
	public boolean descontarRepuesto(String nombre, int cantidad) {
		Repuesto repuestoAux;
		
		if (!repuestosName.containsKey(nombre)) return false;
		
		repuestoAux = repuestosName.get(nombre);
		repuestoAux.setCantidad(repuestoAux.getCantidad() - cantidad);
		
		return true;
	}
	
	public boolean descontarRepuesto(int id, int cantidad) {
		Repuesto repuestoAux;
		
		if (!repuestosId.containsKey(id)) return false;
		
		repuestoAux = repuestosId.get(id);
		repuestoAux.setCantidad(repuestoAux.getCantidad() - cantidad);
		
		return true;
	}
	
	public Repuesto getRepuesto(String nombre) {
		if (repuestosName.containsKey(nombre)) {
			return repuestosName.get(nombre);
		}
		
		return null;
	}
	
	public Repuesto getRepuesto(int id) {
		if (repuestosId.containsKey(id)) {
			return repuestosId.get(id);
		}
		
		return null;
	}
	
	public Repuesto getListRepuesto(int i) {
		return listRepuesto.get(i);
	}
	
	public int getSizeListRepuesto() {
		return listRepuesto.size();
	}
}
