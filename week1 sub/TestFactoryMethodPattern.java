package deepskilling;

 interface Document {
 void open();
}

 class WordDocument implements Document {
 @Override
 public void open() {
     System.out.println("Opening Word document...");
 }
}

 class PdfDocument implements Document {
 @Override
 public void open() {
     System.out.println("Opening PDF document...");
 }
}

 class ExcelDocument implements Document {
 @Override
 public void open() {
     System.out.println("Opening Excel document...");
 }
}

 abstract class DocumentFactory {
 public abstract Document createDocument();
}

 class WordDocumentFactory extends DocumentFactory {
 @Override
 public Document createDocument() {
     return new WordDocument();
 }
}

 class PdfDocumentFactory extends DocumentFactory {
 @Override
 public Document createDocument() {
     return new PdfDocument();
 }
}

 class ExcelDocumentFactory extends DocumentFactory {
 @Override
 public Document createDocument() {
     return new ExcelDocument();
 }
}

public class TestFactoryMethodPattern {
 public static void main(String[] args) {
     DocumentFactory wordFactory = new WordDocumentFactory();
     Document wordDocument = wordFactory.createDocument();
     wordDocument.open();

     DocumentFactory pdfFactory = new PdfDocumentFactory();
     Document pdfDocument = pdfFactory.createDocument();
     pdfDocument.open();

     DocumentFactory excelFactory = new ExcelDocumentFactory();
     Document excelDocument = excelFactory.createDocument();
     excelDocument.open();
 }
}

