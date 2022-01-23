
package com.mycompany.atvbancod.cadastro.model;
public class Aluno {
	private String nome_aluno;
	private String email;
	private String disciplina;
	private String ano;

    public Aluno(String nome_aluno, String email, String disciplina, String ano) {
        this.nome_aluno = nome_aluno;
        this.email = email;
        this.disciplina = disciplina;
        this.ano = ano;
    }

    public Aluno() {
        this.nome_aluno = null;
        this.email = null;
        this.disciplina = null;
        this.ano = null;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    @Override
    public String toString() {
        return "Pedagogo{" + "NOME: " + nome_aluno + ", DISCIPLINA: " + disciplina +", EMAIL: "+email+", ANO: "+ano+ '}';
    }
}
