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
     * Cada cuantas rondas los peleadores recogen un nuevo objeto especial y
     * cambian de poder equipado. Cada caso de prueba define su propio valor
     * para lograr un ritmo de daño distinto.
     */
    private int frecuenciaRecoleccion;

    /**
     * Numero maximo de rondas que durara el combate antes de forzar un
     * ganador segun el aura restante de cada peleador. Cada caso de prueba
     * puede definir una duracion distinta para el enfrentamiento.
     */
    private int limiteRondas;

    /**
     * Generador de numeros aleatorios utilizado para decidir, en el momento
     * en que un personaje recoge un objeto especial, cual de sus poderes
     * disponibles obtiene.
     */
    private Random random;

    /**
     * Inicializa un nuevo encuentro con los peleadores seleccionados y
     * prepara la estructura para recibir a la audiencia.
     *
     * @param peleadores Lista con los personajes que participaran en la contienda,
     *                   ya en el orden de turno con el que atacaran.
     * @param frecuenciaRecoleccion Cada cuantas rondas se recoge un nuevo objeto especial.
     * @param limiteRondas Numero maximo de rondas que durara el combate.
     */
    public Combate(List<Personaje> peleadores, int frecuenciaRecoleccion, int limiteRondas) {
        this.peleadores = peleadores;
        this.observadores = new ArrayList<>();
        this.frecuenciaRecoleccion = frecuenciaRecoleccion;
        this.limiteRondas = limiteRondas;
        this.random = new Random();
    }

    /**
     * Hace que un personaje recoja un objeto especial junto con su poder e imprime los detalles
     * @param personaje El personaje que recojera el objeto y equipará el poder asociado
     * @param poder La tupla con el objeto especial y el poder a recoger
     */
    public void recogerObjeto(Personaje personaje, Tupla<ObjetoEspecial,Poder> poder){
        personaje.setPoderEquipado(poder);
        System.out.println(personaje.getNombre() + " tomó " + personaje.getPoderEquipado().getElemento1().getNombre() + ".");
        System.out.println("Ahora " + personaje.getNombre() + " tiene " + personaje.getPoderEquipado().getElemento2().getDescripcion());

        notificarObservadores(personaje.getNombre() + " tomó " + personaje.getPoderEquipado().getElemento1().getNombre() + ".");
        notificarObservadores("Ahora " + personaje.getNombre() + " tiene " + personaje.getPoderEquipado().getElemento2().getDescripcion());
    }

    /**
     * Hace que un personaje atacante realice un ataque hacia un personaje objetivo, calcula el daño recibido segun las
     * estadisticas de ataque y defensa, reduce el aura del objetivo e imprime los datos del combate
     * @param atacante El personaje que realiza el ataque
     * @param objetivo El personaje que recibira el ataque
     */
    public void danioAEnemigo(Personaje atacante, Personaje objetivo){
        
        atacante.getPoderEquipado().getElemento2().atacar(objetivo);
        int ataquePropio= atacante.getPoderEquipado().getElemento2().getAtaque();
        int defensaEnemigo= objetivo.getPoderEquipado().getElemento2().getDefensa();
        
        int danio= ataquePropio - defensaEnemigo;
        
        if(danio<0){
            danio=0;
        }

        int auraEnemigo= objetivo.getAura() - danio;

        if(auraEnemigo<0){
            auraEnemigo=0;
        }

        objetivo.setAura(auraEnemigo);
        
        System.out.println(objetivo.getNombre() + " recibió un ataque de " + atacante.getNombre() + ".");
        System.out.println(objetivo.getNombre() + " obtuvo un daño de " + danio + ". Le queda " + objetivo.getAura() + " de aura.");

        notificarObservadores(objetivo.getNombre() + " recibió un ataque de " + atacante.getNombre() + ".");
        notificarObservadores(objetivo.getNombre() + " obtuvo un daño de " + danio + ". Le queda " + objetivo.getAura() + " de aura.");

    }

     /**
     * Absorbe el poder actualmente equipado por el enemigo.
     * La restriccion de franquicia (Korby solo puede tener poderes de su
     * propia saga, MeganMan de la suya, etc.) ya se aplica al elegir los 3
     * poderes base de cada personaje en su constructor; en combate, cualquier
     * personaje que consume, derrota o ve a otro puede replicar el poder que
     * ese enemigo tenia equipado en ese momento, sin importar su franquicia.
     * @param atacante el personaje que absorberá el poder
     * @param objetivo El personaje del cual se copiara el poder equipado
     */
    public void absorberPoder(Personaje atacante, Personaje objetivo){

        int resultado=atacante.esAbsorbido(objetivo);

        if(resultado==1){
            notificarObservadores(atacante.getNombre() + " equipó el poder de " + objetivo.getNombre() + ".");
        }

        if(resultado==0){
            notificarObservadores(atacante.getNombre() + " intentó absorber el poder de " + objetivo.getNombre() + " pero no lo logró.");
        } else {
            
        }
        
    }

    /**
     * Realiza daño al enemigo y trata de absorber o copiar su poder
     * @param atacante El personaje que atacará
     * @param objetivo El personaje objetivo a atacar
     */
    public void ofensa(Personaje atacante, Personaje objetivo){
        this.danioAEnemigo(atacante, objetivo);
        this.absorberPoder(atacante,objetivo);
    }


    /**
     * Condensa toda la logica de un ataque y elimina de la lista de peleadores
     * al personaje que recibe el daño si su vida se termina durante ese ataque.
     * 
     * @param atacante El personaje que hace el daño del ataque.
     * @param objetivo El personaje que recibe el daño del ataque.
     */
    public void realizarAtaque(Personaje atacante, Personaje objetivo){
        this.ofensa(atacante,objetivo);
        if(objetivo.getAura()<=0){
            System.out.println("¡" + objetivo.getNombre() + " ha sido derrotado por " + atacante.getNombre() + "!");
            System.out.println("¡FUERA AURA!");
            notificarObservadores("¡" + objetivo.getNombre() + " ha sido derrotado por " + atacante.getNombre() + "!");
            notificarObservadores("¡FUERA AURA");
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
        System.out.println();
        System.out.println("La pelea inicia en:");
        System.out.println("3...");
        System.out.println("2...");
        System.out.println("1...");
        System.out.println("¡QUE COMIENCE EL COMBATE, A POR SUS AURAS!");
        notificarObservadores("y...¡ARRANCA LA PELEA, SEÑORES Y SEÑORAS!");

        int rondaActual = 1;
        while (rondaActual <= this.limiteRondas) {
            int sobrevivientes = 0;
            for (Personaje peleador : peleadores) {
                if (peleador.getAura() > 0) {
                    sobrevivientes++;
                }
            }

            if (sobrevivientes <= 1) {
                break;
            }

            if (rondaActual > 1 && (rondaActual - 1) % frecuenciaRecoleccion == 0) {
                for (Personaje peleador : peleadores) {
                    if (peleador.getAura() > 0 && !peleador.getPoderes().isEmpty()) {
                        int indiceAleatorio = random.nextInt(peleador.getPoderes().size());
                        Tupla<ObjetoEspecial, Poder> tupla = peleador.getPoderes().get(indiceAleatorio);
                        this.recogerObjeto(peleador,tupla);
                    }
                }
            }
            System.out.println("\n--- Ronda " + rondaActual + " ---\n");
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

            this.realizarAtaque(atacante,objetivo);
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
                if (ganador == null || peleador.getAura() > ganador.getAura()) {
                    ganador = peleador;
                }
            }
        }

        if (ganador == null && !peleadores.isEmpty()) {
            ganador = peleadores.get(0);
        }
        System.out.println("¡FIN DEL COMBATE!");
        notificarObservadores("¡FIN DEL COMBATE!");

        System.out.println("¡El ganador de la pelea es: " + ganador.getNombre() + "!");
        notificarObservadores("Señores y señoras, tenemos a un ganador, y es... ¡" + ganador.getNombre() + "!");
        return ganador;
    }
}