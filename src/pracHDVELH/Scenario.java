/**
 * File: ScenarioDG.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

/**
 * @author prost
 *
 */
public class Scenario {
	private static final String MSG_EMPTY_SCENARIO = "Sorry, no scenario was found.";
	private static final String MSG_FINALE = "That's all folks!";
	private Event head;
	private GUIManager gui;

	/* TO BE COMPLETED */
	public Scenario(GUIManager gui, Event head) {
		this.head = head;
		this.gui = gui;
	}

	public String run() {
		if(head == null)return MSG_EMPTY_SCENARIO;
		while(true)
		{
			head = head.run();
			if (head == null) return MSG_EMPTY_SCENARIO;
				if (!head.hasDaughters())
				{
					gui.output(head.getData());
					return MSG_FINALE;
				}
		}
	}

	/* MAIN */
	public static void main(String[] args) {
		Scenario scenario;
		GUIManager gui = new GUIManager(System.in, System.out, System.err);

		// S
		// *1:event1
		// **1.1
		// ***S
		// **1.2
		// ***E
		// *2:event2
		// **2.1
		// ***1
		// **2.2
		// ***S

		Event event0 = new Event(gui,"Vous êtes Darius, le chasseur le plus renommé de la contrée.\n Un soir, on vous appelle car une créature a attaqué un paysan lui laissant de grosses séquelles.\n On vous dirige vers les lieux de l'attaque.\n En arrivant sur les lieux, vous remarquez qu'il y a des empreintes étranges dans la boue.\n La chasse commence. Où choisissez-vous d'aller?"
				+ "\nSuivre le chemin boueux 2\n"
				+ "Suivre la route pavée 1 \n");

		Event event1 =new Event(gui,"Après quelques mètres de marche, vous arrivez devant une intersection, il y a un panneau qui indique deux directions.\n L'une indique \"VILLAGE DE SALERS\" et l'autre indique \"FORET DE SOURDAN\".\n Quelle direction choisissez-vous ? \n"
				+"Se rendre à la FORET DE SOURDAN 2 \n"
				+"Se rendre au VILLAGE DE SALERS3\n");

		Event event3 = new Event(gui,"Bienvenue à Salers !, c'est un petit village où il fait bon vivre.\n A cette heure-ci, tous les villageois sont chez eux, les rues sont désertes.\n Il n'y a pas grand-chose à faire ici. Depuis le village, on peut rejoindre la FORET DE SOURDAN.\n" +
				"Allez à la FORET DE SOURDAN 2 \n");

		Event event2 = new Event(gui,"Vous arrivez devant l'immense et dense FORET DE SOURDAN, celle-ci regorge d'arbres épineux et de buissons aux feuilles tranchantes.\n Il est impossible pour vous de la traverser.Vous distinguez d'un côté un petit chemin qui longe la forêt et de l'autre côté au loin, vous apercevez de la lumière qui semble provenir d'un village.\n Sur le chemin pour se rendre au village se dresse une silhouette d'un homme. Que voulez-vous faire?\n" +
				"Allez au village 3\n" +
				"Allez parler à l'homme 5\n" +
				"Suivre le petit chemin 4\n");

		Event event4 = new Event(gui,"Vous arrivez dans une GROTTE, vous entendez un bruit, il fait sombre et la lumière se fait absente.\n Néanmoins, la lumière de la lune éclaire brièvement une sorte de brèche dans laquelle on peut s'y glisser.\n Que choisissez-vous de faire?\n" +
				"\n" +
				"Faire demi-tour et retourner vers la FORET DE SOURDAN 2\n" +
				"Traverser la brèche 4\n" +
				"Allez vers le bruit 6\n");
		Event event5 = new Event(gui,"Vous faites la connaissance d'un MENDIANT prénommé Sannur, celui-ci à des informations à vous donner quant au potentiel lieu où se trouve la bête mais celui-ci ne dévoilera ce qu'il sait que si vous gagnez au jeu des dés.\n Si vous perdez, vous lui devrez une pièce d'or. Que voulez-vous faire ?\n" +
				"JEU ALEATOIRE (Si vous gagnez allez en 4)\n" +
				"Refuser son offre et allez au village 3\n" +
				"Refuser son offre et suivre le petit chemin qui longe la FORET4\n");
		Event event6 = new Event(gui,"Les bruits ne cessent de devenir de plus en plus fort lorsque soudain..., Une boule de feu émane brusquement devant vous.\n Vous arrivez à l'esquiver, une source de lumière prend alors vie dans la grotte. Vous arrivez nettement distinguer une forme.\n C'EST LA BETE !. Il ne vous reste plus qu'à la vaincre ! \n");

		event0.setDaughter(event2,2);
		event0.setDaughter(event1,1);
		event1.setDaughter(event2,2);
		event1.setDaughter(event3,3);
		event3.setDaughter(event2,2);
		event2.setDaughter(event3,3);
		event2.setDaughter(event5,5);
		event2.setDaughter(event4,4);
		event4.setDaughter(event2,2);
		event4.setDaughter(event4,4);
		event4.setDaughter(event6,6);
		event5.setDaughter(event4,4);
		event5.setDaughter(event3,3);
		event5.setDaughter(event4,4);
		/* ******* */
		// **2.3
		// ***event4
		// ****event2
		// ****E
		// ****event3
		// ...

		int[] mask = { 3, 6, 7 };
		scenario = new Scenario(gui, event0);

	System.out.println(scenario.run());
	}
}

// eof