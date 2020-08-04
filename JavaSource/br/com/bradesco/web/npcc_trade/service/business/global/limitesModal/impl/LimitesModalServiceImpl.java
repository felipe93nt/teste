/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.limitesModal.impl
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 02/03/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.global.limitesModal.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiasRecCotList.Garantiasreccotlistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiasRecCotList.Garantiasreccotlistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiasRecCotList.Npccwpperequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiasRecCotList.Npccwppsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiasRecCotList.Npccwppsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PropostaPontualList.Npccwmherequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PropostaPontualList.Npccwmhsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PropostaPontualList.Npccwmhsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PropostaPontualList.Propostapontuallistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.PropostaPontualList.Propostapontuallistresponse;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.service.business.global.clienteModal.bean.LimitesModalVO;
import br.com.bradesco.web.npcc_trade.service.business.global.limitesModal.ILimitesModalService;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
 * Nome: LimitesModalServiceImpl.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 02/03/2016 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */

@Named("limitesModalService")
@RequestScoped
public class LimitesModalServiceImpl extends BaseService implements
        ILimitesModalService, Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    /**
     * Nome: getListaCotacao
     * 
     * Propósito: Carrega a lista de Limites
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<LimitesModalVO> listarLimite(LimitesModalVO filtro) {

        Garantiasreccotlistrequest request = new Garantiasreccotlistrequest();
        Npccwpperequest entrada = new Npccwpperequest();
        request.setNpccwpperequest(entrada);

        Garantiasreccotlistresponse response = new Garantiasreccotlistresponse();
        Npccwppsresponse saida = new Npccwppsresponse();
        response.setNpccwppsresponse(saida);

        entrada.setCprodtservc(filtro.getProduto());
        entrada.setCunicpssoacmbio(filtro.getCunicpssoacmbio());
        entrada.setCidtfdmesacmbio(Numeros.DOIS);

        // executa chamada CWS - Fluxo NPCCIAJC - Books: NPCCWPPE / NPCCWPPS
        listaComPaginacao(request, response, "GARANTIASRECCOTLIST", "NPCCIAJC");
        setMsgRetorno(response.getTexmens());

        List<LimitesModalVO> lista = new ArrayList<LimitesModalVO>();

        for (int i = Numeros.ZERO; i < saida.getQtdeocorr(); i++) {
            Npccwppsresponse_lista ocorr = saida.getLista().get(i);
            LimitesModalVO item = new LimitesModalVO();

            item.setCindcdeconmmoeda(ocorr.getLista_cindcdeconmmoeda());
            item.setCprodtservcoper(ocorr.getLista_cprodtservcoper());
            item.setCprodtservc(ocorr.getLista_cprodtservcoper());
            item.setCpssoajurid(ocorr.getLista_cpssoajurid());
            item.setCpssoajuriddesc(ocorr.getLista_cpssoajuriddesc());
            item.setDescrprodtlimite(ocorr.getLista_descrprodtlimite());
            item.setDvctolimgerc(SiteUtil.trocarPontoPorBarra(ocorr.getLista_dvctolimgerc()));
            item.setVenclimite(SiteUtil.trocarPontoPorBarra(ocorr.getLista_dvctolimgerc()));
            item.setVdispnlimgerc(SiteUtil.trocarPontoPorVirgula(ocorr.getLista_vdispnlimgerc()));
            item.setVutlzdlimgerc(SiteUtil.trocarPontoPorVirgula(ocorr.getLista_vutlzdlimgerc()));            
            item.setDescrgarntprinc(ocorr.getLista_descrgarntprinc());
            item.setCcatlggarntprinc(ocorr.getLista_ccatlggarntprinc());
            item.setDescrmoeda(ocorr.getLista_descrmoeda());
            item.setPvctolimgerc(ocorr.getLista_pvctolimgerc());
            item.setPspreadprodt(SiteUtil.trocarPontoPorVirgula(ocorr.getLista_pspreadprodt()));
            item.setNcontrlim(ocorr.getLista_ncontrlim());
            lista.add(item);
        }
      
        return lista;
    }

    /**
     * Nome: getListaProposta
     * 
     * Propósito: Carrega a lista de propostas Pontuais
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<LimitesModalVO> listarProposta(LimitesModalVO filtro) {
        Propostapontuallistrequest request = new Propostapontuallistrequest();
        Npccwmherequest entrada = new Npccwmherequest();
        request.setNpccwmherequest(entrada);

        Propostapontuallistresponse response = new Propostapontuallistresponse();
        Npccwmhsresponse saida = new Npccwmhsresponse();
        response.setNpccwmhsresponse(saida);

        entrada.setCprodtservc(filtro.getProduto());
        entrada.setCunicpssoacmbio(filtro.getCunicpssoacmbio());
        entrada.setCidtfdmesacmbio(Numeros.DOIS);

        // executa chamada CWS - Fluxo NPCCIAS2 - Books: NPCCWMHE / NPCCWMHS
        listaComPaginacao(request, response, "PROPOSTAPONTUALLIST", "NPCCIAS2");
        setMsgRetorno(response.getTexmens());

        List<LimitesModalVO> lista = new ArrayList<LimitesModalVO>();
        for (int i = Numeros.ZERO; i < saida.getQtdeocorr(); i++) {
            Npccwmhsresponse_lista ocorr = saida.getLista().get(i);
            LimitesModalVO item = new LimitesModalVO();

            item.setNumproposta(ocorr.getLista_nseqcontrppl());
            item.setNseqcontrppl(ocorr.getLista_nseqcontrppl());
            
            item.setCprodtservcoper(ocorr.getLista_cprodtservc());
            item.setDescrprodtlimite(ocorr.getLista_descrprodtlimite());
            item.setCindcdeconmmoeda(ocorr.getLista_cindcdeconmmoeda());
            item.setDescrmoeda(ocorr.getLista_descrmoeda());
            item.setVutlzdlimgerc(SiteUtil.trocarPontoPorVirgula(ocorr.getLista_vprincppstanegoc()));
            item.setPvctolimgerc(ocorr.getLista_pvctolimgerc());
            item.setPspreadprodt(SiteUtil.trocarPontoPorVirgula(ocorr.getLista_pspreadnegoc()));
            item.setCcatlggarntprinc(ocorr.getLista_ccatlggarnt());
            item.setDescrgarntprinc(ocorr.getLista_descrgarntprinc());
            item.setDvctolimgerc(SiteUtil.trocarPontoPorBarra(ocorr.getLista_dtsolicppl()));
            item.setDescrseg(ocorr.getLista_descrseg());
            
            lista.add(item);
        }
        return lista;
    }
}
