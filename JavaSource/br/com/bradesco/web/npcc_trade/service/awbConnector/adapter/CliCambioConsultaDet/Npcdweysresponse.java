package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 20/01/16 16:11
 */
public class Npcdweysresponse extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWEYS-HEADER.NPCDWEYS-COD-LAYOUT")
	private String codlayout = "NPCDWEYS";

	@Adapter(transactionField = "NPCDWEYS-HEADER.NPCDWEYS-TAM-LAYOUT")
	private Integer tamlayout = 19115;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CUNIC-PSSOA-CMBIO")
	private Long cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CPSSOA")
	private Long cpssoa = 0L;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-IREDZD-PSSOA-CMBIO")
	private String iredzdpssoacmbio = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CD-EMPRESA")
	private Long cdempresa = 0L;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CD-CPFCNPJ")
	private Integer cdcpfcnpj = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CD-FILIAL")
	private Integer cdfilial = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CD-CTRL-CPFCNPJ")
	private Integer cdctrlcpfcnpj = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-NM-NOME-CLIENTE")
	private String nmnomecliente = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CPSSOA-UND-ORGNZ")
	private Long cpssoaundorgnz = 0L;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-NSEQ-UND-ORGNZ")
	private Integer nsequndorgnz = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CRCONH-UND-ORGNZ-M")
	private Integer crconhundorgnzm = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CRCONH-UND-ORGNZ-F")
	private Integer crconhundorgnzf = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-IRZ-SCIAL")
	private String irzscial = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CTPO-ASS-CMBIO")
	private Integer ctpoasscmbio = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CLIBRC-ASS-DGTAL")
	private String clibrcassdgtal = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CINDCD-CMBIO-WEB")
	private String cindcdcmbioweb = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CINDCD-PAPEL-ATIVO")
	private String cindcdpapelativo = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-ROBS-CLI-CMBIO")
	private String robsclicmbio = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CINDCD-BLOQ-CLI")
	private String cindcdbloqcli = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CAUTRZ-NOVOEX")
	private Integer cautrznovoex = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CAUTRZ-CAM0057")
	private Integer cautrzcam0057 = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CINDCD-CRRT-CMBIO")
	private String cindcdcrrtcmbio = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CINDCD-CONVENIO")
	private String cindcdconvenio = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CEMIS-AVISO-ORD")
	private String cemisavisoord = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-RJUSTF-INATV-CMBIO")
	private String rjustfinatvcmbio = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-RJUSTF-INOPR-CMBIO")
	private String rjustfinoprcmbio = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CINDCD-PAPEL-OPER")
	private String cindcdpapeloper = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CINDCD-FCHTO-AUTOM")
	private Integer cindcdfchtoautom = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CUSUAR-INCL")
	private String cusuarincl = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-IUSUAR-INCL")
	private String iusuarincl = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-HINCL-REG")
	private String hinclreg = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CUSUAR-MANUT")
	private String cusuarmanut = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-IUSUAR-MANUT")
	private String iusuarmanut = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-HMANUT-REG")
	private String hmanutreg = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-CUSUAR-ANLSE")
	private String cusuaranlse = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-IUSUAR-ANLSE")
	private String iusuaranlse = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-HANLSE-REG")
	private String hanlsereg = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-QTDE-CONT")
	private Integer qtdecont = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-QTDE-ENDE")
	private Integer qtdeende = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-QTDE-BRA")
	private Integer qtdebra = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-QTDE-OUT")
	private Integer qtdeout = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-QTDE-MOTVO-I")
	private Integer qtdemotvoi = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-QTDE-MOTVO-A")
	private Integer qtdemotvoa = 0;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-TIPO-DETALHE")
	private String tipodetalhe = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-CONT", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet.Npcdweysresponse_listacont")
	private List<Npcdweysresponse_listacont> listacont = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-ENDE", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet.Npcdweysresponse_listaende")
	private List<Npcdweysresponse_listaende> listaende = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-BRA", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet.Npcdweysresponse_listabra")
	private List<Npcdweysresponse_listabra> listabra = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-OUT", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet.Npcdweysresponse_listaout")
	private List<Npcdweysresponse_listaout> listaout = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-MOTVO-A", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet.Npcdweysresponse_listamotvoa")
	private List<Npcdweysresponse_listamotvoa> listamotvoa = null;

	@Adapter(transactionField = "NPCDWEYS-REGISTRO.NPCDWEYS-LISTA-MOTVO-I", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet.Npcdweysresponse_listamotvoi")
	private List<Npcdweysresponse_listamotvoi> listamotvoi = null;
	
	public String getCodlayout() {
		return codlayout;
	}
	public void setCodlayout(String codlayout) {
		this.codlayout = codlayout;
	}

	public Integer getTamlayout() {
		return tamlayout;
	}
	public void setTamlayout(Integer tamlayout) {
		this.tamlayout = tamlayout;
	}

	public Long getCunicpssoacmbio() {
		return cunicpssoacmbio;
	}
	public void setCunicpssoacmbio(Long cunicpssoacmbio) {
		this.cunicpssoacmbio = cunicpssoacmbio;
	}

	public Long getCpssoa() {
		return cpssoa;
	}
	public void setCpssoa(Long cpssoa) {
		this.cpssoa = cpssoa;
	}

	public String getIredzdpssoacmbio() {
		return iredzdpssoacmbio;
	}
	public void setIredzdpssoacmbio(String iredzdpssoacmbio) {
		this.iredzdpssoacmbio = iredzdpssoacmbio;
	}

	public Long getCdempresa() {
		return cdempresa;
	}
	public void setCdempresa(Long cdempresa) {
		this.cdempresa = cdempresa;
	}

	public Integer getCdcpfcnpj() {
		return cdcpfcnpj;
	}
	public void setCdcpfcnpj(Integer cdcpfcnpj) {
		this.cdcpfcnpj = cdcpfcnpj;
	}

	public Integer getCdfilial() {
		return cdfilial;
	}
	public void setCdfilial(Integer cdfilial) {
		this.cdfilial = cdfilial;
	}

	public Integer getCdctrlcpfcnpj() {
		return cdctrlcpfcnpj;
	}
	public void setCdctrlcpfcnpj(Integer cdctrlcpfcnpj) {
		this.cdctrlcpfcnpj = cdctrlcpfcnpj;
	}

	public String getNmnomecliente() {
		return nmnomecliente;
	}
	public void setNmnomecliente(String nmnomecliente) {
		this.nmnomecliente = nmnomecliente;
	}

	public Long getCpssoaundorgnz() {
		return cpssoaundorgnz;
	}
	public void setCpssoaundorgnz(Long cpssoaundorgnz) {
		this.cpssoaundorgnz = cpssoaundorgnz;
	}

	public Integer getNsequndorgnz() {
		return nsequndorgnz;
	}
	public void setNsequndorgnz(Integer nsequndorgnz) {
		this.nsequndorgnz = nsequndorgnz;
	}

	public Integer getCrconhundorgnzm() {
		return crconhundorgnzm;
	}
	public void setCrconhundorgnzm(Integer crconhundorgnzm) {
		this.crconhundorgnzm = crconhundorgnzm;
	}

	public Integer getCrconhundorgnzf() {
		return crconhundorgnzf;
	}
	public void setCrconhundorgnzf(Integer crconhundorgnzf) {
		this.crconhundorgnzf = crconhundorgnzf;
	}

	public String getIrzscial() {
		return irzscial;
	}
	public void setIrzscial(String irzscial) {
		this.irzscial = irzscial;
	}

	public Integer getCtpoasscmbio() {
		return ctpoasscmbio;
	}
	public void setCtpoasscmbio(Integer ctpoasscmbio) {
		this.ctpoasscmbio = ctpoasscmbio;
	}

	public String getClibrcassdgtal() {
		return clibrcassdgtal;
	}
	public void setClibrcassdgtal(String clibrcassdgtal) {
		this.clibrcassdgtal = clibrcassdgtal;
	}

	public String getCindcdcmbioweb() {
		return cindcdcmbioweb;
	}
	public void setCindcdcmbioweb(String cindcdcmbioweb) {
		this.cindcdcmbioweb = cindcdcmbioweb;
	}

	public String getCindcdpapelativo() {
		return cindcdpapelativo;
	}
	public void setCindcdpapelativo(String cindcdpapelativo) {
		this.cindcdpapelativo = cindcdpapelativo;
	}

	public String getRobsclicmbio() {
		return robsclicmbio;
	}
	public void setRobsclicmbio(String robsclicmbio) {
		this.robsclicmbio = robsclicmbio;
	}

	public String getCindcdbloqcli() {
		return cindcdbloqcli;
	}
	public void setCindcdbloqcli(String cindcdbloqcli) {
		this.cindcdbloqcli = cindcdbloqcli;
	}

	public Integer getCautrznovoex() {
		return cautrznovoex;
	}
	public void setCautrznovoex(Integer cautrznovoex) {
		this.cautrznovoex = cautrznovoex;
	}

	public Integer getCautrzcam0057() {
		return cautrzcam0057;
	}
	public void setCautrzcam0057(Integer cautrzcam0057) {
		this.cautrzcam0057 = cautrzcam0057;
	}

	public String getCindcdcrrtcmbio() {
		return cindcdcrrtcmbio;
	}
	public void setCindcdcrrtcmbio(String cindcdcrrtcmbio) {
		this.cindcdcrrtcmbio = cindcdcrrtcmbio;
	}

	public String getCindcdconvenio() {
		return cindcdconvenio;
	}
	public void setCindcdconvenio(String cindcdconvenio) {
		this.cindcdconvenio = cindcdconvenio;
	}

	public String getCemisavisoord() {
		return cemisavisoord;
	}
	public void setCemisavisoord(String cemisavisoord) {
		this.cemisavisoord = cemisavisoord;
	}

	public String getRjustfinatvcmbio() {
		return rjustfinatvcmbio;
	}
	public void setRjustfinatvcmbio(String rjustfinatvcmbio) {
		this.rjustfinatvcmbio = rjustfinatvcmbio;
	}

	public String getRjustfinoprcmbio() {
		return rjustfinoprcmbio;
	}
	public void setRjustfinoprcmbio(String rjustfinoprcmbio) {
		this.rjustfinoprcmbio = rjustfinoprcmbio;
	}

	public String getCindcdpapeloper() {
		return cindcdpapeloper;
	}
	public void setCindcdpapeloper(String cindcdpapeloper) {
		this.cindcdpapeloper = cindcdpapeloper;
	}

	public Integer getCindcdfchtoautom() {
		return cindcdfchtoautom;
	}
	public void setCindcdfchtoautom(Integer cindcdfchtoautom) {
		this.cindcdfchtoautom = cindcdfchtoautom;
	}

	public String getCusuarincl() {
		return cusuarincl;
	}
	public void setCusuarincl(String cusuarincl) {
		this.cusuarincl = cusuarincl;
	}

	public String getIusuarincl() {
		return iusuarincl;
	}
	public void setIusuarincl(String iusuarincl) {
		this.iusuarincl = iusuarincl;
	}

	public String getHinclreg() {
		return hinclreg;
	}
	public void setHinclreg(String hinclreg) {
		this.hinclreg = hinclreg;
	}

	public String getCusuarmanut() {
		return cusuarmanut;
	}
	public void setCusuarmanut(String cusuarmanut) {
		this.cusuarmanut = cusuarmanut;
	}

	public String getIusuarmanut() {
		return iusuarmanut;
	}
	public void setIusuarmanut(String iusuarmanut) {
		this.iusuarmanut = iusuarmanut;
	}

	public String getHmanutreg() {
		return hmanutreg;
	}
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
	}

	public String getCusuaranlse() {
		return cusuaranlse;
	}
	public void setCusuaranlse(String cusuaranlse) {
		this.cusuaranlse = cusuaranlse;
	}

	public String getIusuaranlse() {
		return iusuaranlse;
	}
	public void setIusuaranlse(String iusuaranlse) {
		this.iusuaranlse = iusuaranlse;
	}

	public String getHanlsereg() {
		return hanlsereg;
	}
	public void setHanlsereg(String hanlsereg) {
		this.hanlsereg = hanlsereg;
	}

	public Integer getQtdecont() {
		return qtdecont;
	}
	public void setQtdecont(Integer qtdecont) {
		this.qtdecont = qtdecont;
	}

	public Integer getQtdeende() {
		return qtdeende;
	}
	public void setQtdeende(Integer qtdeende) {
		this.qtdeende = qtdeende;
	}

	public Integer getQtdebra() {
		return qtdebra;
	}
	public void setQtdebra(Integer qtdebra) {
		this.qtdebra = qtdebra;
	}

	public Integer getQtdeout() {
		return qtdeout;
	}
	public void setQtdeout(Integer qtdeout) {
		this.qtdeout = qtdeout;
	}

	public Integer getQtdemotvoi() {
		return qtdemotvoi;
	}
	public void setQtdemotvoi(Integer qtdemotvoi) {
		this.qtdemotvoi = qtdemotvoi;
	}

	public Integer getQtdemotvoa() {
		return qtdemotvoa;
	}
	public void setQtdemotvoa(Integer qtdemotvoa) {
		this.qtdemotvoa = qtdemotvoa;
	}

	public String getTipodetalhe() {
		return tipodetalhe;
	}
	public void setTipodetalhe(String tipodetalhe) {
		this.tipodetalhe = tipodetalhe;
	}

	public List<Npcdweysresponse_listacont> getListacont() {
		return listacont;
	}
	public void setListacont( List<Npcdweysresponse_listacont> listacont) {
		this.listacont = listacont;
	}

	public List<Npcdweysresponse_listaende> getListaende() {
		return listaende;
	}
	public void setListaende( List<Npcdweysresponse_listaende> listaende) {
		this.listaende = listaende;
	}

	public List<Npcdweysresponse_listabra> getListabra() {
		return listabra;
	}
	public void setListabra( List<Npcdweysresponse_listabra> listabra) {
		this.listabra = listabra;
	}

	public List<Npcdweysresponse_listaout> getListaout() {
		return listaout;
	}
	public void setListaout( List<Npcdweysresponse_listaout> listaout) {
		this.listaout = listaout;
	}

	public List<Npcdweysresponse_listamotvoa> getListamotvoa() {
		return listamotvoa;
	}
	public void setListamotvoa( List<Npcdweysresponse_listamotvoa> listamotvoa) {
		this.listamotvoa = listamotvoa;
	}

	public List<Npcdweysresponse_listamotvoi> getListamotvoi() {
		return listamotvoi;
	}
	public void setListamotvoi( List<Npcdweysresponse_listamotvoi> listamotvoi) {
		this.listamotvoi = listamotvoi;
	}
    
}