public class PoderDisparo implements Poder{

    public final String DESCRIPCION= "poder de disparo: MeganMan adquiere un arma con la que puede disparar balas o intimidar" +
    " a sus oponentes.";
    public final int ATAQUE=25;
    public final int DEFENSA=10;

    public PoderDisparo(){
        
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