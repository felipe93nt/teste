package br.com.bradesco.web.ricc.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.xls.SetorAgronegocioVO;

/**
 * @name QuestionarioAgronegocioXLS
 * @author Diego Munhoz - Foursys
 * @see QuestionarioAgronegocioXLS.java
 * @version 1.0
 * @since 05/2019
 */
public class QuestionarioAgronegocioXLS {

	private Boolean valido;

	public SetorAgronegocioVO lerSetorAgronegocioProdutorGraosFibras(
			File arquivo) {

		this.valido = false;

		SetorAgronegocioVO setorAgronegocio = new SetorAgronegocioVO();

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
							if (cell.getStringCellValue().equals("A")) {
								this.valido = true;
							}
						}
					}
				}

				if (!this.valido) {
					return null;
				}

				if (row.getRowNum() == 4) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setNomeProdutor(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setNomeProdutor(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 7) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDescricaoAreaPropria1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setAreaCedidaAreaPropria1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setAreaCedidaAreaPropria1(cell
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
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDescricaoAreaPropria2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setAreaCedidaAreaPropria2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setAreaCedidaAreaPropria2(cell
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
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDescricaoAreaPropria3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setAreaCedidaAreaPropria3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setAreaCedidaAreaPropria3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 10) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDescricaoAreaPropria4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setAreaCedidaAreaPropria4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setAreaCedidaAreaPropria4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 11) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDescricaoAreaPropria5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setAreaCedidaAreaPropria5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setAreaCedidaAreaPropria5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 12) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDescricaoAreaPropria6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setAreaCedidaAreaPropria6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setAreaCedidaAreaPropria6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 13) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDescricaoAreaPropria7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setAreaCedidaAreaPropria7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setAreaCedidaAreaPropria7(cell
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
								setorAgronegocio.setDescricaoAreaPropria8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setAreaCedidaAreaPropria8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setAreaCedidaAreaPropria8(cell
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
								setorAgronegocio.setDescricaoAreaPropria9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setAreaCedidaAreaPropria9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setAreaCedidaAreaPropria9(cell
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
								setorAgronegocio.setDescricaoAreaPropria10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaCedidaAreaPropria10(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaCedidaAreaPropria10(cell
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
								setorAgronegocio.setDescricaoAreaPropria11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria11(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria11(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaCedidaAreaPropria11(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaCedidaAreaPropria11(cell
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
								setorAgronegocio.setDescricaoAreaPropria12(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria12(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria12(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria12(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria12(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria12(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria12(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria12(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria12(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria12(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria12(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria12(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaCedidaAreaPropria12(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaCedidaAreaPropria12(cell
												.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 19) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDescricaoAreaPropria13(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria13(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria13(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria13(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria13(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria13(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria13(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria13(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria13(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria13(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria13(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria13(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaCedidaAreaPropria13(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaCedidaAreaPropria13(cell
												.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 20) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDescricaoAreaPropria14(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria14(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria14(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria14(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria14(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria14(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria14(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria14(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria14(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria14(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria14(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria14(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaCedidaAreaPropria14(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaCedidaAreaPropria14(cell
												.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 21) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDescricaoAreaPropria15(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria15(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria15(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria15(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria15(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria15(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria15(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria15(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria15(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria15(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria15(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria15(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaCedidaAreaPropria15(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaCedidaAreaPropria15(cell
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
								setorAgronegocio.setDescricaoAreaPropria16(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria16(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria16(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria16(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria16(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria16(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria16(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria16(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria16(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria16(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria16(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria16(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaCedidaAreaPropria16(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaCedidaAreaPropria16(cell
												.getNumericCellValue() + "");
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
								setorAgronegocio.setDescricaoAreaPropria17(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria17(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria17(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria17(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria17(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria17(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria17(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria17(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria17(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria17(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria17(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria17(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaCedidaAreaPropria17(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaCedidaAreaPropria17(cell
												.getNumericCellValue() + "");
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
								setorAgronegocio.setDescricaoAreaPropria18(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria18(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria18(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria18(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria18(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria18(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria18(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria18(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria18(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria18(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria18(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria18(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaCedidaAreaPropria18(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaCedidaAreaPropria18(cell
												.getNumericCellValue() + "");
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
								setorAgronegocio.setDescricaoAreaPropria19(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria19(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria19(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria19(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria19(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria19(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria19(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria19(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria19(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria19(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria19(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria19(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaCedidaAreaPropria19(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaCedidaAreaPropria19(cell
												.getNumericCellValue() + "");
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
								setorAgronegocio.setDescricaoAreaPropria20(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDescricaoAreaPropria20(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaPropria20(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaPropria20(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaPropria20(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaPropria20(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaPropria20(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaPropria20(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria20(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSMilAreaPropria20(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 5) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria20(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setValorMercadoRSHectareAreaPropria20(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 6) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaCedidaAreaPropria20(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaCedidaAreaPropria20(cell
												.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 31) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDescricaoAreaArrendada1(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada1(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada1(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada1(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataInicioAreaArrendada1(""
										+ cell.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada1(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 32) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDescricaoAreaArrendada2(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada2(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada2(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada2(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataInicioAreaArrendada2(""
										+ cell.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada2(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 33) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDescricaoAreaArrendada3(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada3(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada3(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada3(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataInicioAreaArrendada3(""
										+ cell.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada3(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 34) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDescricaoAreaArrendada4(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada4(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada4(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada4(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada4(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada4(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 35) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDescricaoAreaArrendada5(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada5(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada5(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada5(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada5(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada5(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada5(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada5(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada5(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 36) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDescricaoAreaArrendada6(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada6(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada6(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada6(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada6(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada6(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada6(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada6(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada6(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 37) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDescricaoAreaArrendada7(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada7(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada7(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada7(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada7(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada7(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada7(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada7(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada7(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 38) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDescricaoAreaArrendada8(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada8(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada8(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada8(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada8(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada8(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada8(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada8(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada8(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 39) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDescricaoAreaArrendada9(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada9(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada9(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada9(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada9(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada9(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada9(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada9(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada9(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 40) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDescricaoAreaArrendada10(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada10(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada10(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada10(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada10(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada10(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada10(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada10(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada10(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 41) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDescricaoAreaArrendada11(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada11(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada11(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada11(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada11(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada11(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada11(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada11(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada11(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada11(cell
										.getNumericCellValue() + "");
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
								setorAgronegocio
										.setDescricaoAreaArrendada12(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada12(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada12(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada12(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada12(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada12(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada12(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada12(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada12(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada12(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada12(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada12(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada12(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada12(cell
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
								setorAgronegocio
										.setDescricaoAreaArrendada13(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada13(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada13(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada13(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada13(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada13(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada13(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada13(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada13(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada13(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada13(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada13(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada13(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada13(cell
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
								setorAgronegocio
										.setDescricaoAreaArrendada14(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada14(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada14(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada14(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada14(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada14(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada14(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada14(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada14(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada14(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada14(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada14(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada14(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada14(cell
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
								setorAgronegocio
										.setDescricaoAreaArrendada15(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada15(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada15(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada15(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada15(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada15(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada15(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada15(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada15(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada15(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada15(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada15(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada15(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada15(cell
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
								setorAgronegocio
										.setDescricaoAreaArrendada16(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada16(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada16(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada16(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada16(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada16(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada16(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada16(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada16(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada16(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada16(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada16(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada16(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada16(cell
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
								setorAgronegocio
										.setDescricaoAreaArrendada17(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada17(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada17(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada17(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada17(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada17(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada17(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada17(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada17(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada17(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada17(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada17(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada17(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada17(cell
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
								setorAgronegocio
										.setDescricaoAreaArrendada18(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada18(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada18(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada18(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada18(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada18(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada18(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada18(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada18(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada18(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada18(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada18(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada18(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada18(cell
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
								setorAgronegocio
										.setDescricaoAreaArrendada19(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada19(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada19(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada19(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada19(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada19(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada19(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada19(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada19(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada19(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada19(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada19(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada19(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada19(cell
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
								setorAgronegocio
										.setDescricaoAreaArrendada20(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDescricaoAreaArrendada20(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaTotalAreaArrendada20(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaTotalAreaArrendada20(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada20(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAreaProdutivaAreaArrendada20(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setCidadeAreaArrendada20(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCidadeAreaArrendada20(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada20(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCustoArrendamentoAreaArrendada20(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setDataInicioAreaArrendada20(cell
												.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setDataInicioAreaArrendada20(cell
												.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 8) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setDataFimAreaArrendada20(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setDataFimAreaArrendada20(cell
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
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux1 = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado1 = aux1.split(";");
								setorAgronegocio
										.setSojaAnoSafra1(textoSeparado1[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setSojaAnoSafra1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado = aux.split(";");
								setorAgronegocio
										.setSojaAnoSafra2(textoSeparado[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setSojaAnoSafra2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado = aux.split(";");
								setorAgronegocio
										.setSojaAnoSafra3(textoSeparado[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setSojaAnoSafra3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado = aux.split(";");
								setorAgronegocio
										.setSojaAnoSafra4(textoSeparado[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setSojaAnoSafra4(cell
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
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaAreaPlantadaPropria1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaAreaPlantadaPropria1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaAreaPlantadaPropria2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaAreaPlantadaPropria2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaAreaPlantadaPropria3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaAreaPlantadaPropria3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaAreaPlantadaPropria4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaAreaPlantadaPropria4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}

					}
				}

				if (row.getRowNum() == 56) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaAreaArrendadaPropria1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaAreaArrendadaPropria1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaAreaArrendadaPropria2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaAreaArrendadaPropria2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaAreaArrendadaPropria3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaAreaArrendadaPropria3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaAreaArrendadaPropria4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaAreaArrendadaPropria4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}

					}
				}

				if (row.getRowNum() == 60) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaProducaoGraos1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaProducaoGraos1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaProducaoGraos2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaProducaoGraos2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaProducaoGraos3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaProducaoGraos3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaProducaoGraos4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaProducaoGraos4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}

					}
				}

				if (row.getRowNum() == 61) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaUnidadesProducaoSementes(Integer
												.parseInt(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaUnidadesProducaoSementes((int) cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaProducaoSementes1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaProducaoSementes1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaProducaoSementes2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaProducaoSementes2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaProducaoSementes3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaProducaoSementes3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaProducaoSementes4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaProducaoSementes4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 64) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaProdutividadeRealizadaProjetada1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaProdutividadeRealizadaProjetada1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaProdutividadeRealizadaProjetada2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaProdutividadeRealizadaProjetada2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaProdutividadeRealizadaProjetada3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaProdutividadeRealizadaProjetada3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaProdutividadeRealizadaProjetada4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaProdutividadeRealizadaProjetada4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 65) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPrecoMedioGraoRealizadoProjetado1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPrecoMedioGraoRealizadoProjetado1(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPrecoMedioGraoRealizadoProjetado2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPrecoMedioGraoRealizadoProjetado2(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPrecoMedioGraoRealizadoProjetado3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPrecoMedioGraoRealizadoProjetado3(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPrecoMedioGraoRealizadoProjetado4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPrecoMedioGraoRealizadoProjetado4(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}

					}
				}

				if (row.getRowNum() == 66) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaUnidadesPrecoMedioSemente(Integer
												.parseInt(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaUnidadesPrecoMedioSemente((int) cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPrecoMedioSementeRealizadoProjetado1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPrecoMedioSementeRealizadoProjetado1(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPrecoMedioSementeRealizadoProjetado2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPrecoMedioSementeRealizadoProjetado2(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPrecoMedioSementeRealizadoProjetado3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPrecoMedioSementeRealizadoProjetado3(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPrecoMedioSementeRealizadoProjetado4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPrecoMedioSementeRealizadoProjetado4(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 67) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPorcentagemVolumeGraoFixado1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPorcentagemVolumeGraoFixado1(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPorcentagemVolumeGraoFixado2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPorcentagemVolumeGraoFixado2(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPorcentagemVolumeGraoFixado3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPorcentagemVolumeGraoFixado3(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPorcentagemVolumeGraoFixado4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPorcentagemVolumeGraoFixado4(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 68) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPrecoMedioFixado1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPrecoMedioFixado1(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPrecoMedioFixado2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPrecoMedioFixado2(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPrecoMedioFixado3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPrecoMedioFixado3(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaPrecoMedioFixado4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaPrecoMedioFixado4(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 69) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaCustoProducaoRealizadoProjetado1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaCustoProducaoRealizadoProjetado1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaCustoProducaoRealizadoProjetado2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaCustoProducaoRealizadoProjetado2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaCustoProducaoRealizadoProjetado3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaCustoProducaoRealizadoProjetado3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setSojaCustoProducaoRealizadoProjetado4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setSojaCustoProducaoRealizadoProjetado4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 72) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux1 = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado1 = aux1.split(";");
								setorAgronegocio
										.setMilhoAnoSafra1(textoSeparado1[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setMilhoAnoSafra1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux1 = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado1 = aux1.split(";");
								setorAgronegocio
										.setMilhoAnoSafra2(textoSeparado1[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setMilhoAnoSafra2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux1 = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado1 = aux1.split(";");
								setorAgronegocio
										.setMilhoAnoSafra3(textoSeparado1[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setMilhoAnoSafra3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux1 = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado1 = aux1.split(";");
								setorAgronegocio
										.setMilhoAnoSafra4(textoSeparado1[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setMilhoAnoSafra4(cell
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
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoAreaPlantadaPropria1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoAreaPlantadaPropria1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoAreaPlantadaPropria2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoAreaPlantadaPropria2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoAreaPlantadaPropria3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoAreaPlantadaPropria3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoAreaPlantadaPropria4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoAreaPlantadaPropria4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 74) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoAreaArrendadaPropria1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoAreaArrendadaPropria1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoAreaArrendadaPropria2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoAreaArrendadaPropria2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoAreaArrendadaPropria3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoAreaArrendadaPropria3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoAreaArrendadaPropria4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoAreaArrendadaPropria4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 78) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoProducaoGraos1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoProducaoGraos1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoProducaoGraos2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoProducaoGraos2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoProducaoGraos3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoProducaoGraos3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoProducaoGraos4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoProducaoGraos4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 79) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoUnidadesProducaoSementes(Integer
												.parseInt(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoUnidadesProducaoSementes((int) cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoProducaoSementes1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoProducaoSementes1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoProducaoSementes2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoProducaoSementes2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoProducaoSementes3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoProducaoSementes3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoProducaoSementes4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoProducaoSementes4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 82) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoProdutividadeRealizadaProjetada1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoProdutividadeRealizadaProjetada1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoProdutividadeRealizadaProjetada2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoProdutividadeRealizadaProjetada2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoProdutividadeRealizadaProjetada3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoProdutividadeRealizadaProjetada3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoProdutividadeRealizadaProjetada4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoProdutividadeRealizadaProjetada4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 83) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPrecoMedioGraoRealizadoProjetado1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPrecoMedioGraoRealizadoProjetado1(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPrecoMedioGraoRealizadoProjetado2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPrecoMedioGraoRealizadoProjetado2(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPrecoMedioGraoRealizadoProjetado3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPrecoMedioGraoRealizadoProjetado3(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPrecoMedioGraoRealizadoProjetado4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPrecoMedioGraoRealizadoProjetado4(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 84) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 7) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoUnidadesPrecoMedioSemente(Integer
												.parseInt(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoUnidadesPrecoMedioSemente((int) cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPrecoMedioSementeRealizadoProjetado1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPrecoMedioSementeRealizadoProjetado1(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPrecoMedioSementeRealizadoProjetado2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPrecoMedioSementeRealizadoProjetado2(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPrecoMedioSementeRealizadoProjetado3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPrecoMedioSementeRealizadoProjetado3(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPrecoMedioSementeRealizadoProjetado4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPrecoMedioSementeRealizadoProjetado4(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 85) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPorcentagemVolumeGraoFixado1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPorcentagemVolumeGraoFixado1(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPorcentagemVolumeGraoFixado2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPorcentagemVolumeGraoFixado2(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPorcentagemVolumeGraoFixado3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPorcentagemVolumeGraoFixado3(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPorcentagemVolumeGraoFixado4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPorcentagemVolumeGraoFixado4(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 86) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPrecoMedioFixado1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPrecoMedioFixado1(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPrecoMedioFixado2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPrecoMedioFixado2(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPrecoMedioFixado3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPrecoMedioFixado3(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoPrecoMedioFixado4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoPrecoMedioFixado4(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 87) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoCustoProducaoRealizadoProjetado1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoCustoProducaoRealizadoProjetado1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoCustoProducaoRealizadoProjetado2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoCustoProducaoRealizadoProjetado2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoCustoProducaoRealizadoProjetado3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoCustoProducaoRealizadoProjetado3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setMilhoCustoProducaoRealizadoProjetado4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setMilhoCustoProducaoRealizadoProjetado4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 90) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux1 = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado1 = aux1.split(";");
								setorAgronegocio
										.setAlgodaoAnoSafra1(textoSeparado1[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setAlgodaoAnoSafra1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux1 = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado1 = aux1.split(";");
								setorAgronegocio
										.setAlgodaoAnoSafra2(textoSeparado1[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setAlgodaoAnoSafra2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux1 = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado1 = aux1.split(";");
								setorAgronegocio
										.setAlgodaoAnoSafra3(textoSeparado1[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setAlgodaoAnoSafra3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux1 = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado1 = aux1.split(";");
								setorAgronegocio
										.setAlgodaoAnoSafra4(textoSeparado1[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setAlgodaoAnoSafra4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 91) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoAreaPlantadaPropria1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoAreaPlantadaPropria1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoAreaPlantadaPropria2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoAreaPlantadaPropria2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoAreaPlantadaPropria3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoAreaPlantadaPropria3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoAreaPlantadaPropria4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoAreaPlantadaPropria4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 92) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoAreaArrendadaPropria1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoAreaArrendadaPropria1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoAreaArrendadaPropria2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoAreaArrendadaPropria2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoAreaArrendadaPropria3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoAreaArrendadaPropria3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoAreaArrendadaPropria4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoAreaArrendadaPropria4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 96) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalPluma1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalPluma1(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalPluma2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalPluma2(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalPluma3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalPluma3(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalPluma4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalPluma4(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 97) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalCaroco1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalCaroco1(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalCaroco2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalCaroco2(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalCaroco3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalCaroco3(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalCaroco4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalCaroco4(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 98) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalFibrilha1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalFibrilha1(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalFibrilha2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalFibrilha2(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalFibrilha3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalFibrilha3(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalFibrilha4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoProdutividadeTotalFibrilha4(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 107) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoPluma1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoPluma1(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoPluma2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoPluma2(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoPluma3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoPluma3(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoPluma4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoPluma4(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 108) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoCaroco1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoCaroco1(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoCaroco2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoCaroco2(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoCaroco3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoCaroco3(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoCaroco4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoCaroco4(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 109) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoFibrilha1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoFibrilha1(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoFibrilha2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoFibrilha2(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoFibrilha3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoFibrilha3(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoFibrilha4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoMedioRealizadoProjetadoFibrilha4(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 110) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPorcentagemVolumeFixadoPluma1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPorcentagemVolumeFixadoPluma1(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPorcentagemVolumeFixadoPluma2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPorcentagemVolumeFixadoPluma2(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPorcentagemVolumeFixadoPluma3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPorcentagemVolumeFixadoPluma3(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPorcentagemVolumeFixadoPluma4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPorcentagemVolumeFixadoPluma4(cell
												.getNumericCellValue());
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 111) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoFixadoPluma1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoFixadoPluma1(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoFixadoPluma2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoFixadoPluma2(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoFixadoPluma3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoFixadoPluma3(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoPrecoFixadoPluma4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoPrecoFixadoPluma4(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 112) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoCustoProducaoRealizadoProjetado1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoCustoProducaoRealizadoProjetado1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoCustoProducaoRealizadoProjetado2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoCustoProducaoRealizadoProjetado2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoCustoProducaoRealizadoProjetado3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoCustoProducaoRealizadoProjetado3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setAlgodaoCustoProducaoRealizadoProjetado4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setAlgodaoCustoProducaoRealizadoProjetado4(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
					}
				}

			} // fim da leitura das linhas da planilha

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
		return setorAgronegocio;
	}

	public SetorAgronegocioVO lerSetorAgronegocioUsinasAcucarAlcool(File arquivo) {

		SetorAgronegocioVO setorAgronegocio = new SetorAgronegocioVO();

		try {
			FileInputStream fis = new FileInputStream(arquivo);

			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

			XSSFSheet mySheet = myWorkBook.getSheetAt(1);

			Iterator<Row> rowIterator = mySheet.iterator();

			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();

				if (row.getRowNum() == 4) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio.setNomeDaUsina(cell
										.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setNomeDaUsina(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 6) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux1 = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado1 = aux1.split(";");
								setorAgronegocio
										.setUsinaAnoSafra1(textoSeparado1[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setUsinaAnoSafra1(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux1 = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado1 = aux1.split(";");
								setorAgronegocio
										.setUsinaAnoSafra2(textoSeparado1[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setUsinaAnoSafra2(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux1 = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado1 = aux1.split(";");
								setorAgronegocio
										.setUsinaAnoSafra3(textoSeparado1[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setUsinaAnoSafra3(cell
										.getNumericCellValue() + "");
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								String aux1 = cell.getStringCellValue()
										.replace("(", ";").replace(")", ";");
								String[] textoSeparado1 = aux1.split(";");
								setorAgronegocio
										.setUsinaAnoSafra4(textoSeparado1[1]);
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setUsinaAnoSafra4(cell
										.getNumericCellValue() + "");
								break;
							}
						}
					}
				}

				if (row.getRowNum() == 7) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCapacidadeMoagem1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCapacidadeMoagem1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCapacidadeMoagem2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCapacidadeMoagem2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCapacidadeMoagem3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCapacidadeMoagem3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCapacidadeMoagem4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCapacidadeMoagem4(new BigDecimal(
												cell.getNumericCellValue()));
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
								setorAgronegocio
										.setCanaPropriaAreaPropria1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCanaPropriaAreaPropria1(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCanaPropriaAreaPropria2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCanaPropriaAreaPropria2(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCanaPropriaAreaPropria3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCanaPropriaAreaPropria3(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCanaPropriaAreaPropria4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCanaPropriaAreaPropria4(cell
												.getNumericCellValue());
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
								setorAgronegocio
										.setCanaPropriaAreaArreandada1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCanaPropriaAreaArreandada1(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCanaPropriaAreaArreandada2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCanaPropriaAreaArreandada2(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCanaPropriaAreaArreandada3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCanaPropriaAreaArreandada3(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCanaPropriaAreaArreandada4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setCanaPropriaAreaArreandada4(cell
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
								setorAgronegocio
										.setCanaTerceiros1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCanaTerceiros1(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCanaTerceiros2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCanaTerceiros2(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCanaTerceiros3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCanaTerceiros3(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setCanaTerceiros4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setCanaTerceiros4(cell
										.getNumericCellValue());
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
								setorAgronegocio
										.setTerraAreaPropria1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaPropria1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setTerraAreaPropria2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaPropria2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setTerraAreaPropria3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaPropria3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setTerraAreaPropria4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaPropria4(new BigDecimal(
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
								setorAgronegocio
										.setTerraAreaArreandada1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaArreandada1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setTerraAreaArreandada2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaArreandada2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setTerraAreaArreandada3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaArreandada3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setTerraAreaArreandada4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaArreandada4(new BigDecimal(
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
								setorAgronegocio
										.setTerraAreaRenovacao1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaRenovacao1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setTerraAreaRenovacao2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaRenovacao2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setTerraAreaRenovacao3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaRenovacao3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setTerraAreaRenovacao4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaRenovacao4(new BigDecimal(
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
								setorAgronegocio
										.setTerraAreaExpansao1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaExpansao1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setTerraAreaExpansao2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaExpansao2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setTerraAreaExpansao3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaExpansao3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setTerraAreaExpansao4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTerraAreaExpansao4(new BigDecimal(
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
								setorAgronegocio
										.setIdadeMediaCanavial1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setIdadeMediaCanavial1(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setIdadeMediaCanavial2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setIdadeMediaCanavial2(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setIdadeMediaCanavial3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setIdadeMediaCanavial3(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setIdadeMediaCanavial4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setIdadeMediaCanavial4(cell
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
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setPorcentagemColheitaMecanizada1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setPorcentagemColheitaMecanizada1(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setPorcentagemColheitaMecanizada2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setPorcentagemColheitaMecanizada2(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setPorcentagemColheitaMecanizada3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setPorcentagemColheitaMecanizada3(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setPorcentagemColheitaMecanizada4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setPorcentagemColheitaMecanizada4(cell
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
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setRaioMedioCanavial1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setRaioMedioCanavial1(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setRaioMedioCanavial2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setRaioMedioCanavial2(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setRaioMedioCanavial3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setRaioMedioCanavial3(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setRaioMedioCanavial4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setRaioMedioCanavial4(new BigDecimal(
												cell.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
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
								setorAgronegocio
										.setProducaAcucarCristal1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaAcucarCristal1(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaAcucarCristal2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaAcucarCristal2(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaAcucarCristal3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaAcucarCristal3(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaAcucarCristal4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaAcucarCristal4(cell
										.getNumericCellValue());
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
								setorAgronegocio
										.setProducaAcucarVHP1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaAcucarVHP1(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaAcucarVHP2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaAcucarVHP2(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaAcucarVHP3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaAcucarVHP3(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaAcucarVHP4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaAcucarVHP4(cell
										.getNumericCellValue());
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
								setorAgronegocio
										.setProducaAcucarOrganico1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaAcucarOrganico1(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaAcucarOrganico2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaAcucarOrganico2(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaAcucarOrganico3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaAcucarOrganico3(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaAcucarOrganico4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaAcucarOrganico4(cell
										.getNumericCellValue());
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
								setorAgronegocio
										.setProducaoEtanolAnidro1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaoEtanolAnidro1(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaoEtanolAnidro2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaoEtanolAnidro2(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaoEtanolAnidro3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaoEtanolAnidro3(cell
										.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaoEtanolAnidro4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio.setProducaoEtanolAnidro4(cell
										.getNumericCellValue());
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
								setorAgronegocio
										.setProducaoEtanolHidratado1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setProducaoEtanolHidratado1(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaoEtanolHidratado2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setProducaoEtanolHidratado2(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaoEtanolHidratado3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setProducaoEtanolHidratado3(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaoEtanolHidratado4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setProducaoEtanolHidratado4(cell
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
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaoEtanolOrganico1(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setProducaoEtanolOrganico1(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaoEtanolOrganico2(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setProducaoEtanolOrganico2(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaoEtanolOrganico3(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setProducaoEtanolOrganico3(cell
												.getNumericCellValue());
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaoEtanolOrganico4(Double
												.parseDouble(cell
														.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setProducaoEtanolOrganico4(cell
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
						if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaoIndustrial1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setProducaoIndustrial1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaoIndustrial2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setProducaoIndustrial2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaoIndustrial3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setProducaoIndustrial3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setProducaoIndustrial4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setProducaoIndustrial4(new BigDecimal(
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
								setorAgronegocio
										.setPotenciaInstalada1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setPotenciaInstalada1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setPotenciaInstalada2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setPotenciaInstalada2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setPotenciaInstalada3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setPotenciaInstalada3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setPotenciaInstalada4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setPotenciaInstalada4(new BigDecimal(
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
								setorAgronegocio
										.setTotalEnergiaVendida1(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTotalEnergiaVendida1(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setTotalEnergiaVendida2(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTotalEnergiaVendida2(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setTotalEnergiaVendida3(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTotalEnergiaVendida3(new BigDecimal(
												cell.getNumericCellValue()));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setTotalEnergiaVendida4(new BigDecimal(
												cell.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setTotalEnergiaVendida4(new BigDecimal(
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
								setorAgronegocio
										.setFaturamento1(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setFaturamento1(new BigDecimal(cell
												.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 2) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setFaturamento2(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setFaturamento2(new BigDecimal(cell
												.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 3) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setFaturamento3(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setFaturamento3(new BigDecimal(cell
												.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
						if (cell.getColumnIndex() == 4) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								setorAgronegocio
										.setFaturamento4(new BigDecimal(cell
												.getStringCellValue()));
								break;
							case Cell.CELL_TYPE_NUMERIC:
								setorAgronegocio
										.setFaturamento4(new BigDecimal(cell
												.getNumericCellValue())
												.setScale(2,
														RoundingMode.HALF_EVEN));
								break;
							}
						}
					}
				}
			} // fim da leitura das linhas da planilha

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			BradescoFacesUtils
					.addErrorModalMessage("Falha no processamento da planilha.");
		} catch (IOException e) {
			e.printStackTrace();
			BradescoFacesUtils
					.addErrorModalMessage("Falha no processamento da planilha.");
		}
		return setorAgronegocio;
	}

}