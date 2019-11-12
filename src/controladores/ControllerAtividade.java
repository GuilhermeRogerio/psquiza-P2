package controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modulos.Atividade;
import util.Validador;


/**
 * Controller da atividade. 
 * 
 * @author matheusfls-ccc (Matheus Filipe de Lima Souza)
 *
 */
public class ControllerAtividade {
	
	/**
	 * Mapa que guarda as atividades cadastradas.
	 */
	private HashMap<String, Atividade> atividades;
	
	/**
	 * Validador, que verifica os parâmetros dos métodos para tratamento. 
	 */
	private Validador validador;
	
	/**
	 * Código utilizado para identificar as atividades.
	 */
	private int codigo;
	
	
	/**
	 * Construtor do controller, que será utilizado pelo controller geral. 
	 */
	public ControllerAtividade() {
		this.atividades = new HashMap<>();
		this.validador = new Validador();
		this.codigo = 1;
	}
	
	
	/**
	 * Método que cadastra a atividade no sistema. 
	 * 
	 * @param descricao - Objetivo da atividade
	 * @param nivelRisco - Nivel de risco que a atividade apresenta
	 * @param descricaoRisco - Descrição que explica o nivel de risco apresentado
	 * @return Código da atividade que acabou de ser cadastrada
	 */
	public String cadastraAtividade(String descricao, String nivelRisco, String descricaoRisco) {
		this.validador.valida(descricao, "Campo Descricao nao pode ser nulo ou vazio.");
		this.validador.valida(nivelRisco, "Campo nivelRisco nao pode ser nulo ou vazio.");
		this.validador.valida(descricaoRisco, "Campo descricaoRisco nao pode ser nulo ou vazio.");
		this.validador.validaNivelRisco(nivelRisco, "Valor invalido do nivel do risco.");
		Atividade atividade = new Atividade(descricao, nivelRisco, descricaoRisco);
		atividade.concatenaCodigo(this.codigo);
		this.atividades.put((atividade.getCodigo()), atividade);
		this.codigo += 1;
		return atividade.getCodigo();
	}
	
	/**
	 * Método responsável por apagar uma atividade do sistema. 
	 * 
	 * @param codigo - Código da atividade a ser apagada. 
	 */
	public void apagaAtividade(String codigo) {
		this.validador.valida(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		if (!this.atividades.containsKey(codigo)) {
			throw new IllegalArgumentException("Atividade nao encontrada");
		} else {
			this.atividades.remove(codigo);
		}
		
	}
	
	
	/**
	 * Método que cadastra um item à atividade indicada. 
	 * 
	 * @param codigo - Código da atividade
	 * @param item - Código do item a ser cadastrado. 
	 */
	public void cadastraItem(String codigo, String item) {
		this.validador.valida(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		this.validador.valida(item, "Item nao pode ser nulo ou vazio.");
		if (!this.atividades.containsKey(codigo)) {
			throw new IllegalArgumentException("Atividade nao encontrada");
		} else {
			this.atividades.get(codigo).cadastraItem(item);
		}
	}
	
	
	/**
	 * Exibe informações sobre a atividade e seus respectivos itens.
	 * 
	 * @param codigo - Código da atividade que se deseja
	 * @return - Representação textual da atividade. 
	 */
	public String exibeAtividade(String codigo) {
		this.validador.valida(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		if (!this.atividades.containsKey(codigo)) {
			throw new IllegalArgumentException("Atividade nao encontrada");
		} else {
			return this.atividades.get(codigo).toString();
		}
	}
	
	/**
	 * Retorna quantos itens ainda estão pendentes na atividade. 
	 * 
	 * @param codigo - Código da atividade
	 * @return - Quantia de itens pendentes. 
	 */
	public int contaItensPendentes(String codigo) {
		this.validador.valida(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		if (!this.atividades.containsKey(codigo)) {
			throw new IllegalArgumentException("Atividade nao encontrada");
		} else {
			return this.atividades.get(codigo).contaItensPendentes();
		}
	}
	
	
	/**
	 * Retorna quantos itens já foram realizados na atividade.
	 * 
	 * @param codigo - Código da atividade
	 * @return - Quantia de itens resolvidos. 
	 */
	public int contaItensRealizados(String codigo) {
		this.validador.valida(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		if (!this.atividades.containsKey(codigo)) {
			throw new IllegalArgumentException("Atividade nao encontrada");
		} else {
			return this.atividades.get(codigo).contaItensRealizados();
		}
	}


	/**
     * Método retorna um Lista de atividades cadastradas
     * 
     * @return List<Atividade>
     */
    public List<Atividade> getaAtividades() {
    	
    	List<Atividade> listAtividade = new ArrayList<>();
    	
    	for (String key : this.atividades.keySet()) 
			listAtividade.add(this.atividades.get(key));
		
    	
		return listAtividade;
	}
	
	

}