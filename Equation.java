
public class Equation {
	
	private double[] coefs;
	private double b;
	private static int count=0;
	private int equationNumero;
	
	Equation(){
		
		count++;
		this.equationNumero = count;
		System.out.println("Equation "+this.equationNumero+" du Système :");
		this.b = 0.0;
		
	}
	
	Equation(double[] coef, double b){
		
		count++;
		this.equationNumero = count;
		System.out.println("Equation "+this.equationNumero+" du Système :");
		this.b=b;
		this.coefs=coef;
		for (int i=0;i<this.coefs.length;i++){
			System.out.print("("+coef[i]+")*x"+i);
			if (i<this.coefs.length-1) System.out.print("+");
		}
		System.out.println("="+this.b);
	}
	
	/**
	 * Accesseur du tableau ddes coefficients de l'équation
	 * @return coef le tableau des coefficients
	 */
	public double[] getCoef(){
		
		return this.coefs;
	}
	
	/**
	 * Accesseur du numéro de l'équation
	 * @return eqNum le numéro de l'équation
	 */
	
	public int getEqNum(){
		
		return this.equationNumero;
	}
	
	/**
	 * Accesseur du coefficient de droite b de l'équation
	 * @return b le coefficient de droite
	 */
	
	
	/**
	 * mutateur du numéro de l'équation
	 * @param i nouveau numero de l'équation
	 */
	public void setEqNum(int i){
		
		this.equationNumero=i;
	}
	
	public double getb(){
		return this.b;
	}
	
	/**
	 *Utilise le premier coefficient a(n) non nul de l'équation en paramètre comme pivot de Gauss pour éliminer x(n) de l'équation
	 * @param eq2 l'équation dont ont tire le pivot
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
		 System.out.println("Equation "+this.eqNum+" du Système vaut maintenant :");
		for (int i=0;i<this.coef.length;i++){
			System.out.print("("+coef[i]+")*x"+i);
			if (i<this.coef.length-1) System.out.print("+");
		}
		System.out.print("="+this.b);
		*/
	
	}
}
