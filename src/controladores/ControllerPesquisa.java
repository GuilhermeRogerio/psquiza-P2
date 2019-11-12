package controladores;

import java.util.HashMap;

import modulos.Objetivo;
import modulos.Pesquisa;
import modulos.Problema;
import util.Validador;

public class ControllerPesquisa {

    /**
     * Verificador das entradas para o tratamento.
     *
     */
    private Validador validador;

    /**
     * Mapa onde os pesquisas serão armazenados para as operações do sistema.
     * 
     */
    private HashMap<String, Pesquisa> pesquisas;

    /**
     * Construtor do mapa e do verificador do validador.
     */
    public ControllerPesquisa() {
        this.validador = new Validador();
        this.pesquisas = new HashMap<String, Pesquisa>();
    }

    /**
	 * Método das pesquisas a serem cadastrados
	 * @author adyssonfs 
	 * @param descricao: resumo descritivo da pesquisa
	 * @param campoDeInteresse: areas que são abrangidas pela pesquisa. 
	 * A entrada deve ser até 255 caracteres. Cada area é separada por vírgula  
	 * */
    public String cadastraPesquisa(String descricao, String campoDeInteresse) {

        this.validador.valida(descricao, "Descricao nao pode ser nula ou vazia.");
        this.validador.validaTamanhoEntrada(campoDeInteresse, "Formato do campo de interesse invalido.");

        Pesquisa pesquisa = new Pesquisa(descricao, campoDeInteresse);

        String codigoPesquisa = this.geraCodigo(campoDeInteresse);
        pesquisa.setCodigo(codigoPesquisa);
        this.pesquisas.put(codigoPesquisa, pesquisa);
        return codigoPesquisa;
    }

    /**
	 * Método retorna codigo para uma pesquisa baseado no campo de interesse
     * 
	 * @author adyssonfs  
     * @param campoDeInteresse
     * @return String
	 * */
	private String geraCodigo(String campoDeInteresse) {

		int count = 1;
		String codigo = campoDeInteresse.substring(0, 3).toUpperCase();

		for (String key : pesquisas.keySet()) {

            String precode = pesquisas.get(key).getCodigo().substring(0, 3).toUpperCase();
						
			if (precode.equals(codigo))
				count++;
		}

        codigo += String.valueOf(count);
        return codigo;
	}

    /**
	 * Método usado para a alteração em pesquisa
	 * @author adyssonfs 
	 * @param codigo: identificador da pesquisa
	 * @param conteudoASerAlterado: pode ser "CAMPO" ou "DESCRICAO"
	 * */
    public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {

        this.validador.validaAtributo(conteudoASerAlterado, "Nao e possivel alterar esse valor de pesquisa.");

        if (!pesquisas.containsKey(codigo))
            throw new IllegalArgumentException("Pesquisa nao encontrada.");

        Pesquisa pesquisa = this.pesquisas.get(codigo);

        if (!pesquisa.getAtiva())
            throw new Error("Pesquisa desativada.");

        if (conteudoASerAlterado.equals("CAMPO")) {
            this.validador.valida(novoConteudo, "Formato do campo de interesse invalido.");
            pesquisa.setCamposInteresse(novoConteudo);
        } else {
            this.validador.valida(novoConteudo, "Descricao nao pode ser nula ou vazia.");
            pesquisa.setDescricao(novoConteudo);
        }
    }

    /**
	 * Método para efetuar o encerramento de uma pesquisa
	 * @author adyssonfs 
	 * @param codigo: identificador da pesquisa
	 * @param motivo: motivação para o encerramento da pesquisa"
	 * */
    public void encerraPesquisa(String codigo, String motivo) {

        this.validador.valida(motivo, "Motivo nao pode ser nulo ou vazio.");

        if (!pesquisas.containsKey(codigo))
            throw new Error("Pesquisa nao encontrada.");

        Pesquisa pesquisa = this.pesquisas.get(codigo);

        if (!pesquisa.getAtiva())
            throw new Error("Pesquisa desativada.");

        pesquisa.setAtiva(false);
    }

