package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean;

public class ItemSelecionavelVO<T> {
	
	private boolean selecionado;
	private T vo;
	
	public ItemSelecionavelVO(T vo){
		this.vo = vo;
	}

	public boolean isSelecionado() {
		return selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}

	public T getVo() {
		return vo;
	}

	public void setVo(T vo) {
		this.vo = vo;
	}
}