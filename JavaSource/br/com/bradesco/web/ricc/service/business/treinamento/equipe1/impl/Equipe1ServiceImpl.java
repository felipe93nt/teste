package br.com.bradesco.web.ricc.service.business.treinamento.equipe1.impl;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.pagination.cws.baseconnector.CWSBusinessServiceBaseConnector;
import br.com.bradesco.web.ricc.model.cadastro.PesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.RetornoPesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.service.business.treinamento.equipe1.IEquipe1Service;
import br.com.bradesco.web.ricc.utils.SiteUtil;

@Named("equipe1Service")
public class Equipe1ServiceImpl implements IEquipe1Service {
	private static final long serialVersionUID = 1L;

	@Inject
	@Named("CWSBusinessServiceBaseConnector")
	private CWSBusinessServiceBaseConnector adapterCWS = null;

	private SiteUtil siteUtil = SiteUtil.getInstance();

	@Override
	public RetornoPesquisaCadastramentoVO carregarListaCorporate(
			PesquisaCadastramentoVO entrada) {
		// TODO Auto-generated method stub
		return null;
	}

}