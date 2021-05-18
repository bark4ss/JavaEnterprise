package by.teachmeskills.JavaEE.controller.basic;

import ai.djl.ModelException;
import ai.djl.translate.TranslateException;
import by.teachmeskills.JavaEE.util.djl.ObjectDetection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/image_upload")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB
        maxFileSize=1024*1024*50,      	// 50 MB
        maxRequestSize=1024*1024*100)
public class ImageUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 205242440643911308L;

    /**
     * Directory where uploaded files will be saved, its relative to
     * the web application directory.
     */
    private static final String UPLOAD_DIR = "outputs";
    private static final String DETECTED_IMAGE_SUFFIX = "detected-";
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // gets absolute path of the web application
        String applicationPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());

        String fileName = null;
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            part.write(uploadFilePath + File.separator + fileName);
        }
        Path imageFile = Paths.get(uploadFilePath + File.separator + fileName);
        Path outputDir = Paths.get(uploadFilePath);
        String detectedFileName = DETECTED_IMAGE_SUFFIX + fileName;
        try {
            ObjectDetection.predict(imageFile,outputDir, detectedFileName);
        } catch (ModelException | TranslateException e) {
            e.printStackTrace();
        }
        String imagePath = UPLOAD_DIR + File.separator + DETECTED_IMAGE_SUFFIX + fileName;
        request.setAttribute("message", fileName + " File uploaded successfully!");
        request.setAttribute("imagePath", imagePath);
        getServletContext().getRequestDispatcher("/response.jsp").forward(
                request, response);
    }

    /**
     * Utility method to get file name from HTTP header content-disposition
     */
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
}
