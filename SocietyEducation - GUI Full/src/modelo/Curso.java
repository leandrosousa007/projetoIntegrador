package modelo;


public class Curso{
    private int cod_curso;
    private String sigla;
    private String nome_curso;

    public int getCod_curso() {
        return cod_curso;
    }

    public void setCod_curso(int cod_curso) {
        this.cod_curso = cod_curso;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public Curso() {
    }

    public Curso(int cod_curso) {
        this.cod_curso = cod_curso;
    }

    public Curso(int cod_curso, String sigla, String nome_curso) {
        this.cod_curso = cod_curso;
        this.sigla = sigla;
        this.nome_curso = nome_curso;
    }
    
    
 
    }