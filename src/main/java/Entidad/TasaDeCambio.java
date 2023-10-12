package Entidad;
public class TasaDeCambio {
    private double tasaDolar;
    private double tasaLempira;
    private double tasaCordoba;
    private double tasaEuro;
    private double tasaQuetzal;
    public TasaDeCambio(double tasaDolar, double tasaLempira, double tasaCordoba, double tasaEuro, double tasaQuetzal) {
        this.tasaDolar = tasaDolar;
        this.tasaLempira = tasaLempira;
        this.tasaCordoba = tasaCordoba;
        this.tasaEuro = tasaEuro;
        this.tasaQuetzal = tasaQuetzal;
    }
    public void setTasaDolar(double tasaDolar) {
        this.tasaDolar = tasaDolar;
    }
    public void setTasaLempira(double tasaLempira) {
        this.tasaLempira = tasaLempira;
    }
    public void setTasaCordoba(double tasaCordoba) {
        this.tasaCordoba = tasaCordoba;
    }
    public void setTasaEuro(double tasaEuro) {
        this.tasaEuro = tasaEuro;
    }
    public void setTasaQuetzal(double tasaQuetzal) {
        this.tasaQuetzal = tasaQuetzal;
    }
    public double getTasaDolar() {
        return tasaDolar;
    }

    public double getTasaLempira() {
        return tasaLempira;
    }

    public double getTasaCordoba() {
        return tasaCordoba;
    }

    public double getTasaEuro() {
        return tasaEuro;
    }
    public double getTasaQuetzal(){
        return tasaQuetzal;
    }
}
