public class PoderVegetacion implements Poder{
    
    public final String DESCRIPCION= "poder de vegetación: Dittu puede construir grandes barreras de violetas para su defensa.";
    public final int ATAQUE=10;
    public final int DEFENSA=22;

    public PoderVegetacion(){
        
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
        System.out.println("¡Dittu le manda un ramito de violetas a " + enemigo.getNombre() + "!");
    }

}