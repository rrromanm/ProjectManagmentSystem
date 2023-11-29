package model;

/**
 * A class that represents a commercial project, which is a subclass of Project.
 * A commercial project has a size, a number of floors, and a usage type.
 * @author Maciej Matuszewski
 */
public class CommercialProject extends Project {

    // Fields for size, floors, and usage type
    private int size;
    private short floors;
    private String usage;

    /**
     * A constructor that creates a commercial project with the given parameters.
     * @param size the size of the project in square meters
     * @param floors the number of floors in the project
     * @param usage the usage type of the project, such as office, retail, hotel, etc.
     * @param budget the budget of the project in Danish kroner
     * @param startTime the start date of the project
     * @param endTime the end date of the project
     * @param status the status of the project, such as planned, ongoing, completed, etc.
     * @param projectID the unique identifier of the project
     * @param timeline the estimated duration of the project in months
     * @param customer the customer who ordered the project
     * @param resources the resources allocated to the project
     */
    public CommercialProject(int budget,
        MyDate startTime,String status, int projectID, int timeline, Customer customer, Resources resources, int size, short floors, String usage) {
        super(budget, startTime, status, projectID, timeline, customer, resources);
        this.size = size;
        this.floors = floors;
        this.usage = usage;
        super.setEndTime(startTime.convertMonthsToDate(timeline));
        super.setType("Commercial");
    }

    /**
     * A constructor that creates a commercial project with default values for some parameters.
     * @param floors the default number of floors in the project (1)
     * @param usage the default usage type of the project (restaurant)
     * @param budget the budget of the project in Danish kroner
     * @param startTime the start date of the project
     * @param endTime the end date of the project
     * @param status the status of the project, such as planned, ongoing, completed, etc.
     * @param projectID the unique identifier of the project
     * @param timeline the default estimated duration of the project in months (18 months)
     * @param customer the customer who ordered the project
     * @param resources the resources allocated to the project
     * @param size the size of the project in square meters
     */
    public CommercialProject(int budget, MyDate startTime, int projectID,Customer customer, Resources resources, int size, String usage){
        super(budget, startTime, "under construction", projectID, 18, customer, resources);
        this.size = size;
        this.floors = 1;
        this.usage = usage;
        super.setEndTime(startTime.convertMonthsToDate(18));
        super.setType("Commercial");
    }

    /**
     * Gets the size of the project in square meters.
     * @return the size of the project
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size of the project in square meters.
     * @param size the size to set for the project
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Gets the number of floors in the project.
     * @return the number of floors in the project
     */
    public short getFloors() {
        return floors;
    }

    /**
     * Sets the number of floors for the project.
     * @param floors the number of floors to set for the project
     */
    public void setFloors(short floors) {
        this.floors = floors;
    }

    /**
     * Gets the usage type of the project, such as office, retail, hotel, etc.
     * @return the usage type of the project
     */
    public String getUsage() {
        return usage;
    }

    /**
     * Sets the usage type for the project, such as office, retail, hotel, etc.
     * @param usage the usage type to set for the project
     */
    public void setUsage(String usage) {
        this.usage = usage;
    }

    /**
     * A method that checks if two commercial projects are equal based on their attributes.
     * @param obj the object to compare with this commercial project
     * @return true if the object is a commercial project and has the same attributes as this commercial project, false otherwise
     */
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        } else {
            CommercialProject other = (CommercialProject)obj;
            return super.equals(other) && usage.equals(other.usage) && size == other.size && floors == other.floors;
        }
    }

    /**
     * A method that returns a string representation of this commercial project.
     * @return a string that contains the information of this commercial project, such as budget, start date, end date, status, project ID, timeline, customer, resources, usage, size, and floors
     */
    public String toString(){
        return super.toString() + "\nUsage: "+usage+"\nSize: "+size+"\nFloors: "+floors;
    }
}
