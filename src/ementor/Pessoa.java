package ementor;

import java.util.Date;

//Classe pessoa, pai de aluno, profesor e usuário
public class Pessoa {

  //Atributos
  protected String nome, telefone;
  protected Date dataNascimento;
  protected long cpf;

  //Coonstrutor padrão
  public Pessoa() {
    this.nome = "";
    this.dataNascimento = new Date();
    this.telefone = "";
    this.cpf = 0;
  }

  //Construtor para inicializar os atributos
  public Pessoa(String nome, Date dataNascimento, long cpf, String telefone) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.cpf = cpf;
    this.telefone = telefone;
  }

  //Métodos para alterarar os dados da pessoa
  public void setDados(String nome, Date dataNascimento, long cpf, String telefone) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.cpf = cpf;
    this.telefone = telefone;
  }
}
