import java.util.List;
import java.util.ArrayList;

/**
 * Clase abstracta que representa a un personaje dentro del simulador de combate.
 * Define las propiedades base como nombre, franquicia, aura y poder equipado,
 * asi como las acciones de ataque, recoleccion de objetos y absorcion de habilidades.
 */
public abstract class Personaje{

    /** Nombre del personaje */
    private String nombre;

    /** Franquicia a la que pertenece el personaje */
    private String franquicia;

    /** Lista de combinaciones de objetos especiales y poderes disponibles */
    private List<Tupla<ObjetoEspecial,Poder>> poderes;

    /** Tupla que contiene el objeto especial y el poder actualmente equipado */
    private Tupla<ObjetoEspecial,Poder> poderEquipado;

    /** Puntos de aura (vida) del personaje */
    private int aura;

    /**
     * Crea un nuevo personaje con su nombre, franquicia y cantidad de aura base
     * Inicializa su lista de poderes vacia y su poder equipado con un poder nulo
     *
     * @param nombre El nombre del personaje
     * @param franquicia La franquicia de origen del personaje
     * @param aura La cantidad inicial de puntos de aura
     */
    public Personaje(String nombre, String franquicia, int aura){
        this.nombre= nombre;
        this.franquicia= franquicia;
        this.poderes= new ArrayList<>();
        this.poderEquipado= new Tupla<>(new ObjetoEspecial("ningun objeto equipado"), new PoderNulo());
        this.aura= aura;
    }

    /**
     * Obtiene el nombre del personaje
     * @return El nombre del personaje
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Obtiene la franquicia a la que pertenece el personaje
     * @return Nombre de la franquicia
     */
    public String getFranquicia(){
        return this.franquicia;
    }

    /**
     * Obtiene la lista de tuplas con los objetos y poderes del personaje
     * @return Lista de poderes disponibles
     */
    public List<Tupla<ObjetoEspecial,Poder>> getPoderes(){
        return this.poderes;
    }

    /**
     * Obtiene la tupla del objeto especial y poder actualmente equipado
     * @return Tupla con el poder y objeto equipado
     */
    public Tupla<ObjetoEspecial,Poder> getPoderEquipado(){
        return this.poderEquipado;
    }

    /**
     * Obtiene la cantidad actual de puntos de aura (vida) del personaje
     * @return Cantidad de aura restante
     */
    public int getAura(){
        return this.aura;
    }
    
    /**
     * Asigna la tupla del objeto especial y poder equipado al personaje
     * @param poder La tupla con el objeto especial y poder a equipar
     */
    public void setPoderEquipado(Tupla<ObjetoEspecial,Poder> poder){
        this.poderEquipado=poder;
    }

    /**
     * Actualiza la cantidad de puntos de aura del personaje
     * @param aura La nueva cantidad de aura
     */
    public void setAura(int aura){
        this.aura=aura;
    }

    public abstract int esAbsorbido(Personaje enemigo);


}