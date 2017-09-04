package br.ufrj.coppe.producao.enumerado;

/**
 * Enumerado dos Postos e Graduações das 
 * Forças Armadas
 * 
 * @author William Moreira de Pinho - 1º Ten QCO
 * @version 1.0
 */
public enum PostoGraduacao {

	GEN_EXERCITO("Gen Ex"),
	GEN_DIVISAO("Gen Div"),
	GEN_BRIGADA("Gen Bda"),
	CORONEL("Cel"),
	TEN_CORONEL("Ten Cel"),
	MAJOR("Maj"),
	CAPITAO("Cap"),
	PRI_TENENTE("1º Ten"),
	SEG_TENENTE("2º Ten"),
	ASP("Asp"),
	SUBTENENTE("ST"),
	PRI_SARGENTO("1º SGT"),
	SEG_SARGENTO("2º SGT"),
	TER_SARGENTO("3º SGT"),
	CABO("Cabo"),
	SOLDADO("Soldado");
	
	private String value;
	
	private PostoGraduacao(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}