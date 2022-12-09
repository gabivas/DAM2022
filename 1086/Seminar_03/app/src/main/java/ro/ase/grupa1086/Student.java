package ro.ase.grupa1086;

import java.util.Date;
enum FormaInvatamant {CU_FRECVENTA, FARA_FRECVENTA}
enum Facultate {CSIE, Marketing, Management}
public class Student {
    private String nume;
    private Date dataInmatriculare;
    private int varsta;
    private FormaInvatamant formaInvatamant;
    private Facultate facultate;

    public Student(String nume, Date dataInmatriculare, int varsta, FormaInvatamant formaInvatamant, Facultate facultate) {
        this.nume = nume;
        this.dataInmatriculare = dataInmatriculare;
        this.varsta = varsta;
        this.formaInvatamant = formaInvatamant;
        this.facultate = facultate;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Date getDataInmatriculare() {
        return dataInmatriculare;
    }

    public void setDataInmatriculare(Date dataInmatriculare) {
        this.dataInmatriculare = dataInmatriculare;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public FormaInvatamant getFormaInvatamant() {
        return formaInvatamant;
    }

    public void setFormaInvatamant(FormaInvatamant formaInvatamant) {
        this.formaInvatamant = formaInvatamant;
    }

    public Facultate getFacultate() {
        return facultate;
    }

    public void setFacultate(Facultate facultate) {
        this.facultate = facultate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nume='" + nume + '\'' +
                ", dataInmatriculare=" + dataInmatriculare +
                ", varsta=" + varsta +
                ", formaInvatamant=" + formaInvatamant +
                ", facultate=" + facultate +
                '}';
    }
}
