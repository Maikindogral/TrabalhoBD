
package com.mycompany.atvbancod.cadastro.model;
public class Turma {
        private String ano;
	private String disciplina;

    public Turma(String ano, String disciplina) {
        this.ano = ano;
        this.disciplina = disciplina;
    }

    public Turma() {
        this.ano = null;
        this.disciplina = null;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
       @Override
    public String toString() {
        return "Pedagogo{" + "ANO: " + ano + ", Disciplina: " + disciplina+ '}';
    }     
}
