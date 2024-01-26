import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



public class AccountManager {
    private ArrayList<Accounts> accounts = new ArrayList<>();
    private Crypt cipher = new Crypt();
    private File accountDB;
    private String accountDBName;
    Hide hide = new Hide();

    AccountManager(String accountDBName){
        try{
            this.accountDBName = accountDBName;
            this.accountDB = new File(accountDBName+ ".txt");
        }
            catch(Exception e){
                e.printStackTrace();
        }
    }

    ArrayList<Accounts> getAccountList(){
        return accounts;
    }

    Boolean validateNewAccount(String accountTypeInput, String usernameInput){
        Boolean valid = true;
        for(int i =  0; i<accounts.size();i++){
            if(accountTypeInput.equals(cipher.dualDecrypt(accounts.get(i).getAccountType()))&usernameInput.equals(cipher.dualDecrypt(accounts.get(i).getUsername()))){
                valid = false;
            }
        }
        return valid;
    }


    void retrieveAccounts(){
        accounts.clear();
        String info;
        try {
            FileReader reader = new FileReader(accountDB);
            BufferedReader readist = new BufferedReader(reader);
            while((info = readist.readLine())!= null){
            try{
                String[] infoSplit = info.split(",;]");
                Accounts DBaccount = new Accounts(infoSplit[0], infoSplit[1], infoSplit[2]);
                accounts.add(DBaccount);
            }catch(Exception e){

            } 
            }
            readist.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
     
    void addAccount(String accountType, String username, String password){
        try{
            FileWriter userWrite = new FileWriter(accountDB,true);
            String  str= cipher.dualEncrypt(accountType) + ",;]" + cipher.dualEncrypt(username) + ",;]" + cipher.dualEncrypt(password) + "\n";
            userWrite.write(str);
            userWrite.close();
            hide.hideText(accountDB);
            }catch(IOException e){
                e.printStackTrace();
            }
        finally{
            retrieveAccounts();
        }
    }

    void removeAccount(int index){
        String path = accountDBName + ".txt";
        String tempfile = "temp.txt";
        File oldFile = new File(path);
        File newFile = new File(tempfile);

        int ctr = 0;
        String str;

        try{
            FileWriter fw = new FileWriter(tempfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(accountDB);
            BufferedReader br =  new BufferedReader(fr);

            while((str = br.readLine()) != null ){
                ctr++;
                    if(index != ctr){
                        pw.println(str);
                    }
            }

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            oldFile.delete();
            File dump = new File(accountDBName+".txt");
            newFile.renameTo(dump);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            retrieveAccounts();
        }
    }

    String showAccountType(int index){
        String str = "";
        str = cipher.dualDecrypt((accounts.get(index).getAccountType()));
        return str;
    }

    String showUsername(int index){
        String str = "";
        str = cipher.dualDecrypt((accounts.get(index).getUsername()));
        return str;
    }

    String showPassword(int index){
        String str = "";
        str = cipher.dualDecrypt((accounts.get(index).getPassword()));
        return str;
    }

    int showCount(){
        return accounts.size();
    }

    String makePassword(){
        return cipher.generatePass();
    }

    
}

