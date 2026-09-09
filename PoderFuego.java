public class PoderFuego implements Poder{
    
    public final String DESCRIPCION= "poder de fuego: Korby usa su encendedor para escupir llamas como tragafuego en semaforo.";
    public final int ATAQUE=25;
    public final int DEFENSA=0;

    public PoderFuego(){
        
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
        System.out.println("¡Korby lanza una llamarada a " + enemigo.getNombre() + "!");

    }


}