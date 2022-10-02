package Controladores;

import Excepciones.ExistException;
import Main.Empleado;
import Modulos.ModuloPrincipal;
import Ventanas.MenuEmpleado;

public class ControladorVInicioSesionEmpleado {
	private ModuloPrincipal modulo;
	
	public ControladorVInicioSesionEmpleado(ModuloPrincipal modulo) {
		this.modulo = modulo;
	}

	public boolean verificarEmpleado(String rut, String password) throws ExistException {
		Empleado auxEmpleado = modulo.getEmpleadoRut(rut);
		
		if(auxEmpleado == null) {
			throw new ExistException();
		}
		if(!password.equals(auxEmpleado.getPassword())) return false;
		
		return true;
	}
	
	public void botonAcceder(String rut) {
		Empleado aux = modulo.getEmpleadoRut(rut);
		
		modulo.setEmpleadoActual(aux);
		MenuEmpleado.main(null, modulo);
	}

	public void botonVolver() {
		// TODO Auto-generated method stub
		
	}
}
