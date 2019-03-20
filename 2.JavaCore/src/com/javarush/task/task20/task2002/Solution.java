package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("12.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here
            // инициализируйте поле users для объекта javaRush тут
            for (int i = 0; i < 5; i++) {
                javaRush.users.add(new User());
                javaRush.users.get(i).setBirthDate((new SimpleDateFormat("dd MM yyyy")).parse("01 0" + i + " 1234"));
                javaRush.users.get(i).setCountry(User.Country.UKRAINE);
                javaRush.users.get(i).setFirstName("First Name" + i * 17);
                javaRush.users.get(i).setLastName("Last Last" + i * 23);
                if (i % 2 == 0) {
                    javaRush.users.get(i).setMale(false);
                } else {
                    javaRush.users.get(i).setMale(true);
                }
            }

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object
            // проверьте тут, что javaRush и loadedObject равны
            System.out.println(" Check equals: " + loadedObject.equals(javaRush));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (users == null) {
                return;
            }
            for (User u : users) {
                outputStream.write((u.getFirstName() + "\n").getBytes());
                outputStream.write((u.getLastName() + "\n").getBytes());
                outputStream.write((u.getCountry().getDisplayName() + "\n").getBytes());
                outputStream.write((u.getBirthDate().toString() + "\n").getBytes());
                outputStream.write((String.valueOf(u.isMale()) + "\n").getBytes());
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            ArrayList<String> list = new ArrayList<>();

            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                list.add(line);
            }
            reader.close();

            if (list.size() < 5) {
                return;
            }
            int count = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                users.add(new User());
                users.get(count).setFirstName(list.get(i++));
                users.get(count).setLastName(list.get(i++));
                String country = list.get(i++);
                if (country.equals("Russia")) {
                    users.get(count).setCountry(User.Country.RUSSIA);
                } else if (country.equals("Ukraine")) {
                    users.get(count).setCountry(User.Country.UKRAINE);
                } else {
                    users.get(count).setCountry(User.Country.OTHER);
                }
                users.get(count).setBirthDate(new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(list.get(i++)));
                if (list.get(i).equals("true")) {
                    users.get(count).setMale(true);
                } else {
                    users.get(count).setMale(false);
                }
                count++;
            }


        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
