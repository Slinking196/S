package Main;

public class Empleado extends Persona{
	private String password;
	private int sueldo;
	
	public Empleado(String nombre, String rut, String direccion, String celular, String password, int sueldo) {
		super(nombre, rut, direccion, celular);
		this.password = password;
		this.sueldo = sueldo;
	}
	
	public Empleado(String nombre, String rut, String direccion, String password, int sueldo) {
		super(nombre, rut, direccion);
		this.password = password;
		this.sueldo = sueldo;
	}
	
	public Empleado(String nombre, String rut, String direccion, String password) {
		super(nombre, rut, direccion);
		this.password = password;
		this.sueldo = 0;
	}
	
	public void cambiarEstadoOrden(int id, String estado) {
		OrdenDeTrabajo auxOrden = getOrden(id);
		
		auxOrden.setEstado(estado);
	}
	
	public void cambiarEstadoOrden(String dispositivo, String estado) {
		OrdenDeTrabajo auxOrden = getOrden(dispositivo);
		
		auxOrden.setEstado(estado);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getSueldo() {
		return sueldo;
	}
}
