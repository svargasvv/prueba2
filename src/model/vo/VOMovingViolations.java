package model.vo;

/**
 * Representation of a Trip object MovingViolation
 */
public class VOMovingViolations {

	//Atributos 
	//----------------------------------------------------------------
	private int object_ID;
	private String location; 
	private String ticketDate;
	private String violationDesc; 
	
	public VOMovingViolations(String pObject_ID, String pLocation, String pTicketDate, String pViolationDesc)
	{
		object_ID= Integer.parseInt(pObject_ID);
		location = pLocation;
		ticketDate = pTicketDate;
		violationDesc = pViolationDesc;
		
		
		
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return id - Identificador �nico de la infracci�n
	 */
	public int objectId() {
		// TODO Auto-generated method stub
		return object_ID;
	}	
	
	
	/**
	 * @return location - Direcci�n en formato de texto.
	 */
	public String getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	/**
	 * @return date - Fecha cuando se puso la infracci�n .
	 */
	public String getTicketIssueDate() {
		// TODO Auto-generated method stub
		return ticketDate;
	}
	
	public String getViolationDescription()
	{
		return violationDesc;
	}
	/**
	 * @return totalPaid - Cuanto dinero efectivamente pag� el que recibi� la infracci�n en USD.
	 */
	
}
