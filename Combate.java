import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    private static final int LIMITE_RONDAS = 20; 

    /**
     * Da inicio a la simulacion del combate. Aqui es donde los
     * personajes obtienen sus habilidades al azar, intercambian ataques,
     * se defienden y se va informando progresivamente a la audiencia de cada suceso.
     */
    public void iniciarPelea() {
        notificarObservadores("¡QUE COMIENCE EL COMBATE, A POR SUS AURAS!");

        int rondaActual = 1;
        while (rondaActual <= LIMITE_RONDAS) {
            int sobrevivientes = 0;
            for (Personaje peleador : peleadores) {
                if (peleador.getAura() > 0) {
                    sobrevivientes++;
                }
            }

            if (sobrevivientes <= 1) {
                break;
            }

            if (rondaActual > 1) {
                for (Personaje peleador : peleadores) {
                    if (peleador.getAura() > 0 && !peleador.getPoderes().isEmpty()) {
                        int indice = (rondaActual - 2) % peleador.getPoderes().size();
                        Tupla<ObjetoEspecial, Poder> tupla = peleador.getPoderes().get(indice);
                        peleador.recogerObjeto(tupla);
                        notificarObservadores(peleador.getNombre() + " encontró " + tupla.getElemento1().getNombre()
                            + " y ahora tiene " + tupla.getElemento2().getDescripcion());
                    }
                }
            }

            notificarObservadores("--- Ronda " + rondaActual + " ---");
            ejecutarRonda();
            rondaActual++;
        }
    }
    
    /**
     * Ejecuta una ronda de combate donde cada peleador que siga con vida ataca al
     * siguiente rival vivo, siguiendo el orden en que fueron registrados
     * cada ataque y sus consecuencias se transmiten
     * a la audiencia a traves de notificarObservadores(String)}.
     */
    public void ejecutarRonda() {
        int totalPeleadores = peleadores.size();

        for (int i = 0; i < totalPeleadores; i++) {
            Personaje atacante = peleadores.get(i);

            if (atacante.getAura() <= 0) {
                continue;
            }

            Personaje objetivo = null;
            for (int desplazamiento = 1; desplazamiento < peleadores.size(); desplazamiento++) {
                Personaje candidato = peleadores.get((i + desplazamiento) % peleadores.size());
                if (candidato.getAura() > 0) {
                    objetivo = candidato;
                    break;
                }
            }

            if (objetivo == null) {
                continue;
            }

            atacante.ofensa(objetivo);

            Poder poderAtacante = atacante.getPoderEquipado().getElemento2();
            notificarObservadores(atacante.getNombre() + " atacó a " + objetivo.getNombre()
                    + " usando su " + poderAtacante.getDescripcion());
            notificarObservadores(objetivo.getNombre() + " le quedan " + objetivo.getAura() + " puntos de vida.");

            if (objetivo.getAura() <= 0) {
                notificarObservadores(objetivo.getNombre() + " ha sido derrotado, FUERA AURA.");
            }
        }
    }
    
 


    /**
     * Evalúa las condiciones finales del enfrentamiento para determinar cuál de
     * los peleadores logró mantenerse en pie y transmitir el resultado a la audiencia.
     *
     * @return El personaje que resultó victorioso al concluir la batalla.
     */
    public Personaje obtenerGanador() {
        Personaje ganador = null;
        for (Personaje peleador : peleadores) {
            if (peleador.getAura() > 0) {
                ganador = peleador;
                break;
            }
        }

        if (ganador == null && !peleadores.isEmpty()) {
            ganador = peleadores.get(0);
        }

        notificarObservadores("¡FIN DEL COMBATE!");
        notificarObservadores("El ganador de la pelea es: " + ganador.getNombre() + "!");
        return ganador;
    }
}