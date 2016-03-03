package pkg123;

import java.util.Scanner;
class Player
{
	int hp;
	int xp;
	int cash;
	int sleep;
	int hunger;
	int happiness;
	Player()
	{
    	hp=1000;
    	xp=0;
    	cash=100;
    	sleep=100;
    	hunger=100;
    	happiness=100;
   	 
	}
	void lavora()
	{
    	cash=cash+100;
    	sleep=sleep-30;
    	xp=xp+2;
    	hunger=hunger-20;
    	happiness=happiness-10;
    	System.out.println("Hai lavorato... Soldi:"+cash+" Sonno:"+sleep+" Fame:"+hunger+" Felicità:"+happiness+" Esperienza:"+xp);
	}
	void dormi()
	{
    	happiness=100;
    	sleep=100;
    	System.out.println("Hai dormito... Soldi:"+cash+" Sonno:"+sleep+" Fame:"+hunger+" Felicità:"+happiness+" Esperienza:"+xp);
	}
	void rivelafame()
	{
    	if(hunger<=10)
        	System.out.println("Devi mangiare!");
	}
	void mangia()
	{
    	cash=cash-10;
    	hunger=100;
    	System.out.println("Hai mangiato... Soldi:"+cash+" Sonno:"+sleep+" Fame:"+hunger+" Felicità:"+happiness+" Esperienza:"+xp);
	}
	void bollette(int giorno)
	{
    	if(giorno==31 || giorno==62 || giorno==93 || giorno==124 || giorno==155 || giorno==186 || giorno==217 || giorno==248 || giorno==279 || giorno==310 || giorno==341 || giorno==372)
    	{
        	cash=cash-600;
        	happiness=happiness-10;
        	System.out.println("Ecco la bolletta... Soldi:"+cash+" Sonno:"+sleep+" Fame:"+hunger+" Felicità:"+happiness+" Esperienza:"+xp);
    	}
   	 
	}
	void life()
	{
    	sleep=sleep-5;
    	hunger=hunger-2;
    	happiness=happiness-10;
    	System.out.println("Non hai fatto niente... Soldi:"+cash+" Sonno:"+sleep+" Fame:"+hunger+" Felicità:"+happiness+" Esperienza:"+xp);
	}
	void fun()
	{
    	hunger=hunger-10;
    	happiness=100;
    	cash=cash-20;
    	xp=xp+5;
    	sleep=sleep-20;
    	System.out.println("Ti sei divertito con i tuoi amici... Soldi:"+cash+" Sonno:"+sleep+" Fame:"+hunger+" Felicità:"+happiness+" Esperienza:"+xp);
	}
	void fine(int giorno, boolean fine)
	{
    	if(giorno==372 || fine==true)
        	System.out.println("Hai finito il gioco... Soldi:"+cash+" Sonno:"+sleep+" Fame:"+hunger+" Felicità:"+happiness+" Esperienza:"+xp);
        
	}
	void borselloRubato()
	{
    	cash=cash+500;
    	xp=xp+20;
    	happiness=3000;
    	System.out.println("Rubando il borsello hai ottenuto 500 €... Soldi:"+cash+" Sonno:"+sleep+" Fame:"+hunger+" Felicità:"+happiness+" Esperienza:"+xp);
	}
	void borselloBack()
	{
    	xp=xp+20;
    	happiness=happiness+10;
    	System.out.println("Restituendo il borsello hai rinunciato a 500 €... Soldi:"+cash+" Sonno:"+sleep+" Fame:"+hunger+" Felicità:"+happiness+" Esperienza:"+xp);
	}
	void cattivo()
	{
    	hp=hp-100;
    	xp=xp+5;
    	System.out.println("Mentre tornavi a casa, una persona con il passamontagna ti ha pestato e derubato... Vita:"+hp+" Soldi:"+cash+" Sonno:"+sleep+" Fame:"+hunger+" Felicità:"+happiness+" Esperienza:"+xp);
	}
	void ospedale()
	{
    	hp=100;
    	happiness=100;
    	sleep=100;
    	hunger=100;
    	cash=cash-100;
    	xp=xp+1;
    	System.out.println("Sei stato curato... Vita:"+hp+" Soldi:"+cash+" Sonno:"+sleep+" Fame:"+hunger+" Felicità:"+happiness+" Esperienza:"+xp);
	}
        boolean morteFame(boolean fine)
        {
            if(hunger<=0)
            {
                System.out.println("Sei morto di fame... Statistiche finali - Vita:"+hp+" Soldi:"+cash+" Sonno:"+sleep+" Fame:"+hunger+" Felicità:"+happiness+" Esperienza:"+xp);
                fine=true;
                return fine;
            }
            return fine;
        }
}
class Interfaccia
{
}
public class Main
{
	public static void main(String[] args)
	{
    	System.out.println("________***_________***__********__********__");
    	System.out.println("_______***_________***__********__********___");
    	System.out.println("______***_________***__***_______***_________");
    	System.out.println("_____***_________***__******____******_______");
    	System.out.println("____***_________***__***_______***___________");
    	System.out.println("___**********__***__***_______********_______");
    	System.out.println("__**********__***__***_______********________");
    	Scanner sc=new Scanner(System.in);
    	Player one=new Player();
    	System.out.println("Durante questo gioco vivrai la quotidianità per 372 giorni");
    	int giorno=1;
        boolean fine=false;
    	while(giorno<=372)
    	{
        	System.out.println("Buongiorno! Questo è il giorno "+giorno+". Pronto per questa splendida giornata?");
        	System.out.println("Vuoi andare al lavoro?(Si/No)");
        	String answer=sc.next();
        	if(answer.equals("Si") || answer.equals("si"))
                {
                    one.lavora();
                    fine=one.morteFame(fine);
                    one.fine(giorno, fine);
                }
        	else
                {
                    one.life();
                    fine=one.morteFame(fine);
                    one.fine(giorno, fine);
                }
        	if(giorno%31==1)
        	{
                    System.out.println("Tornando a casa hai trovato un borsello sul marciapiede, contiene 500€, vuoi tenerli?(Si/No)");
                    String ans5=sc.next();
                    if(ans5.equals("Si") || ans5.equals("si"))
                        one.borselloRubato();
                    else
                        one.borselloBack();
        	}    
        	one.rivelafame();
        	System.out.println("Vuoi mangiare?(Si/No)");
        	String ans1=sc.next();
        	if(ans1.equals("Si") || ans1.equals("si"))
                    one.mangia();
        	else
                {
                    one.life();
                    fine=one.morteFame(fine);
                    one.fine(giorno, fine);
                }
        	System.out.println("Vuoi uscire con i tuoi amici?(Si/No)");
        	String ans2=sc.next();
        	if(ans2.equals("Si") || ans2.equals("si"))
                {
                    one.fun();
                    fine=one.morteFame(fine);
                    one.fine(giorno, fine);
                }
        	else
                {
                    one.life();
                    fine=one.morteFame(fine);
                    one.fine(giorno, fine);
                }
        	if(giorno%12==1 && (ans2.equals("Si") || ans2.equals("si")))
        	{
                    one.cattivo();
                    System.out.println("Vuoi curarti? Le cure costeranno 100 €...(Si/No)");
                    String ans4=sc.next();
                    if(ans4.equals("Si") || ans4.equals("si"))
                	one.ospedale();
                    else
                    {
                        one.life();
                        fine=one.morteFame(fine);
                        one.fine(giorno, fine);
                    }
        	}
        	System.out.println("Vuoi mangiare?(Si/No)");
        	String ans3=sc.next();
        	if(ans3.equals("Si") || ans3.equals("si"))
                    one.mangia();
        	else
                {
                    one.life();
                    fine=one.morteFame(fine);
                }
        	one.bollette(giorno);
        	one.fine(giorno, fine);
        	one.dormi();
        	giorno++;
    	}
	}
    
}







