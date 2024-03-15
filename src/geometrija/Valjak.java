package geometrija;

import izuzeci.*;

import java.io.FileNotFoundException;
import java.io.*;
import java.util.Scanner;

public class Valjak extends Krug implements Osobine {
	private double h;

	public Valjak(double r, double h) throws Exception {
		super(r);
		this.h = h;
	}
	
	public Valjak() throws Exception, RetardException {
		super((new Scanner(System.in)).nextDouble());			
		Scanner tastatura = new Scanner(System.in);
		
		double tmp = tastatura.nextDouble();
		
		if(tmp < 0) {
			throw new RetardException("majmunee");
		}
		
		this.h = tmp;
	}
	
	public Valjak(String imeFajla) {
		try {
			FileReader fr = new FileReader(imeFajla);
			BufferedReader br =  new BufferedReader(fr);		
			
			String tmp = br.readLine();
			double tmp2 = Double.parseDouble(tmp);
			
			if (tmp2 < 0) {
				br.close();
				throw new RetardException("Pogresan poluprecnik!!!!");
			}
			
			tmp = br.readLine();
			double tmp3 = Double.parseDouble(tmp);
			
			if (tmp3 < 0) {
				br.close();
				throw new RetardException("Pogresna visina!!!!");
			}
			
			super.setR(tmp2);
			this.h = tmp3;
			br.close();
		}
		catch (IOException e) {	
			System.out.println(e.getMessage());
			super.setR(1);
			this.h = 1;
		}
		catch (RetardException e) {
			System.out.println(e.getMessage());
			super.setR(1);
			this.h = 1;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Valjak(int tmp) throws RetardException, IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		super.setR(Double.parseDouble(br.readLine()));
		double pom = Double.parseDouble(br.readLine());
		
		if (pom < 0) {
			br.close();
			throw new RetardException("Nista ne znas");
		}
		
		this.h = pom;
		br.close();
	}
	
	public double povrsina() {
		return 2 * super.povrsina() + super.obim() * this.h;
	}
	
	public void upisiUBin(String imeFajla) throws IOException{
		FileOutputStream fos = new FileOutputStream(imeFajla);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		
		dos.writeDouble(super.getR());
		dos.writeDouble(this.h);
		
		dos.close();
	}
	
	public void citajIzBin(final String imeFajla, final double[] niz) throws IOException, RetardException{
		if (niz.length < 2) {
			throw new RetardException("Nema dovoljno mesta u nizu");
		}
		else {
			FileInputStream fos = new FileInputStream(imeFajla);
			BufferedInputStream bos = new BufferedInputStream(fos);
			DataInputStream dos = new DataInputStream(bos);
			
			double r1 = dos.readDouble();		
			if (r1 < 0) {
				dos.close();
				throw new RetardException("Pogresan pp");
			}
			
			double h1 = dos.readDouble();
			if (h1 < 0) {
				dos.close();
				throw new RetardException("Pogresan pp");
			}
			
			niz[0] = r1;
			niz[1] = h1;
			
			dos.close();
		}
	}
	
	
	
}