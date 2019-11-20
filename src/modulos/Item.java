package modulos;

import java.io.Serializable;

/**
 * Construtor da classe Item
 * 
 * @author matheusfls-ccc (Matheus Filipe de Lima Souza)
 *
 */
public class Item implements Serializable {
	
	/**
	 * Status do item.
	 * 
	 */
	private String status;
	
	/**
	 * Identificador do item.
	 * 
	 */
	private String item;
	
	
	/**
	 * Construtor do item.
	 * 
	 * @param item O código do item.
	 */
	public Item(String item) {
		this.status = "PENDENTE";
		this.item = item;
	}
	
	/**
	 * Método que retorna o status do item.
	 * 
	 * @return O status do item.
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Método que altera o status do item.
	 * 
	 * @param status O novo status do item.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Método que constrói a representação textual do item.
	 * 
	 */
	@Override
	public String toString() {
		return this.status + " - " + this.item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}
	
	public String getItem() {
		return item;
	}
	

	
	

}