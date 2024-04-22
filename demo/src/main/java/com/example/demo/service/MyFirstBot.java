package com.example.demo.service;


import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class MyFirstBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "gerasymchuk_bot";
    }

    @Override
    public String getBotToken() {
        return "6689855493:AAGSpc4zdibzGLdOJWYQeT4aWfpRA53WRT4";
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        Message message = update.getMessage();
        sendMessage.setText("Для виклику екстренних служб надішліть відповідний номер: \n" +
        "101 - служба порятунку; \n" + "102 - поліція; \n" + "103 - швидка медична допомога" );
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        if(message.getText().equals("101")){
            sendMessage.setText("Переадресація дзвінка до служби порятунку");
            sendMessage.setChatId(String.valueOf(message.getChatId()));
        }else if (message.getText().equals("102")){
            sendMessage.setText("Переадресація дзвінка до поліції");
            sendMessage.setChatId(String.valueOf(message.getChatId()));
        }else if (message.getText().equals("103")) {
            sendMessage.setText("Відбувається переадресація дзвінка на швидку медичну допомогу");
                    sendMessage.setChatId(String.valueOf(message.getChatId()));
        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
