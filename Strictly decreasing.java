 public static boolean check(int[] arr, int n)
    {
 

        int modify = 0;
        if (arr[n - 1] >= arr[n - 2]) {
            arr[n - 1] = arr[n - 2] - 1;
            modify++;
        }
        if (arr[0] <= arr[1]) {
            arr[0] = arr[1] + 1;
            modify++;
        }
        for (int i = n - 2; i > 0; i--) {

            if ((arr[i - 1] <= arr[i] && arr[i + 1] <= arr[i]) //finding common numbers to sequence in if 'i' is high
                || (arr[i - 1] >= arr[i] && arr[i + 1] >= arr[i])) { //if low

                arr[i] = (arr[i - 1] + arr[i + 1]) / 2;
                modify++;
                if (arr[i] == arr[i - 1] || arr[i] == arr[i + 1])
                    return false;
            }
        }
 
        // If more than 1 modification is required
        if (modify > 1)
            return false;
 
        return true;
    }