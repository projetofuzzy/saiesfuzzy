package br.ufrj.coppe.producao.seguranca;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import br.ufrj.coppe.producao.modelo.Usuario;

/**
 * Disponibiliza o usuário logado para o restante da  
 * aplicação.
 * 
 * @author William <b>Moreira</b> de Pinho - 1° Ten QCO
 * @version 1.0
 */
@Named
@SessionScoped
public class UsuarioCorrente implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuarioLogado;
	
	@Produces
	@Autenticado
	@Named("usuarioLogado")
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	/**
	 * Nome qualificado do usuário
	 * @return posto/graduação - nome guerra - assessoria
	 */
	public String getNomeQualificado() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(usuarioLogado.getPostoGraduacao().getValue());
		sb.append("  ");		
		sb.append(usuarioLogado.getNomeGuerra());		
		
		return sb.toString();
	}
	
	/**
	 * Listener de evento. Quando um usuário loga com sucesso este 
	 * listener disponibiliza o usuário em nível de aplicação e estabelece 
	 * tempo de expiração da sessão.
	 * @param user usuário autenticado
	 * @param request requisicao
	 */
	public void onLogin(@Observes @Autenticado Usuario user, HttpServletRequest request){
		
		usuarioLogado = user;
				
		request.getSession().setAttribute("usuarioLogado", user);
        request.getSession().setMaxInactiveInterval(3600);		
	}			
}