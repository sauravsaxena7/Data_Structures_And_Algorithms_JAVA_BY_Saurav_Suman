package System_Design.S_O_L_I_D_Principles;


interface InvoiceDaoo{
    public void save(Invoice invoice);
}

class DatabaseInvoiceDao implements InvoiceDaoo{

    @Override
    public void save(Invoice invoice) {
        //save to DB
    }
}

class FileSystemInvoiceDao implements InvoiceDaoo{

    @Override
    public void save(Invoice invoice) {
        //save to File
    }
}

public class Open_Closed_Principles {
}
