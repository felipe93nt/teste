package br.com.bradesco.web.npcc_trade.service.gcc;

import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.enterprise.context.RequestScoped;
import javax.xml.namespace.QName;

import br.com.bradesco.filenet.facade.ArrayOfArrayOfXsdNillableString;
import br.com.bradesco.filenet.facade.ArrayOfXsdBase64Binary;
import br.com.bradesco.filenet.facade.ArrayOfXsdNillableString;
import br.com.bradesco.filenet.facade.IntegracaoFileNetCEImagemService;
import br.com.bradesco.filenet.facade.IntegracaoFileNetCEService;
import br.com.bradesco.web.aq.application.error.BradescoArchitectureException;
import br.com.bradesco.web.aq.application.property.config.IConfigPropertyManager;
import br.com.bradesco.web.aq.application.security.ICoreSecurityManager;
import br.com.bradesco.web.aq.application.security.ISecurityManager;
import br.com.bradesco.web.aq.application.sei.utils.Base64;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeException;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;

/**
 * Classe responsável por chamar os métodos para conexão com o GCC.
 */
@SuppressWarnings("serial")
@RequestScoped
public class ConnectorGcc implements Serializable {

    /**
     * Class Name.
     */
    private String className;
    
    /**
     * Negócio.
     */
    private String negocio;

    /**
     * Usuário.
     */
    private String user;

    /**
     * Password.
     */
    private String password;

    /**
     * Credencial.
     */
    private Object credencial;

    /**
     * Filenet Address.
     */
    private String filenetAddress;

    /**
     * Filenet Address.
     */
    private String filenetImagemAddress;

    /**
     * Path.
     */
    private String path;
    
    private String gccCdPastaProcesso;

    /**
     * File NET.
     */
    private IntegracaoFileNetCEService integracaoFileNetCEService;

    /**
     * File NET Imagem.
     */
    private IntegracaoFileNetCEImagemService integracaoFileNetCEImagemService;

    /**
     * Método construtor.
     */
    public ConnectorGcc() {
        IConfigPropertyManager config = BradescoCommonServiceFactory.getPropertieManager();

        filenetAddress = config.getProperty("integracao.filenet.address");
        filenetImagemAddress = config.getProperty("integracao.filenetimagem.address");
        negocio = config.getProperty("integracao.filenet.negocio");
        path = config.getProperty("integracao.filenet.path");
        //gccCdPastaProcesso = "25"; // gft - "21" - trade "25" - precificacao "24"
        gccCdPastaProcesso = config.getProperty("integracao.filenet.gccCdPastaProcesso");
        className = config.getProperty("integracao.filenet.classname");

        ISecurityManager securityManager = null;
        ICoreSecurityManager coreSecurityManager = BradescoCommonServiceFactory.getSecurityManager();

        if ((coreSecurityManager instanceof ISecurityManager)) {
            securityManager = (ISecurityManager) coreSecurityManager;
        } else {
            throw new BradescoArchitectureException("Security Manager não disponível");
        }

        this.user = securityManager.getUserId();
        this.credencial = securityManager.getUserDetails().getCredencial();
        this.password = securityManager.getCipher().decript((String) credencial);

    }

