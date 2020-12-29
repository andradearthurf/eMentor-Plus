package ementor;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

//Classe professor, filha de pessoa
public class Professor extends Pessoa {

  //Atributos
  private Date dataAdmissao;
  private double salarioBruto;

  //Construtor padrão
  public Professor() {
    super();
    this.dataAdmissao = new Date();
    this.salarioBruto = 0.0;
  }

  //Construtor para inicializar todos os atributos
  public Professor(String nome, Date dataNascimento, long cpf, String telefone, Date dataAdmissao, double salario) {
    super(nome, dataNascimento, cpf, telefone);
    this.dataAdmissao = dataNascimento;
    this.salarioBruto = salario;
  }

  //Método para alterar os dados do profesor
  public void setDados(String nome, Date dataNascimento, long cpf, String telefone, Date dataAdmissao, double salario) {
    super.setDados(nome, dataNascimento, cpf, telefone);
    this.dataAdmissao = dataNascimento;
    this.salarioBruto = salario;
  }

  //Método para alterar a data de admissão
  public void setDataAdmissao(Date data) {
    this.dataAdmissao = data;
  }

  //Método para alterar o salário bruto
  public void setSalarioBruto(double salario) {
    this.salarioBruto = salario;
  }

  //Método para retornar a data de admissão
  public Date getDataAdmissao() {
    return this.dataAdmissao;
  }

  //Método para retornar o salário bruto
  public double getSalarioBruto() {
    return this.salarioBruto;
  }

  //Método para calcular o salário líquido
  public double salarioLiquido() {
    double tributo = 0.14;
    double salarioLiquido = 0;

    //Caso o salário seja maior do que 5000
    if (salarioBruto >= 5000) {
      tributo += 0.225;
    }

    salarioLiquido = salarioBruto * (1 - tributo);

    return salarioLiquido;
  }

  //Método para realizar a impressão dos dados em uma mensagem na tela
  public void imprimeDados() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    String dados = String.valueOf("Nome: " + this.nome
      + "\nData de nascimento: " + sdf.format(this.dataAdmissao)
      + "\nCpf: " + this.cpf + "\nTelefone: " + this.telefone
      + "\nData de admissão: " + sdf.format(this.dataAdmissao)
      + "\nSalário bruto: R$ " + this.salarioBruto
      + "\nSalário líquido: R$ " + this.salarioLiquido());

    JOptionPane.showMessageDialog(null, dados, "Dados do professor", INFORMATION_MESSAGE);
  }
}
