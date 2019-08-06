
public class Equation {
	
	private double[] coefs;
	private double b;
	private static int count=0;
	private int equationNumero;
	
	Equation(){
		
		count++;
		this.equationNumero = count;
		System.out.println("Equation "+this.equationNumero+" du Syst�me :");
		this.b = 0.0;
		
	}
	
	Equation(double[] coef, double b){
		
		count++;
		this.equationNumero = count;
		System.out.println("Equation "+this.equationNumero+" du Syst�me :");
		this.b=b;
		this.coefs=coef;
		for (int i=0;i<this.coefs.length;i++){
			System.out.print("("+coef[i]+")*x"+i);
			if (i<this.coefs.length-1) System.out.print("+");
		}
		System.out.println("="+this.b);
	}
	
	/**
	 * Accesseur du tableau ddes coefficients de l'�quation
	 * @return coef le tableau des coefficients
	 */
	public double[] getCoef(){
		
		return this.coefs;
	}
	
	/**
	 * Accesseur du num�ro de l'�quation
	 * @return eqNum le num�ro de l'�quation
	 */
	
	public int getEqNum(){
		
		return this.equationNumero;
	}
	
	/**
	 * Accesseur du coefficient de droite b de l'�quation
	 * @return b le coefficient de droite
	 */
	
	
	/**
	 * mutateur du num�ro de l'�quation
	 * @param i nouveau numero de l'�quation
	 */
	public void setEqNum(int i){
		
		this.equationNumero=i;
	}
	
	public double getb(){
		return this.b;
	}
	
	/**
	 *Utilise le premier coefficient a(n) non nul de l'�quation en param�tre comme pivot de Gauss pour �liminer x(n) de l'�quation
	 * @param eq2 l'�quation dont ont tire le pivot
	 */
	
	public void gauss(Equation eq2){
		
		int n=0;
		
		while(eq2.getCoef()[n] == 0) n++;
		double pivot=this.coefs[n];
		
		for(int i=n;i<this.coefs.length;i++){
			
			this.coefs[i]=this.coefs[i]-(pivot/eq2.getCoef()[n])*eq2.getCoef()[i];
		}
		this.b=this.b-(pivot/eq2.getCoef()[n])*eq2.getb();
		/**
		 System.out.println("Equation "+this.eqNum+" du Syst�me vaut maintenant :");
		for (int i=0;i<this.coef.length;i++){
			System.out.print("("+coef[i]+")*x"+i);
			if (i<this.coef.length-1) System.out.print("+");
		}
		System.out.print("="+this.b);
		*/
	
	}
}
