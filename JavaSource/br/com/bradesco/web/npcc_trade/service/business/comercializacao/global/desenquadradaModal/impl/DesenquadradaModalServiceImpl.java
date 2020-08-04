package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarBloqCliente.Consultarbloqclienterequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarBloqCliente.Consultarbloqclienteresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarBloqCliente.Npccwmperequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsultarBloqCliente.Npccwmpsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento.Desenquadramentorequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento.Desenquadramentoresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento.Npccwmnerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento.Npccwmnerequest_listaspread;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento.Npccwmnsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento.Npccwmnsresponse_dadoslista_ab;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento.Npccwmnsresponse_dadoslista_credito;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento.Npccwmnsresponse_dadoslista_pa;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Desenquadramento.Npccwmnsresponse_dadoslista_st;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.IDesenquadradaModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean.DesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean.DesenquadramentoAnyBankVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean.DesenquadramentoCreditoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean.DesenquadramentoPagamentoAntecipadoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean.DesenquadramentoStandByVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean.DesenquadramentoVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;


@Named("desenquadradaModalService")
@RequestScoped
public class DesenquadradaModalServiceImpl extends BaseService implements IDesenquadradaModalService {

	 /** Variavel do tipo long. */
	private static final long serialVersionUID = -3708424705149347239L;

