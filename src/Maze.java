import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Maze extends JFrame{
	private int[][] maze = 
		       {{1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,1,0,1,0,1,0,0,0,0,0,1},
				{1,0,1,0,0,0,1,0,1,1,1,0,1},
				{1,0,1,1,1,1,1,0,0,0,0,0,1},
				{1,0,0,1,0,0,0,0,1,1,1,0,1},
				{1,0,1,0,1,1,1,0,1,0,0,0,1},
				{1,0,1,0,1,0,0,0,1,1,1,0,1},
				{1,0,1,0,1,1,1,0,1,0,1,0,1},
				{1,0,0,0,0,0,0,0,0,0,1,9,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1},
		       };
	
	public List<Integer> path = new ArrayList<>();
	
	public Maze() 
	{
		this.setTitle("Maze Solver");
		this.setSize(640,720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.white);
		
		DepthFirstSearch.searchPath(maze, 1, 1, path);
		System.out.println(path);
	}
	
	@Override
	public void paint(Graphics g) 
	{
		g.translate(50, 50);
		for(int i=0 ; i<maze.length ; i++) 
		{
			for(int j=0 ; j<maze[0].length ; j++) 
			{
				Color color;
				switch(maze[i][j]) 
				{
					case 1 : color = Color.black; break;
					case 9 : color = Color.red; break;
					default : color = Color.white;
				}
				g.setColor(color);
				g.fillRect(30*j, 30*i, 30, 30);
				g.setColor(Color.red);
				g.drawRect(30*j, 30*i, 30, 30);
			}
		}
		for(int i=0 ; i<path.size() ; i+=2) 
		{
			int pathx = path.get(i+1);
			int pathy = path.get(i);
			
			g.setColor(Color.green);
			g.fillRect(30*pathx, 30*pathy, 25, 25);
		}
	}
}
