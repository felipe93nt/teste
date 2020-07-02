package br.com.bradesco.web.ricc.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.xls.SetorProjetosVO;

/**
 * @name QuestionarioProjetoXLS
 * @author Diego Munhoz - Foursys
 * @see QuestionarioProjetoXLS.java
 * @version 1.0
 * @since 05/2019
 */
public class QuestionarioProjetoXLS {

	private Boolean valido;
	
	public SetorProjetosVO lerSetorProjetosXLSM(File arquivo) {

		this.valido = false;
		
		SetorProjetosVO setorProjetos = new SetorProjetosVO();

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
							if (cell.getStringCellValue().equals("P")) {
								this.valido = true;
							}
						}
					}
				}
				
				if (!this.valido) {
					return null;
				}

				// Captura Linha 5: Nome Projeto
				if (row.getRowNum() == 4) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setNomeProjeto(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setNomeProjeto(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 8 at� 14: Descri��o do Projeto
				if (row.getRowNum() == 7) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setDescricaoProjeto(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setDescricaoProjeto(cell
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

						// Captura Linha 19: Acionistas
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setAcionistas1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setAcionistas1(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 19: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setAcionistasParticipacao1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setAcionistasParticipacao1(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 19) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 20: Acionistas
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setAcionistas2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setAcionistas2(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 20: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setAcionistasParticipacao2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setAcionistasParticipacao2(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 20) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 21: Acionistas
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setAcionistas3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setAcionistas3(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 21: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setAcionistasParticipacao3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setAcionistasParticipacao3(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 21) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 22: Acionistas
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setAcionistas4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setAcionistas4(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 22: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setAcionistasParticipacao4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setAcionistasParticipacao4(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 22) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 23: Acionistas
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setAcionistas5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setAcionistas5(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 23: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setAcionistasParticipacao5(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setAcionistasParticipacao5(cell
										.getNumericCellValue());
								break;
							}
						}

					}
				}

				// Captura Linha 24: Data de Inicio
				if (row.getRowNum() == 23) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setDataInicio(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setDataInicio(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 25: Data de Termino
				if (row.getRowNum() == 24) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setDataTermino(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setDataTermino(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 27) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 28: Usos
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUso1(cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUso1(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 28: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUsoParticipacao1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUsoParticipacao1(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 28) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 29: Usos
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUso2(cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUso2(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 29: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUsoParticipacao2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUsoParticipacao2(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 29) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 30: Usos
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUso3(cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUso3(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 30: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUsoParticipacao3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUsoParticipacao3(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 30) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 31: Usos
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUso4(cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUso4(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 31: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUsoParticipacao4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUsoParticipacao4(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 31) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 32: Usos
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUso5(cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUso5(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 32: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUsoParticipacao5(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUsoParticipacao5(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 32) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 33: Usos
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUso6(cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUso6(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 33: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUsoParticipacao6(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUsoParticipacao6(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 33) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 34: Usos
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUso7(cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUso7(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 34: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUsoParticipacao7(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUsoParticipacao7(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 34) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 35: Usos
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUso8(cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUso8(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 35: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUsoParticipacao8(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUsoParticipacao8(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 35) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 36: Usos
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUso9(cell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUso9(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 36: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUsoParticipacao9(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUsoParticipacao9(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 36) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 37: Usos
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setUso10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUso10(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 37: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setUsoParticipacao10(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setUsoParticipacao10(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 39) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 40: Fontes
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setFontes1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontes1(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 40: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setFontesParticipacao1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontesParticipacao1(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 40) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 41: Fontes
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setFontes2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontes2(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 41: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setFontesParticipacao2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontesParticipacao2(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 41) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 42: Fontes
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setFontes3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontes3(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 42: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setFontesParticipacao3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontesParticipacao3(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 42) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 43: Fontes
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setFontes4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontes4(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 43: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setFontesParticipacao4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontesParticipacao4(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 43) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 44: Fontes
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setFontes5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontes5(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 44: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setFontesParticipacao5(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontesParticipacao5(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 44) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 45: Fontes
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setFontes6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontes6(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 45: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setFontesParticipacao6(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontesParticipacao6(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 45) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 46: Fontes
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setFontes7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontes7(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 46: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setFontesParticipacao7(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontesParticipacao7(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 46) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 47: Fontes
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setFontes8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontes8(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 47: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setFontesParticipacao8(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontesParticipacao8(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 47) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 48: Fontes
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setFontes9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontes9(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 48: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setFontesParticipacao9(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontesParticipacao9(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 48) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						// Captura Linha 49: Fontes
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setFontes10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontes10(cell
										.getNumericCellValue() + "");
								break;
							}
						}

						// Captura Linha 49: Participa��o
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setFontesParticipacao10(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFontesParticipacao10(cell
										.getNumericCellValue());
								break;
							}
						}
					}
				}

				// Captura Linha 52 at� 56: Status de Equacionamento
				if (row.getRowNum() == 51) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setStatusEquacionamento(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setStatusEquacionamento(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 61: Construtores
				if (row.getRowNum() == 60) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setConstrutores1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setConstrutores1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 62: Construtores
				if (row.getRowNum() == 61) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setConstrutores2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setConstrutores2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 63: Construtores
				if (row.getRowNum() == 62) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setConstrutores3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setConstrutores3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 64: Construtores
				if (row.getRowNum() == 63) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setConstrutores4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setConstrutores4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 65: Construtores
				if (row.getRowNum() == 64) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setConstrutores5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setConstrutores5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 68: Fornecedores
				if (row.getRowNum() == 67) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setFornecedores1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFornecedores1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 69: Fornecedores
				if (row.getRowNum() == 68) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setFornecedores2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFornecedores2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 70: Fornecedores
				if (row.getRowNum() == 69) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setFornecedores3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFornecedores3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 71: Fornecedores
				if (row.getRowNum() == 70) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setFornecedores4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFornecedores4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 72: Fornecedores
				if (row.getRowNum() == 71) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos.setFornecedores5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos.setFornecedores5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				// Captura Linha 75 at� 77: Status de licenciamento
				// socioambiental
				if (row.getRowNum() == 74) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorProjetos
										.setStatusLicenciamentoSocioambiental(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorProjetos
										.setStatusLicenciamentoSocioambiental(cell
												.getNumericCellValue() + "");
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

		return setorProjetos;
	}
}