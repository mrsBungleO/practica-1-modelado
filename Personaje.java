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
        this.poderEquipado= new Tupla<>(new ObjetoEspecial(), new PoderNulo());
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

    

}