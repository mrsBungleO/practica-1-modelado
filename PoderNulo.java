/**
 * Clase que representa el poder nulo o por defecto dentro del juego
 * Se asigna a un personaje cuando este aún no ha equipado ningún objeto especial.
 * Implementa la interfaz {@link Poder}.
 */
public class PoderNulo implements Poder{
    
    /** Descripción textual del poder nulo */
    public final String DESCRIPCION= "poder nulo: aún no ha equipado ningún objeto especial.";

    /** Valor de los puntos de ataque base sin poder equipado */
    public final int ATAQUE=10;

    /** Valor de los puntos de defensa base sin poder equipado */
    public final int DEFENSA=5;

    /**
     * Construye una nueva instancia del poder nulo
     */
    public PoderNulo(){
        
    }

    /**
     * Obtiene la descripción textual del poder nulo
     * @return Cadena con la descripción del poder
     */
    @Override
    public String getDescripcion(){
        return DESCRIPCION;
    }

    /**
     * Obtiene el valor de defensa base que otorga este poder
     * @return Cantidad de puntos de defensa
     */
    @Override
    public int getDefensa(){
        return DEFENSA;
    }

    /**
     * Obtiene el valor de ataque base que otorga este poder
     * @return Cantidad de puntos de ataque
     */
    @Override
    public int getAtaque(){
        return ATAQUE;
    }

    /**
     * Ejecuta un ataque físico básico hacia el personaje enemigo
     * @param enemigo El personaje objetivo que recibe la acción de ataque
     */
    @Override
    public void atacar(Personaje enemigo){
        System.out.println("¡Se lanza golpe a " + enemigo.getNombre() + "!");
    }


}