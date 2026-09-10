import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase encargada de la simulacion, crea a los 3 personajes,
 * arma el combate, crea a los espectadores y comienza la pelea 
 * hasta obtener un ganador
 * Único que necesita usar el Main para comenzar toda la simulacion
 */
public class Simulador{
    
    /**
     * Combate que se arma y ejecuta durante la simulacion
     */
    private Combate combate;

    /**
     * Lista de espectadores simulados que seguiran el combate y generaran
     * su propia bitacora.
     */
    private List<EspectadorSimulado> espectadores;

    /**
     * Lista de personajes peleadores de la simulacion.
     */
    private List<Personaje> peleadores;

    /**
     * Crea un nuevo simulador, con la lista de espectadores vacia y sin
     * ningun combate armado todavia.
     */
    public Simulador() {
        this.espectadores = new ArrayList<>();
        this.peleadores = new ArrayList<>();
    }

    /**
     * Crea a los 3 participantes, en el orden Korby, Dittu, MeganMan
     * en ese orden ya que el orden importa en Combate.ejecutarRonda()
     * se asume esa misma rotacion para decidir quien ataca durante la ronda
     * @return la lista con los 3 personajes creados
     */
    public List<Personaje> crearPersonajes() {
        peleadores = new ArrayList<>();
        peleadores.add(new Korby());
        peleadores.add(new Dittu());
        peleadores.add(new MeganMan());
        return peleadores;
    }

    /**
     * Crea las cuatro entidades espectadoras que pide la practica, cada una
     * recibe un identificador unico y un personaje favorito elegido al azar
     * Los espectadores creados se agregan a la lista interna de espectadores.
     */
    public void crearEspectadores() {
        Random random = new Random();

        for (int i = 1; i <= 4; i++) {
            Personaje favorito = peleadores.get(random.nextInt(peleadores.size()));
            EspectadorSimulado espectador = new EspectadorSimulado("espectador No: " + i, favorito);
            espectadores.add(espectador);
        }
    }
 
    /**
     * Suscribe a todos los espectadores creados como observadores del
     * combate ya armado, para que empiecen a recibir las notificaciones de
     * cada evento que ocurra durante la pelea.
     */
    public void registrarEspectadores() {
        for (EspectadorSimulado espectador : espectadores) {
            combate.registrarObservador(espectador);
        }
    }
 
    /**
     * Crea el flujo completo de la simulacion, crea a los personajes,
     * arma el combate con ellos, crea y suscribe a los espectadores, y
     * finalmente inicia la pelea y anuncia al ganador.
     */
    public void iniciarSimulacion() {
        List<Personaje> listaPeleadores = crearPersonajes();
        this.combate = new Combate(listaPeleadores);

        crearEspectadores();
        registrarEspectadores();

        combate.iniciarPelea();
        combate.obtenerGanador();
    }
}
 


