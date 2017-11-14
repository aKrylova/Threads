
package threads;

import java.util.Random;

/**
 *
 * @author ersv
 */
public class UsualMatrix {
    private int[][] matrix;
    private int row;
    private int col;
	
    public UsualMatrix(int r,int c){
        final Random random = new Random();
	matrix = new int[r][c];
	row = r;
	col = c;
	for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                matrix[i][j] = 0;//random.nextInt();
    }

    public void setElement(int r, int c, int value){
		if((r >= row) || (c >= col) ){
			throw new RuntimeException("Выход за границы матрицы");
		}
                this.matrix[r][c] = value;
    }

    public int getElement(int r, int c){
		if((r >= row) || (c >= col) ){
			throw new RuntimeException("Выход за границы матрицы");
		}
	return this.matrix[r][c];
    }
    
    @Override
    public final String toString(){
	       StringBuilder str = new StringBuilder();
			for(int i = 0; i < row; i++) { 
				for(int j = 0; j < col; j++) { 
					str.append(matrix[i][j] + " "); 
				} 
				str.append("\n"); 
			} 
			String result = str.toString(); 
			return result; 
	}
    
    
    public int get_row(){
        return row;
    }
    
    public int get_col(){
        return col;
    }
}