/**
 * Nome: br.com.bradesco.web.cursojava.view.bean.AbstractViewHelper.java<BR/>
 * Propósito: Classe bpmh<BR/>
 *
 * Compilador: 1.6<BR/>
 * Data da Criação: 23/11/2016-15:01:15<BR/>
 * Parâmetros de Compilação -d<BR/>
 * Registro de Manutenção: 23/11/2016<BR/>
 *
 * - Autor: m126112 <BR/>
 * - Responsável: Equipe bpmh
 */
package br.com.bradesco.web.ricc.view.bean;

import java.io.Serializable;

import br.com.bradesco.web.aq.application.log.ILogManager;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.ricc.utils.DateUtil;
import br.com.bradesco.web.ricc.utils.SiteUtil;

/**
 * Nome: AbstractViewHelper.
 * Proposito: AbstractViewHelper.
 * Equipe: ricc
 *
 * @author foursys
 * @version 1.0
 * @see
 * @date ago/2018
 */
public abstract class AbstractViewHelper implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 4715712681680463321L;
	/** Atributo logger. */
	protected ILogManager logger = BradescoCommonServiceFactory.getLogManager();

	/** Atributo date util. */
	protected DateUtil dateUtil = DateUtil.getCurrentInstance();

	/** Atributo site util. */
	protected SiteUtil siteUtil = SiteUtil.getInstance();
	/**
	 *
	 * Nome: inicializar
	 * Propósito: Método abstrato para a inicialização da página
	 * .
	 *
	 * @return NA.
	 *
	 * @see: NA.
	 */
	public abstract void inicializar();

}
