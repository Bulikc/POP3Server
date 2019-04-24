package Base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test
{

    private  Map<String,String> usersList= new HashMap<>();

    public  boolean checkUser(String user){

        if(usersList.get(user)!=null)
            return true;
        else return false;
    }





    public  boolean checkUserPass(String user,String pass){

        if(usersList.get(user).equals(pass))
            return true;
        else return false;
    }

    public  Test() {
        initialise();
    }

    private  void initialise(){
        usersList.put("Ivan","123");
        usersList.put("Dima","321");
        usersList.put("Ola","222");
    }


}
