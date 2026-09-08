import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa el escenario y la logica central donde se lleva a cabo el
 * enfrentamiento entre los personajes.
 *
 * Esta clase actua como la entidad emisora dentro del patron Observer,
 * gestiona la lista de espectadores suscritos e informa en tiempo real
 * cada evento relevante sucedido durante la lucha.
 *
 */
public class Combate implements Sujeto {

    /**
     * Lista que almacena a los tres peleadores participantes de la simulacion.
     */
    private List<Personaje> peleadores;

    /**
     * Lista de espectadores registrados que recibiran las actualizaciones
     * sobre los acontecimientos del combate.
     */
    private List<Observador> observadores;

    /**
     * Inicializa un nuevo encuentro con los peleadores seleccionados y
     * prepara la estructura para recibir a la audiencia.
     *
     * @param peleadores Lista con los personajes que participaran en la contienda.
     */
    public Combate(List<Personaje> peleadores) {
        this.peleadores = peleadores;
        this.observadores = new ArrayList<>();
    }

    /**
     * Condensa toda la logica de un ataque y elimina de la lista de peleadores
     * al personaje que recibe el daño si su vida se termina durante ese ataque.
     * 
     * @param atacante El personaje que hace el daño del ataque.
     * @param objetivo El personaje que recibe el daño del ataque.
     */
    public void realizarAtaque(Personaje atacante, Personaje objetivo){
        atacante.ofensa(objetivo);
        if(objetivo.getAura()<=0){
            System.out.println("¡" + objetivo.getNombre() + " ha sido derrotado por " + atacante.getNombre() + "!");
            this.peleadores.remove(objetivo);
        }
    }

    /**
     * Agrega un nuevo espectador a la lista para que pueda dar seguimiento
     * a los acontecimientos de la pelea.
     *
     * @param o El espectador que desea suscribirse a la transmision.
     */
    @Override
    public void registrarObservador(Observador o) {
        observadores.add(o);
    }

    /**
     * Retira a un espectador de la lista, evitando que reciba futuras
     * notificaciones sobre el encuentro.
     *
     * @param o El espectador que se dara de baja de la transmision.
     */
    @Override
    public void removerObservador(Observador o) {
        observadores.remove(o);
    }

    /**
     * Emite un mensaje con los detalles de lo sucedido en la arena a todos
     * los espectadores que esten conectados en ese momento.
     *
     * @param e Descripcion del evento o accion que acaba de ocurrir en el combate.
     */
    @Override
    public void notificarObservadores(String e) {
        for (Observador observador : observadores) {
            observador.actualizar(e);
        }
    }

    /**
     * Da inicio a la simulacion del combate. Aqui es donde los
     * personajes obtienen sus habilidades al azar, intercambian ataques,
     * se defienden y se va informando progresivamente a la audiencia de cada suceso.
     */
    public void iniciarPelea() {
        notificarObservadores("¡QUE COMIENCE EL COMBATE, A POR SUS AURAS!");
        
        Personaje korby = peleadores.get(0);
        Personaje dittu = peleadores.get(1);
        Personaje meganMan = peleadores.get(2);

        //...
    }

    /**
     * Evalúa las condiciones finales del enfrentamiento para determinar cuál de
     * los peleadores logró mantenerse en pie y transmitir el resultado a la audiencia.
     *
     * @return El personaje que resultó victorioso al concluir la batalla.
     */
    public Personaje obtenerGanador() {
        Personaje ganador = peleadores.get(0); 
        notificarObservadores("¡FIN DEL COMBATE!");
        notificarObservadores("El ganador de la pelea es: " + ganador.getNombre() + "!");
        return ganador;
    }
}