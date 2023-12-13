package model;

/**
 * A class that represents a residential project, which is a subclass of Project.
 * A residential project has size, the number of kitchens, the number of bathrooms, rooms with plumbing, and state.
 * It inherits attributes from the Project class.
 * @author Group 1
 */
public class ResidentialProjects extends Project {

    // Fields for size, number of kitchens, number of bathrooms, rooms with plumbing, state, and new build status
    private int size;
    private int numberOfKitchens;
    private int numberOfBathrooms;
    private int roomsWithPlumbing;
    private String state;

    /**
     * A constructor that creates a residential project with the given parameters.
     *
     * @param name              the name of the residential project
     * @param budget            the budget of the residential project in Danish kroner
     * @param startTime         the start date of the residential project
     * @param status            the status of the residential project, such as planned, ongoing, completed, etc.
     * @param projectID         the unique identifier of the residential project
     * @param timeline          the estimated duration of the residential project in months
     * @param customer          the customer who ordered the residential project
     * @param resources         the resources allocated to the residential project
     * @param size              the size of the residential project in square meters
     * @param numberOfKitchens  the number of kitchens in the residential project
     * @param numberOfBathrooms the number of bathrooms in the residential project
     * @param roomsWithPlumbing the number of rooms with plumbing in the residential project
     * @param state             the state of the residential project, such as "under construction" or "completed"
     */
    public ResidentialProjects(String name, int budget, MyDate startTime, String status,
        int projectID, int timeline, Customer customer, Resources resources, int size,
        int numberOfKitchens, int numberOfBathrooms, int roomsWithPlumbing, String state) {
        super(name, budget, startTime, status, projectID, timeline, customer, resources);
        this.size = size;
        this.numberOfKitchens = numberOfKitchens;
        this.numberOfBathrooms = numberOfBathrooms;
        this.roomsWithPlumbing = roomsWithPlumbing;
        this.state = state;
        super.setEndTime(startTime.convertMonthsToDate(timeline));
        super.setType("Residential");
    }

    /**
     * Sets the size of the residential project in square meters.
     * @param size the size to set for the residential project
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Gets the size of the residential project in square meters.
     * @return the size of the residential project
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the number of kitchens in the residential project.
     * @param numberOfKitchens the number of kitchens to set for the residential project
     */
    public void setNumberOfKitchens(int numberOfKitchens) {
        this.numberOfKitchens = numberOfKitchens;
    }

    /**
     * Gets the number of bathrooms in the residential project.
     * @return the number of bathrooms in the residential project
     */
    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    /**
     * Sets the number of bathrooms in the residential project.
     * @param numberOfBathrooms the number of bathrooms to set for the residential project
     */
    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    /**
     * Gets the number of kitchens in the residential project.
     * @return the number of kitchens in the residential project
     */
    public int getNumberOfKitchens() {
        return numberOfKitchens;
    }

    /**
     * Sets the number of rooms with plumbing in the residential project.
     * @param roomsWithPlumbing the number of rooms with plumbing to set for the residential project
     */
    public void setRoomsWithPlumbing(int roomsWithPlumbing) {
        this.roomsWithPlumbing = roomsWithPlumbing;
    }

    /**
     * Gets the number of rooms with plumbing in the residential project.
     * @return the number of rooms with plumbing in the residential project
     */
    public int getRoomsWithPlumbing() {
        return roomsWithPlumbing;
    }

    /**
     * Sets the state of the residential project.
     * @param state the state to set for the residential project, such as "under construction" or "completed"
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the state of the residential project.
     * @return the state of the residential project
     */
    public String getState() {
        return state;
    }

    /**
     * A method that checks if two residential projects are equal based on their attributes.
     * @param obj the object to compare with this residential project
     * @return true if the object is a residential project and has the same attributes as this residential project, false otherwise
     */
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ResidentialProjects other = (ResidentialProjects) obj;
        return super.equals(other) && size == other.size && numberOfKitchens == other.numberOfKitchens &&
                numberOfBathrooms == other.numberOfBathrooms && roomsWithPlumbing == other.roomsWithPlumbing;
    }

    /**
     * A method that returns a string representation of this residential project.
     * @return a string that contains the information of this residential project, such as budget, start date, end date, status, project ID, timeline, customer, resources, size, number of kitchens, number of bathrooms, rooms with plumbing, state, and purpose
     */
    public String toString() {
        return super.toString() + "," + size + "," + numberOfKitchens + "," + numberOfBathrooms + "," + roomsWithPlumbing + "," + state;
    }
}
