package br.com.bradesco.web.ricc.service.data.fwop;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BeanResolverFilter;

/**
 * Nome: FwopFactoryAdapter.java <br/>
 * Pacote: br.com.bradesco.web.bpmh.service.data.fwop <br/>
 * Prop�sito: <p>F�brica de adaptadores do Framework Open (FWOP).</p>
 * Classe gerada automaticamente atrav�s do WDE Bradesco.
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
	 * Prop�sito: <p>Construtor.</p>
	 */
    protected RiccFactoryAdapter() {
    	super();
    }

	/**
	 * Nome: getInstance <br/>
	 * Prop�sito: <p>Obtem uma inst�ncia da f�brica.</p>
	 * @return: FwopFactoryAdapter
	 */
    public static RiccFactoryAdapter getInstance() {
        return BeanResolverFilter.getResolver()
        	.getBeanByName(RiccFactoryAdapter.class, "fwopFactoryAdapter");
    }
}
