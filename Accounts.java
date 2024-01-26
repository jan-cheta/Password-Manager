public class Accounts{
    private String accountType, username, password;
    Accounts(String accountType, String username, String password){
        this.accountType = accountType;
        this.username = username;
        this.password = password;
    }

    public String getAccountType(){
        return accountType;
    }
    
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
