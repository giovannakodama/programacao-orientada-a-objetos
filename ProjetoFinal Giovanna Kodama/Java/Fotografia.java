import javax.swing.JOptionPane;

//Giovanna Kodama Romero - 2101386

public final class Fotografia extends Arte implements saiDados {
  private String localFoto;
  private int codFoto;

  public Fotografia() {
    localFoto = "";
    codFoto = 0;
  }

  public String getLocalFoto() {
    return localFoto;
  }
  
  public void setLocalFoto(String localFoto) {
    this.localFoto = localFoto;
  }

  public int getCodFoto() {
    return codFoto;
  }

  public void setCodFoto(int codFoto) {
    try{
      this.codFoto = codFoto;
    }catch(NumberFormatException nfe) {
      JOptionPane.showMessageDialog(null, "INFORME UM VALOR NO CAMPO DE CONSULTA!!!");
    }

  }
  
  public void imprimDados() {
    System.out.println();
  }
  
  public void impriDados() {
    System.out.println();
  }
}