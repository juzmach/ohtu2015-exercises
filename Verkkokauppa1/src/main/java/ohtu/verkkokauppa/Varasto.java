package ohtu.verkkokauppa;

/**
 * Created by juzmach on 3/22/15.
 */
public interface Varasto {
    Tuote haeTuote(int id);

    int saldo(int id);

    void otaVarastosta(Tuote t);

    void palautaVarastoon(Tuote t);

}
