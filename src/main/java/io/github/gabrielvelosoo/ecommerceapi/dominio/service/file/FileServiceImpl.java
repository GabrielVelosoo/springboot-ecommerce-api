package io.github.gabrielvelosoo.ecommerceapi.dominio.service.file;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @Value("${app.upload.dir}")
    private String uploadDir;

    @Value("${app.upload.url-prefix:/uploads/}")
    private String urlPrefix;

    @Override
    public String salvarArquivo(MultipartFile arquivo) throws IOException {
        String nomeArquivo = UUID.randomUUID() + "_" + arquivo.getOriginalFilename();
        Path caminho = Paths.get(uploadDir, nomeArquivo);
        Files.createDirectories(caminho.getParent());
        Files.copy(arquivo.getInputStream(), caminho, StandardCopyOption.REPLACE_EXISTING);
        return urlPrefix + nomeArquivo;
    }
}
