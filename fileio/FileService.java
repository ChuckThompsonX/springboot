package springboot.fileio;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;

public interface FileService {

    public void writeToFile(String filePath, String content) throws IOException, URISyntaxException;

    public String readFileContent(String filePath) throws IOException;

    public String uploadImage(String path, MultipartFile file) throws IOException;
}
