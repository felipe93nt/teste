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
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.xls.SetorTransportesVO;

/**
 * @name QuestionarioTransporteXLS
 * @author Diego Munhoz - Foursys
 * @see QuestionarioTransporteXLS.java
 * @version 1.0
 * @since 05/2019
 */
public class QuestionarioTransporteXLS {

	private Boolean valido;

	public SetorTransportesVO lerSetorTransportesXLSM(File arquivo) {

		this.valido = false;

		SetorTransportesVO setorTransportes = new SetorTransportesVO();

		try {
			FileInputStream fis = new FileInputStream(arquivo);

			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

			XSSFSheet mySheet = myWorkBook.getSheetAt(0);

			Iterator<Row> rowIterator = mySheet.iterator();

			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();

				if (row.getRowNum() == 0) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 7) {
							if (cell.getStringCellValue().equals("T")) {
								this.valido = true;
							}
						}
					}
				}

				if (!this.valido) {
					return null;
				}

				// Captura Linha 5: Data Base
				if (row.getRowNum() == 4) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes.setDataBase(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setDataBase(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 6: Quantidade de Veiculos (em unidade)
				if (row.getRowNum() == 5) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setQuantidadeVeiculos(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setQuantidadeVeiculos(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 7: Valor da Frota (R$ mil)
				if (row.getRowNum() == 6) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setValorDaFrota(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setValorDaFrota(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 8: Saldo Devedor (Leasing/Finame) (R$ mil)
				if (row.getRowNum() == 7) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setSaldoDevedor(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setSaldoDevedor(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 10: Idade Media (em anos)
				if (row.getRowNum() == 9) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes.setIdadeMedia(Integer
										.parseInt(cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setIdadeMedia((int) cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 11: Desembolso mensal finame/leasing (R$ mil)
				if (row.getRowNum() == 10) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setDesembolsoLeasingFiname(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setDesembolsoLeasingFiname(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 12: Desembolso mensal cagiro (R$ mil)
				if (row.getRowNum() == 11) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setDesembolsoCagiro(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setDesembolsoCagiro(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 13: Faturamento m�dio mensal (R$ mil)
				if (row.getRowNum() == 12) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFaturamentoMedioMensal(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setFaturamentoMedioMensal(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 16: Percentual de Frota Pr�pria
				if (row.getRowNum() == 15) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setPercentualFrotaPropria(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setPercentualFrotaPropria(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 17: MARGEM EBITDA �LTIMO EXERC�CIO (%)
				if (row.getRowNum() == 16) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setMargemEBITDA(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setMargemEBITDA(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 25: Receita por segmento - Faturamento - Varejo
				if (row.getRowNum() == 24) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setVarejoFaturamento(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setVarejoFaturamento(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 25: Receita por segmento - EBITDA - Varejo
				if (row.getRowNum() == 24) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setVarejoEBITDA(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setVarejoEBITDA(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 26: Receita por segmento - Faturamento -
				// Sa�de
				if (row.getRowNum() == 25) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setSaudeFaturamento(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setSaudeFaturamento(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 26: Receita por segmento - EBITDA - Sa�de
				if (row.getRowNum() == 25) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setSaudeEBITDA(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setSaudeEBITDA(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 27: Receita por segmento - Faturamento -
				// Quimico
				if (row.getRowNum() == 26) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setQuimicoFaturamento(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setQuimicoFaturamento(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 27: Receita por segmento - EBITDA - Quimico
				if (row.getRowNum() == 26) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setQuimicoEBITDA(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setQuimicoEBITDA(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 28: Receita por segmento - Faturamento - Agro
				if (row.getRowNum() == 27) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setAgroFaturamento(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setAgroFaturamento(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 28: Receita por segmento - EBITDA - Agro
				if (row.getRowNum() == 27) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setAgroEBITDA(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setAgroEBITDA(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 29: Receita por segmento - Descri��o -
				// Outros
				if (row.getRowNum() == 28) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes.setDescricaoOutros(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setDescricaoOutros(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 29: Receita por segmento - Faturamento - Outros
				if (row.getRowNum() == 28) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setOutrosFaturamento(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setOutrosFaturamento(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 29: Receita por segmento - EBITDA - Outros
				if (row.getRowNum() == 28) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setOutrosEBITDA(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setOutrosEBITDA(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 30: Receita por segmento - Faturamento - Setor
				// P�blico
				if (row.getRowNum() == 29) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setSetorPublicoFaturamento(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setSetorPublicoFaturamento(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 30: Receita por segmento - EBITDA - Setor
				// P�blico
				if (row.getRowNum() == 29) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setSetorPublicoEBITDA(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setSetorPublicoEBITDA(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 31: Receita por segmento - Faturamento -
				// Receitas � vista
				if (row.getRowNum() == 30) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReceitasVistaFaturamento(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReceitasVistaFaturamento(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 31: Receita por segmento - EBITDA - Receitas
				// �
				// vista
				if (row.getRowNum() == 30) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReceitasVistaEBITDA(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setReceitasVistaEBITDA(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 32: Receita por segmento - Faturamento -
				// Receitas � prazo (90 dias)
				if (row.getRowNum() == 31) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReceitasPrazoFaturamento(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReceitasPrazoFaturamento(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 32: Receita por segmento - EBITDA - Receitas
				// �
				// prazo (90 dias)
				if (row.getRowNum() == 31) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReceitasPrazoEBITDA(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setReceitasPrazoEBITDA(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 34 at� 36: Detalhar situa��o dos
				// principais
				// contratos (atrasos prefeituras)
				if (row.getRowNum() >= 34 && row.getRowNum() <= 35) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setDetalharSituacaoPrincipaisContratos(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setDetalharSituacaoPrincipaisContratos(cell
												.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 39 at� 40: Licita��es e seus Vencimento
				if (row.getRowNum() >= 38 && row.getRowNum() <= 39) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setLicitacoesSeusVencimentos(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setLicitacoesSeusVencimentos(cell
												.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 43 at� 44: Outorga (vencimentos) / Ultimos
				// valores pagos e fonte de financiamento / esclarecer idade
				// m�dia exigida em contrato
				if (row.getRowNum() >= 42 && row.getRowNum() <= 43) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setOutorgaVencimentosUltimosValores(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setOutorgaVencimentosUltimosValores(cell
												.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 47: Principais Custos Operacionais - ANO
				if (row.getRowNum() == 46) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setAnoPrincipalCustoOperacional(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setAnoPrincipalCustoOperacional(((int) cell
												.getNumericCellValue()) + "");
								break;
							}
						}
					}
				}

				// Captura Linha 48: Principais Custos Operacionais -
				// Combust�veis
				if (row.getRowNum() == 47) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setCombustiveis1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setCombustiveis1(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 48: Principais Custos Operacionais -
				// Combust�veis
				if (row.getRowNum() == 47) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setCombustiveis2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setCombustiveis2(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 48: Principais Custos Operacionais -
				// Combust�veis
				if (row.getRowNum() == 47) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setCombustiveis3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setCombustiveis3(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 48: Principais Custos Operacionais -
				// Combust�veis
				if (row.getRowNum() == 47) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setCombustiveis4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setCombustiveis4(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 49: Principais Custos Operacionais -
				// M�o-de-Obra
				if (row.getRowNum() == 48) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setMaoDeObra1(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setMaoDeObra1(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 49: Principais Custos Operacionais -
				// M�o-de-Obra
				if (row.getRowNum() == 48) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setMaoDeObra2(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setMaoDeObra2(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 49: Principais Custos Operacionais -
				// M�o-de-Obra
				if (row.getRowNum() == 48) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setMaoDeObra3(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setMaoDeObra3(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 49: Principais Custos Operacionais -
				// M�o-de-Obra
				if (row.getRowNum() == 48) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setMaoDeObra4(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setMaoDeObra4(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 50: Principais Custos Operacionais - Outros
				if (row.getRowNum() == 49) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setOutros1(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setOutros1(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 50: Principais Custos Operacionais - Outros
				if (row.getRowNum() == 49) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setOutros2(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setOutros2(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 50: Principais Custos Operacionais - Outros
				if (row.getRowNum() == 49) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setOutros3(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setOutros3(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 50: Principais Custos Operacionais - Outros
				if (row.getRowNum() == 49) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setOutros4(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setOutros4(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 55: CAPEX - Recursos Pr�prios
				if (row.getRowNum() == 54) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setRecursosProprios1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setRecursosProprios1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 55: CAPEX - Recursos Pr�prios
				if (row.getRowNum() == 54) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setRecursosProprios2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setRecursosProprios2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 55: CAPEX - Recursos Pr�prios
				if (row.getRowNum() == 54) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setRecursosProprios3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setRecursosProprios3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 55: CAPEX - Recursos Pr�prios
				if (row.getRowNum() == 54) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setRecursosProprios4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setRecursosProprios4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 56: CAPEX - Recursos Terceiros
				if (row.getRowNum() == 55) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setRecursosTerceiros1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setRecursosTerceiros1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 56: CAPEX - Recursos Terceiros
				if (row.getRowNum() == 55) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setRecursosTerceiros2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setRecursosTerceiros2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 56: CAPEX - Recursos Terceiros
				if (row.getRowNum() == 55) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setRecursosTerceiros3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setRecursosTerceiros3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 56: CAPEX - Recursos Terceiros
				if (row.getRowNum() == 55) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setRecursosTerceiros4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setRecursosTerceiros4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 58 at� 59: Detalhar principais investimentos
				// realizados nos ultimos anos e � serem realizados, bem como,
				// expectativa de retorno
				if (row.getRowNum() >= 57 && row.getRowNum() <= 58) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setDetalharPrincipaisInvestimentos(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setDetalharPrincipaisInvestimentos(cell
												.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 63: Tipo de Contratos - A Performar
				if (row.getRowNum() == 62) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoAPerformar1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoAPerformar1(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 63: Tipo de Contratos - A Performar
				if (row.getRowNum() == 62) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoAPerformar2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoAPerformar2(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 63: Tipo de Contratos - A Performar
				if (row.getRowNum() == 62) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoAPerformar3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoAPerformar3(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 63: Tipo de Contratos - A Performar
				if (row.getRowNum() == 62) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoAPerformar4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoAPerformar4(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 64: Tipo de Contratos - Take or Pay
				if (row.getRowNum() == 63) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoTakeOrPay1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoTakeOrPay1(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 64: Tipo de Contratos - Take or Pay
				if (row.getRowNum() == 63) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoTakeOrPay2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoTakeOrPay2(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 64: Tipo de Contratos - Take or Pay
				if (row.getRowNum() == 63) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoTakeOrPay3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoTakeOrPay3(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 64: Tipo de Contratos - Take or Pay
				if (row.getRowNum() == 63) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoTakeOrPay4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoTakeOrPay4(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 65: Tipo de Contratos - Loca��o (Rental)
				if (row.getRowNum() == 64) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoLocacao1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoLocacao1(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 65: Tipo de Contratos - Loca��o (Rental)
				if (row.getRowNum() == 64) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoLocacao2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoLocacao2(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 65: Tipo de Contratos - Loca��o (Rental)
				if (row.getRowNum() == 64) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoLocacao3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoLocacao3(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 65: Tipo de Contratos - Loca��o (Rental)
				if (row.getRowNum() == 64) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoLocacao4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoLocacao4(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 66: Tipo de Contratos - Spot
				if (row.getRowNum() == 65) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoSpot1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoSpot1(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 66: Tipo de Contratos - Spot
				if (row.getRowNum() == 65) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoSpot2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoSpot2(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 66: Tipo de Contratos - Spot
				if (row.getRowNum() == 65) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoSpot3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoSpot3(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 66: Tipo de Contratos - Spot
				if (row.getRowNum() == 65) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setTpContratoSpot4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setTpContratoSpot4(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 73: Frotas - Pr�pria
				if (row.getRowNum() == 72) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaPropria1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFrotaPropria1(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 73: Frotas - Pr�pria
				if (row.getRowNum() == 72) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaPropria2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFrotaPropria2(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 73: Frotas - Pr�pria
				if (row.getRowNum() == 72) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaPropria3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFrotaPropria3(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 73: Frotas - Pr�pria
				if (row.getRowNum() == 72) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaPropria4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFrotaPropria4(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 74: Frotas - Agregados
				if (row.getRowNum() == 73) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaAgregados1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFrotaAgregados1(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 74: Frotas - Agregados
				if (row.getRowNum() == 73) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaAgregados2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFrotaAgregados2(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 74: Frotas - Agregados
				if (row.getRowNum() == 73) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaAgregados3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFrotaAgregados3(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 74: Frotas - Agregados
				if (row.getRowNum() == 73) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaAgregados4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFrotaAgregados4(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 75: Frotas - Terceiros
				if (row.getRowNum() == 74) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaTerceiros1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFrotaTerceiros1(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 75: Frotas - Terceiros
				if (row.getRowNum() == 74) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaTerceiros2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFrotaTerceiros2(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 75: Frotas - Terceiros
				if (row.getRowNum() == 74) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaTerceiros3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFrotaTerceiros3(cell
										.getNumericCellValue());

								break;
							}
						}
					}
				}

				// Captura Linha 75: Frotas - Terceiros
				if (row.getRowNum() == 74) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaTerceiros4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFrotaTerceiros4(cell
										.getNumericCellValue());

								break;
							}
						}
					}
				}

				// Captura Linha 84: Faturamento - Loca��o
				if (row.getRowNum() == 83) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFaturamentoLocacao1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFaturamentoLocacao1(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 84: Faturamento - Loca��o
				if (row.getRowNum() == 83) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFaturamentoLocacao2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFaturamentoLocacao2(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 84: Faturamento - Loca��o
				if (row.getRowNum() == 83) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFaturamentoLocacao3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFaturamentoLocacao3(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 84: Faturamento - Loca��o
				if (row.getRowNum() == 83) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFaturamentoLocacao4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFaturamentoLocacao4(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 85: Faturamento - Outros - Descri��o
				if (row.getRowNum() == 84) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setDescricaoFaturamentoOutros(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setDescricaoFaturamentoOutros(cell
												.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 85: Faturamento - Outros
				if (row.getRowNum() == 84) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFaturamentoOutros1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFaturamentoOutros1(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 85: Faturamento - Outros
				if (row.getRowNum() == 84) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFaturamentoOutros2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFaturamentoOutros2(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 85: Faturamento - Outros
				if (row.getRowNum() == 84) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFaturamentoOutros3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFaturamentoOutros3(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 85: Faturamento - Outros
				if (row.getRowNum() == 84) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFaturamentoOutros4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes.setFaturamentoOutros4(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 86: Faturamento - Venda de Veiculos
				if (row.getRowNum() == 85) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFaturamentoVendaDeVeiculos1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setFaturamentoVendaDeVeiculos1(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 86: Faturamento - Venda de Veiculos
				if (row.getRowNum() == 85) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFaturamentoVendaDeVeiculos2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setFaturamentoVendaDeVeiculos2(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 86: Faturamento - Venda de Veiculos
				if (row.getRowNum() == 85) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFaturamentoVendaDeVeiculos3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setFaturamentoVendaDeVeiculos3(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 86: Faturamento - Venda de Veiculos
				if (row.getRowNum() == 85) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFaturamentoVendaDeVeiculos4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setFaturamentoVendaDeVeiculos4(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 90: Frota em Unidades - Total
				if (row.getRowNum() == 89) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaUnidadesTotal1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setFrotaUnidadesTotal1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 90: Frota em Unidades - Total
				if (row.getRowNum() == 89) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaUnidadesTotal2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setFrotaUnidadesTotal2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 90: Frota em Unidades - Total
				if (row.getRowNum() == 89) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaUnidadesTotal3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setFrotaUnidadesTotal3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 90: Frota em Unidades - Total
				if (row.getRowNum() == 89) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaUnidadesTotal4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setFrotaUnidadesTotal4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 91: Frota em Unidades - Venda de Veiculos no
				// Ano
				if (row.getRowNum() == 90) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaUnidadesVendaVeiculos1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setFrotaUnidadesVendaVeiculos1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 91: Frota em Unidades - Venda de Veiculos no
				// Ano
				if (row.getRowNum() == 90) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaUnidadesVendaVeiculos2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setFrotaUnidadesVendaVeiculos2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 91: Frota em Unidades - Venda de Veiculos no
				// Ano
				if (row.getRowNum() == 90) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaUnidadesVendaVeiculos3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setFrotaUnidadesVendaVeiculos3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 91: Frota em Unidades - Venda de Veiculos no
				// Ano
				if (row.getRowNum() == 90) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setFrotaUnidadesVendaVeiculos4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setFrotaUnidadesVendaVeiculos4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				// Captura Linha 97: Reajustes nos pre�os de Passagens -
				// Municipal
				if (row.getRowNum() == 96) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensMunicipal1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensMunicipal1(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 97: Reajustes nos pre�os de Passagens -
				// Municipal
				if (row.getRowNum() == 96) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensMunicipal2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensMunicipal2(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 97: Reajustes nos pre�os de Passagens -
				// Municipal
				if (row.getRowNum() == 96) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensMunicipal3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensMunicipal3(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 97: Reajustes nos pre�os de Passagens -
				// Municipal
				if (row.getRowNum() == 96) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensMunicipal4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensMunicipal4(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 98: Reajustes nos pre�os de Passagens -
				// Intermunicipal
				if (row.getRowNum() == 97) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensIntermunicipal1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensIntermunicipal1(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 98: Reajustes nos pre�os de Passagens -
				// Intermunicipal
				if (row.getRowNum() == 97) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensIntermunicipal2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensIntermunicipal2(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 98: Reajustes nos pre�os de Passagens -
				// Intermunicipal
				if (row.getRowNum() == 97) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensIntermunicipal3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensIntermunicipal3(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 98: Reajustes nos pre�os de Passagens -
				// Intermunicipal
				if (row.getRowNum() == 97) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensIntermunicipal4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensIntermunicipal4(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 99: Reajustes nos pre�os de Passagens -
				// Interestadual
				if (row.getRowNum() == 98) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensInterestadual1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensInterestadual1(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 99: Reajustes nos pre�os de Passagens -
				// Interestadual
				if (row.getRowNum() == 98) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensInterestadual2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensInterestadual2(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 99: Reajustes nos pre�os de Passagens -
				// Interestadual
				if (row.getRowNum() == 98) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensInterestadual3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensInterestadual3(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 99: Reajustes nos pre�os de Passagens -
				// Interestadual
				if (row.getRowNum() == 98) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensInterestadual4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensInterestadual4(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 100: Reajustes nos pre�os de Passagens -
				// Internacional
				if (row.getRowNum() == 99) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensInternacional1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensInternacional1(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 100: Reajustes nos pre�os de Passagens -
				// Internacional
				if (row.getRowNum() == 99) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensInternacional2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensInternacional2(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 100: Reajustes nos pre�os de Passagens -
				// Internacional
				if (row.getRowNum() == 99) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensInternacional3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensInternacional3(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 100: Reajustes nos pre�os de Passagens -
				// Internacional
				if (row.getRowNum() == 99) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensInternacional4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensInternacional4(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 101: Reajustes nos pre�os de Passagens -
				// Fretamento
				if (row.getRowNum() == 100) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensFretamento1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensFretamento1(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 101: Reajustes nos pre�os de Passagens -
				// Fretamento
				if (row.getRowNum() == 100) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensFretamento2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensFretamento2(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 101: Reajustes nos pre�os de Passagens -
				// Fretamento
				if (row.getRowNum() == 100) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensFretamento3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensFretamento3(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 101: Reajustes nos pre�os de Passagens -
				// Fretamento
				if (row.getRowNum() == 100) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorTransportes
										.setReajustesPassagensFretamento4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorTransportes
										.setReajustesPassagensFretamento4(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}
			}// fim da leitura das linhas da planilha

			if (!this.valido) {
				return null;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			BradescoFacesUtils
					.addErrorModalMessage("Falha no processamento da planilha.");
		} catch (IOException e) {
			e.printStackTrace();
			BradescoFacesUtils
					.addErrorModalMessage("Falha no processamento da planilha.");
		}
		return setorTransportes;
	}

}