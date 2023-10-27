package ba.unsa.etf.rpr;
import java.util.Scanner;
public class Main {
public static int sumaCifara(int a){
    int suma = 0, b;
    while(a != 0 ){
        b = a%10;
        a=a/10;
        suma = suma+b;
    }
    return suma;
}
    public static void main(String[] args) {
	    int n;
        Scanner ulaz= new Scanner(System.in);
        System.out.println("Unesite n: ");
        n = ulaz.nextInt();
        for(int i=1; i<=n; i++){
            if(i % sumaCifara(i) ==0 ){
                System.out.println(i);
            }
        }
    }
}
