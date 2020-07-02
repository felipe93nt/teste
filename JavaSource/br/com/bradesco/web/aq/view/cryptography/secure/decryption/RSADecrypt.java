/**
 * Nome: br.com.bradesco.web.aq.view.cryptography.secure.decryption
 * Prop�sito: Classes de descriptografia
 * Data da Cria��o: 16/06/2015
 *
 * @author mauricio.sako / Capgemini
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Par�metros de Compila��o: -d
 */
package br.com.bradesco.web.aq.view.cryptography.secure.decryption;

import java.math.BigInteger;

import org.apache.commons.lang.StringUtils;

import br.com.bradesco.web.aq.application.property.config.ConfigPropertyManager;
import br.com.bradesco.web.aq.application.property.config.IConfigPropertyManager;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;

/**
 * Nome: RSADecrypt
 * Prop�sito: Classe que implementa a descriptografia usando o RSA <br/>
 * Data: 17/06/2015 <br/>
 *
 * @author mauricio.sako / Capgemini <br/>
 *         copyright Copyright (c) 2015 <br/>
 * @version 1.0
 * @see
 */
public class RSADecrypt implements IDecryptFunction {
    /** Representa o n�mero zero **/
    private static final String ZERO = "0";
    /** Representa o n�mero 256 **/
    private static final String DOIS_CINCO_SEIS = "256";
    /** Representa a chave de configura��o do atributo 'privateExponent' **/
    private static final String CRYPTO_CONF_RSA_EXPONENT = "crypto.conf.rsa.private_exponent";
    /** Representa a chave de configura��o do atributo 'modulus' **/
    private static final String CRYPTO_CONF_RSA_MODULUS = "crypto.conf.rsa.modulus";

    /**
     * Construtor padr�o
     */
    public RSADecrypt() {
    }

    /**
     * Nome: decrypt <br/>
     * Prop�sito: Descriptografa um texto com o RSA <br/>
     * Data: <18/06/2015> <br/>
     *
     * @author marlon.sagrilo / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param dataEnc
     * @return
     * @see br.com.bradesco.web.aq.view.cryptography.secure.decryption.IDecryptFunction#decrypt(byte[])
     */
    public byte[] decrypt(byte[] dataEnc) {
        IConfigPropertyManager confManager = BradescoCommonServiceFactory.getPropertieManager();
        /** Expoente da chave privada **/
        BigInteger privateExponent =
                new BigInteger(StringUtils.trim(confManager.getProperty(CRYPTO_CONF_RSA_EXPONENT,
                        ConfigPropertyManager.FILE_PROPERTY, false)), 16);
        /*
         * BigInteger privateExponent = new BigInteger(StringUtils
         * .trim(ApplicationPropertiesUtil
         * .getProperty(CRYPTO_CONF_RSA_EXPONENT)), 16);
         */
        /** M�dulo do par de chaves **/
        BigInteger modulus =
                new BigInteger(StringUtils.trim(confManager.getProperty(CRYPTO_CONF_RSA_MODULUS,
                        ConfigPropertyManager.FILE_PROPERTY, false)), 16);
        /*
         * BigInteger modulus = new BigInteger(StringUtils
         * .trim(ApplicationPropertiesUtil
         * .getProperty(CRYPTO_CONF_RSA_MODULUS)), 16);
         */
        /** Texto criptografado **/
        String encrypted = new String(dataEnc);
        /** Separa os blocos da cadeia criptografada **/
        String[] blocks = encrypted.split("\\s");
        /** Armazena o resultado **/
        String result = "";
        /** Verifica se a cadeia criptografada � vazia **/
        if (dataEnc == null || dataEnc.length <= 0) {
            return new byte[0];
        }
        try {
            /** Descriptografa bloco a bloco **/
            for (int i = 0; i < blocks.length; i++) {
                BigInteger data = new BigInteger(blocks[i], 16);
                BigInteger decryptedBlock = data.modPow(privateExponent, modulus);
                result += decodeBigIntToHex(decryptedBlock);
            }
        } catch (NumberFormatException e) {
            /**
             * Se n�o for uma cadeia v�lida, retorna o par�metro de entrada sem
             * descriptografar
             **/
            return dataEnc;
        }
        /** Verifica se a cadeia foi descriptografada com sucesso e a retorna **/
        return redundacyCheck(result).getBytes();
    }

    /**
     * Nome: decodeBigIntToHex <br/>
     * Prop�sito: Decodifica um BigInteger em uma string com o c�digo hexadecimal correspondente <br/>
     * Data: <18/06/2015> <br/>
     *
     * @author marlon.sagrilo / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param bigint
     * @return
     */
    private String decodeBigIntToHex(BigInteger bigint) {
        String message = "";
        BigInteger bigintCopia = bigint;
        /** Divide por 256 at� chega a 0 **/
        while (bigintCopia.compareTo(new BigInteger(ZERO)) != 0) {
            BigInteger ascii = bigintCopia.mod(new BigInteger(DOIS_CINCO_SEIS));
            bigintCopia = bigintCopia.divide(new BigInteger(DOIS_CINCO_SEIS));
            message += (char) (ascii.intValue());
        }
        return message;
    }

    /**
     * Nome: redundacyCheck <br/>
     * Prop�sito: Remove o c�digo de redund�ncia da string e valida <br/>
     * Data: <18/06/2015> <br/>
     *
     * @author marlon.sagrilo / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param string
     * @return
     */
    private String redundacyCheck(String string) {
        String r1 = string.substring(0, 2);
        String r2 = string.substring(2);
        int check = Integer.parseInt(r1, 16);
        String value = r2;
        int sum = 0;
        int length = value.length();
        /** Calcula o c�digo de redund�ncia **/
        for (int i = 0; i < length; i++) {
            sum += value.charAt(i);
        }
        /** Verifica o c�digo de redund�ncia **/
        if (check == (sum & 0xFF)) {
            return value;
        } else {
            return null;
        }
    }
}
