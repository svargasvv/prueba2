package model.vo;

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
  private short fineAMTTotal;

  /**
   * cantidad de accidentes del dia
   */
  private int dayAccidents;

  /**
   * fecha del dia
   */
  private Date ticketDate;

  /**
   * Constructor vacio de la clase
   */
  public VODaylyStatistic(){

    fineAMTTotal = 0;
    dayAccidents = 0;

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
  public void increaseTotalAMT(short amt){

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


}
