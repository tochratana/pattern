package behavioral.commandPattern;

// 1. Command Interface
interface Command {
    void execute();
}

// 2. Receiver (អ្នកអនុវត្ត command ពិតប្រាកដ)
class Light {
    public void turnOn(){
        System.out.println("អំពូលភ្លើងត្រូវបានបើក!");
    }

    public void turnOf(){
        System.out.println("អំពូលភ្លើងត្រូវបានបិទ!");
    }
}

// 3. Concrete Commands (បញ្ជាជាក់លាក់)
// បញ្ជាសម្រាប់បើកភ្លើង
class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn(); // ហៅ Receiver ឲ្យធ្វើការ
    }
}


// បញ្ជាសម្រាប់បិទភ្លើង
class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOf(); // ហៅ Receiver ឲ្យធ្វើការ
    }
}
// 4. Invoker (អ្នកហៅបញ្ជា - ឧ. តេឡេ)
class RemoteControl{
    private Command command;

    // កំណត់ថាតើប៊ូតុងនេះនឹងធ្វើអ្វី
    public void setCommand(Command command) {
        this.command = command;
    }

    // ចុចប៊ូតុងដើម្បីដំណើរការ
    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("មិនទាន់បានកំណត់បញ្ជាទេ!");
        }
    }
}



// ៥. Client (កន្លែងសាកល្បងកូដ)
public class Main {
    public static void main(String[] args) {
        // បង្កើត Receiver (អំពូលភ្លើង)
        Light livingRoomLight = new Light();

        // បង្កើត Commands សម្រាប់បញ្ជាអំពូលភ្លើងនោះ
        Command turnOnLight = new LightOnCommand(livingRoomLight);
        Command turnOffLight = new LightOffCommand(livingRoomLight);

        // បង្កើត Invoker (តេឡេ)
        RemoteControl remote = new RemoteControl();

        // កំណត់បញ្ជាឱ្យបើកភ្លើង រួចចុចប៊ូតុង
        remote.setCommand(turnOnLight);
        remote.pressButton(); // លទ្ធផល: អំពូលភ្លើងត្រូវបាន បើក!

        // កំណត់បញ្ជាឱ្យបិទភ្លើង រួចចុចប៊ូតុង
        remote.setCommand(turnOffLight);
        remote.pressButton(); // លទ្ធផល: អំពូលភ្លើងត្រូវបាន បិទ!
    }
}