	/**
	 * Método passa configurar a ativação da pesquisa
	 * @author adyssonfs 
	 * @param codigo: identificador da pesquisa
	 * */
    public void ativaPesquisa(String codigo) {

        if (!pesquisas.containsKey(codigo))
            throw new IllegalArgumentException("Pesquisa nao encontrada.");

        Pesquisa pesquisa = this.pesquisas.get(codigo);

        if (pesquisa.getAtiva())
            throw new Error("Pesquisa ja ativada.");

        pesquisa.setAtiva(true);
    }

    /**
	 * Método faz a exibição da pesquisa no formato
     * "CODIGO - Descricao - ComposDeInteresse"
	 * @author adyssonfs 
	 * @param codigo: identificador da pesquisa
	 * */
    public String exibePesquisa(String codigo) {

        this.validador.valida(codigo, "Codigo nao pode ser nulo ou vazio.");

        if (!pesquisas.containsKey(codigo))
            throw new IllegalArgumentException("Pesquisa nao encontrada.");

        Pesquisa pesquisa = this.pesquisas.get(codigo);
        return pesquisa.toString();
    }

    /**
	 * Método para a verificação da atividade da pesquisa
	 * @author adyssonfs 
	 * @param codigo: identificador da pesquisa
	 * */
    public boolean pesquisaEhAtiva(String codigo) {

        this.validador.valida(codigo, "Codigo nao pode ser nulo ou vazio.");

        if (!pesquisas.containsKey(codigo))
            throw new IllegalArgumentException("Pesquisa nao encontrada.");

        Pesquisa pesquisa = this.pesquisas.get(codigo);
        return pesquisa.getAtiva();
    }

    /**
     * US5
     */
    public boolean associaProblema(String idPesquisa, Problema problema) {
    	if (this.pesquisas.containsKey(idPesquisa)) {
    		if(this.pesquisaEhAtiva(idPesquisa)) {
    			if (!this.pesquisas.get(idPesquisa).existeProblema()) {
					return this.pesquisas.get(idPesquisa).associaProblema(problema);
				}else{
    				throw new IllegalArgumentException("Pesquisa ja associada a um problema.");
				}
    		}else {
    			throw new IllegalArgumentException("Pesquisa desativada.");
    		}
    	}else {
		throw new IllegalArgumentException("Pesquisa nao encontrada.");
    	}
    }

	public boolean desassociaProblema(String idPesquisa) {
		if (this.pesquisas.containsKey(idPesquisa)) {
			if(this.pesquisaEhAtiva(idPesquisa)) {
			return this.pesquisas.get(idPesquisa).desassociaProblema();
			}else {
				throw new IllegalArgumentException("Pesquisa desativada.");
			}
		}else {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
			}
		}
	
	public boolean associaObjetivo(String idPesquisa, Objetivo objetivo, String idObjetivo) {
    	if(this.pesquisas.containsKey(idPesquisa)) {
			if (this.pesquisaEhAtiva(idPesquisa)) {
				if (!objetivo.isAssociado()) {
					return this.pesquisas.get(idPesquisa).associaObjetivo(objetivo, idObjetivo);
				}else{
					throw new IllegalArgumentException("Objetivo ja associado a uma pesquisa.");
				}
			} else {
				throw new IllegalArgumentException("Pesquisa desativada.");
			}
		}else{
    		throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
	}

	public boolean desassociaObjetivo(String idPesquisa,String idObjetivo) {
		if (this.pesquisas.containsKey(idPesquisa)) {
			if (this.pesquisaEhAtiva(idPesquisa)) {
				return this.pesquisas.get(idPesquisa).desassociaObjetivo(idObjetivo);
			} else {
				throw new IllegalArgumentException("Pesquisa desativada.");
			}
		} else {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
	}
}
