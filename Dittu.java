import java.util.List;
import java.util.ArrayList;

/**
 * Clase que representa al personaje Dittu dentro del juego
 * Hereda de {@link Personaje} y pertenece a la franquicia
 * Sobrescribe la mecánica de ofensa para permitir absorber el poder de su enemigo antes de atacar
 */
public class Dittu extends Personaje{
    public Dittu(){
        super("Dittu","Chinpokomon",100);
        
        ObjetoEspecial mocoDeGorila= new ObjetoEspecial("moco de gorila");
        ObjetoEspecial aguaBonafond= new ObjetoEspecial("agua Bonafond");
        ObjetoEspecial ramitoDeVioleta= new ObjetoEspecial("ramito de violeta");

        PoderEscurrir poderEscurrir= new PoderEscurrir();
        PoderAgua poderAgua= new PoderAgua();
        PoderVegetacion poderVegetacion= new PoderVegetacion();

        Tupla<ObjetoEspecial,Poder> poderDittu1= new Tupla<>(mocoDeGorila,poderEscurrir);
        Tupla<ObjetoEspecial,Poder> poderDittu2= new Tupla<>(aguaBonafond,poderAgua);
        Tupla<ObjetoEspecial,Poder> poderDittu3= new Tupla<>(ramitoDeVioleta,poderVegetacion);

        this.getPoderes().add(poderDittu1);
        this.getPoderes().add(poderDittu2);
        this.getPoderes().add(poderDittu3);
    }


    @Override
    public boolean esAbsorbido(Personaje enemigo){
        System.out.println("Dittu intenta copiar el poder de " + enemigo.getNombre());
        if(this.getFranquicia().equalsIgnoreCase(enemigo.getFranquicia())){
            this.setPoderEquipado(enemigo.getPoderEquipado());
            System.out.println("¡Dittu copió el poder de " + enemigo.getNombre()+ "!");;
            System.out.println("Dittu ahora tiene "+ enemigo.getPoderEquipado().getElemento2().getDescripcion() + ".");
            return true;
        } else{
            System.out.println("Dittu no puede absorber el poder de " + enemigo.getNombre() + ", ya que no son de la misma franquicia.");
            return false;
        }
    }
}