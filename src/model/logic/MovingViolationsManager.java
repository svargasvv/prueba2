package model.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import model.data_structures.Queue;
import model.data_structures.Stack;
import model.vo.VODaylyStatistic;
import model.vo.VOMovingViolations;

public class MovingViolationsManager {
	
	private Stack<VOMovingViolations> stack = new Stack<VOMovingViolations>();
	private Queue<VODaylyStatistic> queue= new Queue<VODaylyStatistic>();

	public void loadMovingViolationsJanuary(String movingViolationsFile){

		File archivo = new File(movingViolationsFile);
		try {
			Scanner sc = new Scanner(archivo);
		
			sc.nextLine();
			while(sc.hasNext()){
				
				String actual = sc.nextLine();
				
				actual=actual.replace(",,,", ",-1,-1,");
				actual=actual.replace(",,", ",-1,");
				actual=actual.replace(", ", "_");

				StringTokenizer st = new StringTokenizer(actual,",");

				ArrayList<String> datosActual = new ArrayList<String>();

				while(st.hasMoreTokens()){

					datosActual.add(st.nextToken());


				}
				queue.enqueue(new VODaylyStatistic(datosActual.get(8), datosActual.get(12),datosActual.get(13)));
				stack.push(new VOMovingViolations(datosActual.get(0), datosActual.get(2),datosActual.get(13), datosActual.get(15)));

			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void loadMovingViolationsFebruary(String movingViolationsFile){

		File archivo = new File(movingViolationsFile);
		try {
			Scanner sc = new Scanner(archivo);
		
			sc.nextLine();
			while(sc.hasNext()){
				
				String actual = sc.nextLine();
				
				actual=actual.replace(",,,", ",-1,-1,");
				actual=actual.replace(",,", ",-1,");
				actual=actual.replace(", ", "_");

				StringTokenizer st = new StringTokenizer(actual,",");

				ArrayList<String> datosActual = new ArrayList<String>();

				while(st.hasMoreTokens()){

					datosActual.add(st.nextToken());


				}
				stack.push(new VOMovingViolations(datosActual.get(0), datosActual.get(2),datosActual.get(13), datosActual.get(15)));
				queue.enqueue(new VODaylyStatistic(datosActual.get(8), datosActual.get(12),datosActual.get(13)));

			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Stack<VOMovingViolations> darStack()
	{
		return stack;
	}
	
	
	public Queue<VODaylyStatistic> darQueue()
	{
		return queue;
	}

	
}
