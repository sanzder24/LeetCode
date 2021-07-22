class ParkingSystem {
    private int[] size;
    private int[] check;
    public ParkingSystem(int big, int medium, int small) {
        size = new int[3];
        check = new int[3];
        size[0] = big;
        size[1] = medium;
        size[2] = small;
    }
    
    public boolean addCar(int carType) {
     switch (carType){
            case 1: if(check[carType-1] < size[0]) check[carType-1]++;
                 else return false;   
                break;
        case 2: if(check[carType-1] < size[1]) check[carType-1]++; 
                else return false;  
                break;
        case 3: if(check[carType-1] < size[2]) check[carType-1]++;
                else return false;             
                break; 
     }
         return true;
    }
   
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */