class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0){
            return true;
        }
        if(flowerbed.length==1 && flowerbed[0]==0){
            return true;
        }
        else if(flowerbed.length==1 && flowerbed[0]==1){
            return false;
        }
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0 && n!=0){
                if(i==0 && flowerbed[i+1]==0){
                    n--;
                    flowerbed[i]=1;
                }
                else if(i==flowerbed.length-1 && flowerbed[i]==0 && flowerbed[i-1]==0){
                    n--;
                    flowerbed[i]=1;
                }
                else if(i!=0 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
                    n--;
                    flowerbed[i]=1;
                }
            }
            else if(n==0){
                break;
            }
        }
        if(n==0){
            return true;
        }
        else{
            return false;
        }
    }
}