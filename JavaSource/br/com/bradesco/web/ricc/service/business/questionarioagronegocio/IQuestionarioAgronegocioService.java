/**
 * Nome: br.com.bradesco.web.ricc.service.business.questionarioagronegocio
 * Compilador: JDK 1.5
 * Propósito: INSERIR O PROPÓSITO DAS CLASSES DO PACOTE
 * Data da criação: <dd/MM/yyyy>
 * Parâmetros de compilação: -d
 */
package br.com.bradesco.web.ricc.service.business.questionarioagronegocio;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.ricc.enums.TipoManutencaoEnum;
import br.com.bradesco.web.ricc.exception.RiccException;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.AreaArrendadaAgronegocioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.AreaPropriaAgronegocioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.GraosFibrasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.QuestionarioAgronegocioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.UsinasVO;
import br.com.bradesco.web.ricc.service.business.questionarioagronegocio.impl.GraoFibraAux;
import br.com.bradesco.web.ricc.view.bean.questionarioagronegocio.bean.QuestionarioAgronegocioBean;

/**
 * @name IQuestionarioAgronegocioService
 * @author Foursys
 * @see IQuestionarioAgronegocioService.java
 * @version 1.0
 * @since 13/09/2018
 */
public interface IQuestionarioAgronegocioService extends Serializable {

	/**
	 * @description
	 * @name manutencaoAreaPropria
	 * @see IQuestionarioAgronegocioService
	 * @param areaVo
	 * @throws RiccException
	 * @return void
	 */
	void manutencaoAreaPropria(QuestionarioAgronegocioVO agro, AreaPropriaAgronegocioVO areaVo, Integer tipoManutencao)
			throws RiccException;

	/**
	 * @description
	 * @name listarAreaPropria
	 * @see IQuestionarioAgronegocioService
	 * @param tipoProduto
	 * @param codGrupo
	 * @param codRelatorio
	 * @return
	 * @throws RiccException
	 * @return GraosFibrasVO
	 */
	GraosFibrasVO listarAreaPropria(String tipoProduto,
			String codGrupo, String codRelatorio) throws RiccException;

	/**
	 * @description
	 * @name manutencaoAreaArrendada
	 * @see IQuestionarioAgronegocioService
	 * @param areaVo
	 * @throws RiccException
	 * @return void
	 */
	void manutencaoAreaArrendada(QuestionarioAgronegocioVO agro, AreaArrendadaAgronegocioVO areaVo, Integer tipoManutencao)
			throws RiccException;

	/**
	 * @description
	 * @name listarAreaArrendada
	 * @see IQuestionarioAgronegocioService
	 * @param tipoProduto
	 * @param codGrupo
	 * @param codRelatorio
	 * @return
	 * @throws RiccException
	 * @return List<AreaArrendadaAgronegocioVO>
	 */
	GraosFibrasVO listarAreaArrendada(String tipoProduto,
			String codGrupo, String codRelatorio) throws RiccException;

	/**
	 * @description
	 * @name manutencaoGrao
	 * @see IQuestionarioAgronegocioService
	 * @param graoVo
	 * @param tipoGrao
	 * @throws RiccException
	 * @return void
	 */
	void manutencaoGraosFibra(QuestionarioAgronegocioVO questionario, List<GraoFibraAux> lista, int codTpoRamo)
			throws RiccException;

	/**
	 * @description
	 * @name consultarGrao
	 * @see IQuestionarioAgronegocioService
	 * @param tipoGrao
	 * @param codGrupo
	 * @param codRelatorio
	 * @return
	 * @throws RiccException
	 * @return TipoGraoVO
	 */
	List<GraoFibraAux> consultarGraosFibras(QuestionarioAgronegocioVO questionario, int codigoTipoRamo) throws RiccException;

	/**
	 * @description
	 * @name manutencaoNomeUsina
	 * @see IQuestionarioAgronegocioService
	 * @param questionario
	 * @param usinas
	 * @param tipoManutencao
	 * @return void
	 */
	void manutencaoNomeUsina(QuestionarioAgronegocioVO questionario,
			UsinasVO usinas, TipoManutencaoEnum tipoManutencao);

	/**
	 * @description
	 * @name consultaNomeUsina
	 * @see IQuestionarioAgronegocioService
	 * @param questionario
	 * @return
	 * @return String
	 */
	String consultaNomeUsina(QuestionarioAgronegocioVO questionario);

	/**
	 * @description
	 * @name manutencaoUsinas
	 * @see IQuestionarioAgronegocioService
	 * @param questionario
	 * @param usinas
	 * @return void
	 */
	void manutencaoUsinas(QuestionarioAgronegocioVO questionario,
			List<QuestionarioAgronegocioBean.ObjectUsinas> usinas);

	/**
	 * @description
	 * @name consultaUsinas
	 * @see IQuestionarioAgronegocioService
	 * @param questionario
	 * @return
	 * @return List<QuestionarioAgronegocioBean.ObjectUsinas>
	 */
	List<QuestionarioAgronegocioBean.ObjectUsinas> consultaUsinas(
			QuestionarioAgronegocioVO questionario);

	/**
	 * @description
	 * @name manutencaoProducaoUsinas
	 * @see IQuestionarioAgronegocioService
	 * @param questionario
	 * @param usinas
	 * @return void
	 */
	void manutencaoProducaoUsinas(QuestionarioAgronegocioVO questionario,
			List<QuestionarioAgronegocioBean.ObjectUsinas> usinas);

	/**
	 * @description
	 * @name consultaProducaoUsinas
	 * @see IQuestionarioAgronegocioService
	 * @param questionario
	 * @return
	 * @return List<QuestionarioAgronegocioBean.ObjectUsinas>
	 */
	List<QuestionarioAgronegocioBean.ObjectUsinas> consultaProducaoUsinas(
			QuestionarioAgronegocioVO questionario);
	
	/**
	 * @param agro
	 * @param tipoManutencao
	 */
	void manutencaoNomeProdutor(QuestionarioAgronegocioVO agro, TipoManutencaoEnum tipoManutencao);
}