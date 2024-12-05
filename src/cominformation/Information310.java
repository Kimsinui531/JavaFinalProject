package cominformation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Information310 {
    private String input = "C:\\Users\\ksy05\\Desktop\\2-2 수업\\자바스터디\\ComputerProgram310.txt"; // 기본 경로
    private LinkedHashMap<String, String> computerMap310;

    public Information310() {
        this.computerMap310 = new LinkedHashMap<>();
        loadInformation(); // 데이터 로드
    }

    private void loadInformation() {
        try (FileInputStream fis = new FileInputStream(input);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":"); // 구분자(:)로 분리
                if (parts.length == 2) { // 잘 분리된 경우
                    String cName = parts[0].trim(); // "cName" 저장
                    String data = parts[1].trim(); // "data" 저장
                    computerMap310.put(cName, data); // LinkedHashMap에 저장
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // 예외 처리
        }
    }

    public LinkedHashMap<String, String> getComputerMap310() {
        return computerMap310;
    }
}




