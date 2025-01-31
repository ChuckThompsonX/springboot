package springboot.fileio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private ResourceLoader resourceLoader;

    public String readFileContent(String filePath) throws IOException {
        Resource resource = resourceLoader.getResource(filePath);
        if (resource.exists() && resource.isReadable()) {
            try (InputStream inputStream = resource.getInputStream()) {
                return new String(FileCopyUtils.copyToByteArray(inputStream));
            }
        }
        return "File does not exist or is not readable.";
    }

    public void writeToFile(String filePath, String content) throws IOException, URISyntaxException {
        Path path = Paths.get(filePath);
        Files.write(path, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        String originalFileName = file.getOriginalFilename();
        String randomId = UUID.randomUUID().toString();
        String fileName = randomId.concat(originalFileName.substring(originalFileName.lastIndexOf('.')));
        String filePath = path + File.separator + fileName;
        File folder = new File(path);
        
        if (!folder.exists()) {
            folder.mkdir();
        }

        Files.copy(file.getInputStream(), Paths.get(filePath));
        return fileName;
    }
}
