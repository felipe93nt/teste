/**
 * Nome: sicc.global.dao.xml
 * 
 * Compilador: JDK 1.5
 * 
 * Propósito: Classes de uso do Bradesco que contém informações a respeito de Cambio.
 * 
 * Data da Criação: 12/02/2015
 * 
 * Parâmetros de Compilação: -d
 * 
 */
package br.com.bradesco.web.npcc_trade.utils.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Nome: LeitorXML.java Carrega um XML e fornece os métodos necessários para percorre-lo como uma lista. Propósito:
 * 
 * @author : francinaldo Equipe: BRQ - Câmbio
 * @version:
 * 
 *           Parametro de compilação -d
 * 
 *           Registro de Manutenção: 25/02/2015 - Autor: francinaldo - Responsavel: francinaldo - Motivo:
 */
public class LeitorXML {
    private int indice;
    private int len;
    private List<Node> lista;
    private Map<String, String> valores;

    /**
     * @param stringXML
     * @param nomeNodo
     */
    public LeitorXML(String stringXML, String nomeNodo) {
        ByteArrayInputStream bais = new ByteArrayInputStream(stringXML.getBytes());
        lerXml(bais, nomeNodo);
    }

    protected LeitorXML() {
        super();
    }

    protected void lerXml(InputStream is, String nomeNodo) {
        DocumentBuilder db;
        try {
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document d = db.parse(is);
            lista = converteLista(d.getElementsByTagName(nomeNodo));
            len = lista.size();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Erro ao ler o XML ", e);
        } catch (SAXException e) {
            throw new RuntimeException("Erro ao ler o XML ", e);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o XML ", e);
        }
        if (len > 0)
            lerValores();
    }

    private LeitorXML(Node nodo) {
        lista = converteLista(nodo.getChildNodes());
        len = lista.size();
        indice = 0;
        lerValores();
    }

    private List<Node> converteLista(NodeList nList) {
        List<Node> lista = new ArrayList<Node>();
        Node n;
        for (int i = 0; i < nList.getLength(); i++) {
            n = nList.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                lista.add(n);
            }
        }
        return lista;
    }

    /**
     * Retorna o número de elementos do tipo informado.
     * 
     * @return
     */
    public int getLength() {
        return len;
    }

    /**
     * Informa quando já leu todos os elementos do XML.
     * 
     * @return
     */
    public boolean eof() {
        return indice == len;
    }

    /**
     * Retorna o valor (seja atributo ou elemento filho) referente ao nodo atual.
     * 
     * @param nomeAtributo
     * @return
     */
    public String getValorString(String nomeAtributo) {
        return valores.get(nomeAtributo.toLowerCase());
    }

    /**
     * Retorna o valor (seja atributo ou elemento filho) referente ao nodo atual.
     * 
     * @param nomeAtributo
     * @return
     */
    public int getValorInt(String nomeAtributo) {
        return Integer.parseInt(getValorString(nomeAtributo));
    }

    /**
     * Retorna o valor (seja atributo ou elemento filho) referente ao nodo atual.
     * 
     * @param nomeAtributo
     * @return
     */
    public double getValorDouble(String nomeAtributo) {
        return Double.parseDouble(getValorString(nomeAtributo));
    }

    /**
     * Nome: next
     * 
     * Propósito: Avanca para o proximo nodo
     * 
     * @return
     * 
     *         Registro de Manutenção: 25/02/2015 - Autor: francinaldo - Responsavel: BRQ - Cambio - Descrição:
     */
    public boolean next() {
        indice++;
        if (!eof())
            lerValores();
        return !eof();
    }

    private void lerValores() {
        Node nodo = lista.get(indice);
        lerValores(nodo);
    }

    private void lerValores(Node nodo) {
        valores = new HashMap<String, String>();
        Node n;
        NamedNodeMap atributos = nodo.getAttributes();
        for (int i = 0; i < atributos.getLength(); i++) {
            n = atributos.item(i);
            valores.put(n.getNodeName().toLowerCase(), n.getNodeValue());
        }
        NodeList filhos = nodo.getChildNodes();
        for (int i = 0; i < filhos.getLength(); i++) {
            n = filhos.item(i);
            if (n.getChildNodes().getLength() > 0) {
                valores.put(n.getNodeName().toLowerCase(), n.getChildNodes().item(0).getNodeValue());
            }
        }
    }

    /**
     * Nome: subAtributos
     * 
     * Propósito: Retorna um LeitorXML cujos campos são os filhos do campo informado.
     * 
     * @param atributo
     * @return
     * 
     *         Registro de Manutenção: 25/02/2015 - Autor: francinaldo - Responsavel: BRQ - Cambio - Descrição:
     */
    public LeitorXML subAtributos(String atributo) {
        Node n;
        Node nodo = lista.get(indice);
        NodeList filhos = nodo.getChildNodes();
        for (int i = 0; i < filhos.getLength(); i++) {
            n = filhos.item(i);
            if (n.getNodeName().equalsIgnoreCase(atributo)) {
                return new LeitorXML(n);
            }
        }
        return null;
    }

    /**
     * Nome: buscar
     * 
     * Propósito: Busca e posiciona no nodo em que o campo informado em "chave" corresponda a "valor"
     * 
     * @param chave
     * @param valor
     * @return
     * 
     *         Registro de Manutenção: 25/02/2015 - Autor: francinaldo - Responsavel: BRQ - Cambio - Descrição:
     */
    public boolean buscar(String chave, String valor) {
        start();
        while (!eof()) {
            if (getValorString(chave).equalsIgnoreCase(valor)) {
                return true;
            }
            next();
        }
        return false;
    }

    /**
     * Nome: buscar
     * 
     * Propósito: Busca e posiciona no nodo em que o campo informado em "chave" corresponda a "valor"
     * 
     * @param chave
     * @param valor
     * @return
     * 
     *         Registro de Manutenção: 25/02/2015 - Autor: francinaldo - Responsavel: BRQ - Cambio - Descrição:
     */
    public boolean buscar(String chave, int valor) {
        start();
        while (!eof()) {
            if (getValorInt(chave) == valor) {
                return true;
            }
            next();
        }
        return false;
    }

    /**
     * Nome: start
     * 
     * Propósito: Retorna para o primeiro nodo do xml.
     * 
     * Registro de Manutenção: 25/02/2015 - Autor: francinaldo - Responsavel: BRQ - Cambio - Descrição:
     */
    public void start() {
        indice = 0;
        if (!eof()) {
            lerValores();
        }
    }

    /**
     * Nome: getValorBoolean
     * 
     * Propósito: Retorna o valor
     * 
     * @param nomeAtributo
     * @return
     * 
     *         Registro de Manutenção: 25/02/2015 - Autor: francinaldo - Responsavel: BRQ - Cambio - Descrição:
     */
    public boolean getValorBoolean(String nomeAtributo) {
        return getValorString(nomeAtributo).trim().toLowerCase().equals("true");
    }
}
