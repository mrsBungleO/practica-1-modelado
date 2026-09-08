/**
 * Punto de entrada del programa. Su unica responsabilidad es crear un
 * {@link Simulador} y arrancar con el toda la simulacion del combate.
 */
public class Main {
 
    /**
     * Metodo principal que inicia la ejecucion del programa.
     *
     * @param args Argumentos de linea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Simulador simulador = new Simulador();
        simulador.iniciarSimulacion();
    }
}
 
