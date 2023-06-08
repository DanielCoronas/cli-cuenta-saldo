import java.util.List;
import java.util.ArrayList;

public class Cuenta {
    private double saldo;			// Saldo actual de la cuenta
    private Usuario usuario;		// Usuario al que pertenece la cuenta
    private List<Gasto> gastos;		// Lista de los gastos realizados
    private List<Ingreso> ingresos;	// Lista de los ingresos realizados
    
    // Constructor de la cuenta
    public Cuenta(Usuario usuario) {
        this.saldo = 0;
        this.usuario = usuario;
        this.gastos = new ArrayList<>();
        this.ingresos = new ArrayList<>();
    }
    
    // Método para obtener el saldo actual de la cuenta
    public double getSaldo() {
        return saldo;
    }
    
    // Método para establecer un nuevo saldo en la cuenta
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    // Método para obtener el usuario al que pertenece la cuenta
    public Usuario getUsuario() {
        return usuario;
    }
    
    // Método para establecer un nuevo usuario en la cuenta
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Método para agregar un ingreso a la cuenta y actualizar el saldo
    public double addIngresos(String description, double cantidad) {
        Ingreso ingreso = new Ingreso(cantidad, description);
        ingresos.add(ingreso);
        saldo += cantidad;
        return saldo;
    }

    // Método para agregar un gasto a la cuenta y actualizar el saldo
    public double addGastos(String description, double cantidad) throws GastoException {
        if (saldo < cantidad) {
            throw new GastoException();// Si el saldo es menor a la cantidad del gasto, lanza una excepción
        } else {
            Gasto gasto = new Gasto(cantidad, description);
            gastos.add(gasto);
            saldo -= cantidad;
        }
        return saldo;
    }
    
    // Método para obtener la lista de ingresos realizados en la cuenta
    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    // Método para obtener la lista de gastos realizados en la cuenta   
    public List<Gasto> getGastos() {
        return gastos;
    }

    // Método para obtener la información completa de la cuenta (usuario y saldo actual)
    @Override
    public String toString() {
        return "Cuenta de " + usuario.getNombre() + ", con saldo actual de " + saldo + "€";
    }
}
