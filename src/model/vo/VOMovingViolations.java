package model.vo;

/**
 * Representation of a Trip object MovingViolation
 */
public class VOMovingViolations {

  private int objectId;

  private String location;

  private int addressId;

  private int streetSegId;

  private float xCoord;

  private float yCoord;

  private String type;

  private int fineAMT;

  private int totalPaid;

  private int penalty1;

  private int penalty2;

  private String accidentIndicator;

  private String ticketIssue;

  private String violationCode;

  private String violationDesc;

  /**
   * Constructs new VOMovingViolation
   * @param objectId
   * @param location
   * @param addressId
   * @param streetSegId
   * @param xCoord
   * @param yCoord
   * @param type
   * @param fineAMT
   * @param totalPaid
   * @param penalty1
   * @param penalty2
   * @param accidentIndicator
   * @param ticketIssue
   * @param violationCode
   * @param violationDesc
   */
  public VOMovingViolations(int objectId, String location, int addressId, int streetSegId,
      float xCoord, float yCoord, String type, int fineAMT, int totalPaid, int penalty1,
      int penalty2,
      String accidentIndicator, String ticketIssue, String violationCode,
      String violationDesc) {
    this.objectId = objectId;
    this.location = location;
    this.addressId = addressId;
    this.streetSegId = streetSegId;
    this.xCoord = xCoord;
    this.yCoord = yCoord;
    this.type = type;
    this.fineAMT = fineAMT;
    this.totalPaid = totalPaid;
    this.penalty1 = penalty1;
    this.penalty2 = penalty2;
    this.accidentIndicator = accidentIndicator;
    this.ticketIssue = ticketIssue;
    this.violationCode = violationCode;
    this.violationDesc = violationDesc;
  }

  public int objectId() {
    return objectId;
  }

  public String getLocation() {
    return location;
  }

  public int getAddressId() {
    return addressId;
  }

  public int getStreetSegId() {
    return streetSegId;
  }

  public float getxCoord() {
    return xCoord;
  }

  public float getyCoord() {
    return yCoord;
  }

  public String getType() {
    return type;
  }

  public int getFineAMT() {
    return fineAMT;
  }

  public int getTotalPaid() {
    return totalPaid;
  }

  public int getPenalty1() {
    return penalty1;
  }

  public int getPenalty2() {
    return penalty2;
  }

  public String getAccidentIndicator() {
    return accidentIndicator;
  }

  public String getTicketIssueDate() {
    return ticketIssue;
  }

  public String getViolationCode() {
    return violationCode;
  }

  public String getViolationDescription() {
    return violationDesc;
  }
}
