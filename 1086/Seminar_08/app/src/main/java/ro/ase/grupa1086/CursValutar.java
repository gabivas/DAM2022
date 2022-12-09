package ro.ase.grupa1086;

public class CursValutar {

    private String dateConcatenate;

    public CursValutar() {
    }

    public void setDateConcatenate(String dateConcatenate) {
        this.dateConcatenate = dateConcatenate;
    }

    @Override
    public String toString() {
        return "CursValutar{" +
                "dateConcatenate='" + dateConcatenate + '\'' +
                '}';
    }
}