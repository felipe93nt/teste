package br.com.bradesco.web.npcc_trade.utils.components;


import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumCadastroNacionalPessoa;
import br.com.bradesco.web.npcc_trade.utils.text.TextUtil;

/**
  * <b>Nome:</b> <p> CadastroNacionalPessoa.java </p>
  * 
  * <b>Prop�sito:</b> <p> Representa��o dos cadastros de pessoa f�sica (CPF) ou jur�dica (CNPJ). 
  * Possui formata��o, valida��o e funcionalidade de apresenta��o em array. </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR/>
  * @version:  1.5
  *          Parametro  de compila��o -d
  *
  *
  * Registro  de Manuten��o: 11/04/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padr�o hexavision.
*/
public class CadastroNacionalPessoa implements Cloneable, Comparable<CadastroNacionalPessoa> {
    private int base;
    private int filial;
    private int digito;
    private EnumCadastroNacionalPessoa tipoPessoa;
    
    /**
     * Nome: split
     * 
     * Prop�sito: Separar um CPF ou CNPJ em tr�s blocos base, que ser�o utilizados para maniula��o/valida��o dos dados.
     *
     * @param : Texto que represente um CPF ou CNPJ. Este pode conter os separadores ".", "-" e/ou "/".
     * @return : Um array de 3 posi��es, que s�o respectivamente Base, Filial e Digito.
     * @throws :
     * @exception : 
     *
     * Registro  de Manuten��o: 11/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public static int[] split(String cpfCnpj) {
        int[] blocos = new int[3];
        
     // Verifica se o argumento � valido
        if (cpfCnpj != null && cpfCnpj.trim().length() > 0) {
            Long valorNumerico = SiteUtil.getLong(cpfCnpj.trim().replace(".",  "").replace("-", "").replace("/", ""));
            
            // Verifica se o valor � um cnpj
            if (valorNumerico > 99999999999L) {
                String valorTexto = TextUtil.padLeft(valorNumerico.toString(), 15, "0");
                
                // Base
                blocos[0] = Integer.valueOf(valorTexto.substring(0, 9));
                // Filial
                blocos[1] = Integer.valueOf(valorTexto.substring(9, 13));
                // Digito
                blocos[2] = Integer.valueOf(valorTexto.substring(13, 15));
            } else if (valorNumerico > 0) {
                String valorTexto = TextUtil.padLeft(valorNumerico.toString(), 11, "0");
                
                // Base
                blocos[0] = Integer.valueOf(valorTexto.substring(0, 9));                
                // Digito
                blocos[2] = Integer.valueOf(valorTexto.substring(9, 11));
            } else {
                // Base
                blocos[0] = 0;                
                // Filial
                blocos[1] = 0;                
                // Digito
                blocos[2] = 0;
            }
        }
        
        return blocos;
    }

    /**
     * Nome: format
     * 
     * Prop�sito: Formata um CPF ou CNPJ nos respectivos padr�es, xxx.xxx.xxx-xx e xx.xxx.xxx/xxxx-xx.
     *
     * @param : Texto que represente um CPF ou CNPJ. Este pode conter os separadores ".", "-" e/ou "/". 
     * @return : Verdadeiro caso seja um CPF ou CNPJ v�lido e Falso do contr�rio.
     * @throws :
     * @exception : 
     *
     * Registro  de Manuten��o: 11/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public static String format(String cpfCnpj) {
        int[] blocos = split(cpfCnpj);
        
        return format(blocos[0], blocos[1], blocos[2]);
    }
    
    /**
     * Nome: format
     * 
     * Prop�sito: Formata um CPF ou CNPJ nos respectivos padr�es, xxx.xxx.xxx-xx e xx.xxx.xxx/xxxx-xx.
     *
     * @param : Base do CPF. Nove primeiros d�gitos.
     * @param : Digito de verifica��o.
     * @return : Verdadeiro caso seja um CPF ou CNPJ v�lido e Falso do contr�rio.
     * @throws :
     * @exception : 
     *
     * Registro  de Manuten��o: 11/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public static String format(int base, int digito) {
        return format(base, 0, digito);
    }
    
    /**
     * Nome: format
     * 
     * Prop�sito: Formata um CPF ou CNPJ nos respectivos padr�es, xxx.xxx.xxx-xx e xx.xxx.xxx/xxxx-xx.
     *
     * @param : Base do CPF ou CNPJ. Novo primeiros d�gitos.
     * @param : C�digo da filial. Caso esse campo seja zero adota-se o comportamento de um CPF.
     * @param : Digito de verifica��o
     * @return : Verdadeiro caso seja um CPF ou CNPJ v�lido e Falso do contr�rio.
     * @throws :
     * @exception : 
     *
     * Registro  de Manuten��o: 11/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public static String format(int base, int filial, int digito) {
        // A base � obrigat�rio para indicar que � um cpf ou cnpj
        if (base > 0) {
            StringBuffer builder = new StringBuffer();
            String baseString = TextUtil.padLeft(String.valueOf(base), 9, "0");
            
            // Inclui os pontos na base do cpf ou cnpj
            for (int i = 0; i < baseString.length(); i++) {
                // Verifica se deve colocar o ponto a cada 3 digitos
                if (i > 0 && i % 3 == 0) {
                    builder.append(".");
                }
                
                builder.append(baseString.charAt(i));
            }
            
            // Verifica se deve incluir o campo de filial
            if (filial > 0) {
                // Caso seja uma pessoa juridica remove o primeiro zero � esquerda
                builder.delete(0, 1);
                builder.append("/");
                builder.append(TextUtil.padLeft(String.valueOf(filial), 4, "0"));
            }
            
            builder.append("-");
            builder.append(TextUtil.padLeft(String.valueOf(digito), 2, "0"));

            return builder.toString();
        } else {
            return null;
        }
    }
    
    /**
     * Nome: isValid
     * 
     * Prop�sito: Verifica os d�gitos verificadores e valida o CPF ou CNPJ.
     *
     * @param : Texto que represente um CPF ou CNPJ. Este pode conter os separadores ".", "-" e/ou "/". 
     * @return : Verdadeiro caso seja um CPF ou CNPJ v�lido e Falso do contr�rio.
     * @throws :
     * @exception : 
     *
     * Registro  de Manuten��o: 11/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public static boolean isValid(String cpfCnpj) {
        boolean valido = false;
        int[] blocos = split(cpfCnpj);
        int[] pesoPessoaFisica = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesoPessoaJuridica = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        
        // Verifica se o valor � v�lido para continuar
        if (blocos[0] > 0) {
            int[] peso = blocos[1] > 0 ? pesoPessoaJuridica : pesoPessoaFisica;
            int primeiroDigito = 0;
            int segundoDigito = 0;
            int digitoCalculado = 0;
            
            primeiroDigito = calcularDigito(blocos[0], peso);
            segundoDigito = calcularDigito(blocos[0], primeiroDigito, peso);
            
            digitoCalculado = Integer.valueOf(String.valueOf(primeiroDigito).concat(String.valueOf(segundoDigito)));
            
            valido = digitoCalculado == blocos[2];
        }
        
        return valido;
    }
        
    /**
     * Nome: isValid
     * 
     * Prop�sito: Verifica os d�gitos verificadores e valida o CPF ou CNPJ.
     *
     * @param : Base do CPF. Nove primeiros d�gitos.
     * @param : Digito de verifica��o.
     * @return : Verdadeiro caso seja um CPF ou CNPJ v�lido e Falso do contr�rio.
     * @throws :
     * @exception : 
     *
     * Registro  de Manuten��o: 11/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public static boolean isValid(int base, int digito) {
        // Verifica se o valor � v�lido
        if (base <= 0) {
            return false;
        } else {
            return isValid(format(base, digito));
        }
    }
    
    /**
     * Nome: isValid
     * 
     * Prop�sito: Verifica os d�gitos verificadores e valida o CPF ou CNPJ.
     *
     * @param : Base do CPF ou CNPJ. Novo primeiros d�gitos.
     * @param : C�digo da filial. Caso esse campo seja zero adota-se o comportamento de um CPF.
     * @param : Digito de verifica��o
     * @return : Verdadeiro caso seja um CPF ou CNPJ v�lido e Falso do contr�rio.
     * @throws :
     * @exception : 
     *
     * Registro  de Manuten��o: 11/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public static boolean isValid(int base, int filial, int digito) {
        // Verifica se o valor � v�lido
        if (base <= 0) {
            return false;
        } else {
            
            return isValid(format(base, filial, digito));
        }
    }
    
    private static int calcularDigito(String base, int[] peso) {
        int soma = 0;
        int length = base.length();
        int baseIndex = base.length() - 1;
        
        // Percorre toda a base afim de calcular o 
        for (; baseIndex > -1; baseIndex--) {
            int digito = Integer.valueOf(base.substring(baseIndex, baseIndex + 1));
            int pesoIndex = peso.length - length + baseIndex;
            
            soma += digito * peso[pesoIndex];
        }
        
        soma = 11 - soma % 11;
        
        return soma > 9 ? 0 : soma;
    }
    
    private static int calcularDigito(int base, int[] peso) {
        String baseTexto = String.valueOf(base);
        
        return calcularDigito(baseTexto, peso);
    }
    
    private static int calcularDigito(int base, int digito, int[] peso) {
        String baseTexto = String.valueOf(base).concat(String.valueOf(digito));
        
        return calcularDigito(baseTexto, peso);
    }
    
    /**
     * Construtor
     * 
     *@param @param Texto que represente um CPF ou CNPJ. Este pode conter os separadores ".", "-" e/ou "/".
     */
    public CadastroNacionalPessoa(String cpfCnpj) {
        // Verifica se o argumento � valido
        if (cpfCnpj == null || cpfCnpj.trim().length() == 0) {
            throw new IllegalArgumentException("O par�metro 'cpfCnpj' n�o pode ser nulo ou vazio.");
        }

        int[] blocos = split(cpfCnpj);
        
        this.base = blocos[0];
        this.filial = blocos[1];
        this.digito = blocos[2];
        this.tipoPessoa = this.filial > 0 ? EnumCadastroNacionalPessoa.JURIDICA : EnumCadastroNacionalPessoa.FISICA;
    }

