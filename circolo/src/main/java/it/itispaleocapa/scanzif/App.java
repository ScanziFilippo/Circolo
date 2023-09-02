package it.itispaleocapa.scanzif;

public class App 
{
    public static void main( String[] args )
    {
        Soci soci = new Soci();
        soci.aggiungiSocio(new Socio("Filippo", "Scanzi", 18, Sesso.Maschio));
        soci.esportaSuFile();
        soci.aggiungiSocio(new Socio("Giorgio", "Bonacina", 17, Sesso.Maschio));
        System.out.println(soci.toString());
        System.out.println(soci.etaMedia());
        soci.importaDaFile();
        System.out.println(soci.toString());
    }
}
