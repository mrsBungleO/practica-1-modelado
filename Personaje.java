import java.util.List;
import java.util.ArrayList;

public abstract class Personaje{
    
    private String nombre;
    private String franquicia;
    private List<Tupla<ObjetoEspecial,Poder>> poderes;
    private Tupla<ObjetoEspecial,Poder> poderEquipado;
    private int vida;

    public Personaje(String nombre, String franquicia, int vida){
        this.nombre= nombre;
        this.franquicia= franquicia;
        this.poderes= new ArrayList<>();
        this.poderEquipado= new Tupla<>(new ObjetoEspecial("ningun objeto equipado"), new PoderNulo());
        this.vida= vida;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getFranquicia(){
        return this.franquicia;
    }

    public List<Tupla<ObjetoEspecial,Poder>> getPoderes(){
        return this.poderes;
    }

    public Tupla<ObjetoEspecial,Poder> getPoderEquipado(){
        return this.poderEquipado;
    }

    public int getVida(){
        return this.vida;
    }
    
    public void setPoderEquipado(Tupla<ObjetoEspecial,Poder> poder){
        this.poderEquipado=poder;
    }

    public void setVida(int vida){
        this.vida=vida;
    }

    public void recogerObjeto(Tupla<ObjetoEspecial,Poder> poder){
        this.setPoderEquipado(poder);
        System.out.println("\n" + this.getNombre() + " tomó " + this.getPoderEquipado().getElemento1().getNombre() + ".");
        System.out.println("Ahora " + this.getNombre() + " tiene " + this.getPoderEquipado().getElemento2().getDescripcion());
    }

    public void danioAEnemigo(Personaje enemigo){
        int ataquePropio= this.getPoderEquipado().getElemento2().getAtaque();
        int defensaEnemigo= enemigo.getPoderEquipado().getElemento2().getDefensa();
        
        int danio= ataquePropio - defensaEnemigo;

        if(danio<0){
            danio=0;
        }

        int vidaEnemigo= enemigo.getVida() - danio;

        if(vidaEnemigo<0){
            vidaEnemigo=0;
        }

        enemigo.setVida(vidaEnemigo);
        
        System.out.println("\n" + enemigo.getNombre() + " recibió un ataque de " + this.getNombre() + ".");
        System.out.println(enemigo.getNombre() + " obtuvo un daño de " + danio + ". Le queda " + enemigo.getVida() + " de vida.");

    }

    public void absorberPoder(Personaje enemigo){
        if(this.getFranquicia().equalsIgnoreCase(enemigo.getFranquicia())){
            this.setPoderEquipado(enemigo.getPoderEquipado());
            System.out.println(this.getNombre() + " absorbió el poder de " + enemigo.getNombre() + ".");
        } else {
            System.out.println(this.getNombre() + " no puede obtener el poder de " + enemigo.getNombre() + ", ya que no son" + 
            " de la misma franquicia.");
        }

    }

    public void ofensa(Personaje enemigo){
        this.danioAEnemigo(enemigo);
        if(enemigo.getVida()<= 0){
            this.absorberPoder(enemigo);
        }
    }

    
    

}