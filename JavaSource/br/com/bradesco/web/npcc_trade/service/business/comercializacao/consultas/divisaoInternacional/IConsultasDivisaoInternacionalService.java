package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.divisaoInternacional;

import java.io.Serializable;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.divisaoInternacional.bean.ConsultaDivInternacFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.divisaoInternacional.bean.ConsultaDivInternacVO;

/**
*
* Nome: IConsultasDivisaoInternacionalService
* 
* Propósito: Interface para o serviço <br/>
*
* Data: 13/07/2015 <br/>
* 
* @author BRQ <br/>
*         copyright Copyright (c) 2016 <br/>
*
* @version 1.0
* @see
*/
public interface IConsultasDivisaoInternacionalService extends Serializable {

   /**
    * 
    * Nome: getListaCotacoesDivisaoInternacional
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 30/08/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public ConsultaDivInternacVO getListaCotacoesDivisaoInternacional(ConsultaDivInternacFiltroVO filtro);
}
