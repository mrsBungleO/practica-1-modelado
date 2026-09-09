/**
 * Clase que representa un objeto especial en el juego
 * Sirve para almacenar la información de los objetos que los personajes pueden recoger o equipar.
 */
public class ObjetoEspecial{

    /** Nombre del objeto especial */
    private String nombre;

    /**
     * Construye un nuevo objeto especial con el nombre especificado
     * @param nombre El nombre del objeto especial
     */
    public ObjetoEspecial(String nombre){
        this.nombre=nombre;
    }

    /**
     * Obtiene el nombre del objeto especial
     * @return El nombre del objeto especial
     */
    public String getNombre(){
        return this.nombre;
    }
}