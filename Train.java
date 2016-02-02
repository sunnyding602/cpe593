import java.util.Scanner;
import java.util.Random;
public class Train
{
    public static void main (String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the candidate number");
        int n = scanner.nextInt();
        System.out.println(millerRabin(n));
    }
    private static boolean millerRabin(int n)
    {
        if(n == 0 || n == 1)
            return false;
        if(n == 2 || n == 3)
            return true;
        if(n % 2 == 0)
            return false;
        Random random = new Random();
        int s = 0;
        int d = 0;
        int m = n - 1;
        while((m & 1) == 0)
        {
            s++;
            m = m >> 1;
        }
        d = m;
        int x;
        for(int i = 0;i < 6;i++)
        {
            int a = random.nextInt(n-3) + 2;
            x = powerMod(a,d,n);
            if(x == 1 || x == n - 1)
                continue;
            int j;
            for(j = 0;j < s - 1;j++)
            {
                x = (x * x) % n;
                if(x == 1)
                    return false;
                else if (x == n - 1)
                    break;
            }
            if(x == n - 1 && j < s - 1)
                continue;
            return false;
        }
        return true;
    }
    private static int powerMod(int x,int n,int m)
    {
        int product = 1;
        while(n > 0)
        {
            if(n % 2 != 0)
                product = product * x % m;
            x = x * x % m;
            n /= 2;
        }
        return product;
    }
}