	/**
     * Nome: consutarBloqueioCliente
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 21/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String consultarBloqueioCliente(Long codUnicoPessoa) {

        Consultarbloqclienterequest request = new Consultarbloqclienterequest();
        Consultarbloqclienteresponse response = new Consultarbloqclienteresponse();
        Npccwmperequest entrada = new Npccwmperequest();
        Npccwmpsresponse saida = new Npccwmpsresponse();

        request.setNpccwmperequest(entrada);
        response.setNpccwmpsresponse(saida);

        entrada.setCunicpssoacmbio(codUnicoPessoa);

        // executa chamada CWS - Fluxo NPCCIAS9 - Books: NPCCWMPE / NPCCWMPS
        listaSemPaginacao(request, response, "CONSULTARBLOQCLIENTE");      

        setMsgRetorno(response.getTexmens());
        
        return saida.getCclibloqdqmto();

    }
    
    /**
     * Nome: pesquisar
     * 
     * Propósito: Carrega a Lista de Desenquadramentos
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/05/2016 - Autor: BRQ - Francinaldo - Responsavel: Equipe Web - Adequação ao
     *      padrão hexavision.
     */
    public DesenquadramentoVO pesquisar(DesenquadramentoVO vo) {
        List<DesenquadramentoCreditoVO> creditos = new ArrayList<DesenquadramentoCreditoVO>();        
        List<DesenquadramentoAnyBankVO> anyBank = new ArrayList<DesenquadramentoAnyBankVO>();
        List<DesenquadramentoStandByVO> standBy = new ArrayList<DesenquadramentoStandByVO>();
        List<DesenquadramentoPagamentoAntecipadoVO> pagamentosAntecipados = 
                        new ArrayList<DesenquadramentoPagamentoAntecipadoVO>();
        
        Desenquadramentorequest request = new Desenquadramentorequest();
        Npccwmnerequest entrada = new Npccwmnerequest();
        request.setNpccwmnerequest(entrada);

        Desenquadramentoresponse response = new Desenquadramentoresponse();
        Npccwmnsresponse saida = new Npccwmnsresponse();
        response.setNpccwmnsresponse(saida);

        entrada.setCprodtservc(vo.getCprodtservc());
        entrada.setCidtfdmesacmbio(vo.getCidtfdmesacmbio());
        entrada.setCindcdeconmmoeda(vo.getCindcdeconmmoeda());
        entrada.setCunicclicmbio(vo.getCunicclicmbio());
        entrada.setCindcdcartaidpdt(vo.getCindcdcartaidpdt());
        entrada.setCindcdnegoccarta(vo.getCindcdnegoccarta());
        
        if(!SiteUtil.isEmptyOrNull(vo.getDprevtembrq())) {
            entrada.setDprevtembrq(vo.getDprevtembrq().replace("/", "."));
        } else {
            entrada.setDprevtembrq("01.01.0001");
        }
        
        entrada.setDprevtdsembcmbio(vo.getDprevtdsembcmbio());
        entrada.setNppstapontucmbio(vo.getNppstapontucmbio());
        entrada.setNseqcontrlim(vo.getNseqcontrlim());
        entrada.setPtxparidade(SiteUtil.getDouble(vo.getPtxparidade()));
        entrada.setTdiavalddcarta(vo.getTdiavalddcarta());
        //Se produto for BNDES pós, utiliza o valor financiado para o desenquadramento da operação e limite
		if (vo.getProduto().isBndesPos())
			entrada.setVnegocmoedaestrg(SiteUtil.webMoedaToMainframe(vo.getVprevtrectacmbio()));
		else
			entrada.setVnegocmoedaestrg(SiteUtil.webMoedaToMainframe(vo.getVnegocmoedaestrg()));
        entrada.setTdiaopercmbio(vo.getTdiaopercmbio());
        
        // Informa valor do Spread Total caso seja estes produtos relacionados abaixo:
        // FINIMP ECA
        // FINIMP DIRETO/ REFINIMP DIRETO
        // FINIMP INDIRETO/ REFINIMP INDIRETO
        // LEI 4131
        // PPE
        // WORKING CAPITAL
        // FORFAITING
        if(vo.getProduto().equals(EnumProduto.FINIMP_ECA)
                        || vo.getProduto().equals(EnumProduto.PRODUTO_FINIMP_DIRETO)
                        || vo.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO)
                        || vo.getProduto().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO)
                        || vo.getProduto().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO)
                        || vo.getProduto().equals(EnumProduto.PRODUTO_LEI_4131)
                        || vo.getProduto().equals(EnumProduto.PRODUTO_P_P_E)
                        || vo.getProduto().equals(EnumProduto.PRODUTO_WORKING_CAPITAL)
                        || vo.getProduto().equals(EnumProduto.PRODUTO_FORFAITING)) {
            
            entrada.setPspreadtxcmbio(SiteUtil.getDouble(SiteUtil.webMoedaToMainframe(vo.getVtxspreadtot())));
        }
        // Informa valor do spread All-in caso esteja preenchido no lugar do Spread negociado
        else if (SiteUtil.isValueZero(vo.getPtxswapcmpdo())){
            entrada.setPspreadtxcmbio(SiteUtil.getDouble(SiteUtil.webMoedaToMainframe(vo.getPspreadtxcmbio())));
        } 
        // Informa valor do da taxa
        else {
            entrada.setPspreadtxcmbio(SiteUtil.getDouble(SiteUtil.webMoedaToMainframe(vo.getPtxswapcmpdo())));
        }
        
        entrada.setVlimcobervar(SiteUtil.getDouble(SiteUtil.webMoedaToMainframe(vo.getVlimcobervar())));
        
        
        List<Npccwmnerequest_listaspread> listaSpred = new ArrayList<Npccwmnerequest_listaspread>();
        for (DesembolsoVO desemb : vo.getDesembolso()) {
        	Npccwmnerequest_listaspread spred = new Npccwmnerequest_listaspread();
        	spred.setListaspread_spreaddesemb(desemb.getSpreadDesemb());
        	listaSpred.add(spred);
		}
        entrada.setListaspread(listaSpred);
        entrada.setQtdedesemb(listaSpred.size());
            
        // executa chamada CWS - Fluxo NPCCIAS7 - Books: NPCCWMNE / NPCCWMNS
        listaSemPaginacao(request, response, "DESENQUADRAMENTO");
        setMsgRetorno(response.getTexmens());

        vo.setInddqmto(saida.getInddqmto());
        vo.setCodmoedaoper(saida.getCodmoedaoper());
        vo.setSiglamoedaoper(saida.getSiglamoedaoper());
        vo.setDescmoedaoper(saida.getDescmoedaoper());
        vo.setCodmoedalim(saida.getCodmoedalim());
        vo.setSiglamoedalim(saida.getSiglamoedalim());
        vo.setDescmoedalim(saida.getDescmoedalim());
        
        // Percorre todos as ocorrencias
        for (int i = 0; i < saida.getDadoslista_cntcredito(); i++) {
            Npccwmnsresponse_dadoslista_credito ocorr = saida.getDadoslista_credito().get(i);
            
            DesenquadramentoCreditoVO item = new DesenquadramentoCreditoVO();
            item.setDesccred(ocorr.getDadoslista_credito_desccred());
            item.setVmotvodisp(ocorr.getDadoslista_credito_vmotvodisp());
            item.setVmotvosolic(ocorr.getDadoslista_credito_vmotvosolic());
            
            creditos.add(item);
        }
        
        vo.setCreditos(creditos);
        
        // Percorre todos as ocorrencias
        for (int i = 0; i < saida.getDadoslista_scntpa(); i++) {
            Npccwmnsresponse_dadoslista_pa ocorr = saida.getDadoslista_pa().get(i);
            
            DesenquadramentoPagamentoAntecipadoVO item = new DesenquadramentoPagamentoAntecipadoVO();
            item.setDescpgto(ocorr.getDadoslista_pa_descpgto());
            item.setDprevtdsemb(ocorr.getDadoslista_pa_dprevtdsemb());
            item.setDprevtembrq(ocorr.getDadoslista_pa_dprevtembrq());
            
            pagamentosAntecipados.add(item);
        }
        
        vo.setPagamentosAntecipados(pagamentosAntecipados);
        
        // Percorre todos as ocorrencias
        for (int i = 0; i < saida.getDadoslista_cntab(); i++) {
            Npccwmnsresponse_dadoslista_ab ocorr = saida.getDadoslista_ab().get(i);
            
            DesenquadramentoAnyBankVO item = new DesenquadramentoAnyBankVO();
            item.setDescany(ocorr.getDadoslista_ab_descany());
            item.setCondicao(ocorr.getDadoslista_ab_condicao());
            
            anyBank.add(item);
        }
        
        vo.setAnyBank(anyBank);
        
        // Percorre todos as ocorrencias
        for (int i = 0; i < saida.getDadoslista_cntst(); i++) {
            Npccwmnsresponse_dadoslista_st ocorr = saida.getDadoslista_st().get(i);
            
            DesenquadramentoStandByVO item = new DesenquadramentoStandByVO();
            item.setDescstand(ocorr.getDadoslista_st_descstand());
            item.setTdiamax(ocorr.getDadoslista_st_tdiamax());
            item.setTdiavaldd(ocorr.getDadoslista_st_tdiavaldd());
            
            standBy.add(item);
        }
        
        vo.setStandBy(standBy);
        
        return vo;
    }

    /**
     * @return o valor do serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
	
}