    /**
     * Construtor
     * 
     * @param @param Base do CPF. Nove primeiros d�gitos.
     * @param @param Digito de verifica��o.
     */
    public CadastroNacionalPessoa(int base, int digito) {
        // Verifica se o argumento � valido
        if (base <= 0) {
            throw new IllegalArgumentException("O par�metro 'base' n�o pode ser menor ou igual � zero.");
        }
        
        this.base = base;
        this.filial = 0;
        this.digito = digito;
        this.tipoPessoa = EnumCadastroNacionalPessoa.FISICA;
    }

    /**
     * Construtor
     * 
     * @param @param Base do CPF ou CNPJ. Novo primeiros d�gitos.
     * @param @param C�digo da filial. Caso esse campo seja zero adota-se o comportamento de um CPF.
     * @param @param Digito de verifica��o
     */
    public CadastroNacionalPessoa(int base, int filial, int digito) {
        // Verifica se o argumento � valido
        if (base <= 0) {
            throw new IllegalArgumentException("O par�metro 'base' n�o pode ser menor ou igual � zero.");
        }
        
        this.base = base;
        this.filial = filial;
        this.digito = digito;
        this.tipoPessoa = filial > 0 ? EnumCadastroNacionalPessoa.JURIDICA : EnumCadastroNacionalPessoa.FISICA;
    }

