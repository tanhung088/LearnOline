
package com.mycompany.luyenthi4.DAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class UploadFileDAO {
    public String uploadFile(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws Exception {
        String uploadsPath = getUploadsDirectory(servletContext);
        Part filePart = request.getPart("file");
        String fileName = getFileName(filePart);

        try (InputStream inputStream = filePart.getInputStream();
             OutputStream outputStream = new FileOutputStream(new File(uploadsPath, fileName))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        return "/uploads/" + fileName;
    }

    private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    private String getUploadsDirectory(ServletContext servletContext) {
        String uploadsPath = servletContext.getRealPath("/uploads");
        File uploadsDirectory = new File(uploadsPath);
        if (!uploadsDirectory.exists()) {
            uploadsDirectory.mkdirs();
        }
        return uploadsPath;
    }
}
