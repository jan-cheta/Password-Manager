import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;



public class UserManager{
    private ArrayList<Users> users = new ArrayList<>();
    private AccountManager account;
    private Crypt cipher = new Crypt();
    private File userDB;
    private String UserDBName = "userDB.txt";
    Path path;
    Hide hide = new Hide();


    UserManager(){
        this.userDB = new File(UserDBName);  
    }

    AccountManager getAccount(){
        return account;
    }

    Boolean validateNewUser(String usernameInput){
        retrieveDB();
        Boolean valid = true;
        for(int i =  0; i<users.size();i++){
            if(usernameInput.equals(cipher.dualDecrypt(users.get(i).getUsername()))){
                valid = false;
            }
        }
        return valid;
    }

    int validateUser(String usernameInput, String passwordInput){
        retrieveDB();
        int result = -1;
        for(int i = 0; i<users.size();i++){
            try{
                if(usernameInput.equals(cipher.dualDecrypt(users.get(i).username))&&(usernameInput.equals(cipher.dualDecrypt(users.get(i).username)))){
                    result = i;
                    account = new AccountManager(usernameInput);
                }
            }catch(Exception e){

            }
        }
        return result;
    }

    void retrieveDB(){
        users.clear();
        String info;
        try {
            FileReader reader = new FileReader(userDB);
            BufferedReader readist = new BufferedReader(reader);
            while((info = readist.readLine())!= null){
            try{
                String[] infoSplit = info.split(",;");
                Users DBuser = new Users(infoSplit[0], infoSplit[1]);
                users.add(DBuser);
            }catch(Exception e){

            } 
            }
            readist.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
     
    void addUser(String username, String password){
        try{
            FileWriter userWrite = new FileWriter(userDB,true);
            String  str= cipher.dualEncrypt(username) + ",;" + cipher.dualEncrypt(password) + "\n";
            userWrite.write(str);
            userWrite.close();
            hide.hideText(userDB);
            }catch(IOException e){
                e.printStackTrace();
            }
        finally{
            retrieveDB();
        }
    }

    
}

