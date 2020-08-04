/**
 *
 * Nome: AtivoDAO.java
 * Prop�sito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compila��o -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manuten��o: 23/07/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padr�o hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.global.commonXml.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.business.global.commonXml.ICommonXmlService;
import br.com.bradesco.web.npcc_trade.utils.xml.LeitorXMLArquivo;

/**
 *
 * Nome: AtivoDAO.java Prop�sito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 23/07/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padr�o hexavision.
 */
@Named("commonXmlService")
@SessionScoped
public class CommonXmlServiceImpl implements ICommonXmlService, Serializable {

    /**
	 *
	 */
    private static final long serialVersionUID = 1L;

    /**
	 *
	 */
    private LeitorXMLArquivo xml = null;

    /**
     * Construtor
     * 
     */
    public CommonXmlServiceImpl() {
        super();
    }

    /**
     * 
     * Nome: getSimNao
     * 
     * Prop�sito: Carrega os dados da Lista Ativo
     *
     * @param : <BR/>
     * @return :
     *
     * 
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 23/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public Map<Integer, Object> getSimNao() {

        xml = new LeitorXMLArquivo("/br/com/bradesco/web/npcc_trade/service/business/global/commonXml/xml/simNao.xml",
                "simNao");

        Map<Integer, Object> mapa = new LinkedHashMap<Integer, Object>();
        xml.start();
        while (!xml.eof()) {
            mapa.put(xml.getValorInt("codigo"), xml.getValorString("nome"));
            xml.next();
        }

        return mapa;
    }

    /**
     * 
     * Nome: getMoeda
     * 
     * Prop�sito: Carrega os dados do Combo de Moeda
     *
     * @param : <BR/>
     * @return :
     *
     * 
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 23/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    @Override
    public Map<Integer, Object> getMoeda() {
        Map<Integer, Object> mapa = new LinkedHashMap<Integer, Object>();
        mapa.put(0, "SELECIONE");
        mapa.put(1, "ME");
        mapa.put(2, "MN");
        return mapa;
    }

}
