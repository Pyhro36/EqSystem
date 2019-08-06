
public class EqSystem {

	public static void main(String[] args) {
		
		double[][] eq = {{1,2,3,0},{3,5,0,0},{0,1,2,0},{2,2,3,0}};
		double[] b = {5,3,4,2};
		Systeme systeme=new Systeme(eq, b);
		System.out.println(systeme);
		systeme.gauss();
		System.out.println(systeme);
	}

}
