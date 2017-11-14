package threads;

import java.lang.Thread;

public class MatrixThread extends Thread{
    UsualMatrix mtr1;
    UsualMatrix mtr2;
    UsualMatrix result;
    int index_first;
    int index_last;
    
    public MatrixThread(UsualMatrix mx1, UsualMatrix mx2, UsualMatrix res, int first, int last){
        index_first = first;
        index_last = last;
        mtr1 = mx1;
        mtr2  = mx2;
        result = res;
    }
    
   @Override
   public void run(){
       int tmp = 0;
       for(int p = index_first; p < index_last; p++){
           for(int u = 0; u < mtr2.get_col(); u++){
                result.setElement(p, u, 0);
                    for(int z = 0; z < mtr1.get_col(); z++){
                        tmp = mtr1.getElement(p, z) * mtr2.getElement(z, u);
                        tmp += result.getElement(p, u);
                        result.setElement(p, u, tmp);
                    }
           }
       }
       
   }
    
   public UsualMatrix getResult(){
       return result;
   }
}
