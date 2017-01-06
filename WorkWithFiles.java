/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sapfksu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class WorkWithFiles {

    private final String fileName = "SavesTest.json";

    public void WriteInFile(JSONArray jsonarr) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);

            for (int i = 0; i < jsonarr.size(); i++) {
                String forWrite = jsonarr.get(i).toString();
                bw.write(forWrite);
                bw.newLine();
            }
            System.out.println("Done");
        } catch (IOException e) {
            e.getMessage();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
    }
    public JSONArray ReadFromFile() {
        JSONArray array = new JSONArray();
        BufferedReader br = null;
        FileReader fr = null;

        try {
            String line;
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                JSONObject currentLineObj = (JSONObject) new JSONParser().parse(line);
                array.add(currentLineObj);
            }

        } catch (FileNotFoundException e) {
            System.out.println("There is no saved events yet!");
        } catch (IOException e) {
            System.out.println("Cant read from file!");
        } catch (ParseException ex) {
        } catch (Exception ex) {
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        return array;
    }
}
