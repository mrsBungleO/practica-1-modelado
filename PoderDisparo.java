/**
 * Clase que representa el poder de disparo dentro del juego
 * Otorga un arma a MeganMan 
 * Implementa la interfaz {@link Poder}
 */
public class PoderDisparo implements Poder{

    /** Descripción del poder de disparo y sus efectos */
    public final String DESCRIPCION= "poder de disparo: MeganMan adquiere un arma con la que puede disparar balas o intimidar" +
    " a sus oponentes.";
    
    /** Valor de los puntos de ataque que otorga este poder */
    public final int ATAQUE=25;

    /** Valor de los puntos de defensa que otorga este poder */
    public final int DEFENSA=10;

    /**
     * Construye una nueva instancia del poder de disparo
     */
    public PoderDisparo(){
        
    }

    /**
     * Obtiene la descripción textual del poder de disparo
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
     * Ejecuta el mensaje de ataque del poder de disparo hacia el enemigo
     * @param enemigo El personaje objetivo que recibe la acción de ataque
     */
    @Override
    public void atacar(Personaje enemigo){
        System.out.println("¡MeganMan tira balazos locos a " + enemigo.getNombre() + "!");
    }

}