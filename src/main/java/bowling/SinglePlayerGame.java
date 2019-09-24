package bowling;

import java.util.List;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
    
    private int tour;
    private int tentative;
    private int p_score;
    private boolean spard;
    private boolean strikd;
    private int boulstrike;
    private int quilles;
    private int[] aled = new int[10];
    
	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
            this.p_score=0;
            this.tentative=1;
            this.tour=1;
            this.spard=false;
            this.strikd=false;
            this.boulstrike=0;
            this.quilles=10;
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            if (this.tour<=10){
                if (nombreDeQuillesAbattues == 10) {
                if (spard){
                    this.p_score+=20;
                    this.spard=false;
                }
                if (strikd && boulstrike==1){
                    this.p_score+=20;
                    this.boulstrike+=1;
                }
                if (strikd && boulstrike==2){
                    this.p_score+=20;
                    this.boulstrike=0;
                }
                else{
                    this.p_score +=10;
                }
                this.strikd=true;
                this.aled[this.tour]=10;
                this.tour+=1; 

            }else if (nombreDeQuillesAbattues == this.quilles){
                if (spard){
                    this.p_score+=this.quilles*2;
                    this.spard=false;
                }
                if (strikd && boulstrike==1){
                    this.p_score+=this.quilles*2;
                    this.boulstrike+=1;
                }
                if (strikd && boulstrike==2){
                    this.p_score+=this.quilles*2;
                    this.boulstrike=0;
                }
                else{
                    this.p_score +=this.quilles*2;
                }
                this.spard=true;
                this.tour+=1;
            }else {
                
                this.p_score=nombreDeQuillesAbattues;
                this.quilles=this.quilles-nombreDeQuillesAbattues;
                this.tentative+=1;
                if (this.tentative==2){
                    this.tour+=1;
                }
            }
            }
            
	}

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
            return this.p_score;
            //throw new UnsupportedOperationException("Pas encore implémenté");
	}
}
