/*
 * HashMap
 *
 * Description: This source file is a part of
 * Tic-Tac-Toe Game.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/03/16
 *
 * Updated: 2018/03/17
 */
package ua.training;

import java.util.HashMap;

public class KeyValue {

	HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

    /**
     * Sets HashMap.
     * Every grid coordinate gets a corresponding index.
     */
	public void setHashMap() {
        hashMap.put("1A", Integer.valueOf(0));
        hashMap.put("1B", Integer.valueOf(1));
        hashMap.put("1C", Integer.valueOf(2));
        hashMap.put("2A", Integer.valueOf(3));
        hashMap.put("2B", Integer.valueOf(4));
        hashMap.put("2C", Integer.valueOf(5));
        hashMap.put("3A", Integer.valueOf(6));
        hashMap.put("3B", Integer.valueOf(7));
        hashMap.put("3C", Integer.valueOf(8));
    }

    public HashMap<String, Integer> getHashMap() {
        return hashMap;
    }

    public boolean isValidCoordinate(String key) {
    	return (hashMap.containsKey(key));
    }

    public int getIndexOfCoordinate(String key) {
    	return hashMap.get(key);
    }
}
