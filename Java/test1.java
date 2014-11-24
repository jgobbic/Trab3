import java.util.*;

public class test1{

public static void main(String[] args){

Double a = 0.25;
Int b = 1;
int c = 0;
ChanceToGet<Int> A = new ChanceToGet<Int>(a,b);


for(int i=0;i<100;i++){
z = A.amIGetting();
if(a==null)
	c++;
System.out.println(a + c/z);

}

}

}