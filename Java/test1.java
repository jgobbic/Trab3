import java.util.*;
import Item.*;

public class test1{

public static void main(String[] args){

	double a = 0.9;
	Item b = new Weapon("Teste",0,0,0);
	int c = 0;
	double d=1;
	ChanceToGet<Item> A = new ChanceToGet<Item>(a,b);

	Item z;
	for(int i=1;i<100;i++){

		z = A.amIGetting();
		if(z!=null)
			System.out.println( z.getName() );
		if(z==null)
			System.out.println("null");
			c++;

	
		//System.out.println(z);

}
c = c;
		System.out.println(c);
}

}