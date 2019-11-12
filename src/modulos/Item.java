package modulos;


/**
 * Construtor da classe Item
 * 
 * @author matheusfls-ccc (Matheus Filipe de Lima Souza)
 *
 */
public class Item {
	
	/**
	 * Status do Item
	 */
	private String status;
	
	/**
	 * Identificador do item
	 */
	private String item;
	
	
	/**
	 * Construtor do item
	 * 
	 * @param item - Código do item
	 */
	public Item(String item) {
		this.status = "PENDENTE";
		this.item = item;
	}
	
	/**
	 * Recupera o Status do item
	 * 
	 * @return - Status do item
	 */
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

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
	
	

	
	

}