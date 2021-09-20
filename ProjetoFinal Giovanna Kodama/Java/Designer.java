//Giovanna Kodama Romero - 2101386

public class Designer {
	
	private int codDesigner;
	private String nomeDesigner;
	private Nacionalidade nacionalidade;

	public Designer() {
		codDesigner = 0;
		nomeDesigner = "";
		nacionalidade = new Nacionalidade();
	}

	public Nacionalidade getNacionalidade(){
		return nacionalidade;
	}
	public String getNomeDesigner(){
		return nomeDesigner;
	}	
	public int getCodDesigner(){
		return codDesigner;	
	}
    public void setDesigner(int codDesigner){
        this.codDesigner = codDesigner;
    }
    public void setNomeDesigner(String nomeDesigner){
        this.nomeDesigner = nomeDesigner;
	}
	public void setNacionalidade(Nacionalidade nacionalidade){
		this.nacionalidade = nacionalidade;
	}

    public void setCodDesigner(int parseInt) {
    }

}