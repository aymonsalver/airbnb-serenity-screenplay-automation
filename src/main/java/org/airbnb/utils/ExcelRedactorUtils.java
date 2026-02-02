package org.airbnb.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelRedactorUtils {

    public static void escribirExcel(String nombreArchivo, String nombreAlojamiento, String anfitrionAlojamiento, String precioAlojamiento) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Alojamiento");

        // Crear encabezados
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Nombre Alojamiento");
        headerRow.createCell(1).setCellValue("Anfitrión");
        headerRow.createCell(2).setCellValue("Precio");

        // Crear fila de datos
        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue(nombreAlojamiento);
        dataRow.createCell(1).setCellValue(anfitrionAlojamiento);
        dataRow.createCell(2).setCellValue(precioAlojamiento);

        // Ajustar el tamaño de las columnas
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream outputStream = new FileOutputStream(nombreArchivo))  {
            workbook.write(outputStream);
            System.out.println("✅ Datos escritos en el archivo Excel: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
