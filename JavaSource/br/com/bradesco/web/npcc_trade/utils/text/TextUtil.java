/**
 * Nome: br.com.bradesco.web.cmnc.utils
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * Data da Criação: 29/07/2015
 *
 * @see : Referencias externas.
 *
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.6
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.utils.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.bradesco.web.aq.application.property.config.IConfigPropertyManager;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.utils.text.formats.ITextFormat;

public class TextUtil {
	
	public static File convertDelimitedToFixedPosition(InputStream inputStream, ITextFormat format, char delimiter) {
		IConfigPropertyManager propertyManager = BradescoCommonServiceFactory.getPropertieManager();
		String server = propertyManager.getProperty("xfb.server");
		String name = propertyManager.getProperty("xfb.ncm.fileName");
		String encoding = propertyManager.getProperty("xfb.encoding");
		String fullName = server.concat("\\").concat(name);
		
		File outputFile = new File(fullName);
		Charset charset = Charset.forName(encoding);
		
		try {
			InputStreamReader stream = new InputStreamReader(inputStream, charset);
			StringBuffer buffer = new StringBuffer();
			
			if (stream.ready()) {
				String line;
				BufferedReader reader = new BufferedReader(stream);
				Map<Integer, TextAttribute> layout = format.getLayout();
				
				if (format.hasHeader())
					reader.readLine();

				while ((line = reader.readLine()) != null) {
					String[] columns = split(line, delimiter);
					
					for (int i = 0; i < columns.length; i++) {
						if (layout.containsKey(i)) {
							buffer.append(formatField(columns[i], layout.get(i)));
						}
					}
					
					buffer.append("\r\n");
				}

				reader.close();
				inputStream.close();
			}
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(outputFile), charset);
			writer.write(buffer.toString());
			writer.close();
			
		} catch (IOException e) {
			return null;
		}
		
		return outputFile;
	}
	
	private static String formatField(String field, TextAttribute textAttribute) {
		String formattedField;
		
		if (field == null)
			field = "";
		
		if (field.length() > textAttribute.getSize())
			field = field.substring(0, textAttribute.getSize());
		
		if (textAttribute.isNumericField())
			formattedField = padLeft(field, textAttribute.getSize(), textAttribute.getDefaultValue());
		else
			formattedField = padRight(field, textAttribute.getSize(), textAttribute.getDefaultValue());
		
		return formattedField;
	}
	
	public static String padLeft(String text, int numberOfCharacters, String character) {
		StringBuffer buffer = new StringBuffer(text == null ? "" : text);
		
		if (buffer.length() < numberOfCharacters) {
			for (int i = buffer.length(); i < numberOfCharacters; i++) {
				buffer.insert(0, character);
			}
		}
		
		return buffer.toString();
	}
	
	private static String padRight(String text, int numberOfCharacters, String character) {
		StringBuffer buffer = new StringBuffer(text == null ? "" : text);
		
		if (buffer.length() < numberOfCharacters) {
			for (int i = buffer.length(); i < numberOfCharacters; i++) {
				buffer.append(character);				
			}
		}
		
		return buffer.toString();
	}
	
	private static String[] split(String line, char delimiter) {
		
		if (!line.contains("\""))
			return line.split(String.valueOf(delimiter));

		boolean openQuote = false;
		boolean closeQuote = false;
		StringBuffer buffer = new StringBuffer();
		List<String> columns = new ArrayList<String>();	

		for (char character : line.toCharArray()) {
			buffer.append(character);
			
			if (!openQuote && character == '\"') {
				openQuote = true;
			} else if (openQuote && !closeQuote && character == '\"') {
				closeQuote = true;
			}
			
			if (character == delimiter && (openQuote == closeQuote)) {
				openQuote = false;
				closeQuote = false;
				
				columns.add(buffer.substring(0, buffer.length() - 1));
				
				buffer = new StringBuffer();
			}
		}
		
		if (buffer.length() > 0)
			columns.add(buffer.toString());
				
		String[] array = new String[columns.size()];
		
		for (int i = 0; i < columns.size(); i++) {
			array[i] = columns.get(i);
		}
		
		//return (String[])columns.toArray();
		return array;
	}
}
