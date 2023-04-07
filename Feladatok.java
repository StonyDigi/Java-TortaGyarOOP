package tortaGyar;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Feladatok {
	@SuppressWarnings("unused")
	private static String fejlec = "";
	List<TortaGyarPojo> tortaLista = new FajlKezelo().fajlBeolvas("tortaGyar-csv");
	FajlKezelo fkObj = new FajlKezelo();

	public void adatKiir() {
		for (TortaGyarPojo item : tortaLista) {
			System.out.print(item.getAzonosito().toString());
			System.out.print(";");
			System.out.print(item.getMegnevezes().toString());
			System.out.print(";");
			System.out.print(item.getNetto_ar().toString());
			System.out.print(";");
			System.out.print(item.getSzeletes().toString());
			System.out.print(";");
			System.out.print(item.getAzonosito().toString());
			System.out.print(";");
			System.out.print(item.isAkciosSzovegesen().toString());
			System.out.print(";");
			System.out.print(item.isGlutenMentes().toString());
			System.out.print(";");
			System.out.print(item.isLaktozMentes().toString());
			System.out.println();	
		}
	}
	public int hanyfeleTortaRendelhetoAcukraszdabol() {
		int db = 0;
		int osszeg = 0;
		for (TortaGyarPojo item : tortaLista) {
			if(item.getMegnevezes() != null) {
				db++;
				osszeg = db;
			}	
		}
		return osszeg;
	}
	public void melyikAlegdragabbTorta() {
		int max = 0;
		int osszeg = 0;

		for (TortaGyarPojo item : tortaLista) {
				if(item.getNetto_ar()>max) {
					max++;
					max = osszeg;
					osszeg = item.getNetto_ar();
				}	
		}
		System.out.println();
}
	public void glutenMentesEsLaktozMentesTortak() {
		
		for (TortaGyarPojo item : tortaLista) {
			if(item.isGlutenMentes().equals("glut�nmentes") && item.isLaktozMentes().equals("lakt�zmentes")) {
				System.out.println(item.toString());
			}	
		}
	}
	public double egySzeletGlutenmentesTortaAvgAr() {
		int dbSzelet = 0;
		int osszegSzeletek = 0;
		double osszegNettoAr = 0.0;
		for (TortaGyarPojo item : tortaLista) {
			if(item.isGlutenMentes().equalsIgnoreCase("glut�nmentes")) {
				dbSzelet++;
				osszegSzeletek += item.getSzeletes();//itt megkapom a 96-ot
			}	
		}
		for (TortaGyarPojo item : tortaLista) {
			if(item.isGlutenMentes().equalsIgnoreCase("glut�nmentes")) {
				osszegNettoAr += item.getNetto_ar();//itt a tort�k �sszeg�t 31700	
			}	
		}
		return Math.round(osszegNettoAr/osszegSzeletek);//it 31700/96 = 330 ft/szelet
		}
	
	public double rendelhetoTortakHanySzazalekaAkcios() {
		int max = 0;
		double db = 0;
		for (TortaGyarPojo item : tortaLista) {
			if (item.getMegnevezes()!=null) {
				max++;// itt megkapjuk a 11-et a sz�zal�k alapot! 
				}
					}
		for (TortaGyarPojo item : tortaLista) {
			if(item.isAkciosSzovegesen().equalsIgnoreCase("akci�s")) {
				db++; // itt megkapjuk a 4-et a sz�zal�k �rt�ket
			}
		}
		return Math.round(db/max*100); // 4/11*100 = % l�b
		}
	public void tortaAmibenSzerepelAmandulaSzo() {
		for (TortaGyarPojo item : tortaLista) {
			if(item.getMegnevezes().contains("mandula")) {
				System.out.println(item.toString());
			}
		}	
	}
	public void akciosTortaWeboldal() {
		try {
			FileOutputStream fsAkciosTorta = new FileOutputStream("akciosTorta.html");
			OutputStreamWriter outAkciosTorta = new OutputStreamWriter(fsAkciosTorta, "UTF-8");
			outAkciosTorta.write("<!DOCTYPE html>");
			outAkciosTorta.write("<head>");
			outAkciosTorta.write("<title>Akci�s term�kek</title>");
			outAkciosTorta.write("<meta charset='UTF-8'>");
			outAkciosTorta.write("</head>");
			outAkciosTorta.write("<body>");
			outAkciosTorta.write("<h1>Akci�s term�kek</h1>");
			outAkciosTorta.write("<table border=1>");
			outAkciosTorta.write("<tr>");
			outAkciosTorta.write("<th>Azonos�t�</th>");
			outAkciosTorta.write("<th>Megnevez�s</th>");
			outAkciosTorta.write("<th>Nett� �r</th>");
			outAkciosTorta.write("<th>Szeletes</th>");
			outAkciosTorta.write("<th>Akci�s</th>");
			outAkciosTorta.write("<th>Glut�nmentes</th>");
			outAkciosTorta.write("<th>Lakt�zmentes</th>");
			outAkciosTorta.write("</tr>");
			    for (TortaGyarPojo tortaGyarPojo : tortaLista) {
			    	if(tortaGyarPojo.isAkcios()) {
			    		 outAkciosTorta.write("</tr>");
				    		outAkciosTorta.write("<td>"+tortaGyarPojo.getAzonosito()+"</td>");
				    		outAkciosTorta.write("<td>"+tortaGyarPojo.getMegnevezes()+"</td>");
				    		outAkciosTorta.write("<td>"+tortaGyarPojo.getNetto_ar().toString()+"</td>");
				    		outAkciosTorta.write("<td>"+tortaGyarPojo.getSzeletes().toString()+"</td>");
				    		outAkciosTorta.write("<td>"+tortaGyarPojo.isAkciosSzovegesen()+"</td>");
				    		outAkciosTorta.write("<td>"+tortaGyarPojo.isGlutenMentes()+"</td>");
				    		outAkciosTorta.write("<td>"+tortaGyarPojo.isLaktozMentes()+"</td>");
				    		outAkciosTorta.write("</tr>");
				}
			 }
			    outAkciosTorta.write("</table>");//lez�rjuk a cell�kat
			    outAkciosTorta.write("</body>");
			    outAkciosTorta.write("</html>");
			    outAkciosTorta.close();
			    fsAkciosTorta.close();   
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Sajn�lom, nem tal�lhat� a f�jl a megadott el�r�si �tvonalon....");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Sajn�lom, Nem t�mogatott f�jlform�tum!!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Sajn�lom, I / O (eszk�z) hiba l�pett fel!!!");
		}	
	}
	public void ujFajlLetrehozTortaBruttoAr() {
		try {
			FileOutputStream fs = new FileOutputStream("tortaGyar_brutto.csv", false);
			OutputStreamWriter out = new OutputStreamWriter(fs, "UTF-8");
			out.write("azonosito;megnevezes;brutto_ar;szeletes;akcios;glut�nmentes;lakt�zmentes");
			out.write("\n");
			for (TortaGyarPojo item : tortaLista) {
				out.write(item.getAzonosito());
				out.write(";");
				out.write(item.getMegnevezes());
				out.write(";");
				out.write(String.valueOf(item.getNetto_ar() * 1.27));
				out.write(";");
				out.write(String.valueOf(item.getSzeletes()));
				out.write(";");
				out.write(item.isAkciosSzovegesen());
				out.write(";");
				out.write(item.isGlutenMentes());
				out.write(";");
				out.write(item.isLaktozMentes());
				out.write(";");
				out.write("\n");
				}
			out.close();
			fs.close();
		} catch (FileNotFoundException e) {
			System.out.println("Sajn�lom, nem tal�lhat� a f�jl a megadott el�r�si �ton!!!");
//			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Sajn�lom, nem t�mogatott karakterk�dol�s!!!");
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Sajn�lom, I/O (eszk�z) hiba l�pett fel!!!");
			e.printStackTrace();	
	}
		
		}
}