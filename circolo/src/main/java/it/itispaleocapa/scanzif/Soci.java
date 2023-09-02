package it.itispaleocapa.scanzif;
import java.io.*;
import java.util.*;

public class Soci {
    LinkedList<Socio> soci;

    public Soci() {
        soci = new LinkedList<Socio>();
    }
    
    public String toString() {
        return soci.stream().reduce("", (acc, socio) -> acc + socio.nome + " " + socio.cognome + " " + socio.eta + " " + socio.sesso + "\n", (acc, socio) -> acc + socio);
    }
    public void aggiungiSocio(Socio socio) {
        soci.add(socio);
    }
    public void rimuoviSocio(Socio socio) {
        soci.remove(socio);
    }
    public void sovrascriviSocio(Socio socio, Socio nuovoSocio) {
        soci.set(soci.indexOf(socio), nuovoSocio);
    }
    public void incrementaEta() {
        soci.stream().forEach(socio -> socio.eta++);
    }
    public double etaMedia() {
        return soci.stream().mapToDouble(socio -> socio.eta).average().getAsDouble();
    }
    public double etaMediaMaschi() {
        return soci.stream().filter(socio -> socio.sesso == Sesso.Maschio).mapToDouble(socio -> socio.eta).average().getAsDouble();
    }
    public double etaMediaFemmine() {
        return soci.stream().filter(socio -> socio.sesso == Sesso.Femmina).mapToDouble(socio -> socio.eta).average().getAsDouble();
    }
    public double[] etaMediaSessi(){
        double[] etaMediaSessi = new double[2];
        etaMediaSessi[0] = 0;
        etaMediaSessi[1] = 0;
        int[] numeroSessi = new int[2];
        numeroSessi[0] = 0;
        numeroSessi[1] = 0;
        for (Socio socio : soci) {
            if (socio.sesso == Sesso.Maschio) {
                etaMediaSessi[0] += socio.eta;
                numeroSessi[0]++;
            } else {
                etaMediaSessi[1] += socio.eta;
                numeroSessi[1]++;
            }
        }
        etaMediaSessi[0] /= numeroSessi[0];
        etaMediaSessi[1] /= numeroSessi[1];
        return etaMediaSessi;
    }
    public double distribuzioneMaschi(){
        return (double) soci.stream().filter(socio -> socio.sesso == Sesso.Maschio).count() / soci.size();
    }
    public double distribuzioneFemmine(){
        return (double) soci.stream().filter(socio -> socio.sesso == Sesso.Femmina).count() / soci.size();
    }
    public double[] distribuzioneSessi(){
        double[] distribuzioneSessi = new double[2];
        distribuzioneSessi[0] = 0;
        distribuzioneSessi[1] = 0;
        for (Socio socio : soci) {
            if (socio.sesso == Sesso.Maschio) {
                distribuzioneSessi[0]++;
            } else {
                distribuzioneSessi[1]++;
            }
        }
        distribuzioneSessi[0] /= soci.size();
        distribuzioneSessi[1] /= soci.size();
        return distribuzioneSessi;
    }
    public void esportaSuFile(){
        try {
            FileWriter fileWriter = new FileWriter("soci.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Socio socio : soci) {
                printWriter.println(socio.nome + " " + socio.cognome + " " + socio.eta + " " + socio.sesso);
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void importaDaFile(){
        soci.clear();
        try {
            FileReader fileReader = new FileReader("soci.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] socio = line.split(" ");
                aggiungiSocio(new Socio(socio[0], socio[1], Integer.parseInt(socio[2]), Sesso.valueOf(socio[3])));
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}