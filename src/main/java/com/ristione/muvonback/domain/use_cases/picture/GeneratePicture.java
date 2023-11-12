package com.ristione.muvonback.domain.use_cases.picture;

import com.ristione.muvonback.domain.entities.CreationResultObject;
import com.ristione.muvonback.domain.entities.OperationResult;
import com.ristione.muvonback.domain.entities.picture.PhotoSize;
import com.ristione.muvonback.domain.entities.picture.PictureError;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class GeneratePicture {

    // @Value("${azure.storage.container-name}")
    // private String containerName;

    // @Value("${azure.storage.blob-url-prefix}")
    // private String blobUrlPrefix = "http://cdn.com/";

    private static final Logger LOGGER =
            LoggerFactory.getLogger(GeneratePicture.class);

    @Transactional
    public CreationResultObject<?> run(Long activityId, MultipartFile file) {
        LOGGER.info(
                "Uploading picture: "
                        + file.getOriginalFilename() + " of "
                        + file.getSize() / 1024 + " Ko");

        List<Object> createdPictures = new ArrayList<>();
        List<OperationResult> errors = new ArrayList<>();
        List<OperationResult> warnings = new ArrayList<>();

        try {
            for (PhotoSize size : PhotoSize.values()) {
                String sizeName = size.getSizeName();
                byte[] ogImageBytes = file.getBytes();
                byte[] resizedImageBytes = resizeImage(
                        ogImageBytes,
                        size.getWidth(),
                        size.getHeight());
                String blobUrl = uploadToCloudStorage(resizedImageBytes, sizeName);
            }

        } catch (Exception e) {
            errors.add(PictureError.FAILED_UPLOAD);
        }

        return new CreationResultObject<>(
                activityId.toString(),
                createdPictures,
                errors,
                warnings);
    }

    private byte[] resizeImage(byte[] originalImageBytes, int width, int height) throws IOException {
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(originalImageBytes);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            BufferedImage bufferedImage = ImageIO.read(inputStream);
            BufferedImage bufferedImageResult = new BufferedImage(
                    width,
                    height,
                    bufferedImage.getType()
            );

            Graphics2D g2d = bufferedImageResult.createGraphics();
            g2d.drawImage(bufferedImage, 0, 0, width, height, null);
            g2d.dispose();

            ImageIO.write(bufferedImageResult, "jpeg", outputStream);
            return outputStream.toByteArray();
        }
    }

    private String uploadToCloudStorage(byte[] imageBytes, String sizeName) {
        // Code pour envoyer l'image vers Azure Blob Storage
        // Utilisez le SDK Azure Storage ou une bibliothèque de gestion Azure Blob Storage
        // Ajoutez le code nécessaire pour configurer et utiliser votre compte Azure Storage

        // Exemple fictif (vous devrez le remplacer par une implémentation réelle)
        // azureBlobStorage.upload(imagePath, "photos/" + size + "/" + photoId + ".jpg");

        // Retournez l'URL complète de l'image stockée
        return "https:/www.cdn.com/photos/" + sizeName + ".jpg";
    }
}
