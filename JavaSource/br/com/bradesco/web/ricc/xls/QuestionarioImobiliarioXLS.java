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
 * @name QuestionarioImobiliarioXLS
 * @author Diego Munhoz - Foursys
 * @see QuestionarioImobiliarioXLS.java
 * @version 1.0
 * @since 05/2019
 */
public class QuestionarioImobiliarioXLS {
	
	private Boolean valido;
	
	public SetorImobiliarioVO lerSetorImobiliarioQuestionario(File arquivo) {
		
		this.valido = false;
		
		SetorImobiliarioVO setorImobiliario = new SetorImobiliarioVO();
		
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
							if (cell.getStringCellValue().equals("I")) {
								this.valido = true;
							}
						}
					}
				}
				
				if (!this.valido) {
					return null;
				}

				if (row.getRowNum() == 7) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setTipoEmpreendimento(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setTipoEmpreendimento(cell
										.getNumericCellValue() + "");
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
								setorImobiliario.setPublicoAlvo(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPublicoAlvo(cell
										.getNumericCellValue() + "");
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
								setorImobiliario
										.setPreChaves(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPreChaves(cell
										.getNumericCellValue());
								break;
							}
						}

						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPosChaves(Double.parseDouble(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPosChaves(cell
										.getNumericCellValue());
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
								setorImobiliario.setTipoConstrutora(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setTipoConstrutora(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDescricaoConstrutora(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDescricaoConstrutora(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 14) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAreaAtuacaoEstado1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAreaAtuacaoEstado1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAreaAtuacaoRegiao1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAreaAtuacaoRegiao1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 15) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAreaAtuacaoEstado2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAreaAtuacaoEstado2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAreaAtuacaoRegiao2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAreaAtuacaoRegiao2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 16) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAreaAtuacaoEstado3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAreaAtuacaoEstado3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAreaAtuacaoRegiao3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAreaAtuacaoRegiao3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 17) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAreaAtuacaoEstado4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAreaAtuacaoEstado4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAreaAtuacaoRegiao4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAreaAtuacaoRegiao4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 18) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAreaAtuacaoEstado5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAreaAtuacaoEstado5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setAreaAtuacaoRegiao5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setAreaAtuacaoRegiao5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 22) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setHistoricoLancamentoAno1(Integer
												.parseInt(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setHistoricoLancamentoAno1((int) cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setHistoricoLancamentoVGV1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setHistoricoLancamentoVGV1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setHistoricoLancamentoQtdeEmpreendimentos1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setHistoricoLancamentoQtdeEmpreendimentos1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 23) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setHistoricoLancamentoAno2(Integer
												.parseInt(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setHistoricoLancamentoAno2((int) cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setHistoricoLancamentoVGV2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setHistoricoLancamentoVGV2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setHistoricoLancamentoQtdeEmpreendimentos2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setHistoricoLancamentoQtdeEmpreendimentos2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 24) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setHistoricoLancamentoAno3(Integer
												.parseInt(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setHistoricoLancamentoAno3((int) cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setHistoricoLancamentoVGV3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setHistoricoLancamentoVGV3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setHistoricoLancamentoQtdeEmpreendimentos3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setHistoricoLancamentoQtdeEmpreendimentos3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 25) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setHistoricoLancamentoAno4(Integer
												.parseInt(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setHistoricoLancamentoAno4((int) cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setHistoricoLancamentoVGV4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setHistoricoLancamentoVGV4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setHistoricoLancamentoQtdeEmpreendimentos4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setHistoricoLancamentoQtdeEmpreendimentos4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 26) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setHistoricoLancamentoAno5(Integer
												.parseInt(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setHistoricoLancamentoAno5((int) cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setHistoricoLancamentoVGV5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setHistoricoLancamentoVGV5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setHistoricoLancamentoQtdeEmpreendimentos5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setHistoricoLancamentoQtdeEmpreendimentos5(new BigDecimal(
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
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno1(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno1(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado1(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado1(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 43) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno2(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno2(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado2(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado2(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}
				if (row.getRowNum() == 44) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno3(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno3(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado3(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado3(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}
				if (row.getRowNum() == 45) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno4(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno4(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado4(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado4(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}
				if (row.getRowNum() == 46) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno5(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno5(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado5(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado5(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}
				if (row.getRowNum() == 47) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno6(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno6(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado6(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado6(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}
				if (row.getRowNum() == 48) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno7(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno7(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado7(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado7(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 49) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno8(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno8(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado8(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado8(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 50) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno9(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno9(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado9(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado9(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 51) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado10(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado10(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 52) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento11(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao11(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado11(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado11(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista11(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus11(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 53) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento12(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento12(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao12(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao12(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno12(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno12(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado12(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado12(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista12(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista12(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus12(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus12(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 54) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento13(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento13(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao13(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao13(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno13(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno13(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado13(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado13(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista13(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista13(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus13(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus13(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 55) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento14(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento14(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao14(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao14(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno14(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno14(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado14(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado14(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista14(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista14(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus14(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus14(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 56) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento15(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento15(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao15(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao15(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno15(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno15(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado15(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado15(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista15(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista15(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus15(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus15(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 57) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento16(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento16(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao16(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao16(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno16(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno16(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado16(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado16(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista16(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista16(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus16(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus16(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 58) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento17(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento17(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao17(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao17(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno17(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno17(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado17(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado17(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista17(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista17(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus17(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus17(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 59) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento18(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento18(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao18(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao18(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno18(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno18(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado18(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado18(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista18(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista18(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus18(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus18(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 60) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento19(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento19(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao19(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao19(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno19(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno19(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado19(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado19(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista19(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista19(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus19(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus19(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 61) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento20(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento20(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao20(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao20(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno20(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno20(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado20(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado20(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista20(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista20(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus20(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus20(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}
				if (row.getRowNum() == 62) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento21(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento21(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao21(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao21(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno21(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno21(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado21(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado21(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista21(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista21(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus21(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus21(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 63) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento22(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento22(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao22(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao22(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno22(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno22(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado22(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado22(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista22(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista22(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus22(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus22(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 64) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento23(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento23(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao23(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao23(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno23(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno23(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado23(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado23(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista23(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista23(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus23(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus23(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 65) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento24(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento24(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao24(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao24(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno24(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno24(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado24(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado24(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista24(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista24(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus24(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus24(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 66) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento25(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento25(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao25(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao25(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno25(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno25(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado25(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado25(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista25(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista25(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus25(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus25(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 67) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento26(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento26(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao26(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao26(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno26(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno26(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado26(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado26(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista26(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista26(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus26(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus26(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 68) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento27(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento27(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao27(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao27(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno27(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno27(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado27(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado27(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista27(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista27(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus27(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus27(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 69) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento28(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento28(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao28(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao28(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno28(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno28(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado28(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado28(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista28(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista28(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus28(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus28(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 70) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento29(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento29(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao29(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao29(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno29(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno29(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado29(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado29(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista29(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista29(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus29(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus29(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 71) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento30(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento30(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao30(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao30(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno30(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno30(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado30(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado30(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista30(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista30(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus30(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus30(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 72) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento31(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento31(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao31(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao31(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno31(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno31(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado31(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado31(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista31(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista31(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus31(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus31(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 73) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento32(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento32(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao32(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao32(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno32(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno32(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado32(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado32(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista32(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista32(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus32(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus32(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 74) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento33(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento33(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao33(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao33(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno33(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno33(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado33(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado33(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista33(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista33(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus33(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus33(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 75) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento34(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento34(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao34(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao34(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno34(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno34(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado34(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado34(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista34(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista34(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus34(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus34(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}
				if (row.getRowNum() == 76) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento35(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento35(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao35(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao35(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno35(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno35(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado35(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado35(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista35(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista35(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus35(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus35(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 77) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento36(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento36(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao36(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao36(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno36(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno36(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado36(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado36(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista36(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista36(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus36(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus36(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 78) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento37(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento37(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao37(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao37(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno37(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno37(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado37(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado37(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista37(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista37(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus37(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus37(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 79) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento38(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento38(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao38(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao38(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno38(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno38(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado38(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado38(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista38(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista38(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus38(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus38(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 80) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento39(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento39(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao39(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao39(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno39(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno39(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado39(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado39(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista39(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista39(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus39(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus39(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}
				if (row.getRowNum() == 81) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setEmpreendimento40(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setEmpreendimento40(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setLocalizacao40(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setLocalizacao40(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setValorDoTerreno40(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setValorDoTerreno40(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setVgvProjetado40(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setVgvProjetado40(new BigDecimal(cell
												.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setDataPrevista40(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setDataPrevista40(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario.setPossuiOnus40(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario.setPossuiOnus40(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}
			}// fim da leitura das linhas da primeira aba - QUESTIONARIO
			
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
		return setorImobiliario;
		
	}

	public SetorImobiliarioVO lerSetorImobiliarioObrasConcluidas(File arquivo) {

		SetorImobiliarioVO setorImobiliario = new SetorImobiliarioVO();

		try {
			FileInputStream fis = new FileInputStream(arquivo);

			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

			XSSFSheet mySheet = myWorkBook.getSheetAt(2);

			Iterator<Row> rowIterator = mySheet.iterator();

			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();

				if (row.getRowNum() == 9) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setIncorporadoraObraConcluida1(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida1(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida1(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida1(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida1(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida1(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida1(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida1(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida1(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida1(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida1(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida1(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida1(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida1(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida1(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida1(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida2(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida2(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida2(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida2(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida2(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida2(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida2(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida2(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida2(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida2(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida2(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida2(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida2(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida2(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida2(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida2(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida3(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida3(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida3(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida3(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida3(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida3(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida3(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida3(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida3(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida3(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida3(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida3(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida3(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida3(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida3(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida3(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida4(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida4(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida4(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida4(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida4(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida4(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida4(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida4(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida4(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida4(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida4(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida4(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida4(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida4(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida4(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida4(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida5(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida5(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida5(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida5(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida5(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida5(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida5(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida5(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida5(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida5(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida5(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida5(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida5(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida5(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida5(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida5(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida5(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida6(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida6(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida6(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida6(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida6(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida6(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida6(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida6(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida6(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida6(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida6(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida6(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida6(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida6(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida6(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida6(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida6(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida7(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida7(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida7(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida7(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida7(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida7(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida7(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida7(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida7(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida7(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida7(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida7(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida7(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida7(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida7(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida7(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida7(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida8(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida8(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida8(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida8(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida8(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida8(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida8(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida8(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida8(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida8(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida8(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida8(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida8(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida8(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida8(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida8(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida8(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida9(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida9(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida9(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida9(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida9(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida9(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida9(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida9(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida9(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida9(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida9(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida9(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida9(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida9(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida9(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida9(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 18) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setIncorporadoraObraConcluida10(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida10(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida10(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida10(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida10(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida10(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida10(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida10(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida10(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida10(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida10(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida10(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida10(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida10(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida10(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida10(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida10(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida11(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida11(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida11(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida11(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida11(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida11(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida11(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida11(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida11(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida11(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida11(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida11(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida11(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida11(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida11(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida11(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida11(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida12(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida12(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida12(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida12(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida12(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida12(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida12(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida12(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida12(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida12(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida12(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida12(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida12(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida12(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida12(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida12(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida12(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida12(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida12(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida12(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida12(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida12(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida12(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida12(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida12(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida12(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida12(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida12(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida12(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida12(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida13(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida13(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida13(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida13(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida13(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida13(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida13(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida13(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida13(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida13(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida13(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida13(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida13(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida13(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida13(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida13(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida13(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida13(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida13(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida13(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida13(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida13(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida13(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida13(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida13(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida13(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida13(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida13(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida13(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida13(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida14(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida14(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida14(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida14(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida14(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida14(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida14(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida14(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida14(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida14(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida14(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida14(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida14(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida14(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida14(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida14(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida14(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida14(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida14(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida14(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida14(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida14(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida14(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida14(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida14(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida14(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida14(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida14(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida14(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida14(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida15(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida15(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida15(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida15(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida15(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida15(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida15(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida15(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida15(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida15(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida15(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida15(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida15(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida15(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida15(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida15(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida15(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida15(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida15(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida15(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida15(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida15(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida15(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida15(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida15(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida15(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida15(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida15(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida15(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida15(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida16(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida16(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida16(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida16(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida16(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida16(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida16(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida16(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida16(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida16(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida16(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida16(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida16(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida16(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida16(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida16(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida16(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida16(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida16(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida16(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida16(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida16(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida16(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida16(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida16(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida16(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida16(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida16(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida16(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida16(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida17(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida17(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida17(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida17(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida17(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida17(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida17(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida17(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida17(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida17(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida17(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida17(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida17(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida17(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida17(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida17(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida17(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida17(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida17(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida17(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida17(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida17(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida17(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida17(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida17(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida17(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida17(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida17(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida17(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida17(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida18(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida18(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida18(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida18(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida18(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida18(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida18(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida18(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida18(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida18(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida18(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida18(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida18(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida18(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida18(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida18(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida18(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida18(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida18(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida18(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida18(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida18(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida18(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida18(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida18(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida18(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida18(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida18(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida18(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida18(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida19(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida19(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida19(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida19(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida19(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida19(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida19(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida19(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida19(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida19(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida19(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida19(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida19(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida19(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida19(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida19(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida19(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida19(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida19(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida19(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida19(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida19(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida19(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida19(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida19(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida19(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida19(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida19(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida19(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida19(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida20(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida20(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida20(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida20(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida20(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida20(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida20(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida20(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida20(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida20(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida20(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida20(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida20(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida20(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida20(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida20(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida20(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida20(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida20(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida20(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida20(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida20(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida20(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida20(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida20(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida20(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida20(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida20(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida20(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida20(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida21(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida21(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida21(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida21(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida21(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida21(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida21(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida21(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida21(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida21(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida21(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida21(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida21(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida21(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida21(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida21(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida21(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida21(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida21(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida21(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida21(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida21(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida21(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida21(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida21(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida21(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida21(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida21(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida21(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida21(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida22(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida22(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida22(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida22(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida22(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida22(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida22(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida22(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida22(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida22(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida22(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida22(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida22(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida22(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida22(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida22(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida22(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida22(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida22(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida22(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida22(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida22(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida22(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida22(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida22(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida22(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida22(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida22(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida22(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida22(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida23(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida23(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida23(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida23(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida23(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida23(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida23(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida23(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida23(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida23(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida23(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida23(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida23(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida23(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida23(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida23(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida23(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida23(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida23(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida23(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida23(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida23(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida23(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida23(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida23(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida23(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida23(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida23(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida23(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida23(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida24(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida24(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida24(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida24(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida24(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida24(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida24(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida24(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida24(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida24(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida24(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida24(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida24(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida24(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida24(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida24(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida24(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida24(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida24(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida24(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida24(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida24(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida24(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida24(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida24(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida24(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida24(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida24(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida24(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida24(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorImobiliario
										.setIncorporadoraObraConcluida25(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida25(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida25(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida25(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida25(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida25(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida25(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida25(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida25(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida25(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida25(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida25(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida25(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida25(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida25(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida25(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida25(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida25(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida25(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida25(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida25(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida25(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida25(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida25(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida25(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida25(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida25(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida25(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida25(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida25(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 34) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setIncorporadoraObraConcluida26(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida26(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida26(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida26(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida26(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida26(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida26(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida26(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida26(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida26(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida26(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida26(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida26(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida26(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida26(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida26(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida26(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida26(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida26(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida26(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida26(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida26(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida26(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida26(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida26(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida26(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida26(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida26(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida26(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida26(new BigDecimal(
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
								setorImobiliario
										.setIncorporadoraObraConcluida27(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida27(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida27(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida27(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida27(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida27(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida27(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida27(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida27(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida27(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida27(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida27(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida27(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida27(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida27(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida27(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida27(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida27(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida27(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida27(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida27(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida27(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida27(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida27(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida27(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida27(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida27(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida27(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida27(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida27(new BigDecimal(
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
								setorImobiliario
										.setIncorporadoraObraConcluida28(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida28(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida28(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida28(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida28(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida28(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida28(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida28(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida28(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida28(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida28(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida28(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida28(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida28(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida28(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida28(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida28(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida28(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida28(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida28(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida28(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida28(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida28(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida28(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida28(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida28(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida28(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida28(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida28(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida28(new BigDecimal(
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
								setorImobiliario
										.setIncorporadoraObraConcluida29(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida29(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida29(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida29(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida29(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida29(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida29(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida29(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida29(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida29(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida29(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida29(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida29(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida29(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida29(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida29(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida29(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida29(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida29(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida29(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida29(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida29(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida29(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida29(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida29(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida29(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida29(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida29(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida29(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida29(new BigDecimal(
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
								setorImobiliario
										.setIncorporadoraObraConcluida30(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida30(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida30(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida30(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida30(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida30(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida30(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida30(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida30(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida30(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida30(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida30(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida30(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida30(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida30(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida30(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida30(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida30(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida30(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida30(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida30(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida30(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida30(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida30(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida30(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida30(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida30(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida30(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida30(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida30(new BigDecimal(
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
								setorImobiliario
										.setIncorporadoraObraConcluida31(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida31(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida31(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida31(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida31(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida31(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida31(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida31(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida31(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida31(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida31(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida31(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida31(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida31(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida31(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida31(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida31(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida31(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida31(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida31(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida31(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida31(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida31(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida31(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida31(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida31(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida31(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida31(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida31(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida31(new BigDecimal(
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
								setorImobiliario
										.setIncorporadoraObraConcluida32(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida32(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida32(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida32(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida32(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida32(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida32(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida32(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida32(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida32(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida32(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida32(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida32(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida32(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida32(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida32(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida32(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida32(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida32(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida32(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida32(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida32(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida32(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida32(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida32(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida32(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida32(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida32(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida32(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida32(new BigDecimal(
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
								setorImobiliario
										.setIncorporadoraObraConcluida33(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida33(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida33(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida33(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida33(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida33(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida33(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida33(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida33(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida33(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida33(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida33(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida33(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida33(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida33(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida33(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida33(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida33(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida33(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida33(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida33(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida33(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida33(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida33(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida33(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida33(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida33(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida33(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida33(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida33(new BigDecimal(
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
								setorImobiliario
										.setIncorporadoraObraConcluida34(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida34(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida34(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida34(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida34(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida34(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida34(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida34(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida34(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida34(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida34(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida34(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida34(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida34(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida34(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida34(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida34(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida34(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida34(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida34(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida34(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida34(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida34(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida34(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida34(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida34(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida34(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida34(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida34(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida34(new BigDecimal(
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
								setorImobiliario
										.setIncorporadoraObraConcluida35(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida35(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida35(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida35(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida35(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida35(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida35(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida35(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida35(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida35(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida35(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida35(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida35(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida35(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida35(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida35(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida35(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida35(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida35(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida35(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida35(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida35(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida35(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida35(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida35(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida35(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida35(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida35(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida35(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida35(new BigDecimal(
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
								setorImobiliario
										.setIncorporadoraObraConcluida36(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida36(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida36(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida36(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida36(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida36(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida36(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida36(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida36(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida36(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida36(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida36(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida36(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida36(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida36(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida36(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida36(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida36(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida36(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida36(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida36(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida36(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida36(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida36(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida36(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida36(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida36(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida36(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida36(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida36(new BigDecimal(
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
								setorImobiliario
										.setIncorporadoraObraConcluida37(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida37(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida37(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida37(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida37(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida37(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida37(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida37(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida37(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida37(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida37(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida37(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida37(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida37(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida37(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida37(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida37(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida37(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida37(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida37(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida37(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida37(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida37(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida37(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida37(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida37(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida37(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida37(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida37(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida37(new BigDecimal(
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
								setorImobiliario
										.setIncorporadoraObraConcluida38(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida38(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida38(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida38(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida38(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida38(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida38(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida38(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida38(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida38(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida38(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida38(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida38(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida38(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida38(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida38(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida38(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida38(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida38(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida38(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida38(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida38(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida38(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida38(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida38(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida38(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida38(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida38(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida38(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida38(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 47) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setIncorporadoraObraConcluida39(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida39(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida39(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida39(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida39(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida39(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida39(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida39(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida39(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida39(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida39(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida39(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida39(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida39(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida39(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida39(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida39(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida39(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida39(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida39(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida39(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida39(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida39(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida39(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida39(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida39(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida39(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida39(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida39(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida39(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 48) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setIncorporadoraObraConcluida40(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setIncorporadoraObraConcluida40(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida40(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setNomeEmpreendimentoObraConcluida40(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida40(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setBairroLocalizacaoObraConcluida40(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida40(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setCidadeLocalizacaoObraConcluida40(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setUfLocalizacaoObraConcluida40(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setUfLocalizacaoObraConcluida40(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 16) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDataEntregaObraConcluida40(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDataEntregaObraConcluida40(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setRecebidosObraConcluida40(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setRecebidosObraConcluida40(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAteDozeMesesObraConcluida40(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAteDozeMesesObraConcluida40(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 9) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida40(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setDeDozeAteDezesseisMesesObraConcluida40(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 10) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida40(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAposTrintaSeisMesesObraConcluida40(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 11) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida40(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setQuantidadeUnidadesObraConcluida40(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 12) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setPercentualVendasObraConcluida40(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setPercentualVendasObraConcluida40(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 13) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setEstoqueObraConcluida40(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setEstoqueObraConcluida40(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 14) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida40(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setAgenteFinanceiroObraConcluida40(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 15) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setSaldoDevedorObraConcluida40(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setSaldoDevedorObraConcluida40(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 53) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorImobiliario
										.setComentariosGeraisObraConcluida(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorImobiliario
										.setComentariosGeraisObraConcluida(cell
												.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

			}// fim da leitura das linhas da terceira aba - OBRA CONCLUIDA

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			BradescoFacesUtils
					.addErrorModalMessage("Falha no processamento da planilha.");
		} catch (IOException e) {
			e.printStackTrace();
			BradescoFacesUtils
					.addErrorModalMessage("Falha no processamento da planilha.");
		}
		
		return setorImobiliario;
	}	

}