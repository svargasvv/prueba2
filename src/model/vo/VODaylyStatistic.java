package model.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VODaylyStatistic {

	//Atributos 
	//----------------------------------------------------------------

	private short fineAMT;
	private boolean accidentIndicator; 
	private Date ticketDate;


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




		// TODO Auto-generated constructor stub
	}


	public Date darFecha()
	{
		return ticketDate;
	}
	
	public short darDinero()
	{
		return fineAMT;
	}

	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public boolean  getAccidentIndicator() {
		// TODO Auto-generated method stub
		return accidentIndicator;
	}

}
