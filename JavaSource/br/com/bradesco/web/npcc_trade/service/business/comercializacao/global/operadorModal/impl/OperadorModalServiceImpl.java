package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.operadorModal.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList.Npccwvuerequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList.Npccwvusresponse;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList.Npccwvusresponse_lista;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList.Operadormodallistrequest;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperadorModalList.Operadormodallistresponse;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.operadorModal.IOperadorModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.operadorModal.bean.OperadorVO;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseService;

@Named("operadorModalServiceImpl")
@RequestScoped
public class OperadorModalServiceImpl extends BaseService implements IOperadorModalService{

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 710181290155458514L;
	
	public List<OperadorVO> pesquisarOperador(OperadorVO operadorVO){
		List<OperadorVO> lista = new ArrayList<OperadorVO>();
			
		// IN3827741 [587651] - O CAMPO DE BUSCA NÃO ESTÁ TRAZENDO OPERADOR (I397185) - book nova
		Operadormodallistrequest request = new Operadormodallistrequest();
	    Operadormodallistresponse response = new Operadormodallistresponse();
	    Npccwvuerequest entrada = new Npccwvuerequest();
	    Npccwvusresponse saida = new Npccwvusresponse();
	    request.setNpccwvuerequest(entrada);
	    response.setNpccwvusresponse(saida);
		
	    listaSemPaginacao(request, response, "OPERADORMODALLIST");
	    
	    for (int i = 0; i < response.getNpccwvusresponse().getQtdeocorr(); i++) {
	    	
	    	Npccwvusresponse_lista objFrom = response.getNpccwvusresponse().getLista().get(i);
	        OperadorVO objTo = new OperadorVO();
	
	        // Copia os valores das propriedades com o mesmo nome
	        objTo.setCusuarincl(objFrom.getLista_cusuarincl());
	        objTo.setNmusuarinc(objFrom.getLista_nmusuarinc());
	        
	        lista.add(objTo);
	    }
	    
	    return lista;
	}
	
}
