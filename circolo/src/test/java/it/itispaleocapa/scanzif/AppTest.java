package it.itispaleocapa.scanzif;

import static org.junit.Assert.assertTrue;
//import it.itispaleocapa.scanzif.*;
import org.junit.Test;

public class AppTest 
{
    @Test
    public void aggiungiSocioTest()
    {
        Soci soci = new Soci();
        soci.aggiungiSocio(new Socio("Filippo", "Scanzi", 18, Sesso.Maschio));
        assertTrue(soci.soci.size() == 1);
        assertTrue(soci.soci.get(0).nome.equals("Filippo"));
        assertTrue(soci.soci.get(0).cognome.equals("Scanzi"));
        assertTrue(soci.soci.get(0).eta == 18);
        assertTrue(soci.soci.get(0).sesso == Sesso.Maschio);
    }
    @Test
    public void rimuoviSocioTest()
    {
        Soci soci = new Soci();
        Socio socio = new Socio("Filippo", "Scanzi", 18, Sesso.Maschio);
        soci.aggiungiSocio(socio);
        assertTrue(soci.soci.size() == 1);
        soci.rimuoviSocio(socio);
        assertTrue(soci.soci.size() == 0);
    }
    @Test
    public void modificaSocioTest(){
        Soci soci = new Soci();
        Socio socio = new Socio("Filippo", "Scanzi", 18, Sesso.Maschio);
        soci.aggiungiSocio(socio);
        assertTrue(soci.soci.size() == 1);
        Socio nuovoSocio = new Socio("Giorgio", "Bonacina", 17, Sesso.Maschio);
        soci.sovrascriviSocio(socio, nuovoSocio);
        assertTrue(soci.soci.size() == 1);
        assertTrue(soci.soci.get(0).nome.equals("Giorgio"));
        assertTrue(soci.soci.get(0).cognome.equals("Bonacina"));
        assertTrue(soci.soci.get(0).eta == 17);
        assertTrue(soci.soci.get(0).sesso == Sesso.Maschio);
    }
    @Test
    public void incrementaEtaTest(){
        Soci soci = new Soci();
        soci.aggiungiSocio(new Socio("Filippo", "Scanzi", 18, Sesso.Maschio));
        soci.aggiungiSocio(new Socio("Giorgio", "Bonacina", 17, Sesso.Maschio));
        soci.incrementaEta();
        assertTrue(soci.soci.get(0).eta == 19);
        assertTrue(soci.soci.get(1).eta == 18);
    }
    @Test
    public void etaMediaTest(){
        Soci soci = new Soci();
        soci.aggiungiSocio(new Socio("Filippo", "Scanzi", 18, Sesso.Maschio));
        soci.aggiungiSocio(new Socio("Giorgio", "Bonacina", 17, Sesso.Maschio));
        assertTrue(soci.etaMedia() == 17.5);
    }
    @Test
    public void etaMediaMaschiTest(){
        Soci soci = new Soci();
        soci.aggiungiSocio(new Socio("Filippo", "Scanzi", 18, Sesso.Maschio));
        soci.aggiungiSocio(new Socio("Giorgio", "Bonacina", 17, Sesso.Maschio));
        soci.aggiungiSocio(new Socio("Giorgia", "Bonacina", 17, Sesso.Femmina));
        assertTrue(soci.etaMediaMaschi() == 17.5);
    }
    @Test
    public void etaMediaFemmineTest(){
        Soci soci = new Soci();
        soci.aggiungiSocio(new Socio("Filippo", "Scanzi", 18, Sesso.Maschio));
        soci.aggiungiSocio(new Socio("Giorgio", "Bonacina", 17, Sesso.Maschio));
        soci.aggiungiSocio(new Socio("Giorgia", "Bonacina", 17, Sesso.Femmina));
        soci.aggiungiSocio(new Socio("Matilde", "Bonacina", 19, Sesso.Femmina));
        assertTrue(soci.etaMediaFemmine() == 18);
    }
    @Test
    public void etaMediaSessiTest(){
        Soci soci = new Soci();
        soci.aggiungiSocio(new Socio("Filippo", "Scanzi", 18, Sesso.Maschio));
        soci.aggiungiSocio(new Socio("Giorgio", "Bonacina", 17, Sesso.Maschio));
        soci.aggiungiSocio(new Socio("Giorgia", "Bonacina", 17, Sesso.Femmina));
        soci.aggiungiSocio(new Socio("Matilde", "Bonacina", 19, Sesso.Femmina));
        double[] etaMediaSessi = soci.etaMediaSessi();
        assertTrue(etaMediaSessi[0] == 17.5);
        assertTrue(etaMediaSessi[1] == 18);
    }
    @Test
    public void distribuzioneMaschiTest(){
        Soci soci = new Soci();
        soci.aggiungiSocio(new Socio("Filippo", "Scanzi", 18, Sesso.Maschio));
        soci.aggiungiSocio(new Socio("Giorgio", "Bonacina", 17, Sesso.Maschio));
        soci.aggiungiSocio(new Socio("Stefano", "Volpi", 18, Sesso.Maschio));
        soci.aggiungiSocio(new Socio("Giorgia", "Bonacina", 17, Sesso.Femmina));
        assertTrue(soci.distribuzioneMaschi() == 0.75);
    }
    @Test
    public void distribuzioneFemmineTest(){
        Soci soci = new Soci();
        soci.aggiungiSocio(new Socio("Giorgia", "Bonacina", 17, Sesso.Femmina));
        soci.aggiungiSocio(new Socio("Matilde", "Bonacina", 19, Sesso.Femmina));
        assertTrue(soci.distribuzioneFemmine() == 1);
    }
    @Test
    public void distribuzioneSessiTest(){
        Soci soci = new Soci();
        soci.aggiungiSocio(new Socio("Filippo", "Scanzi", 18, Sesso.Maschio));
        soci.aggiungiSocio(new Socio("Giorgio", "Bonacina", 17, Sesso.Maschio));
        soci.aggiungiSocio(new Socio("Stefano", "Volpi", 18, Sesso.Maschio));
        soci.aggiungiSocio(new Socio("Giorgia", "Bonacina", 17, Sesso.Femmina));
        double[] distribuzioneSessi = soci.distribuzioneSessi();
        assertTrue(distribuzioneSessi[0] == 0.75);
        assertTrue(distribuzioneSessi[1] == 0.25);
    }
    @Test 
    public void importaEdEsporta(){
        Soci soci = new Soci();
        soci.aggiungiSocio(new Socio("Filippo", "Scanzi", 18, Sesso.Maschio));
        soci.aggiungiSocio(new Socio("Giorgio", "Bonacina", 17, Sesso.Maschio));
        assertTrue(soci.soci.size() == 2);
        soci.esportaSuFile();
        soci.aggiungiSocio(new Socio("Giorgia", "Bonacina", 17, Sesso.Femmina));
        soci.aggiungiSocio(new Socio("Matilde", "Bonacina", 19, Sesso.Femmina));
        assertTrue(soci.soci.size() == 4);
        soci.importaDaFile();
        assertTrue(soci.soci.size() == 2);
        assertTrue(soci.soci.get(0).nome.equals("Filippo"));
        assertTrue(soci.soci.get(0).cognome.equals("Scanzi"));
        assertTrue(soci.soci.get(0).eta == 18);
        assertTrue(soci.soci.get(0).sesso == Sesso.Maschio);
        assertTrue(soci.soci.get(1).nome.equals("Giorgio"));
        assertTrue(soci.soci.get(1).cognome.equals("Bonacina"));
        assertTrue(soci.soci.get(1).eta == 17);
        assertTrue(soci.soci.get(1).sesso == Sesso.Maschio);
    }
}
