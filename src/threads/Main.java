package threads;
import java.util.Scanner;

/**
 *
 * @author ersv
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        UsualMatrix matrix1 = new UsualMatrix(4,4);
        UsualMatrix matrix2 = new UsualMatrix(4,4);
        UsualMatrix matrix3 = new UsualMatrix(3,2);
        UsualMatrix matrix4 = new UsualMatrix(2,4);
        
        matrix1.setElement(0, 0, 2);
        matrix1.setElement(0, 1, 0);
        matrix1.setElement(0, 2, -5);
        matrix1.setElement(0, 3, 1);
        matrix1.setElement(1, 0, 7);
        matrix1.setElement(1, 1, 1);
        matrix1.setElement(1, 2, -1);
        matrix1.setElement(1, 3, 2);
        matrix1.setElement(2, 0, 5);
        matrix1.setElement(2, 1, 5);
        matrix1.setElement(2, 2, 1);
        matrix1.setElement(2, 3, -2);
        matrix1.setElement(3, 0, 8);
        matrix1.setElement(3, 1, 1);
        matrix1.setElement(3, 2, 1);
        matrix1.setElement(3, 3, 0);
        
        matrix2.setElement(0, 0, 3);
        matrix2.setElement(0, 1, 0);
        matrix2.setElement(0, 2, -1);
        matrix2.setElement(0, 3, 2);
        matrix2.setElement(1, 0, -5);
        matrix2.setElement(1, 1, 6);
        matrix2.setElement(1, 2, 1);
        matrix2.setElement(1, 3, -2);
        matrix2.setElement(2, 0, 0);
        matrix2.setElement(2, 1, 1);
        matrix2.setElement(2, 2, 3);
        matrix2.setElement(2, 3, 1);
        matrix2.setElement(3, 0, 0);
        matrix2.setElement(3, 1, 3);
        matrix2.setElement(3, 2, 4);
        matrix2.setElement(3, 3, 3);
        
        matrix3.setElement(0, 0, 0);
        matrix3.setElement(0, 1, 1);
        matrix3.setElement(1, 0, 2);
        matrix3.setElement(1, 1, 1);
        matrix3.setElement(2, 0, -1);
        matrix3.setElement(2, 1, 3);
        
        matrix4.setElement(0, 0, 0);
        matrix4.setElement(0, 1, 1);
        matrix4.setElement(0, 2, 0);
        matrix4.setElement(0, 3, 1);
        matrix4.setElement(1, 0, 3);
        matrix4.setElement(1, 1, -1);
        matrix4.setElement(1, 2, 0);
        matrix4.setElement(1, 3, -2);

        
        Scanner in = new Scanner(System.in);
        System.out.print("Input count threads:");
        int count_thr = in.nextInt();
        System.out.print("count threads: ");
        System.out.println(count_thr); 
        
        ParallelMatrixProduct coordinator = new ParallelMatrixProduct(matrix1, matrix2, count_thr);
        ParallelMatrixProduct coordinator2 = new ParallelMatrixProduct(matrix3, matrix4, count_thr);
        
        try{
            UsualMatrix result2 = coordinator.startProduct();
            
            long l = System.currentTimeMillis();
            UsualMatrix result1 = coordinator.productOneThread();
            long l2 = System.currentTimeMillis();
            System.out.println("time matrix product (one thread) = " + (l2 - l));
            
            System.out.println(result2);
            
            UsualMatrix result3 = coordinator2.startProduct();
            System.out.println(result3);
            
            
        }
        catch(RuntimeException ex){
            ex.getMessage();
        }
    }
    
}
