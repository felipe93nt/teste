package br.com.bradesco.web.ricc.model.parametrizacaomensagem;

public class ParametrizacaoMensagemVO {

    // Campos da tela
    private String tipoComponente = "";
    private String descricao = "";
    private String bloco = "";
    private String tagMt = "";
    private String tipoDado = "";
    private String formatoCampo = "";
    private String tamanhoCampo = "";
    private String tamanhoFixo = "";
    private String quantidadeLinhas = "";
    private String moduloConsistencia = "";

 
    public ParametrizacaoMensagemVO(){
    	
    }
    
    public ParametrizacaoMensagemVO(String tipoComponente, String descricao,
			String bloco, String tagMt, String tipoDado, String formatoCampo,
			String tamanhoCampo, String tamanhoFixo, String quantidadeLinhas,
			String moduloConsistencia) {
		this.tipoComponente = tipoComponente;
		this.descricao = descricao;
		this.bloco = bloco;
		this.tagMt = tagMt;
		this.tipoDado = tipoDado;
		this.formatoCampo = formatoCampo;
		this.tamanhoCampo = tamanhoCampo;
		this.tamanhoFixo = tamanhoFixo;
		this.quantidadeLinhas = quantidadeLinhas;
		this.moduloConsistencia = moduloConsistencia;
	}

	public String getTipoComponente() {
        return tipoComponente;
    }

    public void setTipoComponente(String tipoComponente) {
        this.tipoComponente = tipoComponente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getTagMt() {
        return tagMt;
    }

    public void setTagMt(String tagMt) {
        this.tagMt = tagMt;
    }

    public String getTipoDado() {
        return tipoDado;
    }

    public void setTipoDado(String tipoDado) {
        this.tipoDado = tipoDado;
    }

    public String getFormatoCampo() {
        return formatoCampo;
    }

    public void setFormatoCampo(String formatoCampo) {
        this.formatoCampo = formatoCampo;
    }

    public String getTamanhoCampo() {
        return tamanhoCampo;
    }

    public void setTamanhoCampo(String tamanhoCampo) {
        this.tamanhoCampo = tamanhoCampo;
    }

    public String getTamanhoFixo() {
        return tamanhoFixo;
    }

    public void setTamanhoFixo(String tamanhoFixo) {
        this.tamanhoFixo = tamanhoFixo;
    }
 
    public String getQuantidadeLinhas() {
        return quantidadeLinhas;
    }

    public void setQuantidadeLinhas(String quantidadeLinhas) {
        this.quantidadeLinhas = quantidadeLinhas;
    }
 
    public String getModuloConsistencia() {
        return moduloConsistencia;
    }

    public void setModuloConsistencia(String moduloConsistencia) {
        this.moduloConsistencia = moduloConsistencia;
    }

}