package br.ufrj.coppe.producao.modelo;

import java.io.Serializable;

/**
 * Classe base para todos os modelos do sistema
 * 
 * @author William <b>Moreira</b> de Pinho - 1° Ten QCO
 * @version 1.0
 *
 * @param <T> Tipo do identificador
 */
public abstract class BaseModel<T extends Serializable> {

	/**
	 * Identificador de tabela. Código sequencial
	 * @return chave primária da obrigação
	 */			
	public abstract T getId();
	
}