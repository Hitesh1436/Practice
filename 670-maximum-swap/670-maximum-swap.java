class Solution {
    public int maximumSwap(int num) {
        char[] arr = (num + "").toCharArray();// number to char array conversion
        int[] right = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--){
            if(i == arr.length - 1){
                right[i] = -1;  // agr sbse bdi value last mn h toh uske right mn koi ni h toh -1 daldia right[i]pr
            } else if(i == arr.length - 2){ // second last pr h toh last vle ka idx dldo
                right[i] = arr.length - 1;
            } else {
    // bki phle h toh usse next value compare krenge arr ke right ke i+1 idx vale se
                if(arr[i + 1] > arr[right[i + 1]]){
                    right[i] = i + 1;
                } else {
                    right[i] = right[i + 1]; 
                }
            }
        }
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] < arr[right[i]]){
                char temp = arr[i];
                arr[i] = arr[right[i]];
                arr[right[i]] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(arr));
    }
}