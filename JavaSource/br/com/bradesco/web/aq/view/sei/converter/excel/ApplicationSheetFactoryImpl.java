package br.com.bradesco.web.aq.view.sei.converter.excel;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.ObjectCreationFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.xml.sax.Attributes;

/**
  * Nome: ApplicationSheetFactoryImpl.java
  * 
  * Propósito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 09/03/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public class ApplicationSheetFactoryImpl implements ObjectCreationFactory {

	private Digester digester = null;

	/**
	 * Construtor
	 * 
	 * @param 
	 */
	public ApplicationSheetFactoryImpl() {
		super();
	}

	public Object createObject(Attributes attributes) throws Exception {
		Workbook workbook = (Workbook) this.digester.getRoot();

		Sheet sheet = null;
		sheet = workbook.createSheet();

		CreationHelper helper = workbook.getCreationHelper();

		ClientAnchor anchor = helper.createClientAnchor();
		anchor.setCol1(0);
		anchor.setCol2(2);
		anchor.setRow1(0);
		anchor.setRow2(5);

		Row row = sheet.createRow(1);
		CellStyle boldStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		boldStyle.setFont(font);
		Cell cell = row.createCell(0);
		cell.setCellStyle(boldStyle);

		cell.setCellValue("Nova Plataforma de Câmbio");
		sheet.createRow(3);

		return sheet;
	}

	public Digester getDigester() {
		return this.digester;
	}

	public void setDigester(Digester digester) {
		this.digester = digester;
	}
}