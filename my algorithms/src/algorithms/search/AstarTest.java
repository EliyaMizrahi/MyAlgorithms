package algorithms.search;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;


public class AstarTest {

	@Test
	public void numberOfNodesEvaluatedTest() {
		byte[] myMaze = {0,0,0,5,0,0,0,5,0,0,0,5,0,0,0,2,0,0,0,1,0,0,0,0,0,0,0,2,0,0,0,3,0,0,0,0,
				  
				  1,1,1,1,1,
				  1,1,1,1,1,
				  1,1,1,1,1,
				  1,1,1,1,1,
				  1,1,1,1,1,
				  
				  1,1,1,1,1,
				  1,0,1,0,1,
				  1,1,1,1,1,
				  1,0,1,0,1,
				  1,1,1,1,1,
				  
				  1,1,1,1,1,
				  0,0,0,1,1,
				  1,0,0,1,1,
				  0,0,0,1,1,
				  1,1,1,1,1,
				  
				  1,1,1,1,1,
				  1,0,0,0,1,
				  1,0,1,1,1,
				  1,0,1,1,1,
				  1,1,1,1,1,
				  
				  1,1,1,1,1,
				  1,1,1,1,1,
				  1,1,1,1,1,
				  1,1,1,1,1,
				  1,1,1,1,1};
		
		Maze3d maze3d= null;
		try {
			maze3d = new Maze3d(myMaze);
		} catch (IOException e) {
			e.printStackTrace();
		}

		CommonSearcher<Position> commonSearcher = new Astar<Position>(new MazeAirDistance());
		MazeSearchable mazeSearchable = new MazeSearchable(maze3d);
		Solution<Position> solution = commonSearcher.search(mazeSearchable);

		assertEquals(16, commonSearcher.getNumberOfNodesEvaluated());
	}
	
	
	@Test
	public void theBestSolution() {
		byte [] myMaze = {0,0,0,5,0,0,0,5,0,0,0,5,0,0,0,2,0,0,0,1,0,0,0,0,0,0,0,2,0,0,0,3,0,0,0,0,
						  
						  1,1,1,1,1,
						  1,1,1,1,1,
						  1,1,1,1,1,
						  1,1,1,1,1,
						  1,1,1,1,1,
						  
						  1,1,1,1,1,
						  1,0,1,0,1,
						  1,1,1,1,1,
						  1,0,1,0,1,
						  1,1,1,1,1,
						  
						  1,1,1,1,1,
						  0,0,0,1,1,
						  1,0,0,1,1,
						  0,0,0,1,1,
						  1,1,1,1,1,
						  
						  1,1,1,1,1,
						  1,0,0,0,1,
						  1,0,1,1,1,
						  1,0,1,1,1,
						  1,1,1,1,1,
						  
						  1,1,1,1,1,
						  1,1,1,1,1,
						  1,1,1,1,1,
						  1,1,1,1,1,
						  1,1,1,1,1};
		
		Maze3d maze3d= null;
		try {
			maze3d = new Maze3d(myMaze);
		} catch (IOException e) {
			e.printStackTrace();
		}

		CommonSearcher<Position> commonSearcher = new Astar<Position>(new MazeAirDistance());
		MazeSearchable mazeSearchable = new MazeSearchable(maze3d);
		Solution<Position> solution = commonSearcher.search(mazeSearchable);
		Solution<Position> bestSolution = new Solution<Position>();
		
		bestSolution.getSolution(new Position(2, 3, 0));
		bestSolution.getSolution(new Position(2, 3, 1));
		bestSolution.getSolution(new Position(2, 2, 1));
		bestSolution.getSolution(new Position(2, 1, 1));
		bestSolution.getSolution(new Position(2, 1, 0));

		
		assertEquals(bestSolution, solution);
		
		bestSolution.printStack();
		solution.printStack();

	}
	

  @Test
  public void startAndGoalAreSameTest() {

		byte [] myMaze = {0,0,0,5,0,0,0,5,0,0,0,5,0,0,0,1,0,0,0,2,0,0,0,0,0,0,0,1,0,0,0,2,0,0,0,0,
		  
						  1,1,1,1,1,
						  1,1,1,1,1,
						  1,1,1,1,1,
						  1,1,1,1,1,
						  1,1,1,1,1,
		  
						  1,1,1,1,1,
						  1,1,1,1,1,
						  0,0,0,1,1,
						  1,0,0,1,1,
						  1,1,1,1,1,
		  
						  1,1,1,1,1,
						  1,0,1,0,1,
						  1,1,1,1,1,
						  1,0,1,0,1,
						  1,1,1,1,1,
		  
						  1,1,1,1,1,
						  1,0,0,0,1,
						  1,0,1,1,1,
						  1,0,1,1,1,
						  1,1,1,1,1,
		  
						  1,1,1,1,1,
						  1,1,1,1,1,
						  1,1,1,1,1,
						  1,1,1,1,1,
						  1,1,1,1,1};
		

		Maze3d maze3d= null;
		try {
			maze3d = new Maze3d(myMaze);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		CommonSearcher<Position> commonSearcher = new Astar<Position>(new MazeAirDistance());
		MazeSearchable mazeSearchable = new MazeSearchable(maze3d);
		Solution<Position> solution = commonSearcher.search(mazeSearchable);
		Solution<Position> bestSolution = new Solution<Position>();
		
		bestSolution.getSolution(new Position(1, 2, 0));
		
		assertEquals(bestSolution, solution);
		bestSolution.printStack();
		solution.printStack();
	}

}
