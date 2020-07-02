/**
* Nome: br.com.bradesco.web.cursojava.view.bean
*
* Compilador: JDK 1.5
*
* Prop�sito: Representa os valores do objeto AbstractBean.java
*
* Data da Cria��o: 31/03/2016
*
* Par�metros de Compila��o:  -d
*
*/
package br.com.bradesco.web.ricc.view.bean;

import java.io.Serializable;

import br.com.bradesco.web.aq.application.log.ILogManager;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.ricc.utils.DateUtil;
import br.com.bradesco.web.ricc.utils.SiteUtil;

/**
 * Nome: AbstractBean
 * Prop�sito: Representa o VO do AbstractBean <br/>
 * Data: 31/03/2016 <br/>
 *
 * @author m69831 / Centro de Desenvolvimento - Bradesco <br/>
 *         copyright Copyright (c) 2015 <br/>
 * @version 1.0
 * @see
 * Registro  de Manuten��o:
 * - Autor:
 * - Responsavel:
 */
public abstract class AbstractBean<VH extends AbstractViewHelper>  implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -8986467532567686409L;

	/** Atributo invalid flag. */
	private boolean invalidFlag = Boolean.FALSE;

	/** Atributo view helper. */
	protected VH viewHelper = null;

	/** �ltimo outcome. */
	private String lastViewId = null;

	/** Atributo logger. */
	protected ILogManager logger = BradescoCommonServiceFactory.getLogManager();

	protected DateUtil dateUtil = DateUtil.getCurrentInstance();

	protected SiteUtil siteUtil = SiteUtil.getInstance();

	public AbstractBean(){}

	public abstract String iniciarPagina();

	/** Campo VAZIO */
	protected String VAZIO;
	/**
	 * Nome: isInvalidFlag
	 * Prop�sito: M�todo get para o atributo invalidFlag
	 * Data: 31/03/2016
	 * @author m69831 / Centro de Desenvolvimento - Bradesco
	 *
	 * @return invalidFlag
	 */
	public boolean isInvalidFlag() {
		return invalidFlag;
	}

	/**
	 * Nome: setInvalidFlag<br/>
	 * Prop�sito: M�todo set para o atributo invalidFlag <br/>
	 * @autor m69831 / Centro de Desenvolvimento - Bradesco
	 *
	 * @param invalidFlag O atributo a ser setado
	 */

	public void setInvalidFlag(boolean invalidFlag) {
		this.invalidFlag = invalidFlag;
	}

	/**
	 * Nome: getViewHelper
	 * Prop�sito: M�todo get para o atributo viewHelper
	 * Data: 31/03/2016
	 * @author m69831 / Centro de Desenvolvimento - Bradesco
	 *
	 * @return viewHelper
	 */
	public VH getViewHelper() {
		return viewHelper;
	}

	/**
	 * Nome: setViewHelper<br/>
	 * Prop�sito: M�todo set para o atributo viewHelper <br/>
	 * @autor m69831 / Centro de Desenvolvimento - Bradesco
	 *
	 * @param viewHelper O atributo a ser setado
	 */

	public void setViewHelper(VH viewHelper) {
		this.viewHelper = viewHelper;
	}

	/**
	 * Nome: getLastViewId
	 * Prop�sito: M�todo get para o atributo lastViewId
	 * Data: 31/03/2016
	 * @author m69831 / Centro de Desenvolvimento - Bradesco
	 *
	 * @return lastViewId
	 */
	public String getLastViewId() {
		return lastViewId;
	}

	/**
	 * Nome: setLastViewId<br/>
	 * Prop�sito: M�todo set para o atributo lastViewId <br/>
	 * @autor m69831 / Centro de Desenvolvimento - Bradesco
	 *
	 * @param lastViewId O atributo a ser setado
	 */

	public void setLastViewId(String lastViewId) {
		this.lastViewId = lastViewId;
	}

	/**
	 * Nome: getLogger
	 * Prop�sito: M�todo get para o atributo logger
	 * Data: 31/03/2016
	 * @author m69831 / Centro de Desenvolvimento - Bradesco
	 *
	 * @return logger
	 */
	public ILogManager getLogger() {
		return logger;
	}

	/**
	 * Nome: setLogger<br/>
	 * Prop�sito: M�todo set para o atributo logger <br/>
	 * @autor m69831 / Centro de Desenvolvimento - Bradesco
	 *
	 * @param logger O atributo a ser setado
	 */

	public void setLogger(ILogManager logger) {
		this.logger = logger;
	}


}
