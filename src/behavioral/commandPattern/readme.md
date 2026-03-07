## Command Pattern


**Command Pattern** គឺជា Behavioral Design Pattern មួយដែលបំប្លែងសំណើ (Request) ឬប្រតិបត្តិការណាមួយ ទៅជា Object 
មួយដាច់ដោយឡែក ដែលមានផ្ទុកព័ត៌មានទាំងអស់អំពីសំណើនោះ។

ការបំប្លែងបែបនេះអនុញ្ញាតឱ្យអ្នកអាច៖
* បញ្ជូនសំណើជា Arguments ទៅកាន់ Methods ផ្សេងៗ 
* រក្សាទុកសំណើក្នុងបញ្ជី (Queue) ឬកំណត់ពេលដំណើរការ (Schedule)
* គាំទ្រមុខងារត្រឡប់ក្រោយ (Undo/Redo operations)

ដើម្បីងាយស្រួលយល់ អ្នកអាចស្រមៃដល់ តេឡេបញ្ជា (Remote Control)។ តេឡេមិនចាំបាច់ដឹងថាតើទូរទស្សន៍ ឬអំពូលភ្លើងដំណើរការយ៉ាងម៉េចនោះទេ វាគ្រាន់តែដឹងថាប៊ូតុងនីមួយៗភ្ជាប់ទៅនឹង "បញ្ជា (Command)" ជាក់លាក់ណាមួយប៉ុណ្ណោះ។

សមាសធាតុសំខាន់ៗនៃ Command Pattern
1. Command (Interface): ជាទូទៅមានតែ Method មួយប៉ុណ្ណោះ គឺ execute() សម្រាប់ដំណើរការបញ្ជា។ 
2. Concrete Command: ជា Class ដែល Implement ពី Command Interface។ វាដើរតួជាអ្នកភ្ជាប់រវាង Receiver និងសកម្មភាព។ 
3. Receiver: ជា Class ដែលផ្ទុកនូវ Business Logic ពិតប្រាកដ (អ្នកធ្វើការងារជាក់ស្តែង ឧ. អំពូលភ្លើង)។ 
4. Invoker: ជា Class ដែលទទួលខុសត្រូវក្នុងការហៅ Command ឲ្យដំណើរការ (ឧ. តេឡេបញ្ជា)។ 
5. Client: ជាអ្នកបង្កើត Object ផ្សេងៗ (Command, Receiver, Invoker) និងភ្ជាប់វាចូលគ្នា។

ឧទាហរណ៍កូដ Java: តេឡេបញ្ជាអំពូលភ្លើង (Smart Home)

ខាងក្រោមនេះជាឧទាហរណ៍នៃការប្រើប្រាស់ Command Pattern ដើម្បីបើក និងបិទអំពូលភ្លើង៖

```java
// ១. Command Interface
public interface Command {
    void execute();
}

// ២. Receiver (អ្នកអនុវត្តការងារពិតប្រាកដ)
public class Light {
    public void turnOn() {
        System.out.println("អំពូលភ្លើងត្រូវបាន បើក! 💡");
    }

    public void turnOff() {
        System.out.println("អំពូលភ្លើងត្រូវបាន បិទ! 🌑");
    }
}

// ៣. Concrete Commands (បញ្ជាជាក់លាក់)
// បញ្ជាសម្រាប់បើកភ្លើង
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn(); // ហៅ Receiver ឲ្យធ្វើការ
    }
}

// បញ្ជាសម្រាប់បិទភ្លើង
public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// ៤. Invoker (អ្នកហៅបញ្ជា - ឧ. តេឡេ)
public class RemoteControl {
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
        remote.pressButton(); // លទ្ធផល: អំពូលភ្លើងត្រូវបាន បើក! 💡

        // កំណត់បញ្ជាឱ្យបិទភ្លើង រួចចុចប៊ូតុង
        remote.setCommand(turnOffLight);
        remote.pressButton(); // លទ្ធផល: អំពូលភ្លើងត្រូវបាន បិទ! 🌑
    }
}
```