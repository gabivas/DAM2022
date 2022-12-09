package en.ase.group1097;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "companie")
public class Companie {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String denumire;
    private String dataInfiintare;
    private String nrAngajati;
    private String locatie;
    private String nrDepartamente;

    public Companie(String denumire, String dataInfiintare, String nrAngajati, String locatie, String nrDepartamente) {
        this.denumire = denumire;
        this.dataInfiintare = dataInfiintare;
        this.nrAngajati = nrAngajati;
        this.locatie = locatie;
        this.nrDepartamente = nrDepartamente;
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

    public String getDataInfiintare() {
        return dataInfiintare;
    }

    public void setDataInfiintare(String dataInfiintare) {
        this.dataInfiintare = dataInfiintare;
    }

    public String getNrAngajati() {
        return nrAngajati;
    }

    public void setNrAngajati(String nrAngajati) {
        this.nrAngajati = nrAngajati;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getNrDepartamente() {
        return nrDepartamente;
    }

    public void setNrDepartamente(String nrDepartamente) {
        this.nrDepartamente = nrDepartamente;
    }

    @Override
    public String toString() {
        return "Companie{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", dataInfiintare='" + dataInfiintare + '\'' +
                ", nrAngajati='" + nrAngajati + '\'' +
                ", locatie='" + locatie + '\'' +
                ", nrDepartamente='" + nrDepartamente + '\'' +
                '}';
    }
}
