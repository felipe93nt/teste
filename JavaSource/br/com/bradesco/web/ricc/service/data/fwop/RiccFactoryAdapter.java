package br.com.bradesco.web.ricc.service.data.fwop;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BeanResolverFilter;

/**
 * Nome: FwopFactoryAdapter.java <br/>
 * Pacote: br.com.bradesco.web.bpmh.service.data.fwop <br/>
 * Propósito: <p>Fábrica de adaptadores do Framework Open (FWOP).</p>
 * Classe gerada automaticamente através do WDE Bradesco.
 * @author: Bradesco <br/>
 * Equipe: WDE Bradesco <br/>
 */
@Named("fwopFactoryAdapter")
@SessionScoped
public class RiccFactoryAdapter implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 201839594233675390L;

	/**
	 * Nome: FwopFactoryAdapter <br/>
	 * Propósito: <p>Construtor.</p>
	 */
    protected RiccFactoryAdapter() {
    	super();
    }

	/**
	 * Nome: getInstance <br/>
	 * Propósito: <p>Obtem uma instância da fábrica.</p>
	 * @return: FwopFactoryAdapter
	 */
    public static RiccFactoryAdapter getInstance() {
        return BeanResolverFilter.getResolver()
        	.getBeanByName(RiccFactoryAdapter.class, "fwopFactoryAdapter");
    }
}
