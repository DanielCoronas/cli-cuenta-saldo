
public abstract class Dinero {
	// Atributos protegidos para ser accesibles en las clases hijas
	protected double dinero;	 // Cantidad de dinero
	protected String description;// Descripción del gasto o ingreso
	
	
	 // Métodos para obtener y establecer el valor del dinero
	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	// Métodos para obtener y establecer la descripción
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
