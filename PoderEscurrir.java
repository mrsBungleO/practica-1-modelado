/**
 * Clase que representa el poder de escurrimiento dentro del juego
 * Permite a Dittu defenderse
 * Implementa la interfaz {@link Poder}
 */
public class PoderEscurrir implements Poder{

    /** Descripción del poder de escurrimiento y sus efectos */
    public final String DESCRIPCION= "poder de escurrimiento: Dittu se vuelve una masa escurridiza que hace imposible a sus " +
    "enemigos atacarlo.";
    
    /** Valor de los puntos de ataque que otorga este poder */
    public final int ATAQUE= 10;

    /** Valor de los puntos de defensa que otorga este poder */
    public final int DEFENSA= 25;

    /**
     * Construye una nueva instancia del poder de escurrimiento
     */
    public PoderEscurrir(){
        
    }

    /**
     * Obtiene la descripción textual del poder de escurrimiento
     * @return Cadena con la descripción del poder
     */
    @Override
    public String getDescripcion(){
        return DESCRIPCION;
    }

    /**
     * Obtiene el valor de defensa que otorga este poder
     * @return Cantidad de puntos de defensa
     */
    @Override
    public int getDefensa(){
        return DEFENSA;
    }

    /**
     * Obtiene el valor de ataque que otorga este poder
     * @return Cantidad de puntos de ataque
     */
    @Override
    public int getAtaque(){
        return ATAQUE;
    }

    /**
     * Ejecuta el mensaje de ataque del poder de escurrimiento hacia el enemigo
     * @param enemigo El personaje objetivo que recibe la acción de ataque
     */
    @Override
    public void atacar(Personaje enemigo){
        System.out.println("¡Dittu esquiva que esquiva y tira golpes a " + enemigo.getNombre() + "!");
    }

}