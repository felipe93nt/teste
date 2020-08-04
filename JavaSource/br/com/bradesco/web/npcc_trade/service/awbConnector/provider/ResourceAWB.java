/**
 * Nome: br.com.bradesco.web.npcc_trade.service.awbConnector.provider
 * 
 * Prop�sito: Classes de uso comum para a funcionalidade 
 * 
 * Data da Cria��o: 17/02/2011
 * 
 * Compilador: 1.5.0_11
 * Par�metros de Compila��o: -d 
 * 
 */
package br.com.bradesco.web.npcc_trade.service.awbConnector.provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.bradesco.data.TransactionParser;
import br.com.bradesco.data.book.Transaction;
import br.com.bradesco.data.connector.XMLTransactionRepository;
import br.com.bradesco.data.connector.exception.ConnectorException;
import br.com.bradesco.data.connector.exception.ConnectorTechnicalException;
import br.com.bradesco.data.exception.CopybookException;

/**
 * Nome: ResourceAWB
 * Prop�sito:  Classe que executa leitura de XML
 * Equipe: AWB Conectores
 * Parametro de compila��o: -d.
 *
 * @author william.santos CPM Braxis Copyright (c) 2011
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 * <p>Registro de Manuten��o:
 * <li>Data : </li>
 * <li>Autor: </li>
 * <li>Respons�vel: </li>
 * </p>
 */

@ApplicationScoped
@Named("resourceAWB")
public class ResourceAWB implements XMLTransactionRepository {
	
	/** Atributo instance. */
	protected static ResourceAWB instance = null;
	
	/** Atributo transactions. */
	protected Map<String, Transaction> transactions;
	
	/** Atributo context. */
	protected ClassLoader context = null;
	
	/**
	 * Obt�m um inst�ncia �nica atrav�s do m�todo ResourceAWB.
	 *
	 * @return Retorna a instancia atrav�s do m�todo ResourceAWB
	 */
	public static ResourceAWB getInstance() {
		if (instance == null) {
			instance = new ResourceAWB();
		}
		return instance;
	}
	
	/**
	 * Construtor Padr�o
	 * Instancia um novo objeto ResourceAWB.
	 */
	protected ResourceAWB() {
		this.context = this.getClass().getClassLoader();
		transactions = new HashMap<String, Transaction>();
	}
	
	/**
	 * Nome: getTransactionType
	 * Recupera o valor do atributo 'transactionType'.
	 *
	 * @param name the name
	 * @return valor do atributo 'transactionType'
	 * @throws ConnectorException the connector exception
	 * @see
	 */
	public String getTransactionType(String name) throws ConnectorException {
		Transaction tx = transactions.get(name);
		if (tx == null) {
			tx = this.getTransaction(name);
		}
		return tx.getType();
	}
	
	/**
     * Nome: getTransactionName
     * Recupera o valor do atributo 'transactionName'. Nome do fluxo mainframe executado na transa��o
     *
     * @param name the name
     * @return valor do atributo 'transactionName'
     * @throws ConnectorException the connector exception
     * @see
     */
    public String getTransactionName(String name) throws ConnectorException {
        Transaction tx = transactions.get(name);
        if (tx == null) {
            tx = this.getTransaction(name);
        }
        return tx.getName();
    }
	
	/**
	 * Nome: getTransaction
	 * Recupera o valor do atributo 'transaction'.
	 *
	 * @param name the name
	 * @return valor do atributo 'transaction'
	 * @throws ConnectorException the connector exception
	 * @see
	 */
	public Transaction getTransaction(String name) throws ConnectorException {
		Transaction tx = transactions.get(name);
		if (tx == null) {
			String xml = readXMLTransaction(name);
			try {
				tx = TransactionParser.generateTransaction(xml);
			} catch (CopybookException e) {
				throw new ConnectorTechnicalException("Erro ler transacao", e);
			}
			transactions.put(name, tx);
		}
		return tx;
	}
	
	/**
	 * Nome: readXMLTransaction
	 * Read xml transaction.
	 *
	 * @param fileName the file name
	 * @return string
	 * @see
	 */
	private String readXMLTransaction(String fileName) {
		String cobol = null;
		String file = "resources/transactions/" + fileName + ".xml";
		
		InputStream is = context.getResourceAsStream(file);
		if (is != null) {
		
			Writer writer = new StringWriter();
			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} catch (UnsupportedEncodingException e) {
		
			} catch (IOException e) {
		
			} finally {
				try {
					is.close();
				} catch (IOException e) {
		
				}
			}
			cobol = writer.toString();
		}
		return cobol;
	}
	
	/**
	 * Nome: getClassByName
	 * Recupera o valor do atributo 'classByName'.
	 *
	 * @param classname the classname
	 * @return valor do atributo 'classByName'
	 * @throws ConnectorException the connector exception
	 * @see
	 */
	public Object getClassByName(String classname) throws ConnectorException {
		Object classe;
		try {
			classe = Class.forName(classname).newInstance();
		} catch (Exception e) {
			throw new ConnectorTechnicalException("Falha criando classe: " + classname, e);
		}
		return classe;
	}

	public String getTransactionFrameWork(String name)
			throws ConnectorException {
		return null;
	}
}
