package threads;
import java.util.Scanner;

/*

Задание 8. Thread.
Реализовать класс ParallelMatrixProduct для многопоточного умножения матриц UsualMatrix.
В конструкторе класс получает число потоков, которые будут использованы для перемножения
(число потоков может быть меньше, чем число строк у первой матрицы).

В функции main сравнить время перемножения больших случайных матриц обычным и многопоточным способом.
Получить текущее время можно с помощью методов класса System.

 */

//TODO: lab8
public class Main {

    public static void main(String[] args) throws InterruptedException {
        UsualMatrix matrix1 = new UsualMatrix(4,4);
        UsualMatrix matrix2 = new UsualMatrix(4,4);
        UsualMatrix matrix3 = new UsualMatrix(3,2);
        UsualMatrix matrix4 = new UsualMatrix(2,4);
        
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
