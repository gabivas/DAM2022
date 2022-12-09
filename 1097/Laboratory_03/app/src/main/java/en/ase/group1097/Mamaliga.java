package en.ase.group1097;

import java.util.Date;
enum TipMamaliga{Mamaliga_cu_branza,
    Mamaliga_cu_smantana,Mamaliga_cu_branza_si_smantana}
enum TipMalai{Malai_Bio,Malai_Economic}
public class Mamaliga {
    private String numeRestaurant;
    private int cantitate;
    private Date dataExpirare;
    private TipMamaliga tipMamaliga;
    private TipMalai tipMalai;

    public Mamaliga(String numeRestaurant, int cantitate, Date dataExpirare, TipMamaliga tipMamaliga, TipMalai tipMalai) {
        this.numeRestaurant = numeRestaurant;
        this.cantitate = cantitate;
        this.dataExpirare = dataExpirare;
        this.tipMamaliga = tipMamaliga;
        this.tipMalai = tipMalai;
    }

    public String getNumeRestaurant() {
        return numeRestaurant;
    }

    public void setNumeRestaurant(String numeRestaurant) {
        this.numeRestaurant = numeRestaurant;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public Date getDataExpirare() {
        return dataExpirare;
    }

    public void setDataExpirare(Date dataExpirare) {
        this.dataExpirare = dataExpirare;
    }

    public TipMamaliga getTipMamaliga() {
        return tipMamaliga;
    }

    public void setTipMamaliga(TipMamaliga tipMamaliga) {
        this.tipMamaliga = tipMamaliga;
    }

    public TipMalai getTipMalai() {
        return tipMalai;
    }

    public void setTipMalai(TipMalai tipMalai) {
        this.tipMalai = tipMalai;
    }

    @Override
    public String toString() {
        return "Mamaliga{" +
                "numeRestaurant='" + numeRestaurant + '\'' +
                ", cantitate=" + cantitate +
                ", dataExpirare=" + dataExpirare +
                ", tipMamaliga=" + tipMamaliga +
                ", tipMalai=" + tipMalai +
                '}';
    }
}
