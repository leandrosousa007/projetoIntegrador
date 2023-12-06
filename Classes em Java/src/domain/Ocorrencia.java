package domain;

import java.util.List;

public class Ocorrencia {

    private Integer codOcorrencia;

    private String campus;

    private String dataRegistro;

    private String resolucao;

    private String dataAcontecimento;

    private Aluno aluno;

    private List<Penalidade> penalidades;

    private List<Funcionario> funcionarios;

    public Ocorrencia(Integer codOcorrencia, String campus, String dataRegistro, String resolucao,
            String dataAcontecimento, Aluno aluno) {
        this.codOcorrencia = codOcorrencia;
        this.campus = campus;
        this.dataRegistro = dataRegistro;
        this.resolucao = resolucao;
        this.dataAcontecimento = dataAcontecimento;
        this.aluno = aluno;
    }

    public Integer getCodOcorrencia() {
        return codOcorrencia;
    }

    public void setCodOcorrencia(Integer codOcorrencia) {
        this.codOcorrencia = codOcorrencia;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public String getDataAcontecimento() {
        return dataAcontecimento;
    }

    public void setDataAcontecimento(String dataAcontecimento) {
        this.dataAcontecimento = dataAcontecimento;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Penalidade> getPenalidades() {
        return penalidades;
    }

    public void setPenalidades(List<Penalidade> penalidades) {
        this.penalidades = penalidades;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Ocorrencia [codOcorrencia=" + codOcorrencia + ", campus=" + campus + ", dataRegistro=" + dataRegistro
                + ", resolucao=" + resolucao + ", dataAcontecimento=" + dataAcontecimento + ", aluno=" + aluno
                + ", penalidades=" + penalidades + ", funcionarios=" + funcionarios + "]";
    }

}
