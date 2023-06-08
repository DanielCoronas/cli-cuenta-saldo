
public class Usuario {
    
    String nombre;
    int edad;
    String DNI;

    
    public Usuario() {}

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    public boolean setDNI(String DNI) {
        // Definimos la expresión regular como una cadena de caracteres
        String patron = "^[0-9]{8}(-?[A-Z])$";
        // Comprobamos si DNI cumple el patrón utilizando el método matches() de la clase String
        if (DNI.matches(patron)) {
            this.DNI = DNI;
            return true;
        } else {
            System.out.println("El DNI introducido es incorrecto.");
            return false;
        }
    }



    // Sobreescribimos el método toString()
    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", edad=" + edad + ", DNI=" + DNI + "]";
    }
}
