package domain;

public class Penalidade {
    
    private Integer codPenalidade;

    private TipoPenalidade tipoPenalidade;

    private String quantidadeDias;

    private String dataInicio;

    private Ocorrencia ocorrencia;

    public Penalidade(Integer codPenalidade, TipoPenalidade tipoPenalidade, String quantidadeDias, String dataInicio,
            Ocorrencia ocorrencia) {
        this.codPenalidade = codPenalidade;
        this.tipoPenalidade = tipoPenalidade;
        this.quantidadeDias = quantidadeDias;
        this.dataInicio = dataInicio;
        this.ocorrencia = ocorrencia;
    }

    public Integer getCodPenalidade() {
        return codPenalidade;
    }

    public void setCodPenalidade(Integer codPenalidade) {
        this.codPenalidade = codPenalidade;
    }

    public TipoPenalidade getTipoPenalidade() {
        return tipoPenalidade;
    }

    public void setTipoPenalidade(TipoPenalidade tipoPenalidade) {
        this.tipoPenalidade = tipoPenalidade;
    }

    public String getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(String quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    @Override
    public String toString() {
        return "Penalidade [codPenalidade=" + codPenalidade + ", tipoPenalidade=" + tipoPenalidade + ", quantidadeDias="
                + quantidadeDias + ", dataInicio=" + dataInicio + ", ocorrencia=" + ocorrencia + "]";
    }

    
}
