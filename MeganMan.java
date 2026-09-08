import java.util.List;
import java.util.ArrayList;

public class MeganMan extends Personaje{
    public MeganMan(){
        super("MeganMan", "CopCam", 100);

        ObjetoEspecial nerfOnada= new ObjetoEspecial("pistola Nerf Onada");
        ObjetoEspecial taco= new ObjetoEspecial("taco de futbol llanero");
        ObjetoEspecial robolais= new ObjetoEspecial("Robolais");

        PoderDisparo poderDisparo= new PoderDisparo();
        PoderBarrida poderBarrida= new PoderBarrida();
        PoderMascota poderMascota= new PoderMascota();

        Tupla<ObjetoEspecial,Poder> poderMeganMan1= new Tupla<>(nerfOnada, poderDisparo);
        Tupla<ObjetoEspecial,Poder> poderMeganMan2= new Tupla<>(taco, poderBarrida);
        Tupla<ObjetoEspecial,Poder> poderMeganMan3= new Tupla<>(robolais, poderMascota);

        this.getPoderes().add(poderMeganMan1);
        this.getPoderes().add(poderMeganMan2);
        this.getPoderes().add(poderMeganMan3);
    }
}