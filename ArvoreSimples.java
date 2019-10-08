import java.util.Iterator;
import java.util.Vector;
import java.lang.Iterable;
public class ArvoreSimples implements ArvoreGenerica
{
	//Atributos da arvore
	NoArvore raiz;
	int tamanho;
	//Construtor
	public ArvoreSimples(Object o)
	{
		raiz = new NoArvore(null, o);
		tamanho = 1;
	}
	/** Retorna a raiz da �rvore */
	public Position root()
	{
		return raiz;
	}
	/** Retorna o no pai de um no */
	public Position parent(Position v)
	{
		NoArvore n = (NoArvore) v;
		return (n.parent());
	}
	/** retorna os filhos de um no */
	public Iterator children(Position v)
	{
		NoArvore n = (NoArvore) v;
		return n.children();
	}
	/** Testa se um no e interno */
	public boolean isInternal(Position v)
	{
		NoArvore n = (NoArvore) v;
		return (n.childrenNumber() > 0);
	}
	/** Testa se um no e externo*/
	public boolean isExternal(Position v)
	{
		NoArvore n = (NoArvore) v;
		return (n.childrenNumber() == 0);
	}
	/** Testa se um no e a raiz */
	public boolean isRoot(Position v)
	{
		NoArvore n = (NoArvore) v;
		return n == raiz;
	}
	/** Adiciona um filho a um n� */
	public void addChild(Position v, Object o)
	{
		NoArvore n = (NoArvore) v;
		NoArvore novo = new NoArvore(n, o);
		n.addChild(novo);
		tamanho++;
	}
	/** Remove um no
	 *  So pode remover nos externos e que tenham um pai (nao seja raiz)
	*/
	public Object remove(Position v) throws InvalidPositionException
	{
		NoArvore n = (NoArvore) v;
		NoArvore pai = n.parent();
		if (pai != null || isExternal(n))
			pai.removeChild(n);
		else
			throw new InvalidPositionException();
		Object o = n.element();
		tamanho--;
		return o;
	}
	/** Troca dois elementos de posicao */
	public void swapElements(Position v, Position w)
	{
		Object temp;
		NoArvore n = (NoArvore) v;
		NoArvore m = (NoArvore) w;
		temp = n.element();
		n.setElement(m.element());
		m.setElement(temp);
		/*M�todo que serve de exerc�cio
		 * Este m�todo dever� fazer com que o objeto
		 * que estava na posi��o v fique na posi��o w
		 * e fazer com que o objeto que estava na posi��o w
		 * fique na posi��o v
		 */  		
	}
	/** Retorna a profundidade de um no */
	public int depth(Position v)
	{
		NoArvore n = (NoArvore) v;
		int profundidade = profundidade(n);
		return profundidade;
	}
	private int profundidade(NoArvore n)
	{
		if (n == raiz)
			return 0;
		else
			return 1 + profundidade(n.parent());
	}
	/** Retorna a altura da �rvore */
	public int height(Position v)
	{
		NoArvore n = (NoArvore) v;
		int altura = altura(n);
		return altura;
	}
	
	public int altura(NoArvore n) {
		int sum = 0;
		if (n.childrenNumber()==0) {
			return 0;
		} else {
			Iterator it = n.children();
			while(it.hasNext()){
				NoArvore atual = (NoArvore) it.next();
				sum = max(sum, altura(atual));				
			}
			return 1+sum;
		}		
	}
	private int max(int a, int b) {
		if(a<b) {return b;}
		return a;
	}
	/** Retorna um iterator com os elementos armazenados na �rvore */
	public Iterator elements()
	{
		// M�todo n�o implementados --- Coleguinha fique a vontade para faz�-los
		return null;
	}
	/** Retorna um iterator com as posi��es (n�s) da �rvore */
	public Iterator positions()
	{
		// M�todo n�o implementados --- Coleguinha fique a vontade para faz�-los
		return null;
	}
	/** Retorna o n�mero de n�s da �rvore
	 */
	public int size()
	{
		return 0;
	}
	/** Retorna se a �vore est� vazia. Sempre vai ser falso, pois n�o permitimos remover a raiz
	 */
	public boolean isEmpty()
	{
		return false;
	}
	public Object replace(Position v, Object o)
	{
		NoArvore n = (NoArvore) v;
		n.setElement(o);
		return o;
	}
	/* In�cio da classe aninhada para armazenar o n�*/
	private class NoArvore implements Position
	{
		private Object o;
		private NoArvore pai;
		private Vector filhos = new Vector();
		public NoArvore(NoArvore pai, Object o)
		{
			this.pai = pai;
			this.o = o;
		}
		public Object element()
		{
			return o;
		}
		public NoArvore parent()
		{
			return pai;
		}
		public void setElement(Object o)
		{
			this.o = o;
		}
		public void addChild(NoArvore o)
		{
			filhos.add(o);
		}
		public void removeChild(NoArvore o)
		{
			filhos.remove(o);
		}
		public int childrenNumber()
		{
			return filhos.size();
		}
		public Iterator children()
		{
			return filhos.iterator();
		}
	}
	/* Fim da classe aninhada para armazenar o n� */
}