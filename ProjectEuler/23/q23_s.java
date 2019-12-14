public class q23_s {
	public static void euler23(){
        int LIMIT = 28123;
        int[] divisorsSum = new int[LIMIT];
        boolean[] abundantSum = new boolean[LIMIT];
        int sum = 0;
        
        //compute the sum of divisor for every number below 28123
        for (int i = 1 ; i < divisorsSum.length ; i++)
            for(int n = i+i ; n < divisorsSum.length ; n += i)
                divisorsSum[n] += i;
        
        for (int i = 1 ; i < LIMIT ; i++)
            if(i < divisorsSum[i])
                for(int j = i ; j < LIMIT - i ; j++) // ie: i=12 , j < LIMIT-12
                    if( j < divisorsSum[j] )         // 12+j will be < LIMIT
                        abundantSum[i+j] = true;     // never adding if above LIMIT
                                                     // and not causing an 
        for (int i = 0; i < LIMIT; i++)              // ArrayIndexOutOfBoundsException
            if (!abundantSum[i])
                sum += i;
        
        System.out.println(sum);
    }
	public static void main(String[] args) {
		euler23();
	}
}