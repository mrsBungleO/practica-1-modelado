public interface Poder{

    public String getDescripcion();
    
    public int getDefensa();

    public int getAtaque();
    
    public void atacar(Personaje personaje, Personaje enemigo);
    
}