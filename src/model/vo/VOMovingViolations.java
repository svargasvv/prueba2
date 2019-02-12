package model.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representation of a Trip object MovingViolation
 */
public class VOMovingViolations {

  //Atributos
  //----------------------------------------------------------------
  private int object_ID;
  private String location;
  private Date ticketDate;
  private String violationDesc;
  private boolean accidentIndicator;


  /**
   * Constructor de un objeto de infraccion
   * @param pObject_ID id de la infraccion (valor unico)
   * @param pLocation ubicacion de la infraccion
   * @param pTicketDate fecha de la infraccion
   * @param pViolationDesc descripcion de la violacion
   * @param accidentIndicator idica si la infraccion se dio por accidente o no
   */
  public VOMovingViolations(String pObject_ID, String pLocation, String pTicketDate,
      String pViolationDesc, String accidentIndicator) {
    object_ID = Integer.parseInt(pObject_ID);
    location = pLocation;
    try {
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      ticketDate = df.parse(pTicketDate.substring(0, 10));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    violationDesc = pViolationDesc;
    this.accidentIndicator = accidentIndicator.equals("Yes");

  }


  /**
   * @return id - Identificador único de la infracción
   */
  public int objectId() {
    return object_ID;
  }


  /**
   * @return location - Dirección en formato de texto.
   */
  public String getLocation() {
    return location;
  }

  /**
   * @return date - Fecha cuando se puso la infracción.
   */
  public Date getTicketIssueDate() {
    return ticketDate;
  }

  /**
   * @return violationDescriprion - Descripcion de la infraccion.
   */
  public String getViolationDescription() {
    return violationDesc;
  }

  /**
   * @return accidentIndicator - Indica si la infraccion fue accidente o no: 'Yes', 'No'
   */
  public boolean getAccidentIndicator() {
    return accidentIndicator;
  }


}
