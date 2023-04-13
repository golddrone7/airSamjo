package jiwon.airlineStatus;

import jiwon.enumset.Continent;
import jiwon.enumset.Theme;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static jiwon.airlineStatus.AirlineInfo.city;
import static jiwon.enumset.Continent.*;
import static jiwon.enumset.Theme.*;
import static yougeun.Utility.*;

public class AirlineRepository {
  static List<String> airportList;
  static String from;

  static City c = new City();

  // 출발지
  static {
    airportList = new ArrayList<>(
        Arrays.asList("서울 / 인천", "서울 / 김포", "제주", "광주", "여수", "청주", "대구", "부산 / 김해")
    );
  }

  // 출발지 공항 목록
  public static void airportList() {
    int i = 1;
    for (String airport : airportList) {
      System.out.println("  " + i + ". " + airport);
      i++;
    }
  }

  // 출발지 선택
  static String startingPoint(String inputFrom) {
    // 숫자 선택
    int n = Integer.parseInt(inputFrom);
    from = airportList.get(n);
    return from;
  }


//도착지 선택
  public void choiceCity(Object o) {
    choice(o);
    pickCity(input("여행을 떠나고 싶은 나라를 선택해주세요"));
  }

  // 테마, 나라별 여행지 선택
  private void choice(Object o) {
    city.stream()
        .filter(t -> t.getChoice(o) == o)
        .collect(toList())
        .forEach(t -> {
          System.out.println("    " + from + " <-> " + t.getCountryName());
          System.out.println("    왕복");
          System.out.println("    KRW " + t.getFee() * 2);
          makeLine();
        });
  }
   public Theme themeChangeNum(String inputTheme) {
    switch (inputTheme) {
      case "1":
        return SEASON;
      case "2":
        return DISCOUNT;
      case "3":
        return UNUSUAL;
    }
    return NORMAL;
  }
  //나라별 여행지 ( 모든도시 보여주기)
  public  Continent pickContinent(String s) {
    Map<String, Continent> cMap = new HashMap<>();
    cMap.put("1", DOMESTIC);
    cMap.put("2", CHINA);
    cMap.put("3", JAPAN);
    cMap.put("4", SOUTHEAST_ASIA);
    cMap.put("5", AMERICA);
    cMap.put("6", EUROPE);
    cMap.put("7", OCEANIA);

    return cMap.get(s);
  }
   private void pickCity(String input) {
    List<City> pickCity = city.stream()
        .filter(c -> c.getCountryName().equals(input))
        .collect(toList());
    System.out.println(pickCity);
  }

}

