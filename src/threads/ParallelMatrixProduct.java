package threads;

public class ParallelMatrixProduct {
   private UsualMatrix m1;
   private UsualMatrix m2;
   private UsualMatrix res;
   private MatrixThread[] thr;
   private int count_threads;
   
   public ParallelMatrixProduct(UsualMatrix a, UsualMatrix b, int n){
       m1 = a;
       m2 = b;
       res = new UsualMatrix(m1.get_row(), m2.get_col());
       count_threads = n;
       thr = new MatrixThread[count_threads];
   }
   
   public UsualMatrix startProduct() throws InterruptedException{
       if(m1.get_col() != m2.get_row()){
            throw new RuntimeException("Данные матрицы перемножить невозможно");
        }
       int first = 0;
       int last = 0;
       int row_result = m1.get_row();
       for(int i = 0; i < count_threads ; i++){
           if(count_threads - 1 == i ){
               last = first + ((row_result/count_threads) + (row_result % count_threads));//res.get_row() * res.get_col();
           }
           else{
                last = first + row_result/count_threads; // на один поток 
           }
           thr[i] = new MatrixThread(m1, m2, res, first, last);
           thr[i].start(); 
           first = last;
       }
       long l = System.currentTimeMillis();
       for(int i = 0; i < count_threads; i++){
           thr[i].join();
           res = thr[i].getResult();
       }
       long l2 = System.currentTimeMillis();
       System.out.println("время произведения матриц (мнопоточ.) = " + (l2 - l));
        
       return res;
   } 
   
       public UsualMatrix productOneThread(){
        if(m1.get_col() != m2.get_row()){
            throw new RuntimeException("Данные матрицы перемножить невозможно");
        }
	int tmp;
	for(int i = 0; i < m1.get_row(); i++){
            for(int j = 0; j < m2.get_col(); j++){
                res.setElement(i,j,0);
                for(int k = 0; k < m1.get_col(); k++){
                    tmp = m1.getElement(i,k) * m2.getElement(k,j);
                    tmp += res.getElement(i,j);
                    res.setElement(i,j,tmp);
                }
            }
	}
        return res;
    }
}
