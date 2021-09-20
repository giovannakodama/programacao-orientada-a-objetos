//Giovanna Kodama Romero - 2101386

public final class Post extends Arte implements saiDados {
  
  private int codPost;
  private String nomePost;

  public Post() {
    codPost = 0;
    nomePost = "";
  }

  public void setCodPost(int codPost) {
    this.codPost = codPost;
  }

  public int getCodPost() {
    return codPost;
  }

  public String getNomePost() {
    return nomePost;
  }

  public void setNomePost(String nomePost) {
    this.nomePost = nomePost;
  }

  public void impriDados() {
    System.out.println("Identificacao do post: " + getCodPost());
  }
  public void imprimDados() {
    System.out.println("Identificacao do post " + getCodPost());
  }

public char[] getNomeArte() {
    return null;
}

public void setNomeArte(String text) {
}
}