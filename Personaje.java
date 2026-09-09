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

    /**
     * Equipa un objeto especial junto con su poder e imprime los detalles
     * @param poder La tupla con el objeto especial y el poder a recoger
     */
    public void recogerObjeto(Tupla<ObjetoEspecial,Poder> poder){
        this.setPoderEquipado(poder);
        System.out.println("\n" + this.getNombre() + " tomó " + this.getPoderEquipado().getElemento1().getNombre() + ".");
        System.out.println("Ahora " + this.getNombre() + " tiene " + this.getPoderEquipado().getElemento2().getDescripcion());
    }

    /**
     * Ejecuta un ataque hacia un personaje enemigo, calcula el daño recibido segun las
     * estadisticas de ataque y defensa, reduce el aura del objetivo e imprime los datos del combate
     * @param enemigo El personaje que recibira el ataque
     */
    public void danioAEnemigo(Personaje enemigo){
        
        this.getPoderEquipado().getElemento2().atacar(enemigo);
        int ataquePropio= this.getPoderEquipado().getElemento2().getAtaque();
        int defensaEnemigo= enemigo.getPoderEquipado().getElemento2().getDefensa();
        
        int danio= ataquePropio - defensaEnemigo;

        if(danio<0){
            danio=0;
        }

        int auraEnemigo= enemigo.getAura() - danio;

        if(auraEnemigo<0){
            auraEnemigo=0;
        }

        enemigo.setAura(auraEnemigo);
        
        System.out.println("\n" + enemigo.getNombre() + " recibió un ataque de " + this.getNombre() + ".");
        System.out.println(enemigo.getNombre() + " obtuvo un daño de " + danio + ". Le queda " + enemigo.getAura() + " de aura.");

    }

    /**
     * Absorbe el poder del enemigo si ambos pertenecen a la misma franquicia
     * Si son de distintas franquicias, despliega un mensaje indicando que no es posible
     * @param enemigo El personaje del cual se intentara copiar el poder
     */
    public void absorberPoder(Personaje enemigo){
        if(this.getFranquicia().equalsIgnoreCase(enemigo.getFranquicia())){
            this.setPoderEquipado(enemigo.getPoderEquipado());
            System.out.println(this.getNombre() + " absorbió el poder de " + enemigo.getNombre() + ".");
        } else {
            System.out.println(this.getNombre() + " no puede obtener el poder de " + enemigo.getNombre() + ", ya que no son" + 
            " de la misma franquicia.");
        }

    }

    /**
     * Realiza daño al enemigo y si su aura llega a cero, intenta absorber su poder
     * @param enemigo El personaje objetivo a atacar
     */
    public void ofensa(Personaje enemigo){
        this.danioAEnemigo(enemigo);
        if(enemigo.getAura()<= 0){
            this.absorberPoder(enemigo);
        }
    }

    
    

}