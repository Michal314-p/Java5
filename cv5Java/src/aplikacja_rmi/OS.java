package aplikacja_rmi;

import java.io.Serializable;

public class OS implements Serializable
{

    private String description;
    private String name;

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public OS(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "Nazwa: " + name + " " + ", Opis: " + description + " ";
    }








}
