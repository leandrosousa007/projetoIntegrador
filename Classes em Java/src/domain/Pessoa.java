package domain;


public class Pessoa {

    protected String cpf;
    
    protected String dataNascimento;

    protected String email;

    protected String telefone;

    protected String endereco;

    public Pessoa(String cpf, String dataNascimento, String email, String telefone, String endereco) {
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa [cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", email=" + email + ", telefone="
                + telefone + ", endereco=" + endereco + "]";
    }

    

}
