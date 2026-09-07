public class PoderNulo implements Poder{
    
    public final String DESCRIPCION= "poder nulo: aún no ha equipado ningún objeto especial.";
    public final int ATAQUE=5;
    public final int DEFENSA=5;

    public PoderNulo(){
        
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