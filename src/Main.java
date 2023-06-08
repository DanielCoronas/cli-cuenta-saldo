import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	// Creamos un objeto Scanner para leer desde consola
        Scanner scanner = new Scanner(System.in);
        // Inicializamos la variable opcion con un valor negativo para entrar al bucle del menú
        int opcion = -1;
        // Creación del usuario
        System.out.println("Introduce el nombre del usuario:");
        String nombre = scanner.nextLine();

        System.out.println("Introduce la edad del usuario:");
        int edad = Integer.parseInt(scanner.nextLine());

        String dni = "";
        boolean dniCorrecto = false;
        while (!dniCorrecto) {
            System.out.println("Introduce el DNI del usuario:");
            dni = scanner.nextLine();
            Usuario usuario = new Usuario();
            dniCorrecto = usuario.setDNI(dni);
        }
        
        // Creamos un objeto Usuario y le asignamos los valores introducidos
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEdad(edad);
        usuario.setDNI(dni);
        
        // Mostramos por consola los datos del usuario creado
        System.out.println("Se ha creado el usuario correctamente.");
		System.out.println("Nombre: \"" + usuario.getNombre() + "\" Edad: " + usuario.getEdad() + " DNI: " + usuario.getDNI());
        
		// Creación de la cuenta
        Cuenta cuenta = new Cuenta(usuario);

        // Visualización del menú
        boolean salir = false;
        while (!salir) {
            System.out.println("\n Realiza una nueva acción");
            System.out.println("  (1) Introduce un nuevo gasto");
            System.out.println("  (2) Introduce un nuevo ingreso");
            System.out.println("  (3) Mostrar gastos");
            System.out.println("  (4) Mostrar ingresos");
            System.out.println("  (5) Mostrar saldo");
            System.out.println("  (0) Salir");

            // Leemos la opción seleccionada por el usuario desde consola
            opcion = Integer.parseInt(scanner.nextLine());

            // Evaluamos la opción seleccionada por el usuario y ejecutamos la acción correspondiente
            switch (opcion) {
	            case 1:
	            	// Se pide al usuario que introduzca una descripción para el gasto
	                System.out.println("Introduce una descripción para el gasto:");
	                String descripcionGasto = scanner.nextLine();
	
	                // Se pide al usuario que introduzca la cantidad del gasto
	                System.out.println("Introduce la cantidad del gasto:");
	                String cantidadGastoStr = scanner.nextLine();
	                double cantidadGasto;
	
	                // Se intenta convertir la cantidad del gasto a un número decimal
	                try {
	                    cantidadGasto = Double.parseDouble(cantidadGastoStr.replace(',', '.'));
	                } catch (NumberFormatException e) {
	                // Si la cantidad introducida no es un número, se muestra un mensaje de error y se sale del case
	                    System.out.println("Cantidad introducida no válida.");
	                    break;
	                }
	
	                // Se intenta agregar el gasto a la cuenta
	                try {
	                // Si se agrega correctamente el gasto, se muestra el nuevo saldo
	                    double saldoDespuesGasto = cuenta.addGastos(descripcionGasto, cantidadGasto);
	                    System.out.println("Nuevo saldo: " + String.format("%.2f", saldoDespuesGasto).replace('.', ',') + "€");
	                } catch (GastoException e) {
	                // Si la cantidad del gasto excede el saldo de la cuenta, se muestra un mensaje de error y el saldo restante
	                    System.out.println(e.getMessage());
	                    System.out.println("Saldo: " + String.format("%.2f", (cuenta.getSaldo())) + "€ " + "Gasto: " + String.format("%.2f",cantidadGasto) + "€" 
	                    					+ "\nSaldo restante: " + String.format("%.2f",(cuenta.getSaldo())) + "€");
	                }
	                break;

                case 2:
                	// Se pide al usuario que introduzca una descripción para el ingreso
                    System.out.println("Introduce una descripción para el ingreso:");
                    String descripcionIngreso = scanner.nextLine();
                    
                    // Se pide al usuario que introduzca la cantidad del ingres
                    System.out.println("Introduce la cantidad del ingreso:");
                    double cantidadIngreso = 0;
                    
                    try {
                        cantidadIngreso = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    } catch (NumberFormatException e) {
                    // Si la cantidad introducida no es un número, se muestra un mensaje de error y se sale del case
                        System.out.println("Cantidad introducida no es válida");
                        break;
                    }
                    // Se agrega el ingreso a la cuenta
                    double saldoDespuesIngreso = cuenta.addIngresos(descripcionIngreso, cantidadIngreso);
                    // Se muestra el nuevo saldo
                    System.out.println("Nuevo saldo: " + String.format("%.2f", saldoDespuesIngreso).replace('.', ',') + "€");
                    break;

                case 3:
                	//se comprueba si hay gastos
                	if (cuenta.getGastos().isEmpty()) {
						System.out.println("No hay gastos para mostrar.");
                	// Imprimir los gastos
                		}else{
                			System.out.println("Gastos:");
                			for (Gasto gasto : cuenta.getGastos()) {
                				System.out.println(gasto.toString().replace('.', ','));
                			}
                	}
                    break;

                case 4:
					// se comprueba si hay ingresos
					if (cuenta.getIngresos().isEmpty()) {
						System.out.println("No hay ingresos para mostrar.");
						} else {
							// Imprimir los ingresos
							System.out.println("Ingresos:");
							for (Ingreso ingreso : cuenta.getIngresos()) {
								System.out.println(ingreso.toString().replace('.', ','));
							}
					}
                    break;
                    
                case 5:
                	// Imprimir el nombre del usuario y su saldo actual
                	System.out.println("Usuario= " + usuario.getNombre() + " Saldo actual= " + String.format("%.2f", cuenta.getSaldo()) + "€");

                    break;

                case 0:
                	// Salir del programa
                    salir = true;
                    break;

                default:
                	// Opción inválida
                    System.err.println("Opción no válida.\nElige una opcion entre el 1 y el 5.");
            }
        }

        scanner.close();

        // Fin de la aplicación
        System.out.println("Fin del programa.\nGracias por utilizar la aplicación de M03B en el curso 2s2223.");
    }
}
