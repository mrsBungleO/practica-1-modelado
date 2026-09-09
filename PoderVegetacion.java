/**
 * Clase que representa el poder de vegetación dentro del juego
 * Implementa la interfaz {@link Poder}.
 */
public class PoderVegetacion implements Poder{
    
   /** Descripción del poder de vegetación y su efecto defensivo */
    public final String DESCRIPCION= "poder de vegetación: Dittu puede construir grandes barreras de violetas para su defensa.";
    
    /** Valor de los puntos de ataque que otorga este poder*/
    public final int ATAQUE=10;

    /** Valor de los puntos de defensa que otorga este poder */
    public final int DEFENSA=22;

    /**
     * Construye una nueva instancia del poder de vegetacion
     */
    public PoderVegetacion(){
        
    }

    /**
     * Obtiene la descripción textual del poder de vegetación
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
     * Ejecuta el mensaje de ataque del poder de vegetaciom hacia el enemigo especificado
     * @param enemigo El personaje objetivo que recibe la acción de ataque
     */
    @Override
    public void atacar(Personaje enemigo){
        System.out.println("¡Dittu le manda un ramito de violetas a " + enemigo.getNombre() + "!");
    }

}