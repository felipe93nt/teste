package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean;

/**
  * Nome: DesenquadramentoCreditoVO.java
  * 
  * Propósito: <p> </p>
  *
  * @author :  BRQ - Francinaldo
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 20/05/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public class DesenquadramentoCreditoVO {
    
    /* DESC-CRED     PIC  X(020). */
    private String desccred = null;

    /* VMOTVO-SOLIC  PIC  X(022). */
    private String vmotvosolic = null;

    /* VMOTVO-DISP   PIC  X(022). */
    private String vmotvodisp = null;
    
    /**
     * Construtor
     * 
     * @param 
     */
    public DesenquadramentoCreditoVO() {
        super();
    }

    /**
     * @return o valor do desccred
     */
    public String getDesccred() {
        return desccred;
    }

    /**
     * @param desccred seta o novo valor para o campo desccred
     */
    public void setDesccred(String desccred) {
        this.desccred = desccred;
    }

    /**
     * @return o valor do vmotvosolic
     */
    public String getVmotvosolic() {
        return vmotvosolic;
    }

    /**
     * @param vmotvosolic seta o novo valor para o campo vmotvosolic
     */
    public void setVmotvosolic(String vmotvosolic) {
        this.vmotvosolic = vmotvosolic;
    }

    /**
     * @return o valor do vmotvodisp
     */
    public String getVmotvodisp() {
        return vmotvodisp;
    }

    /**
     * @param vmotvodisp seta o novo valor para o campo vmotvodisp
     */
    public void setVmotvodisp(String vmotvodisp) {
        this.vmotvodisp = vmotvodisp;
    }
}
