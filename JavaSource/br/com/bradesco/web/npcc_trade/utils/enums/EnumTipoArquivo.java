package br.com.bradesco.web.npcc_trade.utils.enums;

public enum EnumTipoArquivo {

	/**
     * 
     */
	DEFAULT(""),
	/**
     * 
     */
    JPG("JPG"),
	
	/**
     * 
     */
    JPEG("JPEG"),
    
    /**
     * 
     */
    TIFF("TIFF"),
    
    /**
     * 
     */
    PDF("PDF"),
    
    /**
     * 
     */
    TIF("TIF");
    
    private String descricao;
    
    private EnumTipoArquivo(String descricao){
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumTipoArquivo fromCode(String code) {
        
        if(code.equals(JPG.descricao))
            return JPG;
        else if(code.equals(JPEG.descricao))
            return JPEG;
        else if(code.equals(TIFF.descricao))
            return TIFF;
        else if(code.equals(PDF.descricao))
            return PDF;
        else if(code.equals(TIF.descricao))
            return TIF;
        return DEFAULT;
    }
	
}
