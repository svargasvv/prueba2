package model.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

import model.data_structures.Queue;
import model.data_structures.Stack;
import model.vo.VODaylyStatistic;
import model.vo.VOMovingViolations;

public class MovingViolationsManager {

  /**
   * Pila que contiene todas las infracciones individuales
   */
  private Stack<VOMovingViolations> violationsStack = new Stack<VOMovingViolations>();

  /**
   * Cola que contiene las estadisticas diarias de las infracciones
   */
  private Queue<VODaylyStatistic> statisticsQueue = new Queue<VODaylyStatistic>();

  /**
   * Solo para pruebas. Variable que indica la cantidad de lineas cargadas.
   */
  private int counter;

  /**
   * Carga las infracciones de movimiento del mes de Febrero
   * @param movingViolationsFile ruta del archivo csv de infracciones
   */
  public void loadMovingViolations(String movingViolationsFile) {

    File archivo = new File(movingViolationsFile);
    //Contador solo para pruebas
    counter = 0;
    try {
      Scanner sc = new Scanner(archivo);

      String line = sc.nextLine();
      System.out.println(line);

      VODaylyStatistic dayStats = new VODaylyStatistic();

      while (sc.hasNext()) {

        ArrayList<String> datosActual = new ArrayList<String>();

        try {

          String actual = sc.nextLine();

          actual = actual.replace(",,,", ",-1,-1,");
          actual = actual.replace(",,", ",-1,");
          actual = actual.replace(", ", "_");

          StringTokenizer st = new StringTokenizer(actual, ",");

          while (st.hasMoreTokens()) {

            datosActual.add(st.nextToken());

          }

          System.out.println(datosActual.get(0));


          SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
          Date ticketDate = df.parse(datosActual.get(13).substring(0, 10));
          boolean huboAccidente = datosActual.get(12).equals("Yes");

          /*
          Este codigo registra las estadisticas diarias del archivo en objetos VODaylyStatistics
          que son almacenados en el Queue statisticsQueue.

          Si la fecha del actual es diferente de la fecha del anterior se registra el dia, de lo
          contrario la informacion del dia sigue incrementando
           */
          if(dayStats.getDate() != null){

            if(dayStats.getDate().equals(ticketDate)){
              dayStats.increaseTotalAMT(Short.valueOf(datosActual.get(8)));
              if(huboAccidente)
                dayStats.increaseDayAccidents();
            }
            else{
              statisticsQueue.enqueue(dayStats);
              dayStats = new VODaylyStatistic();
              dayStats.increaseTotalAMT(Short.valueOf(datosActual.get(8)));
              if(huboAccidente)
                dayStats.increaseDayAccidents();
            }

          }
          //Si aun no se ha inicializado el primer dia
          else{
            dayStats.setDate(ticketDate);
            dayStats.increaseTotalAMT(Short.valueOf(datosActual.get(8)));
            if(huboAccidente)
              dayStats.increaseDayAccidents();
          }

          violationsStack.push(
              new VOMovingViolations(datosActual.get(0), datosActual.get(2), datosActual.get(13),
                  datosActual.get(15), datosActual.get(12)));

          counter++;
          /*
          Se lanza una excepcion si se encuentra un error en la fecha pero la linea se ignora y el
          ciclo continua
           */
        } catch (ParseException e) {
          System.out
              .println("El elemento con id:" + datosActual.get(0) + " tiene una fecha invalida");
        }

      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    System.out.println(counter + " lineas cargadas con exito");
  }

  /**
   * Solo para pruebas. retorna la cantidad de lineas cargadas
   * @return cantidadLineasCargadas
   */
  public int darCantidadLineasCargadas(){
    return counter;
  }

  /**
   * Retorna una pila con la informacion diaria de las infracciones de transito
   */
  public Queue<VODaylyStatistic> getDailyStatistics() {

    return statisticsQueue;

  }

  /**
   * Imprime la información de las ultimas n infracciones que fueron accidentes en consola
   * informacion OBJECTID, TICKETISSUEDATE, LOCATION y VIOLATIONDESC.
   *
   * @param n numero de infracciones que se analiza
   */
  public Stack<VOMovingViolations> nLastAccidents(int n) {

    Stack<VOMovingViolations> temp = violationsStack;

    Stack<VOMovingViolations> newStack = new Stack<>();

    for (int i = 0, j = 0; i < temp.size() && j < n; i++) {

      VOMovingViolations stat = temp.pop();

      if (stat.getAccidentIndicator()) {
        newStack.push(stat);
        j++;
      }

    }

    return newStack;
  }

}
