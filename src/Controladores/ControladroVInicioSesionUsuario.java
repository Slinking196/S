package Controladores;

import Main.Persona;
import Modulos.ModuloPrincipal;
import Ventanas.MenuCliente;
import Ventanas.RegistroCliente;
import Excepciones.ExistException;

public class ControladroVInicioSesionUsuario {
	private ModuloPrincipal modulo;
	
	public ControladroVInicioSesionUsuario(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}

	public boolean verificarUsuario(String nombre, String rut) throws ExistException {
		Persona auxPersona = modulo.getClienteRut(rut);
		
		if(auxPersona == null) {
			throw new ExistException();
		}
		if(!nombre.equals(auxPersona.getNombre())) return false;
		
		return true;
	}
	
	public void botonAcceder(String rut) {
		Persona aux = modulo.getClienteRut(rut);
		
		modulo.setClienteActual(aux);
		MenuCliente.main(null, modulo);
	}

	public void botonRegistrarse() {
		RegistroCliente.main(null, modulo);
	}
}
