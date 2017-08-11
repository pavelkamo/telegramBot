import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class QAkerBot extends TelegramLongPollingBot {

    private final String BOT_NAME = "QAkerBot";
    private final String TOKEN = "TOKEN";

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(new QAkerBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()){
            if (message.getText().equals("/help")){
                sendMsg(message, "Hello, I'm Bot");
            } else if (message.getText().equals("/kot")){
                sendMsg(message, "Hello, I'm Bot");
            } else if (message.getText().equals("/sol")){
                sendMsg(message, "Cолошенко, срочно поцемай Каминского!))))))");
            } else if (message.getText().equals("/gps")){
                sendMsg(message, "GPS activated! iPhone(5s) IMEI: E346DT45424JB3001 ");
            } else if (message.getText().equals("/message")){
                sendMsg(message, "Messaging activated! iPhone(5s) IMEI: E346DT45424JB3001 ");
            } else if (message.getText().equals("/kot_kozel?")){
                sendMsg(message, "Нет конечно!!! Он же лапочка и самый хороший в мире)))) Его надо срочно поцемать");
            } else {
                sendMsg(message, "Your iPhone(5s) IMEI: E346DT45424JB3001 is trecking!");
            }
        }
    }

    private void sendMsg(Message message, String s){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);
        try{
            sendMessage(sendMessage);
        }
        catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return BOT_NAME;
    }

    public String getBotToken() {
        return TOKEN;
    }
}
