package org.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.models.Student;
import org.example.models.University;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class JsonUtils {

    private JsonUtils() {
        System.out.println("Private constructor.");
        System.out.println("Forbidden to create this class instance.");
    }

    public static String studentToJson (Student student) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(student);
        return jsonString;

    }

    public static Student studentFromJson (String studentJsonString) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Student studentRestoredJson = gson.fromJson(studentJsonString, Student.class);
        return studentRestoredJson;

    }

    public static String studentListToJson (List<Student> studentDataStorage){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(studentDataStorage);
        return jsonString;

    }

    public static List<Student> studentListFromJson (String studentListJsonString){

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        List<Student> studentListRestoredFromJson = gson.fromJson(studentListJsonString, List<Student>(){}.getType());
//        List<Student> participantJsonList = mapper.readValue(studentListJsonString, new TypeReference<List<Student>>(){});
//        Type collectionType = new TypeToken >(){}.getType();
//        List gBooks = gson.fromJson(studentListJsonString, collectionType);
//
//        return studentListRestoredFromJson;
//
//        String list = "your_json_string";
//        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Student>>() {}.getType();
        ArrayList<Student> studentListRestoredFromJson = new Gson().fromJson(studentListJsonString , listType);
        return studentListRestoredFromJson;

    }

    public static String universityToJson (University university) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(university);
        return jsonString;

    }

    public static University universityFromJson (String universityJsonString) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        University universityRestoredJson = gson.fromJson(universityJsonString, University.class);
//        return universityRestoredJson;
        return gson.fromJson(universityJsonString, University.class);

    }

    public static String universityListToJson(List<University> universityDataStorage) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(universityDataStorage);
        return jsonString;

    }

    public static List<University> universityListFromJson(String universityListJsonString) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type listType = new TypeToken<ArrayList<University>>() {}.getType();
        ArrayList<University> universityListRestoredFromJson = new Gson().fromJson(universityListJsonString , listType);
        return universityListRestoredFromJson;

    }
}
