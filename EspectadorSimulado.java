import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Representa a un espectador en la audiencia que sigue la transmision
 * del combate y registra los eventos en su bitacora personal.
 */
public class EspectadorSimulado implements Observador {

    private String idEspectador;
    private Personaje personajeFavorito;
    private File bitacora;

    /**
     * Inicializa a un espectador con su identificador unico y su personaje predilecto.
     *
     * @param idEspectador Identificador de la entidad espectadora.
     * @param personajeFavorito Personaje al que apoya durante el combate.
     */
    public EspectadorSimulado(String idEspectador, Personaje personajeFavorito) {
        this.idEspectador = idEspectador;
        this.personajeFavorito = personajeFavorito;
        this.bitacora = new File(idEspectador + "_bitacora.txt");
    }

    /**
     * Recibe los acontecimientos transmitidos por el combate y los guarda en su bitacora.
     *
     * @param evento Descripcion del suceso recibido.
     */
    @Override
    public void actualizar(String evento) {
        escribirEnBitacora("[" + idEspectador + "] " + evento);

        /**
         * Reaccion personalizada segun si su candidato gano o perdio.
         */
        if (evento.contains("El ganador de la pelea es:")) {
            if (evento.contains(personajeFavorito.getNombre())) {
                escribirEnBitacora("Mi personaje apoyado (" 
                        + personajeFavorito.getNombre() + ") ha ganado el combate.");
            } else {
                escribirEnBitacora("Mi personaje apoyado (" 
                        + personajeFavorito.getNombre() + ") ha perdido su aura.");
            }
        }
    }

    /**
     * Escribe una linea de texto en el archivo de bitacora del espectador.
     *
     * @param texto Mensaje a registrar.
     */
    public void escribirEnBitacora(String texto) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(bitacora, true))) {
            writer.println(texto);
        } catch (IOException ex) {
            System.err.println("Error al escribir la bitacora de " + idEspectador);
        }
    }
}