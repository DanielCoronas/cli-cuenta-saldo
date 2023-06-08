
public class Ingreso extends Dinero {
    
	// Constructor único que recibe el valor del ingreso y su descripción
    public Ingreso(double ingreso, String description) {
        super.setDinero(ingreso);		  // Establece el valor del ingreso
        super.setDescription(description);// Establece la descripción del ingreso
    }
    
    // Sobreescribimos el método toString() para mostrar los datos del ingreso
    @Override
    public String toString() {
        return "Ingreso en concepto de: \"" + super.getDescription() + "\", por importe de: " 
                + super.getDinero() + "€";
    }
}
