
package com.mycompany.atvbancod.cadastro.model;
public class Pedagogo {
        private String cpf;
	private String nome_pedagogo;
	private String email;
	private String telefone;
        private int senha;

    public Pedagogo(String cpf, String nome_pedagogo, String email, String telefone) {
        this.cpf = cpf;
        this.nome_pedagogo = nome_pedagogo;
        this.email = email;
        this.telefone = telefone;
    }

    public Pedagogo() {
        this.cpf = null;
        this.nome_pedagogo = null;
        this.email = null;
        this.telefone = null;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome_pedagogo() {
        return nome_pedagogo;
    }

    public void setNome_pedagogo(String nome_pedagogo) {
        this.nome_pedagogo = nome_pedagogo;
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

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
    
        @Override
    public String toString() {
        return "Pedagogo{" + "NOME: " + nome_pedagogo + ", CPF: " + cpf +", EMAIL: "+email+", TELEFONE: "+telefone+ '}';
    }
}
