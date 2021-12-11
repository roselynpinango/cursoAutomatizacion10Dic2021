package Utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;

public class DatosExcel {
	public static Object[][] leerExcel(String ruta,String nombreHoja) throws Exception {
		FileInputStream file = new FileInputStream(new File(ruta));
		
		XSSFWorkbook libroExcel= new XSSFWorkbook(file); // abre el libro de excel
		XSSFSheet Hoja=libroExcel.getSheet(nombreHoja); // abre la hoja de excel
		
		System.out.println(nombreHoja);
		
		XSSFRow fila;
		int filas = Hoja.getPhysicalNumberOfRows(); // contar cuantas filas llenas hay
		int columnas= Hoja.getRow(0).getPhysicalNumberOfCells(); // contar cuantas columnas llenas hay
		
		Object cellValue[][]=new Object[filas][columnas];
		
		// Recorrer fila a fila
		for (int r = 0; r < filas; r++) {
		 fila = Hoja.getRow(r);
		 if (fila == null){ 
			 break; 
	     }else{ 
	    	 // Recorrer columna a columna
	    	 for (int c = 0; c < columnas; c++) {
	    		 DataFormatter dataFormatter = new DataFormatter();
	    		 cellValue[r][c] = dataFormatter.formatCellValue(Hoja.getRow(r).getCell(c));
	    	 } 
	     }
		 }
		
		return cellValue; 
	} 
}
