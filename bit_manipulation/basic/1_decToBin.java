class 1_decToBin {
    public int findComplement(int num) {
        
        String bin=decToBin(num);
        int n=bin.length();
        StringBuilder complement=new StringBuilder();
        for(int i=0; i<n; i++){
            if(bin.charAt(i)=='0'){
                complement.append('1');
            }else{
                complement.append('0');
            }
        }
        return binToDec(complement.toString());
    }
    String decToBin(int num){
        if(num==0)    return "0";
        StringBuilder bin=new StringBuilder();
        while(num>0){
            bin.insert(0,num%2);
            num/=2;
        }
        return bin.toString();
    }
    int binToDec(String bin){
        int dec=0;
        int n=bin.length();
        for(int i=0; i<n; i++){
            if(bin.charAt(n-i-1)=='1'){
                dec+=Math.pow(2,i);
            }
        }
        return dec;
    }
}