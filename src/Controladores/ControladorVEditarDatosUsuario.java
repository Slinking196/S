package Controladores;

import Ventanas.MenuCliente;
import Modulos.ModuloPrincipal;
import Main.Persona;

public class ControladorVEditarDatosUsuario {
	private ModuloPrincipal modulo;
	
	public ControladorVEditarDatosUsuario(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}
	
	public boolean botonActualizar(String nombre, String direccion, String celular) {
		Persona clienteAux = modulo.getClienteActual();
		
		clienteAux.setNombre(nombre);
		clienteAux.setDireccion(direccion);
		clienteAux.setCelular(celular);
		
		if(!nombre.equals(clienteAux.getNombre())) return false;
		if(!direccion.equals(clienteAux.getDireccion())) return false;
		if(!celular.equals(clienteAux.getCelular())) return false;
		
		return true;
	}
	
	public String getRutCliente() {
		Persona clienteAux = modulo.getClienteActual();
		
		return clienteAux.getRut();
	}
	
	public String getNombreCliente() {
		Persona clienteAux = modulo.getClienteActual();
		
		return clienteAux.getNombre();
	}
	
	public String getDireccionCliente() {
		Persona clienteAux = modulo.getClienteActual();
		
		return clienteAux.getDireccion();
	}
	
	public String getCelularCliente() {
		Persona clienteAux = modulo.getClienteActual();
		
		return clienteAux.getCelular();
	}

	public void botonVolver() {
		MenuCliente.main(null, modulo);
	}
	
}
