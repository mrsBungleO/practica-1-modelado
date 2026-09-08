public class PoderRoca implements Poder{

    public final String DESCRIPCION= "poder de roca: Korby puede protegerse de los ataques de su oponente siendo frio y duro " +
     "como una roca y lanzando fragmentos de si mismo a quien quiera hacerle batalla.";
    public final int ATAQUE=11;
    public final int DEFENSA=20;

    public PoderRoca(){
        
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
        System.out.println("¡Korby piedroso lanza roquitas a " + enemigo.getNombre() + "!");
    }

}