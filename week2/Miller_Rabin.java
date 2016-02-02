import java.io.*;
public class Miller_Rabin {
	public static void main(String args[]){
		
		long[] nums = getNumsFromFile("/Users/sunny/test/cpe593/week2/hw2.dat");
		for(int i =0; i<nums.length; i++){
				long n = nums[i];
				boolean isP = is_prime(n, 6);
				System.out.println(n + " "+isP);		
		}
	}
	
	public static long mod_pow(long base, long exponent,long modulus){
	    if(modulus == 1) return 0;
	    long c = 1;
	    for (long e_prime = 1; e_prime<=exponent; e_prime++){
	        c = (c*base) % modulus;
	    }
	    return c;
	}
	
	public static long powerMod(long base, long exponent,long modulus){
		if(modulus == 1) return 0L;
		//if( (modulus -1)*(modulus -1) > base) return 0L;
		long result = 1L;
		base = base % modulus;
		while(exponent > 0){
			if(exponent % 2  ==1){
				result = (result * base)% modulus;
			}
			exponent = exponent>>1;
			base = (base * base) % modulus;
			
		}
		return result;	
	}


	//97
	public static boolean is_prime(long n, int k){
	    //step1  n-1 2^r*d
	    long tmp = n-1;
	    long r = 0;
	    while(true){
	        if(tmp%2 == 0){
	            tmp = tmp/2;
	            r++;
	        }else{
	            break;
	        }
	    }

	    long d = (long) ((n-1)/Math.pow(2, r));

	    while(k-- > 0){
	        int a = (int)(Math.random() * (n-2) + 2);
	        long x =  powerMod(a, d, n);
	        boolean enterWhileLoop = false;
	        if( x == 1 || x == (n-1)) continue;
	        for(int i =0; i<r-1; i++){
	            x = x*x % n;
	            if(x == 1) return false;
	            if(x == (n-1)) { enterWhileLoop = true; break;};
	        }
	        if(enterWhileLoop) continue;
	        return false;
	    }
	    return true;
	}
	
	public static long[] getNumsFromFile(String fileName){
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String s = br.readLine();
			String[] strs =  s.split(" ");
			long[] l = new long[strs.length];
			for(int i =0; i< strs.length; i++){
				l[i] = Long.parseLong(strs[i]);
			}
			br.close();
			return l;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
