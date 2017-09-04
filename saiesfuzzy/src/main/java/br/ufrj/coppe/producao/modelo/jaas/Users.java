package br.ufrj.coppe.producao.modelo.jaas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import br.ufrj.coppe.producao.enumerado.TipoAcesso;
import br.ufrj.coppe.producao.modelo.BaseModel;

/**
 * Classe de apoio para funcionamento do JAAS.<br/>
 * Após a liberação do usuário pelo administrador, é criado 
 * um users em conformidade com a especificação JAAS. No momento da 
 * criação a senha do usuário é igual ao username. O usuário 
 * possui uma funcionalidade para troca de senha.
 * 
 * @author William <b>Moreira</b> de Pinho - 1° Ten QCO
 * @version 1.0
 */
@Entity
@Table(name="users")
public class Users extends BaseModel<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_name")
	private String name;
	
	@Column(name="user_pass")
	private String pass;

	@OneToMany(mappedBy="users", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	private List<UserRoles> roles;
	
	/**
	 * UserName do usuário, convencionado para identidade
	 * @return identidade do usuário
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Senha do usuário
	 * @return senha do usuário
	 */
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/**
	 * Perfis do usuário. USUARIO e/ou ADMINISTRADOR
	 * @return perfis do usuário
	 */
	public List<UserRoles> getRoles() {
		return roles;
	}
	public void setRoles(List<UserRoles> roles) {
		this.roles = roles;
	}
	
	/**
	 * Propriedade não utilizada
	 */
	@Override
	public Long getId(){
		return null;
	}	
	
	/**
	 * Inicializa lista de perfis
	 */
	public Users() {
		roles = new ArrayList<UserRoles>();		
	}	
	public Users(String name) {
		this.name = name;
	}		
	public Users(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}	
	
	/**
	 * Adiciona um novo perfil
	 * @param acesso tipo do perfil
	 */
	public void addRole(TipoAcesso acesso) {				
		roles.add(new UserRoles(this, acesso));		
	}	
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Users))
			return false;
		Users other = (Users) obj;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Users [name=" + name + "]";
	}	
}