package br.com.bradesco.web.npcc_trade.utils.converter;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.bradesco.web.aq.view.components.html.uioutputlabel.UIOutputLabelBradesco;
import br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.SpreadNegocCalc.Npccwxxerequest_lista;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboClausulaVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tipoClausula.bean.TipoClausulaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSituacaoAtivoInativo;
import br.com.bradesco.web.npcc_trade.view.bean.MoedaDetalheVO;

/**
  * <b>Nome:</b> <p> CadastroNacionalPessoa.java </p>
  * 
  * <b>Propósito:</b> <p> Conversão de números e valores em texto contendo os números por extenso.</p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR/>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  *
  * Registro  de Manutenção: 15/09/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
@FacesConverter(value = "extensoConverter")
public class ExtensoConverter implements Cloneable, Converter {

	// Identificação do genero (Masculino ou Feminino) a ser considerado.
	private static String generoExtenso = EnumGeneroMasculinoFeminino.MASCULINO.getDescricao();

	// Definições de extenso para os números
    private static String[] unidadeExtenso = {SiteUtil.STRING_EMPTY, "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
    private static String[] dezenaExtenso = {SiteUtil.STRING_EMPTY, SiteUtil.STRING_EMPTY, "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};
    private static String[] centenaExtenso = {SiteUtil.STRING_EMPTY, "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};
    private static String[] qualificaSingular = {"", " mil", " milhão", " bilhão", " trilhão"};
    private static String[] qualificaPlural = {"", " mil", " milhões", " bilhões", " trilhões"};
    
    // Qualificação de junção e excessão de extenso.
    private static final String STRING_EXTENSO_ZERO = "zero";
    private static final String STRING_EXTENSO_CEM = "cem ";
    private static final String STRNG_SEPARADOR_E = " e ";
    
    // Detalhamento das informações de Moeda
    private static List<MoedaDetalheVO> listaMoedaDetalhe = new ArrayList<MoedaDetalheVO>();
    private static MoedaDetalheVO detalheMoeda = new MoedaDetalheVO(); 
    
    
    /**
     * Construtor
     * 
     *@param .
     */
    public ExtensoConverter() {
    	// Aciona a carga dos detalhes das moedas na lista.
    	this.carregarDetalhesMoeda();
	    carregarDetalhesMoeda();
    }

    
    /**
     * Nome: carregarDetalhesMoeda
     * 
     * Propósito: Controla e adiciona o objeto de detalhes da moeda à lista de moedas.
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     *
     * Registro  de Manutenção: 16/09/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    private static void carregarDetalhesMoeda() {

    	if (listaMoedaDetalhe.size() == 0) {
    		//adicionaNovaMoeda(Numeros.ZERO, "",    "CUC", SiteUtil.STRING_EMPTY, "Peso", "Pesos", "centavo", "centavos",    SiteUtil.STRING_EMPTY); //COLON/COSTA RICA               COSTA RICA                           
    		//adicionaNovaMoeda(Numeros.ZERO, "",    "GGP", SiteUtil.STRING_EMPTY, "Libra", "Libras", "dinheiro", "dinheiros",    SiteUtil.STRING_EMPTY); //LARI GEORGIA                   GEORGIA, REPUBLICA DA                
    		//adicionaNovaMoeda(Numeros.ZERO, "",    "IMP", SiteUtil.STRING_EMPTY, "Libra", "Libras", "dinheiro", "dinheiros",    SiteUtil.STRING_EMPTY); //LIBRA ISRAELENSE               -                                    
    		//adicionaNovaMoeda(Numeros.ZERO, "",    "JEP", SiteUtil.STRING_EMPTY, "Libra", "Libras", "dinheiro", "dinheiros",    SiteUtil.STRING_EMPTY); //LIRA ITALIANA                  ITALIA                               
    		//adicionaNovaMoeda(Numeros.ZERO, "",    "PNB", SiteUtil.STRING_EMPTY, "Rublo", "Rublos", "copeque", "copeques",    SiteUtil.STRING_EMPTY); //ZLOTY/POLONIA                  POLONIA, REPUBLICA DA                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "005", "AFN", SiteUtil.STRING_EMPTY, "Afegane", "Afeganes", "pul", "puls",    SiteUtil.STRING_EMPTY)); //AFEGANE AFEGANIST              AFEGANISTAO                          
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "008", "ETB", SiteUtil.STRING_EMPTY, "Birr", "Birr", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //BIRR                           -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "009", "ETB", SiteUtil.STRING_EMPTY, "Birr", "Birr", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //BIRR/ETIOPIA                   ETIOPIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "010", "ARG", SiteUtil.STRING_EMPTY, "Austral", "Austral", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //AUSTRAL                        ARGENTINA                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "015", "THB", SiteUtil.STRING_EMPTY, "Bath", "Baths", "satang", "satangs",    SiteUtil.STRING_EMPTY)); //BATH/TAILANDIA                 TAILANDIA                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "020", "PAB", SiteUtil.STRING_EMPTY, "Balboa", "Balboas", "centésimo", "centésimos",    SiteUtil.STRING_EMPTY)); //BALBOA/PANAMA                  PANAMA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "025", "VEB", SiteUtil.STRING_EMPTY, "Bolivar", "Bolivares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //BOLIVAR/VENZUELA               VENEZUELA                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "026", "VEF", SiteUtil.STRING_EMPTY, "Bólivar", "Bólivars", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //BOLIVAR VEN                    VENEZUELA                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "030", "BOB", SiteUtil.STRING_EMPTY, "Boliviano", "Bolivianos", "centavo", "centavo",    SiteUtil.STRING_EMPTY)); //BOLIVIANO/BOLIVIA              BOLIVIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "035", "GHS", SiteUtil.STRING_EMPTY, "Cedi", "Cedis", "pesewa", "pesewas",    SiteUtil.STRING_EMPTY)); //CEDI GANA                      GANA                                 
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "035", "GHC", SiteUtil.STRING_EMPTY, "Cedi", "Cedis", "pesewa", "pesewas",    SiteUtil.STRING_EMPTY)); //CEDI GANA                      GANA                                 
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "040", "CRC", SiteUtil.STRING_EMPTY, "Colón", "Colóns", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //COLON/COSTA RICA               COSTA RICA                           
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "045", "SVC", SiteUtil.STRING_EMPTY, "Colón", "Colóns",   "cent", "cents",    SiteUtil.STRING_EMPTY)); //COLON/EL SALVADOR              EL SALVADOR                          
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "050", "NIC", SiteUtil.STRING_EMPTY, "Cordoba",  "Cordobas", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //CORDOBA/NICARAGUA              -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "051", "NIO", SiteUtil.STRING_EMPTY, "Cordoba Ouro",  "Cordobas Ouro", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //CORDOBA OURO NICARAGUA                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "055", "DKK", SiteUtil.STRING_EMPTY, "Coroa", "Coroas", "øre", "øres",    SiteUtil.STRING_EMPTY)); //COROA DINAMARQUESA             DINAMARCA                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "057", "EEK", SiteUtil.STRING_EMPTY, "Coroa", "Coroas",   "halé", "halés",    SiteUtil.STRING_EMPTY)); //COROA ESTONIA                  ESTONIA, REPUBLICA DA                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "058", "SKK", SiteUtil.STRING_EMPTY, "Coroa", "Coroas",   "halé", "halés",    SiteUtil.STRING_EMPTY)); //COROA ESLOVACA                 ESLOVACA, REPUBLICA                  
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "060", "ISK", SiteUtil.STRING_EMPTY, "Coroa", "Coroas", "eyrir", "eyrirs",    SiteUtil.STRING_EMPTY)); //COROA ISLND/ISLAN              ISLANDIA                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "065", "NOK", SiteUtil.STRING_EMPTY, "Coroa", "Coroas", "øre", "øres",    SiteUtil.STRING_EMPTY)); //COROA NORUEGUESA               NORUEGA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "070", "SEK", SiteUtil.STRING_EMPTY, "Coroa", "Coroas", "öre", "öres",    SiteUtil.STRING_EMPTY)); //COROA SUECA                    SUECIA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "075", "CZK", SiteUtil.STRING_EMPTY, "Coroa", "Coroas", "halé", "halés",    SiteUtil.STRING_EMPTY)); //COROA TCHECA                   TCHECA, REPUBLICA                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "078", "NCZ", SiteUtil.STRING_EMPTY, "Cruzado Novo", "Cruzados Novos", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //CRUZADO NOVO                   BRASIL                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "079", "CZ",  SiteUtil.STRING_EMPTY, "Cruzado", "Cruzados", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //CRUZADO                        BRASIL                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "080", "CR",  SiteUtil.STRING_EMPTY, "Cruzeiro", "Cruzeiros", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //CRUZEIRO                       BRASIL                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "083", "CR",  SiteUtil.STRING_EMPTY, "Cruzeiro", "Cruzeiros", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //CRUZEIRO                       BRASIL                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "085", "CR",  SiteUtil.STRING_EMPTY, "Cruzeiro Real", "Cruzeiros Real", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //CRUZEIRO REAL                  BRASIL                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "088", "RUR", SiteUtil.STRING_EMPTY, "Cupon", "Cupons", "fração", "frações",    SiteUtil.STRING_EMPTY)); //CUPON GEORGIANO                -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "090", "GMD", SiteUtil.STRING_EMPTY, "Dalasi","Dalasi", "butut", "bututs",    SiteUtil.STRING_EMPTY)); //DALASI/GAMBIA                  GAMBIA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "095", "DZD", SiteUtil.STRING_EMPTY, "Dinar", "Dinares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DINAR ARGELINO                 ARGELIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "100", "KWD", SiteUtil.STRING_EMPTY, "Dinar", "Dinares", "fils", "fils",    SiteUtil.STRING_EMPTY)); //DINAR/KWAIT                    COVEITE                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "105", "BHD", SiteUtil.STRING_EMPTY, "Dinar", "Dinares", "fils", "fils",    SiteUtil.STRING_EMPTY)); //DINAR/BAHREIN                  BAHREIN, ILHAS                       
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "110", "YD",  SiteUtil.STRING_EMPTY, "Dinar", "Dinares", "fils", "fils",    SiteUtil.STRING_EMPTY)); //DINAR IEMENITA                 -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "115", "IQD", SiteUtil.STRING_EMPTY, "Dinar", "Dinares", "fils", "fils",    SiteUtil.STRING_EMPTY)); //DINAR/IRAQUE                   IRAQUE                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "120", "DIN", SiteUtil.STRING_EMPTY, "Dinar", "Dinares", "fils", "fils",    SiteUtil.STRING_EMPTY)); //DINAR IUGOSLAVO                SERVIA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "125", "JOD", SiteUtil.STRING_EMPTY, "Dinar", "Dinares", "piastra", "piastras",    SiteUtil.STRING_EMPTY)); //DINAR/JORDANIA                 JORDANIA                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "130", "LYD", SiteUtil.STRING_EMPTY, "Dinar", "Dinares", "dirame", "dirames",    SiteUtil.STRING_EMPTY)); //DINAR/LIBIA                    LIBIA                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "132", "MKD", SiteUtil.STRING_EMPTY, "Dinar", "Dinares", "deni", "deni",    SiteUtil.STRING_EMPTY)); //DINAR/MACEDONIA                MACEDONIA, ANT.REP.IUGOSLAVA         
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "133", "RSD", SiteUtil.STRING_EMPTY, "Dinar", "Dinares", "deni", "deni",    SiteUtil.STRING_EMPTY)); //DINAR SERVIO SERVIA            SERVIA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "134", "SDG", SiteUtil.STRING_EMPTY, "Libra", "Libras", "piastra", "piastras",    SiteUtil.STRING_EMPTY)); //NOVA LIBRA SUDANESA            SUDAO                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "135", "TND", SiteUtil.STRING_EMPTY, "Dinar", "Dinares", "milésimo", "milésimos",    SiteUtil.STRING_EMPTY)); //DINAR/TUNISIA                  TUNISIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "136", "SSP", SiteUtil.STRING_EMPTY, "Libra", "Libras", "piastra", "piastras",    SiteUtil.STRING_EMPTY)); //LIBRA SUL SUDANESA             SUDAO DO SUL                         
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "139", "MAD", SiteUtil.STRING_EMPTY, "Dirame", "Dirames", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DIRHAM/MARROCOS                MARROCOS                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "145", "AED", SiteUtil.STRING_EMPTY, "Dirham", "Dirhames", "fils", "fils",    SiteUtil.STRING_EMPTY)); //DIRHAM/EMIR.ARABE              EMIRADOS ARABES UNIDOS               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "148", "STD", SiteUtil.STRING_EMPTY, "Dobra", "Dobras", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOBRA S TOME PRIN              SAO TOME E PRINCIPE, ILHAS           
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "150", "AUD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR AUSTRALIANO              AUSTRALIA                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "155", "BSD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR/BAHAMAS                  BAHAMAS, ILHAS                       
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "160", "BMD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR/BERMUDAS                 BERMUDAS                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "165", "CAD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR CANADENSE                CANADA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "170", "GYD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR DA GUIANA                GUIANA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "173", "NAD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR DA NAMIBIA               NAMIBIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "175", "BBD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR/BARBADOS                 BARBADOS                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "180", "BZD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR/BELIZE                   BELIZE                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "185", "BND", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR BRUNEI                   BRUNEI                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "190", "KYD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR CAYMAN                   CAYMAN, ILHAS                        
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "195", "SGD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR CINGAPURA                CINGAPURA                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "200", "FJD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR FIJI                     FIJI                                 
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "205", "HKD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR HONG KONG                HONG KONG                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "210", "TTD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR/TRIN. TOBAG              TRINIDAD E TOBAGO                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "215", "XCD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR CARIBE ORIENTAL          -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "217", "ZWL", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR ZIMBABUE                 ZIMBABUE                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "220", "USD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR DOS EUA                  ESTADOS UNIDOS                       
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "225", "ETB", SiteUtil.STRING_EMPTY, "Birr", "Birr", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR/ETIOPIA                  -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "230", "JMD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR/JAMAICA                  JAMAICA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "235", "LRD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR LIBERIA                  LIBERIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "240", "M",   SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR MALAIO                   MALASIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "245", "NZD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR/NOVA ZELAND              NOVA ZELANDIA                        
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "250", "SBD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR IL SALOMAO               SALOMAO, ILHAS                       
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "255", "SRD", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR/SURINAME                 SURINAME                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "260", "VND", SiteUtil.STRING_EMPTY, "Dongue", "Dongues", "hào", "hàos",    SiteUtil.STRING_EMPTY)); //DONGUE/VIETNAN                 VIETNA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "270", "GRD", SiteUtil.STRING_EMPTY, "Dracma", "Dracmas", "piastra", "piastras",    SiteUtil.STRING_EMPTY)); //DRACMA/GRECIA                  GRECIA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "275", "AMD", SiteUtil.STRING_EMPTY, "Dram", "Drams", "fração", "frações",    SiteUtil.STRING_EMPTY)); //DRAM ARMENIA REP               ARMENIA, REPUBLICA DA                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "295", "CVE", SiteUtil.STRING_EMPTY, "Escudo", "Escudos", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //ESCUDO CABO VERDE              CABO VERDE, REPUBLICA DE             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "315", "PTE", SiteUtil.STRING_EMPTY, "Escudo", "Escudos", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //ESCUDO PORTUGUES               PORTUGAL                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "320", "TPE", SiteUtil.STRING_EMPTY, "Escudo", "Escudos", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //ESCUDO TIMOR LESTE             TIMOR LEST                           
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "325", "ANG", SiteUtil.STRING_EMPTY, "Florim", "Florim", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //GUILDER ANTILHAS HOLANDESAS    ANTILHAS HOLANDESAS                  
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "328", "AWG", SiteUtil.STRING_EMPTY, "Florim", "Florim", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FLORIM/ARUBA                   ARUBA                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "330", "SRG", SiteUtil.STRING_EMPTY, "Florim", "Florims", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FLORIM/SURINAME                SURINAME                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "333", "SRD", SiteUtil.STRING_EMPTY, "Dolar", "Dolar", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR/SURINAME                 SURINAME                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "335", "NLG", SiteUtil.STRING_EMPTY, "Florim", "Florims", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FLORIM HOLANDES                PAISES BAIXOS (HOLANDA)              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "345", "HUF", SiteUtil.STRING_EMPTY, "Florim", "Forints", "fillér", "fillérs",    SiteUtil.STRING_EMPTY)); //FLORIM/HUNGRIA                 HUNGRIA, REPUBLICA DA                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "360", "BEF", SiteUtil.STRING_EMPTY, "Franco", "Francos", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO BELGA/BELG              BELGICA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "361", "FBF", SiteUtil.STRING_EMPTY, "Franco", "Francos", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO BELGA FINA              -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "363", "CDF", SiteUtil.STRING_EMPTY, "Franco", "Francos", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO CONGOLES                CONGO, REPUBLICA DEMOCRATICA DO      
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "365", "BIF", SiteUtil.STRING_EMPTY, "Franco", "Francos", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO/BURUNDI                 BURUNDI                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "368", "KMF", SiteUtil.STRING_EMPTY, "Franco", "Francos", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO/COMORES                 COMORES, ILHAS                       
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "370", "XAF", SiteUtil.STRING_EMPTY, "Franco", "Francos", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO CFA BEAC                -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "372", "XOF", SiteUtil.STRING_EMPTY, "Franco", "Francos", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO CFA BCEAO               -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "380", "XPF", SiteUtil.STRING_EMPTY, "Franco", "Francos", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO CFP                     POLINESIA FRANCESA                   
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "385", "BIF", SiteUtil.STRING_EMPTY, "Franco", "Francos", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO/BURUNDI                 -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "390", "DJF", SiteUtil.STRING_EMPTY, "Franco", "Francos", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO/DJIBUTI                 DJIBUTI                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "395", "FRF", SiteUtil.STRING_EMPTY, "Franco", "Francos", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO FRANCES                 FRANCA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "398", "GNF", SiteUtil.STRING_EMPTY, "Franco",  "Francos",   "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO/GUINE                   GUINE                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "400", "LUF", SiteUtil.STRING_EMPTY, "Franco", "Francos", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO LUXEMBURGO              LUXEMBURGO                           
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "405", "MGF", SiteUtil.STRING_EMPTY, "Franco", "Francos", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO MALGAXE MADAGA          MADAGASCAR                           
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "406", "MGA", SiteUtil.STRING_EMPTY, "Ariari", "Ariari", "iraimbilanja", "iraimbilanja",    SiteUtil.STRING_EMPTY)); //ARIARY MADAGASCAR              MADAGASCAR                           
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "410", "MF",  SiteUtil.STRING_EMPTY, "Franco", "Francos", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO MALI                    -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "420", "RWF", SiteUtil.STRING_EMPTY, "Franco",  "Francos",   "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO/RUANDA                  RUANDA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "425", "CHF", SiteUtil.STRING_EMPTY, "Franco", "Francos", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //FRANCO SUICO                   SUICA                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "440", "HTG", SiteUtil.STRING_EMPTY, "Gourde", "Gourdes", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //GOURDE/HAITI                   HAITI                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "450", "PYG", SiteUtil.STRING_EMPTY, "Guarani", "Guaranis", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //GUARANI/PARAGUAI               PARAGUAI                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "460", "UAH", SiteUtil.STRING_EMPTY, "Hyvnia", "Hyvnias", "kopiyka", "kopiykas",    SiteUtil.STRING_EMPTY)); //HRYVNIA UCRANIA                UCRANIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "470", "JPY", SiteUtil.STRING_EMPTY, "Iene", "Ienes", "sen", "sengs",    SiteUtil.STRING_EMPTY)); //IENE                           JAPAO                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "480", "I",   SiteUtil.STRING_EMPTY, "Inti", "Ints", "fração", "frações",    SiteUtil.STRING_EMPTY)); //INTI PERUANO                   PERU                                 
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "482", "GEL", SiteUtil.STRING_EMPTY, "Lari", "Laris", "tetri", "tetris",    SiteUtil.STRING_EMPTY)); //LARI GEORGIA                   GEORGIA, REPUBLICA DA                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "485", "LVL", SiteUtil.STRING_EMPTY, "Lat", "Lats", "fração", "frações",    SiteUtil.STRING_EMPTY)); //LAT LETONIA REP                LETONIA, REPUBLICA DA                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "490", "ALL", SiteUtil.STRING_EMPTY, "Lek", "Leks", "qindarkë", "qindarkës",    SiteUtil.STRING_EMPTY)); //LEK ALBANIA REP                ALBANIA, REPUBLICA DA                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "495", "HNL", SiteUtil.STRING_EMPTY, "Lempira", "Lempiras", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //LEMPIRA/HONDURAS               HONDURAS                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "500", "SLL", SiteUtil.STRING_EMPTY, "Leone", "Leones", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //LEONE/SERRA LEOA               SERRA LEOA                           
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "503", "MDL", SiteUtil.STRING_EMPTY, "Leu", "Leus", "ban", "banes",    SiteUtil.STRING_EMPTY)); //LEU/MOLDAVIA, REP              MOLDAVIA, REPUBLICA DA               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "505", "ROL", SiteUtil.STRING_EMPTY, "Leu", "Leus", "ban", "banes",    SiteUtil.STRING_EMPTY)); //LEU/ROMENIA                    ROMENIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "506", "RON", SiteUtil.STRING_EMPTY, "Leu", "Leus", "ban", "bans",    SiteUtil.STRING_EMPTY)); //NOVO LEU/ROMENIA               ROMENIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "510", "BGN", SiteUtil.STRING_EMPTY, "Lev", "Levs", "stotinka", "stotinkas",    SiteUtil.STRING_EMPTY)); //LEV/BULGARIA, REP              BULGARIA, REPUBLICA DA               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "520", "CYP", SiteUtil.STRING_EMPTY, "Libra",  "Libras",   "piastra", "piastras",    SiteUtil.STRING_EMPTY)); //LIBRA CIP/CHIPRE               CHIPRE                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "530", "GIP", SiteUtil.STRING_EMPTY, "Libra",  "Libras",   "piastra", "piastras",    SiteUtil.STRING_EMPTY)); //LIBRA/GIBRALTAR                GIBRALTAR                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "535", "EGP", SiteUtil.STRING_EMPTY, "Libra", "Libras", "piastra", "piastras",    SiteUtil.STRING_EMPTY)); //LIBRA/EGITO                    EGITO                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "540", "GBP", SiteUtil.STRING_EMPTY, "Libra esterlina", "Libras esterlinas", "dinheiro", "dinheiros",    SiteUtil.STRING_EMPTY)); //LIBRA ESTERLINA                REINO UNIDO                          
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "545", "FKP", SiteUtil.STRING_EMPTY, "Libra",  "Libras",   "dinheiro", "dinheiros",    SiteUtil.STRING_EMPTY)); //LIBRA/FALKLAND                 FALKLAND (ILHAS MALVINAS)            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "550", "IEP", SiteUtil.STRING_EMPTY, "Libra",  "Libras",   "dinheiro", "dinheiros",    SiteUtil.STRING_EMPTY)); //LIBRA/IRLANDA                  IRLANDA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "555", "IL",  SiteUtil.STRING_EMPTY, "Novo siclo", "Novos siclos", "agora", "agoras",    SiteUtil.STRING_EMPTY)); //LIBRA ISRAELENSE               -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "560", "LBP", SiteUtil.STRING_EMPTY, "Libra",  "Libras",   "piastra", "piastras",    SiteUtil.STRING_EMPTY)); //LIBRA/LIBANO                   LIBANO                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "565", "MTL", SiteUtil.STRING_EMPTY, "Lira", "Liras", "piastra", "piastras",    SiteUtil.STRING_EMPTY)); //LIRA/MALTA                     MALTA                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "570", "SHP", SiteUtil.STRING_EMPTY, "Libra",  "Libras",   "dinheiro", "dinheiros",    SiteUtil.STRING_EMPTY)); //LIBRA/STA HELENA               SANTA HELENA                         
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "575", "SYP", SiteUtil.STRING_EMPTY, "Libra",  "Libras",   "piastra", "piastras",    SiteUtil.STRING_EMPTY)); //LIBRA/SIRIA, REP               SIRIA, REPUBLICA ARABE DA            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "580", "LSD", SiteUtil.STRING_EMPTY, "Libra",  "Libras",   "piastra", "piastras",    SiteUtil.STRING_EMPTY)); //LIBRA SUDANESA                 SUDAO                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "585", "SZL", SiteUtil.STRING_EMPTY, "Lilangeni", "Lilangenis", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //LILANGENI/SUAZIL               SUAZILANDIA                          
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "595", "ITL", SiteUtil.STRING_EMPTY, "Libra",  "Libras",   "dinheiro", "dinheiros",    SiteUtil.STRING_EMPTY)); //LIRA ITALIANA                  ITALIA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "600", "TRL", SiteUtil.STRING_EMPTY, "Libra",  "Libras",   "piastra", "piastras",    SiteUtil.STRING_EMPTY)); //LIRA TURQUIA                   TURQUIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "601", "LTL", SiteUtil.STRING_EMPTY, "Lita", "Litas", "fração", "frações",    SiteUtil.STRING_EMPTY)); //LITA LITUANIA                  LITUANIA, REPUBLICA DA               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "603", "LSL", SiteUtil.STRING_EMPTY, "Loti", "Lotis", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //LOTI/LESOTO                    LESOTO                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "605", "M",   SiteUtil.STRING_EMPTY, "Marco", "Marcos", "fening", "fenings",    SiteUtil.STRING_EMPTY)); //MARCO                          -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "607", "AZN", SiteUtil.STRING_EMPTY, "Manat", "Manats", "tennesi", "tennesis",    SiteUtil.STRING_EMPTY)); //MANAT ARZEBAIJAO               AZERBAIJAO, REPUBLICA DO             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "608", "TMT", SiteUtil.STRING_EMPTY, "Novo Manat", "Novos Manats", "tennesi", "tennesis",    SiteUtil.STRING_EMPTY)); //NOVO MANAT TURCOM              TURCOMENISTAO, REPUBLICA DO          
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "610", "DEM", SiteUtil.STRING_EMPTY, "Marco", "Marcos", "fening", "fenings",    SiteUtil.STRING_EMPTY)); //MARCO ALEMAO                   ALEMANHA                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "612", "BAM", SiteUtil.STRING_EMPTY, "Marco", "Marcos", "fening", "fenings",    SiteUtil.STRING_EMPTY)); //MARCO CONV BOSNIA              BOSNIA-HERZEGOVINA (REPUBLICADA)     
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "615", "FIM", SiteUtil.STRING_EMPTY, "Marco", "Marcos", "fening", "fenings",    SiteUtil.STRING_EMPTY)); //MARCO FINLANDES                FINLANDIA                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "620", "MZM", SiteUtil.STRING_EMPTY, "Metical", "Meticals", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //METICAL MOCAMBIQ               MOCAMBIQUE                           
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "622", "MZN", SiteUtil.STRING_EMPTY, "Nova Metical", "Nova Meticals", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //NOVA METICAL/MOCA              MOCAMBIQUE                           
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "625", "ERN", SiteUtil.STRING_EMPTY, "Nakfa", "Nakfas", "cêntimo", "cêntimo",    SiteUtil.STRING_EMPTY)); //NAKFA ERITREIA                 ERITREIA                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "630", "NGN", SiteUtil.STRING_EMPTY, "Naira", "Nairas", "kobo", "kobos",    SiteUtil.STRING_EMPTY)); //NAIRA/NIGERIA                  NIGERIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "635", "AOA", SiteUtil.STRING_EMPTY, "Kwanza", "Kwanzas", "cêntimo", "cêntimos",      SiteUtil.STRING_EMPTY)); //KWANZA/ANGOLA                  ANGOLA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "637", "YUM", SiteUtil.STRING_EMPTY, "Novo Dinar", "Novos Dinares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //NOVO DINAR IUGOSLAVO           SERVIA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "640", "TWD", SiteUtil.STRING_EMPTY, "Novo Dolar", "Novos Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //NOVO DOLAR/TAIWAN              FORMOSA (TAIWAN)                     
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "642", "TRY", SiteUtil.STRING_EMPTY, "Nova Lira", "Nova Liras", "piastra", "piastras",    SiteUtil.STRING_EMPTY)); //LIRA TURCA                     TURQUIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "645", "MXN", SiteUtil.STRING_EMPTY, "Peso", "Pesos", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //NOVO PESO/MEXICO               -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "646", "MXN", SiteUtil.STRING_EMPTY, "Peso", "Pesos", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //NOVO PESO/MEXICO               -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "650", "N",   SiteUtil.STRING_EMPTY, "Novo Peso", "Novos Pesos", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //NOVO PESO URUGUAI              -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "651", "NC",  SiteUtil.STRING_EMPTY, "Novo Peso", "Novos Pesos", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //NOVO PESO URUGUAI              -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "660", "PEN", SiteUtil.STRING_EMPTY, "Novo Sol", "Novos Sois", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //NOVO SOL/PERU                  PERU                                 
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "663", "ZRN", SiteUtil.STRING_EMPTY, "Novo Zaire", "Novos Zaires", "fração", "frações",    SiteUtil.STRING_EMPTY)); //NOVO ZAIRE/ZAIRE               -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "665", "BTN", SiteUtil.STRING_EMPTY, "Ngultrum", "Ngultrums", "chetrum", "chetrums",    SiteUtil.STRING_EMPTY)); //NGULTRUM/BUTAO                 BUTAO                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "670", "MRO", SiteUtil.STRING_EMPTY, "Uguia", "Uguia", "khoums", "khoums",    SiteUtil.STRING_EMPTY)); //UGUIA MAURITANIA               MAURITANIA                           
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "680", "TOP", SiteUtil.STRING_EMPTY, "Paanga", "Paangas", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //PAANGA/TONGA                   TONGA                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "685", "MOP", SiteUtil.STRING_EMPTY, "Pataca", "Patacas", "avo", "avos",    SiteUtil.STRING_EMPTY)); //PATACA/MACAU                   MACAU                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "690", "ADP", SiteUtil.STRING_EMPTY, "Peseta", "Pesetas", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //PESETA/ANDORA                  ANDORRA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "700", "ESP", SiteUtil.STRING_EMPTY, "Peseta", "Pesetas", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //PESETA ESPANHOLA               ESPANHA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "705", "ARG", SiteUtil.STRING_EMPTY, "Peso", "Pesos", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //PESO ARGENTINO                 ARGENTINA                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "706", "ARS", SiteUtil.STRING_EMPTY, "Peso", "Pesos", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //PESO ARGENTINO                 ARGENTINA                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "715", "CLP", SiteUtil.STRING_EMPTY, "Peso", "Pesos", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //PESO CHILE                     CHILE                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "720", "COP", SiteUtil.STRING_EMPTY, "Peso",  "Pesos",   "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //PESO/COLOMBIA                  COLOMBIA                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "725", "CUP", SiteUtil.STRING_EMPTY, "Peso",  "Pesos",   "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //PESO/CUBA                      CUBA                                 
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "730", "DOP", SiteUtil.STRING_EMPTY, "Peso", "Pesos", "fracentavo", "centavos",    SiteUtil.STRING_EMPTY)); //PESO/REP. DOMINIC              REPUBLICA DOMINICANA                 
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "735", "PHP", SiteUtil.STRING_EMPTY, "Peso",  "Pesos",   "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //PESO/FILIPINAS                 FILIPINAS                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "738", "GWP", SiteUtil.STRING_EMPTY, "Peso",  "Pesos",   "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //PESO/GUINE BISSAU              GUINE-BISSAU                         
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "740", "EX",  SiteUtil.STRING_EMPTY, "Peso", "Pesos", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //PESO MEXICANO M                MEXICO                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "741", "MXN", SiteUtil.STRING_EMPTY, "Peso", "Pesos", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //PESO/MEXICO                    MEXICO                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "745", "UYU", SiteUtil.STRING_EMPTY, "Peso",  "Pesos",   "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //PESO/URUGUAIO                  URUGUAI                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "755", "BWP", SiteUtil.STRING_EMPTY, "Pula", "Pulas", "thebe", "thebes",    SiteUtil.STRING_EMPTY)); //PULA/BOTSWANA                  BOTSUANA                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "760", "MWK", SiteUtil.STRING_EMPTY, "Kwacha", "Kwachas", "tambala", "tambalas",    SiteUtil.STRING_EMPTY)); //QUACHA/MALAVI                  MALAVI                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "765", "ZMK", SiteUtil.STRING_EMPTY, "Kwacha", "Kwachas", "ngwee", "ngwees",    SiteUtil.STRING_EMPTY)); //QUACHA ZAMBIA                  ZAMBIA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "766", "ZMW", SiteUtil.STRING_EMPTY, "Kwacha", "Kwachas", "ngwee", "ngwees",    SiteUtil.STRING_EMPTY)); //QUACHA ZAMBIA                  ZAMBIA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "770", "GTQ", SiteUtil.STRING_EMPTY, "Quetzal", "Quetzals", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //QUETZAL/GUATEMALA              GUATEMALA                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "775", "MMK", SiteUtil.STRING_EMPTY, "Kyat", "Kyats", "pya", "pyas",    SiteUtil.STRING_EMPTY)); //QUIATE/BIRMANIA                MIANMAR (BIRMANIA)                   
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "778", "PGK", SiteUtil.STRING_EMPTY, "Kina", "Kinas", "toea", "toea",    SiteUtil.STRING_EMPTY)); //KINA/PAPUA N GUIN              PAPUA NOVA GUINE                     
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "779", "HRK", SiteUtil.STRING_EMPTY, "Kuna", "Kunas", "lipa", "lipas",    SiteUtil.STRING_EMPTY)); //KUNA/CROACIA                   CROACIA (REPUBLICA DA)               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "780", "LAK", SiteUtil.STRING_EMPTY, "Quipe","Quipes","att", "atts",    SiteUtil.STRING_EMPTY)); //QUIPE/LAOS, REP                LAOS, REP.POP.DEMOCR.DO              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "785", "ZAR", SiteUtil.STRING_EMPTY, "Rand", "Rands", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //RANDE/AFRICA SUL               AFRICA DO SUL                        
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "790", "BRL", SiteUtil.STRING_EMPTY, "Real", "Reais", "centavo", "centavos",    SiteUtil.STRING_EMPTY)); //REAL BRASIL                    BRASIL                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "795", "CNY", SiteUtil.STRING_EMPTY, "Iuan Renmimbi", "Iuanes Renmimbi", "fen", "fens",    SiteUtil.STRING_EMPTY)); //RENMIMBI IUAN                  CHINA, REPUBLICA POPULAR             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "796", "CNH", SiteUtil.STRING_EMPTY, "Iuan Renmimbi", "Iuanes Renmimbi", "fen", "fens",    SiteUtil.STRING_EMPTY)); //RENMINBI HONG KONG             -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "800", "QAR", SiteUtil.STRING_EMPTY, "Rial", "Rials", "dirame", "dirames",    SiteUtil.STRING_EMPTY)); //RIAL/CATAR                     CATAR                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "805", "OMR", SiteUtil.STRING_EMPTY, "Rial", "Rials", "baisa", "baisas",    SiteUtil.STRING_EMPTY)); //RIAL/OMA                       OMA                                  
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "810", "YER", SiteUtil.STRING_EMPTY, "Rial", "Rial", "fils", "fils",    SiteUtil.STRING_EMPTY)); //RIAL/IEMEN                     IEMEN                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "815", "IRR", SiteUtil.STRING_EMPTY, "Rial", "Rials", "dinar", "dinares",    SiteUtil.STRING_EMPTY)); //RIAL/IRAN, REP                 IRA, REPUBLICA ISLAMICA DO           
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "820", "SAR", SiteUtil.STRING_EMPTY, "Rial", "Rial", "halala", "halalas",    SiteUtil.STRING_EMPTY)); //RIAL/ARAB SAUDITA              ARABIA SAUDITA                       
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "825", "KHR", SiteUtil.STRING_EMPTY, "Riel", "Riels", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //RIEL/CAMBOJA                   CAMBOJA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "828", "MYR", SiteUtil.STRING_EMPTY, "Ringgit", "Ringgits", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //RINGGIT/MALASIA                MALASIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "829", "BYR", SiteUtil.STRING_EMPTY, "Rublo", "Rublos", "copeque", "copeques",    SiteUtil.STRING_EMPTY)); //RUBLO BELARUS                  BELARUS, REPUBLICA DA                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "830", "RUB", SiteUtil.STRING_EMPTY, "Rublo", "Rublos", "copeque", "copeques",    SiteUtil.STRING_EMPTY)); //RUBLO/RUSSIA                   RUSSIA, FEDERACAO DA                 
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "831", "BYN", SiteUtil.STRING_EMPTY, "Rublo", "Rublos", "copeque", "copeques",    SiteUtil.STRING_EMPTY)); //RUBLO BELARUS                  BELARUS, REPUBLICA DA                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "835", "TJS", SiteUtil.STRING_EMPTY, "Somoni", "Somonis", "dirame", "dirames",    SiteUtil.STRING_EMPTY)); //SOMONI TADJIQUISTAO            TADJIQUISTAO, REPUBLICA DO           
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "840", "MUR", SiteUtil.STRING_EMPTY, "Rupia", "Rupias", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //RUPIA/MAURICIO                 MAURICIO                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "845", "NPR", SiteUtil.STRING_EMPTY, "Rupia", "Rupias", "paisa", "paisas",    SiteUtil.STRING_EMPTY)); //RUPIA/NEPAL                    NEPAL                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "850", "SCR", SiteUtil.STRING_EMPTY, "Rupia", "Rupias", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //RUPIA/SEYCHELES                SEYCHELLES                           
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "855", "LKR", SiteUtil.STRING_EMPTY, "Rupia", "Rupias", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //RUPIA/SRI LANKA                SRI LANKA                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "860", "INR", SiteUtil.STRING_EMPTY, "Rupia", "Rupias", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //RUPIA/INDIA                    INDIA                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "865", "IDR", SiteUtil.STRING_EMPTY, "Rupia", "Rupias", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //RUPIA/INDONESIA                INDONESIA                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "870", "MVR", SiteUtil.STRING_EMPTY, "Rupia", "Rupias", "laari", "laaris",    SiteUtil.STRING_EMPTY)); //RUFIA/MALDIVAS                 MALDIVAS                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "875", "PKR", SiteUtil.STRING_EMPTY, "Rupia", "Rupias", "paisa", "paisas",    SiteUtil.STRING_EMPTY)); //RUPIA/PAQUISTAO                PAQUISTAO                            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "890", "",    SiteUtil.STRING_EMPTY, "Sol", "Sois", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //SOL PERUANOS                   PERU
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "892", "KGS", SiteUtil.STRING_EMPTY, "Som", "Soms", "tyiyn", "tyiyns",    SiteUtil.STRING_EMPTY)); //SOM QUIRGUISTAO                QUIRGUIZ, REPUBLICA                  
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "893", "UZS", SiteUtil.STRING_EMPTY, "Som", "Soms", "tiyin", "tiyins",    SiteUtil.STRING_EMPTY)); //SOM UZBEQUISTAO                UZBEQUISTAO, REPUBLICA DO            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "895", "ECS", SiteUtil.STRING_EMPTY, "Sucre", "Sucres", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //SUCRE EQUADOR                  EQUADOR                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "905", "BDT", SiteUtil.STRING_EMPTY, "Taka", "Takas", "paisa", "paisas",    SiteUtil.STRING_EMPTY)); //TACA/BANGLADESH                BANGLADESH                           
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "910", "WST", SiteUtil.STRING_EMPTY, "Tala", "Talas", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //TALA                           SAMOA                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "911", "WST", SiteUtil.STRING_EMPTY, "Tala", "Talas", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //TALA SAMOA OC                  SAMOA                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "912", "WST", SiteUtil.STRING_EMPTY, "Tala", "Talas", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //TALA SAMOA                     SAMOA                                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "913", "KZT", SiteUtil.STRING_EMPTY, "Tenge", "Tenges", "tïn", "tïns",    SiteUtil.STRING_EMPTY)); //TENGE CAZAQUISTAO              CAZAQUISTAO, REPUBLICA DO            
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "914", "SIT", SiteUtil.STRING_EMPTY, "Tolar", "Tolars", "fração", "frações",    SiteUtil.STRING_EMPTY)); //TOLAR/ESLOVENIA                ESLOVENIA, REPUBLICA DA              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "915", "MNT", SiteUtil.STRING_EMPTY, "Tugrik", "Tugriks", "möngö", "möngö",    SiteUtil.STRING_EMPTY)); //TUGRIK/MONGOLIA                MONGOLIA                             
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "920", "VUV", SiteUtil.STRING_EMPTY, "Vatu", "Vatus", "", "",    SiteUtil.STRING_EMPTY)); //VATU VANUATU                   VANUATU                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "925", "KPW", SiteUtil.STRING_EMPTY, "Won", "Wons", "chon", "chons",    SiteUtil.STRING_EMPTY)); //WON/COREIA NORTE               COREIA, REP.POP.DEMOCRATICA          
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "930", "KRW", SiteUtil.STRING_EMPTY, "Won", "Wons", "jeon", "jeons",    SiteUtil.STRING_EMPTY)); //WON COREIA SUL                 COREIA, REPUBLICA DA                 
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "940", "ATS", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //XELIM AUSTRIACO                AUSTRIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "945", "SH",  SiteUtil.STRING_EMPTY, "Xelim", "Xelims", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //XELIM DA TANZANIA T            TANZANIA, REP.UNIDA DA               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "946", "TZS", SiteUtil.STRING_EMPTY, "Xelim", "Xelims", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //XELIM/TANZANIA                 TANZANIA, REP.UNIDA DA               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "950", "KES", SiteUtil.STRING_EMPTY, "Xelim", "Xelims", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //XELIM/QUENIA                   QUENIA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "955", "UGX", SiteUtil.STRING_EMPTY, "Xelim", "Xelims", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //XELIM/UGANDA                   UGANDA                               
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "960", "SOS", SiteUtil.STRING_EMPTY, "Xelim", "Xelims", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //XELIM/SOMALIA                  SOMALIA                              
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "970", "ZRN", SiteUtil.STRING_EMPTY, "Novo Zaire", "Novos Zaires", "fração", "frações",    SiteUtil.STRING_EMPTY)); //NOVO ZAIRE ZAIRE               CONGO, REPUBLICA DEMOCRATICA DO      
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "971", "ZRN", SiteUtil.STRING_EMPTY, "Novo Zaire", "Novos Zaires", "fração", "frações",    SiteUtil.STRING_EMPTY)); //NOVO ZAIRE/ZAIRE               CONGO, REPUBLICA DEMOCRATICA DO      
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "975", "PLN", SiteUtil.STRING_EMPTY, "Zlóti", "Zlótis", "grosz",  "groszs",    SiteUtil.STRING_EMPTY)); //ZLOTY/POLONIA                  POLONIA, REPUBLICA DA                
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "978", "EUR", SiteUtil.STRING_EMPTY, "Euro",  "Euros",  "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //EURO                           -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "980", "RDA", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR-EX-ALEM.ORI CL$          -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "982", "ULG", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR-BULGARIA CL$B            -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "983", "REC", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR-GRECIA CL$G              -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "984", "UNG", SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR-HUNGRIA CL$H             -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "986", "SR",  SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR-ISRAEL CL$I              -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "988", "UG",  SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR-IUGOSLAVIA CL$I          -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "990", "OL",  SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR-POLONIA CL$P             -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "991", "XAG", SiteUtil.STRING_EMPTY, "Prata", "Pratas", "fração", "frações",    SiteUtil.STRING_EMPTY)); //PRATA-DEAFI                    -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "992", "OM",  SiteUtil.STRING_EMPTY, "Dolar", "Dolares", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR-ROMENIA CL$R             -                                    
    		listaMoedaDetalhe.add(adicionaNovaMoeda(Numeros.ZERO, "998", "XAU", SiteUtil.STRING_EMPTY, "Dolar Ouro", "Dolares Ouro", "cêntimo", "cêntimos",    SiteUtil.STRING_EMPTY)); //DOLAR OURO
    	}    	
    	
    }

    /**
     * Nome: adicionaNovaMoeda
     * 
     * Propósito: Cria objeto de detalhes da moeda a ser adicionado à lista de moedas.
     *
     * @param : Código interno de cadastro da moeda.
     * 			Código ISO/BACEN da moeda (ex: 220 para Dolar, etc.).
     * 			Sigla da moeda no BACEN (ex: USD, EUR, etc)
     * 			Símbolo da moeda (ex: R$ - Real, etc)
     * 			Nome da moeda no singular (ex: real)
     * 			Nome da moeda no plural   (ex: reais)
     * 			Unidade fracionária da moeda no singular (ex: centavo)
     * 			Unidade fracionária da moeda no plural (ex: centavos)
     * 			Descrição indicadora da moeda.
     * @return : Objeto montado com os detalhes da moeda para ser adicionado à lista de moedas.
     * @throws :
     * @exception : 
     *
     * Registro  de Manutenção: 16/09/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    private static MoedaDetalheVO adicionaNovaMoeda(Integer cindcdeconmmoeda, 
			    									String codigoMoedaBacen, 
			    									String siglaMoedaBacen, 
			    									String simboloMoeda, 
			    									String nomeMoedaSingular, String nomeMoedaPlural, 
			    									String fracaoMoedaSingular, String fracaoMoedaPlural, 
			    									String descIndcdMoeda) {
        
    	MoedaDetalheVO objTo = new MoedaDetalheVO();
	    	objTo.setCindcdeconmmoeda(cindcdeconmmoeda);
	    	objTo.setCindcdfontecons(codigoMoedaBacen);
	    	objTo.setDescrmoedasingular(nomeMoedaSingular);
	    	objTo.setDescrmoedaplural(nomeMoedaPlural);
	    	objTo.setDescrmoedafracaosingular(fracaoMoedaSingular);
	    	objTo.setDescrmoedafracaoplural(fracaoMoedaPlural);
	    	objTo.setIindcdeconmoeda(descIndcdMoeda);
	    	objTo.setIsgleconmmoeda(siglaMoedaBacen);
	    	objTo.setSimbleconmmoeda(simboloMoeda);
	   return objTo;
    
    }

    /**
     * Nome: obterDetalhesMoeda
     * 
     * Propósito: Pesquisa pelos detalhes da moeda através da sigla.
     *
     * @param : Texto que representa a sigla ISO/BACEN de uma moeda.
     * @return : Detalhes da moeda caso encontre ou detalhes vazios caso não encontre.
     * @throws :
     * @exception : 
     *
     * Registro  de Manutenção: 16/09/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    private static MoedaDetalheVO obterDetalhesMoeda(String siglaMoedaBacen) {
    	MoedaDetalheVO itemMoeda = new MoedaDetalheVO();
    		
    	if (listaMoedaDetalhe.size() > Numeros.ZERO) {
    		for (Iterator<MoedaDetalheVO> iterator = listaMoedaDetalhe.iterator(); iterator.hasNext();) {
    			itemMoeda = (MoedaDetalheVO) iterator.next();
    			if (itemMoeda.getIsgleconmmoeda().equalsIgnoreCase(siglaMoedaBacen.trim().toUpperCase())) {
    				break;
    			}
    		}
    	}
    	return itemMoeda;
	}
    	

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        // Verifica a nulidade 
        if (value != null && value.toString().trim().length() > 0) {            
            //String stringValue = getNumericValue(value.toString());
            return value.replace(".", "").replace(",", ".");
        } else {
            return "";
        }
    }

    @SuppressWarnings("resource")
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        
    	if (component instanceof UIOutputLabelBradesco) {
    		UIOutputLabelBradesco label = (UIOutputLabelBradesco)component;
    		
    		Object bacenmoeda = label.getAttributes() != null ? label.getAttributes().get("bacenmoeda") : null;
    		Object siglatmoeda = label.getAttributes() != null ? label.getAttributes().get("siglatmoeda") : null;
    		Object nomemoeda = label.getAttributes() != null ? label.getAttributes().get("nomemoeda") : null;
    		
    		if ((bacenmoeda == null) && (siglatmoeda == null) && (nomemoeda == null)) {
    			throw new IllegalArgumentException("Um dos parâmetros ('bacenmoeda', 'siglatmoeda', 'nomemoeda') não pode ser nulo.");
    		}
    		
    		// masculino ou "" - Masculino - Um, Dois, etc.
    		// feminino  - Feminino  - Uma, duas, etc.
    		Object generoMascFem = label.getAttributes() != null ? label.getAttributes().get("generoextenso") : null;
    		
    		if (generoMascFem == null) {
    	    	this.generoExtenso = EnumGeneroMasculinoFeminino.MASCULINO.getDescricao();
    	    	
    		} else if (generoMascFem.toString().trim().toUpperCase().equalsIgnoreCase(EnumGeneroMasculinoFeminino.FEMININO.getDescricao())) {
    	    	this.generoExtenso = EnumGeneroMasculinoFeminino.FEMININO.getDescricao();
    		} else {
    	    	this.generoExtenso = EnumGeneroMasculinoFeminino.MASCULINO.getDescricao();
    		}
    		
    	    carregarDetalhesMoeda();
    	    
    	    if (siglatmoeda  != null) {
    	    	detalheMoeda = obterDetalhesMoeda(siglatmoeda.toString());
    	    }
    	}
    	
        // Verifica a nulidade 
        if (value != null && value.toString().trim().length() > 0) {            
            String stringValue = getNumericValue(value.toString());
            int dotIndex = stringValue.indexOf(".");
            
            // Verifica se há decimais no número
            if (dotIndex > -1) {
                int precisaoDecimais = stringValue.length() - dotIndex - 1;
                return this.getExtenso(stringValue.toString().trim().replace(".", ","), precisaoDecimais);
            } else {
                return this.getExtenso(stringValue.toString().trim(), this.generoExtenso);
            }
            
        } else {
        	return "";
        	
        }
    }
    

    /**
     * Nome: getExtenso
     * 
     * Propósito: Atribui o genero (masculino ou feminino) para controle do retorno do extenso equivalente.
     *
     * @param : Texto que representa um genero a ser tratado: masculino (um, dois) ou feminino (uma, duas).
     * @return : 
     * @throws :
     * @exception : 
     *
     * Registro  de Manutenção: 16/09/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    private static void setGenero(String generoMascFem) {
		if (generoMascFem.toString().trim().toUpperCase().equalsIgnoreCase(EnumGeneroMasculinoFeminino.FEMININO.getDescricao())) {
	    	generoExtenso = EnumGeneroMasculinoFeminino.FEMININO.getDescricao();
		} else {
	    	generoExtenso = EnumGeneroMasculinoFeminino.MASCULINO.getDescricao();
		}
    }
    
    
    /**
     * Nome: getExtenso
     * 
     * Propósito: Conversão de número em um extenso equivalente.
     *
     * @param : Texto que representa um número sem casas decimais.
     * @return : Texto contendo o número convertido em extenso.
     * @throws :
     * @exception : 
     *
     * Registro  de Manutenção: 16/09/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static String getExtenso(String numero, String generoMascFem) {
    	setGenero(generoMascFem);

    	return converteExtensoNumero(SiteUtil.removeNaoNumericos(numero.trim()));
    }
    
    
    /**
     * Nome: getExtenso
     * 
     * Propósito: Conversão de valor monetário em um extenso equivalente.
     *
     * @param : Texto que representa um valor monetário.
     *			Caso contenha o separador de decimal, este deve ser a virgula (","). 
     *			Caso não contenha o separador de decimal, serão consideradas os últimos dígitos 
     *			como decimais, respeitando a quantidade de casas decimis informada. 
     * @return : Texto contendo o valor monetário convertido em extenso.
     * @throws :
     * @exception : 
     *
     * Registro  de Manutenção: 16/09/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static String getExtenso(String valor, int decimais) {
    	return converteExtensoValor(valor, decimais);
    }
        
    
    /**
     * Nome: getExtenso
     * 
     * Propósito: Conversão de número em um extenso equivalente.
     *
     * @param : Número sem casas decimais.
     * @return : Texto contendo o número convertido em extenso.
     * @throws :
     * @exception : 
     *
     * Registro  de Manutenção: 16/09/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static String getExtenso(Integer numero, String generoMascFem) {
        String strNumero = SiteUtil.STRING_EMPTY;

    	setGenero(generoMascFem);
        
        strNumero = SiteUtil.getString(numero).trim();
        strNumero = SiteUtil.removeNaoNumericos(strNumero);

    	return converteExtensoNumero(strNumero);
    }
    
    
    /**
     * Nome: getExtenso
     * 
     * Propósito: Conversão de número em um extenso equivalente.
     *
     * @param : Numero sem casas decimais.
     * @return : Texto contendo o número convertido em extenso.
     * @throws :
     * @exception : 
     *
     * Registro  de Manutenção: 16/09/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static String getExtenso(Long numero, String generoMascFem) {
        String strNumero = SiteUtil.STRING_EMPTY;
        
    	setGenero(generoMascFem);
        
        strNumero = SiteUtil.getString(numero).trim();
        strNumero = SiteUtil.removeNaoNumericos(strNumero);

    	return converteExtensoNumero(strNumero);
    }

    
    /**
     * Nome: getExtenso
     * 
     * Propósito: Conversão de valor monetário em um extenso equivalente.
     *
     * @param : Valor monetário.
     * @param : Quantidade de casas decimais.
     * @return : Texto contendo o valor monetário convertido em extenso.
     * @throws :
     * @exception : 
     *
     * Registro  de Manutenção: 16/09/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static String getExtenso(double valor, int decimais) {
        String strValor = SiteUtil.STRING_EMPTY;
        
        strValor = SiteUtil.doubleToBrowserMoeda(valor, decimais);
    	
    	return converteExtensoValor(strValor, decimais);
    }
    
    
    /**
     * Nome: getExtenso
     * 
     * Propósito: Conversão de valor monetário em um extenso equivalente.
     *
     * @param : Valor monetário.
     *			Serão consideradas 2 casas decimais. 
     * @return : Texto contendo o valor monetário convertido em extenso.
     * @throws :
     * @exception : 
     *
     * Registro  de Manutenção: 16/09/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static String getExtenso(Double valor) {
    	
        String strValor = SiteUtil.STRING_EMPTY;
        
        strValor = SiteUtil.doubleToBrowserMoeda(valor);
    	
    	return converteExtensoValor(strValor, Numeros.DOIS);
    }


    /**
     * Nome: getExtenso
     * 
     * Propósito: Conversão de valor monetário em um extenso equivalente.
     *
     * @param : Valor monetário.
     * @param : Quantidade de casas decimais.
     * @return : Texto contendo o valor monetário convertido em extenso.
     * @throws :
     * @exception : 
     *
     * Registro  de Manutenção: 16/09/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static String getExtenso(BigDecimal valor, int decimais) {
        String strValor = SiteUtil.STRING_EMPTY;
        
        strValor = SiteUtil.bigDecimalToWebMoeda(valor, decimais);
    	
    	return converteExtensoValor(strValor, decimais);
    }
    
    
    /**
     * Nome: getExtenso
     * 
     * Propósito: Conversão de valor monetário em um extenso equivalente.
     *
     * @param : Valor monetário.
     *			Serão consideradas 2 casas decimais. 
     * @return : Texto contendo o valor monetário convertido em extenso.
     * @throws :
     * @exception : 
     *
     * Registro  de Manutenção: 16/09/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static String getExtenso(BigDecimal valor) {
    	
        String strValor = SiteUtil.STRING_EMPTY;
        
        strValor = SiteUtil.bigDecimalToWebMoeda(valor);
    	
    	return converteExtensoValor(strValor, Numeros.DOIS);
    }

    
    private String getNumericValue(String value) {
        int dotCount = characterCount(value, ".");
        int commaCount = characterCount(value, ",");
        
        // Valor no padrão americano (e.g. 1,000,000.00)
        if (commaCount > dotCount && dotCount == 1) {
            return value.toString().trim().replace(",", "");
        } else if (dotCount == 1) { // Pode ser tanto 1.000,00 como 1,000.00
            int dotIndex = value.indexOf(".");
            int commaIndex = value.indexOf(",");
            
            if (dotIndex > commaIndex) {
                return value.toString().trim().replace(",", "");
            } else {
                return value.toString().trim().replace(".", "").replace(",", ".");
            }
        } else {
            return value.toString().trim().replace(".", "").replace(",", ".");
        }
    }
    
    private int characterCount(String string, String character) {
        if (string != null && string.length() > 0) {
            int counter = 0;
            int lastIndex = string.indexOf(character, 0);
            
            while (lastIndex > -1) {
                lastIndex = string.indexOf(character, lastIndex + 1);
                counter++;
            }
            
            return counter;            
        } else {
            return 0;
        }
    }

    
    /**
     * Nome: converteExtensoValor
     * 
     * Propósito: Tratamento para conversão de valores monetários em extenso.
     *
     * @param : Texto que represente um valor monetário.
     * @return : Texto contendo o valor monetário convertido em extenso.
     * @throws :
     * @exception : 
     *
     * Registro  de Manutenção: 15/09/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    private static String converteExtensoValor(String valor, int decimais) {

    	StringBuilder numeroExtenso = new StringBuilder(SiteUtil.STRING_EMPTY);
        
    	String numeroTratar   = SiteUtil.STRING_EMPTY;
        String decimaisTratar = SiteUtil.STRING_EMPTY;
        
        numeroTratar = valor.trim();
        
        decimaisTratar = numeroTratar.substring(numeroTratar.length() - decimais);
        
        numeroTratar = numeroTratar.substring(0, (numeroTratar.length() - (decimais + 1)));
        numeroTratar = SiteUtil.removeNaoNumericos(numeroTratar);
        
        numeroExtenso.append(converteExtensoNumero(numeroTratar));
        
        if (numeroExtenso.toString().length() > 0) {
            if (SiteUtil.getLong(numeroTratar) == Numeros.UM_L) {
            	numeroExtenso.append(" ").append(detalheMoeda.getDescrmoedasingular().trim().toLowerCase());
            } else {
            	numeroExtenso.append(" ").append(detalheMoeda.getDescrmoedaplural().trim().toLowerCase());
            }
        }
        
        if (SiteUtil.getInt(decimaisTratar) != Numeros.ZERO) {
			
        	numeroExtenso.append(STRNG_SEPARADOR_E);
            numeroExtenso.append(converteExtensoNumero(decimaisTratar));
            
            if (SiteUtil.getInt(decimaisTratar) == Numeros.UM) {
            	numeroExtenso.append(" ").append(detalheMoeda.getDescrmoedafracaosingular().trim().toLowerCase());
            } else {
            	numeroExtenso.append(" ").append(detalheMoeda.getDescrmoedafracaoplural().trim().toLowerCase());
            }
            
        }
    	
    	return numeroExtenso.toString().trim();
    }
    
    
    /**
     * Nome: converteExtensoNumero
     * 
     * Propósito: Tratamento para conversão de números inteiros sem casas decimais.
     *
     * @param : Texto que represente um número inteiro.
     * @return : Texto contendo o número convertido em extenso.
     * @throws :
     * @exception : 
     *
     * Registro  de Manutenção: 15/09/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    private static String converteExtensoNumero(String numero) {

    	if(generoExtenso.equalsIgnoreCase(EnumGeneroMasculinoFeminino.FEMININO.getDescricao())) {
	    	unidadeExtenso[Numeros.UM] = "uma";
	    	unidadeExtenso[Numeros.DOIS] = "duas";
		} else {
	    	unidadeExtenso[Numeros.UM] = "um";
	    	unidadeExtenso[Numeros.DOIS] = "dois";
		}
    	
    	StringBuilder numeroExtenso = new StringBuilder(SiteUtil.STRING_EMPTY);
    	
    	// centenas, milhares, milhões, bilhoes, trilhoes       
    	String[] centenasQuebradas = {SiteUtil.STRING_EMPTY, SiteUtil.STRING_EMPTY, SiteUtil.STRING_EMPTY, SiteUtil.STRING_EMPTY, SiteUtil.STRING_EMPTY};
    	
        String numeroTratar = SiteUtil.STRING_EMPTY;
        numeroTratar = SiteUtil.removeNaoNumericos(numero);
        
    	int indiceCentenas = Numeros.ZERO;
    	while (!numeroTratar.equals(SiteUtil.STRING_EMPTY)) {
    		try {
    			
    			centenasQuebradas[indiceCentenas] = numeroTratar.substring(numeroTratar.length() - 3); 
    			numeroTratar = numeroTratar.substring(0, numeroTratar.length() - 3);
        		indiceCentenas++;
        		
    		} catch (Exception ex) {
    			if (numeroTratar.length() > 0) {
    				centenasQuebradas[indiceCentenas] = numeroTratar;
    			}
    			numeroTratar = SiteUtil.STRING_EMPTY;
    		}
    	}
    	
    	for (int elemento = Numeros.QUATRO; elemento >= Numeros.ZERO; elemento--) {
    		numeroTratar = centenasQuebradas[elemento].trim();
    		if ((!numeroTratar.equals(SiteUtil.STRING_EMPTY)) && (SiteUtil.getInt(numeroTratar) > 0)) {
    			
    			if (!numeroExtenso.toString().trim().equals(SiteUtil.STRING_EMPTY)) {
    				numeroExtenso.append(STRNG_SEPARADOR_E);
    			}
    			
    			numeroExtenso.append(converteExtensoBloco(numeroTratar));
    			if (SiteUtil.getInt(numeroTratar) > 1) {
    				numeroExtenso.append(qualificaPlural[elemento]);
    			} else {
    				numeroExtenso.append(qualificaSingular[elemento]);
    			}
    			
    		}
    	}
    	
    	return numeroExtenso.toString().trim();
    }
    
    
    
    /**
     * Nome: converteExtensoBloco
     * 
     * Propósito: Converter um bloco de números até a centena (unidade, dezena, centena) podendo conter ou não dezena e/ou centena.
     *
     * @param : Texto que represente um número inteiro até 999.
     * @return : Texto contendo os números do bloco convertidos em extenso.
     * @throws :
     * @exception : 
     *
     * Registro  de Manutenção: 15/09/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    private static String converteExtensoBloco(String numero) {

    	StringBuilder numeroExtenso = new StringBuilder(SiteUtil.STRING_EMPTY);
    	
    	numero = numero.trim();
    	
    	// Se numero estiver vazio, retornar zero
    	if (numero.equals(SiteUtil.STRING_EMPTY)) {
    		numeroExtenso.append(STRING_EXTENSO_ZERO);
    	} else {
    		int numeroInteiro = SiteUtil.getInt(numero, true);
    		
        	// Se numero estiver zerado, retornar vazio
        	if (numeroInteiro == Numeros.ZERO) {
        		numeroExtenso.append(SiteUtil.STRING_EMPTY);
        		
           	// Se possuir apenas unidades ou dezenas até 19
        	} else if (numeroInteiro < Numeros.VINTE) {
	           		numeroExtenso.append(unidadeExtenso[numeroInteiro]);

            // Se possuir número exato 100
            } else if (numeroInteiro == Numeros.CEM) {
               		numeroExtenso.append(STRING_EXTENSO_CEM);
           		
        	} else {
	        	Integer dezenas = Numeros.ZERO;
	        	Integer unidades = Numeros.ZERO;

	           	// Se possuir apenas unidades ou dezenas até 19
	        	if (numeroInteiro < Numeros.CEM) {
	    			dezenas = (numeroInteiro / 10);
	    			unidades = (numeroInteiro % 10);
	    			
    				numeroExtenso.append(dezenaExtenso[dezenas]);
	    			if (unidades > Numeros.ZERO) {
	    				numeroExtenso.append(STRNG_SEPARADOR_E);
   						numeroExtenso.append(unidadeExtenso[unidades]);
	    			}
	    			
    			} else {
    	        	Integer centenas = Numeros.ZERO;
    	        	centenas = (numeroInteiro / 100);
    	        	if (SiteUtil.getInt(numero.substring(1)) < Numeros.VINTE) {
            			dezenas = Numeros.ZERO;
            			unidades = SiteUtil.getInt(numero.substring(1));
    	        		
    	        	} else {
	        			dezenas = ((numeroInteiro % 100) / 10);
	        			unidades = ((numeroInteiro % 100) % 10);
    	        	}
        			
        			numeroExtenso.append(centenaExtenso[centenas]);

	    			if (dezenas > Numeros.ZERO) {
	    				numeroExtenso.append(STRNG_SEPARADOR_E).append(dezenaExtenso[dezenas]);	    				
	    			}

	    			if (unidades > Numeros.ZERO) {
	    				numeroExtenso.append(STRNG_SEPARADOR_E);
   						numeroExtenso.append(unidadeExtenso[unidades]);
	    			}
    			}
    		}
    	}
    	return numeroExtenso.toString().trim();
    }

    public enum EnumGeneroMasculinoFeminino {

        /**
         * 
         */
        MASCULINO(1, "masculino"),
        
        
        /**
         * 
         */
        FEMININO(2, "feminino");
        
        
        private Integer codigo;
        
        private String descricao;
        
        private EnumGeneroMasculinoFeminino(Integer codigo, String descricao){
            this.codigo = codigo;
            this.descricao = descricao;
        }
        
        /**
         * @param codigo
         * @return
         */
        public static EnumGeneroMasculinoFeminino fromCode(Integer code) {
            switch(code) {
            case 1:
                return MASCULINO;
            case 2:
                return FEMININO;
            }
            throw new IllegalArgumentException("Inconsistência nos dados informados: " + code);
        }
        
        /**
         * @return
         */
        public String getDescricao() {
            return descricao;
        }

        /**
         * @return the codigo
         */
        public Integer getCodigo() {
            return codigo;
        }

    }
    
}
