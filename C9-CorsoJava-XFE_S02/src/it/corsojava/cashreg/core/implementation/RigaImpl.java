package it.corsojava.cashreg.core.implementation;

import it.corsojava.cashreg.core.Riga;
import it.corsojava.cashreg.core.datatypes.specifici.Iva;
import it.corsojava.cashreg.core.datatypes.specifici.Sconto;

public class RigaImpl implements Riga {

    private double prezzoUnitario;
    private Sconto sconto;
    private Iva iva;
    private double quantita;
    private String descrizione;

    protected RigaImpl(){

    }

    @Override
    public void setPrezzoUnitario(double prezzoUnitario){
        this.prezzoUnitario=prezzoUnitario;
    }
    @Override
    public double getPrezzoUnitario(){
        return this.prezzoUnitario;
    }
    @Override
    public void setSconto(Sconto sconto){
        this.sconto=sconto;
    }
    @Override
    public Sconto getSconto(){
        return this.sconto;
    }
    @Override
    public void setIva(Iva iva){
        this.iva=iva;
    }
    @Override
    public Iva getIva(){
        return this.iva;
    }
    @Override
    public void setQuantita(double quantita){
        this.quantita=quantita;
    }
    @Override
    public double getQuantita(){
        return this.quantita;
    }
    @Override
    public String getDescrizione() {
        return this.descrizione;
    }
    @Override
    public void setDescrizione(String descrizione) {
        this.descrizione=descrizione;
    }

    @Override
    public double getPrezzoTotale() {
        double temp=0.0;
        temp=prezzoUnitario * quantita;
        if(this.sconto !=null){
            temp -= this.sconto.calcolaValore(temp);
        }
        if(this.iva!=null){
            temp += this.iva.calcolaValore(temp);
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(quantita);
        sb.append(" X ");
        sb.append(prezzoUnitario);
        sb.append(" - ");
        sb.append(sconto != null ? getSconto().getValue() : 0);
        sb.append("% ");
        if(getIva()!=Iva.IVA_0){
            sb.append(" + ");
            sb.append(getIva());
            sb.append("% ");
        }
        sb.append(" = ");
        sb.append(getPrezzoTotale());
        return sb.toString();
    }

}
