public class PoderEscurrir implements Poder{

    public final String DESCRIPCION= "poder de escurrimiento: Dittu se vuelve una masa escurridiza que hace imposible a sus " +
    "enemigos atacarlo.";
    public final int ATAQUE= 0;
    public final int DEFENSA= 25;

    public PoderEscurrir(){
        
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