/**
 * Classe que extende de Arvore e acrescenta metodos para adicionar 
 * nos em uma arvore e remover nos da  arvore
 */
public interface ArvoreGenerica extends Arvore
{
	/**
	 * @param v Posicao que vai receber esse filho
	 * @param o Objeto que vai ficar nessa posicao
	 */
	public void addChild(Position v, Object o);
	
	/**
	 * @param v
	 * @return Objeto que estava na posicao que foi removida
	 * @throws InvalidPositionException
	 */
	public Object remove(Position v) throws InvalidPositionException;
}