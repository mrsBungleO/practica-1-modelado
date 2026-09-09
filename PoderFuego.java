/**
 * Clase que representa el poder de fuego dentro del juego
 * Otorga un alto valor de ataque ofensivo sin aportar defensa
 * Implementa la interfaz {@link Poder}
 */
public class PoderFuego implements Poder{
    
    /** Descripción del poder de fuego y sus efectos */
    public final String DESCRIPCION= "poder de fuego: Korby usa su encendedor para escupir llamas como tragafuego en semaforo.";
    
    /** Valor de los puntos de ataque que otorga este poder */
    public final int ATAQUE=25;

    /** Valor de los puntos de defensa que otorga este poder */
    public final int DEFENSA=0;

    /**
     * Construye una nueva instancia del poder de fuego
     */
    public PoderFuego(){
        
    }

    /**
     * Obtiene la descripción textual del poder de fuego
     * @return Cadena con la descripcionn del poder
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
     * Ejecuta el mensaje de ataque del poder de fuego hacia el enemigo
     * @param enemigo El personaje objetivo que recibe la acción de ataque
     */
    @Override
    public void atacar(Personaje enemigo){
        System.out.println("¡Korby lanza una llamarada a " + enemigo.getNombre() + "!");

    }


}