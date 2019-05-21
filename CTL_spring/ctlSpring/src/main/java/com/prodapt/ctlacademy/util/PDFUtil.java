package com.prodapt.ctlacademy.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import com.prodapt.ctlacademy.util.ApplicationUtil;



public class PDFUtil {

	public static String pdfToImages(String filename, String masterDirectory, String directory) throws IOException {
		StringBuilder pages = new StringBuilder();
		PDDocument document = PDDocument.load(new File(filename));
	    PDFRenderer pdfRenderer = new PDFRenderer(document);
	    for (int page = 0; page < document.getNumberOfPages(); ++page) {
	        BufferedImage bim = pdfRenderer.renderImageWithDPI(
	          page, 300, ImageType.RGB);
	        ImageIOUtil.writeImage(
	          bim, String.format(masterDirectory + File.separator + directory + "pdf-%d.%s", page + 1, ApplicationUtil.IMAGE_EXTENSIONS.PNG.toString()), 300);
	        pages.append(directory + "pdf-" + (page + 1) + "." + ApplicationUtil.IMAGE_EXTENSIONS.PNG.toString()).append(";");
	    }
	    document.close();
	    return pages.toString();
	}
}
