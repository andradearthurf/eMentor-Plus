package ementor;

//Classe usuário, filha de pessoa
public class Usuario extends Pessoa {

  //Atributos
  private String nomeUsuario, senha;
  private int nvlAcesso;

  //Construtor padrão
  public Usuario() {
    this.nomeUsuario = "";
    this.senha = "";
    this.nvlAcesso = 0;
  }

  //Método para alterar os dados
  public void setDados(String nomeUsuario, String senha, int nvlAcesso) {
    this.nomeUsuario = nomeUsuario;
    this.senha = senha;
    this.nvlAcesso = nvlAcesso;
  }

  //Método para retornar o nome de usuário
  public String getnomeUsuario() {
    return this.nomeUsuario;
  }

  //Método para retornar a senha
  public String getSenha() {
    return this.senha;
  }
}
