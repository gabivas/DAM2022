package en.ase.grupa1097.util;

import java.io.Serializable;

public class Masina implements Serializable {
    private long id;
    private String marca;
    private double pret;
    private float putere;

    public Masina(long id, String marca, double pret, float putere) {
        this.id = id;
        this.marca = marca;
        this.pret = pret;
        this.putere = putere;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", pret=" + pret +
                ", putere=" + putere +
                '}';
    }
}
