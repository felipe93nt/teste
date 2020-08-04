package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tipoClausula.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaAlt.Npccwvderequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaAlt.Npccwvdsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaAlt.Tipoclausulaaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaAlt.Tipoclausulaaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaExcl.Npccwveerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaExcl.Npccwvesresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaExcl.Tipoclausulaexclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaExcl.Tipoclausulaexclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaIncl.Npccwvberequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaIncl.Npccwvbsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaIncl.Tipoclausulainclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaIncl.Tipoclausulainclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaList.Npccwvaerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaList.Npccwvasresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaList.Npccwvasresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaList.Tipoclausulalistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TipoClausulaList.Tipoclausulalistresponse;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tipoClausula.ITipoClausulaService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tipoClausula.bean.TipoClausulaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
 * 
 * Nome: TipoClausulaServiceImpl.java
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
 *      Registro de Manutenção: 27/11/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */

@Named("tipoClausulaService")
@SessionScoped
public class TipoClausulaServiceImpl extends BaseService implements ITipoClausulaService {

    /**
    *
    */

    private static final long serialVersionUID = 1L;

    /**
     * Construtor.
     */

    public TipoClausulaServiceImpl() {
        super();
    }

    /**
     * 
     * Nome: getLista Propósito: Carrega a lista de Tipo de Clausula
     *
     * @param : <BR/>
     * @return : List<FormaLiquidacaoVO>
     *
     * @throws : NpcdServiceBusinessException
     * 
     * @exception : NpcdServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */

    @Override
    public List<TipoClausulaVO> listar() {
        List<TipoClausulaVO> listaVO = new ArrayList<TipoClausulaVO>();

        Tipoclausulalistrequest request = new Tipoclausulalistrequest();
        Tipoclausulalistresponse response = new Tipoclausulalistresponse();
        Npccwvaerequest bookEntrada = new Npccwvaerequest();
        Npccwvasresponse bookSaida = new Npccwvasresponse();

        request.setNpccwvaerequest(bookEntrada);
        response.setNpccwvasresponse(bookSaida);

        // carrega book de entrada
        bookEntrada.setCtpoclauscmbio(Numeros.ZERO);

        // // Executa chamada CWS - Fluxo: NPCCIAOC - Books: NPCCWVAE / NPCCWVAS
        listaComPaginacao(request, response, "TIPOCLAUSULALIST", "NPCCIAOC");

        // // trata retorno
        this.setMsgRetorno(response.getTexmens());

        // carrega lista de retorno
        for (int i = Numeros.ZERO; i < bookSaida.getQtdeocorr(); i++) {
            Npccwvasresponse_lista objFrom = bookSaida.getLista().get(i);
            TipoClausulaVO objTo = new TipoClausulaVO();

            // // Copia os valores das propriedades com o mesmo nome
            // // automaticamente
            SiteUtil.copyPropertiesObjects(objFrom, objTo, "lista_", true);
            // objTo.setCtpoclauscmbio(objFrom.getLista_ctpoclauscmbio());

            listaVO.add(objTo);

        }
        return listaVO;
    }

    /**
     * Nome: incluir
     * 
     * Propósito: Incluir TipoClausulaVO
     *
     * @param : TipoClausulaVO
     * @return : Messagem de retorno do MF
     *
     * @throws : NpcdServiceBusinessException
     * 
     * @exception : NpcdServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String incluir(TipoClausulaVO obj) {
        Tipoclausulainclrequest request = new Tipoclausulainclrequest();
        Tipoclausulainclresponse response = new Tipoclausulainclresponse();
        Npccwvberequest entrada = new Npccwvberequest();
        Npccwvbsresponse saida = new Npccwvbsresponse();
        request.setNpccwvberequest(entrada);
        response.setNpccwvbsresponse(saida);

        entrada.setItpoclauscmbio(obj.getItpoclauscmbio());

        listaSemPaginacao(request, response, "TIPOCLAUSULAINCL");

        return response.getTexmens();
    }

    /**
     * 
     * Nome: alterar Propósito: alterar TipoClasulaVO
     *
     * @param : TipoClasulaVO
     * @return : Messagem de retorno do MF
     *
     * @throws : NpcdServiceBusinessException
     * 
     * @exception : NpcdServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    @Override
    public String alterar(TipoClausulaVO obj) {
        Tipoclausulaaltrequest request = new Tipoclausulaaltrequest();
        Tipoclausulaaltresponse response = new Tipoclausulaaltresponse();
        Npccwvderequest entrada = new Npccwvderequest();
        Npccwvdsresponse saida = new Npccwvdsresponse();
        request.setNpccwvderequest(entrada);
        response.setNpccwvdsresponse(saida);

        SiteUtil.copyPropertiesObjects(obj, entrada);

        listaSemPaginacao(request, response, "TIPOCLAUSULAALT");

        return response.getTexmens();
    }

    /**
     * 
     * Nome: excluir
     * 
     * Propósito: Valida os dados para realizar a exlusão de um registro
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    @Override
    public String excluir(TipoClausulaVO obj) {
        Tipoclausulaexclrequest request = new Tipoclausulaexclrequest();
        Tipoclausulaexclresponse response = new Tipoclausulaexclresponse();
        Npccwveerequest entrada = new Npccwveerequest();
        Npccwvesresponse saida = new Npccwvesresponse();
        request.setNpccwveerequest(entrada);
        response.setNpccwvesresponse(saida);

        entrada.setCtpoclauscmbio(obj.getCtpoclauscmbio());

        listaSemPaginacao(request, response, "TIPOCLAUSULAEXCL");

        return response.getTexmens();

    }

}
