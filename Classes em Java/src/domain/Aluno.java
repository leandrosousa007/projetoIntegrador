package domain;

import java.util.List;

public class Aluno extends Pessoa {

    private String nome;

    private String sexo;

    private String matricula;

    private String rg;

    private List<Responsavel> reponsaveis;

    private List<Ocorrencia> ocorrencias;

    private Turma turma;

    public Aluno(String cpf, String dataNascimento, String email, String telefone, String endereco, String nome,
            String sexo, String matricula, String rg, Turma turma) {
        super(cpf, dataNascimento, email, telefone, endereco);
        this.nome = nome;
        this.sexo = sexo;
        this.matricula = matricula;
        this.rg = rg;
        this.turma = turma;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public List<Responsavel> getReponsaveis() {
        return reponsaveis;
    }

    public void setReponsaveis(List<Responsavel> reponsaveis) {
        this.reponsaveis = reponsaveis;
    }

    public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(List<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return super.toString() + "Aluno [nome=" + nome + ", sexo=" + sexo + ", matricula=" + matricula + ", rg=" + rg + ", reponsaveis="
                + reponsaveis + ", ocorrencias=" + ocorrencias + ", turma=" + turma + "]";
    }

    
}
