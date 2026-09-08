import java.util.List;
import java.util.ArrayList;

public class Korby extends Personaje{
    
    public Korby(){
        super("Korby", "Nientiendo",100);

        ObjetoEspecial encendedorTokai= new ObjetoEspecial("encendedor Tokai");
        ObjetoEspecial boliDeHorchata= new ObjetoEspecial("boli de horchata");
        ObjetoEspecial tabique= new ObjetoEspecial("tabique");

        PoderFuego poderFuego= new PoderFuego();
        PoderHielo poderHielo= new PoderHielo();
        PoderRoca poderRoca= new PoderRoca();

        Tupla<ObjetoEspecial,Poder> poderKorby1= new Tupla<>(encendedorTokai,poderFuego);
        Tupla<ObjetoEspecial,Poder> poderKorby2= new Tupla<>(boliDeHorchata,poderHielo);
        Tupla<ObjetoEspecial,Poder> poderKorby3= new Tupla<>(tabique,poderRoca);

        this.getPoderes().add(poderKorby1);
        this.getPoderes().add(poderKorby2);
        this.getPoderes().add(poderKorby3);
        

    }
}