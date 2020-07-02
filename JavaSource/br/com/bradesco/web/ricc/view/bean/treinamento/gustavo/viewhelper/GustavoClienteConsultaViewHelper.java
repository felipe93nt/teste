package br.com.bradesco.web.ricc.view.bean.treinamento.gustavo.viewhelper;

import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteGustavoVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class GustavoClienteConsultaViewHelper extends AbstractViewHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2968087514659636530L;
	/**
	 * 
	 */
	

	private ClienteGustavoVO clienteGustavoVO ;
	private ClienteGustavoVO clienteGustavoVO2 ;
	private ClienteGustavoVO clienteGustavoVO3 ;
	
	@Override
	public void inicializar() {
		clienteGustavoVO = new ClienteGustavoVO("Gustavo Garcia Alencar Santos","28.456.789-8","178.865.756-89","M","04/10/2001","Rua teste","325","08470-290","bloco 9 ap 22","São Paulo","São Paulo","Jardim Teste","(11)4002-8922","(11)94002-8922","gustavogarciaalencar@hotmail.com");
		clienteGustavoVO2 = new ClienteGustavoVO();
		clienteGustavoVO3 = new ClienteGustavoVO();
	}

	public ClienteGustavoVO getClienteGustavoVO2() {
		return clienteGustavoVO2;
	}

	public void setClienteGustavoVO2(ClienteGustavoVO clienteGustavoVO2) {
		this.clienteGustavoVO2 = clienteGustavoVO2;
	}

	public ClienteGustavoVO getClienteGustavoVO3() {
		return clienteGustavoVO3;
	}

	public void setClienteGustavoVO3(ClienteGustavoVO clienteGustavoVO3) {
		this.clienteGustavoVO3 = clienteGustavoVO3;
	}

	public ClienteGustavoVO getClienteGustavoVO() {
		return clienteGustavoVO;
	}


	public void setClienteGustavoVO(ClienteGustavoVO clienteGustavoVO) {
		this.clienteGustavoVO = clienteGustavoVO;
	}


	

	public List<SelectItem> getComboCidades() {
		return siteUtil.carregarComboBoxCidadesGustavo();
	}

	public List<SelectItem> getComboEstados() {
		return siteUtil.carregarComboBoxEstadosGustavo();
	}

}
