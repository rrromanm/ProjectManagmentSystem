package model;

/**
 * A class that represents an industrial project, which is a subclass of Project.
 * An industrial project has a size, a facility type, and inherits attributes from the Project class.
 *
 * @author Group 1
 */
public class IndustrialProjects extends Project {
    private int size;
    private String facilityType;

    /**
     * A constructor that creates an industrial project with the given parameters.
     *
     * @param name         the name of the industrial project
     * @param budget       the budget of the industrial project in Danish kroner
     * @param startTime    the start date of the industrial project
     * @param status       the status of the industrial project, such as planned, ongoing, completed, etc.
     * @param projectID    the unique identifier of the industrial project
     * @param timeline     the estimated duration of the industrial project in months
     * @param customer     the customer who ordered the industrial project
     * @param resources    the resources allocated to the industrial project
     * @param size         the size of the industrial project in square meters
     * @param facilityType the facility type of the industrial project, such as plant, warehouse, etc.
     */
    public IndustrialProjects(String name, int budget, MyDate startTime, String status,
        int projectID, int timeline, Customer customer, Resources resources, int size, String facilityType) {
        super(name, budget, startTime, status, projectID, timeline, customer, resources);
        this.size = size;
        this.facilityType = facilityType;
        super.setEndTime(startTime.convertMonthsToDate(timeline));
        super.setType("Industrial");
    }

    /**
     * Sets the size of the industrial project in square meters.
     * @param size the size to set for the industrial project
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Gets the size of the industrial project in square meters.
     * @return the size of the industrial project
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the facility type of the industrial project.
     * @param facilityType the facility type to set for the industrial project, such as plant, warehouse, etc.
     */
    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    /**
     * Gets the facility type of the industrial project.
     * @return the facility type of the industrial project
     */
    public String getFacilityType() {
        return facilityType;
    }

    /**
     * A method that checks if two industrial projects are equal based on their attributes.
     * @param obj the object to compare with this industrial project
     * @return true if the object is an industrial project and has the same attributes as this industrial project, false otherwise
     */
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IndustrialProjects other = (IndustrialProjects) obj;
        return super.equals(other) && size == other.size && facilityType.equals(other.facilityType);
    }

    /**
     * A method that returns a string representation of this industrial project.
     * @return a string that contains the information of this industrial project, such as budget, start date, end date, status, project ID, timeline, customer, resources, size, project type, and facility type
     */
    public String toString() {
        return super.toString() + "," + size + "," + facilityType;
    }
}
