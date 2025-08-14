package io.github.gabrielvelosoo.ecommerceapi.dominio.service.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    String salvarArquivo(MultipartFile arquivo) throws IOException;
}
