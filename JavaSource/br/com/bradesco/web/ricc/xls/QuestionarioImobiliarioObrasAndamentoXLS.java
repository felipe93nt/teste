package br.com.bradesco.web.ricc.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.xls.SetorImobiliarioVO;

/**
 * @name QuestionarioImobiliarioObrasAndamentoXLS
 * @author Diego Munhoz - Foursys
 * @see QuestionarioImobiliarioObrasAndamentoXLS.java
 * @version 1.0
 * @since 05/2019
 */
public class QuestionarioImobiliarioObrasAndamentoXLS {
	
	public SetorImobiliarioVO lerSetorImobiliarioObrasEmAndamento(File arquivo) {

		SetorImobiliarioVO setorImobiliario = new SetorImobiliarioVO();
		SetorImobiliarioVO auxiliar = new SetorImobiliarioVO();
		SetorImobiliarioVO retorno = new SetorImobiliarioVO();

		try {
			FileInputStream fis = new FileInputStream(arquivo);

			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

			XSSFSheet mySheet = myWorkBook.getSheetAt(1);

			Iterator<Row> rowIterator = mySheet.iterator();

			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();

				if (row.getRowNum() == 7) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setIncorporadora1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setIncorporadora1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setNomeEmpreendimento1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setNomeEmpreendimento1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setBairroLocalizacao1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setBairroLocalizacao1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setCidadeLocalizacao1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setCidadeLocalizacao1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setUfLocalizacao1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setUfLocalizacao1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setParticipacaoNoEmpreendimento1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setParticipacaoNoEmpreendimento1(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 26) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataLancamento1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataLancamento1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 27) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPrevisaoEntrega1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPrevisaoEntrega1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPorcentagemDeObra1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPorcentagemDeObra1(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoTotalDaObra1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoTotalDaObra1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoAIncorrer1(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoAIncorrer1(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setVgvTotal1(new BigDecimal(
										cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVgvTotal1(new BigDecimal(
										cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvPermutas1(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvPermutas1(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesMenosPermutas1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesMenosPermutas1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesPermutas1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesPermutas1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesEstoque1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesEstoque1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 17) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDistrato1(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDistrato1(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 18) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVenda1(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVenda1(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 19) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValoresJaRecebidos1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValoresJaRecebidos1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 20) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setaReceberAteAsChaves1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setaReceberAteAsChaves1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 21) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebiveisPosChaves1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebiveisPosChaves1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 22) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAgenteFinanceiro1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAgenteFinanceiro1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 23) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoContrato1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoContrato1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 24) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoALiberar1(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoALiberar1(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 25) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedor1(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedor1(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 8) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setIncorporadora2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setIncorporadora2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setNomeEmpreendimento2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setNomeEmpreendimento2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setBairroLocalizacao2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setBairroLocalizacao2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setCidadeLocalizacao2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setCidadeLocalizacao2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setUfLocalizacao2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setUfLocalizacao2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setParticipacaoNoEmpreendimento2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setParticipacaoNoEmpreendimento2(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 26) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataLancamento2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataLancamento2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 27) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPrevisaoEntrega2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPrevisaoEntrega2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPorcentagemDeObra2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPorcentagemDeObra2(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoTotalDaObra2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoTotalDaObra2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoAIncorrer2(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoAIncorrer2(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setVgvTotal2(new BigDecimal(
										cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVgvTotal2(new BigDecimal(
										cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvPermutas2(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvPermutas2(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesMenosPermutas2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesMenosPermutas2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesPermutas2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesPermutas2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesEstoque2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesEstoque2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 17) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDistrato2(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDistrato2(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 18) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVenda2(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVenda2(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 19) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValoresJaRecebidos2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValoresJaRecebidos2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 20) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setaReceberAteAsChaves2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setaReceberAteAsChaves2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 21) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebiveisPosChaves2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebiveisPosChaves2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 22) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAgenteFinanceiro2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAgenteFinanceiro2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 23) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoContrato2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoContrato2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 24) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoALiberar2(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoALiberar2(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 25) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedor2(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedor2(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 9) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setIncorporadora3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setIncorporadora3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setNomeEmpreendimento3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setNomeEmpreendimento3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setBairroLocalizacao3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setBairroLocalizacao3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setCidadeLocalizacao3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setCidadeLocalizacao3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setUfLocalizacao3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setUfLocalizacao3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setParticipacaoNoEmpreendimento3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setParticipacaoNoEmpreendimento3(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 26) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataLancamento3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataLancamento3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 27) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPrevisaoEntrega3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPrevisaoEntrega3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPorcentagemDeObra3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPorcentagemDeObra3(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoTotalDaObra3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoTotalDaObra3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoAIncorrer3(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoAIncorrer3(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setVgvTotal3(new BigDecimal(
										cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVgvTotal3(new BigDecimal(
										cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvPermutas3(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvPermutas3(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesMenosPermutas3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesMenosPermutas3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesPermutas3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesPermutas3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesEstoque3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesEstoque3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 17) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDistrato3(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDistrato3(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 18) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVenda3(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVenda3(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 19) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValoresJaRecebidos3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValoresJaRecebidos3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 20) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setaReceberAteAsChaves3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setaReceberAteAsChaves3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 21) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebiveisPosChaves3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebiveisPosChaves3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 22) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAgenteFinanceiro3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAgenteFinanceiro3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 23) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoContrato3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoContrato3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 24) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoALiberar3(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoALiberar3(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 25) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedor3(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedor3(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 10) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setIncorporadora4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setIncorporadora4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setNomeEmpreendimento4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setNomeEmpreendimento4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setBairroLocalizacao4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setBairroLocalizacao4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setCidadeLocalizacao4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setCidadeLocalizacao4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setUfLocalizacao4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setUfLocalizacao4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setParticipacaoNoEmpreendimento4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setParticipacaoNoEmpreendimento4(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 26) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataLancamento4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataLancamento4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 27) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPrevisaoEntrega4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPrevisaoEntrega4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPorcentagemDeObra4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPorcentagemDeObra4(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoTotalDaObra4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoTotalDaObra4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoAIncorrer4(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoAIncorrer4(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setVgvTotal4(new BigDecimal(
										cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVgvTotal4(new BigDecimal(
										cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvPermutas4(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvPermutas4(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesMenosPermutas4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesMenosPermutas4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesPermutas4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesPermutas4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesEstoque4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesEstoque4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 17) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDistrato4(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDistrato4(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 18) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVenda4(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVenda4(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 19) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValoresJaRecebidos4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValoresJaRecebidos4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 20) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setaReceberAteAsChaves4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setaReceberAteAsChaves4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 21) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebiveisPosChaves4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebiveisPosChaves4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 22) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAgenteFinanceiro4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAgenteFinanceiro4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 23) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoContrato4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoContrato4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 24) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoALiberar4(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoALiberar4(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 25) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedor4(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedor4(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 11) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setIncorporadora5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setIncorporadora5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setNomeEmpreendimento5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setNomeEmpreendimento5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setBairroLocalizacao5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setBairroLocalizacao5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setCidadeLocalizacao5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setCidadeLocalizacao5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setUfLocalizacao5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setUfLocalizacao5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setParticipacaoNoEmpreendimento5(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setParticipacaoNoEmpreendimento5(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 26) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataLancamento5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataLancamento5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 27) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPrevisaoEntrega5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPrevisaoEntrega5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPorcentagemDeObra5(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPorcentagemDeObra5(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoTotalDaObra5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoTotalDaObra5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoAIncorrer5(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoAIncorrer5(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setVgvTotal5(new BigDecimal(
										cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVgvTotal5(new BigDecimal(
										cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvPermutas5(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvPermutas5(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesMenosPermutas5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesMenosPermutas5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesPermutas5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesPermutas5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesEstoque5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesEstoque5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 17) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDistrato5(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDistrato5(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 18) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVenda5(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVenda5(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 19) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValoresJaRecebidos5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValoresJaRecebidos5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 20) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setaReceberAteAsChaves5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setaReceberAteAsChaves5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 21) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebiveisPosChaves5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebiveisPosChaves5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 22) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAgenteFinanceiro5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAgenteFinanceiro5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 23) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoContrato5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoContrato5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 24) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoALiberar5(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoALiberar5(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 25) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedor5(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedor5(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 12) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setIncorporadora6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setIncorporadora6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setNomeEmpreendimento6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setNomeEmpreendimento6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setBairroLocalizacao6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setBairroLocalizacao6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setCidadeLocalizacao6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setCidadeLocalizacao6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setUfLocalizacao6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setUfLocalizacao6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setParticipacaoNoEmpreendimento6(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setParticipacaoNoEmpreendimento6(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 26) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataLancamento6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataLancamento6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 27) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPrevisaoEntrega6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPrevisaoEntrega6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPorcentagemDeObra6(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPorcentagemDeObra6(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoTotalDaObra6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoTotalDaObra6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoAIncorrer6(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoAIncorrer6(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setVgvTotal6(new BigDecimal(
										cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVgvTotal6(new BigDecimal(
										cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvPermutas6(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvPermutas6(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesMenosPermutas6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesMenosPermutas6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesPermutas6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesPermutas6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesEstoque6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesEstoque6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 17) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDistrato6(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDistrato6(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 18) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVenda6(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVenda6(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 19) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValoresJaRecebidos6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValoresJaRecebidos6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 20) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setaReceberAteAsChaves6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setaReceberAteAsChaves6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 21) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebiveisPosChaves6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebiveisPosChaves6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 22) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAgenteFinanceiro6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAgenteFinanceiro6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 23) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoContrato6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoContrato6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 24) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoALiberar6(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoALiberar6(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 25) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedor6(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedor6(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 13) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setIncorporadora7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setIncorporadora7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setNomeEmpreendimento7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setNomeEmpreendimento7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setBairroLocalizacao7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setBairroLocalizacao7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setCidadeLocalizacao7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setCidadeLocalizacao7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setUfLocalizacao7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setUfLocalizacao7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setParticipacaoNoEmpreendimento7(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setParticipacaoNoEmpreendimento7(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 26) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataLancamento7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataLancamento7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 27) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPrevisaoEntrega7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPrevisaoEntrega7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPorcentagemDeObra7(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPorcentagemDeObra7(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoTotalDaObra7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoTotalDaObra7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoAIncorrer7(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoAIncorrer7(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setVgvTotal7(new BigDecimal(
										cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVgvTotal7(new BigDecimal(
										cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvPermutas7(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvPermutas7(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesMenosPermutas7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesMenosPermutas7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesPermutas7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesPermutas7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesEstoque7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesEstoque7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 17) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDistrato7(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDistrato7(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 18) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVenda7(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVenda7(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 19) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValoresJaRecebidos7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValoresJaRecebidos7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 20) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setaReceberAteAsChaves7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setaReceberAteAsChaves7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 21) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebiveisPosChaves7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebiveisPosChaves7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 22) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAgenteFinanceiro7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAgenteFinanceiro7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 23) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoContrato7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoContrato7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 24) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoALiberar7(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoALiberar7(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 25) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedor7(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedor7(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 14) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setIncorporadora8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setIncorporadora8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setNomeEmpreendimento8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setNomeEmpreendimento8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setBairroLocalizacao8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setBairroLocalizacao8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setCidadeLocalizacao8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setCidadeLocalizacao8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setUfLocalizacao8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setUfLocalizacao8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setParticipacaoNoEmpreendimento8(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setParticipacaoNoEmpreendimento8(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 26) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataLancamento8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataLancamento8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 27) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPrevisaoEntrega8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPrevisaoEntrega8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPorcentagemDeObra8(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPorcentagemDeObra8(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoTotalDaObra8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoTotalDaObra8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoAIncorrer8(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoAIncorrer8(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setVgvTotal8(new BigDecimal(
										cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVgvTotal8(new BigDecimal(
										cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvPermutas8(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvPermutas8(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesMenosPermutas8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesMenosPermutas8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesPermutas8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesPermutas8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesEstoque8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesEstoque8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 17) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDistrato8(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDistrato8(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 18) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVenda8(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVenda8(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 19) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValoresJaRecebidos8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValoresJaRecebidos8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 20) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setaReceberAteAsChaves8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setaReceberAteAsChaves8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 21) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebiveisPosChaves8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebiveisPosChaves8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 22) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAgenteFinanceiro8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAgenteFinanceiro8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 23) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoContrato8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoContrato8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 24) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoALiberar8(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoALiberar8(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 25) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedor8(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedor8(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 15) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setIncorporadora9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setIncorporadora9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setNomeEmpreendimento9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setNomeEmpreendimento9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setBairroLocalizacao9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setBairroLocalizacao9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setCidadeLocalizacao9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setCidadeLocalizacao9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setUfLocalizacao9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setUfLocalizacao9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setParticipacaoNoEmpreendimento9(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setParticipacaoNoEmpreendimento9(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 26) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataLancamento9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataLancamento9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 27) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPrevisaoEntrega9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPrevisaoEntrega9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPorcentagemDeObra9(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPorcentagemDeObra9(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoTotalDaObra9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoTotalDaObra9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoAIncorrer9(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoAIncorrer9(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setVgvTotal9(new BigDecimal(
										cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVgvTotal9(new BigDecimal(
										cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvPermutas9(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvPermutas9(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesMenosPermutas9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesMenosPermutas9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesPermutas9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesPermutas9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesEstoque9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesEstoque9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 17) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDistrato9(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDistrato9(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 18) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVenda9(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVenda9(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 19) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValoresJaRecebidos9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValoresJaRecebidos9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 20) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setaReceberAteAsChaves9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setaReceberAteAsChaves9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 21) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebiveisPosChaves9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebiveisPosChaves9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 22) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAgenteFinanceiro9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAgenteFinanceiro9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 23) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoContrato9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoContrato9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 24) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoALiberar9(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoALiberar9(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 25) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedor9(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedor9(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 16) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setIncorporadora10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setIncorporadora10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setNomeEmpreendimento10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setNomeEmpreendimento10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setBairroLocalizacao10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setBairroLocalizacao10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setCidadeLocalizacao10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setCidadeLocalizacao10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setUfLocalizacao10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setUfLocalizacao10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setParticipacaoNoEmpreendimento10(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setParticipacaoNoEmpreendimento10(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 26) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataLancamento10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataLancamento10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 27) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPrevisaoEntrega10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPrevisaoEntrega10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPorcentagemDeObra10(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPorcentagemDeObra10(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoTotalDaObra10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoTotalDaObra10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoAIncorrer10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoAIncorrer10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setVgvTotal10(new BigDecimal(
										cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVgvTotal10(new BigDecimal(
										cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvPermutas10(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvPermutas10(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesMenosPermutas10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesMenosPermutas10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesPermutas10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesPermutas10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesEstoque10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesEstoque10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 17) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDistrato10(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDistrato10(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 18) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVenda10(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVenda10(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 19) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValoresJaRecebidos10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValoresJaRecebidos10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 20) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setaReceberAteAsChaves10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setaReceberAteAsChaves10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 21) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebiveisPosChaves10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebiveisPosChaves10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 22) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAgenteFinanceiro10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAgenteFinanceiro10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 23) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoContrato10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoContrato10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 24) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoALiberar10(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoALiberar10(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 25) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedor10(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedor10(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 17) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setIncorporadora11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setIncorporadora11(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setNomeEmpreendimento11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setNomeEmpreendimento11(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setBairroLocalizacao11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setBairroLocalizacao11(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setCidadeLocalizacao11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setCidadeLocalizacao11(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setUfLocalizacao11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setUfLocalizacao11(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setParticipacaoNoEmpreendimento11(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setParticipacaoNoEmpreendimento11(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 26) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataLancamento11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataLancamento11(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 27) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPrevisaoEntrega11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPrevisaoEntrega11(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPorcentagemDeObra11(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPorcentagemDeObra11(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoTotalDaObra11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoTotalDaObra11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCustoAIncorrer11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCustoAIncorrer11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setVgvTotal11(new BigDecimal(
										cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVgvTotal11(new BigDecimal(
										cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvPermutas11(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvPermutas11(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesMenosPermutas11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesMenosPermutas11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesPermutas11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesPermutas11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setTotalUnidadesEstoque11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setTotalUnidadesEstoque11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 17) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDistrato11(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDistrato11(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 18) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVenda11(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setVenda11(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 19) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValoresJaRecebidos11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValoresJaRecebidos11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 20) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setaReceberAteAsChaves11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setaReceberAteAsChaves11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 21) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebiveisPosChaves11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebiveisPosChaves11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 22) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAgenteFinanceiro11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAgenteFinanceiro11(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 23) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoContrato11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoContrato11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 24) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoALiberar11(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoALiberar11(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 25) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedor11(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedor11(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
					}
				}
			}
			auxiliar = lerSetorImobiliarioObrasEmAndamentoSegundaParte(setorImobiliario, mySheet);
			retorno = lerSetorImobiliarioObrasEmAndamentoTerceiraParte(auxiliar, mySheet);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			BradescoFacesUtils
					.addErrorModalMessage("Falha no processamento da planilha.");
		} catch (IOException e) {
			e.printStackTrace();
			BradescoFacesUtils
					.addErrorModalMessage("Falha no processamento da planilha.");
		}
		return retorno;
	}
	
	public SetorImobiliarioVO lerSetorImobiliarioObrasEmAndamentoSegundaParte(
			SetorImobiliarioVO setorImobiliario, XSSFSheet mySheet) {

		Iterator<Row> rowIterator = mySheet.iterator();

		while (rowIterator.hasNext()) {
			
			Row row = rowIterator.next();

			if (row.getRowNum() == 18) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora12(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora12(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento12(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento12(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao12(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao12(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao12(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao12(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao12(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao12(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento12(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento12(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento12(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento12(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega12(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega12(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra12(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra12(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra12(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra12(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer12(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer12(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal12(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal12(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas12(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas12(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas12(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas12(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas12(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas12(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque12(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque12(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato12(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato12(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda12(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda12(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos12(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos12(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves12(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves12(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves12(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves12(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro12(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro12(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato12(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato12(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar12(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar12(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor12(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor12(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 19) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora13(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora13(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento13(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento13(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao13(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao13(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao13(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao13(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao13(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao13(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento13(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento13(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento13(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento13(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega13(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega13(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra13(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra13(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra13(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra13(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer13(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer13(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal13(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal13(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas13(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas13(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas13(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas13(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas13(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas13(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque13(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque13(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato13(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato13(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda13(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda13(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos13(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos13(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves13(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves13(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves13(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves13(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro13(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro13(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato13(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato13(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar13(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar13(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor13(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor13(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 20) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora14(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora14(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento14(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento14(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao14(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao14(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao14(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao14(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao14(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao14(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento14(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento14(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento14(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento14(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega14(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega14(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra14(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra14(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra14(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra14(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer14(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer14(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal14(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal14(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas14(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas14(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas14(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas14(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas14(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas14(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque14(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque14(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato14(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato14(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda14(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda14(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos14(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos14(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves14(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves14(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves14(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves14(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro14(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro14(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato14(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato14(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar14(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar14(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor14(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor14(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 21) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora15(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora15(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento15(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento15(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao15(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao15(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao15(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao15(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao15(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao15(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento15(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento15(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento15(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento15(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega15(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega15(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra15(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra15(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra15(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra15(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer15(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer15(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal15(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal15(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas15(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas15(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas15(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas15(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas15(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas15(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque15(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque15(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato15(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato15(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda15(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda15(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos15(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos15(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves15(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves15(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves15(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves15(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro15(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro15(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato15(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato15(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar15(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar15(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor15(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor15(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 22) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora16(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora16(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento16(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento16(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao16(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao16(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao16(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao16(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao16(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao16(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento16(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento16(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento16(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento16(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega16(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega16(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra16(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra16(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra16(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra16(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer16(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer16(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal16(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal16(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas16(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas16(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas16(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas16(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas16(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas16(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque16(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque16(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato16(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato16(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda16(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda16(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos16(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos16(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves16(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves16(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves16(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves16(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro16(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro16(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato16(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato16(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar16(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar16(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor16(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor16(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 23) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora17(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora17(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento17(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento17(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao17(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao17(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao17(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao17(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao17(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao17(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento17(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento17(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento17(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento17(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega17(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega17(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra17(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra17(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra17(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra17(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer17(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer17(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal17(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal17(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas17(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas17(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas17(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas17(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas17(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas17(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque17(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque17(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato17(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato17(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda17(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda17(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos17(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos17(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves17(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves17(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves17(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves17(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro17(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro17(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato17(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato17(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar17(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar17(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor17(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor17(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 24) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora18(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora18(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento18(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento18(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao18(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao18(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao18(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao18(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao18(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao18(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento18(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento18(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento18(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento18(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega18(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega18(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra18(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra18(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra18(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra18(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer18(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer18(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal18(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal18(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas18(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas18(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas18(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas18(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas18(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas18(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque18(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque18(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato18(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato18(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda18(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda18(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos18(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos18(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves18(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves18(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves18(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves18(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro18(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro18(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato18(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato18(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar18(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar18(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor18(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor18(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 25) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora19(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora19(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento19(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento19(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao19(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao19(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao19(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao19(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao19(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao19(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento19(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento19(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento19(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento19(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega19(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega19(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra19(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra19(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra19(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra19(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer19(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer19(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal19(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal19(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas19(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas19(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas19(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas19(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas19(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas19(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque19(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque19(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato19(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato19(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda19(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda19(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos19(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos19(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves19(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves19(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves19(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves19(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro19(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro19(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato19(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato19(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar19(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar19(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor19(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor19(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 26) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora20(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora20(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento20(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento20(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao20(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao20(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao20(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao20(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao20(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao20(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento20(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento20(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento20(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento20(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega20(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega20(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra20(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra20(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra20(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra20(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer20(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer20(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal20(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal20(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas20(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas20(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas20(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas20(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas20(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas20(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque20(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque20(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato20(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato20(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda20(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda20(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos20(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos20(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves20(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves20(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves20(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves20(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro20(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro20(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato20(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato20(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar20(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar20(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor20(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor20(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 27) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora21(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora21(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento21(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento21(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao21(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao21(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao21(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao21(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao21(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao21(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento21(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento21(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento21(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento21(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega21(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega21(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra21(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra21(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra21(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra21(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer21(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer21(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal21(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal21(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas21(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas21(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas21(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas21(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas21(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas21(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque21(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque21(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato21(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato21(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda21(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda21(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos21(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos21(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves21(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves21(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves21(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves21(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro21(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro21(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato21(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato21(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar21(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar21(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor21(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor21(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 28) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora22(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora22(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento22(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento22(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao22(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao22(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao22(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao22(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao22(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao22(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento22(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento22(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento22(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento22(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega22(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega22(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra22(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra22(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra22(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra22(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer22(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer22(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal22(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal22(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas22(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas22(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas22(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas22(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas22(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas22(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque22(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque22(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato22(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato22(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda22(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda22(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos22(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos22(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves22(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves22(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves22(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves22(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro22(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro22(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato22(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato22(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar22(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar22(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor22(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor22(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 29) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora23(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora23(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento23(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento23(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao23(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao23(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao23(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao23(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao23(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao23(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento23(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento23(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento23(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento23(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega23(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega23(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra23(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra23(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra23(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra23(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer23(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer23(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal23(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal23(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas23(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas23(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas23(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas23(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas23(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas23(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque23(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque23(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato23(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato23(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda23(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda23(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos23(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos23(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves23(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves23(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves23(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves23(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro23(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro23(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato23(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato23(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar23(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar23(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor23(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor23(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 30) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora24(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora24(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento24(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento24(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao24(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao24(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao24(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao24(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao24(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao24(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento24(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento24(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento24(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento24(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega24(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega24(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra24(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra24(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra24(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra24(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer24(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer24(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal24(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal24(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas24(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas24(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas24(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas24(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas24(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas24(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque24(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque24(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato24(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato24(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda24(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda24(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos24(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos24(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves24(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves24(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves24(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves24(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro24(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro24(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato24(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato24(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar24(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar24(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor24(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor24(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 31) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora25(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora25(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento25(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento25(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao25(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao25(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao25(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao25(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao25(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao25(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento25(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento25(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento25(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento25(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega25(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega25(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra25(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra25(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra25(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra25(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer25(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer25(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal25(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal25(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas25(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas25(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas25(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas25(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas25(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas25(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque25(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque25(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato25(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato25(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda25(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda25(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos25(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos25(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves25(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves25(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves25(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves25(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro25(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro25(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato25(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato25(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar25(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar25(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor25(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor25(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 32) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora26(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora26(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento26(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento26(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao26(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao26(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao26(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao26(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao26(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao26(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento26(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento26(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento26(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento26(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega26(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega26(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra26(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra26(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra26(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra26(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer26(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer26(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal26(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal26(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas26(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas26(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas26(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas26(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas26(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas26(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque26(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque26(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato26(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato26(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda26(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda26(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos26(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos26(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves26(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves26(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves26(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves26(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro26(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro26(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato26(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato26(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar26(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar26(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor26(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor26(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}
			if (row.getRowNum() == 33) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora27(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora27(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento27(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento27(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao27(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao27(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao27(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao27(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao27(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao27(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento27(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento27(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento27(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento27(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega27(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega27(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setPorcentagemDeObra27(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra27(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra27(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra27(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer27(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer27(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal27(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal27(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVgvPermutas27(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setVgvPermutas27(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas27(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas27(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas27(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas27(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque27(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque27(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setDistrato27(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato27(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setVenda27(Double.parseDouble(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda27(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos27(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos27(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves27(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves27(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves27(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves27(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro27(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro27(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato27(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato27(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoALiberar27(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoALiberar27(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setSaldoDevedor27(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setSaldoDevedor27(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
				}
			}			
			
		}
		return setorImobiliario;
	}

	public SetorImobiliarioVO lerSetorImobiliarioObrasEmAndamentoTerceiraParte(
			SetorImobiliarioVO setorImobiliario, XSSFSheet mySheet) {

		Iterator<Row> rowIterator = mySheet.iterator();

		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();

			if (row.getRowNum() == 34) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora28(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora28(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento28(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento28(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao28(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao28(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao28(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao28(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao28(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao28(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento28(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento28(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento28(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento28(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega28(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega28(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPorcentagemDeObra28(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra28(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra28(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra28(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer28(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer28(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal28(new BigDecimal(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal28(new BigDecimal(cell
									.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvPermutas28(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvPermutas28(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas28(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas28(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas28(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas28(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque28(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque28(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDistrato28(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato28(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVenda28(Double.parseDouble(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda28(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos28(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos28(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves28(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves28(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves28(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves28(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro28(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro28(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato28(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato28(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoALiberar28(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoALiberar28(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoDevedor28(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoDevedor28(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 35) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora29(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora29(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento29(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento29(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao29(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao29(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao29(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao29(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao29(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao29(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento29(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento29(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento29(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento29(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega29(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega29(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPorcentagemDeObra29(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra29(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra29(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra29(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer29(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer29(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal29(new BigDecimal(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal29(new BigDecimal(cell
									.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvPermutas29(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvPermutas29(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas29(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas29(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas29(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas29(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque29(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque29(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDistrato29(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato29(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVenda29(Double.parseDouble(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda29(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos29(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos29(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves29(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves29(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves29(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves29(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro29(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro29(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato29(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato29(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoALiberar29(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoALiberar29(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoDevedor29(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoDevedor29(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 36) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora30(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora30(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento30(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento30(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao30(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao30(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao30(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao30(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao30(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao30(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento30(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento30(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento30(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento30(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega30(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega30(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPorcentagemDeObra30(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra30(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra30(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra30(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer30(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer30(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal30(new BigDecimal(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal30(new BigDecimal(cell
									.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvPermutas30(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvPermutas30(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas30(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas30(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas30(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas30(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque30(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque30(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDistrato30(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato30(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVenda30(Double.parseDouble(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda30(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos30(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos30(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves30(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves30(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves30(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves30(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro30(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro30(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato30(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato30(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoALiberar30(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoALiberar30(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoDevedor30(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoDevedor30(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 37) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora31(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora31(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento31(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento31(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao31(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao31(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao31(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao31(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao31(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao31(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento31(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento31(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento31(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento31(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega31(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega31(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPorcentagemDeObra31(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra31(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra31(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra31(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer31(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer31(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal31(new BigDecimal(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal31(new BigDecimal(cell
									.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvPermutas31(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvPermutas31(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas31(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas31(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas31(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas31(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque31(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque31(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDistrato31(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato31(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVenda31(Double.parseDouble(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda31(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos31(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos31(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves31(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves31(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves31(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves31(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro31(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro31(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato31(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato31(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoALiberar31(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoALiberar31(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoDevedor31(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoDevedor31(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 38) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora32(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora32(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento32(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento32(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao32(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao32(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao32(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao32(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao32(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao32(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento32(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento32(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento32(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento32(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega32(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega32(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPorcentagemDeObra32(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra32(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra32(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra32(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer32(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer32(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal32(new BigDecimal(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal32(new BigDecimal(cell
									.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvPermutas32(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvPermutas32(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas32(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas32(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas32(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas32(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque32(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque32(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDistrato32(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato32(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVenda32(Double.parseDouble(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda32(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos32(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos32(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves32(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves32(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves32(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves32(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro32(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro32(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato32(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato32(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoALiberar32(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoALiberar32(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoDevedor32(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoDevedor32(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 39) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora33(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora33(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento33(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento33(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao33(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao33(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao33(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao33(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao33(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao33(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento33(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento33(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento33(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento33(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega33(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega33(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPorcentagemDeObra33(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra33(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra33(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra33(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer33(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer33(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal33(new BigDecimal(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal33(new BigDecimal(cell
									.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvPermutas33(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvPermutas33(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas33(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas33(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas33(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas33(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque33(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque33(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDistrato33(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato33(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVenda33(Double.parseDouble(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda33(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos33(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos33(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves33(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves33(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves33(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves33(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro33(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro33(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato33(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato33(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoALiberar33(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoALiberar33(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoDevedor33(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoDevedor33(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 40) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora34(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora34(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento34(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento34(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao34(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao34(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao34(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao34(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao34(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao34(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento34(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento34(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento34(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento34(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega34(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega34(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPorcentagemDeObra34(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra34(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra34(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra34(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer34(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer34(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal34(new BigDecimal(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal34(new BigDecimal(cell
									.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvPermutas34(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvPermutas34(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas34(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas34(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas34(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas34(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque34(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque34(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDistrato34(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato34(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVenda34(Double.parseDouble(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda34(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos34(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos34(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves34(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves34(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves34(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves34(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro34(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro34(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato34(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato34(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoALiberar34(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoALiberar34(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoDevedor34(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoDevedor34(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 41) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora35(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora35(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento35(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento35(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao35(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao35(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao35(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao35(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao35(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao35(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento35(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento35(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento35(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento35(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega35(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega35(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPorcentagemDeObra35(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra35(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra35(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra35(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer35(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer35(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal35(new BigDecimal(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal35(new BigDecimal(cell
									.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvPermutas35(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvPermutas35(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas35(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas35(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas35(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas35(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque35(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque35(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDistrato35(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato35(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVenda35(Double.parseDouble(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda35(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos35(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos35(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves35(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves35(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves35(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves35(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro35(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro35(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato35(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato35(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoALiberar35(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoALiberar35(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoDevedor35(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoDevedor35(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 42) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora36(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora36(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento36(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento36(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao36(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao36(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao36(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao36(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao36(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao36(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento36(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento36(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento36(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento36(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega36(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega36(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPorcentagemDeObra36(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra36(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra36(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra36(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer36(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer36(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal36(new BigDecimal(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal36(new BigDecimal(cell
									.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvPermutas36(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvPermutas36(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas36(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas36(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas36(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas36(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque36(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque36(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDistrato36(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato36(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVenda36(Double.parseDouble(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda36(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos36(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos36(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves36(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves36(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves36(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves36(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro36(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro36(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato36(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato36(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoALiberar36(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoALiberar36(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoDevedor36(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoDevedor36(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 43) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora37(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora37(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento37(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento37(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao37(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao37(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao37(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao37(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao37(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao37(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento37(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento37(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento37(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento37(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega37(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega37(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPorcentagemDeObra37(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra37(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra37(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra37(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer37(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer37(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal37(new BigDecimal(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal37(new BigDecimal(cell
									.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvPermutas37(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvPermutas37(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas37(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas37(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas37(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas37(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque37(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque37(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDistrato37(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato37(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVenda37(Double.parseDouble(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda37(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos37(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos37(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves37(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves37(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves37(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves37(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro37(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro37(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato37(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato37(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoALiberar37(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoALiberar37(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoDevedor37(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoDevedor37(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 44) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora38(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora38(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento38(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento38(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao38(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao38(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao38(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao38(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao38(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao38(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento38(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento38(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento38(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento38(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega38(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega38(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPorcentagemDeObra38(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra38(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra38(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra38(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer38(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer38(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal38(new BigDecimal(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal38(new BigDecimal(cell
									.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvPermutas38(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvPermutas38(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas38(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas38(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas38(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas38(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque38(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque38(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDistrato38(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato38(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVenda38(Double.parseDouble(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda38(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos38(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos38(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves38(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves38(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves38(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves38(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro38(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro38(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato38(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato38(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoALiberar38(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoALiberar38(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoDevedor38(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoDevedor38(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 45) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora39(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora39(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento39(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento39(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao39(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao39(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao39(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao39(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao39(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao39(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento39(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento39(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento39(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento39(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega39(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega39(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPorcentagemDeObra39(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra39(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra39(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra39(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer39(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer39(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal39(new BigDecimal(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal39(new BigDecimal(cell
									.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvPermutas39(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvPermutas39(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas39(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas39(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas39(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas39(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque39(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque39(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDistrato39(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato39(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVenda39(Double.parseDouble(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda39(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos39(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos39(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves39(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves39(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves39(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves39(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro39(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro39(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato39(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato39(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoALiberar39(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoALiberar39(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoDevedor39(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoDevedor39(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 46) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setIncorporadora40(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setIncorporadora40(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 2) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setNomeEmpreendimento40(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setNomeEmpreendimento40(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 3) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setBairroLocalizacao40(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setBairroLocalizacao40(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 4) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setCidadeLocalizacao40(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setCidadeLocalizacao40(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 5) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setUfLocalizacao40(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setUfLocalizacao40(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 6) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setParticipacaoNoEmpreendimento40(Double
											.parseDouble(cell
													.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setParticipacaoNoEmpreendimento40(cell
											.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 26) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDataLancamento40(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDataLancamento40(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 27) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPrevisaoEntrega40(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPrevisaoEntrega40(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 9) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setPorcentagemDeObra40(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setPorcentagemDeObra40(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 10) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoTotalDaObra40(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoTotalDaObra40(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 11) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setCustoAIncorrer40(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setCustoAIncorrer40(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 12) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvTotal40(new BigDecimal(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvTotal40(new BigDecimal(cell
									.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 13) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVgvPermutas40(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVgvPermutas40(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 14) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesMenosPermutas40(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesMenosPermutas40(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 15) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesPermutas40(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesPermutas40(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 16) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setTotalUnidadesEstoque40(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setTotalUnidadesEstoque40(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 17) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setDistrato40(Double
									.parseDouble(cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setDistrato40(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 18) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setVenda40(Double.parseDouble(cell
									.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setVenda40(cell
									.getNumericCellValue());
							break;
						}
					}
					if (cell.getColumnIndex() == 19) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValoresJaRecebidos40(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValoresJaRecebidos40(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 20) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setaReceberAteAsChaves40(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setaReceberAteAsChaves40(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 21) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setRecebiveisPosChaves40(new BigDecimal(
											cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setRecebiveisPosChaves40(new BigDecimal(
											cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 22) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setAgenteFinanceiro40(cell
									.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setAgenteFinanceiro40(cell
									.getNumericCellValue() + "");
							break;
						}
					}
					if (cell.getColumnIndex() == 23) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setValorDoContrato40(new BigDecimal(cell
											.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setValorDoContrato40(new BigDecimal(cell
											.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 24) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoALiberar40(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoALiberar40(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
					if (cell.getColumnIndex() == 25) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario.setSaldoDevedor40(new BigDecimal(
									cell.getStringCellValue()));
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario.setSaldoDevedor40(new BigDecimal(
									cell.getNumericCellValue()));
							break;
						}
					}
				}
			}

			if (row.getRowNum() == 52) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 1) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							setorImobiliario
									.setComentariosGeraisObrasAndamento(cell
											.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							setorImobiliario
									.setComentariosGeraisObrasAndamento(cell
											.getNumericCellValue() + "");
							break;
						}
					}
				}
			}
		}
		return setorImobiliario;
	}

}