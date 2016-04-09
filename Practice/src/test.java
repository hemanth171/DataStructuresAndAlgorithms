import java.util.Scanner;
import java.util.StringTokenizer;


public class test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        long N = 0;
        long M=0;
        long S=0;
        long t = 0;
        long pi =0;
        for(int ii=0;ii<T;ii++){
        	String input = sc.nextLine();
        	StringTokenizer st = new StringTokenizer(input," ");
        	
        while(st.hasMoreTokens()){	
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        S = Long.parseLong(st.nextToken());
        
        }
        t = S + (M-1);
        if(t>N){
        	pi = t-N;
        	while(pi>N){
        		pi = pi-N;        		
        	}
        }
        else{
        	pi = t;
        }
        System.out.println(pi);
        }
        
	}
	

}
