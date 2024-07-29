package com.example.factorymethod;

// Document interface
interface Document {
    void open();
    void save();
    void close();
}

// WordDocument interface
interface WordDocument extends Document {
}

// PdfDocument interface
interface PdfDocument extends Document {
}

// ExcelDocument interface
interface ExcelDocument extends Document {
}




// Concrete WordDocument class
class ConcreteWordDocument implements WordDocument {
    @Override
    public void open() {
        System.out.println("Opening Word document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document...");
    }

    @Override
    public void close() {
        System.out.println("Closing Word document...");
    }
}

// Concrete PdfDocument class
class ConcretePdfDocument implements PdfDocument {
    @Override
    public void open() {
        System.out.println("Opening PDF document...");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document...");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document...");
    }
}

// Concrete ExcelDocument class
class ConcreteExcelDocument implements ExcelDocument {
    @Override
    public void open() {
        System.out.println("Opening Excel document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Excel document...");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel document...");
    }
}


// Abstract DocumentFactory class
abstract class DocumentFactory {
     abstract Document createDocument();
}

// Concrete factory class for WordDocument
class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ConcreteWordDocument();
    }
}

// Concrete factory class for PdfDocument
class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ConcretePdfDocument();
    }
}

// Concrete factory class for ExcelDocument
class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ConcreteExcelDocument();
    }
}


public class FactoryMethodTest {
    public static void main(String[] args) {
        // Create factories
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // Create documents using the factories
        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        // Use the documents
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
    }
}
