/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import limpieza_recurso.Limpieza_Class;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author seolivera
 */
public class HandleFile {
    
    private String testExternalSourceBaseDir;
    private String dir;
    private static HandleFile hf;
    Client client;
            
    public static HandleFile initHandleFile(){
        if (hf == null) {
            hf = new HandleFile();
        }
        return hf;
        
    }
    
    public static HandleFile getHandleFile()
    {
        return hf;
    }
    
    public HandleFile(String path)
    {
        dir = path;
    }
    
    public HandleFile() {
        this.testExternalSourceBaseDir = System.getProperty("user.dir") + "\\";
    }
    
    public HashMap<String, LinkedList<String>> readArchivoEntradaDesconexion()
    {
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        
        try {
            FileReader fr = new FileReader(dir+"\\test\\test_data_source\\disconnection\\archivoEntrada.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            String ant ="";
            String[] aux ;
            LinkedList<String> auxiliar;
            while((linea = br.readLine()) != null)
            {
                aux = linea.split(";");
                if (isNumeric(aux[0]) && aux[0].length() == 8) {
                    if (!map.containsKey(aux[1])) {
                        map.put(aux[1],new LinkedList<String>());
                        map.get(aux[1]).add(aux[0]);
                        
                    } else 
                    {
                        map.get(aux[1]).add(aux[0]);
                    }
                }
            }
            fr.close();
        } catch(Exception e) {
          System.out.println("Excepcion leyendo fichero archivoEntrada.csv con Error: " + e);
          
        }
        return map;
    }
    public boolean writeArchivoSO_Desconexion(HashMap<String, Limpieza_Class> map)
    {
        File f = new File(dir+"\\Desconexion\\archivoSO.csv");
        try {
            FileOutputStream fos=new FileOutputStream(f);
            PrintWriter pw=new PrintWriter(fos);           
            for (HashMap.Entry<String, Limpieza_Class>entry : map.entrySet()) {
                pw.write(entry.getKey()+";"+entry.getValue().getSO()+";"+entry.getValue().getStatus()+";"+
                        entry.getValue().getSim()+"\n");
                
            }
            pw.flush();
            pw.close();
            fos.close();
            
            return true;
        } catch(Exception e) {
          System.out.println("Excepcion leyendo fichero archivoSO.csv con Error: " + e);
          
        }
        return false;
    }
    public boolean writeArchivoNumeroSIM_Desconexion(String id,String num,String sim)
    {
        File f = new File(dir+"\\Desconexion\\archivoNumberSIM.csv");
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            String linea = id+";"+num+";"+sim+"\n";
            bw.write(linea);
            return true;
        } catch(Exception e) {
          System.out.println("Excepcion leyendo fichero archivoSO.csv con Error: " + e);
          
        }
        return false;
    }
    public boolean writeArchivoStatus_Desconexion(String id,String estado)
    {
        File f = new File(dir+"\\Desconexion\\archivoStatus.csv");
        try {
            FileWriter fw = new FileWriter(dir+"\\Desconexion\\archivoStatus.csv",true);
            BufferedWriter bw = new BufferedWriter(fw);
            String linea = id+";"+estado+"\n";
            bw.write(linea);
            return true;
        } catch(Exception e) {
          System.out.println("Excepcion leyendo fichero archivoSO.csv con Error: " + e);
          
        }
        return false;
    }
    
    
    
    
    public boolean isNumeric(String cadena){
	try {
                
                LinkedList<String> lst =new LinkedList<>();
                while (cadena.length() != 0) {
                    if (cadena.length() > 7) {
                        lst.add(cadena.substring(0, 6));
                        cadena = cadena.substring(7, cadena.length());
                        
                    } else 
                        {
                            lst.add(cadena.substring(0, cadena.length()));
                            cadena = "";
                        }
                    System.out.println(cadena);
                    
                }
                for (String string : lst) {
                    Integer.parseInt(string);
                    //System.out.println(string+" ");
                }
                
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    
            
    public HashMap<String, LinkedList<String>> altaCliente()
    {
     
     HashMap<String, LinkedList<String>> map = new HashMap<>();
        try {
            FileReader fr = new FileReader(dir+"\\Alta\\Clientes.csv");
            
            BufferedReader br = new BufferedReader(fr);
            String id;
            
            String[] aux ;
        while((id = br.readLine()) != null)
        {
             aux = id.split(";");
             if (isNumeric(aux[0])) {
                    if (!map.containsKey(aux[1])) {
                        map.put(aux[1],new LinkedList<String>());
                        map.get(aux[1]).add(aux[0]);
                        
                        
                    } else 
                    {
                        map.get(aux[1]).add(aux[0]);
                    }
             }
           } 
       fr.close();
        }
        catch(Exception e) {
          System.out.println("Excepcion leyendo fichero " +": " + e);
          
        }
        return map;
      }
  
    
    public void CargarArchivos(String dir)
    {
        File fallados = new File(dir+"/Failed.txt");
        try
        {
            FileWriter fw = new FileWriter(fallados); 
           
            
            fw.close();
        
        } catch (Exception e){
            System.out.println("Error al leer crear archivo - Failed.txt");
        }
        
        
    }
    
    //Registrar casos de pruebas
    public HashMap readRegisterDataSource(String registerCase) throws Exception {
       try {
           HashMap sourceMap = new HashMap<>();
           switch(registerCase.toLowerCase()) {
                case "new_residential_client":
                    sourceMap = getNewClientDatSource();
                break; 
                 case "new_enterprise_client":
                    sourceMap = getNewEntClientDatSource();
                break;
                case "new_plan":
                    sourceMap = getNewPlanDatSource();
                break;
                case "change_plan":
                    sourceMap = getChangePlanDatSource();
                break;
                case "sim_card_lost":
                    sourceMap = getSimCardLostPlanDatSource();
                break;
                case "recharge_line":
                    sourceMap = getRechargeLine();
                break;
           }
           

           return sourceMap;
       } catch (Exception e) {
           throw new Exception(e.getMessage() + ": Error reading Excel souce file!");
       }
   }
    //Caso 1:Registrar Cliente Residencial
    public HashMap<String, List<Client>> getNewClientDatSource() throws Exception {
       try {
            HashMap<String, List<Client>> sourceMap = new HashMap<String, List<Client>>();
            File sourceFile = new File(this.testExternalSourceBaseDir + "registers.xlsx");
            if (sourceFile.exists()){
               //obtaining bytes from the file
                FileInputStream fis = new FileInputStream(sourceFile);  
                //creating Workbook instance that refers to .xlsx file  
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                //creating a Sheet object to retrieve object
                // getting the sheet "POTENTIAL-RESCLIENTS" (index 0)
                XSSFSheet sheet = wb.getSheetAt(0);
                //iterating over excel file
                Iterator<Row> itr = sheet.iterator(); 
                itr.next();
                while (itr.hasNext())                 
                {  
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column 
                    Client newClient = new Client();
                    String enviroment = null;
                    while (cellIterator.hasNext())   
                    {  
                        Cell cell = cellIterator.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        Integer columnIndex = cell.getColumnIndex();
                        switch(columnIndex){
                            case 0: //enviroment
                                enviroment = row.getCell(columnIndex).getStringCellValue().toLowerCase();
                                if (!sourceMap.containsKey(enviroment) && enviroment.length() > 0) {
                                    sourceMap.put(enviroment, new ArrayList<>());
                                }
                            break;
                            case 1: //name
                                newClient.setName(row.getCell(columnIndex).getStringCellValue());
                            break;
                            case 2: //second name
                                newClient.setSecondName(row.getCell(columnIndex).getStringCellValue());
                            break;
                            case 3: //dni
                                newClient.setDni(row.getCell(columnIndex).getStringCellValue());
                            break;
                            case 4: //address
                                newClient.setAddress(row.getCell(columnIndex).getStringCellValue());
                            break;
                        }
                    }
                    if(newClient.getName() != null) {
                        sourceMap.get(enviroment).add(newClient);
                    }
                }
                wb.close();
            }
           return sourceMap;
       } catch (Exception e) {
           throw new Exception(e.getMessage() + ": Error getting New Client Data Source!");
       }
   }
    //Caso 1.1:Generar registro cliente residencial
    public void generateRegisteredRClientDatasource(List<Client> clients) throws Exception{
      try {
            
            File sourceFile = new File(this.testExternalSourceBaseDir + "registers.xlsx");
            if (sourceFile.exists() && clients.size() > 0){
               //obtaining bytes from the file
                FileInputStream fis = new FileInputStream(sourceFile);  
                //creating Workbook instance that refers to .xlsx file  
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                //creating a Sheet object to retrieve object
                // getting the sheet "REAL-RESCLIENTS" (index 2)
                XSSFSheet sheet = wb.getSheetAt(2);
                Integer rowIterator = 1;
                while (rowIterator <= clients.size())                 
                {  
                    Integer index = rowIterator - 1;
                    System.out.println("index -> " + index);
                    Row row = sheet.getRow(rowIterator);
                    if (row == null) {
                        row = sheet.createRow(rowIterator);
                    }
                    
                    // Client ID
                    Cell cell = row.getCell(0);  
                    if (cell == null)  
                        cell = row.createCell(0);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(clients.get(index).getClientId());
                    
                    // Name
                    cell = row.getCell(1);  
                    if (cell == null)  
                        cell = row.createCell(1);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(clients.get(index).getName());
                    
                    // second Name
                    cell = row.getCell(2);  
                    if (cell == null)  
                        cell = row.createCell(2);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(clients.get(index).getSecondName());
                    
                    // DNI
                    cell = row.getCell(3);  
                    if (cell == null)  
                        cell = row.createCell(3);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(clients.get(index).getDni());
                    
                    // Address
                    cell = row.getCell(4);  
                    if (cell == null)  
                        cell = row.createCell(4);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(clients.get(index).getAddress());
                    
                    rowIterator++;
                }
            
                try (OutputStream fileOut = new FileOutputStream(sourceFile)) {  
                    wb.write(fileOut); 
                    wb.close();
                }
            }
       } catch (Exception e) {
           throw new Exception(e.getMessage() + ": Error registering Real Client Data Source!");
       }
    }
    //Caso 2:Registrar Cliente Empresarial
    public HashMap<String, List<EnterpriseClient>> getNewEntClientDatSource() throws Exception {
       try {
            HashMap<String, List<EnterpriseClient>> sourceMap = new HashMap<String, List<EnterpriseClient>>();
            File sourceFile = new File(this.testExternalSourceBaseDir + "registers.xlsx");
            System.out.println(sourceFile.getAbsolutePath());
            if (sourceFile.exists()){
               //obtaining bytes from the file
                FileInputStream fis = new FileInputStream(sourceFile);  
                //creating Workbook instance that refers to .xlsx file  
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                //creating a Sheet object to retrieve object
                // getting the sheet "POTENTIAL-ENTCLIENTS" (index 1)
                XSSFSheet sheet = wb.getSheetAt(1);
                //iterating over excel file
                Iterator<Row> itr = sheet.iterator(); 
                itr.next();
                while (itr.hasNext())                 
                {  
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column 
                    EnterpriseClient newClient = new EnterpriseClient();
                    String enviroment = null;
                    while (cellIterator.hasNext())   
                    {  
                        Cell cell = cellIterator.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        Integer columnIndex = cell.getColumnIndex();
                        switch(columnIndex){
                            case 0: //enviroment
                                enviroment = row.getCell(columnIndex).getStringCellValue().toLowerCase();
                                if (!sourceMap.containsKey(enviroment) && enviroment.length() > 0) {
                                    sourceMap.put(enviroment, new ArrayList<>());
                                }
                            break;
                            case 1: //name
                                newClient.setName(row.getCell(columnIndex).getStringCellValue());
                            break;
                            case 2: //second name
                                newClient.setSecondName(row.getCell(columnIndex).getStringCellValue());
                            break;
                            case 3: //dni
                                newClient.setDni(row.getCell(columnIndex).getStringCellValue());
                            break;
                            case 4: //address
                                newClient.setAddress(row.getCell(columnIndex).getStringCellValue());
                            break;
                            case 5: //rut
                                newClient.setRut(row.getCell(columnIndex).getStringCellValue());
                            break;
                        }
                        
                    }
                    if(newClient.getName() != null) {
                        sourceMap.get(enviroment).add(newClient);
                    }
                }
                wb.close();
            }
           return sourceMap;
       } catch (Exception e) {
           throw new Exception(e.getMessage() + ": Error getting New Client Data Source!");
       }
   }
    // Caso 2.1:Generar registro Cliente Empresarial 
    public void generateRegisteredEntClientDatasource(List<EnterpriseClient> clients) throws Exception{
      try {
            
            File sourceFile = new File(this.testExternalSourceBaseDir + "registers.xlsx");
            System.out.println(sourceFile.getAbsolutePath());
            if (sourceFile.exists() && clients.size() > 0){
               //obtaining bytes from the file
                FileInputStream fis = new FileInputStream(sourceFile);  
                //creating Workbook instance that refers to .xlsx file  
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                //creating a Sheet object to retrieve object
                // getting the sheet "REAL-ENTCLIENTS" (index 3)
                XSSFSheet sheet = wb.getSheetAt(3);
                Integer rowIterator = 1;
                while (rowIterator <= clients.size())                 
                {  
                    Integer index = rowIterator - 1;
                    System.out.println("index -> " + index);
                    Row row = sheet.getRow(rowIterator);
                    if (row == null) {
                        row = sheet.createRow(rowIterator);
                    }
                    
                    // Client ID
                    Cell cell = row.getCell(0);  
                    if (cell == null)  
                        cell = row.createCell(0);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(clients.get(index).getClientId());
                    
                    // Name
                    cell = row.getCell(1);  
                    if (cell == null)  
                        cell = row.createCell(1);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(clients.get(index).getName());
                    
                    // second Name
                    cell = row.getCell(2);  
                    if (cell == null)  
                        cell = row.createCell(2);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(clients.get(index).getSecondName());
                    
                    // DNI
                    cell = row.getCell(3);  
                    if (cell == null)  
                        cell = row.createCell(3);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(clients.get(index).getDni());
                    
                    // RUT
                    cell = row.getCell(4);  
                    if (cell == null)  
                        cell = row.createCell(4);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(clients.get(index).getRut());
                    
                    rowIterator++;
                }
            
                try (OutputStream fileOut = new FileOutputStream(sourceFile)) {  
                    wb.write(fileOut);  
                    wb.close();
                }
            }
       } catch (Exception e) {
           throw new Exception(e.getMessage() + ": Error registering Real Client Data Source!");
       }
    }
    //Caso 3:Registrar Plan
    public HashMap<String, List<Plan>> getNewPlanDatSource() throws Exception {
       try {
            HashMap<String, List<Plan>> sourceMap = new HashMap<String, List<Plan>>();
            File sourceFile = new File(this.testExternalSourceBaseDir + "registers.xlsx");
            if (sourceFile.exists()){
               //obtaining bytes from the file
                FileInputStream fis = new FileInputStream(sourceFile);  
                //creating Workbook instance that refers to .xlsx file  
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                //creating a Sheet object to retrieve object
                // getting the sheet "NEW PLAN" (index 4)
                XSSFSheet sheet = wb.getSheetAt(4);
                //iterating over excel file
                Iterator<Row> itr = sheet.iterator(); 
                itr.next();
                while (itr.hasNext())                 
                {  
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column 
                    Plan newPlan = new Plan();
                    String enviroment = null;
                    while (cellIterator.hasNext())   
                    {  
                        Cell cell = cellIterator.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        //String data0= cell.getStringCellValue();
                        Integer columnIndex = cell.getColumnIndex();
                        switch(columnIndex){
                            case 0: //enviroment
                                enviroment = row.getCell(columnIndex).getStringCellValue().toLowerCase();
                                if (!sourceMap.containsKey(enviroment) && enviroment.length() > 0) {
                                    sourceMap.put(enviroment, new ArrayList<>());
                                }
                            break;
                            case 1: //object_id
                                newPlan.setObject_id(row.getCell(columnIndex).getStringCellValue());
                            break;
                            case 2: //name
                                newPlan.setName(row.getCell(columnIndex).getStringCellValue());
                            break;
                             case 3: //ICCID
                                newPlan.setICCID(row.getCell(columnIndex).getStringCellValue());
                            break;
                             case 4: //MSISDN
                                newPlan.setMSISDN(row.getCell(columnIndex).getStringCellValue());
                            break;
                        }
                    }
                    if(newPlan.getName() != null) {
                        sourceMap.get(enviroment).add(newPlan);
                    }
                }
                wb.close();
            }
           return sourceMap;
       } catch (Exception e) {
           throw new Exception(e.getMessage() + ": Error getting New Plan Data Source!");
       }
   }
    //Caso 3.1:Generar resgistro new plan
    public void generateRegisteredNewPlanDatasource(List<Plan> plan) throws Exception{
      try {
            
            File sourceFile = new File(this.testExternalSourceBaseDir + "registers.xlsx");
            if (sourceFile.exists() && plan.size() > 0){
               //obtaining bytes from the file
                FileInputStream fis = new FileInputStream(sourceFile);  
                //creating Workbook instance that refers to .xlsx file  
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                //creating a Sheet object to retrieve object
                // getting the sheet "REAL-PLAN" (index 5)
                XSSFSheet sheet = wb.getSheetAt(5);
                Integer rowIterator = 1;
                while (rowIterator <= plan.size())                 
                {  
                    Integer index = rowIterator - 1;
                    System.out.println("index -> " + index);
                    Row row = sheet.getRow(rowIterator);
                    if (row == null) {
                        row = sheet.createRow(rowIterator);
                    }
                    
                    // Name Plan
                    Cell cell = row.getCell(0);  
                    if (cell == null)  
                        cell = row.createCell(0);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(plan.get(index).getName());
                    
                    // Link SO
                    cell = row.getCell(1);  
                    if (cell == null)  
                        cell = row.createCell(1);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(plan.get(index).getUrlSO());
                    
                    // status SO
                    cell = row.getCell(2);  
                    if (cell == null)  
                        cell = row.createCell(2);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(plan.get(index).getStatuSO());
                    
                    
                    rowIterator++;
                }
            
                try (OutputStream fileOut = new FileOutputStream(sourceFile)) {  
                    wb.write(fileOut);  
                    wb.close();
                }
            }
       } catch (Exception e) {
           throw new Exception(e.getMessage() + ": Error registering RealPlan Data Source!");
       }
    }
    //Caso 4:Cambio de plan
    public HashMap<String, List<Plan>> getChangePlanDatSource() throws Exception {
       try {
            HashMap<String, List<Plan>> sourceMap = new HashMap<String, List<Plan>>();
            File sourceFile = new File(this.testExternalSourceBaseDir + "registers.xlsx");
            if (sourceFile.exists()){
               //obtaining bytes from the file
                FileInputStream fis = new FileInputStream(sourceFile);  
                //creating Workbook instance that refers to .xlsx file  
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                //creating a Sheet object to retrieve object
                // getting the sheet "NEW PLAN" (index 6)
                XSSFSheet sheet = wb.getSheetAt(6);
                //iterating over excel file
                Iterator<Row> itr = sheet.iterator(); 
                itr.next();
                while (itr.hasNext())                 
                {  
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column 
                    Plan newPlan = new Plan();
                    String enviroment = null;
                    while (cellIterator.hasNext())   
                    {  
                        Cell cell = cellIterator.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        //String data0= cell.getStringCellValue();
                        Integer columnIndex = cell.getColumnIndex();
                        switch(columnIndex){
                            case 0: //enviroment
                                enviroment = row.getCell(columnIndex).getStringCellValue().toLowerCase();
                                if (!sourceMap.containsKey(enviroment) && enviroment.length() > 0) {
                                    sourceMap.put(enviroment, new ArrayList<>());
                                }
                            break;
                            case 1: //object_id
                                newPlan.setObject_id(row.getCell(columnIndex).getStringCellValue());
                            break;
                            case 2: //name
                                newPlan.setName(row.getCell(columnIndex).getStringCellValue());
                            break;
                             case 3: //change name
                                newPlan.setName_change_plan(row.getCell(columnIndex).getStringCellValue());
                            break;
                            
                        }
                    }
                    if(newPlan.getName() != null) {
                        sourceMap.get(enviroment).add(newPlan);
                    }
                }
                wb.close();
            }
           return sourceMap;
       } catch (Exception e) {
           throw new Exception(e.getMessage() + ": Error getting Change Plan Data Source!");
       }
   }
    //Caso 4.1:Plan cambiado
    public void generateRegisteredChangedPlanDatasource(List<Plan> plan) throws Exception{
      try {
            
            File sourceFile = new File(this.testExternalSourceBaseDir + "registers.xlsx");
            if (sourceFile.exists() && plan.size() > 0){
               //obtaining bytes from the file
                FileInputStream fis = new FileInputStream(sourceFile);  
                //creating Workbook instance that refers to .xlsx file  
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                //creating a Sheet object to retrieve object
                // getting the sheet "REAL-PLAN" (index 7)
                XSSFSheet sheet = wb.getSheetAt(7);
                Integer rowIterator = 1;
                while (rowIterator <= plan.size())                 
                {  
                    Integer index = rowIterator - 1;
                    System.out.println("index -> " + index);
                    Row row = sheet.getRow(rowIterator);
                    if (row == null) {
                        row = sheet.createRow(rowIterator);
                    }
                    
                    // Name Plan
                    Cell cell = row.getCell(0);  
                    if (cell == null)  
                        cell = row.createCell(0);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(plan.get(index).getName());
                    
                    // Link SO
                    cell = row.getCell(1);  
                    if (cell == null)  
                        cell = row.createCell(1);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(plan.get(index).getUrlSO());
                    
                    // status SO
                    cell = row.getCell(2);  
                    if (cell == null)  
                        cell = row.createCell(2);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(plan.get(index).getStatuSO());
                    
                    
                    rowIterator++;
                }
            
                try (OutputStream fileOut = new FileOutputStream(sourceFile)) {  
                    wb.write(fileOut);  
                    wb.close();
                }
            }
       } catch (Exception e) {
           throw new Exception(e.getMessage() + ": Error registering ChangedPlan Data Source!");
       }
    }
    //Caso 5:Sim Card Lost
    public HashMap<String, List<Plan>> getSimCardLostPlanDatSource() throws Exception {
       try {
            HashMap<String, List<Plan>> sourceMap = new HashMap<String, List<Plan>>();
            File sourceFile = new File(this.testExternalSourceBaseDir + "registers.xlsx");
            if (sourceFile.exists()){
               //obtaining bytes from the file
                FileInputStream fis = new FileInputStream(sourceFile);  
                //creating Workbook instance that refers to .xlsx file  
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                //creating a Sheet object to retrieve object
                // getting the sheet "NEW PLAN" (index 8)
                XSSFSheet sheet = wb.getSheetAt(8);
                //iterating over excel file
                Iterator<Row> itr = sheet.iterator(); 
                itr.next();
                while (itr.hasNext())                 
                {  
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column 
                    Plan newPlan = new Plan();
                    String enviroment = null;
                    while (cellIterator.hasNext())   
                    {  
                        Cell cell = cellIterator.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        //String data0= cell.getStringCellValue();
                        Integer columnIndex = cell.getColumnIndex();
                        switch(columnIndex){
                            case 0: //enviroment
                                enviroment = row.getCell(columnIndex).getStringCellValue().toLowerCase();
                                if (!sourceMap.containsKey(enviroment) && enviroment.length() > 0) {
                                    sourceMap.put(enviroment, new ArrayList<>());
                                }
                            break;
                            case 1: //object_id
                                newPlan.setObject_id(row.getCell(columnIndex).getStringCellValue());
                            break;
                            case 2: //name
                                newPlan.setName(row.getCell(columnIndex).getStringCellValue());
                            break;
                        }
                    }
                    if(newPlan.getName() != null) {
                        sourceMap.get(enviroment).add(newPlan);
                    }
                }
                wb.close();
            }
           return sourceMap;
       } catch (Exception e) {
           throw new Exception(e.getMessage() + ": Error getting Sim Card lost Data Source!");
       }
   }
   //Caso 5.1:Generar registro sim card lost
     public void generateRegisteredSimCardLostDatasource(List<Plan> plan) throws Exception{
      try {
            
            File sourceFile = new File(this.testExternalSourceBaseDir + "registers.xlsx");
            if (sourceFile.exists() && plan.size() > 0){
               //obtaining bytes from the file
                FileInputStream fis = new FileInputStream(sourceFile);  
                //creating Workbook instance that refers to .xlsx file  
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                //creating a Sheet object to retrieve object
                // getting the sheet "REAL-PLAN" (index 9)
                XSSFSheet sheet = wb.getSheetAt(9);
                Integer rowIterator = 1;
                while (rowIterator <= plan.size())                 
                {  
                    Integer index = rowIterator - 1;
                    System.out.println("index -> " + index);
                    Row row = sheet.getRow(rowIterator);
                    if (row == null) {
                        row = sheet.createRow(rowIterator);
                    }
                    
                    // Name Plan
                    Cell cell = row.getCell(0);  
                    if (cell == null)  
                        cell = row.createCell(0);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(plan.get(index).getName());
                    
                    // Link SO
                    cell = row.getCell(1);  
                    if (cell == null)  
                        cell = row.createCell(1);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(plan.get(index).getUrlSO());
                    
                    // status SO
                    cell = row.getCell(2);  
                    if (cell == null)  
                        cell = row.createCell(2);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(plan.get(index).getStatuSO());
                    
                    
                    rowIterator++;
                }
            
                try (OutputStream fileOut = new FileOutputStream(sourceFile)) {  
                    wb.write(fileOut);  
                    wb.close();
                }
            }
       } catch (Exception e) {
           throw new Exception(e.getMessage() + ": Error registering Recharge Data Source!");
       }
    }
     //Caso 6:Recharge line
    public HashMap<String, List<Client>> getRechargeLine() throws Exception {
       try {
            HashMap<String, List<Client>> sourceMap = new HashMap<String, List<Client>>();
            File sourceFile = new File(this.testExternalSourceBaseDir + "registers.xlsx");
            if (sourceFile.exists()){
               //obtaining bytes from the file
                FileInputStream fis = new FileInputStream(sourceFile);  
                //creating Workbook instance that refers to .xlsx file  
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                //creating a Sheet object to retrieve object
                // getting the sheet "NEW PLAN" (index 10)
                XSSFSheet sheet = wb.getSheetAt(10);
                //iterating over excel file
                Iterator<Row> itr = sheet.iterator(); 
                itr.next();
                while (itr.hasNext())                 
                {  
                    Row row = itr.next();
                    Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column 
                    Client newClient = new Client();
                    String enviroment = null;
                    while (cellIterator.hasNext())   
                    {  
                        Cell cell = cellIterator.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        //String data0= cell.getStringCellValue();
                        Integer columnIndex = cell.getColumnIndex();
                        switch(columnIndex){
                            case 0: //enviroment
                                enviroment = row.getCell(columnIndex).getStringCellValue().toLowerCase();
                                if (!sourceMap.containsKey(enviroment) && enviroment.length() > 0) {
                                    sourceMap.put(enviroment, new ArrayList<>());
                                }
                            break;
                             case 1: //object id
                                newClient.setObject_id(row.getCell(columnIndex).getStringCellValue());
                            break;
                            case 2: //line
                                newClient.setLine(row.getCell(columnIndex).getStringCellValue());
                            break;
                        }
                    }
                    if(newClient.getLine() != null) {
                        sourceMap.get(enviroment).add(newClient);
                    }
                }
                wb.close();
            }
           return sourceMap;
       } catch (Exception e) {
           throw new Exception(e.getMessage() + ": Error getting Sim Card lost Data Source!");
       }
   }
    
    //Caso 6.1:Generar registro recarga
     public void generateRegisteredRechargeDatasource(List<Client> client) throws Exception{
      try {
            
            File sourceFile = new File(this.testExternalSourceBaseDir + "registers.xlsx");
            if (sourceFile.exists() && client.size() > 0){
               //obtaining bytes from the file
                FileInputStream fis = new FileInputStream(sourceFile);  
                //creating Workbook instance that refers to .xlsx file  
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                //creating a Sheet object to retrieve object
                // getting the sheet "REAL-PLAN" (index 11)
                XSSFSheet sheet = wb.getSheetAt(11);
                Integer rowIterator = 1;
                while (rowIterator <= client.size())                 
                {  
                    Integer index = rowIterator - 1;
                    System.out.println("index -> " + index);
                    Row row = sheet.getRow(rowIterator);
                    if (row == null) {
                        row = sheet.createRow(rowIterator);
                    }
                    
                    // Link recarga
                    Cell cell = row.getCell(0);  
                    if (cell == null)  
                        cell = row.createCell(0);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(client.get(index).getLink_recharge());
                    
                    // Total recarga
                    cell = row.getCell(1);  
                    if (cell == null)  
                        cell = row.createCell(1);  
                    cell.setCellType(CellType.STRING);  
                    cell.setCellValue(client.get(index).getTotal_recharge());
                 
                    rowIterator++;
                }
            
                try (OutputStream fileOut = new FileOutputStream(sourceFile)) {  
                    wb.write(fileOut);  
                    wb.close();
                }
            }
       } catch (Exception e) {
           throw new Exception(e.getMessage() + ": Error registering Recharge Data Source!");
       }
    }
}

    
