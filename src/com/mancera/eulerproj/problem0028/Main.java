package com.mancera.eulerproj.problem0028;

public class Main {

	public static void main(String[] args) {
		
		int[][] spiral = createSpiral(1001);
		int answer = sumOfDiagonals(spiral);
		System.out.println("Answer: " + answer);

	}
	
	private static int[][] createSpiral(final int dimensions) {
		int[][] spiral = new int[dimensions][dimensions];
		
		int maxNum = dimensions * dimensions;
		int currentX = 0, currentY = dimensions -1, currentNum = maxNum;
		Directions currentDirection = Directions.LEFT;
		
		while(currentNum != 0) {
			
			spiral[currentX][currentY] = currentNum;
			switch(currentDirection) {
				case LEFT:
					if(currentY != 0 && spiral[currentX][currentY-1] == 0) {
						currentY--;						
					} else {
						currentDirection = Directions.DOWN;
						currentX++;
					}					
					break;
				case DOWN:
					if(currentX != dimensions -1 && spiral[currentX+1][currentY] == 0) {
						currentX++;
					}else {
						currentDirection = Directions.RIGHT;
						currentY++;
					}
					break;
				case RIGHT:
					if(currentY != dimensions - 1 && spiral[currentX][currentY + 1] == 0) {
						currentY++;
					} else {
						currentDirection = Directions.UP;
						currentX--;						
					}
					break;
				case UP:
					if(currentX != 0 && spiral[currentX-1][currentY] == 0) {
						currentX--;
					} else {
						currentDirection = Directions.LEFT;
						currentY--;						
					}
			}				
			currentNum--;
		}
		
		return spiral;
		
	}
	
	private static int sumOfDiagonals(final int[][] spiral) {
		int sum = 0;
		int dimension = spiral.length;
		
		for(int i = 0; i < dimension; i++) {
			sum += spiral[i][i];
			sum += spiral[i][dimension - 1 - i];
		}
		
		return sum -1;	
		
	}

	private enum Directions {
		RIGHT,
		DOWN,
		LEFT,
		UP
	}

}
