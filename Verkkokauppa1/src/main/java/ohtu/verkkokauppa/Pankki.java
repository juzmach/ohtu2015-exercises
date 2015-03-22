package ohtu.verkkokauppa;

/**
 * Created by juzmach on 3/22/15.
 */
public interface Pankki {
    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}
