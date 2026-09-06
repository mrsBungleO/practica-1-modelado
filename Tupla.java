public class Tupla<A,B>{
    private A elemento1;
    private B elemento2;

    public Tupla(A elemento1, B elemento2){
        this.elemento1=elemento1;
        this.elemento2=elemento2;
    }

    public A getElemento1(){
        return this.elemento1;
    }

    public B getElemento2(){
        return this.elemento2;
    }

}