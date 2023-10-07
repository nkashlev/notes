package ru.nkashlev.notes.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

@Controller
public class ResourceController {

    @GetMapping("static/css/style.css")
    @ResponseBody
    public ResponseEntity<String> styles() throws IOException {
        // получаем содержимое файла из папки ресурсов в виде потока
        InputStream is = getClass().getClassLoader().getResourceAsStream("static/css/style.css");
        // преобразуем поток в строку
        BufferedReader bf = new BufferedReader(new InputStreamReader(Objects.requireNonNull(is)));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while((line = bf.readLine()) != null){
            sb.append(line).append("\n");
        }

        // создаем объект, в котором будем хранить HTTP заголовки
        final HttpHeaders httpHeaders= new HttpHeaders();
        // добавляем заголовок, который хранит тип содержимого
        httpHeaders.add("Content-Type", "text/css; charset=utf-8");
        // возвращаем HTTP ответ, в который передаем тело ответа, заголовки и статус 200 Ok
        return new ResponseEntity<String>( sb.toString(), httpHeaders, HttpStatus.OK);
    }
}
