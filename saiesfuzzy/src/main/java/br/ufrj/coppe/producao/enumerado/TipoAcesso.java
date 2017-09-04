package br.ufrj.coppe.producao.enumerado;

/**
 * Enumerado para definição dos perfis do usuário<p/>
 * 
 * <b>USUARIO</b> - Usuário de sistema, possui permissão para inserir obrigações 
 * apenas em sua assessoria <p/>
 * <b>ADMINISTRADOR</b> - Administrador, possui permissão para liberar acesso para 
 * usuários do sistema <p/>
 * 
 * @author William <b>Moreira</b> de Pinho - 1º Ten QCO
 * @version 1.1 (Incluído perfil AUDITORIO)
 */
public enum TipoAcesso {
	USUARIO,
	ADMINISTRADOR
}