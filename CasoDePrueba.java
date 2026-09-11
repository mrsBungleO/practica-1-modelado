import java.util.List;


/**
 * Representa un escenario de combate prearmado que se selecciona al azar al iniciar la simulacion. 
 * Cada caso define a los peleadores ya con sus condiciones iniciales ajustadas, el
 * orden de turno en el que atacaran, cada cuantas rondas recogen un nuevo
 * objeto especial y el numero maximo de rondas que durara el enfrentamiento.
 *
 * Esta clase no contiene logica de combate, solo agrupa los datos de un
 * guion para que {@link Simulador} pueda elegir uno al azar y usarlo para
 * armar un {@link Combate} distinto en cada ejecucion del programa.
 */
public class CasoDePrueba {
    
    /**
     *  Nombre corto del caso de prueba, usado para  identificarlo en consola y en las bitacoras 
     */
    private String nombre;

    /**
     *  Breve descripcion de que hace distinto a este caso de los demas 
     */
    private String descripcion;

    /** 
     * Peleadores del caso, ya con sus condiciones iniciales ajustadas y en el orden de turno deseado
     */
    private List<Personaje> peleadores;

    /** 
     * Cada cuantas rondas los peleadores de este caso recogen un nuevo objeto especial
     */
    private int frecuenciaRecoleccion;

    /**
     * Numero maximo de rondas que durara el combate en este caso antes de forzar un ganador
     */
    private int limiteRondas;

    /**
     * Construye un nuevo caso de prueba con su guion ya definido
     *
     * @param nombre Nombre corto del caso de prueba
     * @param descripcion Descripcion de que lo hace distinto a los demas casos
     * @param peleadores Peleadores participantes, en el orden de turno deseado
     * @param frecuenciaRecoleccion Cada cuantas rondas se recoge un nuevo objeto especial
     * @param limiteRondas Numero maximo de rondas del combate
     */
    public CasoDePrueba(String nombre, String descripcion, List<Personaje> peleadores,
                         int frecuenciaRecoleccion, int limiteRondas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.peleadores = peleadores;
        this.frecuenciaRecoleccion = frecuenciaRecoleccion;
        this.limiteRondas = limiteRondas;
    }

    /**
     * Obtiene el nombre del caso de prueba
     * @return El nombre del caso de prueba.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene la descripcion de que hace distinto a este caso de prueba
     * @return La descripcion del caso de prueba
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Obtiene la lista de peleadores de este caso
     * @return Lista de peleadores del caso de prueba
     */
    public List<Personaje> getPeleadores() {
        return this.peleadores;
    }

    /**
     * Obtiene cada cuantas rondas se recoge un nuevo objeto especial en este caso
     * @return Frecuencia de recoleccion, en rondas
     */
    public int getFrecuenciaRecoleccion() {
        return this.frecuenciaRecoleccion;
    }

    /**
     * Obtiene el numero maximo de rondas que durara este caso de prueba
     * @return Limite de rondas del combate
     */
    public int getLimiteRondas() {
        return this.limiteRondas;
    }
}
