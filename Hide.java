import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

class Hide{
    Hide(){
    }

    void hideText(File file){
        Path path= Paths.get(file.getAbsolutePath());
        try{
            Files.setAttribute(path, "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
        }catch(IOException err){
            
        }
    }
}
