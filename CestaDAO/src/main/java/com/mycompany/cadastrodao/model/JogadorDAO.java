package com.mycompany.cadastrodao.model;
public class JogadorDAO {
    private String nome_jogador;
    private int Ncamisa;
    private double altura;
    private String posicao;


    public JogadorDAO(String nome_jogador, int Ncamisa, double altura, String posicao){
        this.nome_jogador = nome_jogador;
        this.Ncamisa = Ncamisa;
        this.altura = altura;
        this.posicao = posicao;
}
    public JogadorDAO() {
        this.nome_jogador = null;
        this.Ncamisa = 0;
        this.altura = 0;
        this.posicao = null;
}

    public String getNome_jogador() {
        return nome_jogador;
    }

    public void setNome_jogador(String nome_jogador) {
        this.nome_jogador = nome_jogador;
    }

    public int getNcamisa() {
        return Ncamisa;
    }

    public void setNcamisa(int Ncamisa) {
        this.Ncamisa = Ncamisa;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
}

