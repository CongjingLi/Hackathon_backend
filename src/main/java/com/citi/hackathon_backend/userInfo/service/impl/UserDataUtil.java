package com.citi.hackathon_backend.userInfo.service.impl;

import com.citi.hackathon_backend.userInfo.entity.UserInfo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class UserDataUtil {

    // 从本地文件中导入用户表
    public static List<UserInfo> excelToUsers(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<UserInfo> users = new ArrayList<UserInfo>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // 跳过表头
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                UserInfo user = new UserInfo();
                String s1 = null;
                int cellIdx = 0;

                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    currentCell.setCellType(CellType.STRING);
                    switch (cellIdx) {

                        case 0:
                            s1 = currentCell.getStringCellValue();
                            user.setId(s1);
                            break;
                        case 1:
                            s1 = currentCell.getStringCellValue();
                            user.setPassword(s1);
                            break;
                        case 2:
                            s1 = currentCell.getStringCellValue();
                            user.setUserName(s1);
                            break;
                        case 3:
                            s1 = currentCell.getStringCellValue();
                            user.setNickName(s1);
                            break;
                        case 4:
                            s1 = currentCell.getStringCellValue();
                            user.setAddress(s1);
                            break;
                        case 5:
                            s1 = currentCell.getStringCellValue();
                            user.setEmail(s1);
                            break;
                        case 6:
                            s1 = currentCell.getStringCellValue();
                            user.setOrganizationType(s1);
                            break;
                        case 7:
                            s1 = currentCell.getStringCellValue();
                            user.setAuthority(s1);
                            break;
                        default:
                            break;
                    }

                    cellIdx++;
                }

                System.out.println("读取到的User:" + user.toString());

                // 用户名不能重复
                for (int i = 0; i < users.size(); i++) {
                    // 判断当前得用户名与列表中的用户名是否重复
                    if (Objects.equals(user.getId(), users.get(i).getId())) {
                        return null;
                    }
                }

                users.add(user);
            }
            workbook.close();

            return users;
        } catch (IOException e) {
            throw new RuntimeException("Excel文件解析异常： " + e.getMessage());
        }
    }
}

