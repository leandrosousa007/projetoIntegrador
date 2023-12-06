package domain;

import java.util.List;

public class Curso{
    
    private Integer codCurso;

    private String nomeCurso;

    private String sigla;

    private List<Turma> turmas;

    public Curso(Integer codCurso, String nomeCurso, String sigla) {
        this.codCurso = codCurso;
        this.nomeCurso = nomeCurso;
        this.sigla = sigla;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
   
    @Override
    public String toString() {
        return "Curso [codCurso=" + codCurso + ", nomeCurso=" + nomeCurso + ", sigla=" + sigla + ", turma=" + turmas +"]";
    }



    


}
