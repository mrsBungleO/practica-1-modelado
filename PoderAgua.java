public class PoderAgua implements Poder{
    
    public final String DESCRIPCION= "poder de agua: Dittu puede manipular grandes volumenes de agua provenientes" + 
    "de Ecatepec para atacar y defenderse.";
    public final int ATAQUE= 18;
    public final int DEFENSA= 3;

    public PoderAgua(){
        
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