    /**
     * @return o valor do base
     */
    public int getBase() {
        return base;
    }

    /**
     * @return o valor do filial
     */
    public int getFilial() {
        return filial;
    }

    /**
     * @return o valor do digito
     */
    public int getDigito() {
        return digito;
    }

    /**
     * @return o valor do tipoPessoa
     */
    public EnumCadastroNacionalPessoa getTipoPessoa() {
        return tipoPessoa;
    }
    
    /**
     * @return Retorna true caso o cpf ou cnpj seja v�lido
     */
    public boolean isValid() {
        // Verifica o tipo de pessoa para validar
        if (this.tipoPessoa == EnumCadastroNacionalPessoa.FISICA) {
            return isValid(getBase(), getDigito());
        } else if (this.tipoPessoa == EnumCadastroNacionalPessoa.JURIDICA) {
            return isValid(getBase(), getFilial(), getDigito());
        } else {
            return false;
        }
    }
    
    /**
     * Nome: copy
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 11/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public CadastroNacionalPessoa copy() {
        try {
            return (CadastroNacionalPessoa)this.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
    @Override
    public String toString() {
        return format(getBase(), getFilial(), getDigito());
    }

    @Override
    public boolean equals(Object otherObject) {
        // Verifica se o objeto n�o � nulo ou se h� dados para comparar
        if (otherObject == null || this.toString() == null || this.toString().isEmpty()) {
            return false;
        }
        
        // Verifica se o objeto passado � uma instancia v�lida para comparar
        if (otherObject instanceof CadastroNacionalPessoa) {
            CadastroNacionalPessoa cadastroNacionalPessoa = (CadastroNacionalPessoa)otherObject;
            
            return this.toString().equals(cadastroNacionalPessoa.toString());
        } else {
            return false;
        }
    };

    @Override
    public int compareTo(CadastroNacionalPessoa next) {
        // Verifica se possui valor antes de fazer a compara��o
        if (this.toString() != null) {
            return this.toString().compareToIgnoreCase(next.toString());
        } else {
            return -1;
        }
    }
}
