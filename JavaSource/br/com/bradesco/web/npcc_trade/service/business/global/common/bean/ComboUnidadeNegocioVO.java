package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;

import br.com.bradesco.web.npcc_trade.utils.text.TextUtil;


public class ComboUnidadeNegocioVO {

	private Long cpssoajuridsubr = 0L;

	private Integer nsequndsubr = 0;

	private Integer cidtfdtpoundsubr = 0;

	private Integer crconhundsubrm = null;

	private Integer crconhundsubrf = null;

	private String irzscialsubr = null;

	private Integer ctpoundorgnzsubr = 0;

	private String itpoundorgnzsubr = null;

	public Long getCpssoajuridsubr() {
		return cpssoajuridsubr;
	}

	public void setCpssoajuridsubr(Long cpssoajuridsubr) {
		this.cpssoajuridsubr = cpssoajuridsubr;
	}

	public Integer getNsequndsubr() {
		return nsequndsubr;
	}

	public void setNsequndsubr(Integer nsequndsubr) {
		this.nsequndsubr = nsequndsubr;
	}

	public Integer getCidtfdtpoundsubr() {
		return cidtfdtpoundsubr;
	}

	public void setCidtfdtpoundsubr(Integer cidtfdtpoundsubr) {
		this.cidtfdtpoundsubr = cidtfdtpoundsubr;
	}

	public Integer getCrconhundsubrm() {
		return crconhundsubrm;
	}

	public void setCrconhundsubrm(Integer crconhundsubrm) {
		this.crconhundsubrm = crconhundsubrm;
	}

	public Integer getCrconhundsubrf() {
		return crconhundsubrf;
	}

	public void setCrconhundsubrf(Integer crconhundsubrf) {
		this.crconhundsubrf = crconhundsubrf;
	}

	public String getIrzscialsubr() {
		return irzscialsubr;
	}

	public void setIrzscialsubr(String irzscialsubr) {
		this.irzscialsubr = irzscialsubr;
	}

	public Integer getCtpoundorgnzsubr() {
		return ctpoundorgnzsubr;
	}

	public void setCtpoundorgnzsubr(Integer ctpoundorgnzsubr) {
		this.ctpoundorgnzsubr = ctpoundorgnzsubr;
	}

	public String getItpoundorgnzsubr() {
		return itpoundorgnzsubr;
	}

	public void setItpoundorgnzsubr(String itpoundorgnzsubr) {
		this.itpoundorgnzsubr = itpoundorgnzsubr;
	}	
	
	/** (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        
        if (crconhundsubrm != null && crconhundsubrf != null && irzscialsubr != null) {
            
            return String.format("%s/%s - %s", 
                            TextUtil.padLeft(crconhundsubrm.toString(), 6, "0"),
                            TextUtil.padLeft(crconhundsubrf.toString(), 6, "0"),
                            irzscialsubr);
            
        }else {
            return null;
        }
            
          
    }
}
