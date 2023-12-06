package domain;

import java.util.List;

public class Funcionario extends Pessoa{
    
private Integer codFuncionario;

private TipoFuncionario tipoFuncionario;

private List<Ocorrencia> Ocorrencias;

public Funcionario(String cpf, String dataNascimento, String email, String telefone, String endereco,
        Integer codFuncionario, TipoFuncionario tipoFuncionario) {
    super(cpf, dataNascimento, email, telefone, endereco);
    this.codFuncionario = codFuncionario;
    this.tipoFuncionario = tipoFuncionario;
}

public Integer getCodFuncionario() {
    return codFuncionario;
}

public void setCodFuncionario(Integer codFuncionario) {
    this.codFuncionario = codFuncionario;
}

public TipoFuncionario getTipo() {
    return tipoFuncionario;
}

public void setTipo(TipoFuncionario tipoFuncionario) {
    this.tipoFuncionario = tipoFuncionario;
}

public List<Ocorrencia> getOcorrencias() {
    return Ocorrencias;
}

public void setOcorrencias(List<Ocorrencia> ocorrencias) {
    Ocorrencias = ocorrencias;
}

@Override
public String toString() {
    return super.toString() + "Funcionario [codFuncionario=" + codFuncionario + ", tipo=" + tipoFuncionario + ", Ocorrencias=" + Ocorrencias + "]";
}


}
