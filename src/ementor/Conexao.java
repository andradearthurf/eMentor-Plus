package ementor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

//Classe para interagir com o banco de dados MySql
public class Conexao {

  //Dados para conexão com o banco
  private String driveJDBC = "com.mysql.cj.jdbc.Driver"; // Nome do driver.
  private String path = "localhost"; // Caminho do server.
  private String port = "3306";
  private String database = "ementorPlus";
  private String timezone = "?useTimezone=true&serverTimezone=UTC";

  private String USER = "root";
  private String PASS = "arthur050564";
  private String URL = "jdbc:mysql://" + path + ":" + port + "/" + database + timezone;

  // Criar conexão com o banco.
  public Connection criaConexao() {
    try {
      return DriverManager.getConnection(this.URL, this.USER, this.PASS);
    } catch (SQLException ex) {
      throw new RuntimeException("Erro ao tentar conexão com o banco de dados: " + ex.toString());
    }
  }

  // Fechar conexão com o banco.
  public void fechaConexao(Connection con) {
    try {
      if (con != null) {
        con.close();
      }
    } catch (SQLException ex) {
      throw new RuntimeException("Erro ao fechar banco de dados: " + ex.toString());
    }
  }

  // Método para inserir aluno no banco.
  public void insereAluno(String nome, Date dataNascimento, long cpf, String telefone, Long matricula, int periodo) {
    Connection con = criaConexao();

    //SQL de insert
    String sqlPessoa = "insert into pessoa (cpf, nome, telefone, dataNascimento) values (?, ?, ?, ?);";
    String sqlAluno = "insert into aluno (matricula, periodo, cpfPessoa) values (?, ?, ?);";

    try {
      //Preparação da query
      PreparedStatement atuadorPessoa = con.prepareStatement(sqlPessoa);
      PreparedStatement atuadorAluno = con.prepareStatement(sqlAluno);

      atuadorPessoa.setLong(1, cpf);
      atuadorPessoa.setString(2, nome);
      atuadorPessoa.setString(3, telefone);
      atuadorPessoa.setDate(4, new java.sql.Date(dataNascimento.getTime()));

      atuadorAluno.setLong(1, matricula);
      atuadorAluno.setInt(2, periodo);
      atuadorAluno.setLong(3, cpf);

      //Execução da query
      atuadorPessoa.execute();
      atuadorAluno.execute();

      //Fecha o atuador
      atuadorPessoa.close();
      atuadorAluno.close();
      JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Salvo", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Não foi possível efetuar o cadastro!", "Erro", JOptionPane.ERROR_MESSAGE);

      throw new RuntimeException("Erro ao inserir no banco de dados: " + ex.toString());
    } finally {
      //Fecha a conexão
      fechaConexao(con);
    }
  }

  //Método que retorna todos os alunos cadastrados no banco
  public ArrayList<Aluno> recuperaAlunos(String ordenacao) {
    Connection con = criaConexao();
    ArrayList<Aluno> alunos = new ArrayList();
    //SQL do select
    String sqlAluno = "select * from pessoa, aluno WHERE pessoa.cpf=aluno.cpfPessoa order by " + ordenacao + ";";

    try {
      PreparedStatement atuadorAluno = con.prepareStatement(sqlAluno);
      ResultSet retornoBanco = atuadorAluno.executeQuery();

      //Adiciona os dados recebidos do banco ao ArrayList
      while (retornoBanco.next()) {
        Aluno objAluno = new Aluno();
        objAluno.cpf = retornoBanco.getLong("cpf");
        objAluno.nome = retornoBanco.getString("nome");
        objAluno.telefone = retornoBanco.getString("telefone");
        objAluno.dataNascimento = retornoBanco.getDate("dataNascimento");
        objAluno.setMatricula(retornoBanco.getLong("matricula"));
        objAluno.setPeriodo(retornoBanco.getInt("periodo"));

        alunos.add(objAluno);
      }

      //Fecha o retorno e o atuador
      retornoBanco.close();
      atuadorAluno.close();
    } catch (SQLException ex) {
      throw new RuntimeException("Erro ao buscar dados: " + ex.toString());
    } finally {
      //Fecha a conexão
      fechaConexao(con);
    }

    return alunos;
  }

  // Método para inserir aluno no banco.
  public void insereProfessor(String nome, Date dataNascimento, long cpf, String telefone, Date dataAdmissao, double salarioBruto) {
    Connection con = criaConexao();

    //SQL de insert
    String sqlPessoa = "insert into pessoa (cpf, nome, telefone, dataNascimento) values (?, ?, ?, ?);";
    String sqlAluno = "insert into professor (cpfPessoa, dataAdmissao, salarioBruto) values (?, ?, ?);";

    try {
      //Prepara query
      PreparedStatement atuadorPessoa = con.prepareStatement(sqlPessoa);
      PreparedStatement atuadorProfessor = con.prepareStatement(sqlAluno);

      atuadorPessoa.setLong(1, cpf);
      atuadorPessoa.setString(2, nome);
      atuadorPessoa.setString(3, telefone);
      atuadorPessoa.setDate(4, new java.sql.Date(dataNascimento.getTime()));

      atuadorProfessor.setLong(1, cpf);
      atuadorProfessor.setDate(2, new java.sql.Date(dataAdmissao.getTime()));
      atuadorProfessor.setDouble(3, salarioBruto);

      //Executa query
      atuadorPessoa.execute();
      atuadorProfessor.execute();

      //Fecha o atuador
      atuadorPessoa.close();
      atuadorProfessor.close();
      JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Salvo", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Não foi possível efetuar o cadastro!", "Erro", JOptionPane.ERROR_MESSAGE);

      throw new RuntimeException("Erro ao inserir no banco de dados: " + ex.toString());
    } finally {
      //Fecha a conexão
      fechaConexao(con);
    }
  }

  //Método para recuperar todos os professores cadastrados no banco
  public ArrayList<Professor> recuperaProfessores(String ordenacao) {
    Connection con = criaConexao();
    ArrayList<Professor> professores = new ArrayList();
    //SQL do select
    String sqlProfessor = "select * from pessoa, professor WHERE pessoa.cpf=professor.cpfPessoa order by " + ordenacao + ";";

    try {
      PreparedStatement atuadorProfessor = con.prepareStatement(sqlProfessor);
      ResultSet retornoBanco = atuadorProfessor.executeQuery();

      //Armazena os dados retornados pela query
      while (retornoBanco.next()) {
        Professor objProfessor = new Professor();

        objProfessor.setDataAdmissao(retornoBanco.getDate("dataAdmissao"));
        objProfessor.setSalarioBruto(retornoBanco.getDouble("salarioBruto"));
        objProfessor.cpf = retornoBanco.getLong("cpf");
        objProfessor.nome = retornoBanco.getString("nome");
        objProfessor.telefone = retornoBanco.getString("telefone");
        objProfessor.dataNascimento = retornoBanco.getDate("dataNascimento");

        professores.add(objProfessor);
      }

      //Fecha o retorno e o atuador
      retornoBanco.close();
      atuadorProfessor.close();
    } catch (SQLException ex) {
      throw new RuntimeException("Erro ao buscar dados: " + ex.toString());
    } finally {
      //Fecha a conexão
      fechaConexao(con);

    }

    return professores;
  }

  //Busca um professor pelo cpf
  public Professor recuperaProfessorCPF(Long cpf) {
    Connection con = criaConexao();
    Professor professor = new Professor();
    //SQL do select
    String sqlProfessor = "select * from pessoa, professor WHERE pessoa.cpf=professor.cpfPessoa and pessoa.cpf=?;";

    try {
      //Prepara a query
      PreparedStatement atuadorProfessor = con.prepareStatement(sqlProfessor);
      atuadorProfessor.setLong(1, cpf);
      ResultSet retornoBanco = atuadorProfessor.executeQuery();

      //Verifica se o professor com aquele CPF existe
      if (!retornoBanco.isBeforeFirst()) {
        retornoBanco.close();
        atuadorProfessor.close();
        fechaConexao(con);
        //Retorna null caso ele não exista
        return null;
      } else {

        //Caso ele exista, armazena os dados e retorna
        while (retornoBanco.next()) {
          professor.setDataAdmissao(retornoBanco.getDate("dataAdmissao"));
          professor.setSalarioBruto(retornoBanco.getDouble("salarioBruto"));
          professor.cpf = retornoBanco.getLong("cpf");
          professor.nome = retornoBanco.getString("nome");
          professor.telefone = retornoBanco.getString("telefone");
          professor.dataNascimento = retornoBanco.getDate("dataNascimento");
        }
        //Fecha o retorno e o atuador
        retornoBanco.close();
        atuadorProfessor.close();
      }
    } catch (SQLException ex) {
      throw new RuntimeException("Erro ao buscar dados: " + ex.toString());
    } finally {
      //Fecha a conexão
      fechaConexao(con);
    }

    return professor;
  }

  //Método que altera os dados do professor
  public void alteraProfessor(String nome, Date dataNascimento, long cpf, String telefone, Date dataAdmissao, double salarioBruto) {
    Connection con = criaConexao();

    //SQL do update
    String sqlPessoa = "update pessoa set cpf=?, nome=?, telefone=?, dataNascimento=? where cpf=?;";
    String sqlProfessor = "update professor set cpfPessoa=?, dataAdmissao=?, salarioBruto=? where cpfPessoa=?;";

    try {
      //Prepara a query
      PreparedStatement atuadorPessoa = con.prepareStatement(sqlPessoa);
      PreparedStatement atuadorProfessor = con.prepareStatement(sqlProfessor);

      atuadorPessoa.setLong(1, cpf);
      atuadorPessoa.setString(2, nome);
      atuadorPessoa.setString(3, telefone);
      atuadorPessoa.setDate(4, new java.sql.Date(dataNascimento.getTime()));
      atuadorPessoa.setLong(5, cpf);

      atuadorProfessor.setLong(1, cpf);
      atuadorProfessor.setDate(2, new java.sql.Date(dataAdmissao.getTime()));
      atuadorProfessor.setDouble(3, salarioBruto);
      atuadorProfessor.setLong(4, cpf);

      //Executa a query
      atuadorPessoa.execute();
      atuadorProfessor.execute();

      //Fecha o retorno e o atuador
      atuadorPessoa.close();
      atuadorProfessor.close();
      JOptionPane.showMessageDialog(null, "Atualizado com sucesso!", "Salvo", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Não foi possível efetuar a atualização!", "Erro", JOptionPane.ERROR_MESSAGE);

      throw new RuntimeException("Erro ao inserir no banco de dados: " + ex.toString());
    } finally {
      //Fecha a conexão
      fechaConexao(con);
    }
  }

  //Método para buscar os dados de um aluno pela matrícula
  public Aluno recuperaAlunoMatricula(Long matricula) {
    Connection con = criaConexao();
    Aluno aluno = new Aluno();
    //SQL de select
    String sqlAluno = "select * from pessoa, aluno WHERE pessoa.cpf=aluno.cpfPessoa and aluno.matricula = ?;";

    try {
      //Prepara query
      PreparedStatement atuadorAluno = con.prepareStatement(sqlAluno);
      atuadorAluno.setLong(1, matricula);
      //Executa query
      ResultSet retornoBanco = atuadorAluno.executeQuery();

      boolean vazio = true;
      //Verifica o retorno do banco
      while (retornoBanco.next()) {
        vazio = false;
        aluno.cpf = retornoBanco.getLong("cpf");
        aluno.nome = retornoBanco.getString("nome");
        aluno.telefone = retornoBanco.getString("telefone");
        aluno.dataNascimento = retornoBanco.getDate("dataNascimento");
        aluno.setMatricula(retornoBanco.getLong("matricula"));
        aluno.setPeriodo(retornoBanco.getInt("periodo"));
      }

      //Fecha o retorno e o atuador
      retornoBanco.close();
      atuadorAluno.close();

      //Caso não encontre o aluno, retorna null
      if (vazio) {
        return null;
      }
    } catch (SQLException ex) {
      throw new RuntimeException("Erro ao buscar dados: " + ex.toString());
    } finally {
      //Fecha a conexão
      fechaConexao(con);
    }

    //Caso encontre o aluno, retorna ele
    return aluno;
  }

  //Método de buscar uma pessoa pelo CPF
  public boolean buscaCPF(Long cpf) {
    Connection con = criaConexao();
    //SQL do select
    String sqlAluno = "select * from pessoa WHERE cpf = ?;";

    try {
      //Prepara a query
      PreparedStatement atuador = con.prepareStatement(sqlAluno);
      atuador.setLong(1, cpf);
      //Executa a query
      ResultSet retornoBanco = atuador.executeQuery();
      boolean vazio = true;

      //Verifica se o select retornou algum registro
      while (retornoBanco.next()) {
        vazio = false;
      }

      //Fecha o retorno e o atuador
      retornoBanco.close();
      atuador.close();

      //Caso não exista uma pessoa com aquele CPf, retorna false
      if (vazio) {
        return false;
      }
    } catch (SQLException ex) {
      throw new RuntimeException("Erro ao buscar dados: " + ex.toString());
    } finally {
      //Fecha a conexão
      fechaConexao(con);
    }

    //Caso exista uma pessoa com o CPF
    return true;
  }

  //Método que verifica se o aluno com aquela matrícula existe
  public boolean buscaMatricula(Long matricula) {
    Connection con = criaConexao();
    //SQL do select
    String sqlAluno = "select * from aluno WHERE matricula = ?;";

    try {
      //Prepara a query
      PreparedStatement atuador = con.prepareStatement(sqlAluno);
      atuador.setLong(1, matricula);
      //Executa a query
      ResultSet retornoBanco = atuador.executeQuery();
      boolean vazio = true;

      //Verifica se o select retornou alguma coisa
      while (retornoBanco.next()) {
        vazio = false;
      }

      //Fecha o retorno e o atuador
      retornoBanco.close();
      atuador.close();

      //Caso não exista o aluno com a matrícula, retorna false
      if (vazio) {
        return false;
      }
    } catch (SQLException ex) {
      throw new RuntimeException("Erro ao buscar dados: " + ex.toString());
    } finally {
      //Fecha a conexão
      fechaConexao(con);
    }

    //Caso exista o aluno com a matrícula, retorna true
    return true;
  }

  //Método que realiza a alteração dos dados do aluno
  public void alteraAluno(String nome, Date dataNascimento, long cpf, String telefone, Long matricula, int periodo) {
    Connection con = criaConexao();

    //SQL do update
    String sqlPessoa = "update pessoa set cpf=?, nome=?, telefone=?, dataNascimento=? where cpf=?;";
    String sqlAluno = "update aluno set matricula=?, periodo=?, cpfPessoa=? where cpfPessoa=?;";

    try {
      //Prepara a query
      PreparedStatement atuadorPessoa = con.prepareStatement(sqlPessoa);
      PreparedStatement atuadorAluno = con.prepareStatement(sqlAluno);

      atuadorPessoa.setLong(1, cpf);
      atuadorPessoa.setString(2, nome);
      atuadorPessoa.setString(3, telefone);
      atuadorPessoa.setDate(4, new java.sql.Date(dataNascimento.getTime()));
      atuadorPessoa.setLong(5, cpf);

      atuadorAluno.setLong(1, matricula);
      atuadorAluno.setInt(2, periodo);
      atuadorAluno.setLong(3, cpf);
      atuadorAluno.setLong(4, cpf);

      //Executa a query
      atuadorPessoa.execute();
      atuadorAluno.execute();

      //Fecha os atuadores
      atuadorAluno.close();
      atuadorPessoa.close();
      JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!", "Salvo", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Não foi possível atualizar!", "Erro", JOptionPane.ERROR_MESSAGE);

      throw new RuntimeException("Erro ao atualizar no banco de dados: " + ex.toString());
    } finally {
      //Fecha a conexão
      fechaConexao(con);
    }
  }

  //Método que realiza a validação do login
  public boolean validarAcesso(String usuario, String senha) {
    Connection con = criaConexao();
    try {

      //SQL do select
      String sql = "select * from usuario where nome='" + usuario + "'and senha='" + senha + "'";

      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);

      //Caso exista um usuário com aquele nome e senha, retorna true
      if (rs.next()) {
        //Fecha atuador e o retorno
        st.close();
        rs.close();
        return true;
      } else {
        JOptionPane.showMessageDialog(null, "Usuário não existe no sistema!", "Erro", JOptionPane.ERROR_MESSAGE);
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    } finally {
      fechaConexao(con);
    }
    //Caso não exista o usuário com o nome e a senha, retorna false
    return false;
  }
}
