/**
 * Clase que representa el poder de mascota dentro del juego
 * Permite que Robolais asista a MeganMan defendiéndolo y atacando a sus oponentes.
 * Implementa la interfaz {@link Poder}
 */
public class PoderMascota implements Poder{
    
    /** Descripción del poder de mascota y sus efectos */
    public final String DESCRIPCION= "poder de mascota: Robolais acude a ayuda de MeganMan. Muerde y ladra a quienes buscan "+ 
    "atacar a su amo.";

    /** Valor de los puntos de ataque que otorga este poder */
    public final int ATAQUE=20;

    /** Valor de los puntos de defensa que otorga este poder */
    public final int DEFENSA=15;

    /**
     * Construye una nueva instancia del poder de mascota
     */
    public PoderMascota(){
        
    }

    /**
     * Obtiene la descripción textual del poder de mascota
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
     * Ejecuta el mensaje de ataque del poder de mascota hacia el enemigo especificado
     * @param enemigo El personaje objetivo que recibe la acción de ataque
     */
    @Override
    public void atacar(Personaje enemigo){
        System.out.println("¡MeganMan manda a Robolais a que muerda a " + enemigo.getNombre() + "!");
    }

}