package ementor;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

//Classe aluno, filha de pessoa
public class Aluno extends Pessoa {

  //Atributos
  private int periodo;
  private long matricula;

  //Construtor padrão
  public Aluno() {
    super();
    this.matricula = 0;
    this.periodo = 0;
  }

  //Construtor para inicializar os atributos
  public Aluno(String nome, Date dataNascimento, long cpf, String telefone, long matricula, int periodo) {
    super(nome, dataNascimento, cpf, telefone);
    this.matricula = matricula;
    this.periodo = periodo;
  }

  //Método setDados para atualizar os dados do aluno
  public void setDados(String nome, Date dataNascimento, long cpf, String telefone, long matricula, int periodo) {
    super.setDados(nome, dataNascimento, cpf, telefone);
    this.matricula = matricula;
    this.periodo = periodo;
  }

  //Método para atualizar a matrícula
  public void setMatricula(long matricula) {
    this.matricula = matricula;
  }

  //Método para atualizar o período
  public void setPeriodo(int periodo) {
    this.periodo = periodo;
  }

  //Método que retorna a matrícula
  public long getMatricula() {
    return this.matricula;
  }

  //Método que retorna o período
  public int getPeriodo() {
    return this.periodo;
  }

  //Método que mostra uma mensagem na tela com os dados do aluno
  public void imprimeDados() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    String dados = String.valueOf("Nome: " + this.nome
      + "\nData de nascimento: " + sdf.format(this.dataNascimento)
      + "\nCpf: " + this.cpf + "\nTelefone: " + this.telefone
      + "\nMatrícula: " + this.matricula + "\nPeríodo: " + this.periodo);

    JOptionPane.showMessageDialog(null, dados, "Dados do aluno", INFORMATION_MESSAGE);

  }
}
