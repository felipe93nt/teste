/**
 * Nome:  br.com.bradesco.web.npcc_trade.service.business.parametros.formaLiquidacao.impl
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 13/07/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */

package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.pagination.PaginationAPI;
import br.com.bradesco.web.aq.application.pagination.PaginationRequest;
import br.com.bradesco.web.aq.application.pagination.PaginationResponse;
import br.com.bradesco.web.aq.application.pagination.cws.CWSPaginationAPIAdapterImpl;
import br.com.bradesco.web.aq.application.pagination.cws.baseconnector.CWSBusinessServiceBaseConnector;
import br.com.bradesco.web.aq.application.pagination.factory.PaginationAPIFactory;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoAlt.Modeloboletoaltrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoAlt.Modeloboletoaltresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoAlt.Npccwvperequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoAlt.Npccwvperequest_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoDet.Modeloboletodetrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoDet.Modeloboletodetresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoDet.Npccwvoerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoDet.Npccwvosresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoDet.Npccwvosresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoExcl.Modeloboletoexclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoExcl.Modeloboletoexclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoExcl.Npccwvqerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoExcl.Npccwvqsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoIncl.Modeloboletoinclrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoIncl.Modeloboletoinclresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoIncl.Npccwvnerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoIncl.Npccwvnerequest_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList.Modeloboletolistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList.Modeloboletolistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList.Npccwvmerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList.Npccwvmsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoList.Npccwvmsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboClausulaVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.IModeloBoletoService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.ModeloBoletoVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.LineBreaks;

/**
 *
 * Nome: FormaLiquidacaoServiceImpl Propósito: Serviços para a funcionalidade <br/>
 *
 * Data: 13/07/2015 <br/>
 * 
 * @author BRQ <br/>
 *         copyright Copyright (c) 2015 <br/>
 *
 * @version 1.0
 * @see
 */
@Named("modeloBoletoService")
@SessionScoped
public class ModeloBoletoServiceImpl extends BaseService implements IModeloBoletoService {

    /**
    *
    */
    private static final long serialVersionUID = 1L;

    /**
     * Construtor.
     */
    public ModeloBoletoServiceImpl() {
        super();
    }

