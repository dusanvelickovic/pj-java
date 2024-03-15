package geometrija;

public class Krug implements Osobine{
	private double r;
	
	public Krug() {}
	
	public Krug(double r) throws Exception {
		if(r < 0) {
			throw new Exception("ti si retard");
		}
		
		this.r = r;
	}
	
	protected void setR(double r) {
		this.r = r;
	}
	
	protected double getR() {
		return this.r;
	}
	
	@Override
	public double povrsina() {
		return Math.pow(r, 2) * Math.PI;
	}
	
	public double obim() {
		return 2 * this.r * Math.PI;
	}
}
