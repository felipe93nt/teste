package br.com.bradesco.web.ricc.model.segmento;



//7. Situação Econômica-Financeira
public class FaturamentoPorSegmentoVO {
	
	private String ano1;
	private String ano2;
	private String ano3;
	
	private LinhaSegmentoVO linha1 = new LinhaSegmentoVO();
	private LinhaSegmentoVO linha2 = new LinhaSegmentoVO();
	private LinhaSegmentoVO linha3 = new LinhaSegmentoVO();
	private LinhaSegmentoVO linha4 = new LinhaSegmentoVO();
	private LinhaSegmentoVO linha5 = new LinhaSegmentoVO();
	private LinhaSegmentoVO linha6 = new LinhaSegmentoVO();

	public String getAno1() {
		return ano1;
	}

	public void setAno1(String ano1) {
		this.ano1 = ano1;
	}

	public String getAno2() {
		return ano2;
	}

	public void setAno2(String ano2) {
		this.ano2 = ano2;
	}

	public String getAno3() {
		return ano3;
	}

	public void setAno3(String ano3) {
		this.ano3 = ano3;
	}

	public LinhaSegmentoVO getLinha1() {
		return linha1;
	}

	public void setLinha1(LinhaSegmentoVO linha1) {
		this.linha1 = linha1;
	}

	public LinhaSegmentoVO getLinha2() {
		return linha2;
	}

	public void setLinha2(LinhaSegmentoVO linha2) {
		this.linha2 = linha2;
	}

	public LinhaSegmentoVO getLinha3() {
		return linha3;
	}

	public void setLinha3(LinhaSegmentoVO linha3) {
		this.linha3 = linha3;
	}

	public LinhaSegmentoVO getLinha4() {
		return linha4;
	}

	public void setLinha4(LinhaSegmentoVO linha4) {
		this.linha4 = linha4;
	}

	public LinhaSegmentoVO getLinha5() {
		return linha5;
	}

	public void setLinha5(LinhaSegmentoVO linha5) {
		this.linha5 = linha5;
	}

	public LinhaSegmentoVO getLinha6() {
		return linha6;
	}

	public void setLinha6(LinhaSegmentoVO linha6) {
		this.linha6 = linha6;
	}

}
