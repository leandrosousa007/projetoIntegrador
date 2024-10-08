package controle;

import conexao.ConexaoMySQL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Aluno;
import modelo.Curso;
import modelo.Responsavel;

public class AlunoControle {

    public static void main(String[] args) {
        // Código para testes, se necessário
    }

    public Aluno consultarAlunoPorCodigo(int codAluno) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Aluno aluno = new Aluno();

        try (Connection conn = conexao.conectar();
             PreparedStatement stm = conn.prepareStatement("SELECT * FROM Aluno WHERE cod_aluno = ?")) {
            stm.setInt(1, codAluno);

            try (ResultSet resultado = stm.executeQuery()) {
                if (resultado.next()) {
                    aluno.setCod_aluno(resultado.getInt("cod_aluno"));
                    aluno.setMatricula(resultado.getString("matricula"));
                    aluno.setNome(resultado.getString("nome"));
                    aluno.setRg(resultado.getString("rg"));
                    aluno.setEmail(resultado.getString("email"));
                    aluno.setTelefone(resultado.getString("telefone"));
                    aluno.setEndereco(resultado.getString("endereco"));
                    aluno.setSexo(resultado.getString("sexo").charAt(0));

                    LocalDate dataNasc = resultado.getDate("data_nasc").toLocalDate();
                    aluno.setData_nasc(dataNasc);

                    // Carrega o objeto Curso
                    int codCurso = resultado.getInt("cod_curso");
                    Curso curso = consultarCursoPorCodigo(codCurso);
                    aluno.setCurso(curso);

                    // Carrega o objeto Responsavel
                    int codResp = resultado.getInt("cod_resp");
                    Responsavel responsavel = consultarResponsavelPorCodigo(codResp);
                    aluno.setResponsavel(responsavel);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aluno;
    }

    public ArrayList<Aluno> consultarAlunos() {
        ConexaoMySQL conexao = new ConexaoMySQL();
        ArrayList<Aluno> alunos = new ArrayList<>();

        try (Connection conn = conexao.conectar();
             Statement stm = conn.createStatement();
             ResultSet resultado = stm.executeQuery("SELECT * FROM Aluno ORDER BY cod_aluno")) {

            while (resultado.next()) {
                Aluno aluno = new Aluno();

                aluno.setCod_aluno(resultado.getInt("cod_aluno"));
                aluno.setMatricula(resultado.getString("matricula"));
                aluno.setNome(resultado.getString("nome"));
                aluno.setRg(resultado.getString("rg"));
                aluno.setEmail(resultado.getString("email"));
                aluno.setTelefone(resultado.getString("telefone"));
                aluno.setEndereco(resultado.getString("endereco"));
                aluno.setSexo(resultado.getString("sexo").charAt(0));

                LocalDate dataNasc = resultado.getDate("data_nasc").toLocalDate();
                aluno.setData_nasc(dataNasc);

                // Carrega o objeto Curso
                int codCurso = resultado.getInt("cod_curso");
                Curso curso = consultarCursoPorCodigo(codCurso);
                aluno.setCurso(curso);

                // Carrega o objeto Responsavel
                int codResp = resultado.getInt("cod_resp");
                Responsavel responsavel = consultarResponsavelPorCodigo(codResp);
                aluno.setResponsavel(responsavel);

                alunos.add(aluno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alunos;
    }

    public String inserirAluno(Aluno aluno) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";

        try {
            String consulta = "INSERT INTO Aluno (matricula, nome, rg, email, telefone, endereco, sexo, data_nasc, cod_curso, cod_resp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setString(1, aluno.getMatricula());
            stm.setString(2, aluno.getNome());
            stm.setString(3, aluno.getRg() + "");
            stm.setString(4, aluno.getEmail());
            stm.setString(5, aluno.getTelefone());
            stm.setString(6, aluno.getEndereco());
            stm.setString(7, aluno.getSexo() + "");
            stm.setObject(8, aluno.getData_nasc());
            stm.setInt(9, aluno.getCurso().getCod_curso()); // Use o método getCod_curso()
            stm.setInt(10, aluno.getResponsavel().getCod_resp()); // Use o método getCod_resp()

            stm.executeUpdate();
            resultado = "Nome: " + aluno.getNome() + "\n" +
                        "Matricula: " + aluno.getMatricula() + "\n" +
                        "RG: " + aluno.getRg() + "\n" +
                        "Email: " + aluno.getEmail() + "\n" +
                        "Telefone: " + aluno.getTelefone() + "\n" +
                        "Endereco: " + aluno.getEndereco() + "\n" +
                        "Sexo: " + aluno.getSexo() + "\n" +
                        "Data de Nascimento: " + aluno.getData_nasc() + "\n" +
                        "Curso: " + aluno.getCurso().getNome_curso() + "\n" +
                        "Responsavel: " + aluno.getResponsavel().getNome_resp();

        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "erro";
        }
        return resultado;
    }

    public void imprimirAluno(Aluno aluno) {
        if (aluno != null) {
            System.out.println("Código do Aluno: " + aluno.getCod_aluno() + "\n" +
                               "Matrícula: " + aluno.getMatricula() + "\n" +
                               "Nome: " + aluno.getNome() + "\n" +
                               "RG: " + aluno.getRg() + "\n" +
                               "Email: " + aluno.getEmail() + "\n" +
                               "Telefone: " + aluno.getTelefone() + "\n" +
                               "Endereço: " + aluno.getEndereco() + "\n" +
                               "Sexo: " + aluno.getSexo() + "\n" +
                               "Data de Nascimento: " + aluno.getData_nasc() + "\n" +
                               "Curso: " + aluno.getCurso().getNome_curso() + "\n" +
                               "Responsável: " + aluno.getResponsavel().getNome_resp());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void imprimirAlunos(ArrayList<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            System.out.println("Código do Aluno: " + aluno.getCod_aluno() + "\n" +
                               "Matrícula: " + aluno.getMatricula() + "\n" +
                               "Nome: " + aluno.getNome() + "\n" +
                               "RG: " + aluno.getRg() + "\n" +
                               "Email: " + aluno.getEmail() + "\n" +
                               "Telefone: " + aluno.getTelefone() + "\n" +
                               "Endereço: " + aluno.getEndereco() + "\n" +
                               "Sexo: " + aluno.getSexo() + "\n" +
                               "Data de Nascimento: " + aluno.getData_nasc() + "\n" +
                               "Curso: " + aluno.getCurso().getNome_curso() + "\n" +
                               "Responsável: " + aluno.getResponsavel().getNome_resp());
            System.out.println("--------------------------------------");
        }
    }

    public String alterarAluno(Aluno aluno) {
    ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
    try {
        String consulta = "UPDATE aluno SET nome = ?, rg = ?, email = ?, telefone = ?, endereco = ?,"
                + " sexo = ?, data_nasc = ?, cod_curso = ?, cod_resp = ?, matricula = ? WHERE cod_aluno = ?";
        PreparedStatement stm = conn.prepareStatement(consulta);

        stm.setString(1, aluno.getNome());
        stm.setString(2, aluno.getRg());
        stm.setString(3, aluno.getEmail());
        stm.setString(4, aluno.getTelefone());
        stm.setString(5, aluno.getEndereco());
        stm.setString(6, String.valueOf(aluno.getSexo()));
        stm.setObject(7, aluno.getData_nasc());
        stm.setInt(8, aluno.getCurso().getCod_curso());
        stm.setInt(9, aluno.getResponsavel().getCod_resp());
        stm.setString(10, aluno.getMatricula());
        stm.setInt(11, aluno.getCod_aluno());

        int linhasAfetadas = stm.executeUpdate();
        if (linhasAfetadas > 0) {
            resultado = "Nome: " + aluno.getNome() + "\n" +
                    "Matricula: " + aluno.getMatricula() + "\n" +
                    "RG: " + aluno.getRg() + "\n" +
                    "Email: " + aluno.getEmail() + "\n" +
                    "Telefone: " + aluno.getTelefone() + "\n" +
                    "Endereco: " + aluno.getEndereco() + "\n" +
                    "Sexo: " + aluno.getSexo() + "\n" +
                    "Data de Nascimento: " + aluno.getData_nasc() + "\n" +
                    "Cod. Curso: " + aluno.getCurso().getCod_curso() + "\n" +
                    "Cod. Responsavel: " + aluno.getResponsavel().getCod_resp();
        } else {
            resultado = "Erro: Nenhuma linha foi atualizada. Verifique se o aluno com cod_aluno = " + aluno.getCod_aluno() + " existe.";
        }

    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        resultado = "Erro durante a atualização: " + ex.getMessage();
    }
    return resultado;
}


    public String removerAluno(int aluno) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.conectar();
        String resultado = "";
        try {
            String consulta = "DELETE FROM aluno WHERE cod_aluno = ?";

            PreparedStatement stm = conn.prepareStatement(consulta);
            stm.setInt(1, aluno);

            stm.executeUpdate();
            resultado = "removido";
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            resultado = "erro";
        }
        return resultado;
    }

    public AlunoControle() {
    }

    private Curso consultarCursoPorCodigo(int codCurso) {
        
        return new Curso(); 
    }

    private Responsavel consultarResponsavelPorCodigo(int codResp) {
        // Implemente este método para carregar o objeto Responsavel
        return new Responsavel(); // Retorne um objeto Responsavel adequado
    }
}
