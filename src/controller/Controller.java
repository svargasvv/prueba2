package controller;

import java.util.Scanner;

import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.data_structures.Queue;
import model.data_structures.Stack;
import model.logic.MovingViolationsManager;
import model.vo.VODaylyStatistic;
import model.vo.VOMovingViolations;
import view.MovingViolationsManagerView;

public class Controller {
 
	private MovingViolationsManagerView view;
	private static MovingViolationsManager  manager = new MovingViolationsManager();
	/**
	 * Cola donde se van a cargar los datos de los archivos
	 */
	private Queue<VODaylyStatistic> movingViolationsQueue;
	
	/**
	 * Pila donde se van a cargar los datos de los archivos
	 */
	private Stack<VOMovingViolations> movingViolationsStack;


	public Controller() {
		view = new MovingViolationsManagerView();
		manager = new MovingViolationsManager();
		//TODO, inicializar la pila y la cola
		movingViolationsQueue = new Queue<VODaylyStatistic>();
		movingViolationsStack = new Stack <VOMovingViolations>();
	}
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		
		while(!fin)
		{
			view.printMenu();
			
			int option = sc.nextInt();
			
			switch(option)
			{
				case 1:
					this.loadMovingViolations();
					break;
					
				case 2:
					IQueue<VODaylyStatistic> dailyStatistics = this.getDailyStatistics();
					view.printDailyStatistics(dailyStatistics);
					break;
					
				case 3:
					view.printMensage("Ingrese el número de infracciones a buscar");
					int n = sc.nextInt();

					IStack<VOMovingViolations> violations = this.nLastAccidents(n);
					view.printMovingViolations(violations);
					break;
											
				case 4:	
					fin=true;
					sc.close();
					break;
			}
		}
	}

	

	public void loadMovingViolations() {
		manager.loadMovingViolationsJanuary("data/Moving_Violations_Issued_in_January_2018_ordered");
		manager.loadMovingViolationsFebruary("data/Moving_Violations_Issued_in_February_2018_ordered");
		
	
	}
	
	public IQueue <VODaylyStatistic> getDailyStatistics () {
		// TODO
		return null;
	}
	
	public IStack <VOMovingViolations> nLastAccidents(int n) {
		// TODO
		return null;
	}
}
