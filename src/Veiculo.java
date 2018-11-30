/**
 *
 * @author Marcel
 */
public class Veiculo implements Comparable<String>{

    private String placa;
    private String modelo;
    private int ano;
    private String proprietario;

    public Veiculo(String pl, String m, int a, String pr) {
        this.placa = pl;
        this.modelo = m;
        this.ano = a;
        this.proprietario = pr;
    }
    
    public Veiculo() {
    	
    }

    @Override
    public String toString() {
        return ("Veículo " + modelo + ",placa " + placa + ",ano " + ano + ", de " + proprietario+"\n");
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public int compareTo(String outro) {
       return (this.getPlaca().compareTo(outro));
    }

    @Override
    public boolean equals(Object obj) {
        return (this.getPlaca().compareTo((String) obj)==0);
    }

}
