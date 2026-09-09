/**
 * Clase que representa el poder de hielo dentro del juego
 * Permite a Korby atacar
 * Implementa la interfaz {@link Poder}
 */
public class PoderHielo implements Poder{

    /** Descripción del poder de hielo y sus efectos */
    public final String DESCRIPCION= "poder de hielo: Korby congela al oponente con su aliento helado olor a horchata.";
    
    /** Valor de los puntos de ataque que otorga este poder */
    public final int ATAQUE= 20;

    /** Valor de los puntos de defensa que otorga este poder */
    public final int DEFENSA= 3;

    /**
     * Construye una nueva instancia del poder de hielo
     */
    public PoderHielo(){

    }

    /**
     * Obtiene la descripción textual del poder de hielo
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
     * Ejecuta el mensaje de ataque del poder de hielo hacia el enemigo especificado
     * @param enemigo El personaje objetivo que recibe la acción de ataque
     * 
     */
    @Override
    public void atacar(Personaje enemigo){
        System.out.println("¡Korby sopla hacia " + enemigo.getNombre() + "!");
    }

}