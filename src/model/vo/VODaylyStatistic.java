package model.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class VODaylyStatistic {

  //Atributos
  //----------------------------------------------------------------

  /**
   * valor AMT pagado por el infractor de la multa
   */
  private int  fineAMTTotal;

  /**
   * cantidad de accidentes del dia
   */
  private int dayAccidents;

  /**
   * fecha del dia
   */
  private Date ticketDate;
  
  private int size = 0;

  /**
   * Constructor vacio de la clase
   */
  public VODaylyStatistic(){

  }

  /**
   * Incrementa la cantidad de accidentes del dia
   */
  public void increaseDayAccidents(){

    dayAccidents++;

  }

  /**
   * incrementa el total AMT del dia
   * @param amt valor que se agrega al total
   */
  public void increaseTotalAMT(int amt){

    fineAMTTotal += amt;

  }

  /**
   * Inicializa la fecha del dia, si la fecha ya esta inicializada no funciona
   * @param date nueva fecha que se asigna a ticketDate
   */
  public void setDate(Date date){

    if(ticketDate == null){

      ticketDate = date;

    }
  }

  /**
   * Retorna la fecha del dia
   * @return retorna la fecha, si no se ha inicializado retorna null
   */
  public Date getDate(){

    Date result;
    if(ticketDate != null)
      result = ticketDate;
    else
      result = null;

    return result;

  }

  /**
   * Devuelve la cantidad de infracciones que fueron accidentes en el dia
   * @return cantidad de infracciones del dia
   */
  public int getDayAccidents(){

    return dayAccidents;

  }

  /**
   * Devuelve la cantidad total de AMT pagados por los infractores en el dia
   * @return cantidad total de AMT del dia
   */
  public int getFineAMTTotal(){

    return fineAMTTotal;

  }
  
  public void increaseSize() {
	  
	  size++;
	  
  }
 public int getSize() {
	  
	   return size;
	  
  }

}
