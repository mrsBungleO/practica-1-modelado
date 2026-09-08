public class PoderMascota implements Poder{
    
    public final String DESCRIPCION= "poder de mascota: Robolais acude a ayuda de MeganMan. Muerde y ladra a quienes buscan "+ 
    "atacar a su amo.";
    public final int ATAQUE=20;
    public final int DEFENSA=15;

    public PoderMascota(){
        
    }

    @Override
    public String getDescripcion(){
        return DESCRIPCION;
    }

    @Override
    public int getDefensa(){
        return DEFENSA;
    }

    @Override
    public int getAtaque(){
        return ATAQUE;
    }

    @Override
    public void atacar(Personaje enemigo){
        System.out.println("¡MeganMan manda a Robolais a que muerda a " + enemigo.getNombre() + "!");
    }

}