    /**
     * 
     * Nome: getLista 
     * Propósito: Carrega a lista de Produtos
     *
     * @param : filtroProduto
     * @return : listaVO
     *
     * @throws : NpccServiceBusinessException
     * 
     * @exception : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 27/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    @Override
    public List<ModeloBoletoVO> listar(Integer filtroProduto) {

        List<ModeloBoletoVO> listaVO = new ArrayList<ModeloBoletoVO>();

        Modeloboletolistrequest request = new Modeloboletolistrequest();
        Modeloboletolistresponse response = new Modeloboletolistresponse();
        Npccwvmerequest bookEntrada = new Npccwvmerequest();
        Npccwvmsresponse bookSaida = new Npccwvmsresponse();

        request.setNpccwvmerequest(bookEntrada);
        response.setNpccwvmsresponse(bookSaida);

        // carrega book de entrada
        bookEntrada.setCprodtserv(filtroProduto);

        // executa chamada CWS
        listaComPaginacao(request, response, "MODELOBOLETOLIST", "NPCCIAOO");

        // trata retorno
        this.setMsgRetorno(response.getTexmens());

        // carrega lista de retorno
        for (int i = Numeros.ZERO; i < response.getNpccwvmsresponse().getQtdeocorr(); i++) {

            Npccwvmsresponse_lista objFrom = response.getNpccwvmsresponse().getLista().get(i);
            ModeloBoletoVO objTo = new ModeloBoletoVO();

            // Copia os valores das propriedades com o mesmo nome
            // automaticamente
            objTo.setImodcontrcmbio(objFrom.getLista_imodcontrcmbio());
            objTo.setCmodcontrcmbio(objFrom.getLista_cmodcontrcmbio());
            objTo.setCindcdmodpdrao(objFrom.getLista_cindcdmodpdrao().equals("S")? true:false );

            // Seta os valor dos campos que não vem do MF

            listaVO.add(objTo);
        }

        return listaVO;

    }
    
    /**
     * 
     * Nome: obterModeloBoleto
     * 
     * Propósito: Obter dados da Cláusula e enviar pra página seguinte
     *
     * @param : codModeloBoleto
     * @return : Objeto modeloBoletoVO
     *
     * @throws : NpccServiceBusinessException
     * 
     * @exception : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    @Override
    public ModeloBoletoVO detalhar(Integer codModeloBoleto) {
      
        ModeloBoletoVO modeloBoletoVO = new ModeloBoletoVO();
        modeloBoletoVO.setLista(new ArrayList<ComboClausulaVO>());

        Modeloboletodetrequest request = new Modeloboletodetrequest();
        Modeloboletodetresponse response = new Modeloboletodetresponse();
        Npccwvoerequest bookEntrada = new Npccwvoerequest();
        Npccwvosresponse bookSaida = new Npccwvosresponse();

        request.setNpccwvoerequest(bookEntrada);
        response.setNpccwvosresponse(bookSaida);

        // carrega book de entrada
        bookEntrada.setCmodcontrcmbio(codModeloBoleto);
        
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("response", response);
        params.put("transactionName", "MODELOBOLETODET");

        CWSPaginationAPIAdapterImpl<CWSBusinessServiceBaseConnector> apiAdapter =
                new CWSPaginationAPIAdapterImpl<CWSBusinessServiceBaseConnector>(getAdapterCWS());
        PaginationAPI paginationAPI = PaginationAPIFactory.getInstance().getAPI("cws", apiAdapter, params);

        boolean init = false;
        boolean hasMoreData = false;
        //chama o mainframe enquanto ainda houver dados (hasMoreDataRight == true)
        do {
            PaginationRequest<Modeloboletodetrequest> paginationRequest = new PaginationRequest<Modeloboletodetrequest>(request);
            
            //preparando o objeto que vai receber o response da API, que encapsula o response do adaptador
            PaginationResponse<Modeloboletodetresponse> paginationResponse = null;
            
            if (!init) {
                init = true;
                //inicializa a paginacao atraves da API de paginacao e obtem o retorno do adaptador
                //encapsulado em um response da API
                paginationResponse = paginationAPI.init(paginationRequest);
            } else {
                //obtem a proxima leva de dados do MF e retorna o response da API que encapsula o retorno
                paginationResponse = paginationAPI.next(paginationRequest);
            }
            
            //atualiza a flag que informa se tem mais dados para frente (a direita)
            hasMoreData = paginationResponse.isHasMoreDataRight();
            response = paginationResponse.getResponse();
            
            // trata retorno
            this.setMsgRetorno(response.getTexmens());
            
            // copia propiedades
            modeloBoletoVO.setCmodcontrcmbio(bookSaida.getCmodcontrcmbio());
            modeloBoletoVO.setImodcontrcmbio(bookSaida.getImodcontrcmbio());
            modeloBoletoVO.setCprodtservc(bookSaida.getCprodtservc());
            modeloBoletoVO.setCindcdmodpdrao(bookSaida.getCindcdmodpdrao().equals("S")?true:false);
            
            //processa os dados retornados pelo CWS
            for (int i = 0; i < response.getNpccwvosresponse().getQtdeocorr(); i++) {
                Npccwvosresponse_lista objFrom = response.getNpccwvosresponse().getLista().get(i);
                ComboClausulaVO objTo = new ComboClausulaVO();

                // Copia propiedades
                objTo.setCclauscontrcmbio(objFrom.getLista_cclausmodcmbio());
                objTo.setRclauscontrcmbio(LineBreaks.formatToWeb(objFrom.getLista_rclausmodcmbio()));
                objTo.setCtpoclauscmbio(objFrom.getLista_ctpoclauscmbio());
                objTo.setItpoclauscmbio(objFrom.getLista_itpoclauscmbio());

                modeloBoletoVO.getLista().add(objTo);
            }
            
        } while (hasMoreData);
        
        return modeloBoletoVO;
    }
    
    /**
     * Nome: incluir
     * 
     * Propósito: Incluir ModeloBoletoVO
     *
     * @param : ModeloBoletoVO
     * @return : Messagem de retorno do MF
     *
     * @throws : NpcdServiceBusinessException
     * 
     * @exception : NpcdServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public final String incluir(ModeloBoletoVO modeloBoleto) {
    	
      Modeloboletoinclrequest request = new Modeloboletoinclrequest();
      Modeloboletoinclresponse response = new Modeloboletoinclresponse();
      Npccwvnerequest entrada = new Npccwvnerequest();

      request.setNpccwvnerequest(entrada);

      entrada.setLista(new ArrayList<Npccwvnerequest_lista>());
      entrada.setQtdeocorr(modeloBoleto.getLista().size());
      entrada.setCmodldprodtcmbio(SiteUtil.getInt(modeloBoleto.getCmodldprodtcmbio()));
      entrada.setCprodtservc(SiteUtil.getInt(modeloBoleto.getCprodtservc()));
      entrada.setImodcontrcmbio(SiteUtil.getString(modeloBoleto.getImodcontrcmbio()));
      entrada.setCunicpssoacmbio(SiteUtil.getLong(modeloBoleto.getCunicpssoacmbio()));
      entrada.setCindcdmodpdrao(modeloBoleto.getCindcdmodpdrao()?"S":"N");

      for (int i = 0; i < modeloBoleto.getLista().size(); i++) {
          ComboClausulaVO objFrom = modeloBoleto.getLista().get(i);
        
          Npccwvnerequest_lista objTo = new Npccwvnerequest_lista();

          objTo.setLista_cclauscontrcmbio(objFrom.getCclauscontrcmbio());
          objTo.setLista_nordmodcmbio(i + 1);
          
          entrada.getLista().add(objTo);
      }
      

      listaSemPaginacao(request, response, "MODELOBOLETOINCL");

      return response.getTexmens();
  }

    /**
     * 
     * Nome: alterar 
     * 
     * Propósito: alterar ModeloBoletoVO
     *
     * @param : ModeloBoletoVO
     * @return : Messagem de retorno do MF
     *
     * @throws : NpcdServiceBusinessException
     * 
     * @exception : NpcdServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public final String alterar(ModeloBoletoVO modeloBoleto) {

        Modeloboletoaltrequest request = new Modeloboletoaltrequest();
        Modeloboletoaltresponse response = new Modeloboletoaltresponse();
        Npccwvperequest entrada = new Npccwvperequest();

        request.setNpccwvperequest(entrada);

        entrada.setLista(new ArrayList<Npccwvperequest_lista>());
        entrada.setQtdeocorr(modeloBoleto.getLista().size());
        entrada.setCmodcontrcmbio(SiteUtil.getInt(modeloBoleto.getCmodcontrcmbio()));
        entrada.setImodcontrcmbio(SiteUtil.getString(modeloBoleto.getImodcontrcmbio()));
        entrada.setCprodtservc(modeloBoleto.getCprodtservc());
        entrada.setCindcdmodpdrao(modeloBoleto.getCindcdmodpdrao()?"S":"N");

        for (int i = 0; i < modeloBoleto.getLista().size(); i++) {
            ComboClausulaVO objFrom = modeloBoleto.getLista().get(i);
            
            Npccwvperequest_lista objTo = new Npccwvperequest_lista();

            objTo.setLista_cclauscontrcmbio(objFrom.getCclauscontrcmbio());
            objTo.setLista_nordmodcmbio(i + 1);

            entrada.getLista().add(objTo);
        }
        
        listaSemPaginacao(request, response, "MODELOBOLETOALT");

        return response.getTexmens();

    }

    /**
     * 
     * Nome: excluir 
     * 
     * Propósito: excluir ModeloBoletoVO
     *
     * @param : ModeloBoletoVO
     * @return : Messagem de retorno do MF
     *
     * @throws : NpcdServiceBusinessException
     * 
     * @exception : NpcdServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public final String excluir(ModeloBoletoVO obj) {

        Modeloboletoexclrequest request = new Modeloboletoexclrequest();
        Modeloboletoexclresponse response = new Modeloboletoexclresponse();
        Npccwvqerequest entrada = new Npccwvqerequest();
        Npccwvqsresponse saida = new Npccwvqsresponse();
        request.setNpccwvqerequest(entrada);
        response.setNpccwvqsresponse(saida);

        entrada.setCmodcontrcmbio(SiteUtil.getInt(obj.getCmodcontrcmbio()));
        
        listaSemPaginacao(request, response, "MODELOBOLETOEXCL");

        return response.getTexmens();

    }
}
