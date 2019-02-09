package model.vo;

import java.util.Date;

public class VODaylyStatistic {

	//Atributos 
	//----------------------------------------------------------------

	private short fineAMT;
	private boolean accidentIndicator; 
	private Date ticketDate;


	public VODaylyStatistic( String pFineAMT,  String pAccidentIndicator , String pTicketDate)
	{

		fineAMT= Short.parseShort(pFineAMT);
		accidentIndicator=(pAccidentIndicator.equals("Yes"))? true : false;
		ticketDate = null; //IMPLEMENTAR




		// TODO Auto-generated constructor stub
	}


	/**
	 * @return id - Identificador único de la infracción
	 */


	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public boolean  getAccidentIndicator() {
		// TODO Auto-generated method stub
		return accidentIndicator;
	}

}
