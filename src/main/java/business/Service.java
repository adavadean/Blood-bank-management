package business;
import java.io.Serializable;
import java.util.*;
import java.util.List;

public class Service extends Observable implements Serializable{
    private static Service singleInstance = new Service();
    public static Service getInstance() {
        return singleInstance;
    }

    public static List<Donator> donatori = new ArrayList<>();
    public List<Donator> getDonatori()
    {
        return donatori;
    }
    public void creareUser(User user)
    {
        if(user instanceof Donator)
        {
            donatori.add((Donator) user);
            user.setId(donatori.indexOf(user) + 1);
        }
    }

    public void afisare(){
        for(Donator d:donatori){
            System.out.println(d.getUsername());
        }
    }

}
