package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;


public class ComboModeloBoletoVO {

    private Integer cprodtserv  = 0;
    private Integer ctpoclauscmbio = null;
    private String  rclauscontrcmbio = null;                
    private String  imodcontrcmbio = null;
    private Integer cmodcontrcmbio = null;
	public Integer getCprodtserv() {
		return cprodtserv;
	}
	public void setCprodtserv(Integer cprodtserv) {
		this.cprodtserv = cprodtserv;
	}
	public Integer getCtpoclauscmbio() {
		return ctpoclauscmbio;
	}
	public void setCtpoclauscmbio(Integer ctpoclauscmbio) {
		this.ctpoclauscmbio = ctpoclauscmbio;
	}
	public String getRclauscontrcmbio() {
		return rclauscontrcmbio;
	}
	public void setRclauscontrcmbio(String rclauscontrcmbio) {
		this.rclauscontrcmbio = rclauscontrcmbio;
	}
	public String getImodcontrcmbio() {
		return imodcontrcmbio;
	}
	public void setImodcontrcmbio(String imodcontrcmbio) {
		this.imodcontrcmbio = imodcontrcmbio;
	}
	public Integer getCmodcontrcmbio() {
		return cmodcontrcmbio;
	}
	public void setCmodcontrcmbio(Integer cmodcontrcmbio) {
		this.cmodcontrcmbio = cmodcontrcmbio;
	}
}
