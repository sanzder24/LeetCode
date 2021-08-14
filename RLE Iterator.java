class RLEIterator {
    int index = 0;
    int[] arr;
    public RLEIterator(int[] encoding) {
        arr = encoding;
    }
    
    public int next(int n) {
        int count = 0;
        int res = -1;
        while (index < arr.length && count < n) {
            if (count + arr[index] < n) {
                count += arr[index];
                index += 2;

            }else if (count + arr[index] == n) {
                count += arr[index];
                res = arr[index + 1];
                index += 2;

            }else{
                int diff = n - count;
                arr[index] -= diff;
                res = arr[index + 1];
                count = n;
            }
        }
        return res;
    }
}