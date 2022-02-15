package ds.practice.second.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ds.practice.second.dto.MemberDTO;

@Controller
public class ExcelController {
	
	@RequestMapping(value="exceldown.do")
	public String excelForm() {
		return "excel";
	}
	
	
	@RequestMapping(value="exceldown.do", method=RequestMethod.POST)
	public void exceldownload(HttpServletResponse response) throws IOException {
		String sheetName = "당첨자";
		List<MemberDTO> memberDTO = null;
		int totalRow = memberDTO.size();
		
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet(sheetName);
		Row row = null;
		Cell cell = null;
		int rowNum = 0;
		
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue("당첨자ID");
		cell = row.createCell(1);
		cell.setCellValue("이름");
		cell = row.createCell(2);
		cell.setCellValue("전화번호");
		
		for(int i = 0; i < totalRow ;  i++) {
			row = sheet.createRow(rowNum++);
			cell = row.createCell(0);
			cell.setCellValue(memberDTO.get(i).getMemberId());
			cell = row.createCell(1);
			cell.setCellValue(memberDTO.get(i).getMemberName());
			cell = row.createCell(2);
			cell.setCellValue(memberDTO.get(i).getMemberPhone());
		}
		
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename=example.xlsx");
		
		wb.write(response.getOutputStream());
		wb.close();
		
	}
}
