/**
 * Interfaz que define lo que un personaje puede equipar y utilizar.
 * Establece los métodos para obtener las estadísticas de ataque, defensa,
 * la descripción del poder y la ejecución de la acción de ataque
 */
public interface Poder{

    /**
     * Obtiene la descripción del poder y sus efectos
     * @return Cadena con la descripción del poder
     */
    public String getDescripcion();
    
    /**
     * Obtiene los puntos de defensa que otorga este poder
     * @return Cantidad de puntos de defensa
     */
    public int getDefensa();

    /**
     * Obtiene los puntos de ataque que otorga este poder
     * @return Cantidad de puntos de ataque
     */
    public int getAtaque();
    
    /**
     * Ejecuta la acción de ataque del poder hacia un personaje enemigo
     * @param enemigo El personaje que recibirá el ataque
     */
    public void atacar(Personaje enemigo);
    
}