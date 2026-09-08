/**
 * Esta clase define las operaciones necesarias para que un objeto pueda funcionar
 * como sujeto dentro de nuestro patron Observer.
 *
 * Un sujeto mantiene una lista de observadores interesados en recibir
 * informacion sobre los eventos que ocurren en el. En esta practica,
 * el sujeto sera el combate, ya que es quien conoce lo que sucede
 * durante la pelea y puede avisarle a los espectadores.
 */
public interface Sujeto {

    /**
     * Agrega un observador a la lista de personas que recibiran
     * las actualizaciones del combate.
     *
     * @param observador objeto que desea recibir los eventos
     *                   generados durante el combate
     */
    void registrarObservador(Observador observador);

    /**
     * Quita un observador de la lista. Despues de realizar esta operacion,
     * el observador dejara de recibir las notificaciones que genere
     * el sujeto.
     *
     * @param observador observador que ya no desea recibir actualizaciones
     */
    void removerObservador(Observador observador);

    /**
     * Envia a todos los observadores registrados la informacion sobre
     * algun evento que haya ocurrido en el sujeto.
     *
     * @param evento descripcion del acontecimiento que se desea transmitir
     */
    void notificarObservadores(String evento);
}