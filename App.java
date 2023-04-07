package tortaGyar;

public class App {

	public static void main(String[] args) {
		Feladatok fObj = new Feladatok();
		//FajlKezelo fkObj = new FajlKezelo();
		System.out.println("2. feladat: �rjuk ki az �sszetartoz� adatokat egym�s mell� tabul�torral elv�lasztva! ");
		fObj.adatKiir();
		System.out.println();
		
		System.out.println("3. feladat: H�nyf�le torta rendelhet� a cukr�szd�b�l? ");
		System.out.println(fObj.hanyfeleTortaRendelhetoAcukraszdabol());
		System.out.println();
		
		System.out.println("4. feladat: Melyik a legdr�g�bb torta? A v�laszban a nev�t, azonos�t�j�t �s �r�t is jelen�ts�k meg!");
		fObj.melyikAlegdragabbTorta();
		System.out.println();
		
		System.out.println("5. feladat: Melyek azok a tort�k, amelyek glut�n- �s lakt�zmentesek is? A v�laszban a tort�k minden \r\n" + 
				"adat�t jelen�ts�k meg!");
		fObj.glutenMentesEsLaktozMentesTortak();
		System.out.println();
		
		System.out.println("6. feladat: �tlagosan mennyibe ker�l 1 szelet glut�nmentes torta?");
		System.out.println(fObj.egySzeletGlutenmentesTortaAvgAr()+ " Ft");
		System.out.println();
		
		System.out.println("7. feladat: A rendelhet� tort�k h�ny sz�zal�ka akci�s?");
		System.out.println(fObj.rendelhetoTortakHanySzazalekaAkcios()+ " %");
		System.out.println();
		
		System.out.println("8. feladat: Van �e olyan torta, aminek a nev�ben szerepel a mandula sz�? A v�laszban jelen�ts�k meg a \r\n" + 
				"torta minden adat�t!");
		fObj.tortaAmibenSzerepelAmandulaSzo();
		System.out.println();
		
		System.out.println("9. feladat: Hozzunk l�tre egy �j f�jlt tortaGyar_brutto.csv n�ven, amelybe az eredeti f�jllal azonos \r\n" + 
				"szerkezetben elhelyezz�k a tort�k minden adat�t! A nett� �r helyett a brutt�t ments�k a \r\n" + 
				"f�jlba (27%-s az �FA)!");
		System.out.println("tortaGyar_brutto.csv l�trej�tt....");
		fObj.ujFajlLetrehozTortaBruttoAr();
		System.out.println();
		
		System.out.println("10. feladat: Hozzunk l�tre weboldalt akciosTorta.html n�ven UTF-8 k�dol�sban! A weboldal jelen�tse meg \r\n" + 
				"az �sszes akci�s torta minden adat�t t�bl�zatos form�ban (nett� �rral). ");
		fObj.akciosTortaWeboldal();
		System.out.println("l�trej�tt az akciosTorta.html....");
		System.out.println();
	}
}