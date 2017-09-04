package br.ufrj.coppe.producao.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import br.ufrj.coppe.producao.enumerado.PostoGraduacao;
import br.ufrj.coppe.producao.enumerado.TipoAcesso;
import br.ufrj.coppe.producao.modelo.jaas.Users;
import br.ufrj.coppe.producao.util.EncodingSHA256;

/**
 * Usuarios habilitados a entrar com registros no 
 * Calendário de Obrigações.
 * 
 * @author William <b>Moreira</b> de Pinho - 1º Ten QCO
 * @version 1.0
 */
@Entity
public class Usuario extends BaseModel<Long> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_ID_GENERATOR", sequenceName="USUARIO_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_ID_GENERATOR")	
	private Long id;
		
	@Column(unique=true)
	private String identidade;
	
	@Column
	private String nome;
	
	@Column
	private String nomeGuerra;
	
	@Enumerated(EnumType.STRING)
	private PostoGraduacao postoGraduacao;
			
	@Column
	private Boolean liberado;
		
	public Usuario(){
		liberado = Boolean.FALSE;
	}
	
	/**
	 * Identificador de tabela. Código sequencial
	 * @return chave primária da ação orçamentária 
	 */	
	@Override
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Identidade do militar
	 * @return identidade do militar 
	 */	
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	/**
	 * Nome do militar
	 * @return nome do militar 
	 */
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Nome de guerra do militar
	 * @return nome de guerra do militar
	 */
	public String getNomeGuerra() {
		return nomeGuerra;
	}
	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}

	/**
	 * Posto/Graduação do militar
	 * @return posto/graduação do militar
	 */
	public PostoGraduacao getPostoGraduacao() {
		return postoGraduacao;
	}
	public void setPostoGraduacao(PostoGraduacao postoGraduacao) {
		this.postoGraduacao = postoGraduacao;
	}
			
	/**
	 * Indica liberação para acesso ao sistema
	 * @return true-> Acesso liberado <br/>false-> Acesso negado
	 */
	public Boolean getLiberado() {
		return liberado;
	}
	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}

	/**
	 * Realiza parse para usuário JAAS. Na liberação do usuário 
	 * para acesso ao sistema, por convenção a senha será a identidade 
	 * criptografada
	 * 
	 * @return parse para usuário JAAS
	 */
	public Users parseUsers() {
		
		Users users = new Users();
		
		users.setName(identidade);
		users.addRole(TipoAcesso.USUARIO);
		users.setPass(EncodingSHA256.encodingBase64(identidade));
			
		return users;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identidade == null) ? 0 : identidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (getIdentidade() == null) {
			if (other.getIdentidade() != null)
				return false;
		} else if (!getIdentidade().equals(other.getIdentidade()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [identidade=" + identidade + ", nomeGuerra=" + nomeGuerra + "]";
	}	
}