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
  private short fineAMTTotal;

  /**
   * cantidad de accidentes del dia
   */
  private int dayAccidents;

<<<<<<< HEAD
  /**
   * fecha del dia
   */
  private Date ticketDate;

  /**
   * Constructor vacio de la clase
   */
  public VODaylyStatistic(){
=======
	public VODaylyStatistic( String pFineAMT,  String pAccidentIndicator , String pTicketDate)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 
		fineAMT= Short.parseShort(pFineAMT);
		accidentIndicator=(pAccidentIndicator.equals("Yes"))? true : false;
		try {
			ticketDate = sdf.parse(pTicketDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ticketDate= null;
		} //IMPLEMENTAR
>>>>>>> 87b0eaafbf4170ba35e7e01b22bd076dfd3ec52e

    fineAMTTotal = 0;
    dayAccidents = 0;

  }

  /**
   * Incrementa la cantidad de accidentes del dia
   */
  public void increaseDayAccidents(){

    dayAccidents++;

  }

<<<<<<< HEAD
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
=======
	public Date darFecha()
	{
		return ticketDate;
	}
	
	public short darDinero()
	{
		return fineAMT;
	}
>>>>>>> 87b0eaafbf4170ba35e7e01b22bd076dfd3ec52e


}
