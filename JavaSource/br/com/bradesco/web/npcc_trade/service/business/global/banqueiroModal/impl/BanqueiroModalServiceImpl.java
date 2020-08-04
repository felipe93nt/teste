/**
 *
 * Nome: BanqueiroServiceImpl.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 05/10/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.global.banqueiroModal.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BanqueiroList.Banqueirolistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BanqueiroList.Banqueirolistresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BanqueiroList.Npcdwfgerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BanqueiroList.Npcdwfgsresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.BanqueiroList.Npcdwfgsresponse_lista;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;
import br.com.bradesco.web.npcc_trade.service.business.global.banqueiroModal.IBanqueiroModalService;
import br.com.bradesco.web.npcc_trade.service.business.global.banqueiroModal.bean.BanqueiroModalVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
 *
 * Nome: BanqueiroServiceImpl.java Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 05/10/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
@Named("banqueiroModalService")
@SessionScoped
public class BanqueiroModalServiceImpl extends BaseService implements
		IBanqueiroModalService, Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 1L;

	/**
	 * Método construtor da classe.
	 */
	public BanqueiroModalServiceImpl() {
		super();
	}

	/**
	 * 
	 * Nome: banqueiroListRequest Propósito:
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
	 *      Registro de Manutenção: 28/10/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public List<BanqueiroModalVO> listar(BanqueiroModalVO filtro) {

		List<BanqueiroModalVO> dadosRetorno = new ArrayList<BanqueiroModalVO>();

		Banqueirolistrequest request = new Banqueirolistrequest();
		Banqueirolistresponse response = new Banqueirolistresponse();
		Npcdwfgerequest bookEntrada = new Npcdwfgerequest();
		Npcdwfgsresponse bookSaida = new Npcdwfgsresponse();
		request.setNpcdwfgerequest(bookEntrada);
		response.setNpcdwfgsresponse(bookSaida);

		// Copia os valores das propriedades com o mesmo nome automaticamente
		SiteUtil.copyPropertiesObjects(filtro, bookEntrada);

		String codigoSwift = filtro.getCidbanqrswift();

		// Verifica se a filial do swift foi informado
		if (codigoSwift != null && codigoSwift.length() > 8) {
			bookEntrada.setCidbanqrswift(codigoSwift.substring(0, 8));
			bookEntrada.setCflialbanqrswift(codigoSwift.substring(8));
		} else {
			bookEntrada.setCidbanqrswift(codigoSwift);
			bookEntrada.setCflialbanqrswift(SiteUtil.STRING_EMPTY);
		}

		// executa chamada CWS - Fluxo NPCDIADP - Books: NPCDWFGE / NPCDWFGS
		listaComPaginacao(request, response, "BANQUEIROLIST", "NPCDIADP");

		// carrega lista de retorno
		for (int i = Numeros.ZERO; i < response.getNpcdwfgsresponse()
				.getQtdeocorr(); i++) {

			Npcdwfgsresponse_lista objFrom = response.getNpcdwfgsresponse()
					.getLista().get(i);
			BanqueiroModalVO objTo = new BanqueiroModalVO();

			// Copia os valores das propriedades com o mesmo nome
			// automaticamente
			SiteUtil.copyPropertiesObjects(objFrom, objTo, "lista_", true);
			// Seta o valor a ser utilizado na variável para o banco principal.
			objTo.setCbanqrcmbiop(objFrom.getLista_cbanqrcmbio());

			dadosRetorno.add(objTo);
		}

		return dadosRetorno;
	}

}
