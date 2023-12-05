package model;

/**
 * A class that represents a road construction project, which is a subclass of Project.
 * A road construction project has attributes such as width, length, number of bridges, number of tunnels,
 * environmental challenges, and geographical challenges. It inherits attributes from the Project class.
 * @author all Group 1 members
 */
public class RoadConstruction extends Project {

    // Fields for width, length, number of bridges, number of tunnels, environmental challenges, and geographical challenges
    private String name;
    private int width;
    private int length;
    private int bridges;
    private int tunnels;
    private String environmentalChallenges;
    private String geographicalChallenges;

    /**
     * A constructor that creates a road construction project with the given parameters.
     *
     * @param name
     * @param budget                  the budget of the road construction project in Danish kroner
     * @param startTime               the start date of the road construction project
     * @param status                  the status of the road construction project, such as planned, ongoing, completed, etc.
     * @param projectID               the unique identifier of the road construction project
     * @param timeline                the estimated duration of the road construction project in months
     * @param customer                the customer who ordered the road construction project
     * @param resources               the resources allocated to the road construction project
     * @param width                   the width of the road in meters
     * @param length                  the length of the road in meters
     * @param bridges                 the number of bridges in the road construction project
     * @param tunnels                 the number of tunnels in the road construction project
     * @param environmentalChallenges the environmental challenges associated with the road construction project
     * @param geographicalChallenges  the geographical challenges associated with the road construction project
     */
    public RoadConstruction(String name, int budget, MyDate startTime,String status, int projectID, int timeline,
                            Customer customer, Resources resources, int width, int length, int bridges, int tunnels,
                            String environmentalChallenges, String geographicalChallenges) {
        super(budget, startTime, status, projectID, timeline, customer, resources);
        this.width = width;
        this.length = length;
        this.bridges = bridges;
        this.tunnels = tunnels;
        this.environmentalChallenges = environmentalChallenges;
        this.geographicalChallenges = geographicalChallenges;
        super.setEndTime(startTime.convertMonthsToDate(timeline));
        super.setType("RoadConstruction");
    }

    /**
     * Adds an environmental challenge to the road construction project.
     * @param challenge the environmental challenge to add
     */
    public void addEnvironmentalChallenge(String challenge) {
        if (environmentalChallenges.equals("none")) {
            environmentalChallenges = "";
            environmentalChallenges += challenge;
        } else {
            environmentalChallenges += ", " + challenge;
        }
    }

    /**
     * Adds a geographical challenge to the road construction project.
     * @param challenge the geographical challenge to add
     */
    public void addGeographicalChallenge(String challenge) {
        if (geographicalChallenges.equals("none")) {
            geographicalChallenges = "";
            geographicalChallenges += challenge;
        } else {
            geographicalChallenges += ", " + challenge;
        }
    }

    /**
     * Gets the width of the road in meters.
     * @return the width of the road
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width of the road in meters.
     * @param width the width to set for the road
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Gets the length of the road in meters.
     * @return the length of the road
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the length of the road in meters.
     * @param length the length to set for the road
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Gets the number of bridges in the road construction project.
     * @return the number of bridges
     */
    public int getBridges() {
        return bridges;
    }

    /**
     * Sets the number of bridges in the road construction project.
     * @param bridges the number of bridges to set for the road construction project
     */
    public void setBridges(int bridges) {
        this.bridges = bridges;
    }

    /**
     * Gets the number of tunnels in the road construction project.
     * @return the number of tunnels
     */
    public int getTunnels() {
        return tunnels;
    }

    /**
     * Sets the number of tunnels in the road construction project.
     * @param tunnels the number of tunnels to set for the road construction project
     */
    public void setTunnels(int tunnels) {
        this.tunnels = tunnels;
    }

    /**
     * Gets the environmental challenges associated with the road construction project.
     * @return the environmental challenges
     */
    public String getEnvironmentalChallenges() {
        return environmentalChallenges;
    }

    /**
     * Sets the environmental challenges associated with the road construction project.
     * @param environmentalChallenges the environmental challenges to set for the road construction project
     */
    public void setEnvironmentalChallenges(String environmentalChallenges) {
        this.environmentalChallenges = environmentalChallenges;
    }

    /**
     * Gets the geographical challenges associated with the road construction project.
     * @return the geographical challenges
     */
    public String getGeographicalChallenges() {
        return geographicalChallenges;
    }

    /**
     * Sets the geographical challenges associated with the road construction project.
     * @param geographicalChallenges the geographical challenges to set for the road construction project
     */
    public void setGeographicalChallenges(String geographicalChallenges) {
        this.geographicalChallenges = geographicalChallenges;
    }

    /**
     * A method that checks if two road construction projects are equal based on their attributes.
     * @param obj the object to compare with this road construction project
     * @return true if the object is a road construction project and has the same attributes as this road construction project, false otherwise
     */
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoadConstruction other = (RoadConstruction) obj;
        return super.equals(other) && width == other.width && length == other.length
                && bridges == other.bridges && tunnels == other.tunnels
                && environmentalChallenges.equals(other.environmentalChallenges)
                && geographicalChallenges.equals(other.geographicalChallenges);
    }

    /**
     * A method that returns a string representation of this road construction project.
     * @return a string that contains the information of this road construction project,
     * such as budget, start date, end date, status, project ID, timeline, customer, resources,
     * width, length, number of bridges, number of tunnels, environmental challenges, and geographical challenges
     */
    public String toString() {
        return super.toString() + "," + width + "," + length + "," + bridges +
                "," + tunnels + "," + environmentalChallenges +
                "," + geographicalChallenges;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
