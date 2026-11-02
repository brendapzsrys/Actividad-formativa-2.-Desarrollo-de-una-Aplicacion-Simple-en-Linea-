import java.util.Scanner;

// La clase base CuentaBancaria se define con sus
public class CuentBancaria {
    protected String nombreCliente;
    protected String numCuenta;
    protected double saldo;

    // Constructor de la clase Cuenta Bancaria
    public CuentBancaria(String nombreCliente, String cuenta, double saldo) {
        this.nombreCliente = nombreCliente;
        this.numCuenta = cuenta;
        this.saldo = saldo;
    }

    // Metodo para consultar el saldo de la cuenta
    public void consultarSaldo() {
        System.out.println("Tu saldo actual es: $" + saldo);
    }

    // Metodo para poder retirar dinero de la cuenta
    public void retirar() {
        System.out.println("¿Cuánto deseas retirar?");
        Scanner scanner = new Scanner(System.in);
        double cantidad = scanner.nextDouble();

        // Condicional para validar saldo
        if (cantidad > saldo) {
            System.out.println("No puedes retirar más de lo que tienes en tu saldo disponible.");
        } else {
            saldo -= cantidad;
            System.out.println("Has retirado:$ " + cantidad + ". Tu saldo restante es: " + saldo);
        }
    }

    // Metodo en caso de depositar dinero
    public void depositar() {
        System.out.println("¿Cuánto deseas depositar?");
        Scanner scanner = new Scanner(System.in);
        double cantidad;
        cantidad = scanner.nextDouble();

        saldo += cantidad;
        System.out.println("Has depositado: $" + cantidad + ". Tu saldo actual es: " + saldo);
    }

    // Metodo principal e istancia de la clase derivada
    public static void main(String[] args) {
        CuentaEstudiante cuenta = new CuentaEstudiante("Brenda Reyes", "06132022", 2500.87, "Preparatoria Normal No.13", 800.0);

        System.out.println("--------------------------------------------------");
        System.out.println("* Nombre del cliente: " + cuenta.nombreCliente);
        System.out.println("* Número de cuenta: " + cuenta.numCuenta);
        System.out.println("* Saldo disponible: " + cuenta.saldo);
        System.out.println("--------------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        int opcion;
// Bucle que muestra el menú el cuál permitira al usuario interactuar con el sistema
        do {
            System.out.println("Hola " + cuenta.nombreCliente + " ¿Qué deeseas hacer hoy?");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Retirar");
            System.out.println("3 - Depositar");
            System.out.println("4 - Ver información de estudiante");
            System.out.println("5 - Salir");

            opcion = scanner.nextInt();
// Switch para ejecutar la opción elegida por el usuario
            switch (opcion) {
                case 1:
                    cuenta.consultarSaldo();
                    break;
                case 2:
                    cuenta.retirar();
                    break;
                case 3:
                    cuenta.depositar();
                    break;
                case 4:
                    cuenta.mostrarInfoEstudiante();
                    break;
                case 5:
                    System.out.println("Gracias por usar BANCO HANA, que tengas un excelente día, vuelve pronto ...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
                    break;
            }
        } while (opcion != 5);
    }
}

// Subclase CuentaEstudiante
class CuentaEstudiante extends CuentBancaria {
    private String institucion;
    private double limiteRetiroDiario;

    public CuentaEstudiante(String nombreCliente, String cuenta, double saldo, String institucion, double limiteRetiroDiario) {
        super(nombreCliente, cuenta, saldo);
        this.institucion = institucion;
        this.limiteRetiroDiario = limiteRetiroDiario;
    }
    // Invocación a metodo de retiro original pero añadiendo una condicional al limite de retiro
    public void retirar() {
        System.out.println("¿Cuánto deseas retirar?");
        Scanner scanner = new Scanner(System.in);
        double cantidad = scanner.nextDouble();

        if (cantidad > limiteRetiroDiario) {
            System.out.println("Operación no permitida: Supera tu límite de retiro diario de $" + limiteRetiroDiario);
        } else if (cantidad > saldo) {
            System.out.println("No puedes retirar más de lo que tienes en tu saldo disponible.");
        } else {
            saldo -= cantidad;
            System.out.println("Has retirado:$ " + cantidad + ". Tu saldo restante es: " + saldo);
        }
    }

    public void mostrarInfoEstudiante() {
        System.out.println("Institución educativa: " + institucion);
        System.out.println("Límite diario autorizado: $" + limiteRetiroDiario);
    }
}