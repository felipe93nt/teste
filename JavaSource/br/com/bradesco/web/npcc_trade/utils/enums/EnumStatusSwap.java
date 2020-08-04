package br.com.bradesco.web.npcc_trade.utils.enums;

import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

public enum EnumStatusSwap {

    /**
    * 
    */
   EM_SER(Numeros.UM, "Em ser"),
   
   /**
    * 
    */
   BAIXADO(Numeros.DOIS, "Baixado"),

   /**
    * 
    */
   DEFAULT(Numeros.ZERO, " ");
   
   private Integer codigo;
   
   private String descricao;

       /**
        * Construtor
        * 
        * @param @param arg0
        * @param @param arg1
        */
   private EnumStatusSwap(Integer codigo, String descricao){
       this.codigo = codigo;
       this.descricao = descricao;
   }
   
   /**
    * @param codigo
    * @return
    */
   public static EnumStatusSwap fromCode(int code) {
       switch(code) {
       case 1:
           return EM_SER;
       case 2:
           return BAIXADO;
       default:
           return DEFAULT;
       }
   }
   
   /**
    * @param codigo
    * @return
    */
   public static EnumStatusSwap fromCode(String code) {
       switch(SiteUtil.getInt(code)) {
       case 1:
           return EM_SER;
       case 2:
           return BAIXADO;
       default:
           return DEFAULT;
       }
   }   
   
   /**
    * @return descrição
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
