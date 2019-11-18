import java.time.LocalDate;

public class Homicidio {

    private LocalDate dataFalecimento;
    private String nome;
    private String sexo;
    private String objeto_utilizado;
    private String minicipio;
    private int idade;
    private String natureza;
    private int totalVitimas;

    public Homicidio(LocalDate dataFalecimento, String nome, String sexo, String objeto_utilizado, String minicipio, int idade, String natureza, int totalVitimas) {
        this.dataFalecimento = dataFalecimento;
        this.nome = nome;
        this.sexo = sexo;
        this.objeto_utilizado = objeto_utilizado;
        this.minicipio = minicipio;
        this.idade = idade;
        this.natureza = natureza;
        this.totalVitimas = totalVitimas;
    }

    public LocalDate getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(LocalDate dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObjeto_utilizado() {
        return objeto_utilizado;
    }

    public void setObjeto_utilizado(String objeto_utilizado) {
        this.objeto_utilizado = objeto_utilizado;
    }

    public String getMinicipio() {
        return minicipio;
    }

    public void setMinicipio(String minicipio) {
        this.minicipio = minicipio;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public int getTotalVitimas() {
        return totalVitimas;
    }

    public void setTotalVitimas(int totalVitimas) {
        this.totalVitimas = totalVitimas;
    }

    @Override
    public String toString() {
        return dataFalecimento  + "  " + nome + "  " + sexo + "  " + objeto_utilizado + "  " + minicipio + "  " + idade + "  " + natureza + "  " + totalVitimas + "\n";
    }
}
