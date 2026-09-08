public class Combate{
    public static void main(String[] args){
        Korby korby= new Korby();
        Dittu dittu= new Dittu();
        MeganMan meganMan= new MeganMan();

        Tupla<ObjetoEspecial, Poder> poderKorby = korby.getPoderes().get(0);
        Tupla<ObjetoEspecial, Poder> poderDittu = korby.getPoderes().get(0);
        Tupla<ObjetoEspecial, Poder> poderMeganMan = korby.getPoderes().get(0);

        dittu.ofensa(korby);
        korby.recogerObjeto(poderKorby);
        korby.ofensa(meganMan);
        
    }
}