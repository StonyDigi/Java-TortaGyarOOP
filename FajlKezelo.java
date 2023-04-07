package tortaGyar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class FajlKezelo {
	private static String fejlec = "";
	List<TortaGyarPojo> tortaLista = new ArrayList<TortaGyarPojo>();
	
	public List<TortaGyarPojo> fajlBeolvas(String fajlNev) {
		try {
			BufferedReader br = 
					new BufferedReader(
							new InputStreamReader(new FileInputStream("tortaGyar.csv"), "UTF-8"));
			fejlec = br.readLine();
			while (br.ready()) {
				String sor = br.readLine();
				String[] sorAdat = sor.split(";");
				TortaGyarPojo ujTorta = new TortaGyarPojo(
						sorAdat[0],
						sorAdat[1],
						Integer.parseInt(sorAdat[2]),
						Integer.parseInt(sorAdat[3]),
						sorAdat[4].equals("1"),
						sorAdat[5].equals("1"),
						sorAdat[6].equals("1"));
				tortaLista.add(ujTorta);	
			}
			br.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tortaLista;
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
	