class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {

        while(tx>sx && ty>sy){ //will terminate with last set yet to process
          if(ty > tx){
            ty %= tx;
          }
            else {
                tx %=ty;
            }
        }
       return sx == tx && sy <= ty && (ty - sy) % sx == 0 ||  //last step is subtracting and checked for either x or y pos
               sy == ty && sx <= tx && (tx - sx) % sy == 0;
    }
}