package Controladores;

import Modulos.ModuloPrincipal;
import Ventanas.InicioSesionUsuario;
import Main.Persona;
import Excepciones.ExistException;

public class ControladorVRegistroCliente {
	private ModuloPrincipal modulo;

	public ControladorVRegistroCliente(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}

	public boolean buscarUsuario(String nombre, String rut) throws ExistException {
		Persona auxPersona = modulo.getClienteRut(rut);
		
		if(auxPersona == null) {
			throw new ExistException();
		}
		if(!nombre.equals(auxPersona.getNombre())) return false;
		
		return true;
	}

	public void agregarUsuario(String nombre, String rut, String direccion, String celular) {
		Persona newCliente = new Persona(nombre, rut, direccion, celular);
		
		modulo.agregarClienteName(newCliente);
		modulo.agregarClienteRut(newCliente);
		modulo.agregarListCliente(newCliente);		
	}

	public void botonVolver() {
		InicioSesionUsuario.main(null, modulo);
	}

}
