package ro.ase.grupa1086;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sport")
public class Sport {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String denumire;
    private String dificultate;
    private String nrTitulari;
    private String numeStadion;

    public Sport(String denumire, String dificultate, String nrTitulari, String numeStadion) {
        //this.id = id;
        this.denumire = denumire;
        this.dificultate = dificultate;
        this.nrTitulari = nrTitulari;
        this.numeStadion = numeStadion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getDificultate() {
        return dificultate;
    }

    public void setDificultate(String dificultate) {
        this.dificultate = dificultate;
    }

    public String getNrTitulari() {
        return nrTitulari;
    }

    public void setNrTitulari(String nrTitulari) {
        this.nrTitulari = nrTitulari;
    }

    public String getNumeStadion() {
        return numeStadion;
    }

    public void setNumeStadion(String numeStadion) {
        this.numeStadion = numeStadion;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", dificultate='" + dificultate + '\'' +
                ", nrTitulari='" + nrTitulari + '\'' +
                ", numeStadion='" + numeStadion + '\'' +
                '}';
    }
}
