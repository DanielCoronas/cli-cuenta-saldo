
public class GastoException extends RuntimeException {
	// Se utiliza un número de serie estático para identificar la versión de la clase
	//private static final long serialVersionUID = 1L;
	//Es recomendable usar el serial, pero como no esta especificado en el diagrama no pongo
	
	// Constructor de la excepción personalizada
	public GastoException() {
		// Se llama al constructor de la clase base (RuntimeException) y se le pasa como argumento el mensaje de error
		super("La cantidad del gasto excede el saldo de su cuenta\n");
	}
}
