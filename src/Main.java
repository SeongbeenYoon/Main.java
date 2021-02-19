import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws IOException {

        //MemberList 생성자 선언부
        MemberList memberList = new MemberList();


        ArrayList<String> temp;
        FileInputStream fis=new FileInputStream("example.xlsx");
        XSSFWorkbook workbook= new XSSFWorkbook(fis);;
        int rowindex=0;
        int columnindex=0;
        XSSFSheet sheet=workbook.getSheetAt(0);
        int rows=sheet.getPhysicalNumberOfRows();
        for(rowindex=1;rowindex<rows;rowindex++){
            XSSFRow row=sheet.getRow(rowindex);
            if(row !=null){
                int cells=row.getPhysicalNumberOfCells();
                temp=new ArrayList<>();
                for(columnindex=1;columnindex<=cells;columnindex++) {
                    XSSFCell cell = row.getCell(columnindex);
                    String value = "";
                    if (cell == null) {
                        value="내용 없음";
                    } else {
                        //타입별로 내용 읽기
                        switch (cell.getCellType()) {
                            case FORMULA:
                                value = cell.getCellFormula();
                                break;
                            case NUMERIC:
                                value = cell.getNumericCellValue() + "";
                                break;
                            case STRING:
                                value = cell.getStringCellValue() + "";
                                break;
                            case BLANK:
                                value = cell.getBooleanCellValue() + "";
                                break;
                            case ERROR:
                                value = cell.getErrorCellValue() + "";
                                break;
                        }
                    }
                    System.out.println("좌표 : ("+rowindex+","+columnindex+")");
                    System.out.println("각 셀 내용 :" + value);
                    temp.add(value);
                }
                System.out.println(temp.size());
                memberList.addMember(new Member(temp));
            }
        }
        for(int i=0;i<memberList.size();i++){
            String message = memberList.get(i).getAll_info();
            File file = new File("MEMBER_"+i+".txt");
            FileWriter writer = null;
                try {
                    // 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
                    writer = new FileWriter(file, false);
                    writer.write(message);
                    writer.flush();

                    System.out.println("DONE");
                } catch(IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if(writer != null) writer.close();
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                }
        }

    }
}