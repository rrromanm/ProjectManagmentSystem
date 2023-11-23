package model;

public class commercialProjects extends Project {
    private int size;
    private short floors;
    private String usage;

    public commercialProjects(int budget, String status, int projectID, Date deadline) {
        super(budget, status, projectID, deadline);

    }
}
