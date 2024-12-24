package cominformation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

/**
 * {@code Information310} 클래스는 강의실 06-310에 있는 컴퓨터의
 * 프로그램 정보를 관리하는 클래스입니다.
 * <p>
 * 이 클래스는 지정된 파일에서 데이터를 읽어와 컴퓨터 이름과
 * 관련된 프로그램 정보를 {@link LinkedHashMap}에 저장합니다.
 * 파일의 각 줄은 "컴퓨터 이름: 프로그램 정보" 형식으로 작성되어 있어야 하며,
 * 잘못된 형식의 데이터는 무시됩니다.
 * </p>
 *
 * <h2>기능</h2>
 * <ul>
 *   <li>파일에서 데이터를 읽어와 해시맵에 저장</li>
 *   <li>외부에서 컴퓨터 정보를 조회할 수 있는 기능 제공</li>
 * </ul>
 *
 * @author KIM SIN UI
 * @version 1.0
 * @since 2024-12-23
 *
 * @changelog
 * <ul>
 *   <li>2024-12-05: 패키지 및 기본 클래스 생성 (KIM SIN UI)</li>
 *   <li>2024-12-05: 파일 읽기 로직 추가 (KIM SIN UI)</li>
 *   <li>2024-12-05: 파일에서 각 라인을 ":" 기준으로 분리하여 LinkedHashMap에 저장(KIM SIN UI)</li>
 *   <li>2024-12-05: 예외 처리 추가(KIM SIN UI)</li>
 *   <li>2024-12-05: 외부에서 정보를 조회 가능하도록 기능 추가 (KIM SIN UI)</li>
 *   <li>2024-12-17: 데이터 파일 포함 및 경로 수정 (KIM SIN UI)</li>
 *   <li>2024-12-24: 자바독 추가 (KIM SIN UI)</li>
 * </ul>
 */
public class Information310 {

    /**
     * 데이터 파일 경로입니다.
     * 기본적으로 "resources/data/ComputerProgram310.txt"를 가리킵니다.
     */
    private String input = "resources/data/ComputerProgram310.txt";

    /**
     * 컴퓨터 이름과 프로그램 정보를 저장하는 {@link LinkedHashMap}입니다.
     */
    private LinkedHashMap<String, String> computerMap310;

    /**
     * {@code Information310} 클래스의 생성자입니다.
     * <p>
     * 생성자는 지정된 경로에서 컴퓨터 정보를 로드하여 {@code computerMap310}에 저장합니다.
     * </p>
     */
    public Information310() {
        this.computerMap310 = new LinkedHashMap<>();
        loadInformation();
    }

    /**
     * 컴퓨터 정보를 파일에서 로드하는 메서드입니다.
     * <p>
     * 파일의 각 줄을 읽어와 ":" 구분자로 컴퓨터 이름과 프로그램 정보를 분리하여
     * {@link LinkedHashMap}에 저장합니다. 파일이 존재하지 않거나
     * 읽기에 실패한 경우 {@link IOException} 예외가 발생하며
     * 스택 트레이스를 출력합니다.
     * </p>
     */
    private void loadInformation() {
        try (FileInputStream fis = new FileInputStream(input);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":"); // ":"로 분리
                if (parts.length == 2) {
                    String cName = parts[0].trim(); // 컴퓨터 이름
                    String data = parts[1].trim(); // 프로그램 정보
                    computerMap310.put(cName, data); // 해시맵에 저장
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 강의실 06-310의 컴퓨터 정보를 반환하는 메서드입니다.
     * <p>
     * 컴퓨터 이름과 프로그램 정보를 {@link LinkedHashMap} 형태로 반환합니다.
     * </p>
     *
     * @return 컴퓨터 이름과 프로그램 정보를 포함하는 {@link LinkedHashMap}
     */
    public LinkedHashMap<String, String> getComputerMap310() {
        return computerMap310;
    }
}