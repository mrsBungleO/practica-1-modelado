/**
 * Clase que representa el poder de agua dentro del juego
 * Permite a Dittu atacar y defenderse
 * Implementa la interfaz {@link Poder}
 */
public class PoderAgua implements Poder{
    
    /** Descripción del poder de agua y sus efectos */
    public final String DESCRIPCION= "poder de agua: Dittu puede manipular grandes volumenes de agua provenientes" + 
    " de Ecatepec para atacar y defenderse.";

    /** Valor de los puntos de ataque que otorga este poder */
    public final int ATAQUE= 18;

    /** Valor de los puntos de defensa que otorga este poder */
    public final int DEFENSA= 3;

    /**
     * Construye una nueva instancia del poder de agua
     */
    public PoderAgua(){
        
    }

    /**
     * Obtiene la descripción textual del poder de agua
     * @return Cadena con la descripción del poder
     */
    @Override
    public String getDescripcion(){
        return DESCRIPCION;
    }

    /**
     * Obtiene el valor de defensa que otorga este podee
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
     * Ejecuta el mensaje de ataque del poder de agua hacia el enemigo
     * @param enemigo El personaje objetivo que recibe la acción de ataque
     */
    @Override
    public void atacar(Personaje enemigo){
        System.out.println("Dittu toma la poca agua potable de Ecatepec y la manipula para que lastime a " + enemigo.getNombre() + "!");
    }

}