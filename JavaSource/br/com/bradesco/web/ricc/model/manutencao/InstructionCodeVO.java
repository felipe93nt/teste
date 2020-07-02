package br.com.bradesco.web.ricc.model.manutencao;

import br.com.bradesco.web.ricc.model.manutencao.InstructionCodeVO;

public class InstructionCodeVO implements Comparable<InstructionCodeVO> {

	// Campos tabela
	private String occur = "";
	private String code = "";
	private String instruction = "";

	@Override
	public int compareTo(InstructionCodeVO o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getOccur() {
		return occur;
	}

	public void setOccur(String occur) {
		this.occur = occur;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

}
