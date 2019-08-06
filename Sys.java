import java.util.Scanner;

public class Sys {
	
	private Equation[] sys;
	private int nbx;
	
	/**
	 * Constructeur du Syst�me d'�quations et demande � l'utilisateur des coefficients de toutes les �quations 
	 * @param Nbre nombre d'�quations du Syst�me
	 */
	public Sys(int nbEq,int nbx){
		
		Scanner sc=new Scanner(System.in);
		this.sys=new Equation[nbEq];
		this.nbx=nbx;
		System.out.println("L'�quation n du syst�me est de la forme :");
		for (int i=1;i<=this.nbx;i++){
			System.out.print("a(n;"+i+")*x("+i+")");
			if (i<nbx) System.out.print("+");
		}
		System.out.println("=b(n)");
		for(int n=0;n<nbEq;n++){
			
			double[] coef=new double[nbx];
			for(int i=0;i<this.nbx;i++){
			
				System.out.println("a("+(n+1)+";"+(i+1)+")=");
				coef[i]=sc.nextDouble(); 
			}
			
			System.out.println("b("+(n+1)+")=");
			this.sys[n]=new Equation(coef, sc.nextDouble());
		
		}
		
		sc.close();
	}
	
	/**
	 * Trie les �quations dans le tableau pour avoir toujours le coeffcicent a(n;n) non nul, on part du principe qu'au moins un des coefficients de chaque variable est non nul 
	 */
	
	public void sysTri(){
		
		for(int i=0;i<this.sys.length;i++){
			int n=i;
			while(this.sys[n].getCoef()[i]==0)n++;
			Equation transEq=this.sys[i];
			this.sys[i]=this.sys[n];
			this.sys[n]=transEq;
			this.sys[i].setEqNum(i);
			this.sys[n].setEqNum(n);
		}
	}
	
	/**
	 * Fonction de r�duction du syst�me par la m�thode du pivot de Gauss
	 */
	
	public void gauss(){
		
		for(int i=0;i<this.sys.length;i++){
			for (int n=i+1;n<this.sys.length;n++)
			this.sys[n].gauss(this.sys[i]);
		}
	}
	
	/**
	 * Fonction d'affichage du syst�me
	 */
	
	public void dispSys(){
		
		System.out.println("Syst�me complet : \n \n");
		for (int i=0;i<this.sys.length;i++){
				for (int n=0;n<this.sys[i].getCoef().length;n++){
					if (this.sys[i].getCoef()[n]!=0){
						if ((this.sys[i].getCoef()[n]>0)&&(n>0)) System.out.print("+");
						System.out.print(this.sys[i].getCoef()[n]+"*x"+n);
					}else{
						System.out.print("        ");
					}
					
				}
				System.out.println("="+this.sys[i].getb());
		}
	}
}
