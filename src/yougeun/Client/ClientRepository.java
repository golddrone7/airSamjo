package yougeun.Client;

import jiwon.enumset.Way;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class ClientRepository {
    static private ArrayList<Client> clientArrayList;

    static {
        clientArrayList = new ArrayList<>(
                Arrays.asList(new Client("감사", Gender.MALE, "019-1111-1111", "gamsa@naver.com", "청주", "gamsa", "gamsa", new Card("1000", 1500000), 500000),
                        new Client("admin", Gender.FEMALE, "019-2222-2222", "admin@naver.com", "수원", "admin", "admin", true),
                        new Client("하나", Gender.FEMALE, "019-3333-3333", "one@naver.com", "서울", "one", "one", new Card("2000", 2200000), 700000),
                        new Client("둘", Gender.MALE, "019-4444-4444", "two@naver.com", "대구", "two", "two", new Card("3000", 3600000), 300000),
                        new Client("셋", Gender.FEMALE, "019-5555-5555", "three@naver.com", "대전", "three", "three"),
                        new Client("test", Gender.MALE, "010-6666-6666", "test@naver.com", "서울", "testtest", "testtest", new Card("1", 1000000000 ), new Ticket("서울", "뉴욕", LocalDate.of(2023, 5, 30), LocalDate.of(2023, 6, 20), Way.ROUND_TRIP, 2), 500000000),
                        new Client("test2", Gender.MALE, "010-6666-6666", "test@naver.com", "서울", "testtest2", "testtest2", new Card("1", 1000000000 ), new Ticket("서울", "뉴욕", LocalDate.of(2023, 5, 30), LocalDate.of(2023, 6, 20), Way.ROUND_TRIP, 2), 500000000)
                )

        );
    }

    public static ArrayList<Client> getClientArrayList() {
        return clientArrayList;
    }

    /** 아이디를 입력하면 해당하는 클라이언트 반환하는 함수
     * @param id
     * @return 해당 클라이언트
     */
    public static Client findClient(String id){
        for (Client client : clientArrayList) {
            if(id.equals(client.getId()))
                return client;
        }
        return null;
    }

    /** 클라이언트 객체를 받으면 정보를 알려주는 메서드
     * 이름, 번호, 이메일 출력
     * @param client
     */
    public static void showClient(Client client){
        System.out.println("==============유저 정보 조회=============");
        System.out.println("이름 : " + client.getUserName());
        System.out.println("번호 : " + client.getUserPhone());
        System.out.println("이메일 : " + client.getEmail());
    }


    public ClientRepository() {
    }

//    public static void main(String[] args) {
//        for (Client client : clientArrayList) {
//            System.out.println(client);
//        }
//    }


}
