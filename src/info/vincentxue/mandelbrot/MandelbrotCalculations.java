package info.vincentxue.mandelbrot;
//----------------------------------------------------------------------------
//
//	MandelbrotCalculations.java				Created by Vincent Xue
//
//
//	Class used to determine how many iterations it takes
//	for a given set of coordinates to become less than 2
//
//----------------------------------------------------------------------------
/**
 * @author Vincent Xue
 *
 */
public class MandelbrotCalculations 
{
	private double[] xValuesArray;
	private double[] yValuesArray;
	
	/**
	 * @param xArray This is the array of the actual x coordinates
	 * @param yArray This is the array of the actual y coordinates
	 */
	public MandelbrotCalculations(double[] xArray,double[]yArray)
	{
		xValuesArray = xArray;
		yValuesArray = yArray;
	}
	/**
	 * @param x integer which represents the x coordinate of the point
	 * @param y integer which represent the y coordinate of the point
	 * @param times integer which represents the number of iteration it takes normally zero
	 * @return the number of times the coordinate iterates
	 */
	public int howManyTimes(double x, double y, int times) 
	{
		double dontchangex = x;
		double dontchangey = y;
		
		while(((x*x)+(y*y))<=4 && times<2041)
		{	
			double xtemp;
			xtemp=(dontchangex+((x*x)-(y*y)));
			y=(dontchangey+(2*x*y));
			x=xtemp;
			times++;

		}
		return times;
	}
	
	//	Need to return an array which will hold how many times the current point iterates.
	//	did somehting wrong here... relook at it..
	
	/**
	 * @return int[][] which represents the x and y coordinate relative to the 500x500 grid.
	 * each element in the array is the number of iterations that point took to escape the mandelbrot set.
	 */
	public int[][] returnArrayOfTimes()
	{
		int[][] array = new int[500][500];
		for(int y=0; y<500; y++)
		{
			for(int x=0; x<500; x++)
			array[y][x]=(howManyTimes(xValuesArray[y],yValuesArray[x],0));
		}
		return array;
	}
	
}
