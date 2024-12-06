package problems.report_generator.exporters;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import problems.report_generator.charts.chart.Chart;
import problems.report_generator.charts.chart.Dimension;
import problems.report_generator.charts.chart.ImgType;
import problems.report_generator.charts.saver.ChartSaver;
import problems.report_generator.charts.saver.SaveMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PDFExporter implements Exporter {
    PDDocument document;
    List<PDPage> pages;
    PDPageContentStream contentStream;
    boolean isContentStreamAvailable=false;
    Standard14Fonts.FontName fontName = Standard14Fonts.FontName.COURIER;
    int fonSize =14;
    private final ChartSaver saver;
    public PDFExporter(ChartSaver saver){
        this.document=new PDDocument();
        this.pages=new ArrayList<>();
        this.saver=saver;
    }

    private void openContentStream(PDPage page) throws IOException {
        this.closeContentStream();
        this.contentStream = new PDPageContentStream(this.document,page);
        this.isContentStreamAvailable=true;
    }

    private void closeContentStream() throws IOException {
        if(!this.isContentStreamOpen() ) return;
        this.contentStream.close();;
        this.isContentStreamAvailable=false;
    }
    @Override
    public void addPage() throws IOException {
        PDPage page = new PDPage(new PDRectangle(1000,1020));
        this.pages.add(page);
        this.document.addPage(page);
        this.openContentStream(page);
    }
    public boolean isContentStreamOpen(){
        return this.contentStream!=null &&  this.isContentStreamAvailable;
    }
    @Override
    public void addText(String text, Dimension dimension) throws IOException {
        this.contentStream.beginText();
        this.contentStream.setFont(new PDType1Font(this.fontName), this.fonSize);
        this.contentStream.newLineAtOffset((float)dimension.x, (float)(1000-dimension.y));

        this.contentStream.showText(text);
        this.contentStream.endText();
    }

    @Override
    public void setFont(Standard14Fonts.FontName font, int size) {
        this.fontName=font;
        this.fonSize = size;
    }

    public File saveImage(Chart chart,String filename,Dimension size) throws IOException {
        return saver.saveToFile(chart, new SaveMeta(filename, ImgType.PNG,size));

    }
    @Override
    public void addChart(Chart chart,Dimension position, Dimension size) throws IOException {
        File file = this.saveImage(chart,"temp.png",size);
        PDImageXObject pdImage = PDImageXObject.createFromFile(file.getPath(), document);
        this.contentStream.drawImage(pdImage,(float)position.x,(float) position.y,(float)size.x,(float)size.y);
    }

    @Override
    public void export(String filename) throws IOException {
        this.closeContentStream();
        this.document.save(filename);
        this.document.close();

    }
}