    /**
     * @param pasta
     *            Nome da pasta.
     * @param value
     *            Caminho da pasta.
     */
    public void criarPasta(String pasta, String value) {
        
        try {
            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.criarPasta] Início");
            
            ArrayOfXsdNillableString propriedades = new ArrayOfXsdNillableString();

            propriedades.getString().add("GccCdPastaProcesso");
            propriedades.getString().add(gccCdPastaProcesso); // gft - "21" - trade "25" - precificacao "24"
            propriedades.getString().add("integer");

            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.criarPasta] Pasta: "
                    + " Usuario: " + user
                    + " - Negocio: " + negocio
                    + " - Path: " + this.path  + value
                    + " - Propriedades: " + propriedades.toString());
            
            getIntegracaoFileNetCEService().getIntegracaoFileNetCE()
                .criarPastaComClasse(user, password, negocio, pasta, this.path + value, className, propriedades);

        } catch (Exception e) {
        	BradescoCommonServiceFactory.getLogManager().error("[ConnectorGcc.criarPasta] Erro " + e.getMessage());
            throw new NpccTradeWebException("Não foi possível criar a pasta.", "");
        } finally {
            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.criarPasta] Fim");
        }
    }

    /**
     * @param pasta
     *            Nome da pasta
     * @return Nome da pasta criada
     */
    public ArrayOfArrayOfXsdNillableString pesquisarPasta(String pasta) {
        
        try {
            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.pesquisarPasta] Início");
            
            ArrayOfXsdNillableString whereProperties = new ArrayOfXsdNillableString();            
            whereProperties.getString().add("FolderName");
            whereProperties.getString().add(pasta);
            
            ArrayOfXsdNillableString propertiesReturn = new ArrayOfXsdNillableString();
            propertiesReturn.getString().add("FolderName");
            
            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.pesquisarPasta] dados: "
                + " Usuario: " + user
                + " - Negocio: " + negocio
                + " - Path: " + pasta);
            
            ArrayOfArrayOfXsdNillableString resposta = getIntegracaoFileNetCEImagemService()
                    .getIntegracaoFileNetCEImagem()
                    .consultarDocumentosSearchTemplate(
                            user, 
                            password, 
                            negocio,
                            "/GCC/BCAF/Search_Templates/GccBCAFSearchPasta", 
                            whereProperties, 
                            propertiesReturn);
            
            return resposta;
            
        } catch (Exception e) {
            BradescoCommonServiceFactory.getLogManager().error("[ConnectorGcc.pesquisarPasta] Erro " + e.getMessage());
            throw new NpccTradeWebException("Pasta não encontrada.", "");
        } finally {
            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.pesquisarPasta] Fim");
        }
        
    }

    /**
     * @return Classe de Negócio
     */
    public ArrayOfArrayOfXsdNillableString obterClasseNegocio() {
        try {
        	BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.obterClasseNegocio] Início");           
            
            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.obterClasseNegocio] dados: "
                + " Usuario: " + user
                + " - Negocio: " + negocio);           
            
            ArrayOfArrayOfXsdNillableString resposta = getIntegracaoFileNetCEImagemService()
                    .getIntegracaoFileNetCEImagem()
                    .obterChoiceList(
                            user, 
                            password, 
                            negocio, 
                            "lstGccNmClasseNegocio",
                            null);
            
            return resposta;
            
        } catch (Exception e) {
            BradescoCommonServiceFactory.getLogManager().error("[ConnectorGcc.obterClasseNegocio] Erro  "+e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
        	BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.obterClasseNegocio] Fim");           

        }
    }

    /**
     * @param path
     *            {@link String}
     * @param documentClass
     *            {@link String}
     * @param documentTitle
     *            {@link String}
     * @param mimeType
     *            {@link String}
     * @param gccCdTipoDocIcor
     *            {@link String}
     * @param gccCdPessoaIcor
     *            {@link String}
     * @param gccNrIdentificacao
     *            {@link String}
     * @param fileBytes
     *            {@link File}
     * @return {@link String}
     */
    public String criarDocumento(String path, 
            String documentClass, 
            String documentTitle, 
            String mimeType,
            String gccCdTipoDocIcor, 
            String gccCdPessoaIcor, 
            String gccNrIdentificacao, 
            byte[] fileBytes) {
        try {
            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.criarDocumento] Início");

            ArrayOfXsdNillableString propriedades = new ArrayOfXsdNillableString();

            propriedades.getString().add("DocumentClass");
            propriedades.getString().add(documentClass);
            
            // Tratamento padrão GCC para nomenclatura dos arquivos
            Integer index = documentTitle.lastIndexOf('.');
            String extensao = documentTitle.substring(index);
            GCCFileNameGeneration fileNameGenerator = new GCCFileNameGeneration("F", extensao);
            documentTitle = fileNameGenerator.getFileName();

            propriedades.getString().add("DocumentTitle");
            propriedades.getString().add(documentTitle);

            propriedades.getString().add("MimeType");
            propriedades.getString().add(mimeType);

            propriedades.getString().add("GccCdTipoDocIcor");
            propriedades.getString().add("37");

            propriedades.getString().add("GccCdIdentificacao");
            propriedades.getString().add(gccCdPessoaIcor);

            propriedades.getString().add("GccNrIdentificacao");
            propriedades.getString().add(gccNrIdentificacao);

            propriedades.getString().add("GccCdDocGcc");
            propriedades.getString().add("37");

            propriedades.getString().add("GccCdProcesso");
            propriedades.getString().add("20");

            propriedades.getString().add("GccCdusuarioCaptura");
            propriedades.getString().add(user);

            ArrayOfXsdBase64Binary bytes = new ArrayOfXsdBase64Binary();
            bytes.getBase64Binary().add(fileBytes);

            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.criarDocumento] Dados do arquivo: "
                + " Usuario: " + user
                + " - Negocio: " + negocio
                + " - Path: " + this.path + path
                + " - Propriedades: " + propriedades.toString()
                + " - Bytes: " + bytes);
            
            String resposta = null;
            resposta = getIntegracaoFileNetCEImagemService()
                    .getIntegracaoFileNetCEImagem().criarDocumentoId(
                            user, 
                            password, 
                            negocio, 
                            this.path + path, 
                            propriedades, 
                            bytes);

            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.criarDocumento] resposta: " + resposta);
            
            System.out.println(Base64.encodeToString(fileBytes, false));
            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.criarDocumento] filebytes: " + Base64.encodeToString(fileBytes, false));

            return resposta;

        } catch (Throwable t) {
            BradescoCommonServiceFactory.getLogManager().error("[ConnectorGcc.criarDocumento] Não foi possível salvar o arquivo. " + t.getMessage());
            throw new NpccTradeWebException("Não foi possível salvar o arquivo.", "");
        } finally {
            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.criarDocumento] Fim");
        }
    }

    /**
     * @param documentTitle
     *            Nome do documento
     * @return {@link ArrayOfArrayOfXsdNillableString}
     */
    public ArrayOfArrayOfXsdNillableString pesquisarDocumentos(String documentTitle) {
        try {
            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.pesquisarDocumentos] Início");
            
            ArrayOfXsdNillableString whereProperties = new ArrayOfXsdNillableString();
            whereProperties.getString().add("DocumentTitle");
            whereProperties.getString().add(documentTitle);

            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.pesquisarDocumentos] Dados: "
            +" Usuario: "+user
            +" - Negocio:"+negocio
            +" - Path:"+this.path + path
            +" - Nome Documento:"+documentTitle);
            
            ArrayOfXsdNillableString propertiesReturn = new ArrayOfXsdNillableString();
            propertiesReturn.getString().add("GccDtCaptura");
            propertiesReturn.getString().add("DateCreated");
            propertiesReturn.getString().add("GccCdPessoaIcor");
            propertiesReturn.getString().add("GccNrIdentificacao");
            propertiesReturn.getString().add("GccCdTipoDocIcor");

            ArrayOfArrayOfXsdNillableString resposta = getIntegracaoFileNetCEImagemService()
                    .getIntegracaoFileNetCEImagem()
                    .consultarDocumentosSearchTemplate(
                            user, 
                            password, 
                            negocio,
                            "/GCC/BCAF/Search_Templates" + "/GccBCAFSearchNomeDocumento", 
                            whereProperties,
                            propertiesReturn);

            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.pesquisarDocumentos] resposta: " + resposta);
            
            return resposta;

        } catch (Exception e) {
            BradescoCommonServiceFactory.getLogManager().error("[ConnectorGcc.pesquisarDocumentos] Erro:. "+e.getMessage());
            e.printStackTrace();
        } finally {
            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.pesquisarDocumentos] Fim");
        }

        return null;
    }

    /**
     * @param value
     *            Caminho
     * @return {@link ArrayOfArrayOfXsdNillableString}
     */
    public ArrayOfArrayOfXsdNillableString pesquisarDocumentosPorPath(String value) {

        ArrayOfArrayOfXsdNillableString documentos = null;

        try {
        	BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.pesquisarDocumentosPorPath] Início");
            
            BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.pesquisarDocumentosPorPath] Dados: "
	            + " Usuario: " + user
	            + " - Negocio:" + negocio
	            + " - Path:" + this.path + value);
            
            ArrayOfXsdNillableString propertiesReturn = new ArrayOfXsdNillableString();
            propertiesReturn.getString().add("DateCreated");
            propertiesReturn.getString().add("Creator");
            
            documentos = getIntegracaoFileNetCEService().getIntegracaoFileNetCE().pesquisarDocumentosPorPath(user,
                    password, negocio, this.path + value, propertiesReturn);

            if (documentos == null) {
                documentos = new ArrayOfArrayOfXsdNillableString();
            }

        } catch (Throwable t) {
            BradescoCommonServiceFactory.getLogManager().error("[ConnectorGcc.pesquisarDocumentosPorPath] Erro:. "+t.getMessage());
            throw new NpccTradeException("Não foi possível listar os documentos", t);
        } finally {
        	BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.pesquisarDocumentosPorPath] Fim");
        }

        return documentos;
    }

    /**
     * @return {@link IntegracaoFileNetCEService}
     */
    private IntegracaoFileNetCEService getIntegracaoFileNetCEService() {
        
        try {
        	BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.getIntegracaoFileNetCEService] Início");
            
            integracaoFileNetCEService = new IntegracaoFileNetCEService(
                    new URL(filenetAddress + "?wsdl"), 
                    new QName("http://facade.filenet.bradesco.com.br", "IntegracaoFileNetCEService"));
            
        } catch (MalformedURLException e) {
            BradescoCommonServiceFactory.getLogManager().error("[ConnectorGcc.getIntegracaoFileNetCEService] Erro:. " + e.getMessage());
        } finally {
        	BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.getIntegracaoFileNetCEService] Fim");
        }

        return integracaoFileNetCEService;
    }

    /**
     * @return {@link IntegracaoFileNetCEImagemService}
     */
    private IntegracaoFileNetCEImagemService getIntegracaoFileNetCEImagemService() {
        
        try {
        	BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.getIntegracaoFileNetCEImagemService] Início");
        
            integracaoFileNetCEImagemService = new IntegracaoFileNetCEImagemService(
                    new URL(filenetImagemAddress + "?wsdl"),
                    new QName("http://facade.filenet.bradesco.com.br", "IntegracaoFileNetCEImagemService"));
            
        } catch (MalformedURLException e) {
            BradescoCommonServiceFactory.getLogManager().error("[ConnectorGcc.getIntegracaoFileNetCEImagemService] Erro:. " + e.getMessage());
        } finally {
        	BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.getIntegracaoFileNetCEImagemService] Fim");
        }

        return integracaoFileNetCEImagemService;
    }

    /**
     * @param value
     *            Caminho
     * @return {@link boolean}
     */
    public boolean verificarPastaExiste(String value) {

        Boolean result = false;

        try {
        	BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.verificarPastaExiste] Início");
            
        	BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.verificarPastaExiste] Dados: "+" - value: " + value);
            
            result = pesquisarDocumentosPorPath(value) != null;
            
        } catch (NpccTradeException e) {
            BradescoCommonServiceFactory.getLogManager().error("[ConnectorGcc.verificarPastaExiste] Erro:. " + e.getMessage());
        } catch (Exception e) {
        	BradescoCommonServiceFactory.getLogManager().error("[ConnectorGcc.verificarPastaExiste] Erro:. " + e.getMessage());
        } finally {
        	BradescoCommonServiceFactory.getLogManager().info("[ConnectorGcc.verificarPastaExiste] Fim");
        }

        return result;
    }

    /**
     * @return the filenetAddress
     */
    public String getFilenetAddress() {
        return filenetAddress;
    }

    /**
     * @param value
     *            the filenetAddress to set
     */
    public void setFilenetAddress(String value) {
        this.filenetAddress = value;
    }

    /**
     * @return the filenetImagemAddress
     */
    public String getFilenetImagemAddress() {
        return filenetImagemAddress;
    }

    /**
     * @param value
     *            the filenetImagemAddress to set
     */
    public void setFilenetImagemAddress(String value) {
        this.filenetImagemAddress = value;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param value
     *            the user to set
     */
    public void setUser(String value) {
        this.user = value;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param value
     *            the password to set
     */
    public void setPassword(String value) {
        this.password = value;
    }
    
//    /**
//     * 
//     * @return
//     */
//    private ILogManager getLogManager() {
//        return BradescoCommonServiceFactory.getLogManager();
//    }

    /**
     * @return o valor do className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className seta o novo valor para o campo className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return o valor do negocio
     */
    public String getNegocio() {
        return negocio;
    }

    /**
     * @param negocio seta o novo valor para o campo negocio
     */
    public void setNegocio(String negocio) {
        this.negocio = negocio;
    }

    /**
     * @return o valor do credencial
     */
    public Object getCredencial() {
        return credencial;
    }

    /**
     * @param credencial seta o novo valor para o campo credencial
     */
    public void setCredencial(Object credencial) {
        this.credencial = credencial;
    }

    /**
     * @return o valor do path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path seta o novo valor para o campo path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return o valor do gccCdPastaProcesso
     */
    public String getGccCdPastaProcesso() {
        return gccCdPastaProcesso;
    }

    /**
     * @param gccCdPastaProcesso seta o novo valor para o campo gccCdPastaProcesso
     */
    public void setGccCdPastaProcesso(String gccCdPastaProcesso) {
        this.gccCdPastaProcesso = gccCdPastaProcesso;
    }     
    
}
