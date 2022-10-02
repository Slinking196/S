package Controladores;

import java.util.Random;

import Main.Persona;
import Main.Empleado;
import Main.OrdenDeTrabajo;
import Modulos.ModuloPrincipal;
import Ventanas.MenuCliente;

public class ControladorVCreadorNuevaOrden {
	private ModuloPrincipal modulo;
	
	public ControladorVCreadorNuevaOrden(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}
	
	public Empleado buscarEmpleado() {
		Empleado empleado;
		int i;
		
		for(i = 0; i < modulo.getSizeEmpleados(); i++) {
			empleado = modulo.getEmpleado(i);
			
			if(empleado.getSizeListOrden() < 10) {
				return empleado;
			}
		}
		
		return null;
	}

	public boolean agregarOrden(String dispositivo, String descripcion) {
		Random randomId = new Random();
		Persona clienteActual = modulo.getClienteActual();
		Empleado empleado = buscarEmpleado();
		OrdenDeTrabajo newOrden;
		int newId = randomId.nextInt(10000);
		
		while (modulo.getOrden(newId) != null) {
			if(modulo.getSizeEmpleados() == 1000) return false;
			newId = randomId.nextInt(10000);
		}
		
		newOrden = new OrdenDeTrabajo(clienteActual, empleado, dispositivo, descripcion, newId);
		clienteActual.agregarOrden(newOrden);
		empleado.agregarOrden(newOrden);
		modulo.agregarOrden(newOrden);
		
		return true;
	}

	public void botonVolver() {
		MenuCliente.main(null, modulo);
	}
	
}
