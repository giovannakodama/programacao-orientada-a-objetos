//Giovanna Kodama Romero - 2101386

public class StorageArte{
  private Fotografia vetFotografia[];
  private Post vetPost[];
  private int countFotografia;
  private int countPost;


  public StorageArte() {
    vetFotografia = new Fotografia[5];
    vetPost = new Post[5];
    countFotografia = 0;
    countPost = 0;
  }

  public boolean insArte(Fotografia fotografia) {
    if(countFotografia < 5) {
      for(int i = 0; i < 5; i++){
        if(vetFotografia[i] == null) {
          vetFotografia[i] = fotografia;
          countFotografia++;
          return true;
        }
      }
    }
    return false;
  }

  public boolean insArte(Post post) {
    if (countPost < 5) {
      for (int i = 0; i < 5; i++) {
        if (vetPost[i] == null) {
          vetPost[i] = post;
          countPost++;
          return true;
        }
      }
    }
    return false;
  }

  public Fotografia consArte(Fotografia fotografia) {
    if(countFotografia == 0) {
      return null;
    }
    for(int i = 0; i < 5; i++) {
      if(vetFotografia[i] != null) {
        if(vetFotografia[i].getCodFoto() == fotografia.getCodFoto()) {
          return vetFotografia[i];
        }
      } else {
        if (i == 4) {
          return null;
        }
      }

    }
    return null;
  }

  public Post consArte(Post post) {
    if (countPost == 0) {
      return null;
    }
    for(int i = 0; i < 5; i++) {
      if(vetPost[i] != null)  {
        if(vetPost[i].getCodPost() == post.getCodPost()) {
          return vetPost[i];
        }
      } else {
        if(i == 4) {
          return null;
        }
      }
    }
    return null;
  }

  public int consArte(Fotografia fotografia, int aux) {
    if(countFotografia == 0) {
      return -1;
    }
    for(int i = 0; i < 5; i++) {
      if(vetFotografia[i] != null) {
        if(vetFotografia[i].getCodFoto() == fotografia.getCodFoto()) {
          return i;
        }
      } else {
        if (i == 4) {
          return -1;
        }
      }

    }
    return -1;
  }

  public int consArte(Post post, int aux) {
    if (countPost == 0) {
      return -1;
    }
    for(int i = 0; i < 5; i++) {
      if(vetPost[i] != null)  {
        if(vetPost[i].getCodPost() == post.getCodPost()) {
          return i;
        }
      } else {
        if(i == 4) {
          return -1;
        }
      }
    }
    return -1;
  }

  public boolean alteraArte(Fotografia fotografia, int index) {
    vetFotografia[index] = fotografia;
    return true;
  }

  public boolean alteraArte(Post post, int index) {
    vetPost[index] = post;
    return true;
  }
 
  public boolean excluiArte(Fotografia fotografia) {
    if (countFotografia == 0) {
      return false;
    }
    for(int i = 0; i < 5; i++) {
      if(vetFotografia[i].getCodFoto() == fotografia.getCodFoto()) {
        vetFotografia[i] = null;
        countFotografia--;
        return true;
      }
    }
    return false;
  }

  public boolean excluiArte(Post post) {
    if (countPost == 0) {
      return false;
    }
    for(int i = 0; i < 5; i++) {
      if(vetPost[i].getCodPost() == post.getCodPost()) {
        vetPost[i] = null;
        countPost--;
        return true;
      }
    }
    return false;
  }

}