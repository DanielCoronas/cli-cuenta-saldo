
public class Gasto extends Dinero {
    
	// Constructor único para crear objetos Gasto con su descripción y cantidad.
    public Gasto(double gasto, String description) {
        super.setDinero(gasto);			  // Establecemos el valor del gasto con el método setDinero() de la clase padre.
        super.setDescription(description);// Establecemos la descripción del gasto con el método setDescription() de la clase padre.
    }
    
    // Sobreescribimos el método toString() para devolver un String con la información del gasto.
    @Override
    public String toString() {
        return "Gasto en concepto de: \"" + super.getDescription() + "\", por importe de: " 
                + super.getDinero() + "€"; // Devolvemos un String que incluye la descripción y cantidad del gasto.
    }
}
