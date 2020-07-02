package br.com.bradesco.web.ricc.model.segmento;


//9. Exposição cambial e Política de Hedge
public class ImportacoesExportacoesVO {

	private String ano;
	private String mes;
	private String importacao;
	private String exportacao;
	private String numSequencial;

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getImportacao() {
		return importacao;
	}
	
	public void setImportacao(String importacao) {
		this.importacao = importacao;
	}

	public String getExportacao() {
		return exportacao;
	}
	
	public void setExportacao(String exportacao) {
		this.exportacao = exportacao;
	}

	public String getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(String numSequencial) {
		this.numSequencial = numSequencial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result
				+ ((exportacao == null) ? 0 : exportacao.hashCode());
		result = prime * result
				+ ((importacao == null) ? 0 : importacao.hashCode());
		result = prime * result + ((mes == null) ? 0 : mes.hashCode());
		result = prime * result
				+ ((numSequencial == null) ? 0 : numSequencial.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImportacoesExportacoesVO other = (ImportacoesExportacoesVO) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (exportacao == null) {
			if (other.exportacao != null)
				return false;
		} else if (!exportacao.equals(other.exportacao))
			return false;
		if (importacao == null) {
			if (other.importacao != null)
				return false;
		} else if (!importacao.equals(other.importacao))
			return false;
		if (mes == null) {
			if (other.mes != null)
				return false;
		} else if (!mes.equals(other.mes))
			return false;
		if (numSequencial == null) {
			if (other.numSequencial != null)
				return false;
		} else if (!numSequencial.equals(other.numSequencial))
			return false;
		return true;
	}
	
	

}
