//Giovanna Kodama Romero - 2101386

public abstract class Arte{
	
	private int ano;
	private int altura;
	private int largura;
	private double valor;
	private Designer dsg;
	
	public Arte() {
		ano = 0;
		altura = 0;
		largura = 0;
		valor = 0;
		dsg = new Designer();
	}
	public int getAno() {
		return ano;
	}
	public int getAltura() {
		return altura;
	}
	public int getLargura() {
		return largura;
	}

	public double getValor() {
		return valor;
	}
    public Designer getDsg() {
        return dsg;
    }
	public void setAno(int ano) {
		this.ano = ano;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public void setLargura(int largura) {
		this.largura = largura;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
    public void setDsg(Designer dsg){
        this.dsg = dsg;
	}
	public abstract void impriDados();

}