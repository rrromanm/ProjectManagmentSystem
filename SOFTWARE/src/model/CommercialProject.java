package model;

public class CommercialProject extends Project{
    private int size;
    private short floors;
    private String usage;

    public CommercialProject(int budget, String status, int projectID, Date deadline, int size, short floors, String usage){
        super(budget, deadline, status, projectID);
        this.size = size;
        this.floors = floors;
        this.usage = usage;
    }

    public CommercialProject(int budget, Date deadline, String status, int projectID, int timeline, short floors, String usage){
        super(budget, deadline, status, projectID);
        super.setTimeline(18);
        floors = 1;
        usage = "restaurant";
    }
    

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the floors
     */
    public short getFloors() {
        return floors;
    }

    /**
     * @param floors the floors to set
     */
    public void setFloors(short floors) {
        this.floors = floors;
    }

    /**
     * @return the usage
     */
    public String getUsage() {
        return usage;
    }

    /**
     * @param usage the usage to set
     */
    public void setUsage(String usage) {
        this.usage = usage;
    }

    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        } else {
            CommercialProject other = (CommercialProject)obj;
            return super.equals(other) && usage.equals(other.usage) && size == other.size && floors == other.floors;
        }
    }

    public String toString(){
        return super.toString() + "\nUsage: "+usage+"\nSize: "+size+"\nFloors: "+floors;
    }
}
