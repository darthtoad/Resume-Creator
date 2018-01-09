package models;

import java.util.ArrayList;

/**
 * Created by Guest on 1/9/18.
 */
public class Resume {
    private String company;
    private String jobTitle;
    private String jobDescription;
    private String dateStarted;
    private String dateEnded;
    private int id;
    private static ArrayList instances = new ArrayList();

    public Resume(String company, String jobTitle, String jobDescription, String dateStarted, String dateEnded) {
        this.company = company;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.dateStarted = dateStarted;
        this.dateEnded = dateEnded;
        instances.add(this);
        this.id = instances.size();
    }

    public String getCompany() {return this.company;}
    public String getJobTitle() {return this.jobTitle;}
    public String getJobDescription() {return this.jobDescription;}
    public String getDateStarted() {return this.dateStarted;}
    public String getDateEnded() {return this.dateEnded;}
    public int getId() {return this.id;}
    public static ArrayList getAll() {return instances;}
    public static void clearAll() {instances.clear();}
    public static Object findById(int id) {return instances.get(id-1);}
}
