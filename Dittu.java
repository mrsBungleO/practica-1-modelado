import java.util.List;
import java.util.ArrayList;

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
}