/**
 * Clase que representa el poder de roca dentro del juego
 * Otorga capacidades defensivas y de ataque
 * Implementa la interfaz {@link Poder}
 */
public class PoderRoca implements Poder{


    /** Descripción del poder de roca y sus efectos */
    public final String DESCRIPCION= "poder de roca: Korby puede protegerse de los ataques de su oponente siendo frio y duro " +
     "como una roca y lanzando fragmentos de si mismo a quien quiera hacerle batalla";
    
    /** Valor de los puntos de ataque que otorga este poder */
    public final int ATAQUE=11;

    /** Valor de los puntos de defensa que otorga este poder */
    public final int DEFENSA=20;

    /**
     * Construye una nueva instancia del poder de roca
     */
    public PoderRoca(){
        
    }

    /**
     * Obtiene la descripción textual del poder de roca
     * 
     * @return Cadena con la descripción del poder
     */
    @Override
    public String getDescripcion(){
        return DESCRIPCION;
    }

    /**
     * Obtiene el valor de defensa que otorga este poder
     * 
     * @return Cantidad de puntos de defensa
     */
    @Override
    public int getDefensa(){
        return DEFENSA;
    }

    /**
     * Obtiene el valor de ataque que otorga este poder
     * 
     * @return Cantidad de puntos de ataque
     */
    @Override
    public int getAtaque(){
        return ATAQUE;
    }

    /**
     * Ejecuta el mensaje de ataque del poder de roca hacia el enemigo especificado
     * 
     * @param enemigo El personaje objetivo que recibe la acción de ataque
     */
    @Override
    public void atacar(Personaje enemigo){
        System.out.println("¡Korby piedroso lanza roquitas a " + enemigo.getNombre() + "!");
    }

}