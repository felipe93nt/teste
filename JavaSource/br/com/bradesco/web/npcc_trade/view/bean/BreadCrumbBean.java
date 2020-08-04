/**
 * Nome: br.com.bradesco.web.npcc_trade.view.bean
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 24/07/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */
package br.com.bradesco.web.npcc_trade.view.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
 *
 * Nome: BreadCrumbBean Propósito: Fornecer metodos para crontrução dinâmica do
 * caminho de pão <br/>
 *
 * Data: 24/07/2015 <br/>
 * 
 * @author BRQ <br/>
 *         copyright Copyright (c) 2015 <br/>
 *
 * @version 1.0
 * @see
 */
@Named(value = "breadCrumbBean")
@RequestScoped
public class BreadCrumbBean {

    /**
     * 
     * Nome: loadCaminho Propósito: Carrega a lista de Funcionalidades para
     * telas CRUD
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/08/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<String> loadCaminho(String parent, Integer action) {
        return loadCaminho(parent, action, SiteUtil.STRING_EMPTY);
    }

    /**
     * 
     * Nome: loadCaminho Propósito: Carrega a lista de Funcionalidades para
     * telas CRUD
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/08/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<String> loadCaminho(String parent, Integer action, String custom) {
        List<String> list = new ArrayList<String>();

        // Adiciona no primeiro item da lista o titulo da página inicial
        list.add(SiteUtil.getBundleValue(parent));

        switch (action) {
        case 1:
            // adiciona item incluir na lista
            list.add(SiteUtil.getBundleValue("label_incluir"));
            break;

        case 2:
            // adiciona item alterar na lista
            list.add(SiteUtil.getBundleValue("label_alterar"));
            break;

        case 3:
            // adiciona item detalhar na lista
            list.add(SiteUtil.getBundleValue("label_detalhar"));
            break;

        case 4:
            // adiciona item aprovar na lista
            list.add(SiteUtil.getBundleValue("label_aprovar"));
            break;

        case 5:
            // adiciona item excluir na lista
            list.add(SiteUtil.getBundleValue("label_excluir"));
            break;

        case 6:
            // adiciona item ativar na lista
            list.add(SiteUtil.getBundleValue("label_ativar"));
            break;
            
        case 7:
            // adiciona item desativar na lista
            list.add(SiteUtil.getBundleValue("label_desativar"));
            break;
        
        case 8:
            // adiciona item desativar na lista
            list.add(SiteUtil.getBundleValue("label_importar"));
            break;
            
        case 99:
            // adiciona item customizado na lista
            list.add(SiteUtil.getBundleValue(custom));
            break;

        default:
            break;
        }

        return list;

    }
    
    /**
     * 
     * Nome: loadCaminhoThree 
     * 
     * Propósito: Carrega a lista de Funcionalidades para 3 passos
     *
     * @param : String, String, String
     * 
     * @return : List<String>
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/08/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<String> loadCaminhoThree(String parent0, String parent1, String atual) {
        List<String> list = new ArrayList<String>();

        // Adiciona itens do caminho até a tela atual
        list.add(SiteUtil.getBundleValue(parent0));
        list.add(SiteUtil.getBundleValue(parent1));
        list.add(SiteUtil.getBundleValue(atual));

        return list;

    }
    
    /**
     * Nome: loadCaminhoCustom
     * 
     * Propósito: Carrega lista de breadCrumb para n titulos e subtitulos (WAS 8.5 não funciona)
     *
     * @param : caminhosTelas (titulos e subtitulos das telas, cujo valor são recuperados do message.properties)
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 15/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<String> loadCaminhoCustom(String... caminhosTelas) {
    	List<String> list = new ArrayList<String>();

    	//ignora nulos
    	if (!caminhosTelas.equals(null)) {

    		// Adiciona os itens em loop        
    		for (int i = 0; i < caminhosTelas.length; i++) {
    			list.add(SiteUtil.getBundleValue(caminhosTelas[i]));
    		}
    	}
    	return list;
    }
    
}