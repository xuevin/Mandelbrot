package info.vincentxue.mandelbrot;

import processing.core.PApplet;

public class Main_PApplet extends PApplet{
	double x_start = -3;
	double x_end = 3;
	double y_start= -3;
	double y_end = 3;
	double zooming=1.1;
	
	
	public void setup(){
	  size(200, 200, P2D);
	  loadPixels();
	  colorMode(HSB);
	  frameRate(4);
	}
	
	public void draw(){
		background(255);	
		
		//line(0,0,mouseX,mouseY);
//		double relativeX = (double)mouseX/width;
//		double relativeY = (double)mouseY/height;
		
		double newWidth = (x_end-x_start)/zooming;
		double newHeight = (y_end-y_start)/zooming;
		double clickedAbs_X;
		double clickedAbs_Y;
		
		if(pmouseX!=mouseX && pmouseY!=mouseY){
			 clickedAbs_X = map(mouseX,0,width,x_start,x_end);
			 clickedAbs_Y= map(mouseY,0,height,y_start,y_end);	
		}else{
			clickedAbs_X=((x_end-x_start)/2)+x_start;
			clickedAbs_Y=((y_end-y_start)/2)+y_start;
		}
		
//		System.out.println(x_start);
//		System.out.println(x_end);
		x_start= clickedAbs_X-(newWidth/2);
		x_end= clickedAbs_X+(newWidth/2);
		y_start=clickedAbs_Y-(newHeight/2);
		y_end=clickedAbs_Y+(newHeight/2);
		
		updateArray();
		
	}
	
	private void updateArray(){
		for(int i = 0;i<width;i++){
			for(int j = 0;j<height;j++){
				double x = map(i,0,width,x_start,x_end);
				double y = map(j,0,height,y_start,y_end);
				int iterations = howManyTimes(x,y);
				stroke(iterationToColor(iterations));
				point(i,j);
			}
		}
		
	}
	
	private double map(double i, double low1, double high1, double low2, double high2) {
		return ((i-low1)/(high1-low1))*(high2-low2)+(low2);
		
	}

	private int iterationToColor(int iteration){
		return color(iteration,255,255); 
		
	}
	public int howManyTimes(double x, double y) 
	{
		double dontchangex = x;
		double dontchangey = y;
		int times=0;
		while(((x*x)+(y*y))<=4 && times<8000)
		{	
			double xtemp;
			xtemp=(dontchangex+((x*x)-(y*y)));
			y=(dontchangey+(2*x*y));
			x=xtemp;
			times++;

		}
		return times;
	}
	

}
