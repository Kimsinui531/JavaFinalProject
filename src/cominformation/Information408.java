package cominformation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Information408 {
    private String input = "C:\\Users\\ksy05\\Desktop\\2-2 수업\\자바스터디\\ComputerProgram408.txt"; // 기본 경로
    private LinkedHashMap<String, String> computerMap408;

    public Information408() {
        this.computerMap408 = new LinkedHashMap<>();
        loadInformation(); // 데이터 로드
    }

    private void loadInformation() {
        try (FileInputStream fis = new FileInputStream(input);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // 읽은 라인 출력
            }
        } catch (IOException e) {
            e.printStackTrace(); // 예외 처리
        }
    }
}
