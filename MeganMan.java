import java.util.List;
import java.util.ArrayList;

/**
 * Clase que representa al personaje MeganMan dentro del juego
 * Hereda de {@link Personaje} y pertenece a la franquicia CopCam
 */
public class MeganMan extends Personaje{

    /**
     * Construye e inicializa una nueva instancia de MeganMan
     * Configura su nombre, franquicia, 100 puntos de aura iniciales
     * y añade a su lista de poderes la pistola Nerf, el taco de fútbol y su mascota Robolais.
     */
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

    @Override
    public int esAbsorbido(Personaje enemigo){
        if(enemigo.getAura()==0){
             System.out.println("MeganMan intenta copiar el poder de " + enemigo.getNombre());
            if(this.getFranquicia().equalsIgnoreCase(enemigo.getFranquicia())){
                this.setPoderEquipado(enemigo.getPoderEquipado());
                System.out.println("¡MeganMan copió el poder de " + enemigo.getNombre()+ "!");;
                System.out.println("MeganMan ahora tiene "+ enemigo.getPoderEquipado().getElemento2().getDescripcion() + ".");
                return 1;
            } else{
                System.out.println("MeganMan no puede equipar el poder de " + enemigo.getNombre() + ", ya que no son de la misma franquicia.");
                return 0;
            }
        } else { 
            return 2;
        }
        
    }
}