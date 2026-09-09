public class PoderHielo implements Poder{

    public final String DESCRIPCION= "poder de hielo: Korby congela al oponente con su aliento helado olor a horchata.";
    public final int ATAQUE= 20;
    public final int DEFENSA= 3;

    public PoderHielo(){

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
        System.out.println("¡Korby sopla hacia " + enemigo.getNombre() + "!");
    }

}