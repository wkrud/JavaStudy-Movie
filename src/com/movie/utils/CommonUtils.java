package com.movie.utils;

import java.lang.reflect.Field;
import java.util.*;

public class CommonUtils {

    /**
     * 메소드 설명 : List<?> -> List<Map>
     * @param list
     * @return resultList
     * @throws Exception
     */
    public List<Map<String, Object>> getListMapByListObj(List<?> list) throws Exception {
        List<Map<String, Object>> resultList = null;

        try {
            if (list == null || list.isEmpty()) {
                return Collections.emptyList();
            }

            resultList = new ArrayList<>();

            for (Object obj : list) {
                resultList.add(getMapByObj(obj));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception(e);
        }

        return resultList;
    }

    /**
     * 메소드 설명 : obj -> map
     * @param obj
     * @return map
     * @throws Exception
     */
    public Map<String, Object> getMapByObj(Object obj) throws Exception {
        Map<String, Object> map = null;
        try {
            if (obj == null) {
                return Collections.emptyMap();
            }
            map = new HashMap<>();
            Field[] fields = obj.getClass().getDeclaredFields();

            for (Field  field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (IllegalAccessException e) {
            System.out.println(e.toString());
            throw new Exception(e);
        }
        return map;
    }

    /**
     * 메소드 설명 : 알파벳(소문자, 대문자), 숫자 랜덤 조합
     * @param length
     * @return randomStr
     * @throws Exception
     */
    public String getRandomStr(int length) throws Exception {
        String randomStr = "";

        try {
            int leftLimit = 48;
            int rightLImit = 122;
            Random random = new Random();
            randomStr = random.ints(leftLimit, rightLImit + 1)
                              .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                              .limit(length)
                              .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                              .toString();

//            for (int i = 0; i < length; i++) {
//                if (random.nextBoolean()) {
//                    randomStr += String.valueOf((char) ((int) random.nextInt(26) + 97));
//                } else {
//                    randomStr += String.valueOf(random.nextInt(10));
//                }
//            }
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception(e);
        }

        return randomStr;
    }

}
