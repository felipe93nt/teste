/**
*
* Nome: GCCFileNameGeneration.java
* Propósito: <p> </p>
*
* @author :  BRQ <BR>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compilação -d
*
* @see : Referencias externas. 
*
* Registro  de Manutenção: 14/12/2016
*	- Autor: BRQ
*	- Responsavel: Equipe Web
*	_ Ajuste para deixar no padrão hexavision.
*/
package br.com.bradesco.web.npcc_trade.service.gcc;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * Nome: GCCFileNameGeneration.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ <BR>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 14/12/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class GCCFileNameGeneration {

    private String fileName;
    
    /**
    *
    * @param lado - F = Frente, V = Verso
    * @param ext - tipo de arquivo
    */
    public GCCFileNameGeneration(String lado, String ext) {
          generation(lado, ext);
    }

    public String getFileName() {
          return fileName;
    }

    /*
    *
     */
    private void generation(String lado, String ext) {
          StringBuffer result = new StringBuffer();
          InetAddress iaddr = null;
          String machineName = "";
          long currentTimeMillis = System.currentTimeMillis();
          int count = 1;

          try {
                 iaddr = InetAddress.getLocalHost();
                 machineName = iaddr.getHostName();
          } catch (UnknownHostException e) {
                 e.printStackTrace();
          } finally {
                 result.append(lado);
                 result.append(String.valueOf(currentTimeMillis));
                 result.append(machineName);
                 result.append(String.valueOf(count));
                 result.append(ext);
          }

          fileName = result.toString();
    }
}
