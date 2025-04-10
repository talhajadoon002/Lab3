import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 class Publisher {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public Publisher(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, File file) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
}

class Editor {
    public Publisher events;
    private File file;

    public Editor() {
        this.events = new Publisher("open", "save");
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}
interface EventListener {
    void update(String eventType, File file);
}
class EmailNotificationListener implements EventListener {
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Email to " + email + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}
 class LogOpenListener implements EventListener {
    private File log;

    public LogOpenListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save to log " + log + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}
class smssupportlistener implements EventListener {
    private String phoneNumber;
    private String sms;

    public smssupportlistener(String phoneNumber,String sms) {
        this.phoneNumber=phoneNumber;
        this.sms=sms;
    }

    public void update(String eventType, File file) {
        if (sms.length() > 160) {
            System.out.println("Warning: SMS is too long! Please define a valid default SMS.");
        } else {
            System.out.println("Sending SMS to " + phoneNumber + ": " + sms);
        }
    }
}
public class sentsmstophonenumber {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("smsSupport.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("khan@example.com"));
        editor.events.subscribe("save", new smssupportlistener("+92345678962","your file has been saved successfully"));

        try {
            editor.openFile("sms.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}