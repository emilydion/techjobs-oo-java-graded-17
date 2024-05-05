package org.launchcode.techjobs.oo;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    @Override
    public String toString() {
        String finalString = System.lineSeparator();

        LinkedHashMap<String, String> properties = new LinkedHashMap<>();
        properties.put("ID", String.valueOf(id));
        properties.put("Name", name);
        properties.put("Employer", employer.getValue());
        properties.put("Location", location.getValue());
        properties.put("Position Type", positionType.getValue());
        properties.put("Core Competency", coreCompetency.getValue());

        for (Map.Entry<String, String> property : properties.entrySet()) {
            finalString += property.getKey() + ": ";
            if (property.getValue().isEmpty()) {
                finalString += "Data not available";
            } else {
                finalString += property.getValue();
            }
            finalString += System.lineSeparator();
        }

        return finalString;
//        return System.lineSeparator() +
//                "ID: " + id + "\n" +
//                "Name: " + name + "\n" +
//                "Employer: " + employer.getValue() + "\n" +
//                "Location: " + location.getValue() + "\n" +
//                "Position Type: " + positionType.getValue() + "\n" +
//                "Core Competency: " + coreCompetency.getValue() +
//                System.lineSeparator();
    }
}
