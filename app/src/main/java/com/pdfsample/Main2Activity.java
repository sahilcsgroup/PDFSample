package com.pdfsample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.RadioCheckField;
import com.pdfsample.model.Form2Model.FormTwoProp;
import com.pdfsample.model.Form2Model.Report1;
import com.pdfsample.model.Form2Model.Report2;
import com.pdfsample.model.Form2Model.Report3;
import com.pdfsample.model.Form2Model.Report4;
import com.pdfsample.model.Form2Model.Report5;
import com.pdfsample.model.Form2Model.Report6;
import com.pdfsample.model.Form2Model.Report7;
import com.pdfsample.model.Form2Model.Response;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {

    Font font_heading = new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.BOLD);
    Font font_normal = new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.NORMAL);
    Font font_title = new Font(Font.FontFamily.TIMES_ROMAN, 50, Font.BOLD);

    private String file;

    private FormTwoProp twoProp = new FormTwoProp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initTwo();

        if (Build.VERSION.SDK_INT > 20) {
            String state = Environment.getExternalStorageState();

            if (Environment.MEDIA_MOUNTED.equals(state)) {
                file = Environment.getExternalStorageDirectory() + File.separator + "Sahil_Two.pdf";
            } else {
                file = getCacheDir() + File.separator + "Sahil_Two.pdf";
            }

        } else {
            file = Environment.getExternalStorageDirectory() + File.separator + "Sahil_Two.pdf";

        }

        try {

            Document document = new Document(PageSize.A1);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            addData(document, writer);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addData(Document document, PdfWriter writer) throws DocumentException, IOException {

        //////// Add Logo  /////////

        PdfPTable table = new PdfPTable(2);
        //       table.setWidthPercentage(20);
        //      table.setSpacingBefore(10);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);

        float[] columnWidths = new float[]{1f, 5f};
        table.setWidths(columnWidths);
        table.addCell(createLogoCell());
        PdfPCell c1 = new PdfPCell(new Phrase("Two", font_title));
        c1.setBorderColor(BaseColor.WHITE);
        c1.setPadding(70f);
        //Paragraph para = new Paragraph(getString(R.string.app_name), font_title);
        table.addCell(c1);


        Chapter chapter = new Chapter("", 0);
        chapter.setNumberDepth(0);
        Section section = chapter.addSection("");
        section.setNumberDepth(0);
        section.add(table);

        //////////////////////////One///////////////////////////

        section.add(addHeading("Page 1"));

        PdfPTable table2 = new PdfPTable(2);
        table2.setWidthPercentage(100);
        float[] columnWidths1 = new float[]{1f, 2f};
        table2.setWidths(columnWidths1);
        table2.setHorizontalAlignment(Element.ALIGN_LEFT);

        table2.addCell(addCell("Name"));
        table2.addCell(addCell(twoProp.getResponse().getReport1().getJobNo()));
        table2.addCell(addCell("Address"));
        table2.addCell(addCell(twoProp.getResponse().getReport1().getVisitNo()));
        table2.addCell(addCell("Address"));
        table2.addCell(addCell(twoProp.getResponse().getReport1().getReportdate1()));
        table2.addCell(addCell("Address"));
        table2.addCell(addCell(twoProp.getResponse().getReport1().getArrived()));
        table2.addCell(addCell("Address"));
        table2.addCell(addCell(twoProp.getResponse().getReport1().getServiceReportNo()));
        table2.addCell(addCell("Address"));
        table2.addCell(addCell(twoProp.getResponse().getReport1().getClientName()));
        table2.addCell(addCell("Address"));
        table2.addCell(addCell(twoProp.getResponse().getReport1().getNotes1()));

        section.add(table2);
//////////////////////////---------///////////////////////////


//////////////////////////Two///////////////////////////

        section.add(addHeading("Page 2"));

        PdfPTable table4 = new PdfPTable(2);
        table4.setWidthPercentage(100);
        float[] columnWidths2 = new float[]{1f, 2f};
        table4.setWidths(columnWidths2);
        table4.setHorizontalAlignment(Element.ALIGN_LEFT);

        table4.addCell(addCell("Date"));
        table4.addCell(addCell(twoProp.getResponse().getReport2().getReportdate2()));
        table4.addCell(addCell("Name"));
        table4.addCell(addCell(twoProp.getResponse().getReport2().getAuthorisedSignName()));
        table4.addCell(addCell("Name"));
        table4.addCell(addImageCell());

        table4.addCell(addCell("CheckBox Filled"));
        addCheckBoxCell(twoProp.getResponse().getReport2().getAuthorisedBy(), "1", table4);
        table4.addCell(addCell("CheckBox Unfilled"));
        addCheckBoxCell(twoProp.getResponse().getReport2().getAuthorisedBy(), "2", table4);

        section.add(table4);
//////////////////////////-----///////////////////////////

//////////////////////////Three///////////////////////////

        section.add(addHeading("Page 3"));

        PdfPTable table6 = new PdfPTable(2);
        table6.setWidthPercentage(100);
        table6.setWidths(columnWidths2);
        table6.setHorizontalAlignment(Element.ALIGN_LEFT);

        table6.addCell(addCell("CheckBox Filled"));
        addCheckBoxCell(twoProp.getResponse().getReport3().getTypesOfSystems(), "1", table6);
        table6.addCell(addCell("CheckBox Filled"));
        addCheckBoxCell(twoProp.getResponse().getReport3().getTypesOfSystems(), "2", table6);
        table6.addCell(addCell("CheckBox Filled"));
        addCheckBoxCell(twoProp.getResponse().getReport3().getTypesOfSystems(), "3", table6);
        table6.addCell(addCell("CheckBox Filled"));
        addCheckBoxCell(twoProp.getResponse().getReport3().getTypesOfSystems(), "4", table6);

        table6.addCell(addCell("Notes"));
        table6.addCell(addCell(twoProp.getResponse().getReport3().getSystemNotes()));
        section.add(table6);

        //////////////////////////-----///////////////////////////

        //////////////////////////Four///////////////////////////
        section.add(addHeading("Page 4"));
        section.add(addSubHeading("Checks Done"));
        section.add(addCommon());
        if (twoProp.getResponse().getReport3().getTypesOfSystems().contains("1")) {
            section.add(addQuartely());
        }
        if (twoProp.getResponse().getReport3().getTypesOfSystems().contains("2")) {
            section.add(addHalfYearly());
        }
        if (twoProp.getResponse().getReport3().getTypesOfSystems().contains("3")) {
            section.add(addYarly());
        }
        if (twoProp.getResponse().getReport3().getTypesOfSystems().contains("4")) {
            section.add(addAlternateList());
        }

        PdfPTable table7 = new PdfPTable(2);
        table7.setSpacingBefore(15f);
        table7.setWidthPercentage(100);
        table7.setWidths(columnWidths2);
        table7.setHorizontalAlignment(Element.ALIGN_LEFT);
        table7.addCell(addCell("Notes"));
        table7.addCell(addCell(twoProp.getResponse().getReport4().getNotes2()));

        section.add(table7);
        //////////////////////////-----///////////////////////////

        //////////////////////////Six///////////////////////////

        section.add(addHeading("Page 6"));
        section.add(addSubHeading("Completion"));

        PdfPTable table13 = new PdfPTable(2);
        table13.setWidthPercentage(100);
        table13.setWidths(columnWidths2);
        table13.setHorizontalAlignment(Element.ALIGN_LEFT);
        table13.addCell(addCell("Date"));
        table13.addCell(addCell(twoProp.getResponse().getReport6().getDate()));
        table13.addCell(addCell("Date"));
        table13.addCell(addCell(twoProp.getResponse().getReport6().getTime()));
        table13.addCell(addCell("Date"));
        table13.addCell(addCell(twoProp.getResponse().getReport6().getClientNameWork()));
        table13.addCell(addCell("Date"));
        table13.addCell(addCell(twoProp.getResponse().getReport6().getWorkCompleted()));
        table13.addCell(addCell("Date"));
        table13.addCell(addCell(twoProp.getResponse().getReport6().getBackOnline()));
        table13.addCell(addCell("Client"));
        table13.addCell(addImageCell());
        table13.addCell(addCell("Engineer"));
        table13.addCell(addImageCell());
        table13.addCell(addCell("Date"));
        table13.addCell(addCell(twoProp.getResponse().getReport6().getNotes()));
        section.add(table13);

        /////////////////////-----------/////////////////////

        //////////////////////////Six///////////////////////////

        section.add(addHeading("Page 7"));

        PdfPTable table14 = new PdfPTable(2);
        table14.setWidthPercentage(100);
        table14.setWidths(columnWidths2);
        table14.setHorizontalAlignment(Element.ALIGN_LEFT);
        table14.addCell(addCell("Date"));
        table14.addCell(addCell(twoProp.getResponse().getReport7().getTimeCompleted()));
        table14.addCell(addCell("Date"));
        table14.addCell(addCell(twoProp.getResponse().getReport7().getTraveltime()));
        table14.addCell(addCell("Date"));
        table14.addCell(addCell(twoProp.getResponse().getReport7().getWorkCompletedLast()));
        table14.addCell(addCell("Date"));
        table14.addCell(addCell(twoProp.getResponse().getReport7().getMileage()));
        table14.addCell(addCell("Date"));
        table14.addCell(addCell(twoProp.getResponse().getReport7().getEmailAddress()));
        section.add(table14);

        /////////////////////-----------/////////////////////

        document.add(section);

       /* Chapter chapter1 = new Chapter("", 0);
        chapter1.setNumberDepth(0);
        Section section1 = chapter1.addSection("");
        section1.setNumberDepth(0);

        //////////////////////////Four///////////////////////////

        section1.add(addHeading("Page 4"));
        section1.add(addSubHeading("System State"));

        PdfPTable table8 = new PdfPTable(2);
        table8.setWidthPercentage(100);
        table8.setWidths(columnWidths2);
        table8.setHorizontalAlignment(Element.ALIGN_LEFT);
        table8.addCell(addCell("Note"));
        table8.addCell(addCell(twoProp.getResponse().getReport4().getSysStateOnArrival()));
        section1.add(table8);

        section1.add(addSubHeading("PT"));

        PdfPTable table9 = new PdfPTable(2);
        table9.setWidthPercentage(100);
        table9.setWidths(columnWidths2);
        table9.setHorizontalAlignment(Element.ALIGN_LEFT);
        table9.addCell(addCell("Set No"));
        table9.addCell(addCell(twoProp.getResponse().getReport4().getSetNo()));
        table9.addCell(addCell("CheckBox Filled"));
        addCheckBoxCell(twoProp.getResponse().getReport4().getPressureTest(), "1", table9);
        table9.addCell(addCell("CheckBox Filled"));
        addCheckBoxCell(twoProp.getResponse().getReport4().getPressureTest(), "2", table9);
        table9.addCell(addCell("CheckBox Filled"));
        addCheckBoxCell(twoProp.getResponse().getReport4().getPressureTest(), "3", table9);
        table9.addCell(addCell("CheckBox Filled"));
        addCheckBoxCell(twoProp.getResponse().getReport4().getPressureTest(), "4", table9);
        table9.addCell(addCell("CheckBox Filled"));
        addCheckBoxCell(twoProp.getResponse().getReport4().getPressureTest(), "5", table9);
        table9.addCell(addCell("CheckBox Filled"));
        addCheckBoxCell(twoProp.getResponse().getReport4().getPressureTest(), "6", table9);
        table9.addCell(addCell("Bar"));
        table9.addCell(addCell(twoProp.getResponse().getReport4().getBar1()));
        table9.addCell(addCell("CheckBox Filled"));
        addCheckBoxCell(twoProp.getResponse().getReport4().getPtRes(), "1", table9);
        table9.addCell(addCell("CheckBox Filled"));
        addCheckBoxCell(twoProp.getResponse().getReport4().getPtRes(), "2", table9);
        table9.addCell(addCell("Bar"));
        table9.addCell(addCell(twoProp.getResponse().getReport4().getBar2()));
        table9.addCell(addCell("Hours"));
        table9.addCell(addCell(twoProp.getResponse().getReport4().getHours()));
        table9.addCell(addCell("Notes"));
        table9.addCell(addCell(twoProp.getResponse().getReport4().getNotes()));

        section1.add(table9);

        //////////////////////////------///////////////////////////

        //////////////////////////Five///////////////////////////

        section1.add(addHeading("Page 5"));
        section1.add(addSubHeading("Comments/ Recomm."));

        PdfPTable table10 = new PdfPTable(2);
        table10.setWidthPercentage(100);
        table10.setWidths(columnWidths2);
        table10.setHorizontalAlignment(Element.ALIGN_LEFT);
        table10.addCell(addCell("Comments"));
        table10.addCell(addCell(twoProp.getResponse().getReport5().getEngineerNote()));
        section1.add(table10);

        PdfPTable table12 = new PdfPTable(3);
        table12.setSpacingBefore(10f);
        table12.setWidthPercentage(100);
        table12.setHorizontalAlignment(Element.ALIGN_LEFT);
        table12.addCell(addImageCell());
        table12.addCell(addImageCell());
        table12.addCell(addImageCell());
        section1.add(table12);

        section1.add(addSubHeading("Parts Used"));

        PdfPTable table11 = new PdfPTable(2);
        table11.setWidthPercentage(100);
        table11.setWidths(columnWidths2);
        table11.setHorizontalAlignment(Element.ALIGN_LEFT);
        table11.addCell(addCell("Notes"));
        table11.addCell(addCell(twoProp.getResponse().getReport5().getPartsUsed()));
        section1.add(table11);

        /////////////////////-----------/////////////////////

        //////////////////////////Six///////////////////////////

        section1.add(addHeading("Page 6"));
        section1.add(addSubHeading("Completion"));

        PdfPTable table13 = new PdfPTable(2);
        table13.setWidthPercentage(100);
        table13.setWidths(columnWidths2);
        table13.setHorizontalAlignment(Element.ALIGN_LEFT);
        table13.addCell(addCell("Date"));
        table13.addCell(addCell(twoProp.getResponse().getReport6().getDate()));
        table13.addCell(addCell("Date"));
        table13.addCell(addCell(twoProp.getResponse().getReport6().getTime()));
        table13.addCell(addCell("Date"));
        table13.addCell(addCell(twoProp.getResponse().getReport6().getClientName()));
        table13.addCell(addCell("Date"));
        table13.addCell(addCell(twoProp.getResponse().getReport6().getWorkCompleted()));
        table13.addCell(addCell("Date"));
        table13.addCell(addCell(twoProp.getResponse().getReport6().getBackOnline()));
        table13.addCell(addCell("Client"));
        table13.addCell(addImageCell());
        table13.addCell(addCell("Engineer"));
        table13.addCell(addImageCell());
        table13.addCell(addCell("Date"));
        table13.addCell(addCell(twoProp.getResponse().getReport6().getNotes()));
        section1.add(table13);

        /////////////////////-----------/////////////////////

        //////////////////////////Six///////////////////////////

        section1.add(addHeading("Page 7"));

        PdfPTable table14 = new PdfPTable(2);
        table14.setWidthPercentage(100);
        table14.setWidths(columnWidths2);
        table14.setHorizontalAlignment(Element.ALIGN_LEFT);
        table14.addCell(addCell("Date"));
        table14.addCell(addCell(twoProp.getResponse().getReport7().getTimeCompleted()));
        table14.addCell(addCell("Date"));
        table14.addCell(addCell(twoProp.getResponse().getReport7().getTraveltime()));
        table14.addCell(addCell("Date"));
        table14.addCell(addCell(twoProp.getResponse().getReport7().getWorkCompletedLast()));
        table14.addCell(addCell("Date"));
        table14.addCell(addCell(twoProp.getResponse().getReport7().getMileage()));
        table14.addCell(addCell("Date"));
        table14.addCell(addCell(twoProp.getResponse().getReport7().getEmailAddress()));
        section1.add(table14);

        /////////////////////-----------/////////////////////


        document.add(section1);*/

    }

    private PdfPTable addQuartely() throws DocumentException {
        ArrayList<String> item= new ArrayList<>();
        item.addAll(new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.quarterly))));
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        float[] columnWidths2 = new float[]{4f, 1f, 1f, 8f};
        table.setWidths(columnWidths2);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        for (int i = 0; i < item.size(); i++) {
            table.addCell(addCell(item.get(i)));
            addCheckBoxCellFull("1", "1", table);
            addCheckBoxCellFull("2", "1", table);
            table.addCell(addCell(item.get(i)));
        }

        return table;
    }

    private PdfPTable addHalfYearly() throws DocumentException {
        ArrayList<String> item= new ArrayList<>();
        item.addAll(new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.half_yearly))));
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        float[] columnWidths2 = new float[]{4f, 1f, 1f, 8f};
        table.setWidths(columnWidths2);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        for (int i = 0; i < item.size(); i++) {
            table.addCell(addCell(item.get(i)));
            addCheckBoxCellFull("1", "1", table);
            addCheckBoxCellFull("2", "1", table);
            table.addCell(addCell(item.get(i)));
        }

        return table;
    }

    private PdfPTable addYarly() throws DocumentException {
        ArrayList<String> item= new ArrayList<>();
        item.addAll(new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.yearly))));
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        float[] columnWidths2 = new float[]{4f, 1f, 1f, 8f};
        table.setWidths(columnWidths2);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        for (int i = 0; i < item.size(); i++) {
            table.addCell(addCell(item.get(i)));
            addCheckBoxCellFull("1", "1", table);
            addCheckBoxCellFull("2", "1", table);
            table.addCell(addCell(item.get(i)));
        }

        return table;
    }

    private PdfPTable addAlternateList() throws DocumentException {
        ArrayList<String> item = new ArrayList<>();
        item.addAll(new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.alternate_trip))));
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        float[] columnWidths2 = new float[]{4f, 1f, 1f, 8f};
        table.setWidths(columnWidths2);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        for (int i = 0; i < item.size(); i++) {
            table.addCell(addCell(item.get(i)));
            addCheckBoxCellFull("1", "1", table);
            addCheckBoxCellFull("2", "1", table);
            table.addCell(addCell(item.get(i)));
        }

        return table;
    }

    private PdfPTable addCommon() throws DocumentException {
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        float[] columnWidths2 = new float[]{4f, 1f, 1f, 8f};
        table.setWidths(columnWidths2);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(addCell("Date"));
        table.addCell(addCell("Date"));
        table.addCell(addCell("Date"));
        table.addCell(addCell("Date"));

        return table;
    }

    private void initTwo() {
        twoProp.setResponse(new Response());
        twoProp.getResponse().setReport1(new Report1());
        twoProp.getResponse().setReport2(new Report2());
        twoProp.getResponse().setReport3(new Report3());
        twoProp.getResponse().setReport4(new Report4());
        twoProp.getResponse().setReport5(new Report5());
        twoProp.getResponse().setReport6(new Report6());
        twoProp.getResponse().setReport7(new Report7());
    }

    private PdfPTable addHeading(String name) {
        PdfPTable table5 = new PdfPTable(1);
        table5.setSpacingBefore(20f);
        table5.setWidthPercentage(100);
        table5.setHorizontalAlignment(Element.ALIGN_LEFT);

        PdfPCell c4 = new PdfPCell(new Phrase(name, font_title));
        c4.setBorderColor(BaseColor.DARK_GRAY);
        c4.setPadding(15f);
        c4.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table5.addCell(c4);
        return table5;
    }

    private PdfPTable addSubHeading(String name) {
        PdfPTable tabl7 = new PdfPTable(1);
        tabl7.setSpacingBefore(10f);
        tabl7.setWidthPercentage(100);
        tabl7.setHorizontalAlignment(Element.ALIGN_LEFT);
        tabl7.addCell(addCell(name));
        return tabl7;
    }

    private PdfPCell addCell(String name) {
        PdfPCell cell1 = new PdfPCell(new Phrase(name, font_heading));
        cell1.setPadding(10f);
        return cell1;
    }

    private void addCheckBoxCell(String str, String number, PdfPTable table4) {
        PdfPCell cell1 = new PdfPCell();

        PdfPTable table3 = new PdfPTable(1);
        table3.setWidthPercentage(5);
        table3.setHorizontalAlignment(Element.ALIGN_LEFT);

        PdfPCell cell = new PdfPCell();
        if (str.contains(number))
            cell.setCellEvent(new CheckboxCellEvent("cb", 0));
        cell.setBorderColor(BaseColor.BLACK);
        cell.setFixedHeight(40f);

        table3.addCell(cell);
        cell1.setPadding(10f);
        cell1.addElement(table3);
        table4.addCell(cell1);
    }

    private void addCheckBoxCellFull(String str, String number, PdfPTable table4) {
        PdfPCell cell1 = new PdfPCell();

        PdfPTable table3 = new PdfPTable(1);
        table3.setWidthPercentage(50);
        table3.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell cell = new PdfPCell();
        if (str.contains(number))
            cell.setCellEvent(new CheckboxCellEvent("cb", 0));
        cell.setBorderColor(BaseColor.BLACK);
        cell.setFixedHeight(40f);

        table3.addCell(cell);
        cell1.setPadding(10f);
        cell1.addElement(table3);
        table4.addCell(cell1);
    }

    private PdfPCell addImageCell() throws IOException, BadElementException {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 50, stream);
        Image image = Image.getInstance(stream.toByteArray());
        //   image.scaleToFit(1, 1);
        PdfPCell cell = new PdfPCell(image, true);
        cell.setFixedHeight(300f);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        return cell;
    }


    public PdfPCell createLogoCell() throws DocumentException, IOException {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 50, stream);
        Image image = Image.getInstance(stream.toByteArray());
        image.setBorderColor(BaseColor.WHITE);
        image.setAlignment(Element.ALIGN_CENTER);
        image.setWidthPercentage(20);
        image.scaleToFit(1, 1);
        PdfPCell cell = new PdfPCell(image, true);
        cell.setBorderColor(BaseColor.WHITE);
        return cell;
    }

    class CheckboxCellEvent implements PdfPCellEvent {
        // The name of the check box field
        protected String name;
        protected int i;

        // We create a cell event
        public CheckboxCellEvent(String name, int i) {
            this.name = name;
            this.i = i;
        }

        // We create and add the check box field
        public void cellLayout(PdfPCell cell, Rectangle position,
                               PdfContentByte[] canvases) {
            PdfWriter writer = canvases[0].getPdfWriter();
            // define the coordinates of the middle
            float x = (position.getLeft() + position.getRight()) / 2;
            float y = (position.getTop() + position.getBottom()) / 2;
            // define the position of a check box that measures 20 by 20
            Rectangle rect = new Rectangle(x - 10, y - 10, x + 10, y + 10);
            // define the check box
            RadioCheckField checkbox = new RadioCheckField(
                    writer, rect, name, "Yes");
            switch (i) {
                case 0:
                    checkbox.setCheckType(RadioCheckField.TYPE_CHECK);
                    break;
                case 1:
                    checkbox.setCheckType(RadioCheckField.TYPE_CIRCLE);
                    break;
                case 2:
                    checkbox.setCheckType(RadioCheckField.TYPE_CROSS);
                    break;
                case 3:
                    checkbox.setCheckType(RadioCheckField.TYPE_DIAMOND);
                    break;
                case 4:
                    checkbox.setCheckType(RadioCheckField.TYPE_SQUARE);
                    break;
                case 5:
                    checkbox.setCheckType(RadioCheckField.TYPE_STAR);
                    break;
            }
            checkbox.setChecked(true);
            // add the check box as a field
            try {
                writer.addAnnotation(checkbox.getCheckField());
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }
}
