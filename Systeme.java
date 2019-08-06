
public class Systeme {
	

	private double[][] coef;
	private double[] b;
	
	/**
	 * Constructeur du Système d'équations
	 * @param coef la matrice carree correspondant au systeme, on suppose qu'au moins un coef pour
	 * chaque variable est non nul
	 * @param b la liste sous forme de tab d'int des membres de droite de chaque equation
	 */
	public Systeme(double[][] coef,double[] b){
		
		this.coef = coef;
		this.b = b;
	}
	
	/**
	 * Trie les équations dans le tableau pour avoir toujours le coeffcicent a(n;n) non nul, 
	 * on part du principe qu'au moins un des coefficients de chaque variable est non nul 
	 */
	
	private void triSysteme(){
		
		int n;
		
		for(int i = 0; i<this.coef.length; i++){
			
			n = i;
			
			while((this.coef[n][i] == 0)&&(n<this.coef.length))
				n++;
			
			double[] transEq = this.coef[i];
			this.coef[i] = this.coef[n];
			this.coef[n] = transEq;
		}
	}
	
	
	private void gaussEq(int eq1, int eq2){
		
		int n=0;
		
		while(this.coef[eq2][n]==0)
			n++;
		
		double pivot=this.coef[eq1][n];
		
		//sur les coefficient de variables
		for(int i=n;i<this.coef[eq1].length;i++){
			
			this.coef[eq1][i] = this.coef[eq1][i]-(pivot/this.coef[eq2][n])*this.coef[eq2][i];
		}
		
		//sur le memebre de droite
		this.b[eq1] = this.b[eq1]-(pivot/this.coef[eq2][n])*this.b[eq2];
	}
	
	/**
	 * Fonction de réduction du système par la méthode du pivot de Gauss
	 */
	
	public void gauss(){
		
		this.triSysteme();
		
		for(int i=0;i<this.coef.length;i++){
			
			for (int n=i+1;n<this.coef.length;n++)
				gaussEq(n,i);
		}
	}
	
	/**
	 * toString d'un systeme
	 */
	
	public String toString(){
		
		String toStr = "Système complet : \n \n";
		
		for (int i=0;i<this.coef.length;i++){
			
			for (int n=0;n<this.coef[i].length;n++){
				
				if (this.coef[i][n]!=0){
					
					if ((this.coef[i][n]>0)&&(n>0)) 
						toStr += "+";
					
					toStr += this.coef[i][n] + "*x" + n;
					
				}else{
					
					toStr += "      ";
				}
					
			}
			toStr += "=" + this.b[i] + "\n";
		}
		
		return toStr;
	}
	
	/**
	 * Teste la compatibilité  du système et donne le as échéant le nombre de paramètres
	 * @return  si le système est imcompatible, 0 si le système admet une solution et sinon le nombre de paramètres dans les solutions
	 */
	
	public int compatibility(){
		
		int comp = 0;
		
		if(this.coef.length<this.coef[0].length)
			comp+=this.coef[0].length-this.coef.length;
		
		int i = b.length;
		
		while(this.coef[i][this.coef[0].length]==0){
			
			if(this.b[i]==0){
				comp+=(i<this.coef[0].length)?1:0;
			}else{
				return -1;
			}
			i++;
		}
		
		return comp;
	}
	
	public double[] srolve(){
		return null;
		
	}

}
