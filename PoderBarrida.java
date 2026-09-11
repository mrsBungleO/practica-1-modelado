/**
 * Clase que representa el poder de barrida dentro del juego
 * Implementa la interfaz {@link Poder}
 */
public class PoderBarrida implements Poder{

    /** Descripción del poder de barrida y sus efectos */
    public final String DESCRIPCION= "poder de barrida: MeganMan puede barrerse como tu tío en su torneo de futbol llanero "+
    "y tumbar a sus oponentes.";

    /** Valor de los puntos de ataque que otorga este poder */
    public final int ATAQUE=18;

    /** Valor de los puntos de defensa que otorga este poder */
    public final int DEFENSA=12;

    /**
     * Construye una nueva instancia del poder de barrida
     */
    public PoderBarrida(){
        
    }

    /**
     * Obtiene la descripción textual del poder de barrida
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
     * Ejecuta el mensaje de ataque del poder de barrida hacia el enemigo
     * @param enemigo El personaje objetivo que recibe la acción de ataque
     */
    @Override
    public void atacar(Personaje enemigo){
        System.out.println("¡MeganMan se barre en dirección a " + enemigo.getNombre() + " argumentando que fue al balón!");
    }

}