import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SudokuServlet")
public class SudokuServlet extends HttpServlet{
	  private static final int N = 9;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int matrix [][] = new int[9][9];
		
		System.out.println(request.getParameter(1+","+1));
		
		
		for(int j=0;  j<=8; j++){
			for(int k=0; k<=8;k++) {
				matrix[j][k] = Integer.parseInt(request.getParameter(j+","+k));
			}
		}
		
		for(int j=0 ; j<=8; j++) {
			System.out.println(Arrays.toString(matrix[j]));
		}
		 if (solveSudoku(matrix)) {
	            for (int i = 0; i < N; i++) {
	                for (int j = 0; j < N; j++) {
	                    System.out.print(matrix[i][j] + " ");
	                }
	                System.out.println();
	            }
	        } else {
	            System.out.println("Sudoku can't be solved");
	        }
		 
		 for(int i=0;i<N;i++)
			 for(int j=0;j<N;j++)
		 request.setAttribute("element"+i+j,matrix[i][j]);
		 
		 request.getRequestDispatcher("display.jsp").forward(request, response);
		 
	    }

	    private static boolean solveSudoku(int[][] matrix) {
	        RowColumn rc = new RowColumn(0, 0);
	        if (!findFreeLocation(matrix, rc)) {
	            return true;
	        }
	        for (int num = 1; num <= N; num++) {
	            if (isLegal(matrix, rc.row, rc.column, num)) {
	                matrix[rc.row][rc.column] = num;
	                if (solveSudoku(matrix)) {
	                    return true;
	                }
	                matrix[rc.row][rc.column] = 0;
	            }
	        }
	        return false;
	    }

	    //to check if putting a number in row, column or box doesnt affect the logic of sudoku
	    private static boolean isLegal(int[][] matrix, int row, int column, int num) {
	        return !usedInRow(matrix, row, num)
	                && !usedInColumn(matrix, column, num)
	                && !usedInBox(matrix, row - row % 3, column - column % 3, num);
	    }

	    //to check if the particular number is used in the matrix of 9X9
	    private static boolean usedInBox(int[][] matrix, int boxStartingRow, int boxStartingColumn, int num) {
	        //setting number of rows of every box to 3 which is default in sudoku
	        for (int row = 0; row < 3; row++) {
	            //setting number of columns of every box to 3 which is default in sudoku
	            for (int column = 0; column < 3; column++) {
	                if (matrix[row + boxStartingRow][column + boxStartingColumn] == num) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

	    //to check if a particular number is used in a column
	    private static boolean usedInColumn(int[][] matrix, int column, int num) {
	        for (int row = 0; row < N; row++) {
	            if (matrix[row][column] == num) {
	                return true;
	            }
	        }
	        return false;
	    }

	    //to check if a particular number is used in a row
	    private static boolean usedInRow(int[][] matrix, int row, int num) {
	        for (int column = 0; column < N; column++) {
	            if (matrix[row][column] == num) {
	                return true;
	            }
	        }
	        return false;
	    }

	    //to find a location which is not assigned a number
	    private static boolean findFreeLocation(int[][] matrix, RowColumn rc) {
	        for (rc.row = 0; rc.row < N; rc.row++) {
	            for (rc.column = 0; rc.column < N; rc.column++) {
	                if (matrix[rc.row][rc.column] == 0) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }    
	    private static class RowColumn {
	        int row;
	        int column;
	        RowColumn(int row, int column) {
	            this.row = row;
	            this.column = column;
	        }
	    }
	}
