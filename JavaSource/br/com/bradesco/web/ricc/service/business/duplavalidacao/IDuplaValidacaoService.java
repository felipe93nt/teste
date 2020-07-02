package br.com.bradesco.web.ricc.service.business.duplavalidacao;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.ricc.model.duplavalidacao.DuplaValidacaoVO;

public interface IDuplaValidacaoService extends Serializable {
	
	public void manutencaoDuplaValidacao (int tipoManutencao, DuplaValidacaoVO modelDe, DuplaValidacaoVO modelPara, String justificativa, String usuarioLogado);
	
	public List<DuplaValidacaoVO> consultaDuplaValidacao (int codOrigem);
	
}
