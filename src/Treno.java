/**
 * 
 * @author alessandromarra
 * <b>Classe Treno</b>
 * <p>array di oggetti</p>
 * <p>dati in ingresso:</p>
 * <UL>
 * <LI>nome 
 * <LI>destinazione
 * <LI>partenza
 * <LI>vagoni massimi
 * </UL>
 */

public class Treno {
	/**
	 * nome = nome del treno
	 */
	private String nome, destinazione, partenza;
	private Vagone[] vagoni;
	private int maxV, numV;
	/**
	 * 
	 * @param nome
	 * @param maxV
	 * @param partenza
	 * @param destinazione
	 */
	/**
	 * @return metodo costruttore
	 */
	public Treno(String nome, int maxV, String partenza, String destinazione) {
		this.nome = nome;
		this.maxV = maxV;
		this.destinazione = destinazione;
		this.partenza = partenza;
		numV=0;
		vagoni= new Vagone[maxV];
	}
	/**
	 * @return metodo che aggiunge un vagone al treno
	 */
	public boolean addVagone(int pos, Vagone v){
		if(pos<maxV) {
			vagoni[pos]=v;
			numV++;
			return true;
		}
		return false;
	}
	/**
	 * @return metodo che elimina un vagone dal treno
	 */
	public boolean deleteVagone(int pos) {
		if(pos<maxV && vagoni[pos]!=null) {
			//vagoni[pos]=new Vagone(0, null);
			vagoni[pos]= null;
			return true;
		}
		return false;
	}
	/**
	 * @return metodo che inserisce i posti occupati di un determinato vagone
	 */
	public void addPostiOcc(int pos,int posti) {
		vagoni[pos].setPostiOcc(posti);
	}
	/**
	 * @return metodo che restituisce i posti disponibili
	 */
	public int postiLib() {
		int x=0;
		for(int i=0;i<vagoni.length;i++)
			if(vagoni[i]!=null)
				x+=vagoni[i].getPostiDisp();
		return x;
	}
	/**
	 * @return metodo che restituisce il treno completo
	 */
	public String toString() {
		String s="";
		s+="Il treno "+nome+", che parte da "+partenza+" con destinazione "+destinazione+", ha un totale di "+maxV+" vagoni.";
		for(int i=0;i<vagoni.length;i++) {
			s+="\n"+vagoni[i];
		}
		return s;
	}
	/**
	 * @return metodo main per testare i metodi della classe
	 */
	public static void main(String[] args) {
		Treno t= new Treno("Pechino Express", 10, "Londra", "Parigi");
		t.addVagone(2, new Vagone(20, "Terza"));
		t.addVagone(1, new Vagone(21, "Sesta"));
		t.deleteVagone(1);
		t.addPostiOcc(1, 18);
		System.out.println(t.postiLib());
		System.out.println(t);
	}
}
