package persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersistenciaXML implements IPersistencia{
    private XMLEncoder xmlEncoder;
    private XMLDecoder xmlDecoder;
    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;


    /**
     * Abre y prepara un archivo para la
     * @param nombre
     * @throws IOException
     */
    @Override
    public void abrirInput(String nombre) throws IOException {
        fileInputStream = new FileInputStream(nombre);
        xmlDecoder = new XMLDecoder(fileInputStream);

    }

    @Override
    public void abrirOutput(String nombre) throws IOException {
        fileOutputStream = new FileOutputStream(nombre);
        xmlEncoder = new XMLEncoder(fileOutputStream);

    }

    @Override
    public void cerrarOutput() throws IOException {
        if (fileOutputStream != null)
            fileOutputStream.close();
    }

    @Override
    public void cerrarInput() throws IOException {
        if (fileInputStream !=null)
            fileInputStream.close();
    }

    @Override
    public void escribir(Object objeto) throws IOException {
        xmlEncoder.writeObject(objeto);
    }

    @Override
    public Object leer() throws IOException, ClassNotFoundException {
        return xmlDecoder.readObject();
    }
}
