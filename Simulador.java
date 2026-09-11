import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase encargada de la simulacion que arma los 3 casos de prueba pedidos por
 * la pratica, elige uno al azar, crea el combate y a los espectadores a
 * partir de ese caso, y ejecuta la pelea hasta obtener un ganador
 * Único que necesita usar el Main para comenzar toda la simulacion
 */
public class Simulador {

    /** 
     * Combate que se arma y ejecuta durante la simulacion. 
    */
    private Combate combate;

    /** 
     * Lista de espectadores simulados que seguiran el combate y generaran su propia bitacora. 
     */
    private List<EspectadorSimulado> espectadores;

    /** 
     * Generador de numeros aleatorios usado para elegir el caso de prueba y a los espectadores favoritos. 
     */
    private Random random;

    /**
     * Crea un nuevo simulador, con la lista de espectadores vacia y sin
     * ningun combate armado todavia.
     */
    public Simulador() {
        this.espectadores = new ArrayList<>();
        this.random = new Random();
    }

    /**
     * Arma los 3 casos de prueba pedidos por la practica. Cada uno tiene un
     * personaje favorecido con aura extra, un ritmo distinto de cambio de
     * poderes y una duracion maxima distinta, de forma que cada uno refleje
     * un combate diferente.
     *
     * @return Lista con los 3 casos de prueba disponibles.
     */
    public List<CasoDePrueba> crearCasosDePrueba() {
        List<CasoDePrueba> casos = new ArrayList<>();

        // Caso 1: Korby gana
        Korby korby1 = new Korby();
        korby1.setAura(130);
        List<Personaje> peleadores1 = new ArrayList<>();
        peleadores1.add(korby1);
        peleadores1.add(new MeganMan());
        peleadores1.add(new Dittu());
        casos.add(new CasoDePrueba(
                "Ventaja de Korby",
                "Korby inicia con aura extra y los 3 cambian de poder cada ronda: combate rapido e intenso.",
                peleadores1, 1, 10));

        // Caso 2: Dittu gana
        Dittu dittu2 = new Dittu();
        dittu2.setAura(140);
        List<Personaje> peleadores2 = new ArrayList<>();
        peleadores2.add(dittu2);
        peleadores2.add(new MeganMan());
        peleadores2.add(new Korby());
        casos.add(new CasoDePrueba(
                "Resistencia de Dittu",
                "Dittu inicia con aura extra y los poderes cambian lento (cada 3 rondas): combate largo, de desgaste.",
                peleadores2, 3, 10));

        // Caso 3: MeganMan gana
        MeganMan meganMan3 = new MeganMan();
        meganMan3.setAura(120);
        List<Personaje> peleadores3 = new ArrayList<>();
        peleadores3.add(meganMan3);
        peleadores3.add(new Korby());
        peleadores3.add(new Dittu());
        casos.add(new CasoDePrueba(
                "Golpe relampago de MeganMan",
                "MeganMan inicia con aura extra y el combate se limita a pocas rondas: choque corto y contundente.",
                peleadores3, 1, 5));

        return casos;
    }

    /**
     * Elige al azar uno de los casos de prueba disponibles.
     *
     * @param casos Lista de casos de prueba entre los que se elegira.
     * @return El caso de prueba seleccionado para esta ejecucion.
     */
    public CasoDePrueba elegirCasoAlAzar(List<CasoDePrueba> casos) {
        int indice = random.nextInt(casos.size());
        return casos.get(indice);
    }

    /**
     * Crea las cuatro entidades espectadoras que pide la practica, cada una
     * con un identificador unico y un personaje favorito elegido al azar
     * entre los peleadores del caso de prueba seleccionado
     *
     * @param peleadores Peleadores del caso de prueba elegido, entre los que
     *                    se sorteara el personaje favorito de cada espectador
     */
    public void crearEspectadores(List<Personaje> peleadores) {
        for (int i = 1; i <= 4; i++) {
            Personaje favorito = peleadores.get(random.nextInt(peleadores.size()));
            EspectadorSimulado espectador = new EspectadorSimulado("espectador_" + i, favorito);
            espectadores.add(espectador);
        }
    }

    /**
     * Suscribe a todos los espectadores creados como observadores del
     * combate ya armado, para que empiecen a recibir las notificaciones de
     * cada evento que ocurra durante la pelea
     */
    public void registrarEspectadores() {
        for (EspectadorSimulado espectador : espectadores) {
            combate.registrarObservador(espectador);
        }
    }

    /**
     * Arma la simulacion elige al azar uno de los 3
     * casos de prueba, arma el combate con su guion, crea y suscribe a los
     * espectadores, e inicia la pelea hasta anunciar al ganasor
     */
    public void iniciarSimulacion() {
        List<CasoDePrueba> casos = crearCasosDePrueba();
        CasoDePrueba casoElegido = elegirCasoAlAzar(casos);

        this.combate = new Combate(casoElegido.getPeleadores(),
                casoElegido.getFrecuenciaRecoleccion(),
                casoElegido.getLimiteRondas());

        crearEspectadores(casoElegido.getPeleadores());
        registrarEspectadores();
        combate.iniciarPelea();
        combate.obtenerGanador();
    }
}

