package geometrija;

//import izuzeci.RetardException;

public class Mejn {
	public static void main(String[] args) {
			try {
//				Valjak v1 = new Valjak();				
//				System.out.println(v1.povrsina());
//				Valjak v2 = new Valjak("fajl.txt");
//				System.out.println(v2.povrsina());
				
				Valjak v3 = new Valjak(5);
//				v3.upisiUBin("binUpis.bin");
				
				final double[] niz = new double[2];
				
				v3.citajIzBin("binUpis.bin", niz);
				
				System.out.println(niz[0]);
				System.out.println(niz[1]);
				
//				System.out.println(v3.povrsina());				
			}
			catch (Exception e) {
				System.out.println(e);
			}
	}
}
