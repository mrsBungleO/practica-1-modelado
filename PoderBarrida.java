public class PoderBarrida implements Poder{

    public final String DESCRIPCION= "poder de barrida: MeganMan puede barrerse como tu tío en su torneo de futbol llanero "+
    "y tumbar a sus oponentes.";
    public final int ATAQUE=18;
    public final int DEFENSA=12;

    public PoderBarrida(){
        
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
    public void atacar(Personaje personaje, Personaje enemigo){
        personaje.danioAEnemigo(enemigo);
    }

}