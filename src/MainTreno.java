public class MainTreno {
	public static int menu() {
		int scelta;
		System.out.println("           TRENO");
		System.out.println("0. Uscita");
		System.out.println("1. Inserisci un vagone al treno");
		System.out.println("2. Elimina un vagone dal treno");
		System.out.println("3. Occupa i posti di un vagone");
		System.out.println("4. Visualizza il numero totale di posti liberi presenti sul treno");
		System.out.println("5. Stampa le informazioni sul treno e i vagoni");
		System.out.println("Fai la tua scelta: ");
		return LetturaCl.leggiI("");
	}
	public static void main(String[] args) {
		Treno t= new Treno(LetturaCl.leggiSt("Inserisci il nome del treno: "),
                		   LetturaCl.leggiI("Inserisci il numero massimo di vagoni: "),
                		   LetturaCl.leggiSt("Inserisci il luogo di partenza: "),
                		   LetturaCl.leggiSt("Inserisci il luogo di destinazione: "));
		int scelta;
		do {
			scelta=menu();
			switch(scelta){
				case 0:System.out.println("Arrivederci!"); break;
				case 1: if(t.addVagone(LetturaCl.leggiI("Inserisci la posizione del vagone che vuoi aggiungere: "),
									new Vagone(LetturaCl.leggiI("Inserisci il numero totale di posti: "),
                		                       LetturaCl.leggiSt("Inserisci la classe del vagone: ")))){
							System.out.println("Vagone aggiunto al treno!");
						}
						else{
							System.out.println("Numero massimo di vagoni raggiunto!");
						}
					 break;
				case 2: if(t.deleteVagone(LetturaCl.leggiI("Inserisci la posizione del vagone che vuoi cancellare: "))){
							System.out.println("Vagone cancellato!");
				        }
						else {
							System.out.println("Numero vagone non esistente!");
						}
				     break;
				case 3: t.addPostiOcc(LetturaCl.leggiI("Inserisci la posizione del vagone in cui occupare posti: "),
							        LetturaCl.leggiI("Inserisci il numero dei posti occupati: "));
					break;
				case 4: System.out.println("Sul treno sono disponibili in totale "+t.postiLib()+" posti");
					 break; 
				case 5:System.out.println(t);
					 break;
				default:System.out.println("Scelta errata!");
			}
		}while(scelta!=0);
	}
}
