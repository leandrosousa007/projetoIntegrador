package domain;


public class Responsavel extends Pessoa {

    private String nome;

    private Aluno aluno;


    public Responsavel(String cpf, String dataNascimento, String email, String telefone, String endereco, String nome,
            Aluno aluno) {
        super(cpf, dataNascimento, email, telefone, endereco);
        this.nome = nome;
        this.aluno = aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

      public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
    @Override
    public String toString() {
        return super.toString()+ "Responsavel [nome=" + nome + ", aluno=" + aluno + "]";
    }
  
}




