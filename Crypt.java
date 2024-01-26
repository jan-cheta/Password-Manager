import java.util.List;
import java.util.Random;
import java.util.ArrayList;
public class Crypt {

    private String chars = "";
    private Random ran = new Random();
    private final String key = "MUSTBECAPS";
    
    public Crypt() {
        char start = '!';
        for(int i  = 33; i<128;i++){
            if(i!=92 || i!=34){
            this.chars += Character.valueOf(start);
            }
            start++;
        }
    }

     private List<Integer> getCharPositions(String str) {
        
        List<Integer> charsAtPos = new ArrayList<Integer>();
        
        for (int i = 0; i < str.length(); i++) {
            charsAtPos.add(chars.indexOf(str.charAt(i)));
        } 

        return charsAtPos;
    }

    private String paddedCrypt(String crypt){
        crypt += "~/";
        while(crypt.length()!=32){
            crypt+=chars.charAt(ran.nextInt(chars.length()));
        }
        return crypt;
    }

    private String encrypt(String text) {
        List<Integer> textCharAtPos = getCharPositions(text);
        List<Integer> keyCharAtPos = getCharPositions(key);

        int textLength = text.length();
        int keyLength = key.length();

        String cipher = "";
        int letter;

        for (int n = 0; n < textLength; n++) {
            letter = (textCharAtPos.get(n) + keyCharAtPos.get(n % keyLength));
            letter %= chars.length();
            cipher += chars.charAt(letter);
        }
        return cipher;
    }

   

    private String decrypt(String cipher) {
        
        List<Integer> cipherCharAtPos = getCharPositions(cipher);
        List<Integer> keyCharAtPos = getCharPositions(key);

        int cipherLength = cipher.length();
        int keyLength = key.length();

        String plainText = "";
        int letter;

        for (int n = 0; n < cipherLength; n++) {
            letter = (cipherCharAtPos.get(n) - keyCharAtPos.get(n % keyLength));
            letter += chars.length();
            letter %= chars.length();
            plainText += chars.charAt(letter);
        }

        return plainText;
    }

    public String dualEncrypt(String text){
        String e = encrypt(text);
        e = encrypt(e);
        String encrypted = paddedCrypt(e);

        return encrypted;
    }

    public String dualDecrypt(String cipher){
        String[] splitter = cipher.split("~/");
        cipher = splitter[0];
        String e = decrypt(cipher);
        String decrypted = decrypt(e);
        return decrypted;
    }

    public String generatePass(){
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String number = "0123456789";
        String special = "!@#$%^&*()-_+={}|[]|:/<>~`' ";

        List<String> all = new ArrayList<>();
        all.add(special);
        all.add(lower);
        all.add(upper);
        all.add(number);

        int length = ran.nextInt(10, 15);
        String generated = "";

        for(int i = 0; i < length;i++){
            if(all.size() == 0){
                all.add(special);
                all.add(lower);
                all.add(upper);
                all.add(number);
            }else{
                    int random = ran.nextInt(all.size());
                    int randomchar = ran.nextInt(all.get(random).length());
                    generated+=all.get(random).charAt(randomchar);
                    all.remove(random);
            }
        }
        return generated;
    }
}

