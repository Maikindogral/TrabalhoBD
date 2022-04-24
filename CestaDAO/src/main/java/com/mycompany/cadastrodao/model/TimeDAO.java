
package com.mycompany.cadastrodao.model;
public class TimeDAO {
    private String nome_time;
    private int Njogadores;
    private String nome_tecnico;
   public TimeDAO(String nome_time, int Njogadores, String nome_tecnico){
        this.nome_time = nome_time;
        this.Njogadores = Njogadores;
        this.nome_tecnico = nome_tecnico;
}

    public TimeDAO() {
     this.nome_time = null;
     this.Njogadores = 0;
     this.nome_tecnico = null;
    }

    public String getNome_time() {
        return nome_time;
    }

    public void setNome_time(String nome_time) {
        this.nome_time = nome_time;
    }

    public int getNjogadores() {
        return Njogadores;
    }

    public void setNjogadores(int Njogadores) {
        this.Njogadores = Njogadores;
    }

    public String getNome_tecnico() {
        return nome_tecnico;
    }

    public void setNome_tecnico(String nome_tecnico) {
        this.nome_tecnico = nome_tecnico;
    }


      
    
}
