package com.mycompany.cadastrodao.model;
public class CestaDAO {
    private String estadio;
    private String timeVencedor;
 public CestaDAO(String estadio, String timeVencedor){
        this.estadio = estadio;
        this.timeVencedor = timeVencedor;
    }

    public CestaDAO() {
      this.estadio = null;
      this.timeVencedor = null;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getTimeVencedor() {
        return timeVencedor;
    }

    public void setTimeVencedor(String timeVencedor) {
        this.timeVencedor = timeVencedor;
    }
     
}

