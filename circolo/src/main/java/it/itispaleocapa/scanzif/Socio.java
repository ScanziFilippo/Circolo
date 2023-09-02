package it.itispaleocapa.scanzif;

public class Socio {
    String nome;
    String cognome;
    int eta;
    Sesso sesso;

    public Socio(String nome, String cognome, int eta, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.sesso = sesso;
    }
}
enum Sesso {
    Maschio, Femmina
};
